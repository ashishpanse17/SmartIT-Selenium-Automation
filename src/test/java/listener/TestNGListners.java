package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners implements ITestListener{

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("***************************  Suite Test Finished  *********************** "+context.getName());;    
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("***************************  Suite Test Started  *********************** "+context.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult context) {
		// TODO Auto-generated method stub
		
		System.out.println("***************************  Test FailedButWithinSuccessPercentage  *********************** "+context.getName());
	}

	public void onTestFailure(ITestResult context) {
		// TODO Auto-generated method stub
		
		System.out.println("***************************  Test Failed  *********************** "+context.getName());
	}

	public void onTestSkipped(ITestResult context) {
		// TODO Auto-generated method stub
	
		System.out.println("***************************  Test Skipped  *********************** "+context.getName());
	}

	public void onTestStart(ITestResult context) {
		// TODO Auto-generated method stub
		System.out.println("*****************************  @Test globalSearch() Started **************** "+context.getName());
	}

	public void onTestSuccess(ITestResult context) {
		// TODO Auto-generated method stub
		
		System.out.println("***************************   @Test globalSearch() Sucessful  *************** "+context.getName());
	}

}
