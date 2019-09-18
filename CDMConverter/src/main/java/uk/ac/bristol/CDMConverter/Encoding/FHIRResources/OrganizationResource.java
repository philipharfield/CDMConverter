package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("159a3f00-4698-4793-b292-bcf0375aa6be")
public class OrganizationResource extends FHIRResource {
    @objid ("ea6cf123-df97-48ef-848c-9c674ffbea23")
    private String name;

    @objid ("90bf0f9b-f6c6-4d9e-845d-06a010178daf")
    public String getName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.name;
    }

    @objid ("807e5c16-5745-4f9d-8038-dbf9c310dcf8")
    public void setName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.name = value;
    }

    @objid ("ba7c5ce9-cacd-4dd0-b0c8-83a494872783")
    @Override
    public IBaseResource generateFHIRMessage(EncodedComposite personComposite) {
        Organization organization = new Organization();
        Iterator<String> identifierItr = this.identifiers.iterator();
        while (identifierItr.hasNext()) {
            organization.addIdentifier(new Identifier().setValue(identifierItr.next()));            
        }
        if (this.name.length() > 0) {
            organization.setName(this.name);
        }
        return organization;
    }
}
