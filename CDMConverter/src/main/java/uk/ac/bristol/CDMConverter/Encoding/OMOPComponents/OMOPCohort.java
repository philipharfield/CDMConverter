package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*At this stage, a cohort is assumed to be a cohort of person ids.
 * 
 */
@objid ("5ce0cf18-ea32-41fd-b8ce-3b56973ca89b")
public class OMOPCohort implements Iterable<OMOPPerson> {
    @objid ("7792fcf7-3469-4f0e-a4df-861c04db26f3")
     Logger logger = LogManager.getLogger();

    @objid ("4c4f5f04-6037-494e-9dfb-162c84a83395")
    protected int primaryKey;

    @objid ("1594640f-828b-4673-8e7b-03d66f8d2399")
    private final List<OMOPPerson> cohortPersons = new ArrayList<OMOPPerson>();

    @objid ("c819f28f-dbe1-4977-983d-56a5d3eb5c18")
    public OMOPCohort(int cohortDefinitionId) {
        this.primaryKey = cohortDefinitionId;
    }

    @objid ("53fa3ee0-48df-4006-8154-4620a52d40d9")
    public void addPerson(int personId) {
        cohortPersons.add(new OMOPPerson(personId));
    }

    @objid ("cb3693a7-4692-4998-83a6-42d7aeba5214")
    @Override
    public Iterator<OMOPPerson> iterator() {
        return cohortPersons.iterator();
    }

    @objid ("ea59a560-ac7d-471c-8f5f-f6966215515a")
    public String toString() {
        List<String> strList = new ArrayList<String>();
        
        Iterator<OMOPPerson> itr = cohortPersons.iterator();
        while (itr.hasNext()) {
            strList.add(itr.next().toString());
        }
        return String.join("\r\n", strList);
    }

    @objid ("6869adae-cda7-44eb-8add-05995a870a5d")
    public int size() {
        return cohortPersons.size();
    }

}
