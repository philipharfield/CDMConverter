package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.SQLException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("aec37fcb-36e8-41dd-ae06-5660bb0ec845")
public interface ISearchableByPK<T> {
    @objid ("74c1cdbd-5207-4a1d-ae5f-23689486441a")
    T getByPK(int pk) throws SQLException;

}
