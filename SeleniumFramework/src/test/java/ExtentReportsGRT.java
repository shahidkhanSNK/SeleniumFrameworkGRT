import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsGRT {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, AWTException{

		ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);
        
        ExtentTest test1 = extent.createTest("Open GRT Site", "This test is to open GRT portal");

        
     // To store this project's path
		  String projectPath = System.getProperty("user.dir");
		  System.out.println("projectPath: "+projectPath);
		
		// To set the property for Google Chrome drive, without it, it will throw an error
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// To maximize the browser window
		driver.manage().window().maximize();
		
		test1.log(Status.INFO, "Starting 1st test case");
		
		// To store URL in variable and then call this variable to open this URL
		String baseUrl1 = "https://t1.grtinsight.com/"; 
		driver.get(baseUrl1);
		TimeUnit.SECONDS.sleep(5);
		test1.pass("Navigated to GRTInsight Portal");
		
		// To find Email text area and then enter email address
        WebElement email= driver.findElement(By.id("email"));;
        TimeUnit.SECONDS.sleep(2);
		email.sendKeys("admin@grthealthonline.com");
		
		TimeUnit.SECONDS.sleep(2);
		
		// To find Password text area and then enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("@Grthealthadmin2021#");
		
		TimeUnit.SECONDS.sleep(2);
		
		// To find and click Sign in button
		WebElement signin  = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
		signin.click();
		
		
		test1.info("Test Completed");
		extent.flush();
	}

}
