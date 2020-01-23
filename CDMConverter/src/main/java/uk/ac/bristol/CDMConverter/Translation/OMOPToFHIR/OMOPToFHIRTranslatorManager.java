package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hl7.fhir.instance.model.api.IBaseResource;
import uk.ac.bristol.CDMConverter.Encoding.DAOFHIRResources.FHIRDAO;
import uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents.*;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.FHIRInstance;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.FHIRResource;
import uk.ac.bristol.CDMConverter.Encoding.IEncodingInstance;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPCohort;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPPerson;
import uk.ac.bristol.CDMConverter.Encoding.OMOPInstance;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;
import uk.ac.bristol.CDMConverter.Translation.ITranslatorManager;
import uk.ac.bristol.CDMConverter.Translation.RedundancyHashMap;

@objid ("a07d9aa0-8b6c-4eef-a9b7-6e1cd8e5f3f2")
public class OMOPToFHIRTranslatorManager implements ITranslatorManager {
    @objid ("e15af180-5df3-44d5-b61f-8e04fe1c2d6b")
     final Logger logger = LogManager.getLogger();

    @objid ("b1b1ff04-198b-4775-b478-b7c2c6c3d4d4")
     final RedundancyHashMap redundancyHash = new RedundancyHashMap();

    @objid ("dedbc7cd-3e89-405c-a25a-12534eb1738d")
    @Override
    public void doTranslate(IEncodingInstance sourceEI, IEncodingInstance targetEI, List<String> targetResources, String sourceCohort) throws ApplicationException, SQLException {
        int iSourceCohort;
        try {
            iSourceCohort = Integer.valueOf(sourceCohort);
        } catch (NumberFormatException nfe) {
            throw new ApplicationException("sourceCohort is not an integer", nfe);
        }
        if (!(sourceEI instanceof OMOPInstance)) {
            throw new ApplicationException("Source encoding is not OMOP");
        }
        if (!(targetEI instanceof FHIRInstance)) {
            throw new ApplicationException("Target encoding is not FHIR");
        }
        
        doTranslate((OMOPInstance)sourceEI, (FHIRInstance)targetEI, targetResources, iSourceCohort);
    }

    @objid ("f4a3db73-63cc-4c02-a627-f8e69eae8ae7")
    private void doTranslate(OMOPInstance sourceEI, FHIRInstance targetEI, List<String> targetResources, int iSourceCohort) throws ApplicationException {
        OMOPCohortDAO cohortDAO = new OMOPCohortDAO(sourceEI.getDbSource().getConn());
        OMOPPersonDAO personDAO = new OMOPPersonDAO(sourceEI.getDbSource().getConn());
        FHIRDAO fhirDAO = new FHIRDAO();
        
        OMOPCohort cohort = null;
        try {
            cohort = cohortDAO.getByPK(iSourceCohort);
        } catch (SQLException sqle) {
            throw new ApplicationException("Failed to load OMOP Cohort with PK " + iSourceCohort, sqle);
        }
        
        if (cohort.size() == 0) {
            throw new ApplicationException("There are no patients found in this cohort.");
        }
        
        Iterator<OMOPPerson> personItr = cohort.iterator();
        
        // Iterate over all persons in the cohort
        while (personItr.hasNext()) {
            // Create a composite containing the full person record, procedures, drugs etc...
            EncodedComposite personComposite = null;
            OMOPPerson person = personItr.next();
            try {
                personComposite = personDAO.populateComponents(person);
            } catch (SQLException sqle) {
                throw new ApplicationException("Failed to load person for person with PK " + person.getPrimaryKey(), sqle);
            }
            
            // For all objects, ensure the hash is up to date and that redundancy is calculated per component
            // Checked for no obvious potential for Exception throwing
            redundancyHash.populate(personComposite);
            
            logger.debug(personComposite.toString());
            
            // Translate person records into FHIR resources
            Collection<FHIRResource> resources = doMapping(personComposite, targetResources);
            
            // For each resource generated, create the relevant FHIR messages
            Iterator<FHIRResource> resourceItr = resources.iterator();
            while (resourceItr.hasNext()) {
                FHIRResource nextResource = resourceItr.next();
                IBaseResource encodedResource = nextResource.generateFHIRMessage(personComposite);
                if (encodedResource == null) {
                    throw new ApplicationException("You have no generateFHIRMessage implementation for resource of type " + nextResource.getClass().getSimpleName());
                }
                fhirDAO.persist(encodedResource, targetEI, nextResource.getPrimaryIdentifier());
                
                logger.debug(targetEI.getParser().encodeResourceToString(encodedResource));
            }
        }
    }

    @objid ("dda92a3a-28f5-4938-a15f-d85637e90ee0")
    private Collection<FHIRResource> doMapping(EncodedComposite personComposite, List<String> resourceList) throws ApplicationException {
        Collection<FHIRResource> resourceBundle = new ArrayList<>();
        
        // Get the FHIR mapper object from the factory based on resources in list
        Iterator<String> itr = resourceList.iterator();
        while (itr.hasNext()) {
            // For each resource type, create the relevant resources
            IOMOPToFHIRMapper mapper = OMOPToFHIRMapperFactory.getMapper(itr.next());
            if (mapper != null) {
                mapper.doMapping(resourceBundle, personComposite);
            }
        }
        return resourceBundle;
    }

}
