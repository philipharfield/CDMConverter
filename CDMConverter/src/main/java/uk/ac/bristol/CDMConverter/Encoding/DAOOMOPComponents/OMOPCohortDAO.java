package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.Connection;
import java.sql.SQLException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPCohort;

@objid ("7fb3210e-501f-451f-8e42-e46a14658e4e")
public class OMOPCohortDAO extends OMOPDAO implements ISearchableByPK<OMOPCohort> {
    @objid ("5db1952f-139f-4aa9-9b0b-6905c669e836")
    public OMOPCohortDAO(Connection conn) {
        super(conn);
    }

    @objid ("11cb5d7d-19ab-4b4d-807f-930934383349")
    public OMOPCohort getByPK(int pk) throws SQLException {
        OMOPCohort cohort = new OMOPCohort(pk);
        String query = "SELECT SUBJECT_ID FROM COHORT " + 
                        "WHERE COHORT_DEFINITION_ID = " + pk;
        
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            cohort.addPerson(rs.getInt("SUBJECT_ID"));
        }
        return cohort;
    }

}
