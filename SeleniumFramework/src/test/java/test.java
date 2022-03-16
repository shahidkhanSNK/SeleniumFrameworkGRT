import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class test {

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
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/driverchrome/chromedriver.exe");
		driver = new ChromeDriver();
		
		// To maximize the browser window
		driver.manage().window().maximize();

	}
	
	@Test(priority = 0)
	public void opengrtsite()  throws InterruptedException, AWTException {
		
		ExtentTest test2 = extent.createTest("Open GRT Site", "This test is to open GRT portal");
		test2.log(Status.INFO, "Starting 1st test case");
		// To store URL in variable and then call this variable to open this URL
				String baseUrl1 = "https://accounts.google.com/ServiceLogin/webreauth?continue=https%3A%2F%2Fmail.google.com%2Fmail&sacu=1&passive=1209600&hl=en&acui=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin"; 
				driver.get(baseUrl1);
				TimeUnit.SECONDS.sleep(2);
				test2.pass("Navigated to GRTInsight Portal");

	}
	
	@Test(priority = 1)
	public void logingmail() throws InterruptedException, AWTException  {
		
		ExtentTest test3 = extent.createTest("Login GMAIL", "This test is to open GRT portal");
		test3.log(Status.INFO, "Starting 1st test case");
Thread.sleep(1000);
		
	    WebElement emailgmail= driver.findElement(By.id("identifierId"));
		
	    emailgmail.sendKeys("Shahid@troontechnologies.com");
	    
        Thread.sleep(3000);
		
	    WebElement nextt= driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		
	    nextt.click();
	    
        Thread.sleep(2000);
        WebElement passwordgmail= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		
        passwordgmail.sendKeys("doublestriker2021");
	    
        Thread.sleep(1000);
		
	    WebElement nexttt= driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		
	    nexttt.click();
	    
	    TimeUnit.SECONDS.sleep(20);
	    
	    // To open specific mail from Inbox
	    List<WebElement> a = driver.findElements(By.xpath("//span[@class='bog']"));
	    System.out.println(a.size());
	                for(int i=0;i<a.size();i++){
	                    System.out.println(a.get(i).getText());
	                    if(a.get(i).getText().equals("Fwd: Register user")){  // if u want to click on the specific mail then here u can pass it
	                    	a.get(i).click();
	                        TimeUnit.SECONDS.sleep(4);
	                    }}
	                        
	                        List<WebElement> link = driver.findElements(By.tagName("a"));
	                		int linkcount = link.size();
	                		System.out.println(linkcount);

	                		for (int b = 0; b < linkcount; b++) {

	                			System.out.println(link.get(b).getText());
	    	                    if(link.get(b).getText().equals("JOIN NOW")){
	    	                    	link.get(b).click();
	    	                    	TimeUnit.SECONDS.sleep(2);
	                		}
	                        
	                      
	        				test3.pass("Navigated to GRTInsight Portal");}
	                    
	    	                    }
	    

	                		@Test(priority = 2)
	                		public void logingrt() throws InterruptedException, AWTException  {
	                			
	                			ExtentTest test4 = extent.createTest("Test Case GRT", "This test is to find text fields dynamically");
	                			test4.log(Status.INFO, "Starting 3rd test case");
	                	Thread.sleep(1000);
	                	((JavascriptExecutor)driver).executeScript("window.open()");
	                    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	                    driver.switchTo().window(tabs.get(2));
	                	String baseUrl2 = "https://t1.grtinsight.com";
	                		    driver.get(baseUrl2);
	                		    TimeUnit.SECONDS.sleep(7);
	                		    
	                		    List<WebElement> textfields = driver.findElements(By.tagName("input"));
	                		    System.out.println(textfields.size());
	        	                for(int d=0;d<textfields.size();d++){
	        	                    System.out.println(textfields.get(d).getAttribute("type"));
	        	                    if(textfields.get(d).getAttribute("type").equals("email")){  
	        	                    	textfields.get(d).sendKeys("admin@grthealthonline.com");
	        	                        TimeUnit.SECONDS.sleep(4);
	        	                    }
	        	                    else    
	        	                    if(textfields.get(d).getAttribute("type").equals("password")){  
	        	                    	textfields.get(d).sendKeys("@Grthealthadmin2021#");
	        	                        TimeUnit.SECONDS.sleep(4);
	        	                }}
	        	                
	        	                driver.findElement(By.tagName("button")).click();
	        	                TimeUnit.SECONDS.sleep(4);

	}
	                		
	                		@Test(priority = 3)
	                		public void client() throws InterruptedException, AWTException  {
	                			
	                			ExtentTest test5 = extent.createTest("Test Case GRT", "This test is to find text fields dynamically");
	                			test5.log(Status.INFO, "Starting 3rd test case");
	                	Thread.sleep(1000);
	                	
	                	List<WebElement> icons = driver.findElements(By.tagName("i"));
            		    System.out.println(icons.size());
    	                for(int d=0;d<icons.size();d++){
    	                    System.out.println(icons.get(d).getAttribute("class"));
    	                    if(icons.get(d).getAttribute("class").equals("icon-clients")){  
    	                    	icons.get(d).click();
    	                        TimeUnit.SECONDS.sleep(4);
    	                    }}
    	                }
    	                
    	                @Test(priority = 4)
                		public void add_client() throws InterruptedException, AWTException  {
                			
                			ExtentTest test6 = extent.createTest("Test Case Add Client", "This test is to find text fields dynamically");
                			test6.log(Status.INFO, "Starting 4th test case");
    	                
    	                List<WebElement> buttons = driver.findElements(By.tagName("button"));
            		    System.out.println(buttons.size());
    	                for(int d=0;d<buttons.size();d++){
    	                    System.out.println(buttons.get(d).getText());
    	                    if(buttons.get(d).getText().equals("Add Client")){  
    	                    	buttons.get(d).click();
    	                        TimeUnit.SECONDS.sleep(4);
    	                    }}
	                	
	                		}
    	                
    	                
    	                @Test(priority = 5)
                		public void basic_info() throws InterruptedException, AWTException  {
                			
                			ExtentTest test7 = extent.createTest("Test Case to fill basic info form", "This test is to find text fields dynamically");
                			test7.log(Status.INFO, "Starting 4th test case");
    	                
    	                List<WebElement> fields = driver.findElements(By.tagName("input"));
            		    System.out.println(fields.size());
    	                for(int d=0;d<fields.size();d++){
    	                    System.out.println(fields.get(d).getAttribute("placeholder"));
    	                    if(fields.get(d).getAttribute("placeholder").equals("MR-123456789")){  
    	                    	fields.get(d).sendKeys("SS-123321111");;
    	                        TimeUnit.SECONDS.sleep(2);
    	                    }
    	                
    	                if(fields.get(d).getAttribute("placeholder").equals("Smith Christopher")){  
    	                    	fields.get(d).sendKeys("shahid khan");;
    	                        TimeUnit.SECONDS.sleep(4);
    	                    }
    	                
    	                if(fields.get(d).getAttribute("placeholder").equals("smithchristopher@gmail.com")){  
	                    	fields.get(d).sendKeys("shahid@troontechnologies.com");;
	                        TimeUnit.SECONDS.sleep(4);
	                    }
    	                
    	                if(fields.get(d).getAttribute("placeholder").equals("(000) 000-0000")){  
	                    	fields.get(d).sendKeys("1234567890");;
	                        TimeUnit.SECONDS.sleep(4);
	                    }
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
