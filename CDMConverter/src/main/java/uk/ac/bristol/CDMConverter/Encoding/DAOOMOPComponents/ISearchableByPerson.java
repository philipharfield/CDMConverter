package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.SQLException;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a37bf1b5-a16e-4730-94e4-11c90a559fef")
public interface ISearchableByPerson<T> {
    @objid ("d66e0648-c1e2-4e75-a9a3-2288490baa2f")
    Collection<T> getByPerson(int personId) throws SQLException;

}
