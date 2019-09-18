package uk.ac.bristol.CDMConverter.Encoding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("129570b1-7b9d-41cf-b4b4-a5ad689e3c1b")
public class DatabaseSource {
    @objid ("a8ea7744-c666-4195-b818-a269766221ef")
    private String uname;

    @objid ("571f073e-bdc4-4a08-ab24-64e969248e86")
    private String pword;

    @objid ("d8dac245-71bf-4c81-89a3-a320898a9bd9")
    private String server;

    @objid ("77baa65a-19eb-4073-a653-165ecc6da2db")
    private String database;

    @objid ("6f1c7d63-5c65-46a4-a2a2-7fe964aba27e")
    private Connection conn;

    @objid ("2986a6df-d72e-4584-bc58-7fa843c93f1f")
    public DatabaseSource(String dbServer, String dbName, String dbUID, String dbPassword, boolean integratedSecurity) throws ApplicationException {
        String connectionUrl;
        
        uname = dbUID;
        pword = dbPassword;
        server = dbServer;
        database = dbName;
        
        if (integratedSecurity) {
            connectionUrl = "jdbc:sqlserver://" + dbServer + ";databaseName=" + dbName + ";integratedSecurity=true;";
        } else {
            connectionUrl = "";
        }
        
        try  {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new ApplicationException("Failed to create database connection with passed JSON params.", e);
        }
    }

    @objid ("eb10a071-1775-4390-9673-2a07a9d136f8")
    public Connection getConn() {
        return conn;
    }

    @objid ("145feb3e-5613-48b5-b3fe-027f63e77d3a")
    public void close() throws ApplicationException {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new ApplicationException("Failed to close database connection.", e);
        }
    }

}
