package riaadSeleniumFrameWork.TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import riaadSeleniumFrameWork.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReporterObject ();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); //Thread safe
//	Map<String, ExtentTest> testMap= new ConcurrentHashMap<>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		//int attempt= result.getMethod().getCurrentInvocationCount() + 1;
		//String testName=result.getMethod().getMethodName() + " (Attempt " + attempt + ")";
		//String key= result.getMethod().getMethodName() ;
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//assign unique id (errorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	//	String key=result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS,"Test Passed");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	//	test.log(Status.FAIL, "Test Failed");
		//String key=result.getMethod().getMethodName();
		extentTest.get().fail(result.getThrowable());
	//	currentTest.fail(result.getThrowable());
		
		try {
			WebDriver	driver=((BaseTest) result.getInstance()).getDriver();
			String filePath = getScreenShot(result.getMethod().getMethodName(),driver);
			extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	//screenshot, Attach to report

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		extent.flush();

	}
	
	

}
