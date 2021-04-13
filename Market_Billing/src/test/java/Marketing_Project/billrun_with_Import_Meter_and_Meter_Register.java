package Marketing_Project;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Re_Useable.Assertion_Test;
import Re_Useable.Login_site;
import Re_Useable.Repo_testing;
import Re_Useable.csv_file;


public class billrun_with_Import_Meter_and_Meter_Register extends Login_site{
	
	JavascriptExecutor executor;
	Repo_testing action_obj;
	Assertion_Test Assertion_obj;
	public String resi;
	String success;
	DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
	Date date1=new Date();
	
	String prodate= dateformat.format(date1);

	public int random = (new Random()).nextInt(9000000) + 1000000;
	Random rand;
	public int random2 = (new Random()).nextInt(900) + 100;
	Random rand2;
	


	@Test(priority=0)
	public void Add_Customer_and_Service() throws Exception{

		action_obj = new Repo_testing(driver);
		Assertion_obj = new Assertion_Test(driver);
		executor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(1000);
		// Click on Customer tab.
		action_obj.Customertab().click();
		// Select Customer type
		Select custoemrType = new Select(action_obj.Customertype());
		custoemrType.selectByVisibleText("Others");
		// Select category
		Select category1 = new Select(action_obj.categoryopt());
		category1.selectByVisibleText("Residential");

		// Add cusotmer General Detail
		// input
		action_obj.entr_title().sendKeys("Mr");
		action_obj.entr_firstName().sendKeys("Paul");
		action_obj.enter_surname().sendKeys("Raven");
		// adding scripts for Version 7.0.37...............
		// Add Phone (BH)
		action_obj.PhoneBH().sendKeys("42" + random);
		// Add Phone (AH)
		action_obj.PhoneAH().sendKeys("40" + random);

		action_obj.Mobilenumber().sendKeys("43" + random);
		action_obj.Cemail().sendKeys("test_Resdnt3@yopmail.com");
		action_obj.Address1().sendKeys("Madirma R-Town");
		action_obj.City_Suburb().sendKeys("Mills NY");
		Select St = new Select(action_obj.Custmr_State());
		St.selectByValue("WA");

		action_obj.CustomenrPIN().sendKeys("1265");               
		executor.executeScript("window,scrollBy(0,1800)", "");

		Thread.sleep(3000);
		driver.findElement(By.id("accountManagementPlus")).click();
		executor.executeScript("window,scrollBy(0,1800)", "");

		// add Contrat Statrt Date
		action_obj.COntractStartDate().click();
		Thread.sleep(2000);
		action_obj.SelectToday().click();
		action_obj.Contract_Term().sendKeys("10");
		Thread.sleep(3000);
		executor.executeScript("window,scrollBy(0,400)", "");
		// Save Customer
		Thread.sleep(10000);
		action_obj.SaveCustomer().click();
		Thread.sleep(5000);
		// Select 'Save Only' Option
		action_obj.Select_SaveOnly().click();
		// Assertion on Customer Validation Message
		Assertion_obj.Assertion_Custoemrsave();

		// Change Status Details
		executor.executeScript("window,scrollBy(0,1800)", "");
		action_obj.ChangeStatusbtn().click();
		// Assertion On Popup
		Assertion_obj.Assertion_changestatuspopup();
		Select statustype = new Select(action_obj.ChangeStatuslist());
		statustype.selectByVisibleText("Active");

		action_obj.Reasonfields().sendKeys("Only For testing Residetial Type of Category");
	Thread.sleep(1000);
		action_obj.reasonSave().click();
		Thread.sleep(1000);
		Assertion_obj.Assertion_chngStatusmesg();
		 Thread.sleep(3000);
		action_obj.CloseButton().click();

		Thread.sleep(1000);
		executor.executeScript("window,scrollBy(0,-1800)", "");
		// Assertion_obj.Assertion_Statuscheck();
		Thread.sleep(3000);
		resi = driver.findElement(By.xpath("//label[@class='col-sm-12 control-label']/a")).getText();


		action_obj.CLickOverview().click();

		action_obj.RetailElec().click();


		// Add Service Type
		Select ServiceTyp = new Select(action_obj.ServiceType());
		ServiceTyp.selectByVisibleText("Electricity");
		Thread.sleep(1000);
		// Add Market Type
		Select markettyp = new Select(action_obj.SelectmarketTyp());
		//markettyp.selectByVisibleText("Retail");
		markettyp.selectByVisibleText("Off Market");
		Thread.sleep(1000);
//
		// Add NMI Number
		action_obj.NMISelct().sendKeys(random+"328");

		//	NMI = driver.findElement(By.cssSelector("input#NMI")).getText();
		//Thread.sleep(4000);
		Select planno = new Select(action_obj.Service_plan());
		//planno.selectByVisibleText("MktPlan_NetworkRate100");
		planno.selectByIndex(2);
		Thread.sleep(4000);

		executor.executeScript("window,scrollBy(0,200)", "");
		Thread.sleep(3000);
		action_obj.Moveindate_field().click();
		action_obj.MoveIn_Date().click();
		Thread.sleep(3000);

		executor.executeScript("window,scrollBy(0,400)", "");
		action_obj.StructurAddressTogglebtn().click();

		action_obj.Building_Name().sendKeys("Los angel");

		Select UnitType=new Select(action_obj.Unit_Type());
		UnitType.selectByVisibleText("Block");

		Select husesuffix=new Select(action_obj.HouseSufix());
		husesuffix.selectByVisibleText("V");
		//Add Sub Address
		action_obj.Suburb().sendKeys("Almor Distt 324");
		//Postal Code
		action_obj.postcode().sendKeys("15"+random);

		//Add State
		Select State=new Select(action_obj.State());
		State.selectByIndex(2);

		executor.executeScript("window,scrollBy(0,800)", "");
		action_obj.Add_Service().click();
		Thread.sleep(3000);
		//executor.executeScript("window,scrollBy(0,-1500)", "");
		success="Success! The Service has been created successfully.";
		Assert.assertEquals(success,"Success! The Service has been created successfully.");  
		Assertion_obj.Assertion_successmsgservice();

		action_obj.ServicesTab().click();
		Thread.sleep(3000);
		action_obj.SearchID1().sendKeys(random+"328");
		Assertion_obj.Assertion_serviceId1();
		Thread.sleep(3000);


	}

	@Test(priority=1)
	public void Import_Meter_Number() throws Exception{
		
		action_obj = new Repo_testing(driver);
		Assertion_obj = new Assertion_Test(driver);
		executor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		 String p=System.getProperty("user.dir")+"//TestData//Electricity - Meter Import Template.csv";
			
				String col="*Service ID, *Meter Serial Number, *Status, *Consumption Type, *Configuration, Multiplier, Constant, Hazard, Location, Additional Site Info, Meter Point ID, Next Scheduled Read Date, Manufacturer, Model, Meter Read Type, Route, Walk Order, *Meter Installation Type, *Date Connected"; 
						
			
				long serviceId=Long.parseLong(random+"328");
				
				String meterNo= "Meter"+random2;
				
		        csv_file.ImportMeterNumber(p, col, serviceId, meterNo,"Current", "Cumulative", "POS","", "", "", "", "","","", "","", "", "", "", "BASIC",  prodate);
		        
		       //Click on Admin Tab
				action_obj.Admin().click();
				executor.executeScript("window,scrollBy(0,900)", "");
		
				//Click on meter numbers tab
				action_obj.Meter_Numbers_Import().click();
		
				
		
				driver.navigate().refresh();
				// Click on the ManualRecurringCharge link under import setup
				Thread.sleep(5000);
				driver.findElement(By.id("btnbrowseFile")).click();
				Thread.sleep(10000);

		
				Runtime.getRuntime().exec(System.getProperty("user.dir") + "//TestData//Electricity - Meter Import Template.exe");
				Thread.sleep(5000);

				// description
				driver.findElement(By.id("attDesc")).sendKeys("Meter Number");
				Thread.sleep(3000);

				// Click on the Upload btn
				driver.findElement(By.xpath(".//*[contains(text(),'Upload File')]")).click();
				Thread.sleep(2000);
		 
				executor.executeScript("window.scrollBy(0,500)", "");

				// Click on the exceute link
				driver.findElement(By.xpath(".//i[@class='fa fa-play ']")).click();
				Thread.sleep(2000);
		
		

				// capture the alert
				driver.findElement(By.xpath(".//button[contains(text(),'OK')]")).click();
				Thread.sleep(2000);

				// asertion on message
				String Actualtext = driver.findElement(By.xpath(".//*[contains(text(),'Import Successful!')]")).getText();
				Assert.assertEquals(Actualtext, "Import Successful!");
			//Thread.sleep(23000);
		
		
		
		
		
		
		
		
	}
	
	
	

}
