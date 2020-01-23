package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("aecdbfe8-d1b6-4f89-86d3-43f4e996e744")
public interface ISearchableByConcept<T> {
    /**
     * <Enter note text here>
     */
    @objid ("fe9ebb90-5690-47b5-9a93-686138cb082c")
    Collection<T> getByConcept(int conceptId);

}
