import org.openqa.selenium.WebDriver;

public class WaitThreeSecondsAndClose {

	public void WaitAndClose(WebDriver driver) {
		// wait before quitting browser
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
