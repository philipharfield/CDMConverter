package uk.ac.bristol.CDMConverter.Encoding.DAOFHIRResources;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hl7.fhir.instance.model.api.IBaseResource;
import uk.ac.bristol.CDMConverter.Encoding.FHIRInstance;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("2b2afdd4-9fdc-43fd-9bee-6de0dc3182ef")
public interface IWritable {
    @objid ("410e87be-be01-4884-a09e-4e3b5b8382e9")
    void persist(IBaseResource fhirResource, FHIRInstance targetEI, String targetFilename) throws ApplicationException;

}
