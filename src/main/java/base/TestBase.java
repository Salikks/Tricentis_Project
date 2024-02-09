package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportsClass;
import utility.TestUtil;

public class TestBase {
	
	public static ITestContext context;
	public static Logger log;
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\ansar\\eclipse-workspace\\Tricentis_Project\\"
					+ "src\\main\\java\\properties\\config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void intializeExtentReports() {
		extent = ExtentReportsClass.setupExtentReports();
	}
	
	@BeforeTest
	public void setUp() {
		log = LogManager.getLogger(TestBase.class);
	    String browserName = prop.getProperty("browser");
	    if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Browser instantiated");
	    } else if (browserName.equals("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        log.info("Firefox Browser instantiated");
	    }
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	    driver.get(prop.getProperty("url"));
	}
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
















