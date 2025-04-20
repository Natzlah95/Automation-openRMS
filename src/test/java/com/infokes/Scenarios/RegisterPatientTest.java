package com.infokes.Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infokes.Locator.NavBarPage;
import com.infokes.Locator.RegisterPatientPage;
import com.infokes.Locator.HomePage;
import com.infokes.Locator.LoginPage;
import com.infokes.ModelData.ModelUser;
import com.infokes.SetupData.UserData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatientTest {

	WebDriver driver;
	ModelUser userData = UserData.validUser();
	LoginTest loginTest;
	LoginPage loginPage;
	HomePage homePage;
	NavBarPage navBarPage;
	HomePageTest homePageTest;
	RegisterPatientPage registerPatientPage;

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
		homePage = new HomePage(driver);
		homePageTest = new HomePageTest(homePage);
		registerPatientPage = new RegisterPatientPage(driver);
	}

	@Test(description = "Infokes-38 - Cancel Register Patient", testName = "Cancel Register Patient")
	public void testCancelRegisterPatient() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("RegisterPatient");
		registerPatientPage.fieldGivename().sendKeys("Umar");
		registerPatientPage.fieldMiddleName().sendKeys("Syarif");
		registerPatientPage.fieldFamilyName().sendKeys("Alatas");
		registerPatientPage.buttonNext().click();
		registerPatientPage.selectGender("M");
		registerPatientPage.buttonNext().click();
		registerPatientPage.fieldBirthDay().sendKeys("20");
		registerPatientPage.fieldBirthMonth().sendKeys("F");
		registerPatientPage.fieldBirthYear().sendKeys("2015");
		registerPatientPage.buttonNext().click();
		registerPatientPage.fieldAddress1().sendKeys("Address 1 Data");
		registerPatientPage.fieldAddress2().sendKeys("Alamat 2 Data");
		registerPatientPage.fieldCity().sendKeys("Tangerang");
		registerPatientPage.fieldState().sendKeys("Banten");
		registerPatientPage.fieldCountry().sendKeys("Indonesia");
		registerPatientPage.fieldPostalCode().sendKeys("15148");
		registerPatientPage.buttonNext().click();
		registerPatientPage.fieldPhoneNo().sendKeys("082112341234");
		registerPatientPage.buttonNext().click();
		registerPatientPage.selectRelationshipType("Parent");
		registerPatientPage.fieldPersonName().sendKeys("Abas");
		registerPatientPage.buttonNext().click();
		registerPatientPage.buttonCancelSubmission().click();

		System.out.println("Infokes-38 - Cancel Register Patient");
	}

	@Test(description ="Infokes-39 - Submit Register Patient", testName = "Submit Register Patient")
	public void testSubmitRegisterPatient() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("RegisterPatient");
		registerPatientPage.fieldGivename().sendKeys("Umar");
		registerPatientPage.fieldMiddleName().sendKeys("Syarif");
		registerPatientPage.fieldFamilyName().sendKeys("Alatas");
		registerPatientPage.buttonNext().click();
		registerPatientPage.selectGender("M");
		registerPatientPage.buttonNext().click();
		registerPatientPage.fieldBirthDay().sendKeys("20");
		registerPatientPage.fieldBirthMonth().sendKeys("F");
		registerPatientPage.fieldBirthYear().sendKeys("2015");
		registerPatientPage.buttonNext().click();
		registerPatientPage.fieldAddress1().sendKeys("Address 1 Data");
		registerPatientPage.fieldAddress2().sendKeys("Alamat 2 Data");
		registerPatientPage.fieldCity().sendKeys("Tangerang");
		registerPatientPage.fieldState().sendKeys("Banten");
		registerPatientPage.fieldCountry().sendKeys("Indonesia");
		registerPatientPage.fieldPostalCode().sendKeys("15148");
		registerPatientPage.buttonNext().click();
		registerPatientPage.fieldPhoneNo().sendKeys("082112341234");
		registerPatientPage.buttonNext().click();
		registerPatientPage.selectRelationshipType("Parent");
		registerPatientPage.fieldPersonName().sendKeys("Abas");
		registerPatientPage.buttonNext().click();
		registerPatientPage.buttonSubmitSubmission().click();

		System.out.println("Infokes-39 - Submit Register Patient");
	}

	@AfterClass
	public void finishing() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		RegisterPatientTest testRegisterPatient = new RegisterPatientTest();
		testRegisterPatient.setup();
		testRegisterPatient.testCancelRegisterPatient();
		testRegisterPatient.testSubmitRegisterPatient();
		testRegisterPatient.finishing();
		System.out.println("Happy Test - Register Patient Page");
	}

}
