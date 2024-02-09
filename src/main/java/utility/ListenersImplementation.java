package utility;

import java.util.HashMap;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.TestBase;

public class ListenersImplementation extends TestBase implements ITestListener {

    private Map<String, ExtentTest> testMap = new HashMap<>();

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        test.log(Status.PASS, "Test Case: " + methodName + " has Passed");
        log.info("Test Case: " + methodName + " has Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        test.log(Status.FAIL, "Test Case: " + methodName + " has Failed");
        test.log(Status.FAIL, result.getThrowable());
        TestUtil.captureScreenshot(methodName);
        log.info("Test Case: " + methodName + " has Failed and Screenshot saved successfully");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        log.info("Quitting the driver");
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String author = result.getTestContext().getCurrentXmlTest().getParameter("author");

        if (!testMap.containsKey(methodName)) {
            ExtentTest extentTest = extent.createTest(methodName).assignAuthor(author);
            testMap.put(methodName, extentTest);
        }
        test = testMap.get(methodName);
        log.info(methodName + " has started");
    }


}
