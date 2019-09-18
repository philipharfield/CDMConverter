package uk.ac.bristol.CDMConverter.Translation;

import java.sql.SQLException;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.IEncodingInstance;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("09f92215-da61-439b-b175-c2c8da20e0f0")
public interface ITranslatorManager {
    @objid ("492b64ef-d8ce-4b0b-a902-34a21c07bcce")
    void doTranslate(IEncodingInstance sourceEI, IEncodingInstance targetEI, List<String> targetResources, String sourceCohort) throws ApplicationException, SQLException;

}
