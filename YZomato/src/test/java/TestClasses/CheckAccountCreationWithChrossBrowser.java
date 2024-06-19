package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.base.bass;
import qa.pomclasses.HomePage;

public class CheckAccountCreationWithChrossBrowser extends bass{

	WebDriver driver;
	HomePage homePage;
	
	@Parameters("browserName")
	@BeforeTest
	public void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
//		loadProperties();
//		driver = initializeBrowser(prop.getProperty("browser"));
	}
	
	@BeforeClass
	public void createPomObject() {
		homePage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void openWebSite() {
		driver.get("https://www.zomato.com/");
	}
	
	@Test
	public void checkCreatAccountButtonIsEnabled() {
		Boolean CreatAccountButtonIsEnabled= homePage.checkButtonEnabled();
		Assert.assertEquals(true, CreatAccountButtonIsEnabled);
	}
	
	@AfterMethod
	public void afterTest() {
		System.out.println("after test");
	}
	
	@AfterClass
	public void afterMethod() {
		homePage=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		System.gc();
		driver.quit();
	}
}
