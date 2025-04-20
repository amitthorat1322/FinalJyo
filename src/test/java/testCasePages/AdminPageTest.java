package testCasePages;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.TBase;
import pages.AdminPage;

public class AdminPageTest extends TBase{

	AdminPage adminpage;

	public void setup()
	{
		initalization();
		
		adminpage = new AdminPage();
		
	
	}
	
	@Test
		public void allcheck()
		{
			Alert a = driver.switchTo().alert();
			a.dismiss();
		
			
			
			
		}
	
	
	@Test
		public void cal()
		{
		
			WebElement ca = driver.findElement(By.xpath("//input[@id='table_1_range_from_2']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);document.body.style.zoom = '30%';", ca);
			WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
			w.until(ExpectedConditions.elementToBeClickable(ca));
			ca.click();
			
		
			
			ca.sendKeys("10/06/2014");
			ca.click();
			
		}
	
	
		@Test
		public void sendData()
		{
			
			
			String[] listofElement = {"Desk","amit","Grain"};
			
			List<WebElement> listEle = driver.findElements(By.xpath("//a[@role='option']/following::span[1]"));
			
			for(WebElement le : listEle)
			{
				String g = le.getText();
				System.out.println("-------------"+g);
				if(g.equals("1"))
				{
					le.click();
				}
			}
			
			for(String sd : listofElement)
			{
				WebElement s  = driver.findElement(By.xpath("//input[@placeholder='Search table']"));
				s.sendKeys(sd);
				
				
			WebElement table = driver.findElement(By.xpath("//*[@id='table_1']"));
			
			List<WebElement> headers = table.findElements(By.tagName("th"));
			
			for(WebElement header : headers)
			{
				System.out.println(header.getText());
			}
			
			List<WebElement> tablebody = driver.findElements(By.xpath("//tbody/tr"));
			
			for(WebElement trow : tablebody)
			{
				
				List<WebElement> tcols = trow.findElements(By.tagName("td"));
				
				for(WebElement tcol : tcols)
				{
						System.out.println(tcol.getText());					
				}
				
				System.out.println("-------------------------------------");
			}
			s.clear();
			}
			
		}
	
		@Test(enabled = false)
		public void Selectstatement()
		{
			
			
			boolean hasNext = true;
			
			while(hasNext)
			{
				WebElement table = driver.findElement(By.xpath("//*[@id='table_1']"));
	
				List<WebElement> headers = table.findElements(By.tagName("th"));
				
				for(WebElement header : headers)
				{
					System.out.println(header.getText());
				}
				
				List<WebElement> tablebody = driver.findElements(By.xpath("//tbody/tr"));
				
				for(WebElement trow : tablebody)
				{
					
					List<WebElement> tcols = trow.findElements(By.tagName("td"));
					
					for(WebElement tcol : tcols)
					{
						System.out.println(tcol.getText());
					}
					System.out.println("-------------------------------------");
				}
				
				
				
				if(hasNextButton())
				{
					WebElement nextB = driver.findElement(By.xpath("//*[@id='table_1_paginate']/child::*[@id='table_1_next']"));
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);document.body.style.zoom = '30%';", nextB);
				  //js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", nextButton);
					WebDriverWait ws = new WebDriverWait(driver, Duration.ofSeconds(10));
					ws.until(ExpectedConditions.elementToBeClickable(nextB)).click();
					waitForPageLoad();
				}
				else
				{
					System.out.println("End");
					hasNext = false;
					break;
				}
			}
			
			
		}

		 private void waitForPageLoad() {
		        // This method ensures that the page is fully loaded after the next page is clicked
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='table_1']")));  // Wait for product descriptions to load
		    }

		private boolean hasNextButton() {
			
			try {
				WebElement nextB = driver.findElement(By.xpath("//*[@id='table_1_paginate']/child::*[@id='table_1_next']"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true);", nextB);
				
				WebDriverWait ws = new WebDriverWait(driver, Duration.ofSeconds(10));
				ws.until(ExpectedConditions.visibilityOf(nextB));
			 return nextB.isDisplayed(); 
			}
			catch(NoSuchElementException e)
			{
				
			return false;
			}
		}
}
