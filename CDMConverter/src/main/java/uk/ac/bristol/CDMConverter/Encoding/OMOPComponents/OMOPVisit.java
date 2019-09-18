package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import java.util.Date;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b03b6b26-30c7-4a82-8075-b5bf623c6d61")
public class OMOPVisit extends OMOPComponent {
    @objid ("67f4a2e8-32e9-448d-973f-27c0bdd95ee7")
    private Date startDate;

    @objid ("3dfd355b-5e5e-44f7-bde7-94538babf0d9")
    private Date endDate;

    @objid ("21f12ffb-1e4f-4539-9a38-9720a85dbe3d")
    private String visitType;

    @objid ("6fd3fa35-7ec8-49e2-8614-d798ef5ed0f5")
    public OMOPVisit(int pk) {
        super(pk);
    }

}
