package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import appllicationLayer.CustomerPage;
import config.Apputil;
import utilities.Excelfileutilities;

public class AppTest extends Apputil{


	String inputpath ="./FileInput/customer.xlsx";
	String outputpath ="./FileOutput/DataDrivenResults.xlsx";
	String sheet ="customerdata";
	@Test
	public void  startest() throws Throwable
	{
		//create object for excel file util class
		Excelfileutilities xl = new Excelfileutilities(inputpath);
		//count number of rows in customer data sheet
		int rc =xl.rowcount(sheet);
		Reporter.log("no.of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String cname =xl.getcelldata(sheet, i, 0);
			String address=xl.getcelldata(sheet, i, 1);
			String city= xl.getcelldata(sheet, i, 2);
			String country=xl.getcelldata(sheet, i, 3);
			String contperson=xl.getcelldata(sheet, i, 4);
			String pnumber= xl.getcelldata(sheet, i, 5);
			String email=xl.getcelldata(sheet, i, 6);
			String mobnumber=xl.getcelldata(sheet, i, 7);
			String notes=xl.getcelldata(sheet, i, 8);
//call customer page class
			CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
		boolean  res =cus.customer_validate(cname, address, city, country, contperson, pnumber, email, mobnumber, notes, notes);
		//if res is true write as pass
		if(res)
		{
			xl.setcelldata(sheet, i, 9, "pass", outputpath);
		}
		//if res is false write as fail
		else {
			xl.setcelldata(sheet, i, 9, "fail", outputpath);
		}
		}

	}

}
