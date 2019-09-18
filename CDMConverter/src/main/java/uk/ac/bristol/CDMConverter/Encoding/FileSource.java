package uk.ac.bristol.CDMConverter.Encoding;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("12b674ed-24ad-4a1f-b149-99149b78b712")
public class FileSource {
    @objid ("db0ed2bb-cf61-4945-a090-e545f76dedd9")
    private String filePath;

    @objid ("b729a3fc-4d3c-4842-91ce-5ca35b7a9230")
    public FileConnection fileConnection;

    @objid ("45663cfe-ffc5-42d2-8f21-5a17309493cd")
    public FileSource(String filePath) {
        this.filePath = filePath;
    }

    @objid ("ccbd0d38-c227-45cc-b8fa-e3a7a7c4789f")
    public void close() {
        // TODO
    }

}
