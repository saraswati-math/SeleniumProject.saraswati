package fdPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {

	@Test
	public void case2() throws IOException {
		String name="saraswati is tester";
		int count = name.length();
		String[] name1 = name.split(" ");
		String rev ="";
	/*for(String s:name1) {
		System.out.println(s);
	}*/
		for (int i=name1.length-1;i>=0;i--) {
			rev+=(name1[i]+" ");
		}
		System.out.println(rev);
	}

	@Test
	public void case22() {
		String name="saraswati";
		int count=name.length();
		String rev ="";
		for (int i=count-1;i>=0;i--) {
			rev+=name.charAt(i);
		}
	}

}
