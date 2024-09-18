package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	
	WebDriver driver;
	
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException {
	
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browsername.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("safari")) {
			driver=new SafariDriver();
		}
		else if (browsername.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	
	}
	
	public void takeScreenShot(String TestName, WebDriver driver) throws IOException {
		
		 File sshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String Despath=System.getProperty("user.dir"+"\\screeshots\\screen3.png");
		 FileUtils.copyFile(sshot, new File(Despath));
		
	}
}
	
