package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TBase;

public class LoginPage  extends TBase{
	
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Pass;

	@FindBy(xpath="//input[@type='submit']")
	WebElement Click;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	/*
	 * public void login(String username, String password) {
	 * Username.sendKeys(username); Pass.sendKeys(password); Click.click(); }
	 */
	
	public void setName(String username)
	{
		Username.sendKeys(username);
	}

	public void setPass(String password)
	{
		Pass.sendKeys(password);
	}
	public void setClick()
	{
		Click.click();
	}
}
