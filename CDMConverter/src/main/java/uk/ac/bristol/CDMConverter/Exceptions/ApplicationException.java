package uk.ac.bristol.CDMConverter.Exceptions;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e2a55a26-65be-4f82-86a4-682eae3a79ac")
public class ApplicationException extends Exception {
    /**
     * Default serial id
     */
    @objid ("c5538dec-43aa-4fb5-b557-6dc1e2df52df")
    private static final long serialVersionUID = 1L;

    @objid ("7eadf0d5-ad90-492a-a783-50f1b42fbd7d")
    public ApplicationException(String message, Throwable cause) {
        super (message, cause);
    }

    @objid ("9da2cd2f-67b5-4a68-8571-405be801bb61")
    public ApplicationException(Throwable cause) {
        super (cause);
    }

    @objid ("36d52e1a-a2d0-4cad-90a0-24fb9886ea89")
    public ApplicationException(String message) {
        super (message);
    }

}
