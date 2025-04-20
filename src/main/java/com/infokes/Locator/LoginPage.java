package com.infokes.Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	WebDriverWait wait;
	String portal = "https://o2.openmrs.org/openmrs/login.htm";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void directLoginPage() {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Open Infokes");

		driver.manage().window().maximize();
		driver.get("https://o2.openmrs.org/openmrs/login.htm");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
	}

	public WebElement usernameField() {
		return driver.findElement(By.id("username"));
	}

	public WebElement passwordField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement loginButton() {
		return driver.findElement(By.id("loginButton"));
	}

	public WebElement viewPassword() {
		return driver.findElement(By.id("togglePassword"));
	}

	public WebElement cantLoginLink() {
		return driver.findElement(By.id("cantLogin"));
	}

	public WebElement containerLocation() {
		return driver.findElement(By.id("sessionLocation"));
	}

	public WebElement locationInpatientWard() {
		return driver.findElement(By.id("Inpatient Ward"));
	}

	public WebElement locationIsolationWard() {
		return driver.findElement(By.id("Isolation Ward"));
	}

	public WebElement locationLaboratory() {
		return driver.findElement(By.id("Laboratory"));
	}

	public WebElement locationOutpatientClinic() {
		return driver.findElement(By.id("Outpatient Clinic"));
	}

	public WebElement locationPharmacy() {
		return driver.findElement(By.id("Pharmacy"));
	}

	public WebElement locationRegistrationDesk() {
		return driver.findElement(By.id("Registration Desk"));
	}

	public WebElement errorSessionLocationMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sessionLocationError")));
		return driver.findElement(By.id("sessionLocationError"));
	}

	public WebElement errorLoginMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
		return driver.findElement(By.id("error-message"));
	}

	public WebElement cantLoginHeader() {
		return driver.findElement(By.cssSelector("#cannotLoginPopup .dialog-header"));
	}

	public WebElement cantLoginMessage() {
		return driver.findElement(By.cssSelector("#cannotLoginPopup .dialog-instructions"));
	}

	public WebElement cantLoginOkayButton() {
		return driver.findElement(By.cssSelector("#cannotLoginPopup .confirm"));
	}
	
	public void infokesLogin(String email, String password) {
		usernameField().sendKeys(email);
		passwordField().sendKeys(password);
		loginButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
	}
}
