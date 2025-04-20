package com.infokes.Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	WebDriverWait wait;
	String urlHomePage = "https://o2.openmrs.org/openmrs/login.htm";

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement welcomeMessage() {
		return driver.findElement(By.tagName("h4"));
	}

	public WebElement menuPatientRecord() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver
				.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
	}

	public WebElement menuActiveVisits() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id(
				"org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension"));
	}

	public WebElement menuCaptureVital() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id("referenceapplication-vitals-referenceapplication-vitals-extension"));
	}

	public WebElement menuRegisterPatient() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String locatorRegosterPatient = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorRegosterPatient)));
		return driver.findElement(By.id(locatorRegosterPatient));
	}

	public WebElement menuAppointmentSchedulling() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(
				By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension"));
	}

	public WebElement menuReports() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id("reportingui-reports-homepagelink-reportingui-reports-homepagelink-extension"));
	}

	public WebElement menuDataManagement() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(
				By.id("coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension"));
	}

	public WebElement menuConfigureMetadata() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id(
				"org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension"));
	}

	public WebElement menuSystemAdministration() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By
				.id("coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension"));
	}

	public void directHomePage() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(urlHomePage);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h4")));
	}
}
