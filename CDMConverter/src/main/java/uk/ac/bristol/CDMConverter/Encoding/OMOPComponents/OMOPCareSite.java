package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0a97f37c-e499-4552-b5ec-d6f6ec8351b3")
public class OMOPCareSite extends OMOPComponent {
    @objid ("e2839c84-4085-461d-a3bc-3394e89d82a0")
    private String careSiteName;

    @objid ("ad5804ab-eb86-4a31-ad0e-3fe007408f96")
    private int placeOfServiceConceptId;

    @objid ("30cfea86-3b10-4061-a507-f7ee8486095a")
    private String careSiteSourceValue;

    @objid ("82aeb0f8-a328-4aa7-b53d-58e9930dee20")
    public OMOPCareSite(int careSiteId, String careSiteName) {
        super(careSiteId);
        this.careSiteName = careSiteName;
    }

    @objid ("80a8ec3b-c45b-4a79-91ed-704461fdb989")
    public String toString() {
        return "CareSite: " + careSiteName + " Redundant : " + this.isRedundant();
    }

    @objid ("fecae737-2a31-4904-8a01-03f2bf98b616")
    public String getCareSiteName() {
        return careSiteName;
    }

    @objid ("dc5bbd08-520e-40ad-b98a-ae536e76e0eb")
    public void setCareSiteName(String careSiteName) {
        this.careSiteName = careSiteName;
    }

}
