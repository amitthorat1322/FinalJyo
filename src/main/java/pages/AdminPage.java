package pages;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import base.TBase;

public class AdminPage extends TBase {

	
	@FindBy(xpath="//*[@id='static-pagination']")
	private WebElement pagination;
	
	@FindBy(xpath="//*[@id='static-pagination']/child::nav/ul/li")
	private WebElement pagination_size;
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectPagination()
	{
	
		
	
	}
	
	
	
	

	
}
