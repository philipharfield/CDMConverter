package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Procedure;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("c882a1ea-8f2f-4dce-9249-77180a2b4f03")
public class ProcedureResource extends FHIRResource {
    @objid ("dceedb85-3725-48a0-b522-e7aa8dfaf214")
    private List<String> identifiers = new ArrayList<String>();

    @objid ("1a37d943-0b2c-4051-b7ad-e8f5a264a0b4")
    private CodeableConcept code = null;

    @objid ("05a63f63-a9a7-4d38-ba5b-a57c5edadd55")
    public CodeableConcept getCode() {
        return code;
    }

    @objid ("2b1178ed-e47c-4cb8-9dda-b9206b0554b7")
    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    @objid ("5e69ae37-d543-48aa-b197-497da348d7fc")
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
