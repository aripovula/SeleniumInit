import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Selenium code
		
		// Create Driver obj for Chrome
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("http://yahoo.com");
		driver.findElement(By.cssSelector("#uh-search-box")).sendKeys("soap");
		driver.findElement(By.cssSelector("#uh-search-button")).click();
		driver.findElement(By.cssSelector("#uh-search-button")).click();
		

		driver.quit();
	}

}
