package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.instance.model.api.IBaseResource;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("8b62d446-50d1-40a1-a239-4badf9035c28")
public abstract class FHIRResource {
    @objid ("4246eb3a-a749-4610-86ba-5bc341fd1f96")
    protected List<String> identifiers = new ArrayList<String>();

    @objid ("86440b03-b0d1-421e-9f7f-23a047953403")
    public abstract IBaseResource generateFHIRMessage(EncodedComposite personComposite);

    @objid ("3bf2e2ee-e79f-4a59-b1a9-01005d20009e")
    public final void addIdentifier(String identifier) {
        identifiers.add(identifier);
    }

    @objid ("8e033196-4150-4a74-a723-3ad8ccafd4ac")
    public final String getPrimaryIdentifier() {
        return (identifiers.size() > 0) ? identifiers.get(0):"";
    }

}
