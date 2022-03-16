import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GRTExtentreportTestNG {

	ExtentReports extent;
	ExtentSparkReporter spark;
	//private static WebDriver driver = null;
	WebDriver driver = null;

	@BeforeSuite
	public void setup() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);
		
	}
	
	@BeforeTest
	public void setuptest() {
		
		
		String projectPath = System.getProperty("user.dir");
		  System.out.println("projectPath: "+projectPath);
		
		// To set the property for Google Chrome drive, without it, it will throw an error
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// To maximize the browser window
		driver.manage().window().maximize();

	}

	@Test(priority = 0)
	public void info() {

		ExtentTest test1 = extent.createTest("Show Logs Info", "This test is to show loggers");
		test1.log(Status.INFO, "Test Logs");
		test1.info("This will show usage of info(details)");
		test1.pass("This test has been passed successfully");
		
	}
	
	@Test(priority = 1)
	public void opengrtsite()  throws InterruptedException, AWTException {
		
		ExtentTest test2 = extent.createTest("Open GRT Site", "This test is to open GRT portal");
		test2.log(Status.INFO, "Starting 1st test case");
		// To store URL in variable and then call this variable to open this URL
				String baseUrl1 = "https://t1.grtinsight.com/"; 
				driver.get(baseUrl1);
				TimeUnit.SECONDS.sleep(5);
				test2.pass("Navigated to GRTInsight Portal");

	}
	
	
	@Test(priority = 2)
	public void login()  throws InterruptedException, AWTException, NoSuchElementException, ElementNotVisibleException, ElementNotSelectableException, TimeoutException
 {
		
		ExtentTest test3 = extent.createTest("Login on GRT Site", "This test is to login into the GRT portal");
		test3.log(Status.INFO, "Starting 2nd test case");
		
		// To find Email text area and then enter email address
        WebElement email= driver.findElement(By.id("email"));;
        TimeUnit.SECONDS.sleep(2);
		email.sendKeys("admin@grthealthonline.com");
		
		TimeUnit.SECONDS.sleep(2);
		
		// To find Password text area and then enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("@Grthealthadmin2021#");
		
		TimeUnit.SECONDS.sleep(2);
		
		try {
		// To find and click Sign in button
		WebElement signin  = driver.findElement(By.xpath("///html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
		signin.click();
		TimeUnit.SECONDS.sleep(2);
		//String actual_msg = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/ul[1]/li[2]/p[1]")).getAttribute("innerHTML");
		//TimeUnit.SECONDS.sleep(2);
		//test3.log(Status.INFO, "validation is : " +actual_msg);
		//String expected_msg = "Error! Invalid credentials";
		//test3.fail("validation error found");
		test3.pass("Logged in Successfully");
		}
		catch(Exception exp) {
		test3.log(Status.INFO, "Exception is : " +exp.getMessage());
		test3.log(Status.INFO, "Cause is : " +exp.getCause());
		test3.log(Status.INFO, "Path is : " +exp.getStackTrace());
		
		//test3.log(Status.INFO, "printStackTrace()");
		test3.fail("Unable to Login due to above esception");
		System.out.println("Message is : "+exp.getMessage());
		System.out.println("Cause is : "+exp.getCause());
		exp.printStackTrace();
	
	}
	}
	
	
	@AfterTest
	public void teardowntest() {
		driver.close();
		driver.quit();
		
	}
	
	
	@AfterSuite
	public void teardown() {
		
		 extent.createTest("LogLevels")
         .info("Test Completed");
		//extent.info("Test Completed");
		extent.flush();

	}

}
