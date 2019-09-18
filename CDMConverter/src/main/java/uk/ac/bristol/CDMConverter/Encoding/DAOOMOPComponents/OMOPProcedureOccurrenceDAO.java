package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPProcedureOccurrence;

@objid ("24b708db-3157-4907-ba02-2052f3e0f696")
public class OMOPProcedureOccurrenceDAO extends OMOPDAO implements ISearchableByPerson<OMOPProcedureOccurrence> {
    protected OMOPProcedureOccurrenceDAO(Connection conn) {
		super(conn);
	}

	@objid ("c35f177c-cb22-4c79-8876-8c3af7bb794b")
    public Collection<OMOPProcedureOccurrence> getByPerson(int personPK) throws SQLException {
		Collection<OMOPProcedureOccurrence> retCollection = new ArrayList<>();
        //Get complete person (including care site and observation period)        
        String query = "SELECT P.PROCEDURE_OCCURRENCE_ID, P.PROCEDURE_CONCEPT_ID," +
        				" P.PROCEDURE_DATE, P.PROCEDURE_DATETIME," +
        				" P.VISIT_OCCURRENCE_ID, C.CONCEPT_NAME" +
                        " FROM PROCEDURE_OCCURRENCE P" +
        				" JOIN CONCEPT C ON C.CONCEPT_ID = P.PROCEDURE_CONCEPT_ID" +
                        " WHERE P.PERSON_ID = " + personPK;
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
        	OMOPProcedureOccurrence proc = new OMOPProcedureOccurrence(rs.getInt("PROCEDURE_OCCURRENCE_ID"));
        	proc.setProcedureConceptId(rs.getInt("PROCEDURE_CONCEPT_ID"));
        	proc.setProcedureName(rs.getString("CONCEPT_NAME"));
        	retCollection.add(proc);
        }
        
		return retCollection;
    }

}
