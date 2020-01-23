package uk.ac.bristol.CDMConverter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uk.ac.bristol.CDMConverter.Encoding.EncodingInstanceFactory;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.ResourceResolver;
import uk.ac.bristol.CDMConverter.Encoding.IEncodingInstance;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;
import uk.ac.bristol.CDMConverter.Translation.ITranslatorManager;
import uk.ac.bristol.CDMConverter.Translation.TranslatorManagerFactory;

@objid ("5a63d67f-f5e0-4318-853d-2e5ec70be495")
public final class MainConverter {
    @objid ("ca957ff9-250c-43ca-942c-08386c166fa7")
    private static final Logger logger = LogManager.getLogger();

    @objid ("9b70917d-72cc-4dce-9917-d15d53531d75")
    private static IEncodingInstance sourceEncodingInstance;

    @objid ("8356e85a-6ada-4c0d-8dc0-9ce0a52948e7")
    private static IEncodingInstance targetEncodingInstance;

    @objid ("7f666569-04de-40f5-80cf-566cee64fcfd")
    private static ITranslatorManager translator;

    @objid ("34e0af00-4c3d-44e0-aabe-35b11555653d")
    public static void main(String[] args) {
        String jsonPath, sourceCohort;
        JSONObject config, sourceObj, targetObj, targetResource;
        
        logger.info("Starting...");
        if (args.length != 1) {
            logger.error("1 command line argument required.");
            System.exit(-1);
        }
        jsonPath = args[0].toString();
        
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(jsonPath))
        {
            //Read JSON file
             config = (JSONObject) jsonParser.parse(reader);
            logger.info("Got config file " + jsonPath); 
         
            if (config.containsKey("source")) {
                sourceObj = (JSONObject) config.get("source");
            } else {
                throw new JSONConfigException("Failed to find source tag in JSON.");
            }
            
            try {
                sourceEncodingInstance = EncodingInstanceFactory.createEncodingInstance(sourceObj);
            }
            catch (ApplicationException ae) {
                throw new ApplicationException("Failed to create Source Encoding Instance.", ae);
            } catch (JSONConfigException jce) {
                throw new JSONConfigException("Failed to create Source Encoding Instance.", jce);
            }
            
            if (config.containsKey("sourceCohort")) {
                sourceCohort = (String) config.get("sourceCohort");
            } else {
                throw new JSONConfigException("Failed to find sourceCohort tag in JSON");
            }
            
            if (config.containsKey("target")) {
                targetObj = (JSONObject) config.get("target");
            } else {
                throw new JSONConfigException("Failed to find target tag in JSON.");
            }
        
            try {
                targetEncodingInstance = EncodingInstanceFactory.createEncodingInstance(targetObj);
            }
            catch (ApplicationException ae) {
                throw new ApplicationException("Failed to create Target Encoding Instance.", ae);
            }
            
            if (config.containsKey("targetResource")) {
                targetResource = (JSONObject) config.get("targetResource");
            } else {
                throw new JSONConfigException("Failed to find targetResource tag in JSON.");
            }
            
            List<String> targetResources = ResourceResolver.resolveResource(targetResource);
            if (targetResources == null || targetResources.isEmpty()) {
                throw new JSONConfigException("No resources specified in JSON file.");
            } else {
                logger.info("Resources are: " + targetResources.toString());
            }
            
            translator = TranslatorManagerFactory.getTranslatorManager(sourceEncodingInstance, targetEncodingInstance);
            translator.doTranslate(sourceEncodingInstance, targetEncodingInstance, targetResources, sourceCohort);
            
        } catch (FileNotFoundException e) {
            logger.error("JSON configuration file not found:", e);
        } catch (IOException e) {
            logger.error("Failed to read JSON configuration file:", e);
        } catch (SQLException se) {
            logger.error("Failed to do translation due to SQL error", se);
        } catch (ParseException pe) {
            logger.error("Failed to parse JSON - check formatting",  pe);
        } catch (JSONConfigException e) {
            logger.error("JSON configuration error:", e);
            logger.error("Refer to standard JSON example for correct format");
        } catch (ApplicationException e) {
            logger.error("Full stack trace:", e);
        }
        
        logger.info("End.");
    }

}
