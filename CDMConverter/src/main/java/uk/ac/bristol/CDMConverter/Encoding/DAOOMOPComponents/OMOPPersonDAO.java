package uk.ac.bristol.CDMConverter.Encoding.DAOOMOPComponents;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPCareSite;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPComponent;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPObservationPeriod;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPPerson;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPProcedureOccurrence;

@objid ("6184f2f6-66c9-4f6e-ae29-8b1a919c5f8e")
public class OMOPPersonDAO extends OMOPDAO implements IPopulatable {
    @objid ("ae1270db-942a-4ed2-94d9-d5201cc6fd8e")
    public OMOPPersonDAO(Connection conn) {
        super(conn);
    }

    @objid ("27aa197c-ded9-40b7-bb88-db3c56601295")
    public EncodedComposite populateComponents(OMOPComponent OMOPComponent) throws SQLException {
        OMOPPerson person = (OMOPPerson) OMOPComponent;
        
        EncodedComposite level1Composite = new EncodedComposite();
        //Get complete person (including care site and observation period)        
        String query = "SELECT P.YEAR_OF_BIRTH, P.GENDER_CONCEPT_ID," +
        				" P.MONTH_OF_BIRTH, P.DAY_OF_BIRTH, P.BIRTH_DATETIME," +
                        " CS.CARE_SITE_NAME, CS.CARE_SITE_ID," +
                        " OP.OBSERVATION_PERIOD_ID, OP.OBSERVATION_PERIOD_START_DATE, OP.OBSERVATION_PERIOD_END_DATE" +
                        " FROM PERSON P" + 
                        " LEFT JOIN CARE_SITE CS ON P.CARE_SITE_ID = CS.CARE_SITE_ID" +
                        " LEFT JOIN OBSERVATION_PERIOD OP ON P.PERSON_ID = OP.PERSON_ID" +
                        " WHERE P.PERSON_ID = " + person.getPrimaryKey();
        
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            if (rs.getDate("BIRTH_DATETIME") != null) {
            	person.setBirthDatetime(rs.getDate("BIRTH_DATETIME").toLocalDate());
            }
        	person.setYearOfBirth(rs.getInt("YEAR_OF_BIRTH"));
            person.setMonthOfBirth(rs.getInt("MONTH_OF_BIRTH"));
            person.setDayOfBirth(rs.getInt("DAY_OF_BIRTH"));
            person.setGenderConceptId(rs.getInt("GENDER_CONCEPT_ID"));
            
            if (rs.getInt("CARE_SITE_ID") != 0) {
                level1Composite.addChild(new OMOPCareSite(rs.getInt("CARE_SITE_ID"),
                                                        rs.getString("CARE_SITE_NAME")));
            }
            
            if (rs.getInt("OBSERVATION_PERIOD_ID") != 0) {
                level1Composite.addChild(new OMOPObservationPeriod(rs.getInt("OBSERVATION_PERIOD_ID"),
                                                                rs.getDate("OBSERVATION_PERIOD_START_DATE"),
                                                                rs.getDate("OBSERVATION_PERIOD_END_DATE")));
            }
            
            level1Composite.addChild(person);
        }
        
        //Get Procedures        
        OMOPProcedureOccurrenceDAO procedureDAO = new OMOPProcedureOccurrenceDAO(conn);
        Iterator<OMOPProcedureOccurrence> itrPO = procedureDAO.getByPerson(person.getPrimaryKey()).iterator();
        while (itrPO.hasNext()) {
        	level1Composite.addChild(itrPO.next());
        }
        
        //Get Visits
        
        
        
        //Get Drug exposures
        //level1Composite.addChild(proceduresComposite);
        return level1Composite;
    }

}
