import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleJavaAlert {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		
		driver.findElement(By.cssSelector("input[value='Confirmation Alert']")).click();
		String tex = driver.switchTo().alert().getText();
		Assert.assertEquals(tex, "Are you sure you want to give us the deed to your house?");
		System.out.print(tex);
		// if we need to type 
		// driver.switchTo().alert().sendKeys("text");
		driver.switchTo().alert().accept();
		// if need to cancel
		// driver.switchTo().alert().dismiss();
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);

	}
}
