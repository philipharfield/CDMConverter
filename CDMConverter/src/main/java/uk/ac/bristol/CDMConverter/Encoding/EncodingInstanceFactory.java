package uk.ac.bristol.CDMConverter.Encoding;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;

@objid ("ae18c24f-5f60-41e5-9604-f63ba9b15790")
public class EncodingInstanceFactory {
    @objid ("1743b6ac-1613-4c53-aeef-4ca9212d1c90")
     static Logger logger = LogManager.getLogger();

    @objid ("d7637ffa-bffa-4efb-93e4-d05d62af21c0")
    private static IEncodingInstance createOMOPInstance(JSONObject json) throws ApplicationException, JSONConfigException {
        JSONObject config;
        String dbServer = "", dbName = "", dbUID = "", dbPassword = "";
        boolean integratedSecurity = false;
        IEncodingInstance OMOPInstance = null;
        
        if (json.containsKey("config")) {
            config = (JSONObject) json.get("config");
        } else {
            throw new JSONConfigException("config field missing in JSON.");
        }
        
        if (config.containsKey("integratedSecurity")) {
            integratedSecurity = (boolean) config.get("integratedSecurity");
        } else {
            throw new JSONConfigException("integratedSecurity field missing in JSON.");
        }
        
        if (!integratedSecurity) {
            if (config.containsKey("dbUID")) {
                dbUID = (String) config.get("dbUID");
            } else {
                throw new JSONConfigException("dbUID field missing in JSON.");
            }
            if (dbUID.length() == 0) {
                throw new JSONConfigException("UID field empty in JSON.");
            }
        
            if (config.containsKey("dbPassword")) {
                dbPassword = (String) config.get("dbPassword");
            } else {
                throw new JSONConfigException("dbPassword field missing in JSON.");
            }
            if (dbPassword.length() == 0) {
                throw new JSONConfigException("Password field empty in JSON.");
            }
         }
               
        if (config.containsKey("dbServer")) {
            dbServer = (String) config.get("dbServer");
        } else {
            throw new JSONConfigException("dbServer field missing in JSON.");
        }
        if (dbServer.length() == 0) {
            throw new JSONConfigException("dbServer field empty in JSON.");
        }
        
        if (config.containsKey("dbName")) {
            dbName = (String) config.get("dbName");
        } else {
            throw new JSONConfigException("dbName field missing in JSON.");
        }
        if (dbName.length() == 0) {
            throw new JSONConfigException("dbName field empty in JSON.");
        }
                
        OMOPInstance = new OMOPInstance(dbServer, dbName, dbUID, dbPassword, integratedSecurity);
        return OMOPInstance;
    }

    @objid ("0230e5f7-bcf7-4547-b812-d69685f3ac0e")
    private static IEncodingInstance createFHIRInstance(JSONObject json) throws ApplicationException, JSONConfigException {
        JSONObject config = (JSONObject) json.get("config");
        String directory, fhirFormat;
            
        if (config.containsKey("directory")) {
            directory = (String) config.get("directory");
        } else {
            throw new JSONConfigException("directory field missing in JSON.");
        }
        if (directory.length() == 0) {
            throw new JSONConfigException("directory field empty in JSON.");
        }
        
        if (config.containsKey("format")) {
            fhirFormat = (String) config.get("format");
        } else {
            throw new JSONConfigException("format field to specify XML or JSON FHIR messaging missing in JSON.");
        }
        if (fhirFormat.length() == 0) {
            throw new JSONConfigException("format field to specify XML or JSON FHIR messaging empty in JSON.");
        }
        if (!(fhirFormat.contentEquals("XML") || fhirFormat.contentEquals("JSON"))) {
            throw new JSONConfigException("format field in JSON does not specify either JSON or XML.");
        }
        
        IEncodingInstance FHIRInstance = new FHIRInstance(directory, fhirFormat);
        return FHIRInstance;
    }

    @objid ("85140081-9e89-4c6e-b275-97283ee601f1")
    public static IEncodingInstance createEncodingInstance(JSONObject json) throws ApplicationException, JSONConfigException {
        Logger logger = LogManager.getLogger();
        IEncodingInstance encodingInstance = null;
        String encodingType;
        
        if (json.containsKey("encoding")) {
            encodingType = (String) json.get("encoding");
        } else {
            throw new JSONConfigException("encoding field missing in JSON.");
        }
        if (encodingType.length() == 0) {
            throw new JSONConfigException("encoding field empty in JSON.");
        }
        
        switch (encodingType) {
            case "OMOP":
                logger.debug("Creating OMOP instance");
                encodingInstance = createOMOPInstance(json);
                break;
            case "FHIR":
                logger.debug("Creating FHIR instance");
                encodingInstance = createFHIRInstance(json);
                break;
            default:
                throw new JSONConfigException("Failed to parse 'encoding' for new encoding instance: " + encodingType);
        }
        return encodingInstance;
    }

}
