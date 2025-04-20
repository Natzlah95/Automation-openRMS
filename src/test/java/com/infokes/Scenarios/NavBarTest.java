package com.infokes.Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infokes.Locator.NavBarPage;
import com.infokes.Locator.LoginPage;
import com.infokes.ModelData.ModelUser;
import com.infokes.SetupData.UserData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavBarTest {

	WebDriver driver;
	ModelUser userData = UserData.validUser();
	LoginTest loginTest;
	LoginPage loginPage;
	NavBarPage navBarPage;

	String pageTitle;
	boolean isHeadless = false;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		if (isHeadless) {
			options.addArguments("--headless=new");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
		}

		driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
		loginTest = new LoginTest(loginPage);
		navBarPage = new NavBarPage(driver);
	}

	@Test(description = "Infokes-19 - Access Account Profile Menu", testName = "Access Account Profile Menu")
	public void testAccessMyAccount() {
		// Have bug at elemen
		loginTest.directLogin();
		navBarPage.navBarDirectMyAccount();
		System.out.println("Infokes-19 - Access Account Profile Menu");
	}

	@Test(description = "Infokes-20 - Access Relocation Menu", testName = "Access Relocation Menu")
	public void testRelocationMenu() {
		loginTest.directLogin();
		navBarPage.navBarLocation().click();
		System.out.println("Infokes-20 - Access Relocation Menu");
	}

	@Test(description = "Infokes-21 - Access Logout Menu", testName = "Access Logout Menu")
	public void testLogoutUser() {
		loginTest.directLogin();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-21 - Access Logout Menu");
	}

	@Test(description = "Infokes-22 - Account Relocation to Inpatient Ward using NavBar", testName = "Account Relocation to Inpatient Ward using NavBar")
	public void testRelocationInpatientWard() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationLaboratory().click();
		loginPage.loginButton().click();
		navBarPage.navBarLocation().click();
		navBarPage.navBarLocationInpatientWard().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-22 - Account Relocation to Inpatient Ward using NavBar");
	}

	@Test(description = "Infokes-23 - Account Relocation to Isolation Ward using NavBar", testName = "Account Relocation to Isolation Ward using NavBar")
	public void testRelocationIsolationWard() {
		loginTest.directLogin();
		navBarPage.navBarLocation().click();
		navBarPage.navBarLocationIsolationWard().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-23 - Account Relocation to Isolation Ward using NavBar");
	}

	@Test(description = "Infokes-24 - Account Relocation to Laboratory using NavBar", testName = "Account Relocation to Laboratory using NavBar")
	public void testRelocationLaboratory() {
		loginTest.directLogin();
		navBarPage.navBarLocation().click();
		navBarPage.navBarLocationLaboratory().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-24 - Account Relocation to Laboratory using NavBar");
	}

	@Test(description = "Infokes-25 - Account Relocation to Outpatient Clinic using NavBar", testName = "Account Relocation to Outpatient Clinic using NavBar")
	public void testRelocationOutpatientClinic() {
		loginTest.directLogin();
		navBarPage.navBarLocation().click();
		navBarPage.navBarLocationOutpatientClinic().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-25 - Account Relocation to Outpatient Clinic using NavBar");
	}

	@Test(description = "Infokes-26 - Account Relocation to Pharmacy using NavBar", testName = "Account Relocation to Pharmacy using NavBar")
	public void testRelocationPharmacy() {
		loginTest.directLogin();
		navBarPage.navBarLocation().click();
		navBarPage.navBarLocationPharmacy().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-26 - Account Relocation to Pharmacy using NavBar");
	}

	@Test(description = "Infokes-27 - Account Relocation to Registration Deck using NavBar", testName = "Account Relocation to Registration Deck using NavBar")
	public void testRelocationRegistrationDesk() {
		loginTest.directLogin();
		navBarPage.navBarLocation().click();
		navBarPage.navBarLocationRegistrationDesk().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-27 - Account Relocation to Registration Deck using NavBar");
	}

	@AfterClass
	public void finishing() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		NavBarTest testNavBar = new NavBarTest();
		testNavBar.setup();
//		testNavBar.testAccessMyAccount(); // Bug
		testNavBar.testLogoutUser();
		testNavBar.testRelocationInpatientWard();
		testNavBar.testRelocationIsolationWard();
		testNavBar.testRelocationLaboratory();
		testNavBar.testRelocationOutpatientClinic();
		testNavBar.testRelocationPharmacy();
		testNavBar.testRelocationRegistrationDesk();
		testNavBar.finishing();
		System.out.println("Happy Test - Nav Bar Menu");
	}

}
