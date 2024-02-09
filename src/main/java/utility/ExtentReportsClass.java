package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.TestBase;

public class ExtentReportsClass extends TestBase{

	public static ExtentReports setupExtentReports() {
		extent = new ExtentReports();
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + TestUtil.getDateTime() + ".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		extent.attachReporter(sparkReport);
		return extent;
	}	
}

















