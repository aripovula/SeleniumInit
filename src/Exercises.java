import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercises {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
//		WebElement el1 = driver.findElement(By.cssSelector("iframe[src=\'/resources/demos/droppable/default.html\']"));

		int size = driver.findElements(By.cssSelector("a")).size();
		System.out.println(size);
		
		
		// wait before quitting browser
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
