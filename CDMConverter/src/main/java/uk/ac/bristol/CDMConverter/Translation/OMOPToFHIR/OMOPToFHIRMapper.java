package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.FHIRResource;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("470fd500-5429-4754-983a-484040fcbf72")
public final class OMOPToFHIRMapper {
    @objid ("dda92a3a-28f5-4938-a15f-d85637e90ee0")
    public static Collection<FHIRResource> doMapping(EncodedComposite personComposite, List<String> resourceList) throws ApplicationException {
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
