package com.infokes.Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPatientPage {

	WebDriver driver;

	WebDriverWait wait;

	public RegisterPatientPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement headerPage() {
		return driver.findElement(By.tagName("h2"));
	}

	public WebElement sidebarName() {
		return driver.findElement(By.xpath("//li[contains(@class, 'question-legend')]/span[text()='Name']"));
	}

	public WebElement sidebarGender() {
		return driver.findElement(By.xpath("//li[contains(@class, 'question-legend')]/span[text()='Gender']"));
	}

	public WebElement sidebarBirtdate() {
		return driver.findElement(By.xpath("//li[contains(@class, 'question-legend')]/span[text()='Birthdate']"));
	}

	public WebElement sidebarAddress() {
		return driver.findElement(By.xpath("//li[@class='question-legend']/span[text()='Address']"));
	}

	public WebElement sidebarPhoneNo() {
		return driver.findElement(By.xpath("//li[@class='question-legend']/span[text()='Phone Number']"));
	}

	public WebElement sidebarRelatives() {
		return driver.findElement(By.xpath("//li[@class='question-legend']/span[text()='Relatives']"));
	}

	public WebElement fieldGivename() {
		return driver.findElement(By.name("givenName"));
	}

	public WebElement errorGivenNameField() {
		return driver.findElement(By.xpath("//span[@id='fr6775' and contains(@class, 'field-error')]"));
	}

	public WebElement fieldMiddleName() {
		return driver.findElement(By.name("middleName"));
	}

	public WebElement fieldFamilyName() {
		return driver.findElement(By.name("familyName"));
	}

	public WebElement errorFamilyName() {
		return driver.findElement(By.xpath("//span[@id='fr8172' and contains(@class, 'field-error')]"));
	}

	public WebElement checkboxIdentifyType() {
		return driver.findElement(By.id("checkbox-unknown-patient"));
	}

	public WebElement buttonBack() {
		return driver.findElement(By.id("prev-button"));
	}

	public WebElement buttonNext() {
		return driver.findElement(By.id("next-button"));
	}

	public WebElement fieldGender() {
		return driver.findElement(By.id("gender-field"));
	}

	public WebElement fieldBirthDay() {
		return driver.findElement(By.id("birthdateDay-field"));
	}

	public WebElement fieldBirthMonth() {
		return driver.findElement(By.id("birthdateMonth-field"));
	}

	public WebElement fieldBirthYear() {
		return driver.findElement(By.id("birthdateYear-field"));
	}

	public WebElement fieldEstimatedYear() {
		return driver.findElement(By.id("birthdateYears-field"));
	}

	public WebElement fieldEstimatedMonth() {
		return driver.findElement(By.id("birthdateMonths-field"));
	}

	public WebElement errorBirthDateMessage() {
		return driver.findElement(By.xpath("//span[@id='fr3682' and contains(@class, 'field-error')]"));
	}

	public WebElement errorBirthDayeMessage() {
		return driver.findElement(By.xpath("//span[@id='fr6021' and contains(@class, 'field-error')]"));
	}

	public WebElement errorBirthdYearMessage() {
		return driver.findElement(By.xpath("//span[@id='fr9586' and contains(@class, 'field-error')]"));
	}

	public WebElement fieldAddress1() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement fieldAddress2() {
		return driver.findElement(By.id("address2"));
	}

	public WebElement fieldCity() {
		return driver.findElement(By.id("cityVillage"));
	}

	public WebElement fieldState() {
		return driver.findElement(By.id("stateProvince"));
	}

	public WebElement fieldCountry() {
		return driver.findElement(By.id("country"));
	}

	public WebElement fieldPostalCode() {
		return driver.findElement(By.id("postalCode"));
	}

	public WebElement fieldPhoneNo() {
		return driver.findElement(By.xpath("//input[@name='phoneNumber' and contains(@class, 'phone')]"));
	}

	public WebElement buttonPlusRelationshipPatient() {
		return driver.findElement(By.cssSelector("i.icon-plus-sign.edit-action"));
	}

	public WebElement buttonMinusRelationshipPatient() {
		return driver.findElement(By.cssSelector("icon-minus-sign edit-action"));
	}

	public WebElement fieldPersonName() {
		return driver.findElement(By.xpath("//input[@placeholder='Person Name' and @type='text']"));
	}

	public void selectRelationshipType(String relationshipText) {
		Select select = new Select(driver.findElement(By.id("relationship_type")));
		select.selectByVisibleText(relationshipText);
	}

	public WebElement buttonSubmitSubmission() {
		return driver.findElement(By.id("submit"));
	}

	public WebElement buttonCancelSubmission() {
		return driver.findElement(By.id("cancelSubmission"));
	}

	public WebElement selectGender(String gender) {
		WebElement genderElement = driver.findElement(By.id("gender-field"));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByValue(gender); // or "F"
		return driver.findElement(By.id("gender-field"));
	}

}
