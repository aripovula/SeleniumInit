import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormTesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize() ;
		
//		FormTesting ins = new FormTesting();

		Select sel = new Select(driver.findElement(By.cssSelector("select[id*='_mainContent_DropDownListCurrency']")));
		sel.selectByValue("AED");
		sel.selectByIndex(1);
		sel.selectByVisibleText("USD");

		driver.findElement(By.id("divpaxinfo")).click();

//		ins.timeout();

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
				
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.cssSelector("input[id*='_mainContent_ddl_originStation'")).click();
		// USING XPATH inside of XPATH
		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_originStation1_CTNR\']//*[@value=\'DEL\']")).click();
//		ins.timeout();
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"]//*[@value=\"BOM\"]")).click();

		// INPUT RADIO - standard radio

//		ins.timeout();

		// WebElement student =
		// driver.findElement(By.cssSelector("#ctl00_mainContent_chk_StudentDiscount"));
		// student.click();

		// WebElement type =
		// driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1"));
		// type.click();

//		ins.timeout();
		int size = driver.findElements(By.cssSelector("input[name='ctl00$mainContent$rbtnl_Trip']")).size();

		WebElement nextOne = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(1);
		for (int i = 0; i < size - 1; i++) {
			nextOne = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(i);
			System.out.println("Size - " + size + "  i = " + i + " text - " + nextOne.getAttribute("value"));
			nextOne.click();
		}
		
		WebDriverWait expwait = new WebDriverWait(driver, 10);
		expwait.until(ExpectedConditions.elementToBeSelected(nextOne));


		WebElement ele = driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']//*[contains(@class, \'ui-state-highlight\')]"));

		// from
		// https://stackoverflow.com/questions/43868009/how-to-resolve-elementnotinteractableexception-element-is-not-visible-in-seleni
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

//	void timeout() {
//		try {
//			Thread.sleep(400l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

}
