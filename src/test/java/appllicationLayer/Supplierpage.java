package appllicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Supplierpage {
	//define repository for add supplier
	@FindBy(xpath = "(//a[contains(text(),'Suppliers')])[2]")
	WebElement objclicksupplierlink;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement objclickaddicon;
	@FindBy(xpath = "//input[@id='x_Supplier_Number']")
	WebElement objsuppliernumber;
	@FindBy(xpath = "//input[@id='x_Supplier_Name']")
	WebElement objsuppliername;
	@FindBy(xpath = "//textarea[@id='x_Address']")
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
	@FindBy(xpath = "//textarea[@id='x_Notes']")
	WebElement objnotes;
	@FindBy(xpath = "//button[@id='btnAction']")
	WebElement objadd;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement objconfirmok;
	@FindBy(xpath = "(//button[contains(text(),'OK')])[6]")
	WebElement objalertok;
	@FindBy(xpath = "//span[@data-phrase='SearchBtn']")
	WebElement objsearchpannel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement objsearchtextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement objsearchbutton;
	@FindBy(xpath = "")
	WebElement webtable;
	//method for supplier module
	public boolean supplier_validate(String suppliernumber,String suppliername,
			String address,String city,String country,String contactperson,String phonenumber,
			String email,String mobilenumber,String notes) throws Throwable
	{
		objclicksupplierlink.click();
		objclickaddicon.click();
		String exp_data = objsuppliernumber.getAttribute("value");
		objsuppliername.sendKeys(suppliername);
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
			Reporter.log("supplier number is matching::"+exp_data+"     "+act_data,true);
			return true;
		}
		else {
			Reporter.log("supplier number is not  matching::"+exp_data+"     "+act_data,true);
			return false;
		}
	}
}
