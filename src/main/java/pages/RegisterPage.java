package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TBase;

public class RegisterPage extends TBase {



	@FindBy(xpath="//input[@id='customer.firstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='customer.lastName']")
	WebElement lastName;
	@FindBy(xpath="//input[@id='customer.address.street']")
	WebElement Address;
	@FindBy(xpath="//input[@id='customer.address.city']")
	WebElement City;
	@FindBy(xpath="//input[@id='customer.address.state']")
	WebElement State;
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	WebElement ZipCode;
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	WebElement PhoneNumber;
	@FindBy(xpath="//input[@id='customer.ssn']")
	WebElement SSN;
	@FindBy(xpath="//input[@id='customer.username']")
	WebElement Username;
	@FindBy(xpath="//input[@id='customer.password']")
	WebElement Password;
	@FindBy(xpath="//input[@id='repeatedPassword']")
	WebElement RePassword;
	@FindBy(xpath="//input[@type='submit' and @value='Register']")
	WebElement RFormSubmit;
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void RegNewUser(String firstname,String lastname,String address,
			String city,String state,String zipcode,String phn,String sas,
			String uname,String pass,String repass)
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		ZipCode.sendKeys(zipcode);
		PhoneNumber.sendKeys(phn);
		SSN.sendKeys(sas);
		Username.sendKeys(uname);
		Password.sendKeys(pass);
		RePassword.sendKeys(repass);
		RFormSubmit.submit();
	}
}
