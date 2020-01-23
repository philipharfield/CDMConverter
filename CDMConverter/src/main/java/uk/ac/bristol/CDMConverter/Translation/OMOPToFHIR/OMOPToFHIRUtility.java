package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;

@objid ("d91abd07-5568-4dee-9625-6abc35577743")
public final class OMOPToFHIRUtility {
    /**
     * Maps between OMOP representation of gender (SNOMED) to FHIR representation.
     */
    @objid ("875295d1-9589-4fa5-ad1f-fd0509abf12f")
    public static AdministrativeGender genderMapper(int snomedId) {
        AdministrativeGender retGender;
        
        switch(snomedId) {
        case 8507:
            retGender = AdministrativeGender.MALE;
            break;
        case 8532:
            retGender = AdministrativeGender.FEMALE;
            break;
        default:
            retGender = AdministrativeGender.NULL;    
        }
        return retGender;
    }

}
