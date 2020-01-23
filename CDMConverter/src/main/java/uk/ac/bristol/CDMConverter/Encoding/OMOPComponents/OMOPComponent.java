package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.IEncodedComponent;

@objid ("2b5010e1-fd0d-4256-b507-5d234157313b")
public abstract class OMOPComponent implements IEncodedComponent {
    @objid ("4366c6e9-92e0-416f-bc22-d5243cba4a98")
    protected int primaryKey;

    /**
     * <Enter note text here>
     */
    @objid ("71ea25b8-1588-4bfd-867d-893d121cea93")
    protected boolean redundant;

    @objid ("47efd334-f07a-480a-9eb6-78d950e60ecb")
    public OMOPComponent(int pk) {
        redundant = false;
        primaryKey = pk;
    }

    @objid ("0ef59436-6a01-4b6a-8620-fade85c0fec0")
    public void setRedundancy() {
        this.redundant = true;
    }

    @objid ("41e46192-5bca-46e6-84a9-ea8f6cf1e37c")
    public int getPrimaryKey() {
        return primaryKey;
    }

    @objid ("8c673b57-82ad-4c6f-908a-cf2ef99c2aae")
    public boolean isRedundant() {
        return this.redundant;
    }

// Use to identify object in hash key
    @objid ("46e9c4e8-0ca0-4f64-81a4-7af9020ed7dd")
    public String getHashKey() {
        return this.getClass().getSimpleName() + "_" + this.primaryKey;
    }

}
