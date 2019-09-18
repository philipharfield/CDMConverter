package uk.ac.bristol.CDMConverter.Translation.OMOPToFHIR;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e3b62a8c-da9d-44cb-ac20-2838da2378ba")
public final class OMOPToFHIRMapperFactory {
    @objid ("068b5619-8c05-4944-966f-5e89e93cb906")
    public static IOMOPToFHIRMapper getMapper(String resourceString) {
        IOMOPToFHIRMapper mapper;
        
        switch (resourceString) {
        case "Patient":
            mapper = new OMOPToPatientMapper();
            break;
        case "Organization":
            mapper = new OMOPToOrganizationMapper();
            break;
        case "Procedure":
        	mapper = new OMOPToProcedureMapper();
        	break;
        default:
            // Do nothing - just return a null mapper.  Caller to recognise null and deal with it.
            mapper = null;
        }
        return mapper;
    }

}
