package uk.ac.bristol.CDMConverter.Translation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.IEncodingInstance;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;
import uk.ac.bristol.CDMConverter.Translation.FHIRToOMOP.FHIRToOMOPTranslatorManager;
import uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR.OMOPToFHIRTranslatorManager;

@objid ("a901624a-4721-4480-be43-62b1a27913bd")
public final class TranslatorManagerFactory {
    @objid ("13db02a5-b9ea-4902-b979-78c099a7bd71")
    public static ITranslatorManager getTranslatorManagerOMOPTo(IEncodingInstance targetEI) throws JSONConfigException {
        return targetEI.getTranslatorFromOMOP();
    }

    @objid ("af2e066e-a31c-43bf-b804-ab0b76174c37")
    public static ITranslatorManager getTranslatorManagerFHIRTo(IEncodingInstance targetEI) throws JSONConfigException {
        return targetEI.getTranslatorFromFHIR();
    }

    @objid ("4b98f42d-dbc9-4f8c-a7b7-d14fdb44932d")
    public static ITranslatorManager getTranslatorManager(IEncodingInstance sourceEI, IEncodingInstance targetEI) throws JSONConfigException {
        return sourceEI.getTranslatorTo(targetEI);
    }

    @objid ("67efdaac-3b21-4839-9afb-c642fbd7cad3")
    public static ITranslatorManager getOMOPToFHIRManager() {
        return new OMOPToFHIRTranslatorManager();
    }
    
    public static ITranslatorManager getFHIRtoOMOPManager() {
    	return new FHIRToOMOPTranslatorManager();
    }

}
