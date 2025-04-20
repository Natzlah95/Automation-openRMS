	package com.infokes.Scenarios;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	
	import com.infokes.Locator.NavBarPage;
	import com.infokes.Locator.LoginPage;
	import com.infokes.Locator.MyAccountPage;
	import com.infokes.ModelData.ModelUser;
	import com.infokes.SetupData.UserData;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class MyAccountTest {
	    WebDriver driver;
	    ModelUser userData = UserData.validUser();
	    LoginTest loginTest;
	    LoginPage loginPage;
	    NavBarPage homePage;
	    MyAccountPage myAccountPage;
	    
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
	        homePage = new NavBarPage(driver);
	    }

	    
	    @Test(description = "Infokes-27 - Account Relocation to Registration Deck using NavBar", testName = "Account Relocation to Registration Deck using NavBar")
	    public void testBackHomeOnMyAccount() {
	        loginTest.testLoginValidUser();
	        homePage.navBarDirectMyAccount();
	        myAccountPage.buttonBackHome();
	        System.out.println("Infokes-27 - Account Relocation to Registration Deck using NavBar");
	    }

	    @AfterClass
	    public void finishing() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        MyAccountTest testMyAccount = new MyAccountTest();
	        testMyAccount.setup();
	        testMyAccount.testBackHomeOnMyAccount();
	        testMyAccount.finishing();
	        System.out.println("Happy Test - Nav Bar Menu");
	    }
	}

