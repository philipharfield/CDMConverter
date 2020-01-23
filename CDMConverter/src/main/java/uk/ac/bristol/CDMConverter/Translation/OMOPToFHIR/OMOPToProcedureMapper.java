package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import java.util.Collection;
import java.util.Iterator;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.FHIRResource;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.ProcedureResource;
import uk.ac.bristol.CDMConverter.Encoding.IEncodedComponent;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPProcedureOccurrence;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("3cb9e6b1-a6bd-4e4c-a546-0e17d44ea0b2")
public class OMOPToProcedureMapper implements IOMOPToFHIRMapper {
    @objid ("ade66d38-0f4f-49ad-bb41-3a621f89e736")
    public void doMapping(Collection<FHIRResource> currentBundle, EncodedComposite personComposite) throws ApplicationException {
        Collection<IEncodedComponent> collection = personComposite.getComponentByType(OMOPProcedureOccurrence.class);
        IEncodedComponent nextComponent;
        OMOPProcedureOccurrence omopProcedure;
        
        Iterator<IEncodedComponent> procItr = collection.iterator();
        while (procItr.hasNext()) {
            nextComponent = procItr.next();
            if (nextComponent instanceof OMOPProcedureOccurrence) {
                omopProcedure = (OMOPProcedureOccurrence) nextComponent;
            } else {
                throw new ApplicationException("Found an object that isn't an OMOPProcedureOccurrence");
            }
            
            if (!omopProcedure.isRedundant()) {
                ProcedureResource fhirProcedure = new ProcedureResource();
                fhirProcedure.addIdentifier(omopProcedure.getHashKey());
                Coding procedureCode = new Coding("http://snomed.info/sct", 
                                                    String.valueOf(omopProcedure.getProcedureConceptId()),
                                                    omopProcedure.getProcedureName());
                fhirProcedure.setCode(new CodeableConcept(procedureCode));
                currentBundle.add(fhirProcedure);
            }
        }
    }

}
