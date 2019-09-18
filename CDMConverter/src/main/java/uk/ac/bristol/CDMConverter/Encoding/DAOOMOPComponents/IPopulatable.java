package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.SQLException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPComponent;

@objid ("cbd36c41-1e67-45a5-966d-da8a50a29d8a")
public interface IPopulatable {
    @objid ("1a0579f1-c9ee-4ea3-b0ce-af2b21530918")
    EncodedComposite populateComponents(OMOPComponent OMOPComponent) throws SQLException;

}
