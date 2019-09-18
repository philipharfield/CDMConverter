package uk.ac.bristol.CDMConverter.Encoding;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;
import uk.ac.bristol.CDMConverter.Translation.FHIRToOMOP.FHIRToOMOPTranslatorManager;
import uk.ac.bristol.CDMConverter.Translation.ITranslatorManager;
import uk.ac.bristol.CDMConverter.Translation.TranslatorManagerFactory;

@objid ("f0ab16e2-612e-491e-b626-537c6f5809ee")
public class OMOPInstance implements IEncodingInstance {
    @objid ("36681292-23db-44cd-9db4-df6ae196c449")
     final Logger logger = LogManager.getLogger();

    @objid ("af3c840f-6743-4531-beb9-07972b2d0567")
    private DatabaseSource dbSource;

    @objid ("4d8852cf-49ba-4f9f-865f-61deb165a0f2")
    public OMOPInstance(String dbServer, String dbName, String dbUID, String dbPassword, boolean integratedSecurity) throws ApplicationException {
        dbSource = new DatabaseSource(dbServer, dbName, dbUID, dbPassword, integratedSecurity);
    }

    @objid ("a7006448-ee3e-4fa9-9cf5-82e352fd1b58")
    public ITranslatorManager getTranslatorTo(IEncodingInstance targetEI) throws JSONConfigException {
        return TranslatorManagerFactory.getTranslatorManagerOMOPTo(targetEI);
    }

    @objid ("3bdf0af2-5ad2-4ea2-80f3-605aab84d0d1")
    public ITranslatorManager getTranslatorFromFHIR() {
        return new FHIRToOMOPTranslatorManager();
    }

    @objid ("9b301be5-97b1-4809-a8a8-e67c8fb78275")
    public ITranslatorManager getTranslatorFromOMOP() throws JSONConfigException {
        throw new JSONConfigException("Not possible to convert OMOP into OMOP");
    }

    @objid ("d18411d8-220c-4406-a67b-318cabd12993")
    public DatabaseSource getDbSource() {
        return dbSource;
    }

}
