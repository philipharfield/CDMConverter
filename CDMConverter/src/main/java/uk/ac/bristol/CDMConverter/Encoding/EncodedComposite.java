package uk.ac.bristol.CDMConverter.Encoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("84e6ba33-169f-4a05-af54-8662888eff10")
public class EncodedComposite implements IEncodedComponent, Iterable<IEncodedComponent> {
    @objid ("fff75f42-bfd2-4f7a-8f9d-ca31090f24c8")
    public List<IEncodedComponent> children = new ArrayList<IEncodedComponent> ();

    @objid ("f15b6b3d-6309-4238-8ab6-eaf4f574b428")
    public EncodedComposite() {
    }

    @objid ("4bef312c-da95-43ba-9c78-b675101e1365")
    public void addChild(IEncodedComponent child) {
        children.add(child);
    }

    @objid ("85b4e8ce-2c34-4bec-a743-6a23fe4c8450")
    public String toString() {
        List<String> strList = new ArrayList<String>();
        
        Iterator<IEncodedComponent> itr = children.iterator();
        while (itr.hasNext()) {
            strList.add(itr.next().toString());
        }
        return String.join("\r\n", strList);
    }

    @objid ("6c3f370e-93d0-445a-9282-b046d485f24e")
    @Override
    public Iterator<IEncodedComponent> iterator() {
        return children.iterator();
    }

// Use to identify object in hash key
    @objid ("fdc069de-7606-4aa6-9023-623478fd8b0d")
    @Override
    public String getHashKey() {
        // No hash key - its a composite
        return null;
    }

    @objid ("76c82cd4-e765-4b08-99aa-e1189b14c761")
    @Override
    public void setRedundancy() {
        // Nothing to do here - its a composite
    }

    @objid ("3b27725f-baf3-4a7f-8676-f535ac231e99")
    public List<IEncodedComponent> getComponentByType(Class<?> classType) {
        List<IEncodedComponent> list = new ArrayList<IEncodedComponent>();
        Iterator<IEncodedComponent> itr = children.iterator();
        while (itr.hasNext()) {
            IEncodedComponent nextComponent = itr.next();
            // check if component is of classTYpe
            if (nextComponent.getClass() == classType) {
                list.add(nextComponent);
            }
        }
        return list;
    }

    @objid ("a330b570-796a-49f5-b872-7b8261c6e5d2")
    public IEncodedComponent getComponent(Class<?> classType, int pk) {
        IEncodedComponent retComponent = null;
        return retComponent;
    }

    @objid ("827227bb-cd7d-4dda-b1e1-fd181d891268")
    public int getPrimaryKey() {
        // A composite doesn't have a primary key!!
        return 0;
    }

    @objid ("345faea0-c5a8-4c19-8aba-0f81c0f50cc4")
    public IEncodedComponent getSingleComponent(Class<?> classType) {
        // We assume that there is only one component of classtype - so just return the first found
        IEncodedComponent retComponent = null;
        Iterator<IEncodedComponent> itr = children.iterator();
        while (itr.hasNext() ) {
            IEncodedComponent nextComponent = itr.next();
            if (nextComponent.getClass() == classType) {
                retComponent = nextComponent;
                break;
            }
        }
        return retComponent;
    }

}
