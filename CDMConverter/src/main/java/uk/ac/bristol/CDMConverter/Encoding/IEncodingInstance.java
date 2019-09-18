package uk.ac.bristol.CDMConverter.Encoding;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Exceptions.JSONConfigException;
import uk.ac.bristol.CDMConverter.Translation.ITranslatorManager;

@objid ("e31a7721-0276-42d4-8be6-7ec861a03403")
public interface IEncodingInstance {
    @objid ("1e1c899e-f37f-4b18-9566-cd902502e19a")
    ITranslatorManager getTranslatorTo(IEncodingInstance targetEI) throws JSONConfigException;

    @objid ("1a3b2c13-fa5d-4507-835f-4200a24d41cc")
    ITranslatorManager getTranslatorFromFHIR() throws JSONConfigException;

    @objid ("588ac873-8589-4c8d-8955-d039a868ea46")
    ITranslatorManager getTranslatorFromOMOP() throws JSONConfigException;

}
