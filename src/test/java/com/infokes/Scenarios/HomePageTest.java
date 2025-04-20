package com.infokes.Scenarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infokes.Locator.HomePage;
import com.infokes.Locator.LoginPage;
import com.infokes.Locator.NavBarPage;
import com.infokes.ModelData.ModelUser;
import com.infokes.SetupData.UserData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {

	WebDriver driver;
	ModelUser userData = UserData.validUser();
	LoginTest loginTest;
	LoginPage loginPage;
	static HomePage homePage;
	NavBarPage navBarPage;

	String pageTitle;
	boolean isHeadless = false;

	public HomePageTest(HomePage homePage) {
		this.homePage = homePage;
	}

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
		homePage = new HomePage(driver);
		navBarPage = new NavBarPage(driver);
	}

	@Test(description = "Infokes-28 - Check Welcome Message", testName = "Check Welcome Message")
	public void testCheckWelcomeMessage() {
		loginTest.directLogin();
		homePage.welcomeMessage().getText();
		String welcomeMessage = homePage.welcomeMessage().getText();
		String expectedMessage = "Logged in as " + userData.getUserType() + " (" + userData.getUsername() + ") at "
				+ userData.getLocation() + ".";
		assertEquals(welcomeMessage, expectedMessage);
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-28 - Check Welcome Message");
	}

	@Test(description = "Infokes-29 - Access Menu Find Patient Record", testName = "Access Menu Find Patient Record")
	public void testAccessFindPatientRecord() {
		loginTest.directLogin();
		homePage.menuPatientRecord().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-29 - Access Menu Find Patient Record");
	}

	@Test(description = "Infokes-30 - Access Menu Active Visits", testName = "Access Menu Active Visits")
	public void testAccessActiveVisits() {
		loginTest.directLogin();
		homePage.menuActiveVisits().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-30 - Access Menu Active Visits");
	}

	@Test(description = "Infokes-31 - Access Menu Capture Vitals", testName = "Access Menu Capture Vitals")
	public void testAccessCaptureVital() {
		loginTest.directLogin();
		homePage.menuCaptureVital().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-31 - Access Menu Capture Vitals");
	}

	@Test(description = "Infokes-32 - Access Menu Register a patient", testName = "Access Menu Register a patient")
	public void testAccessRegisterPatient() {
		loginTest.directLogin();
		homePage.menuRegisterPatient().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-32 - Access Menu Register a patient");
	}

	@Test(description = "Infokes-33 - Access Menu Appointment Scheduling", testName = "Access Menu Appointment Scheduling")
	public void testAccessAppointmentSchedulling() {
		loginTest.directLogin();
		homePage.menuAppointmentSchedulling().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-33 - Access Menu Appointment Scheduling");
	}

	@Test(description = "Infokes-34 - Access Menu Reports", testName = "Access Menu Reports")
	public void testAccessReports() {
		loginTest.directLogin();
		homePage.menuReports().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-34 - Access Menu Reports");
	}

	@Test(description = "Infokes-35 - Access Menu Data Management", testName = "Access Menu Data Management")
	public void testAccessDataManagement() {
		loginTest.directLogin();
		homePage.menuDataManagement().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-35 - Access Menu Data Management");
	}

	@Test(description = "Infokes-36 - Access Menu Configure Data", testName = "Access Menu Configure Data")
	public void testAccessConfigureMetadata() {
		loginTest.directLogin();
		homePage.menuConfigureMetadata().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-36 - Access Menu Configure Data");
	}

	@Test(description = "Infokes-37 - Access Menu System Administrator", testName = "Access Menu System Administrator")
	public void testAccessSystemAdministration() {
		loginTest.directLogin();
		homePage.menuSystemAdministration().click();
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-37 - Access Menu System Administrator");
	}

	public void accessMenuHomePage(String menu) {
		switch (menu) {
		case "FindPatientRecord":
			homePage.menuPatientRecord().click();
			break;
		case "RegisterPatient":
			homePage.menuRegisterPatient().click();
			break;
		default:
			System.out.println("Menu not recognized: " + menu);
		}
	}

	@AfterClass
	public void finishing() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		HomePageTest homePageTest = new HomePageTest(homePage);
		homePageTest.setup();
		homePageTest.testCheckWelcomeMessage();
		homePageTest.testAccessFindPatientRecord();
		homePageTest.testAccessActiveVisits();
		homePageTest.testAccessCaptureVital();
		homePageTest.testAccessRegisterPatient();
		homePageTest.testAccessAppointmentSchedulling();
		homePageTest.testAccessReports();
		homePageTest.testAccessDataManagement();
		homePageTest.testAccessConfigureMetadata();
		homePageTest.testAccessSystemAdministration();
		homePageTest.finishing();
		System.out.println("Happy Test - Home Page");
	}

}
