package uk.ac.bristol.CDMConverter.Translation.FHIRToOMOP;

import java.sql.SQLException;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ac.bristol.CDMConverter.Encoding.FHIRInstance;
import uk.ac.bristol.CDMConverter.Encoding.IEncodingInstance;
import uk.ac.bristol.CDMConverter.Encoding.OMOPInstance;
import uk.ac.bristol.CDMConverter.Translation.ITranslatorManager;

@objid ("badf3007-2326-4178-a1c7-a3ffc9ae3d98")
public class FHIRToOMOPTranslatorManager implements ITranslatorManager {
    @objid ("8118f4c3-3ea4-4aa0-af50-906b2ce97b09")
    private Logger logger = LogManager.getLogger();

    @objid ("4a5a2f50-9601-44e1-85df-252643a5e0b7")
    @Override
    public void doTranslate(IEncodingInstance sourceEI, IEncodingInstance targetEI, List<String> targetResources, String sourceCohort) throws SQLException {
        logger.info("FHIRToOMOPTranslator not implemented.");
        doTranslate((FHIRInstance) sourceEI, (OMOPInstance) targetEI, targetResources);
    }

    @objid ("08aee395-a383-4951-9365-096dc22b007d")
    private void doTranslate(FHIRInstance sourceEI, OMOPInstance targetEI, List<String> targetResources) {
    }

}
