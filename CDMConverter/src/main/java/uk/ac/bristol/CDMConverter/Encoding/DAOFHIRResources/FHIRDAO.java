package uk.ac.bristol.CDMConverter.Encoding.DAOFHIRResources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hl7.fhir.instance.model.api.IBaseResource;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.FHIRInstance;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("d49c5c63-ee8d-4b3d-86da-db2ac21b4860")
public class FHIRDAO implements IWritable {
    @Override
	public void persist(IBaseResource fhirResource, FHIRInstance targetEI, String targetFilename) throws ApplicationException {
    	Path path = Paths.get(targetEI.getDirectory(), targetFilename.concat(".xml"));
    	
        try (FileWriter writer = new FileWriter(path.toString());
                BufferedWriter bw = new BufferedWriter(writer)) {

               bw.write(targetEI.getParser().encodeResourceToString(fhirResource));

           } catch (IOException e) {
        	   throw new ApplicationException("Failed to write to " + path.toString(), e);
           }
		
	}
}