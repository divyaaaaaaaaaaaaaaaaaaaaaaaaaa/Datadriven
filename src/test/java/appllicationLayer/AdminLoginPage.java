package appllicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
//define repository
	@FindBy(xpath="//button[@id='btnreset']")
	WebElement objreset;
	@FindBy(xpath="//input[@id='username']")
	WebElement objuser;
	@FindBy(xpath= "//input[@id='password']")
	WebElement objpswd;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement objlogin;
	//write a method 
	public void adminLogin(String user,String pswd)
	{
		objreset.click();
		objuser.sendKeys(user);
		objpswd.sendKeys(pswd);
		objlogin.click();
		
	}
	
	
}
