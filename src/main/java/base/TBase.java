package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TBase {

	protected static WebDriver driver;
	
	@BeforeSuite
	public void initalization()
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://wpdatatables.com/documentation/table-examples/statistics-table/");
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterSuite
	public void tearDown()
	{
		if(driver != null)
		{
		driver.quit();
		}
	}
}
