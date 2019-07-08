import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20276/ban-vs-ind-match-40-icc-cricket-world-cup-2019");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		List<WebElement> scores = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']")).findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));
		int summ = 0;
		int toAdd = 0;
		for (int i = 0; i < scores.size(); i++) {
			System.out.println("size - " + scores.get(i).getText()); 
			try {
				toAdd = Integer.parseInt(scores.get(i).getText());	
			} catch(NumberFormatException e) {
			}
			summ = summ + toAdd;
		}
		System.out.println("summ - " + summ);
		
		
		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);
	}
}