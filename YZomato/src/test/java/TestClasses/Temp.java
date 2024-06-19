package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.pomclasses.HomePage;

public class Temp {

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.zomato.com/");
//		
//		HomePage homePage = new HomePage(driver);
//		
//		String emailError =homePage.checkEmailErrorMessage();
//		System.out.println(emailError);
		
		System.getProperties().list(System.out);
	}
}
