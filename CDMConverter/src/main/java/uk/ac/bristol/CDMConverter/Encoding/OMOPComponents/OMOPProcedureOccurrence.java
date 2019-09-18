package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("9285b7ec-b8c4-49d1-9a3c-aa2b43747a02")
public class OMOPProcedureOccurrence extends OMOPComponent {
    @objid ("a4a2b191-c24b-4103-8d9c-2c6140ad3bd6")
    public int procedureConceptId;

    @objid ("fc802714-30d9-4c69-bd47-60d66293ffe1")
    public int procedureSourceConceptId;

    @objid ("95314ab9-56cf-471f-924e-f5718e2931a0")
    public String procedureName;

    @objid ("91acd316-1fca-4b91-a11e-07f495f7c56e")
    public String procedureType;

    @objid ("8b136601-769a-4948-85aa-8cdbaeaab3b7")
    public OMOPProcedureOccurrence(int pk) {
        super(pk);
    }

    @objid ("dd57b780-dbf6-4b1e-a54d-488c34ec06d6")
    public int getProcedureConceptId() {
        return procedureConceptId;
    }

    @objid ("30ef1288-70d9-43ff-abd4-335f7e3801be")
    public void setProcedureConceptId(int procedureConceptId) {
        this.procedureConceptId = procedureConceptId;
    }

    @objid ("666a024d-e018-40ce-85da-5d6fdbd4c4cf")
    public int getProcedureSourceConceptId() {
        return procedureSourceConceptId;
    }

    @objid ("bde0ff35-42e4-426f-8062-1a1cdf60012f")
    public void setProcedureSourceConceptId(int procedureSourceConceptId) {
        this.procedureSourceConceptId = procedureSourceConceptId;
    }

    @objid ("f9e869c3-db6b-48b0-818c-32e1e39d600b")
    public String getProcedureName() {
        return procedureName;
    }

    @objid ("83142fa6-1858-45af-90ee-62612349c0f4")
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    @objid ("1831d908-4ce1-4a6c-ba66-2a0309e8a9b1")
    public String getProcedureType() {
        return procedureType;
    }

    @objid ("6cbafb4f-7eb2-4d99-a9de-476a75e9572b")
    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String toString() {
    	return "ProcedureOccurrenceId : " + this.procedureConceptId + 
    			" ProcedureConceptId : " + this.procedureConceptId + 
    			" ProcedureName : " + this.procedureName;
    }
}
