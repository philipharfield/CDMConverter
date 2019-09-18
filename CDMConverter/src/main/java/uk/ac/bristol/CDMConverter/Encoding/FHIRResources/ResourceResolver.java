package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;

@objid ("21f14872-a63e-4ea5-8030-18884de5ced9")
public final class ResourceResolver {
    @objid ("976329e8-ba47-4ce8-93b9-b78a31db99c7")
    public static List<String> resolveResource(JSONObject targetResource) throws JSONConfigException {
        List<String> resources = null;
        String encoding;
        
        if (targetResource.containsKey("encoding")) {
            encoding = (String) targetResource.get("encoding");
        } else {
            throw new JSONConfigException("No encoding tag for target resource in JSON.");            
        }
        if (encoding.length() == 0) {
            throw new JSONConfigException("Empty encoding tag for target resource in JSON.");
        }
        switch (encoding) {
            case "FHIR":
                resources = resolveFHIRResource(targetResource);        // Pointer so underlying objects are populated without return
                break;
            default:
                throw new JSONConfigException("Unrecognised target resource encoding.");
        }
        return resources;
    }

    @objid ("001d60c9-eb2c-4eaf-9d7c-467891d769c1")
    private static List<String> resolveFHIRResource(JSONObject targetResource) throws JSONConfigException {
        List<String> resources = new ArrayList<String>();
        
        JSONArray resourcesArray;
        if (targetResource.containsKey("resource")) {
            resourcesArray = (JSONArray) targetResource.get("resource");
        } else {
            throw new JSONConfigException("No resource tag in FHIR target resource in JSON.");
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
