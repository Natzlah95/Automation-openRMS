package com.infokes.Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPatientRecordPage {

	WebDriver driver;

	WebDriverWait wait;

	public FindPatientRecordPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement headerPageName() {
		return driver.findElement(By.tagName("h2"));
	}
	public WebElement fieldSearch() {
		String locatorTableData = "patient-search-results";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorTableData)));
		return driver.findElement(By.id("patient-search"));
		
	}
	public WebElement buttonClear() {
		return driver.findElement(By.id("patient-search-clear-button"));
	}
	public WebElement tableSearchResult() {
		return driver.findElement(By.id("patient-search-results"));
	}

	public WebElement pagingFirst() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id("patient-search-results-table_first"));
	}

	public WebElement pagingPrevious() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id("patient-search-results-table_previous"));
	}

	public WebElement pagingPage1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement paging1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='1']")));
		paging1.click();
		return paging1;
	}

	public WebElement pagingPage2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement paging2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='1']")));
		paging2.click();
		return paging2;
	}

	public WebElement pagingPage3() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement paging3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='1']")));
		paging3.click();
		return paging3;
	}

	public WebElement pagingNext() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id("patient-search-results-table_next"));
	}

	public WebElement pagingLast() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.id("patient-search-results-table_last"));
	}

}
