package com.infokes.SetupData;

import com.infokes.ModelData.ModelPatient;

public class PatientData {
	
	public static ModelPatient patientData1() {
		ModelPatient patientData = new ModelPatient();
		patientData.setPatientUuid("100HTR");
		patientData.setName("Umar Syarif Alatas");
		patientData.setGivenName("Umar");
		patientData.setMiddleName("Alatas");
		patientData.setGivenName("Alatas");
		patientData.setAddress1("Alam Sutra");
		patientData.setGender("M");
		patientData.setAge("25");
		patientData.setBirthDate("01.Jan.2000");
		return patientData;
	}

}
