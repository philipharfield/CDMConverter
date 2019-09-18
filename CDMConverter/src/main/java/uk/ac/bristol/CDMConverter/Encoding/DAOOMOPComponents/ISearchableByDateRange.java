package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.util.Collection;
import java.util.Date;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("60569fda-8034-40e0-a334-0c883aa3d0f0")
public interface ISearchableByDateRange<T> {
    @objid ("13774881-c6ce-4e05-b77d-2d2b7a87dc19")
    Collection<T> getByDateRange(Date dateFrom, Date dateTo);

}
