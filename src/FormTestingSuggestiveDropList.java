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
		
		FormTestingSuggestiveDropList ins = new FormTestingSuggestiveDropList();
		
		driver.findElement(By.id("fromCity")).click();
		
		
		// USING RELATIVE PATH WITH PARENT
//		WebElement from = driver.findElement(By.xpath("//*[@id=\'react-autowhatever-1\']/parent::div/input[1]"));
		// USING OTHER ATTRIBUTE - PLACEHOLDER
		WebElement from = driver.findElement(By.xpath("//*[@placeholder=\'From\']"));
		from.clear();
		from.sendKeys("DEL");
		ins.timeout();
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
//		driver.findElement(By.id("toCity")).click();
		ins.timeout();
//		WebElement toC = driver.findElement(By.xpath("//*[@id=\'react-autowhatever-1\']/parent::div/input[1]"));
		// USING OTHER ATTRIBUTE - PLACEHOLDER
		WebElement toC = driver.findElement(By.xpath("//*[@placeholder=\'To\']"));
		ins.timeout();
		toC.clear();
		toC.sendKeys("BOM");
		ins.timeout();
		toC.sendKeys(Keys.ARROW_DOWN);
		ins.timeout();
		toC.sendKeys(Keys.ENTER);
		ins.timeout();
		WebElement selCity = driver.findElement(By.cssSelector("#toCity")); 
		String city = selCity.getAttribute("value");
		System.out.println("city-" + city);
		if (city.equalsIgnoreCase("Mumbai")) System.out.println("Match");
		

		
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
	
	void timeout() {
		try { Thread.sleep(400l); } catch (InterruptedException e) { e.printStackTrace(); }
	}

}
