package Pages;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class AccountsEntry extends DriverClass{
	public String accountNamevalidationMessage ="Account Name is required";
	public String sourceValidatiionMessage = "Source is required";
	public String mobileNumberValidationMessage ="Please enter valida Mobile Number";
	public String designationValidationMessage = "Please enter valida designation";
	public String mobileNumbervalidationMessage = "Please enter valida Mobile Number";
	public By Departmentvalidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Department')])//ancestor::div[1]/div//span");
	public String departmentvalidationMessage = "";
	public By AccontName = By.xpath("//input[@id='A1']");
	public By WebSite = By.xpath("//input[@id='G7']");
	public By OfficeMobile = By.xpath("//input[@id='G9']");
	public By NoStaff = By.xpath("//input[@id='A6']");
	public By Fax = By.xpath("//input[@id='A7']");
	public By Desciption = By.xpath("//input[@id='G16']");
	public By Address = By.xpath("//input[@id='G10']");
	public By City = By.xpath("//input[@id='G12']");
	public By PostalCode = By.xpath("//input[@id='G14']");
	public By DeliveryAddress = By.xpath("//input[@id='A17']");
	public By CityDelivery = By.xpath("//input[@id='A18']");
	public By PostalCodeDelivery = By.xpath("//input[@id='A21']");
	public By FirstNameContact = By.xpath("//input[@id='G2']");
	public By LastNameContact = By.xpath("//input[@id='G3']");
	public By DepartmentContact = By.xpath("//input[@id='G30']");
	public By MobileContact = By.xpath("//input[@id='G31']");
	public By EmaileContact = By.xpath("//input[@id='G6']");
	public By FB = By.xpath("//input[@id='G33']");
	public By Twitter = By.xpath("//input[@id='G34']");
	public By Linkdin = By.xpath("//input[@id='G32']");
	public By Instagram = By.xpath("//input[@id='G35']");
	public By AccountType = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Account Type')])//ancestor::div[1]/div//input");
	public By Industry = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Industry')])//ancestor::div[1]/div//input");
	public By Source = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Source')])//ancestor::div[1]/div//input");
	public By AnualTurnover = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Annual Turnover')])//ancestor::div[1]/div//input");
	public By AssignedTo = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//input");
	public By CountryBilling = By.xpath("(//div[@class='css-1hwfws3'])[6]");
	public By StateBilling = By.xpath("(//div[@class='css-1hwfws3'])[7]");
	public By CountryDelivery = By.xpath("(//div[@class='css-1hwfws3'])[8]");
	public By StateDelivery = By.xpath("(//div[@class='css-1hwfws3'])[9]");
	public By Designation = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Designation')])//ancestor::div[1]/div//input");
	public By DecisionAuthority = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Decision Autority')])//ancestor::div[1]/div//input");
	public By Cancel = By.xpath("(//button[@class='pc_cancel'])[1]");
	public By ResetButton = By.xpath("(//button[@class='pc_cancel'])[2]");
	public By SaveandNew = By.xpath("(//button[@class='pc_cancel'])[3]");
	public By Save = By.xpath("//button[@class='pc_colorBtn']");
	public By AccountNameValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Account Name')])//ancestor::div[1]/div//span");
	public By WebSiteValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Web Site')])//ancestor::div[1]/div//span");
	public By PhoneNumberValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Office Phone')])//ancestor::div[1]/div//span");
	public By NoStaffValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'No of Staff')])//ancestor::div[1]/div//span");
	public By FaxValidation = By.xpath("(//span[@class='help-block'])[7]");
	public By FirstNameContactValidation =By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'First Name')])//ancestor::div[1]/div//span");
	public By LasrNameContactValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Last Name')])//ancestor::div[1]/div//span");
	public By EmailValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Email')])//ancestor::div[1]/div//span");
	public By MobileValidation =By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Mobile')])//ancestor::div[1]/div//span");
	public By SourceValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Lead Source')])//ancestor::div[1]/div//span");
	public By Designationvalidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Designation')])//ancestor::div[1]/div//span");
	public String AccountSucessMessage = "fdfgdfgdf";
	
	
	public PCUtility util = new PCUtility ();
	ExcelReader excel = new ExcelReader ();
	
	
	
	
	public void accountsCreate (int sheet, int row) throws InterruptedException{
		Thread.sleep(3000);
		List<List<HSSFCell>> data = excel.getSheetData(sheet);
		System.out.println(data.size());
		for (int i = 1; i < data.size(); i++) {	
			Thread.sleep(3000);
			List list = data.get(row);
			System.out.println();
			for (int j = 0; j < list.size(); j++) {
				HSSFCell lang = (HSSFCell) list.get(list.size() -1);
				System.out.println(lang +"lang is ");
				HSSFCell cell = (HSSFCell) list.get(j);
				System.out.println(cell+"Cell is");
				System.out.println(j + "j is ");
				switch (j) {
				case 0:
					
						util.sendValue(driver.findElement(AccontName), cell.getStringCellValue());
		
					break;
				case 1:
					try {
						util.sendValue(driver.findElement(WebSite), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				/*case 2:
					try {
						util.sendValue(driver.findElement(OfficeMobile), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}*/
				case 3:
					try {
						util.sendValue(driver.findElement(Address), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 4:
					try {
						util.sendValue(driver.findElement(City), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 5:
					try {
						util.sendValue(driver.findElement(PostalCode),  cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					try {
						util.sendValue(driver.findElement(FirstNameContact), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 7:
					try {
						util.sendValue(driver.findElement(LastNameContact), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 8:
				try {
					util.sendValue(driver.findElement(DepartmentContact), cell.getStringCellValue());
					
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
					break;
				/*case 9:
					try {
						util.sendValue(driver.findElement(MobileContact), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;*/
				case 10:
					try {
						util.sendValue(driver.findElement(EmaileContact), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 11:
					try {
						util.sendValue(driver.findElement(FB), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				
				case 12:
					try {
						util.sendValue(driver.findElement(Twitter), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;	
				case 13:
					try {
						util.handleDropdown(driver.findElement(Designation), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 14:
					try {
						util.handleDropdown(driver.findElement(CountryDelivery), cell.getStringCellValue());
						util.handleDropdown(driver.findElement(CountryBilling), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 15:
					try {
						util.handleDropdown(driver.findElement(StateDelivery), cell.getStringCellValue());
						util.handleDropdown(driver.findElement(StateBilling), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 16:
					try {
						util.handleDropdown(driver.findElement(Source), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 17:
					try {
						util.handleDropdown(driver.findElement(AssignedTo), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 18:
					try {
						util.handleDropdown(driver.findElement(AccountType), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 19:
					try {
						util.handleDropdown(driver.findElement(Industry), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;	
						
				default:
					break;
				}
			
			}
		
				
		}
		
}
	

}
