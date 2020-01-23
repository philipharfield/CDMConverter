package uk.ac.bristol.CDMConverter.Exceptions;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1660deed-cd0e-4163-a353-73866f930dea")
public class JSONConfigException extends Exception {
    @objid ("260288f6-e2c3-4851-b4ad-eb2449f46140")
    private static final long serialVersionUID = 1L;

    @objid ("f6d8f175-089e-48a7-a5ac-f1f2001c2a1d")
    public JSONConfigException(String message, Throwable cause) {
        super (message, cause);
    }

    @objid ("df623aae-ab18-4099-86be-8cc14c3be7a1")
    public JSONConfigException(Throwable cause) {
        super(cause);
    }

    @objid ("4d1bf38f-c3f2-4e6b-88d6-45c4d57abcc4")
    public JSONConfigException(String message) {
        super (message);
    }

}
