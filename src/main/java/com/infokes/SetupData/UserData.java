package com.infokes.SetupData;

import com.infokes.ModelData.ModelUser;

public class UserData {

	public static ModelUser validUser() {
		com.infokes.ModelData.ModelUser userData = new ModelUser();
		userData.setUsername("admin");
		userData.setPassword("Admin123");
		userData.setLocation("Inpatient Ward");
		userData.setUserType("Super User");
		return userData;
	}

}
