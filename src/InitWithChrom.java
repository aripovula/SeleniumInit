import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitWithChrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Selenium code
		
		// Create Driver obj for Chrome
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("http://google.com");
//		System.out.println(driver.getPageSource());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl().contains("https://www.google.com"));
		driver.get("http://yahoo.com");
		driver.navigate().back();
		driver.get("http://weather.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}

}
