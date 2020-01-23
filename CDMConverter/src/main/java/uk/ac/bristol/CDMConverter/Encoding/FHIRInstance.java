package uk.ac.bristol.CDMConverter.Encoding;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;
import uk.ac.bristol.CDMConverter.Translation.ITranslatorManager;
import uk.ac.bristol.CDMConverter.Translation.TranslatorManagerFactory;

@objid ("1854ea1d-3aa8-44d4-9cbd-46ef27935026")
public class FHIRInstance implements IEncodingInstance {
    @objid ("667fffc7-f8b2-486e-8abc-f8316d6a817d")
     final Logger logger = LogManager.getLogger();

    @objid ("ba361897-6f78-4c68-9b76-903e430a7efc")
    private IParser parser;

    @objid ("ce0b0cec-8859-477f-b1c4-e21440d0259c")
    private String directory;

    @objid ("bc492892-a5b3-49a6-98cb-4306c7d4d392")
    public FHIRInstance(String directory, String fhirFormat) {
        this.directory = directory;
        
        if (fhirFormat.contains("JSON")) {
            parser = FhirContext.forR4().newJsonParser();
        } else {
            // Else, default to  XML
            parser = FhirContext.forR4().newXmlParser();
        }
    }

    @objid ("1d7fb9b3-3649-4b71-8db7-ca72afdd4129")
    public ITranslatorManager getTranslatorTo(IEncodingInstance targetEI) {
        return TranslatorManagerFactory.getTranslatorManagerFHIRTo(targetEI);
    }

    @objid ("f7a13f64-2afc-4fc9-9e25-9e38d0b51d16")
    public ITranslatorManager getTranslatorFromFHIR() throws JSONConfigException {
        throw new JSONConfigException("Not possible to convert FHIR into FHIR");
    }

    @objid ("4387c586-947a-464b-9723-144bb4d88aa6")
    public ITranslatorManager getTranslatorFromOMOP() {
        return TranslatorManagerFactory.getOMOPToFHIRManager();
    }

    @objid ("326f6492-c470-484a-9903-f3db075a46c6")
    public IParser getParser() {
        return parser;
    }

    @objid ("ea7e0e72-1627-443d-a32c-bf4d5a11a28b")
    public String getDirectory() {
        return directory;
    }

}
