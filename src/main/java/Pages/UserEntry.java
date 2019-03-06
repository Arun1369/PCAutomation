package Pages;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class UserEntry extends DriverClass{
	public PCUtility util = new PCUtility ();
	ExcelReader excel = new ExcelReader ();
	CalendarPC calendar = new CalendarPC();
	
	public By FirstName = By.xpath("//input[@id='SU1']");
	public By LastName = By.xpath("//input[@id='SU2']");
	public By Email = By.xpath("//input[@id='SU3']");
	public By UserId = By.xpath("//input[@id='SU5']");
	public By UserName = By.xpath("//input[@id='SU11']");
	public By Designation = By.xpath("//input[@id='SU12']");
	public By Department = By.xpath("//input[@id='SU13']");
	public By Mobile = By.xpath("//input[@id='SU14']");
	public By Address = By.xpath("//textarea[@id='SU6']");
	public By Country = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//input");
	public By State  = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'State')])//ancestor::div[1]/div//input");
	public By Profile = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Profile')])//ancestor::div[1]/div//input");
	public By Role = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Role')])//ancestor::div[1]/div//input");
	public By Note = By.xpath("//textarea[@id='SU17']");
	public By PostalCode = By.xpath("//input[@id='SU10']");
	public By Cancel = By.xpath("(//button[@class='pc_cancel'])[1]");
	public By ResetButton = By.xpath("(//button[@class='pc_cancel'])[2]");
	public By SaveandNew = By.xpath("(//button[@class='pc_cancel'])[3]");
	public By Save = By.xpath("//button[@class='pc_colorBtn']");
	public By FirstNameValidation = By.xpath("(//span[@class='help-block'])[1]");
	public By LastNameValidation = By.xpath("(//span[@class='help-block'])[2]");
	public String firstNameValidationMessage = "";
	public String lastNameValidationMessage ="";
	public String  UserCreateSucessMessage ="";
	public By UserNameValidation = By.xpath("(//span[@class='help-block'])[2]");
	public String userNameValidation ="";
	public By MobileNumberValidation =  By.xpath("(//span[@class='help-block'])[2]");
	public String mobileNumberValidationMessage ="";
	public By ProfileValidation =By.xpath("(//span[@class='help-block'])[2]");
	public String profileValidationMessage = "";
	public By DesignationValidation = By.xpath("(//span[@class='help-block'])[2]");
	public String designationvalidationMessage  = "";
	public By DepartmentValidation = By.xpath("(//span[@class='help-block'])[2]");
	public String departmentvalidationMessage  = "";
	
	
	
	
	
	
	public void createUser (int sheet, int row) throws InterruptedException{
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
				
						util.sendValue(driver.findElement(UserName), cell.getStringCellValue());
		
					break;
				case 1:
					try {
						util.sendValue(driver.findElement(FirstName), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 2:
					try {
						util.sendValue(driver.findElement(LastName), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
				case 3:
					try {
						util.sendValue(driver.findElement(Email), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 4:
					try {
						util.sendValue(driver.findElement(Designation), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 5:
					try {
						util.sendValue(driver.findElement(Department), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 6:
					try {
						util.sendValue(driver.findElement(PostalCode), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 7:
					try {
						util.handleDropdown(driver.findElement(Profile), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 8:
					try {
						util.handleDropdown(driver.findElement(Role), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 9:
					try {
						util.handleDropdown(driver.findElement(Country), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 10:
					try {
						util.handleDropdown(driver.findElement(State), cell.getStringCellValue());
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
