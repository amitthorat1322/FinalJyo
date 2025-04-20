package testCasePages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TBase;
import pages.DemoqaPage;

public class DemoqaPageTest extends TBase {
	
	DemoqaPage demoqapage;
	
	@BeforeMethod
	public void setup(ITestResult result)
	{
		initalization();
		demoqapage = new DemoqaPage();
	}
	
	@Test(enabled=false)
	public void CategoryCardTest()
	{
		List<String> actualCategoryNames = demoqapage.getCategoryCards();
		List<String> ls = new ArrayList<>();
		ls.add("Elements");
		ls.add("Forms");
		ls.add("Alerts,Frame & Windows");
		ls.add("Widgets");
		ls.add("Interactions");
		ls.add("Book Store Application");
		Assert.assertEquals(actualCategoryNames, ls);
	}
	
	@Test
	public void SelectCategoryCardTest()
	{
		demoqapage.clickOnAccordion();
		
		demoqapage.executeActions();	
	}
	
	
}
