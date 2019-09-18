package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.SQLException;
import java.util.Collection;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("03cc7fcd-4d2d-465c-839a-63792feaabb9")
public interface ISearchableByAll<T> {
    @objid ("f0184db6-b31f-4014-89aa-4df4faccca29")
    Collection<T> getAll() throws SQLException;

}
