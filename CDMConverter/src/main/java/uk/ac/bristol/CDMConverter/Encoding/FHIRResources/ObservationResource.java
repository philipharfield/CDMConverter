package uk.ac.bristol.CDMConverter.Encoding.FHIRResources;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hl7.fhir.instance.model.api.IBaseResource;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;

@objid ("5c9dd849-c9ca-4b0e-b95c-b28f4975042c")
public class ObservationResource extends FHIRResource {
    @objid ("8cc6fe4b-cfa0-4ba2-8965-f33ea80b88c1")
    public ObservationResource() {
        Logger logger = LogManager.getLogger();
        logger.info("Creating ObservationResource");
    }

    @objid ("9eaa4f67-dd89-49cf-9ee4-d1b037289854")
    @Override
    public IBaseResource generateFHIRMessage(EncodedComposite personComposite) {
        // TODO Auto-generated method stub
        return null;
    }

}
