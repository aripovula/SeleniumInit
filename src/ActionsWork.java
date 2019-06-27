import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsWork {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement elHover = driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-2"));
		WebElement elSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		Actions a = new Actions(driver);
						
		a
		.moveToElement(elHover)
		.contextClick()
		.build().perform();

//		driver.findElement(By.cssSelector("#start > button")).click();

		a.moveToElement(elSearchBox)
		.click()
		.keyDown(Keys.SHIFT)
		.sendKeys("iPad")
		.doubleClick()
		
		.sendKeys(Keys.RETURN)
		.build().perform();

		
		// wait before quitting browser
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
