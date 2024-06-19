package qa.pomclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement logIn;
	
	@FindBy(id="auth-login-ui")
	private WebElement frm;
	
	@FindBy(xpath="//span[contains(text(),'Create account')]")
	private WebElement createAccount;
	
	@FindBy(xpath="//label[text()='Full Name']/parent::section/child::section/input")
	private WebElement fullName;
	
	@FindBy(xpath="//label[text()='Full Name']/parent::section/child::section/input/parent::section/parent::section/following-sibling::section/descendant::input")
	private WebElement email;
	
	@FindBy(xpath="//input[@class='sc-1o2pknd-1 gUphWv']")
	private WebElement checkbox;
	
	@FindBy(xpath="//span[text()='Create account']/parent::span/parent::button")
	private WebElement createAccountButton;
	
//	@FindBy(xpath="//p[text()='Email provided is invalid.']")
//	private WebElement wrongEmailErrorMessage;
	
	@FindBy(xpath="//p[contains(text(),'An account with this email already')]")
	private WebElement wrongEmailErrorMessage;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js =(JavascriptExecutor)driver;
		//WebDriverWait wait = new WebDriverWait(driver,10);
	}
	
	public void clickOnLogin() {
		logIn.click();
	}
	
	public void changeFrame() {
		driver.switchTo().frame(frm);
	}
	
//	public void getOutOfFrame() {
//		driver.switchTo().defaultContent();
//	}
	
	public void createAccount() {
		createAccount.click();
	}
	
	public void sendName(String name) {
		fullName.sendKeys(name);
	}

	public void sendEmail(String eml) {
		email.sendKeys(eml);
	}

	public void clickOnCheckBox() {
		checkbox.click();
	}
	
	public Boolean checkCreateAccountButtonIsEnabled() {
		Boolean accountButton = createAccountButton.isEnabled();
		return accountButton;
	}
	
	public void clickOnClickOnCreateButton() {
		createAccountButton.click();
	}
	
	public String getEmailErrorMessage() {
		String errorMessage =wrongEmailErrorMessage.getText();
		return errorMessage;
	}
	
	//==============================================================//
	//all in one method
	
	public Boolean checkButtonEnabled() {
		logIn.click();
		driver.switchTo().frame(frm);
		createAccount.click();
		fullName.sendKeys("kaido");
		email.sendKeys("kaido@gmail.com");
		checkbox.click();
		Boolean accountButton = createAccountButton.isEnabled();
		return accountButton;
	}
	
	public String checkEmailErrorMessage() {
		logIn.click();
		driver.switchTo().frame(frm);
		createAccount.click();
		fullName.sendKeys("kaido");
		email.sendKeys("kaido@gmail.com");
		checkbox.click();
		createAccountButton.click();
		String errorMessage =wrongEmailErrorMessage.getText();
		return errorMessage;
	}
	
}
