package Pages;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class OpportunityEntry extends DriverClass {
	public By OpportunityName = By.xpath("//input[@id='O1']");
	public By AccountName = By.xpath("//input[@id='G18']");
	public By Description = By.xpath("//textarea[@id='G16']");
	public By ClosedByDate = By.xpath("//div[@class='rdt rdtOpen']//input[@type='text']");
	public By Amount = By.xpath("//input[@id='counter-input-1']");
	public By AssignTo = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//input");
	public By Status = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Status')])//ancestor::div[1]/div//input");
	public By Stage = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Stage')])//ancestor::div[1]/div//input");
	public By Source = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Source')])//ancestor::div[1]/div//input");
	public By Probability = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Probability')])//ancestor::div[1]/div//input");
	public By Cancel = By.xpath("(//button[@class='pc_cancel'])[1]");
	public By ResetButton = By.xpath("(//button[@class='pc_cancel'])[2]");
	public By SaveandNew = By.xpath("(//button[@class='pc_cancel'])[3]");
	public By Save = By.xpath("//button[@class='pc_colorBtn']");
	public By pipeline = By.xpath("//button[@class='pc_colorBtn']");
	public By OpportunityNamevaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Opportunity Name')])//ancestor::div[1]/div//span");
	public By AccountNamevaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Account Name')])//ancestor::div[1]/div//span");
	public By Amountvaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Amount')])//ancestor::div[1]/div//span");
	public String opportunitySucessMessage = "Opportunity Created Sucessfully";
	public String opportunityValidationMessage = "Opportunity Name is Reqiored";
	public String amountValidationMessage = "";
	public String accountNameValdiationMessage ="";
	
	
	
	
	
	public PCUtility util = new PCUtility ();
	ExcelReader excel = new ExcelReader ();
	CalendarPC calendar = new CalendarPC();
	
	
	
	public void opportunityCreate (int sheet, int row) throws InterruptedException{
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
				
						util.sendValue(driver.findElement(OpportunityName), cell.getStringCellValue());
		
					break;
				case 1:
					try {
						util.sendValue(driver.findElement(Amount), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 2:
					try {
						util.sendValue(driver.findElement(Description), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
				case 3:
					try {
						calendar.setDate(cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 4:
					try {
						util.sendValue(driver.findElement(AccountName), cell.getStringCellValue());
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					break;
				case 5:
					try {
						util.handleDropdown(driver.findElement(AssignTo), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					try {
						util.handleDropdown(driver.findElement(Probability), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:
					try {
						util.handleDropdown(driver.findElement(pipeline), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 8:
					try {
						util.handleDropdown(driver.findElement(Status), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 9:
					try {
						util.handleDropdown(driver.findElement(Stage), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 10:
					try {
						util.handleDropdown(driver.findElement(Source), cell.getStringCellValue());
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

	

