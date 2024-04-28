package appllicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
	// define repository for add customer
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement objclickcustomerlink;
	@FindBy(xpath ="(//span[contains(@data-caption,'Add')])[1]")
	WebElement objclickaddicon;
	@FindBy(xpath = "//input[@id='x_Customer_Number']")
	WebElement objcustomernumber;
	@FindBy(xpath="//input[@id='x_Customer_Name']")
	WebElement objcustomername;
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement objaddress;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement objcity;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement objcountry;
	@FindBy(xpath = "//input[@id='x_Contact_Person']")
	WebElement objcontactperson;
	@FindBy(xpath = "//input[@id='x_Phone_Number']")
	WebElement objphonenumber;
	@FindBy(xpath = "//input[@id='x__Email']")
	WebElement objemail;
	@FindBy(xpath = "//input[@id='x_Mobile_Number']")
	WebElement objmobilenumber;
	@FindBy(xpath = "//input[@id='x_Notes']")
	WebElement objnotes;
	@FindBy(id  = "btnAction")
	WebElement objadd;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement objconfirmok;
	@FindBy(xpath = "//button[@class='ajs-button btn btn-primary']")
	WebElement objalertok;
	@FindBy(xpath = "//button[@data-caption='Search Panel']")
	WebElement objsearchpannel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement objsearchtextbox;
	@FindBy(xpath ="//button[@id='btnsubmit']" )
	WebElement objsearchbutton;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
	//method for customer module
	public boolean customer_validate(String customernumber,String customername,
			String address,String city,String country,String contactperson,String phonenumber,
			String email,String mobilenumber,String notes) throws Throwable
	{
		objclickcustomerlink.click();
		objclickaddicon.click();
		String exp_data = objcustomernumber.getAttribute("value");
		objcustomername.sendKeys(customername);
		objaddress.sendKeys(address);
		objcity.sendKeys(city);
		objcountry.sendKeys(country);
		objcontactperson.sendKeys(contactperson);
		objphonenumber.sendKeys(phonenumber);
		objemail.sendKeys(email);
		objmobilenumber.sendKeys(mobilenumber);
		objnotes.sendKeys(notes);
		objadd.click();
		objconfirmok.click();
		objalertok.click();

		Thread.sleep(1000);
		if(!objsearchtextbox.isDisplayed())
			objsearchpannel.click();
		objsearchtextbox.clear();
		objsearchtextbox.sendKeys(exp_data);
		Thread.sleep(1000);
		objsearchbutton.click();
		Thread.sleep(1000);
		String act_data = webtable.getText();
		if(act_data.equals(exp_data))
		{
			Reporter.log("customer number is matching::"+exp_data+"     "+act_data,true);
			return true;
		}
else {
	Reporter.log("customer number is not  matching::"+exp_data+"     "+act_data,true);
	return false;
}




		
	}




}
