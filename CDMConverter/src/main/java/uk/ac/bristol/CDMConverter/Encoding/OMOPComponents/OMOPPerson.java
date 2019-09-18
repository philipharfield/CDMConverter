package uk.ac.bristol.CDMConverter.Encoding.OMOPComponents;

import java.time.LocalDate;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2210ad36-513b-4562-bfc9-61aa3cef94b5")
public class OMOPPerson extends OMOPComponent {
	private LocalDate birthDatetime;

	@objid ("54546b4e-0431-4fbb-82bb-927a6c59eebf")
    private int yearOfBirth;
    /**
     * Month = 0 represents that no month is provided in SQL
     */
    private int monthOfBirth;

    /**
     * Day = 0 represents that no day is provided in SQL
     */
	private int dayOfBirth;

    @objid ("f1060ef8-4b9a-4785-ab0a-47b44eea4f84")
    private boolean fullInstantiation;

    @objid ("343db8be-f682-4c29-9ecd-e01bb5bed780")
    private int careSiteId;

    @objid ("80b84652-a7c3-4b2f-afa9-f42a5c3e6824")
    private int genderConceptId;

    @objid ("e66c99be-85e3-41c8-a83a-7c1187e26923")
    public OMOPPerson(int personId, int yearOfBirth, int careSiteId) {
        super(personId);
        this.yearOfBirth = yearOfBirth;
        this.careSiteId = careSiteId;
        this.fullInstantiation = true;
        /*   
        [person_id] [int] IDENTITY(1,1) NOT NULL,
        [gender_concept_id] [int] NOT NULL,
        [year_of_birth] [int] NOT NULL,
        [month_of_birth] [int] NULL,
        [day_of_birth] [int] NULL,
        [birth_datetime] [datetime2](7) NULL,
        [race_concept_id] [int] NOT NULL,
        [ethnicity_concept_id] [int] NOT NULL,
        [location_id] [int] NULL,
        [provider_id] [int] NULL,
        [care_site_id] [int] NULL,
        [person_source_value] [varchar](50) NULL,
        [gender_source_value] [varchar](50) NULL,
        [gender_source_concept_id] [int] NULL,
        [race_source_value] [varchar](50) NULL,
        [race_source_concept_id] [int] NULL,
        [ethnicity_source_value] [varchar](50) NULL,
        [ethnicity_source_concept_id] [int] NULL
               */
    }

    @objid ("70ba827d-b6cf-4d18-9c7c-eb6d86254d32")
    public OMOPPerson(int personId) {
        super(personId);
        this.primaryKey = personId;
        this.fullInstantiation = false;
    }

    @objid ("4284548c-aca3-40b5-97a0-50bbfd542eea")
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @objid ("6d02291e-0af7-4a40-8e11-097ae79b7f79")
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getMonthOfBirth() {
		return monthOfBirth;
	}

	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public int getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
    @objid ("dbb96f6a-979d-429a-8b5a-9aded5777d03")
    public boolean isFullInstantiation() {
        return fullInstantiation;
    }

    @objid ("1ac47cdb-f3d9-4232-9798-c4f588bf4307")
    public void setFullInstantiation(boolean fullInstantiation) {
        this.fullInstantiation = fullInstantiation;
    }

    @objid ("68235db4-899e-40bd-a8ab-b2465cff4b27")
    public int getCareSiteId() {
        return careSiteId;
    }

    @objid ("c795ab50-8b4a-47ae-962d-b4dfb73b3954")
    public void setCareSiteId(int careSiteId) {
        this.careSiteId = careSiteId;
    }

    @objid ("9a09fcc2-58e9-4ff8-ae28-c611de9f4b0d")
    public int getGenderConceptId() {
        return genderConceptId;
    }

    @objid ("221a48b5-4c79-46d6-8369-afefe5b68f7f")
    public void setGenderConceptId(int genderConceptId) {
        this.genderConceptId = genderConceptId;
    }
	
    public LocalDate getBirthDatetime() {
		return birthDatetime;
	}

	public void setBirthDatetime(LocalDate birthDatetime) {
		this.birthDatetime = birthDatetime;
	}


    @objid ("c52aaa6c-9c48-4bd4-aa6f-a0f2577de4c0")
    public String toString() {
        String returnString;
        if (fullInstantiation) {
            returnString = "PersonID : " + primaryKey + " YOB : " + yearOfBirth + " Redundant : " + this.isRedundant();
        } else {
            returnString = "PersonID : " + primaryKey + " (partial instantiation)";
        }
        return returnString;
    }
}
