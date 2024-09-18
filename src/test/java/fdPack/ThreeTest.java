package fdPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	WebDriver driver;
	@Test
	public void case3() throws IOException {
			 driver= intializeDriver();
			driver.get("https://www.selenium.dev");
			System.out.println(driver.getTitle());
			System.out.println("swati updated the code with this statement");
			driver.close();
		}

	}


