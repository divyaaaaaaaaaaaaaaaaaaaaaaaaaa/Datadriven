package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import appllicationLayer.Supplierpage;
import config.Apputil;
import utilities.Excelfileutilities;

public class AppTest1supplier extends Apputil {
	String inputpath = "./FileInput\\supplier.xlsx";
	String outputpath = "./FileOutput/SupplierDataDrivenResults";
	String sheet ="supplierdata";
	@Test
	public void starttest1() throws Throwable
	{
		
		//create object for excel file util class
		Excelfileutilities xl = new Excelfileutilities(inputpath);
		//count the number of rows in customer data sheet
		int rc = xl.rowcount(sheet);
		Reporter.log(sheet);
		for(int i=1;i<=rc;i++)
		{
			String sname =xl.getcelldata(sheet, i, 0);
			String address=xl.getcelldata(sheet, i, 1);
			String city= xl.getcelldata(sheet, i, 2);
			String country=xl.getcelldata(sheet, i, 3);
			String contperson=xl.getcelldata(sheet, i, 4);
			String pnumber= xl.getcelldata(sheet, i, 5);
			String email=xl.getcelldata(sheet, i, 6);
			String mobnumber=xl.getcelldata(sheet, i, 7);
			String notes=xl.getcelldata(sheet, i, 8);
//call supplier  page class
			Supplierpage  sup = PageFactory.initElements(driver, Supplierpage.class);
			boolean result = sup.supplier_validate(sname, address, city, country, contperson, pnumber, email, mobnumber, notes, notes);
			//if result is true write as pass
			if(result)
			{
				xl.setcelldata(sheet, i, 9, "pass", outputpath);
			}
			//if result is false write as fail;
			if(result)
			{
				xl.setcelldata(sheet, i, 9, "fail", outputpath);
			}
		}
	}
}
