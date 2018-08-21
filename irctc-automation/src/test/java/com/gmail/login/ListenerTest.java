package com.gmail.login;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.gmail.base.StartBrowser;
import com.gmail.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class ListenerTest extends StartBrowser implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		logger = report.startTest(result.getName());
		logger.log(LogStatus.INFO, result.getName() + " test case started.");
		System.out.println(result.getName() + ": test case started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		logger.log(LogStatus.INFO, result.getName() + " test case passed.");
		report.endTest(logger);
		report.flush();
		System.out.println("The name of the testcase passed is :" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// System.out.println("The name of the testcase failed is
		// :"+result.getName());
		if (ITestResult.FAILURE == result.getStatus()) {
			logger.log(LogStatus.FAIL, "Failed test case is " + result.getName());
			// logger.log(LogStatus.FAIL, "Test Case Failed is " +
			// result.getThrowable());
			// To capture screenshot path and store the path of the screenshot
			// in the string "screenshotPath"
			// We do pass the path captured by this method in to the extent
			// reports using "logger.addScreenCapture" method.
			String screenshotPath = null;
			try {
				screenshotPath = Utility.getScreenshot(driver, result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// To add it in the extent report
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		report.endTest(logger);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase skipped is :" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
