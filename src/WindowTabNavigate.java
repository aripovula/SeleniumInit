import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowTabNavigate {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement elSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(elSearchBox)
			.click()
			.keyDown(Keys.SHIFT)
			.sendKeys("iPad")
			.doubleClick()
			
			.sendKeys(Keys.RETURN)
			.build().perform();
		
		Set<String> ids = driver.getWindowHandles();
		List<String> ids2 = new ArrayList<>(ids);
		System.out.println(ids2.get(1));
		driver.switchTo().window(ids2.get(1));
		

		WebElement el1 = driver.findElement(By.cssSelector("img[data-image-index='0']"));
		
		el1.click();
		
		
		// driver.switchTo().defaultContent();
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);
	}

}
