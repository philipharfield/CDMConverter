package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import java.util.Date;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("4bda02d3-2ca3-4cf2-b70c-f820a7f79e53")
public class OMOPObservationPeriod extends OMOPComponent {
    @objid ("01a3e414-20b4-4a91-8632-d6afaf10fd07")
    private Date startDate;

    @objid ("060ad102-f53b-4dc2-a562-9eca5151558d")
    private Date endDate;

    @objid ("0b4b4052-747a-40e5-aecc-e7b6ea7b8048")
    public OMOPObservationPeriod(int obsPeriodId, Date startDate, Date endDate) {
        super(obsPeriodId);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @objid ("9c1167e1-4b3a-4bfd-aa4c-b78e6a5d4cb2")
    public Date getStartDate() {
        return startDate;
    }

    @objid ("8d641400-1f67-45bc-ae31-9570d76c7daf")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @objid ("703eac33-0e90-4f4c-9929-462f3856b4d0")
    public Date getEndDate() {
        return endDate;
    }

    @objid ("b43f00d5-9b03-4f32-b8fb-33ebe0a8d2e6")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @objid ("dfde07b7-6d27-4878-b011-e768a26d850e")
    public String toString() {
        return "ObservationPeriod: Start: " + startDate + " End: " + endDate + " Redundant : " + this.isRedundant();
    }

}
