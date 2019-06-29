import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Selenium code
		
		// Create Driver obj for Chrome
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("http://yahoo.com");
		driver.findElement(By.id("uh-search-box")).sendKeys("soap");
		driver.findElement(By.id("uh-search-button")).click();
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);

	}

}
