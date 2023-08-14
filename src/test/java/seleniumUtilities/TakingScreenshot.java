package seleniumUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakingScreenshot {

	
	public String getScreenshot(WebDriver driver, String testmethod) {
        //TakesScreenshot ts = (TakesScreenshot) driver;
        //System.out.println(ts.toString());
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println( "Source File :: " + srcfile);
		String destination = System.getProperty("user.dir") + "/Screenshots/"+testmethod+".png";
		//File Destfile = new File(System.getProperty("user.dir") + "/test-output/" + testmethod );
		File Destfile = new File(destination);
		System.out.println( "Destination File :: " + Destfile);
		try {
			FileUtils.copyFile(srcfile, Destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
}
}