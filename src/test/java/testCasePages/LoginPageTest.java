package testCasePages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import base.TBase;
import pages.LoginPage;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoginPageTest extends TBase{

	LoginPage loginpage;
	
	@BeforeClass
	public void setup()
	{
		initalization();
		loginpage = new LoginPage();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	
	}
	
	@Test(priority = 1,enabled = false)
	public void validateCurrentUrl()
	{
		String cURL = loginpage.getCurrentUrl();
		AssertJUnit.assertEquals(cURL,"https://parabank.parasoft.com/parabank/index.htm");
	
	}
	
	@Test(dependsOnMethods = "vcheckInvalidLogin",enabled = false)
	public void validateTitle()
	{
	
		String TitleVerify = loginpage.getPageTitle();
		AssertJUnit.assertEquals(TitleVerify,"ParaBank | Errorsss");
		if (driver.getTitle().equals("ParaBank | Errorsss")) {
			System.out.println("YES");
			
		} 
		else
		{
			System.out.println("NO");
			
		}
		
	}
	@Parameters({"Username","Password"})
	@Test(enabled = false)
	public void validateLogin(String name,String pass)
	{
	//	loginpage.login("jyoti", "jyoti@123");
	/*
	 * loginpage.setName("amit"); loginpage.setPass("jyoti@123");
	 */
		loginpage.setName(name);
		loginpage.setPass(pass);
		loginpage.setClick();
		driver.navigate().back();
	}
	
	

	@Test(enabled=false)
	public void voidDtable() {

		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
			WebElement s = driver.findElement(By.xpath("//table[@class='dataTable']"));
			
			List<WebElement> trow = s.findElements(By.tagName("tr"));
			
			int rowCount = trow.size();
			System.out.println("Tr:-"+rowCount);
			List<WebElement> thead = s.findElements(By.tagName("th"));
			
			for(int head = 0;head<thead.size();head++)
			{
				System.out.println("Head is:-"+thead.get(head).getText());
			}
			for(int i=0;i<rowCount;i++)
			{
				List<WebElement> tcol = trow.get(i).findElements(By.tagName("td"));
				int colCount = tcol.size();
				System.out.println("Rows:-"+i+"Col:-"+colCount);
				for(int j=0;j<colCount;j++)
				{
					
					  String data = tcol.get(j).getText();
					  System.out.println("Cell Value of row number " + i + " and column number " +
					  j + " Is " + data);
					String data1 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td["+(j+1)+"]")).getText();
					String datas = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]")).getAttribute("td");
					System.out.println("asdasd:"+datas);
					System.out.println("Data is :-"+data1);
					
				}
	    	    System.out.println("-------------------------------------------------- ");
				
	    	    
			}
	}
	
	@Test(enabled=false)
	public void amazonDropdown()
	{
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=676742245123&hvpos=&hvnetw=g&hvrand=12706191631117004662&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062116&hvtargid=kwd-10573980&hydadcr=14453_2367553");

	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement dropd = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select sd = new Select(dropd);
		List<WebElement> dpd = sd.getOptions();
		  for(WebElement dropds : dpd)
		  { 
			  String   sg = dropds.getText(); 
			  System.out.println("Sg:-"+sg);
			  
			  
		  if(dropds.getText().contains("Baby")) { dropds.click(); } }
		 
	}
	@Test(enabled = false)
	public void wiki()
	{
		driver.get("https://www.wikipedia.org/");
		
		List<WebElement> s = driver.findElements(By.xpath("//nav[@class ='central-featured']/child::div[@dir='ltr']"));
		
		int c=s.size();
		System.out.println("Size is:-"+c);
		
		for(WebElement ck : s)
		{
			if(ck.getAttribute("lang").contains("ja"))
			{
				ck.click();
				driver.navigate().back();
			}
		}
	}
	@Test(enabled=false)
	public void s() {
		driver.get("https://www.amazon.com/");
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.navigate().refresh();
		List<WebElement> s = driver.findElements(By.xpath("//*[starts-with(@id,'desktop')]"));
		
		System.out.println("s:-"+s.size());
		WebElement ssd =driver.findElement(By.xpath("//*[@class='a-cardui-header']/child::*[contains(text(),'Gaming accessories')]/preceding::div[starts-with(@id,'desktop')]/ancestor::div[@id='gw-layout']"));

			if (ssd.getText().contains("Gaming accessories")) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		
	}
	
	@Test(enabled=false)
	public void mytrip()
	{
		String expectedSearchTerm = "Pune, India";
		driver.get("https://www.makemytrip.com/flights/");
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement d = driver.findElement(By.xpath("//*[@id='fromCity']"));
	//	WebDriverWait s = new WebDriverWait(driver,120);
	//	s.until(ExpectedConditions.visibilityOf(d));
		d.click();
		WebElement placeholder =driver.findElement(By.xpath("//input[@type='text' and @placeholder='From'] "));
	       List<WebElement> autoSuggestionList = driver.findElements(By.xpath("//*[@role='option']/ancestor::div[@class='flt_fsw_inputBox searchCity inactiveWidget activeWidget']"));
	       	System.out.println("Cl:"+autoSuggestionList.size());
	       // to traverse the list and navigate to required suggestion search results
	       for (WebElement autoSuggestion : autoSuggestionList) {
	           System.out.println("Auto Suggestion Value : " + autoSuggestion.getText());
	           if (autoSuggestion.getText().equalsIgnoreCase(expectedSearchTerm)) {
	               System.out.println("\nFound required value in auto suggestion list. Clicking on it now\n");
	               placeholder.sendKeys(expectedSearchTerm);
	               autoSuggestion.click();
	               break;
	           }
	       }
	     
	       
	}
	
	@Test(enabled = false)
	public void checkTable() throws IOException
	{
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		WebElement totaltable = driver.findElement(By.xpath("//table[@class='dataTable']"));
	
		List<WebElement> totalRows = totaltable.findElements(By.tagName("tr"));
		
		System.out.println("Total Rows:-"+totalRows.size());
		
		for(int i=0;i<totalRows.size();i++)
		{
			List<WebElement> totalCols = totalRows.get(i).findElements(By.tagName("td"));
			
			int totalColsCount =  totalCols.size();
			System.out.println("Col Count :-"+totalColsCount);
			
			for(int j=0;j<totalColsCount;j++)
			{
			//	String s = totalCols.get(j).getText();
				if(totalCols.get(j).getText().contains("Deepak Fertilisers"))
				{
					String data12 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]")).getText();
					System.out.println("asdasd:"+data12);
				}		 
			}
		}
	}
	
	@Test(enabled=false)
	public void oranage() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/descendant::span[normalize-space()='Admin']")).click();
		
		
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("Amit");
		
		WebElement s = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--focus']"));
		
		Select ss = new Select(s);
		
		List<WebElement> sss = ss.getOptions();
		for(WebElement s2 : sss)
		{
			System.out.println("Selected is:"+s2.getText());
		}
		
		Thread.sleep(30000);
		
	}
	
	@Test(enabled=false)
	public void validatePageDetails() throws AWTException
	{
		  driver.get("https://demoqa.com/browser-windows");

	        // Open new child window within the main window
	        driver.findElement(By.id("windowButton")).click();

	        //Get handles of the windows
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        //System.out.println("Size:-"+allWindowHandles.size());
	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	            	System.out.println("S:-"+ChildWindow);
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                WebElement text = driver.findElement(By.id("sampleHeading"));
	                System.out.println("Heading of child window is " + text.getText());
	            }
	        }
	        
	        
	}
}


