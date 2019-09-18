package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import uk.ac.bristol.CDMConverter.Encoding.IEncodingInstance;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;

@objid ("21f14872-a63e-4ea5-8030-18884de5ced9")
public final class ResourceResolver {
    @objid ("976329e8-ba47-4ce8-93b9-b78a31db99c7")
    public static List<String> resolveResource(JSONObject targetResource) throws JSONConfigException {
        List<String> resources = new ArrayList<String>();
        JSONObject config;

        if (targetResource.containsKey("config")) {
            config = (JSONObject) targetResource.get("config");
        } else {
            throw new JSONConfigException("config field missing in JSON.");
        }
        
        JSONArray resourcesArray;
        if (config.containsKey("resources")) {
            resourcesArray = (JSONArray) config.get("resources");
        } else {
            throw new JSONConfigException("No resources tag in FHIR target resource in JSON.");
        }
        
        for (Object o : resourcesArray) {
            switch (o.toString()) {
            case "Patient":
            case "Organization": 
            case "Procedure": {
                resources.add(o.toString());
                break;
            }
            default:
                throw new JSONConfigException("Unrecognised FHIR resource requested: " + o.toString());
            }
        }
        return resources;
    }
}
