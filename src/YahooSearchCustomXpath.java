import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchCustomXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Selenium code
		
		// Create Driver obj for Chrome
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("http://yahoo.com");
		// using xpath relative to parent
		System.out.println(driver.findElement(By.xpath("//*[@id=\'Aside\']/div[2]/div[2]/div/div/div/div/h2/span/div")).getText());
		// using following-sibling
		System.out.println(driver.findElement(By.xpath("//*[@id=\'Aside\']/div[2]/div[2]/div/div/div/div/ul/li/ul/li/a/span/following-sibling::span[1]")).getText());
		// using parent
		System.out.println(driver.findElement(By.xpath("//*[@id=\'mega-bottombar\']/ul/li[2]/a/i/parent::a[1]")).getText());
		// get element with its text
		System.out.println(driver.findElement(By.xpath("//*[text()=\'Mail\']")).getText());
		

		driver.findElement(By.xpath("//*[@id=\'uh-search-box\']")).sendKeys("soap");
		// ???? using regex-contains
		driver.findElement(By.xpath("//input[contains(@id, \'uh-search-box\')]")).sendKeys("word");
		driver.findElement(By.xpath("//*[@id=\'uh-search-button\']")).click();

//		driver.findElement(By.linkText("More scores »")).click();
		

		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);

	}

}
