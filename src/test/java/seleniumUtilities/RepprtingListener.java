package seleniumUtilities;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.Sampleselenium.TestCase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RepprtingListener extends TestListenerAdapter {

	public static ExtentReports extentReport;
	public static ExtentTest test;
	public static ExtentSparkReporter sparkReporter;

	@Override
	public void onTestStart(ITestResult result) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String MyReport = "Test-Report-" + timestamp + ".html";
		extentReport = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + MyReport);
		sparkReporter.config().setReportName("Automation Results ");
		sparkReporter.config().setDocumentTitle("test Results");
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Tester", "Suneetha");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Success");
		test = extentReport.createTest(tr.getName());

	}

	@Override
	public void onTestFailure(ITestResult tr) {
		
		System.out.println(" get name" + tr.getName());
		extentReport.createTest(tr.getName());
		TakingScreenshot tc = new TakingScreenshot();
		System.out.println("tc object :: " +tc.toString());
		System.out.println(" tr get name :: " + tr.getName());
		tc.getScreenshot(BaseClass.driver, tr.getName());
		//String screenShotPath = getScreenshot(driver,tr.getName());
		//test.addScreenCaptureFromPath(screenShotPath);
		// test.log(LogStatus.fail, test.addScreencast(screenShotPath));

	}

	@Override
	public void onTestSkipped(ITestResult tr) {

	}

	@Override
	public void onFinish(ITestContext testContext) {
		extentReport.flush();
	}

	}
