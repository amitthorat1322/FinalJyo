package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TBase;

public class PracticePage extends TBase{

	@FindBy(xpath="//*[@id='userForm']/descendant::*[@id='userName']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	private WebElement suserEmail; 
	
	@FindBy(xpath="//input[@id='currentAddress'")
	private WebElement currentAddress; 
	
	
	@FindBy(xpath="//input[@id='permanentAddress']")
	private WebElement permanentAddress;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement textBoxSubmit;
	
	@FindBy(xpath="//input[@id='tree-node']")
	private WebElement treeNode;
	
	@FindBy(xpath="//*[@id='tree-node-home']")
	private WebElement treeNodeHome;
	
	@FindBy(xpath="//*[@id='yesRadio']")
	private WebElement yesRadio;
	
	@FindBy(xpath="//*[@id='impressiveRadio']")
	private WebElement impressiveRadio;
	
	@FindBy(xpath="//*[@id='noRadio']")
	private WebElement noRadio;
	
	@FindBy(xpath="//*[@role='grid' and @class='rt-table']")
	private WebElement table;
	
	@FindBy(xpath="//*[@role='row' and @class='rt-tr']")
	private WebElement table_Header;
	
	
	@FindBy(xpath="//*[@class='rt-tbody']/child::*[@role='rowgroup']")
	private List<WebElement> trows;
	
	public void TextBox()
	{
		userName.sendKeys("Amit Jain");		
		suserEmail.sendKeys("ankit@gmail.com"); 
		currentAddress.sendKeys("Pune");
		permanentAddress.sendKeys("Maharashtra");
		textBoxSubmit.click();
	}
	
	 public String getUserNameValue() {
	        return userName.getAttribute("value");
	    }
	
	
	
	
}
