import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		driver.manage().window().maximize();

		// INPUT RADIO - standard radio
		// select round trip
		WebElement type = driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1"));
		type.click();
		
		driver.findElement(By.cssSelector("input[id*='_mainContent_ddl_originStation'")).click();
		// USING XPATH inside of XPATH
		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_originStation1_CTNR\']//*[@value=\'DEL\']")).click();

		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"]//*[@value=\"BOM\"]")).click();

		int size = driver.findElements(By.cssSelector("input[name='ctl00$mainContent$rbtnl_Trip']")).size();

		WebElement nextOne = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(1);
		for (int i = 0; i < size - 1; i++) {
			nextOne = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(i);
			System.out.println("Size - " + size + "  i = " + i + " text - " + nextOne.getAttribute("value"));
			nextOne.click();
		}

		WebDriverWait expwait = new WebDriverWait(driver, 10);
		expwait.until(ExpectedConditions.elementToBeSelected(nextOne));

		// if we need to select current date we can use below
//		WebElement ele = driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']//*[contains(@class,
								// \'ui-state-highlight\')]"));

		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();

		boolean monthFound = false;
		String month2find = "October";
		while (!monthFound) {
			WebElement calendarGroup = driver.findElement(By.id("ui-datepicker-div"));
			
			List<WebElement> months = calendarGroup.findElements(By.className("ui-datepicker-month"));
				if (!months.get(0).getText().equalsIgnoreCase(month2find)) {
					driver.findElement(By.cssSelector("span[class*='ui-icon-circle-triangle-e']")).click();
				} else {
					monthFound = true;
				}
			
		}
//		WebElement calendarGroup = driver.findElement(By.id("ui-datepicker-div"));
//		
//		int month = 0;
//		List<WebElement> months = calendarGroup.findElements(By.className("ui-datepicker-month"));
//		for (int i = 0; i < months.size(); i++) {
//			String dat = months.get(i).getText();
//			System.out.println(i + " -" + dat + '-');
//			if (dat.equalsIgnoreCase("July")) {
////				months.get(i).click();
//				month = i;
//			}
//		}
		
		WebElement firstGroup = driver.findElement(By.cssSelector("div[class*=\"ui-datepicker-group-first\"]"));
		WebElement lastGroup = driver.findElement(By.cssSelector("div[class*=\"ui-datepicker-group-last\"]"));

		List<WebElement> dates = firstGroup.findElements(By.className("ui-state-default"));
//		if (month == 1) dates = lastGroup.findElements(By.className("ui-state-default"));
		for (int i = 0; i < dates.size(); i++) {
			String dat = dates.get(i).getText();
			System.out.println(i + " -" + dat + '-');
			if (dat.equalsIgnoreCase("11")) {
				dates.get(i).click();
				break;
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].click();", dates.get(i));
			}
		}
		
		WebElement ddate = driver.findElement(By.id("ctl00_mainContent_view_date2"));

		expwait.until(ExpectedConditions.elementToBeClickable(ddate));
		ddate.click();

		WebElement firstGroup2 = driver.findElement(By.cssSelector("div[class*=\"ui-datepicker-group-first\"]"));
		
		List<WebElement> dates2 = firstGroup2.findElements(By.className("ui-state-default"));
		
		for (int i = 0; i < dates2.size(); i++) {
			String dat = dates2.get(i).getText();	
			System.out.println(i + " -" + dat + '-');
			if (dat.equalsIgnoreCase("21")) {
				dates2.get(i).click();
				break;
			}
		}

		WebElement passengerNumb = driver.findElement(By.id("divpaxinfo"));
		expwait.until(ExpectedConditions.elementToBeClickable(passengerNumb));
		passengerNumb.click();

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		Select sel = new Select(driver.findElement(By.cssSelector("select[id*='_mainContent_DropDownListCurrency']")));
		sel.selectByValue("AED");
		sel.selectByIndex(1);
		sel.selectByVisibleText("USD");
		
		WebElement student = driver.findElement(By.cssSelector("#ctl00_mainContent_chk_StudentDiscount"));
		student.click();

//		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

		WaitThreeSecondsAndClose w = new WaitThreeSecondsAndClose();
		w.WaitAndClose(driver);
	}

}
