import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTestingSuggestiveDropList {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.id("fromCity")).click();
		try { Thread.sleep(400l); } catch (InterruptedException e) { e.printStackTrace(); }
		
		// USING RELATIVE PATH WITH PARENT
//		WebElement from = driver.findElement(By.xpath("//*[@id=\'react-autowhatever-1\']/parent::div/input[1]"));
		// USING OTHER ATTRIBUTE - PLACEHOLDER
		WebElement from = driver.findElement(By.xpath("//*[@placeholder=\'From\']"));
		from.clear();
		from.sendKeys("DEL");
		try { Thread.sleep(400l); } catch (InterruptedException e) { e.printStackTrace(); }
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
//		driver.findElement(By.id("toCity")).click();
		try { Thread.sleep(400l); } catch (InterruptedException e) { e.printStackTrace(); }
//		WebElement toC = driver.findElement(By.xpath("//*[@id=\'react-autowhatever-1\']/parent::div/input[1]"));
		// USING OTHER ATTRIBUTE - PLACEHOLDER
		WebElement toC = driver.findElement(By.xpath("//*[@placeholder=\'To\']"));
		try { Thread.sleep(400l); } catch (InterruptedException e) { e.printStackTrace(); }
		toC.clear();
		toC.sendKeys("BOM");
		toC.sendKeys(Keys.ARROW_DOWN);
		toC.sendKeys(Keys.ENTER);

		
//		try {
//			Thread.sleep(400l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		for (int i=0;i<3;i++) {
//			driver.findElement(By.id("hrefIncAdt")).click();	
//		}
//		
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		
//		driver.findElement(By.cssSelector("input[id*='_mainContent_ddl_originStation'")).click();
//		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_originStation1_CTNR\']//*[@value=\'DEL\']")).click();
//		try {
//			Thread.sleep(400l);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"]//*[@value=\"BOM\"]")).click();
		
		
		// SUGGESTIVE DROPDOWN
		
		

//		driver.quit();
	}

}
