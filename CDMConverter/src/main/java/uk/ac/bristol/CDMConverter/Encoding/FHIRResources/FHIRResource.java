package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.instance.model.api.IBaseResource;

import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("8b62d446-50d1-40a1-a239-4badf9035c28")
public abstract class FHIRResource {
    protected List<String> identifiers = new ArrayList<String>();
    
    @objid ("86440b03-b0d1-421e-9f7f-23a047953403")
    public abstract IBaseResource generateFHIRMessage(EncodedComposite personComposite);

    @objid ("3bf2e2ee-e79f-4a59-b1a9-01005d20009e")
    final public void addIdentifier(String identifier) {
        identifiers.add(identifier);
    }
    
    final public String getPrimaryIdentifier() {  	 
    	return (identifiers.size() > 0) ? identifiers.get(0):"";
    }
}