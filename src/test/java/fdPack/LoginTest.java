package fdPack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import resources.Base;
import resources.excelReader;

public class LoginTest extends Base{
	WebDriver driver;
	
	@BeforeMethod
	public void launch() throws IOException {
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider= "getLoginData")
	public void login(String UserName, String Password, String Expected) throws IOException {
		
		LandingPage lp= new LandingPage(driver);
		lp.getMyAccField().click();
		lp.getLoginopt().click();
		
		loginPage lp1=new loginPage(driver);
		lp1.emailField().sendKeys(UserName);
		lp1.getPassword().sendKeys(Password);
		lp1.getLoginbtn().click();
		
		myAccountPage ap=new myAccountPage(driver); 
		String Actual=null;
		try {
		if(ap.getAcc().isDisplayed()) {
			Actual="success";
		}
		}
		catch(Exception e) {
			Actual="fail";
		}
		Assert.assertEquals(Actual, Expected);
		
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginData() throws IOException {
		
		excelReader excel=new excelReader();
		Object[][] data = excel.excelRead();
		return data;
	}
}
