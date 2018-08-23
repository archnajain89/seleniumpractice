package com.gmail.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCount = 0;
	private static int maxRetryCount = 2;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		 if (!result.isSuccess()) {                      //Check if test not succeed
	            if (retryCount < maxRetryCount) {                            //Check if maxtry count is reached
	            	retryCount++;                                     //Increase the maxTry count by 1
	            	System.out.println("retryCount"+retryCount);
	                result.setStatus(ITestResult.FAILURE);  //Mark test as failed
	                return true;                                 //Tells TestNG to re-run the test
	            } else {
	            	result.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
	            }
	        } else {
	        	result.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
	        }
		 System.out.println("Test");
	        return false;
	        

	}

}
