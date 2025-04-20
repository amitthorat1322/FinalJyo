package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TBase {

	protected static WebDriver driver;
	

	public void initalization()
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://wpdatatables.com/documentation/table-examples/statistics-table/");
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	

	public void tearDown()
	{
		if(driver != null)
		{
		driver.quit();
		}
	}
}
