package pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TBase;

public class DemoqaPage extends TBase{

	public DemoqaPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='card mt-4 top-card']")
	private List<WebElement> categoryCards;
	
	
	@FindBy(xpath = "//*[@class='accordion']/div[@class='element-group']")
	private List<WebElement> accordion;
	
	
	
	public List<String> getCategoryCards()
	{
		List<String> categoryNames = new ArrayList<>();

		System.out.println("List Size is:-"+categoryCards.size());
		
		for(WebElement list : categoryCards)
		{
			WebElement ss = list.findElement(By.xpath(".//descendant::h5"));
			 String categoryName = ss.getText().replaceAll("\\s*,\\s*", ","); // Normalize spaces around commas
	           
			System.out.println(" :-"+categoryName);
			categoryNames.add(categoryName);
		}
		 return categoryNames;

	}
	
	public List<String> clickOnAccordion()
	{
		driver.get("https://demoqa.com/elements");
		List<String> accordionSelect = new ArrayList<>();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("List Size is:-"+accordion.size());
		
		for(WebElement as : accordion)
		{
			WebElement asc = as.findElement(By.xpath(".//descendant::div[1]"));
			String casc = asc.getText().replaceAll("\\s*,\\s*", ","); 
			System.out.println("O/p:-"+casc);
			js.executeScript("arguments[0].scrollIntoView(true)", asc);
			asc.click();
			accordionSelect.add(casc);
		}
		
		return accordionSelect;
	}
	
	public void oneByOne(List<String> accordionList)
	{
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 for (String text : accordionList) {
	            System.out.println("Clicking on accordion item with text: " + text);
	            // Find the element with the corresponding text and click on it
	            WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[normalize-space(text())='" + text.trim() + "']")));
	            // Scroll into view and click the element
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView(true)", item);
	            item.click();  // Click on the accordion element again
	        }
	}
	
	 public void executeActions() {
	        // Get the list of clicked accordion items (texts)
	        List<String> accordionItems = clickOnAccordion();

	        // Pass the list of texts to the next method to process and click again
	        oneByOne(accordionItems);
	    }
}