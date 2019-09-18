package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.FHIRResource;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("464b8fe0-0b6f-454f-889c-5284c3867fe0")
public interface IOMOPToFHIRMapper {
    @objid ("542e4267-8744-43f8-8284-660886aa92a9")
    void doMapping(Collection<FHIRResource> currentBundle, EncodedComposite personComposite) throws ApplicationException;

}
