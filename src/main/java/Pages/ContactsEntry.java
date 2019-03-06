package Pages;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BasePackage.DriverClass;

public class ContactsEntry extends DriverClass{
	public By ContactID = By.name("C1");
	public By Salutation = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Salutation')])//ancestor::div[1]/div//input");
	public By Firstname = By.name("G2");
	public By LastName = By.name("G3");
	public By Accountname = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Account Name')])//ancestor::div[1]/div//input");
	public By Designation = By.name("f2022");
	public By Email = By.name("G6");
	public By ReportsTo =By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Reports To')])//ancestor::div[1]/div//input");
	public By Description = By.name("G16");
	public By AssignTo = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//input");
	public By Department = By.name("C1");
	public By DecisionAuthority = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Decision Authority')])//ancestor::div[1]/div//input");
	public By Fax = By.name("C13");
	public By OfficeMobile = By.name("G9");
	public By MobileNumber = By.name("G31");
	public By Address = By.name("G10");
	public By Country = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Country')])//ancestor::div[1]/div//input");
	public By State = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'State')])//ancestor::div[1]/div//input");
	public By City = By.name("G12");
	public By PostalCode = By.name("G14");
	public By FB = By.name("G33");
	public By Twitter = By.name("G34");
	public By Linkdin = By.name("G32");
	public By Instagram = By.name("G35");
	public By Cancel = By.xpath("(//button[@class='pc_cancel'])[1]");
	public By ResetButton = By.xpath("(//button[@class='pc_cancel'])[2]");
	public By SaveandNew = By.xpath("(//button[@class='pc_cancel'])[3]");
	public By Save = By.xpath("//button[@class='pc_colorBtn']");
	public String  contactsSucessMessage = "Save Success";
	public String emailValidationMessage = "Invalid email is";
	public String lastNamevaldiationMessage ="Last name is required";
	public By EmailFieldvalidationContacts = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Email')])//ancestor::div[1]/div//span");
	public By ContactIdValidation = By.xpath("(//span[@class='help-block'])[1]");
	public By FirstNameValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'First Name')])//ancestor::div[1]/div//span");
	public By LastNamevalidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Last Name')])//ancestor::div[1]/div//span");
	public By AccountNameValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Account Name')])//ancestor::div[1]/div//span");
	public By DesignationValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Desigantion')])//ancestor::div[1]/div//span");
	public By DepartmentValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Department')])//ancestor::div[1]/div//span");
	public By OfficeNumberValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Office Number')])//ancestor::div[1]/div//span");
	public By MobileNumbervalidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Mobile Number')])//ancestor::div[1]/div//span");
	public By PostalCodeValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Postal Code')])//ancestor::div[1]/div//span");
	public By FaceBookValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'faceBook')])//ancestor::div[1]/div//span");
	public By TwitterValidation = By.xpath("(//span[@class='help-block'])[22]");
	public By LinkidinValidation = By.xpath("(//span[@class='help-block'])[23]");
	public By InstagramValidation = By.xpath("(//span[@class='help-block'])[24]");
	public String firstNameValidationMessage = "Please enter valida first name";
	public String DesignationValidationMessage = "Please enter valida designation";
	public String DepartmentValidationMessage ="Please enter valida department";
	public String OfficeNumberValidationMessage = "Please enter valid office Number";
	public String mobileNumbervalidationMessage = "Please enter valid mobile number";
	public String postalCodevalidationMessage = "Please enter valid postal code";
	
	
			
	
	
	
	
	ContactsListing contsctlist = new ContactsListing ();
	public PCUtility util = new PCUtility ();
	ExcelReader excel = new ExcelReader ();
	
	
	
	@Test 
	public void contactsCreate (int sheet, int row) throws InterruptedException{
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
						try {
							util.handleDropdown(driver.findElement(Salutation),cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + " : " + i);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 1:
						try {
							util.sendValue(driver.findElement(Firstname), cell.getStringCellValue());		
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
					
							util.sendValue(driver.findElement(LastName), cell.getStringCellValue());		
							
						
						break;
					case 3:
						try {
							util.sendValue(driver.findElement(Accountname), cell.getStringCellValue());		
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						try {
							util.sendValue(driver.findElement(Designation), cell.getStringCellValue());		
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 5:
						try {
							util.sendValue(driver.findElement(ReportsTo),  cell.getStringCellValue());
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					/*case 6:
						try {
							util.sendValue(driver.findElement(MobileNumber),  cell.getStringCellValue());
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							
						}
						break;
						*/
					case 7:
						try {
							util.sendValue(driver.findElement(Email), cell.getStringCellValue());		
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							
						}
						break;
					case 8:
						try {
							util.sendValue(driver.findElement(Department), cell.getStringCellValue());		
							
						} catch (Exception e) {
							
						}
						break;
					case 9:
						try {
							util.sendValue(driver.findElement(Address), cell.getStringCellValue());		
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 10:
						try {
							util.handleDropdown(driver.findElement(Country), cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + " : " + i);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 11:
						try {
							util.handleDropdown(driver.findElement(State), cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + " : " + i);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					
					case 12:
						try {
							util.handleDropdown(driver.findElement(City), cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + " : " + i);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 13:
						try {
							util.sendValue(driver.findElement(PostalCode), cell.getStringCellValue());
							
						} 
						catch (Exception e) {
							// TODO Auto-generated catch block
							
						}
						break;
						
					case 14:
						try {
							util.handleDropdown(driver.findElement(DecisionAuthority), cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + " : " + i);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 15:
						try {
							util.sendValue(driver.findElement(FB), cell.getStringCellValue());	
							System.out.println("fb"+i);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
						break;
						
					case 16:
						try {
							util.handleDropdown(driver.findElement(AssignTo), cell.getStringCellValue());
							System.out.println(cell.getStringCellValue() + " : " + i);
							
						} catch (Exception e) {
						
						}
						break;
					case 17:
						try {
							util.sendValue(driver.findElement(Twitter), cell.getStringCellValue());	
							return;	
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




