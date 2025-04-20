package com.infokes.Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

	WebDriver driver;

	WebDriverWait wait;
	String urlMyAccountage = "https://o2.openmrs.org/openmrs/adminui/myaccount/myAccount.page";

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement buttonBackHome() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.xpath("//a[@href='/openmrs/index.htm']"));
	}

	public WebElement menuChangePassword() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/changePassword.page']"));
	}

	public WebElement menuMyLanguages() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/changeDefaults.page']"));
	}
	
	public void directMyAccountPage() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(urlMyAccountage);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs")));
	}
}
