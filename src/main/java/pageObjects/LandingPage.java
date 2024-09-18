package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[text()='My Account']")
	private WebElement myAcc;
	
	@FindBy (xpath="//a[text()='Login']")
	private WebElement loginopt;
  
	public WebElement getLoginopt() {
		return loginopt;
	}

	public WebElement getMyAccField() {
	return myAcc;
	}
	
	}

