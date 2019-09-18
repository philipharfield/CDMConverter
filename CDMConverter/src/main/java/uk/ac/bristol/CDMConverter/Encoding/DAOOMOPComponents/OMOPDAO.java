package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("59f16d02-6a16-43a9-9c60-bb2b5b07ffa9")
public abstract class OMOPDAO {
    @objid ("c1ec7109-3edf-4390-8840-e140098225c4")
    protected ResultSet rs;

    @objid ("dcc513ce-488b-441d-9931-46e78015bc14")
    protected Statement st;

    @objid ("8f54e963-5aa2-463d-9c69-ccda176ca436")
    protected Connection conn;

    @objid ("a8745dd6-d074-40b4-a1e6-78323f15d698")
    protected OMOPDAO(Connection conn) {
        this.conn = conn;
    }

}
