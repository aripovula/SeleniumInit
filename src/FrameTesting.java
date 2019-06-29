import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement el1 = driver.findElement(By.cssSelector("iframe[src=\'/resources/demos/droppable/default.html\']"));
		driver.switchTo().frame(el1);
		// or we can use
		// driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		source.click();
		
		Actions a = new Actions(driver);
		
		a.dragAndDrop(source, target).build().perform();
		
		// to change focus to main page (not frame) we should do this
		driver.switchTo().defaultContent();
		
//		WebElement elSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
//		
//		Actions a = new Actions(driver);
//		
//		a.moveToElement(elSearchBox)
//			.click()
//			.keyDown(Keys.SHIFT)
//			.sendKeys("iPad")
//			.doubleClick()
//			
//			.sendKeys(Keys.RETURN)
//			.build().perform();
//		
//		Set<String> ids = driver.getWindowHandles();
//		List<String> ids2 = new ArrayList<>(ids);
//		System.out.println(ids2.get(1));
//		driver.switchTo().window(ids2.get(1));
//		
//
//		WebElement el1 = driver.findElement(By.cssSelector("img[data-image-index='0']"));
//		
//		el1.click();
		
		
		
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);
	}

}
