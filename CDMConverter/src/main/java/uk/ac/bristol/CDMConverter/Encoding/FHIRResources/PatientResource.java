package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("bce0ab4d-f5d5-493c-a28f-5659f73c5bb8")
public class PatientResource extends FHIRResource {
    @objid ("fcef0665-94a8-4287-9359-2ca493accb86")
    private boolean active;

    @objid ("e3ab57d2-3564-4ab1-b7df-9acd59347e28")
    private String humanName;

    @objid ("5f976d44-efbc-4ee1-a715-8acc536a7915")
    private LocalDate birthDate;

    @objid ("4241f50d-1929-4a7c-9bca-d068bb02c547")
    private Reference generalPractitioner;

    @objid ("21701bd7-e1cb-4de6-ae9d-8990ea70d1c1")
    private AdministrativeGender gender;

    @objid ("ed1690fc-0958-4e40-aec6-53b01a7017c3")
    public boolean isActive() {
        return active;
    }

    @objid ("9d1bc4cc-b889-4c3a-8f0d-567132a69927")
    public void setActive(boolean active) {
        this.active = active;
    }

    @objid ("19ff8b63-126b-44f4-bff5-cca90a56c811")
    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    @objid ("9db4209d-62d5-4eb0-a58f-4e043a596b8a")
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @objid ("08035389-d490-485e-9a28-03ee9c8e0cf9")
    public String toString() {
        return "Name : " + humanName + " Identifier : " + identifiers.get(0);
    }
    
    @objid ("803a7964-2586-4698-aaa4-96712debbc2c")
    public void setGender(AdministrativeGender gender) {
        this.gender = gender;
    }

    @objid ("71671e0b-d741-48ce-94de-610e2724d662")
    public void setGeneralPractitioner(Reference generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    @objid ("e3c88b76-41c8-4858-878b-e90d95f842a4")
    @Override
    public IBaseResource generateFHIRMessage(EncodedComposite personComposite) {
        Patient patient = new Patient();
        Iterator<String> identifierItr = this.identifiers.iterator();
        while (identifierItr.hasNext()) {
            patient.addIdentifier(new Identifier().setValue(identifierItr.next()));            
        }
        if (this.gender != AdministrativeGender.NULL) { 
            patient.setGender(this.gender);
        }
        if (this.generalPractitioner != null) {
            patient.addGeneralPractitioner(generalPractitioner);
        }
        if (this.birthDate != null) {
        	patient.setBirthDate(Date.valueOf(birthDate));
        }
        return patient;
    }

}
