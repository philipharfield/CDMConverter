package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import uk.ac.bristol.CDMConverter.Encoding.EncodedComposite;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.FHIRResource;
import uk.ac.bristol.CDMConverter.Encoding.FHIRResources.OrganizationResource;
import uk.ac.bristol.CDMConverter.Encoding.IEncodedComponent;
import uk.ac.bristol.CDMConverter.Encoding.OMOPComponents.OMOPCareSite;
import uk.ac.bristol.CDMConverter.Exceptions.ApplicationException;

@objid ("0a25259f-eb6d-438c-935b-74212f229afd")
public class OMOPToOrganizationMapper implements IOMOPToFHIRMapper {
    @objid ("e5276ce4-8d3b-4f2d-8217-fc1cd27fab36")
    public void doMapping(Collection<FHIRResource> currentBundle, EncodedComposite personComposite) throws ApplicationException {
        // Get the care sites listed
        Collection<IEncodedComponent> components = new ArrayList<>();
        OMOPCareSite careSite = null;
        
        components = personComposite.getComponentByType(OMOPCareSite.class);
        
        Iterator<IEncodedComponent> componentItr = components.iterator();
        while (componentItr.hasNext()) {
            IEncodedComponent nextComponent = componentItr.next();
            if (nextComponent instanceof OMOPCareSite) {
                careSite = (OMOPCareSite) nextComponent;
            } else {
                throw new ApplicationException("Unable to find an organization component in this particular person composite"); 
            }
            
            if (careSite != null && !careSite.isRedundant()) {
                OrganizationResource organization = new OrganizationResource();
                organization.setName(careSite.getCareSiteName());
                organization.addIdentifier(careSite.getHashKey());
                currentBundle.add(organization);
            }
        }
    }

}
