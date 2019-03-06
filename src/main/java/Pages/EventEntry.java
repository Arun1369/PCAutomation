package Pages;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class EventEntry extends DriverClass {
	public By Sujbect = By.xpath("//input[@id='G15']");
	public By Details = By.xpath("//textarea[@id='G19']");
	public By EventType = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Event Type')])//ancestor::div[1]/div//input");
	public By Location = By.xpath("//input[@id='G14']");
	public By AssignTo = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//input");
	
	public By ReminderBeforeEvent = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Reminder Before Event')])//ancestor::div[1]/div//input");
	public By AllDayEvent = By.className("react-toggle-track");
	public By StartDateTime = By.xpath("(//input[@class='form-control'])[2]");
	public By EndDateTime  = By.xpath("(//input[@class='form-control'])[3]");
	public String successMessage = "Save Success";
	public String commonValidationMessage = "Please enter reqiured fields";
	public String SubjectFieldvalError = "Subject is required";
	public String EventTypeFieldvalError = "Please select Event type";
	public String StartDateTimeFieldvalError = "Please enter Start date and time";
	public String EndDateTimeFieldvalError = "Please enter End date and time";
	public By SubjectValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Subject')])//ancestor::div[1]/div//span");
	public By EveneTypevaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Event Type')])//ancestor::div[1]/div//span");
	public By StartDateTimevalidation = By.xpath("(//span[@class='help-block'])[4]");
	public By EndDateTimeValidation = By.xpath("(//span[@class='help-block'])[5]");
	public By StartcalancerIcon = By.xpath("(//input[@class='form-control'])[2]");
	public By EndcalancerIcon = By.xpath("(//input[@class='form-control'])[3]");
	public By LocatinValdiationMessage = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Location')])//ancestor::div[1]/div//span");
	public String locationvalmessage = "";
	
	
	
	
	PCUtility util = new PCUtility ();
	ExcelReader excel = new ExcelReader ();
	LeadListing leadlisting = new LeadListing();
	CalendarPC calendar = new CalendarPC();
	

	public void createEvent (int sheetNo,int rowNo) throws InterruptedException{
		Thread.sleep(3000);
		List<List<HSSFCell>> data = excel.getSheetData(sheetNo);
		for (int i = 1; i < data.size(); i++) {
			Thread.sleep(3000);
			List list = data.get(rowNo);
			for (int j = 0; j < list.size(); j++) {
				HSSFCell lang = (HSSFCell) list.get(list.size() - 1);
				HSSFCell cell = (HSSFCell) list.get(j);
				switch (j) {
				case 0:
					try {
						util.sendValue(driver.findElement(Sujbect), cell.getStringCellValue());		
						
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
						util.handleDropdown(driver.findElement(EventType), cell.getStringCellValue());
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
						
					} catch (Exception e) {
						calendar.setDate(cell.getStringCellValue());
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 4:
					try {
						util.waitForElementAndClick(driver.findElement(EndcalancerIcon));	
						calendar.setDate(cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						util.sendValue(driver.findElement(Location),  cell.getStringCellValue());	
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				
				case 6:
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
	
	

