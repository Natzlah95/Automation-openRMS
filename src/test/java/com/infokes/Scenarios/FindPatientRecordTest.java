package com.infokes.Scenarios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infokes.Locator.NavBarPage;
import com.infokes.Locator.FindPatientRecordPage;
import com.infokes.Locator.HomePage;
import com.infokes.Locator.LoginPage;
import com.infokes.ModelData.ModelPatient;
import com.infokes.ModelData.ModelUser;
import com.infokes.SetupData.PatientData;
import com.infokes.SetupData.UserData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindPatientRecordTest {

	WebDriver driver;
	ModelUser userData = UserData.validUser();
	ModelPatient patientData = PatientData.patientData1();
	LoginTest loginTest;
	LoginPage loginPage;
	HomePage homePage;
	HomePageTest homePageTest;
	NavBarPage navBarPage;
	FindPatientRecordPage findPatientRecordPage;

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
		homePage = new HomePage(driver);
		loginTest = new LoginTest(loginPage);
		homePageTest = new HomePageTest(homePage);
		navBarPage = new NavBarPage(driver);
		findPatientRecordPage = new FindPatientRecordPage(driver);
	}

	@Test(description = "Infokes-40 - Search Patient Record with Patient ID", testName = "Search Patient Record with Patient ID")
	public void testSearchPatientWithPatientID() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("FindPatientRecord");
		findPatientRecordPage.fieldSearch().sendKeys(patientData.getPatientUuid());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualData = driver.findElement(By.xpath("//tr[@class='odd']/td[1]")).getText();
		System.out.println(actualData);
		String expectedData = patientData.getPatientUuid();
		assertThat(actualData).contains(expectedData);
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-40 - Search Patient Record with Patient ID");
	}

	@Test(description = "Infokes-41 - Search Patient Record with Patient Name", testName = "Search Patient Record with Patient Name")
	public void testSearchPatientWithPatientName() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("FindPatientRecord");
		findPatientRecordPage.fieldSearch().sendKeys(patientData.getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualData = driver.findElement(By.xpath("//tr[@class='odd']/td[1]")).getText();
		System.out.println(actualData);
		String expectedData = patientData.getPatientUuid();
		assertThat(actualData).contains(expectedData);
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-41 - Search Patient Record with Patient Name");
	}

	@Test(description = "Infokes-42 - Search Patient Record with Patient Gender", testName = "Search Patient Record with Patient Gender")
	public void testSearchPatientWithPatientGender() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("FindPatientRecord");
		findPatientRecordPage.fieldSearch().sendKeys(patientData.getGender());
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-42 - Search Patient Record with Patient Gender");
	}

	@Test(description = "Infokes-43 - Search Patient Record with Patient Age", testName = "Search Patient Record with Patient Age")
	public void testSearchPatientWithPatientAge() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("FindPatientRecord");
		findPatientRecordPage.fieldSearch().sendKeys(patientData.getAge());
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-43 - Search Patient Record with Patient Age");
	}

	@Test(description = "Infokes-44 - Search Patient Record with Patient Birthdate", testName = "Search Patient Record with Patient Birthdate")
	public void testSearchPatientWithPatientBirthDate() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("FindPatientRecord");
		findPatientRecordPage.fieldSearch().sendKeys(patientData.getBirthDate());
		navBarPage.navBarLogout().click();
		System.out.println("Infokes-44 - Search Patient Record with Patient Birthdate");
	}

	@Test(description = "Infokes-45 - Clear Patient Record Search", testName = "Clear Patient Record Search")
	public void testClearSearchPatient() {
		loginTest.directLogin();
		homePageTest.accessMenuHomePage("FindPatientRecord");
		findPatientRecordPage.fieldSearch().sendKeys(patientData.getPatientUuid());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		findPatientRecordPage.buttonClear().click();
		System.out.println("Infokes-45 - Clear Patient Record Search");
	}
	@Test(description ="Infokes-46 - First Pagination Data on Patient Record", testName = "First Pagination Data on Patient Record")
	public void testFirstPagination() {
		findPatientRecordPage.pagingFirst().click();
		System.out.println("Infokes-46 - First Pagination Data on Patient Record");
	}
	@Test(description ="Infokes-47 - Previous Pagination Data on Patient Record", testName = "Previous Pagination Data on Patient Record")
	public void testPreviousPagination() {
		findPatientRecordPage.pagingPrevious().click();
		System.out.println("Infokes-47 - Previous Pagination Data on Patient Record");
	}
	@Test(description ="Infokes-48 - Specific Number Pagination Data on Patient Record", testName = "Specific Number Pagination Data on Patient Record")
	public void testSpecificPagination() {
		findPatientRecordPage.pagingPage1().click();
		System.out.println("Infokes-48 - Specific Number Pagination Data on Patient Record");
	}
	@Test(description ="Infokes-49 - Next Pagination Data on Patient Record", testName = "Next Pagination Data on Patient Record")
	public void testNextPagination() {
		findPatientRecordPage.pagingNext().click();
		System.out.println("Infokes-49 - Next Pagination Data on Patient Record");
	}
	@Test(description ="Infokes-50 - Last Pagination Data on Patient Record", testName = "Last Pagination Data on Patient Record")
	public void testLastPagination() {
		findPatientRecordPage.pagingLast().click();
		System.out.println("Infokes-50 - Last Pagination Data on Patient Record");
	}

//	@Test
//	public void selectGender() {
//	    WebElement genderElement = driver.findElement(By.id("gender-field"));
//	    Select genderSelect = new Select(genderElement);
//	    genderSelect.selectByValue("M");
//	}

	@AfterClass
	public void finishing() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		FindPatientRecordTest testFindPatientRecord = new FindPatientRecordTest();
		testFindPatientRecord.setup();
		testFindPatientRecord.testSearchPatientWithPatientID();
		testFindPatientRecord.testSearchPatientWithPatientName();
		testFindPatientRecord.testSearchPatientWithPatientGender();
		testFindPatientRecord.testSearchPatientWithPatientAge();
		testFindPatientRecord.testSearchPatientWithPatientGender();
		testFindPatientRecord.testClearSearchPatient();
		testFindPatientRecord.testFirstPagination();
		testFindPatientRecord.testPreviousPagination();
		testFindPatientRecord.testSpecificPagination();
		testFindPatientRecord.testLastPagination();
		testFindPatientRecord.finishing();
		System.out.println("Happy Test - Nav Bar Menu");
	}

}
