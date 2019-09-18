package uk.ac.bristol.CDMConverter.Translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.IEncodedComponent;

@objid ("72981e8c-0653-4226-92fc-f48bf20f2c6a")
public final class RedundancyHashMap extends HashMap<String,String> {
    @objid ("ab1c82df-905e-4e08-82ca-f1a0f9e08f0c")
    private static final long serialVersionUID = 1L;

    @objid ("08df521c-178d-46f3-b5b3-c6453540cfb7")
    public void populate(IEncodedComponent component) {
        if (component instanceof EncodedComposite) {     // Forward onto sub components
            Iterator<IEncodedComponent> itr = ((EncodedComposite) component).iterator();
            while (itr.hasNext()) {
                this.populate(itr.next());
            }
        } else {    // Need to check whether key exists - either add to hash or set the components redundancy
            if (this.containsKey(component.getHashKey())) {
                component.setRedundancy();
            } else {
                this.put(component.getHashKey(), component.getHashKey());
            }
        }
    }

    @objid ("e976910a-6771-4136-943b-3be5c6dc4eb6")
    public String toString() {
        List<String> strList = new ArrayList<String>();
        Iterator<Entry<String, String>> itr = this.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, String> elem = (Entry<String, String>)itr.next();
            strList.add("hash:" + elem.getKey() + " value:" + elem.getValue());
        }
        return String.join("\r\n", strList);
    }

}
