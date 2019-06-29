import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercises {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
//		WebElement el1 = driver.findElement(By.cssSelector("iframe[src=\'/resources/demos/droppable/default.html\']"));

		// task 1 - get # of anchorlinks in the document
		int size = driver.findElements(By.cssSelector("a")).size();
		System.out.println("In document - " + size);
		
		// task 2 - get # of anchorlinks in the footer
		WebElement el1 = driver.findElement(By.id("gf-BIG"));
		int size2 = el1.findElements(By.tagName("a")).size();
		System.out.println("In footer - " + size2);
		
		// task 3 - get # of anchorlinks in the 1st column of footer
		WebElement el2 = driver.findElement(By.cssSelector("#gf-BIG > table > tbody > tr > td:nth-child(1) > ul"));
		int size3 = el2.findElements(By.tagName("a")).size();
		System.out.println("1st column footer - " + size3);

		// task 4 - click on each link and check if link works
		
		List<WebElement> links = el2.findElements(By.tagName("a"));
		for (int i = 0; i < size3; i++) {
			links.get(i)
			.sendKeys(Keys.chord(Keys.COMMAND, Keys.ENTER));
		}

		Set<String> ids = driver.getWindowHandles();
		List<String> ids2 = new ArrayList<>(ids);
		
		for (int i = 0; i < ids2.size(); i++) {
			String title = driver.switchTo().window(ids2.get(i)).getTitle();
			System.out.println(i + "th title - " + title);
	
			driver.switchTo().defaultContent();
		}
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);
	}

}
