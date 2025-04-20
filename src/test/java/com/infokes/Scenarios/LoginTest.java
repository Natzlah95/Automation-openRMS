package com.infokes.Scenarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infokes.Locator.NavBarPage;
import com.infokes.Locator.LoginPage;
import com.infokes.ModelData.ModelUser;
import com.infokes.SetupData.UserData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	ModelUser userData = UserData.validUser();
	static LoginPage loginPage;
	NavBarPage homePage;

	String pageTitle;
	boolean isHeadless = false;
	
    public LoginTest(LoginPage loginPage) {
        this.loginPage = loginPage;
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
		homePage = new NavBarPage(driver);
	}

	@Test(description = "Infokes-01 - Login with Valid Account", testName = "Login with Valid Account")
	public void testLoginValidUser() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		homePage.navBarLogout().click();
		System.out.println("Infokes-01 - Login with Valid Account");
	}

	@Test(description = "Infokes-02 - Login with User Case Sensitive", testName = "Login with User Case Sensitive")
	public void testLoginUserSensitive() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys("Admin");
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.loginButton().click();
		homePage.navBarLogout().click();
		System.out.println("Infokes-02 - Login with User Case Sensitive");
	}

	@Test(description = "Infokes-03 - Login with User Case Sensitive", testName = "Login with User Case Sensitive")
	public void testLoginPasswordSensitive() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys("admin123");
		loginPage.loginButton().click();
		homePage.navBarLogout().click();
		System.out.println("Infokes-03 - Login with User Case Sensitive");
	}

	@Test(description = "Infokes-04 - Login not Select Location", testName = "Login not Select Location")
	public void testLoginWithoutLocation() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.loginButton().click();
		homePage.navBarLogout().click();
		System.out.println("Infokes-04 - Login not Select Location");
	}

	@Test(description = "Infokes-05 - Login without Username", testName = "Login without Username")
	public void testLoginWithoutUsername() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys("");
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-05 - Login without Username");
	}

	@Test(description = "Infokes-06 - Login without Password", testName = "Login without Password")
	public void testLoginWithoutPassword() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys("");
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-06 - Login without Password");
	}

	@Test(description = "Infokes-07 - Login with Unregister Account", testName = "Login with Unregister Account")
	public void testLoginUnregisterAccount() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys("randomUsername");
		loginPage.passwordField().sendKeys("randomPassword");
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-07 - Login with Unregister Account");
	}

	@Test(description = "Infokes-08 - Login with Wrong Password", testName = "Login with Wrong Password")
	public void testLoginWrongPassword() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys("randomPassword");
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-08 - Login with Wrong Password");
	}

	@Test(description = "Infokes-09 - Login with Wrong Password 10 Times", testName = "Login with Wrong Password 10 Times")
	public void testLoginManyWrongPassword() {
		loginPage.directLoginPage();

		for (int i = 0; i < 10; i++) {
			loginPage.usernameField().sendKeys(userData.getUsername());
			loginPage.passwordField().sendKeys("randomPassword");
			loginPage.locationInpatientWard().click();
			loginPage.loginButton().click();
			String error = loginPage.errorLoginMessage().getText();
			System.out.println(error);

			System.out.println("Infokes-09 - Login with Wrong Password 10 Time, Trying: " + (i + 1));
		}
	}

	@Test(description = "Infokes-10 - View Password", testName = "View Password")
	public void testViewPassword() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys("randomPassword");
		loginPage.locationInpatientWard().click();
		loginPage.viewPassword().click();
//		String getPassword = loginPage.passwordField().getText();
//		String expectedPassword = userData.getPassword();
//		assertEquals("Password matched!", expectedPassword, getPassword);
		System.out.println("Infokes-10 - View Password");
	}

	@Test(description = "Infokes-11 - Disable View Password", testName = "Disable View Password")
	public void testMaskingPassword() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys("randomPassword");
		loginPage.locationInpatientWard().click();
		loginPage.viewPassword().click();
		loginPage.viewPassword().click();
//		String getPassword = loginPage.passwordField().getAttribute("value");
//		String expectedPassword = "********";
//		assertEquals(expectedPassword, getPassword, "Password matched!");
		System.out.println("Infokes-11 - Disable View Password");
	}

	@Test(description = "Infokes-12 - Can't Login", testName = "Can't Login")
	public void testCantLogin() {
		loginPage.directLoginPage();
		loginPage.cantLoginLink().click();
		loginPage.cantLoginOkayButton().click();
		System.out.println("Infokes-12 - Can't Login");
	}

	@Test(description = "Infokes-13 - Login in Inpatient Ward Location", testName = "Login in Inpatient Ward Location")
	public void testLoginAtInpatientWard() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-13 - Login in Inpatient Ward Location");
	}

	@Test(description = "Infokes-14 - Login in Isolation Ward Location", testName = "Login in Isolation Ward Location")
	public void testLoginAtIsolationWard() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationIsolationWard().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-14 - Login in Isolation Ward Location");
	}

	@Test(description = "Infokes-15 - Login in Laboratory Location", testName = "Login in Laboratory Location")
	public void testLoginAtLaboratory() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationLaboratory().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-15 - Login in Laboratory Location");
	}

	@Test(description = "Infokes-16 - Login in Outpatient Clinic Location", testName = "Login in Outpatient Clinic Location")
	public void testLoginAtOutpatientClinic() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationOutpatientClinic().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-16 - Login in Outpatient Clinic Location");
	}

	@Test(description = "Infokes-17 - Login in Pharmacy Location", testName = "Login in Pharmacy Location")
	public void testLoginAtPharmacy() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationPharmacy().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-17 - Login in Pharmacy Location");
	}

	@Test(description = "Infokes-18 - Login in Registration Deck Location", testName = "Login in Registration Deck Location")
	public void testLoginAtRegistrationDesk() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationRegistrationDesk().click();
		loginPage.loginButton().click();
		System.out.println("Infokes-18 - Login in Registration Deck Location");
	}
	
	public void directLogin() {
		loginPage.directLoginPage();
		loginPage.usernameField().sendKeys(userData.getUsername());
		loginPage.passwordField().sendKeys(userData.getPassword());
		loginPage.locationInpatientWard().click();
		loginPage.loginButton().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void finishing() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		LoginTest loginTest = new LoginTest(loginPage);
		loginTest.setup();
		loginTest.testLoginValidUser();
		loginTest.testLoginPasswordSensitive();
		loginTest.testLoginUserSensitive();
		loginTest.testLoginWithoutLocation();
		loginTest.testLoginWithoutUsername();
		loginTest.testLoginWithoutPassword();
		loginTest.testLoginUnregisterAccount();
		loginTest.testLoginWrongPassword();
		loginTest.testLoginManyWrongPassword();
		loginTest.testViewPassword();
		loginTest.testMaskingPassword();
		loginTest.testCantLogin();
		loginTest.testLoginAtInpatientWard();
		loginTest.testLoginAtIsolationWard();
		loginTest.testLoginAtLaboratory();
		loginTest.testLoginAtOutpatientClinic();
		loginTest.testLoginAtPharmacy();
		loginTest.testLoginAtRegistrationDesk();
		loginTest.finishing();
		System.out.println("Happy Test - Login");
	}
}
