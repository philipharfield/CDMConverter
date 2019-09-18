package uk.ac.bristol.CDMConverter.Encoding;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7e21ecf2-8bde-43ec-8eba-53bc622160dd")
public interface IEncodedComponent {
// Use to identify object in hash key
    @objid ("7a24a9e4-d78d-4b37-93fb-cc8365c0e328")
    String getHashKey();

    @objid ("5c80a6da-121f-497e-9c09-cff0c0f2e713")
    void setRedundancy();

    @objid ("a6b192cd-efd3-4d52-9d67-174e2f82e596")
    int getPrimaryKey();

}
