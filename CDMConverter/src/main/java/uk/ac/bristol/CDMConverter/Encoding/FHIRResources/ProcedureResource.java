package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Procedure;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("c882a1ea-8f2f-4dce-9249-77180a2b4f03")
public class ProcedureResource extends FHIRResource {
	private List<String> identifiers = new ArrayList<String>();
	private CodeableConcept code = null;

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
	}
		
	@Override
	public IBaseResource generateFHIRMessage(EncodedComposite personComposite) {
		// TODO Auto-generated method stub
        Procedure procedure = new Procedure();
        
        Iterator<String> identifierItr = this.identifiers.iterator();
        while (identifierItr.hasNext()) {
            procedure.addIdentifier(new Identifier().setValue(identifierItr.next()));            
        }
        if (this.code != null) {
        	procedure.setCode(this.code);
        }
        return procedure;
	}
}
