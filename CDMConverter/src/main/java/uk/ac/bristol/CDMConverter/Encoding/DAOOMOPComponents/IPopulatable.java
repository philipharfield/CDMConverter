package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.SQLException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPComponent;

/**
 * DAO classes with this interface allow searching sub components.  E.g. person can also search their visits, procedures etc...
 */
@objid ("cbd36c41-1e67-45a5-966d-da8a50a29d8a")
public interface IPopulatable {
    /**
     * For a partially populated class, return a composite that includes this class fully populated and all sub-classes populated as part of the composite pattern.
     */
    @objid ("1a0579f1-c9ee-4ea3-b0ce-af2b21530918")
    EncodedComposite populateComponents(OMOPComponent OMOPComponent) throws SQLException;

}
