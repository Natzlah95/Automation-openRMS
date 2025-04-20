package com.infokes.Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPage {

	WebDriver driver;

	WebDriverWait wait;

	public NavBarPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement navBarAccount() {
		return driver.findElement(By.cssSelector("li.nav-item.identifier"));
	}

	public WebElement navBarMyAccountOption() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.xpath("//a[normalize-space(text())='My Account']"));
	}

	public void navBarDirectMyAccount() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement accountMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-account-menu")));
		accountMenu.click();

		WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='My Account']")));
		myAccount.click();
	}


	public WebElement navBarLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selected-location")));
		return driver.findElement(By.id("selected-location"));
	}

	public WebElement navBarLogout() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(By.cssSelector("li.nav-item.logout"));
	}


	public WebElement navBarLocationInpatientWard() {
		return driver.findElement(By.xpath("//li[@locationname='Inpatient Ward']"));
	}

	public WebElement navBarLocationIsolationWard() {
		return driver.findElement(By.xpath("//li[@locationname='Isolation Ward']"));
	}

	public WebElement navBarLocationLaboratory() {
		return driver.findElement(By.xpath("//li[@locationname='Laboratory']"));
	}

	public WebElement navBarLocationOutpatientClinic() {
		return driver.findElement(By.xpath("//li[@locationname='Outpatient Clinic']"));
	}

	public WebElement navBarLocationPharmacy() {
		return driver.findElement(By.xpath("//li[@locationname='Pharmacy']"));
	}

	public WebElement navBarLocationRegistrationDesk() {
		return driver.findElement(By.xpath("//li[@locationname='Registration Desk']"));
	}

}
