package Pages;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class TaskEntry extends DriverClass {
	
	public By Subject = By.xpath("//input[@id='G15']");
	//public By StartDateTime = By.xpath("(//input[@class='form-control'])[2]");
	//public By EndDateTime  = By.xpath("(//input[@class='form-control'])[3]");
	public By TaskType = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Task Type')])//ancestor::div[1]/div//input");
	public By Details = By.xpath("//textarea[@class='entry_form_control form-control']");
	public By RemindOn = By.xpath("(//input[@class='form-control'])[4]");
	public By Priority = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Priority')])//ancestor::div[1]/div//input");
	public By Status = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Status')])//ancestor::div[1]/div//input");
	public By AssignTo = By.xpath("(//div[@class='css-1hwfws3'])[4]");
	public By StartcalancerIcon = By.xpath("(//input[@class='form-control'])[2]");
	public By EndcalancerIcon = By.xpath("(//input[@class='form-control'])[3]");
	public By RemindOncalendrIcon = By.xpath("(//input[@class='form-control'])[4]");
	public String taskSucessMessage = "Task created sucessfully";
	public String SubjectvalidationMessage = "Subject is required";
	public String AssignToValdiationMessage = "Please select Assigned To";
	public By SubjectValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Subject')])//ancestor::div[1]/div//span");
	public By AssignToValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//span");
	public By CheckBoxRecurring  = By.xpath("//span[contains(@class,'slds-checkbox--faux')]");
	public By FrequencyRecurring = By.xpath("(//div[@class='css-1hwfws3'])[5]");
	public By RepeatRecurring = By.xpath("(//div[@class='css-1hwfws3'])[6]");
	public By RepeatONRecurring = By.xpath("(//div[@class='css-1hwfws3'])[7]");
	public By StartDateReccur = By.xpath("(//input[@class='form-control'])[5]");
	public By EnddateReccut = By.xpath("(//input[@class='form-control'])[6]");
	
	
	

	PCUtility util = new PCUtility ();
	ExcelReader excel = new ExcelReader ();
	LeadListing leadlisting = new LeadListing();
	CalendarPC calendar = new CalendarPC();
	
	/**
	 * 
	 * @param sheetNo
	 * @param rowNo
	 * @throws InterruptedException
	 */
	public void createTask (int sheetNo,int rowNo) throws InterruptedException{
		Thread.sleep(3000);
		List<List<HSSFCell>> data = excel.getSheetData(sheetNo);
		for (int i = 1; i < data.size(); i++) {
			Thread.sleep(3000);
			List list = data.get(rowNo);
			for (int j = 0; j < list.size(); j++) {
				HSSFCell lang = (HSSFCell) list.get(list.size() -1);
				System.out.println(lang +"lang is ");
				HSSFCell cell = (HSSFCell) list.get(j);
				System.out.println(cell+"Cell is");
				System.out.println(j + "j is ");
				switch (j) {
				case 0:
					try {
						util.sendValue(driver.findElement(Subject), cell.getStringCellValue());		
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 1:
					try {
						util.sendValue(driver.findElement(Details), cell.getStringCellValue());		
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						util.handleDropdown(driver.findElement(TaskType), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						util.waitForElementAndClick(driver.findElement(StartcalancerIcon));	
						calendar.setDate(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
						Thread.sleep(3000);
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					break;
				case 4:
					try {
						util.waitForElementAndClick(driver.findElement(EndcalancerIcon));
						calendar.setDate(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						util.waitForElementAndClick(driver.findElement(RemindOncalendrIcon));
						calendar.setDate(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 6:
					try {
						util.handleDropdown(driver.findElement(Priority), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 7:
					try {
						util.handleDropdown(driver.findElement(Status), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				
				
				case 8:
					try {
						util.handleDropdown(driver.findElement(AssignTo), cell.getStringCellValue());
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
