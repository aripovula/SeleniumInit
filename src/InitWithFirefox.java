	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class InitWithFirefox {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			// Selenium code
			
			// Create Driver obj for Chrome
					
			System.setProperty("webdriver.gecko.driver", "/Users/myfamily/Documents/00CurWorks/AllCode/Java/selenium-java-3/geckodriver");
			WebDriver driver =  new FirefoxDriver();
			driver.get("http://yahoo.com");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getCurrentUrl().contains("https://www.yahoo.com"));
			driver.close();
		}

	}
