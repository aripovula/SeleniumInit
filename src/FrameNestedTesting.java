import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameNestedTesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement el1 = driver.findElement(By.xpath("/html/frameset"));
		WebElement el2 = driver.findElement(By.cssSelector("frame[name=\'frame-bottom\']"));
		driver
		// it looks like FrameSet does not need to be switched to
//		.switchTo()
//		.frame(el1)
		.switchTo()
		.frame(el2);
		
		System.out.print(driver.findElement(By.cssSelector("body")).getText());
		// or we can use
		// driver.switchTo().frame(0);
		
		
		// to change focus to main page (not frame) we should do this
		driver.switchTo().defaultContent();		
		
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);		
	}
}
