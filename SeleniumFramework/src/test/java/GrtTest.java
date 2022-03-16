import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GrtTest {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
	      // To store this project's path
		  String projectPath = System.getProperty("user.dir");
		  System.out.println("projectPath: "+projectPath);
		
		// To set the property for Google Chrome drive, without it, it will throw an error
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// To maximize the browser window
		driver.manage().window().maximize();
		
		// To store URL in variable and then call this variable to open this URL
		String baseUrl1 = "https://t1.grtinsight.com/"; 
		driver.get(baseUrl1);
		
		// To find Email text area and then enter email address
        WebElement email= driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]"));
		email.sendKeys("admin@grthealthonline.com");
		
		TimeUnit.SECONDS.sleep(2);
		
		// To find Password text area and then enter password
		WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/input[1]"));
		password.sendKeys("@Grthealthadmin2021#");
		
		TimeUnit.SECONDS.sleep(2);
		
		// To find and click Sign in button
		WebElement signin  = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
		signin.click();
		
		TimeUnit.SECONDS.sleep(20);
	}

}
