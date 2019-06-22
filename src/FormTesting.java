import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTesting {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.spicejet.com/");

		Select sel = new Select(driver.findElement(By.cssSelector("select[id*='_mainContent_DropDownListCurrency']")));
		sel.selectByValue("AED");
		sel.selectByIndex(1);
		sel.selectByVisibleText("USD");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		try {
			Thread.sleep(400l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i=0;i<3;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();	
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

//		driver.quit();
	}

}
