package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import appllicationLayer.AdminLoginPage;
import appllicationLayer.AdminLogoutPage;

public class Apputil {
public static WebDriver driver;
public static Properties prop;
@BeforeTest
public static void setup() throws Throwable, Throwable
{
	prop= new Properties();
	prop.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//call admin login page class locators and methods
		AdminLoginPage login = PageFactory.initElements(driver,AdminLoginPage.class);//this  init elementswill intialize and access methods
		//call login method
		login.adminLogin("admin","master");
	}
	else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//call admin login page class locators and methods
		AdminLoginPage login = PageFactory.initElements(driver,AdminLoginPage.class);
		//call login method
		login.adminLogin("Admin","Qedge123!@#");
	}
	else {
		Reporter.log("browser value is not matching");
	}
}
@AfterTest
public static void teardown()
{
	AdminLogoutPage logout = PageFactory.initElements(driver, AdminLogoutPage.class);;
	//call logout method
	logout.adminlogout();
	driver.quit();
	
	}
}
