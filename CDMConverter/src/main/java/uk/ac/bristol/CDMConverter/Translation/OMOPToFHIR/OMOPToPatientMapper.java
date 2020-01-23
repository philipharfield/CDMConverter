package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import java.time.Year;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.r4.model.Reference;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.FHIRResource;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.PatientResource;
import uk.ac.bristol.CDMConverter.Encoding.IEncodedComponent;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPCareSite;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPPerson;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

/**
 * Knows how to map a OMOP Person level composite into patient FHIR messages.
 */
@objid ("50f3c239-b25d-4965-940e-1ab5759fa369")
public class OMOPToPatientMapper implements IOMOPToFHIRMapper {
    @objid ("0e8ed4c4-a79c-484d-bc4f-f76e7b4991ab")
    public void doMapping(Collection<FHIRResource> currentBundle, EncodedComposite personComposite) throws ApplicationException {
        // Get the person object from the person composite - there should only be one
        IEncodedComponent component = personComposite.getSingleComponent(OMOPPerson.class);
        OMOPPerson person = null;
        if (component instanceof OMOPPerson) {
            person = (OMOPPerson) component;
        } else {
            throw new ApplicationException("Unable to find a person component in this particular person composite");
        }
        
        component = personComposite.getSingleComponent(OMOPCareSite.class);
        OMOPCareSite caresite = null;
        // It is not an error if no care site is found
        if (component instanceof OMOPCareSite) {
            caresite = (OMOPCareSite) component;
        }
        
        // There should be a 1:1 mapping person to patient, so create single patient resource
        if (person != null && !person.isRedundant()) { 
            PatientResource patient = new PatientResource();
            patient.addIdentifier(person.getHashKey());
            // OMOP person allows month = 0 or day = 0.  SQL.Date does not, so we need to check and default to Jan 01 as necessary.
            int month = (person.getMonthOfBirth() == 0) ? 1:person.getMonthOfBirth();
            int day = (person.getDayOfBirth() == 0) ? 1:person.getDayOfBirth();
            patient.setBirthDate(Year.of(person.getYearOfBirth()).atMonth(month).atDay(day));
            patient.setGender(OMOPToFHIRUtility.genderMapper(person.getGenderConceptId()));
            if (caresite != null) {
                patient.setGeneralPractitioner(new Reference(caresite.getHashKey()));
            }
            currentBundle.add(patient);
        }
    }

}
