package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@id='input-email']")
	private WebElement email;
	
	public WebElement emailField() {
		return email;
		
	}
	
	@FindBy (xpath="//input[@id='input-password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy (xpath="//input[@class='btn btn-primary']")
	private WebElement loginbtn;
	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	

}
