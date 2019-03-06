/*package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadListing;
import Pages.PCUtility;

interface testArun {
	
	 <class name="Testcases.ContactsTest" /> 
     <class name="Testcases.TaskTest" /> 

}
	
	
}
	*//**
	 * Debugging,Will be removed Once All test cases is completed 
	 *//*
	ExcelReader excel = new ExcelReader();
	PCUtility util = new PCUtility();
	LeadListing lead = new LeadListing ();
	LeadDetails leadDetails = new LeadDetails();
	
	public int rowCount;
	public int userRow;
	
	Logger log = Logger.getLogger("devpinoyLogger");
	
	//public WebElement leadStatst = lead.CreateLeadButtonInLIstingPage;
	

	public void waitForElementToBeDisplayed(WebElement element) {
		void createLead(int sheetNo, int rowNo) throws InterruptedException {
			Thread.sleep(3000);
			List<List<HSSFCell>> data = excel.getSheetData(sheetNo);
			List headerList = data.get(0);
			LeadListing().FirstName;
			for (int i = 1; i < data.size(); i++) {
				Thread.sleep(3000);
				List list = data.get(rowNo);
				System.out.println(list);
				// TEST CODE START 
				HashMap <String,String> linkedHashMap = new HashMap<String, String>(); 
				for (int l = 0; l < list.size(); l++){
					 linkedHashMap.put(headerList.get(l).toString(), list.get(l).toString());
				 }
				
				util.sendValue(driver.findElement(By.name("f102")), linkedHashMap.get("FirstName"));
				util.sendValue(driver.findElement(By.className("notif__message")), linkedHashMap.get("FirstName"));
				util.sendValue(driver.findElement(By.xpath("(//select[@class='entry_form_control form-control'])[2]");), linkedHashMap.get("FirstName"));
				util.sendValue(driver.findElement(entry.LastName), linkedHashMap.get("LastName"));
				util.sendValue(driver.findElement(entry.CompanyName), linkedHashMap.get("CompanyName"));
				util.sendValue(driver.findElement(entry.Designation), linkedHashMap.get("Designation"));
				util.sendValue(driver.findElement(entry.OfficeNumber), linkedHashMap.get("OfficeNumber"));
				util.sendValue(driver.findElement(entry.MobileNumber), linkedHashMap.get("MobileNumber"));
				util.sendValue(driver.findElement(entry.Email), linkedHashMap.get("Email"));
				util.sendValue(driver.findElement(entry.WebSite), linkedHashMap.get("WebSite"));
				System.out.println(linkedHashMap.get("Industry"));
				System.out.println(linkedHashMap.get("LastName"));
				
			}
		}
		
		
		
		/////////////////////////////////////////////////////Lead test cases//////////////////////////////////////////////
		package Testcases;

		import java.io.FileReader;

		import java.io.IOException;
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.Collection;
		import java.util.List;

		import javax.security.auth.callback.Callback;

		import org.json.simple.JSONObject;
		import org.json.simple.parser.JSONParser;
		import org.json.simple.parser.ParseException;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebElement;
		import org.testng.Assert;
		import org.testng.annotations.BeforeMethod;
		import org.testng.annotations.Test;
		import org.testng.asserts.SoftAssert;



		import BasePackage.DriverClass;
		import Pages.ContactsEntry;
		import Pages.EventEntry;
		import Pages.ExcelReader;
		import Pages.LeadDetails;
		import Pages.LeadEntry;
		import Pages.LeadListing;
		import Pages.PCUtility;
		import Pages.TaskEntry;


		public class LeadTest extends DriverClass{
			
			
			*//**
			 * Author : QA Team - Nichi in software solution pvt ltd 
			 * Lead Test Cases - 
			 *//*
			ExcelReader excel ;
			PCUtility util = new PCUtility();
			LeadListing lead = new LeadListing ();
			LeadEntry leadEntry = new LeadEntry();
			LeadDetails leadDetails = new LeadDetails ();
			public String customPageView1;
			boolean firstColumn,thirdColumn,fourthColumn,fifthColumn= false;
			BulkLeads bulk =new BulkLeads ();
			

			
			 void login() throws InterruptedException, IOException, ParseException {
				excel = new ExcelReader();
				util.login(excel.readFromExcel(1, 1, 1), excel.readFromExcel(1, 2, 1));
			
			}
				
			
			
			
			

			
			*//**
			 * leadTable = Lead React table
			 * leadName = excel.readFromExcel(1, 1, 1); = Lead name from Excel sheet
			 * windowHandle = Window handler for switching to New tab 
			 * softAssert = Assert more than one value
			 * leadStatusBeforRefresh = Verifying the Lead before create 
			 * switchToNewTab  = Switing to new Tab 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			 
			 void refresh () throws IOException, InterruptedException{ 
				Thread.sleep(3000);;
				String curentURl = driver.getCurrentUrl();
				util.switchToNewTab();
				util.switchbackToMainTab(1);
				driver.get(curentURl);
				Thread.sleep(3000);
				WebElement CreateButton = driver.findElement(lead.CreateLeadOption);
				util.waitForElementAndClick(CreateButton);
				bulk.createLead(0, 2);
				//Saving the state of of Action pop up
				statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
				util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
				Thread.sleep(3000);
				//Switch back to main tab
				util.switchbackToMainTab(0);
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				String leadNameAfterRefresh = util.loopColumnFindName(excel.readFromExcel(0, 1, 1)+""+excel.readFromExcel(0, 1, 2),driver.findElement(lead.LeadTable));
				Assert.assertEquals(leadNameAfterRefresh, excel.readFromExcel(0, 1, 1));
			}
			
			*//**
			 * Create Lead
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			 void createLead () throws InterruptedException, IOException{
				Thread.sleep(3000);
				WebElement CreateButton = driver.findElement(lead.CreateLeadOption);
				util.waitForElementAndClick(CreateButton);
				//Creating first lead from first row
				bulk.createLead(0, 1);
				util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
				String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				//Verifying the success message 
				Assert.assertEquals(sucessMessage, leadEntry.leadSucessMessage);
				Thread.sleep(3000);
				
			}
			
			 *//**
			  * bulk.createLead(0, 3) = Creating lead 0 = sheet number, 3 row number
			  * @throws InterruptedException
			  *//*
			 public boolean statusOfActionPopup;
			void saveAndNew () throws InterruptedException, IOException{
				driver.navigate().refresh();
				Thread.sleep(3000);
				WebElement CreateButton = driver.findElement(lead.CreateNewOption);
				util.waitForElementAndClick(CreateButton);
				//Creating third lead from 
				bulk.createLead(0, 3);
				util.waitForElementAndClick(driver.findElement(leadEntry.SaveandNewButton));
				Assert.assertEquals(statusOfActionPopup, true);
				//Trying Action pop up is present, create one more user and 
				try{
					if (statusOfActionPopup==true){
						bulk.createLead(0, 4);
						util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
					}

				}
				catch (Exception e){
			        util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
			        util.acceptAlert();
				}
				Thread.sleep(3000);
				util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
				int leadpostionOflaletstLeads = util.rowCount ;
				lasterPositionOfLeads = new Integer(leadpostionOflaletstLeads);
			}
			
			Integer lasterPositionOfLeads;
			void verifylateastLead() throws IOException{
				Assert.assertEquals(lasterPositionOfLeads, "1");
			}
			
			*//**
			 * recordSelection = Selecting 100 from record selction 
			 * leadname  = Verify lead in listing page, if lead available in listing page, its returns Lead name, else null
			 * util.loopColuumFindName  = Loop the React table and get the lead name
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws IOException
			 * @throws InterruptedException 
			 *//*
			 void verifyLeadsInListngPage () throws IOException, InterruptedException{
				util.recordSelection("100 rows");
				Thread.sleep(3000);
				SoftAssert leadsStatus = new SoftAssert ();
				String leadname1 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
				String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2), driver.findElement(lead.LeadTable));
				String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
				leadsStatus.assertEquals(leadname1, excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2));
				leadsStatus.assertEquals(leadname1, excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2));
				leadsStatus.assertEquals(leadname1, excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2));
				System.out.println("verifyLeadsInListngPagen value in the table are " + leadname1 +""+leadname2+""+leadname3);
				leadsStatus.assertAll();
				
				
			}
			
			
			*//**
			 * Verify Search 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * waitForElementAndClick  = Wait for the element and click once element is displayed
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			 void verifySearch () throws IOException, InterruptedException{
				SoftAssert search = new SoftAssert ();
				util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
				//Search for Second lead
				util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(0, 2, 1));
				Thread.sleep(4000);
				//verify Second lead is avilable in list
				String leadname = util.loopColumnFindName(excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2), driver.findElement(lead.LeadTable));
				System.out.println("testArun"+excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2));
				System.out.println("verifyLeadsInListngPagen value in the table are " + leadname);
				//verity third lead. Expecting null as third lead lead should not available
				String leadname2 = util.loopColumnFindName(excel.readFromExcel(1, 3, 1), driver.findElement(lead.LeadTable));
				search.assertEquals(leadname, excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2));
				//Expecting null, because searching only second lead
				search.assertNull(leadname2);		
				driver.navigate().refresh();
				util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
				//Serching with Second lead mobile number
				util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(0, 2, 5));
				Thread.sleep(3000);
				String leadnameByMobile = util.loopColumnFindName(excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2), driver.findElement(lead.LeadTable));
				search.assertEquals(leadnameByMobile, excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2));
				driver.navigate().refresh();
			//Searching with Laed Status
				util.sendValue(driver.findElement(lead.SearchbarOption), "Contacted");
				String statusContacted = util.loopColumnFindName("Contacted", driver.findElement(lead.LeadTable));
				//Checking lead status with "New" Available or not"
				String statusContacted1 = util.loopColumnFindName("New", driver.findElement(lead.LeadTable));
				//Searching with lead Status "Not Contacted" is available or not in lead table
				String statusContacted2 = util.loopColumnFindName("Not Contacted", driver.findElement(lead.LeadTable));
				search.assertEquals(statusContacted, "Contacted");
				//If Status "NEW" is not available, will return as null
				search.assertNull(statusContacted1);
				//If Status "Not Contacted" is not available, will return as null
				search.assertNull(statusContacted2);
				search.assertAll();
				driver.navigate().refresh();
			}
			
			*//**
			 * toggles = All Toggle element
			 * Name of Toggle button
			 * toggle = Each toggle button 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * colorOfToggle  = Color of toggles
			 * "rgba(234,104,9)" = Color code when toggle button is ON
			 * 
			 * 
			 * Verify default one column is enabled in create page view
			 * 
			 *//*
			public String namesOfToggles;
			void verifyDefaultEnabledColumn (){
				try {
					util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
					util.selectFromDropDownModal("Create View",driver.findElement(lead.CustomViewModel));
					WebElement toggleBox = driver.findElement(lead.ColumnSelectionBox);
					util.waitForElementToBeDisplayed(toggleBox);
					//Listing all element from Column list
					List<WebElement> toggles = toggleBox.findElements(By.xpath("//div[@class='slds-dropdown__item iconDeleteHeight']"));
					for (int i = 0; i < toggles.size(); i++) {
						//Gettiing toggle button status from the List
						WebElement toggle = toggles.get(i).findElement(By.className("react-toggle-track"));
						//Saving toggle color
						String colorOfToggle = toggle.getCssValue("background-color");
						System.out.println("color of togggle button is" + colorOfToggle);
						//If Toggle enabled, Getting the name of toggle (Name of column)
						if (colorOfToggle.equals(lead.colorOfToggleEnabled)) {
							namesOfToggles = toggles.get(i).findElement(By.className("pc-view_label")).getText();
							Assert.assertEquals(colorOfToggle, lead.colorOfToggleEnabled);
							break;
						}
					}
				
				} catch (Exception e) {
					System.out.println(e + "Error found while clicking the toggle button");
				}
			}
			
			
			*//**
			 * Creating page view 
			 * clickOnElementIfNotDispayed = If page view is not displayed, Click on Custom page view button 
			 * enableToggle = Enable the column
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * customPageView1 = Name of the custom page view 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			
			 void createPageView () throws IOException, InterruptedException{
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				Thread.sleep(3000);
				util.selectFromDropDownModal("Create View",driver.findElement(lead.CustomViewModel));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 0));//Enable First Name
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 0));//Enable Company
				System.out.println("Ebabled Toggle of Company ");
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 0));//Enable Assign to
				System.out.println("Ebabled Toggle of Assigne to");
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 0));//Enable Lead Status
				System.out.println("Ebabled Toggle of Lead Status");
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 11, 0));//Enable Designation
				System.out.println("Ebabled Toggle of Designation");
				util.disableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 15, 0));//Disable Salutation
				System.out.println("Desable Toggle Saluatation");
				//customPageView1 = excel.readFromExcel(3, 0, 1);
				//Sending Custom view name
				util.sendValue(driver.findElement(lead.InputBoxSaveCustomView), excel.readFromExcel(3, 0, 1));
				util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(sucessMessage, lead.createPageSucessMessage);
				Thread.sleep(3000); 
				
			}
			
			*//**
			 * Verify create page view after creating, 
			 * columnSizeInCustomPage = 
			 * actualColumnSize = Getting column size after redirecting to new custom page view
			 * allColumnNames = Getting all column header names
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			 void verifyCreatedPageView() throws IOException, InterruptedException{
				 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.tableHeader();
				int actualNoColums = util.actaulHeaderSize;
				int expectedNoColumns = 5;
				SoftAssert verifyCreatedPageView = new SoftAssert ();
				//Listing all table header
				List<String> allColumnNames = util.tableHeader();
				System.out.println(allColumnNames);
				//Checking colunmns enabled or not 
				boolean firstColumn = allColumnNames.contains(excel.readFromExcel(3, 3, 0));
				System.out.println(firstColumn);
				boolean thirdColumn = allColumnNames.contains(excel.readFromExcel(3, 4, 0));
				boolean fourthColumn = allColumnNames.contains(excel.readFromExcel(3, 5, 0));
				boolean fifthColumn = allColumnNames.contains(excel.readFromExcel(3, 11, 0));
				verifyCreatedPageView.assertEquals(firstColumn, true);
				verifyCreatedPageView.assertEquals(thirdColumn, true);
				verifyCreatedPageView.assertEquals(fourthColumn, true);
				verifyCreatedPageView.assertEquals(fifthColumn, true);
				verifyCreatedPageView.assertAll ();
				Thread.sleep(3000);	
			}
			
			void verifyDefaultView () throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				//Switching to default view 
				util.selectFromDropDownModal("Default", driver.findElement(lead.SavedPageView));
				Thread.sleep(3000);
				util.tableHeader();
				int actualColumnSize = util.actaulHeaderSize;
				int expectedColumn = 9;
				SoftAssert defaultView = new SoftAssert ();
				List<String> allColumnNames = util.tableHeader();
				System.out.println(allColumnNames);
				boolean leadName = allColumnNames.contains("Lead Name");
				System.out.println(firstColumn);
				boolean company = allColumnNames.contains(excel.readFromExcel(3, 3, 0));
				boolean assigneTo = allColumnNames.contains(excel.readFromExcel(3, 4, 0));
				boolean email = allColumnNames.contains(excel.readFromExcel(3, 6, 0));
				boolean leadStatus = allColumnNames.contains(excel.readFromExcel(3,5, 0));
				boolean desgigantion = allColumnNames.contains(excel.readFromExcel(3, 10, 0));
				boolean createdDate = allColumnNames.contains(excel.readFromExcel(3, 28, 0));
				boolean officephone = allColumnNames.contains(excel.readFromExcel(3, 7, 0));
				boolean state = allColumnNames.contains(excel.readFromExcel(3, 27, 0));
				defaultView.assertEquals(company, true);
				defaultView.assertEquals(assigneTo, true);
				defaultView.assertEquals(email, true);
				defaultView.assertEquals(leadStatus, true);
				defaultView.assertEquals(desgigantion, true);
				defaultView.assertEquals(createdDate, true);
				defaultView.assertEquals(officephone, true);
				defaultView.assertEquals(state, true);
				defaultView.assertAll ();
				Thread.sleep(3000);	
				
				
				
			}
			*//**
			 * Verify the Custom page view in saved page view 
			 * clickOnElementIfNotDispayed = Clicking saved page icon 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * customPageView = returnValueFromReactDropDownModel = Getting the text from Saved page view dropdown model
			 * @throws InterruptedException 
			 * 
			 *//*
			 void verifyCustomViewInSavedPageViews () throws InterruptedException{
				 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				 util.waitForElementAndClick( driver.findElement(lead.PageViewOption));
				 //Read the name from saved page view list
				String customPageView = util.returnValueFromReactDropDownModel(customPageView1);
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				System.out.println("My Custom view is"+" "+customPageView);
				Assert.assertEquals(customPageView, customPageView1);	
			}
			
			*//**
			 * Verifying page view is selected or note
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * tick = Select icon in saved page view list
			 * allNames = All saved page names from saved page view list 
			 * customPageView1 = Customized page view which is cerated 
			 * 
			 * 
			 *//*
			 
			 //TO DO - Need to remove this method, not required 
			void isSelecetdPageView (){
			
				By tick = By.className("slds-icon slds-p-right_xxx-small slds-m-right_xxx-small slds-icon_x-small slds-icon-text-default slds-m-right_x-small previewCheck");
				List<WebElement> allNames = driver.findElements(By.tagName("li"));
				allNames.size();
				
				for (int i=0;i<allNames.size();i++){
					String name = allNames.get(i).getText();
					if (name.equals(customPageView1)){
						try{
						 By isselectIcon = (By) allNames.get(i).findElement(tick);
						 boolean status = driver.findElements(isselectIcon).size() != 0;
						 Assert.assertEquals(status, false);
						}
						catch (Exception e){
						}	
					}	
				}	
			}
			
			*//**
			 * Edit custom view 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * selectFromDropDownModal("Edit View"); = Click on Edit View from the dropdown list 
			 * disableToggle  = Disable the column
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			void editCustomView () throws IOException, InterruptedException{
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				//Select Custom page view from saved page list for Edit
				util.selectFromDropDownModal(customPageView1, driver.findElement(lead.SavedPageView));
				Thread.sleep(3000);
				util.waitForElementAndClick (driver.findElement(lead.CustompageOption));
				//Selecting Edit View 
				util.selectFromDropDownModal("Edit View",driver.findElement(lead.CustomViewModel));
				//Disable the column 
				util.disableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 0));
				System.out.println("Disabling toggle Toggle");
				util.disableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 0));
				customPageView1 = excel.readFromExcel(3, 0, 1);
				util.sendValue(driver.findElement(lead.InputBoxInEditView), customPageView1+" "+"edited");//Editing the Page name
				System.out.println("Disabling toggle Toggle");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInEditPageView));
				String updatedSucess = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(updatedSucess, lead.editPageSucessMessage);
			}
			
			*//**
			 * allColumnNames  = Reading all columns from table header
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * excel.readFromExcel = Read the data from excel sheet to disble the column @param Sheet Number, Row number and Column number
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			
			void pageViewAfterEdit () throws IOException, InterruptedException{
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				//Switching to default view 
				util.selectFromDropDownModal(customPageView1+" "+"edited", driver.findElement(lead.SavedPageView));
				Thread.sleep(3000);
				SoftAssert pageViewAfterEdit = new SoftAssert ();
				List<String> allColumnNames = util.tableHeader();
				System.out.println(allColumnNames);
				boolean firstColumn = allColumnNames.contains(excel.readFromExcel(3, 16, 0));
				System.out.println(firstColumn);
				boolean thirdColumn = allColumnNames.contains(excel.readFromExcel(3, 3, 0));
				boolean fourthColumn = allColumnNames.contains(excel.readFromExcel(3, 4, 0));
				boolean fifthColumn = allColumnNames.contains(excel.readFromExcel(3, 5, 0));
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				//Checking page view get edited or not
				pageViewAfterEdit.assertEquals(firstColumn, true);
				pageViewAfterEdit.assertEquals(thirdColumn, false);
				pageViewAfterEdit.assertEquals(fourthColumn, false);
				pageViewAfterEdit.assertEquals(fifthColumn, true);
				pageViewAfterEdit.assertAll ();
				
			}
			
			
			*//**
			 * Verifying page view saved after Edit 
			 * customPageView = Getting the name after editing from saved list 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 *
			 * @throws IOException
			 *//*
			void pageViewInSavedPageAfterEdit() throws IOException{
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				customPageView1 = excel.readFromExcel(3,0, 1);
				String customPageView = util.returnValueFromReactDropDownModel(customPageView1+" "+"edited");
				System.out.println(customPageView);
				Assert.assertEquals(customPageView, customPageView1+" "+"edited");
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
			}
			
			
			*//**
			 * Delete Page view
			 * selectFromDropDownModal = Selecting the customized page view from saved page view 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			 void deletePageView() throws InterruptedException, IOException {
				 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				customPageView1 = excel.readFromExcel(3, 0, 1);
				 util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				util.selectFromDropDownModal(customPageView1+" "+"edited", driver.findElement(lead.SavedPageView));
				Thread.sleep(5000);
			    util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
			    Thread.sleep(3000);
				util.selectFromDropDownModal("Delete View", driver.findElement(lead.CustomViewModel));
				Thread.sleep(3000);
				int columnSizeInCustomPage = 3;
				util.tableHeader();
				int actualColumnSize = util.actaulHeaderSize;
				boolean columnSizeStatus = !(columnSizeInCustomPage==actualColumnSize);
				SoftAssert verifyCreatedPageView = new SoftAssert();
				verifyCreatedPageView.assertTrue(columnSizeStatus);
				verifyCreatedPageView.assertAll();
			
		   }

			*//**
			 * Verifying deleted view in saved page view list
			 * clickOnElementIfNotDispayed  = Open saved page view list 
			 * isViewSeleted  = Verify deleted page view in saved page view list 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * 
			 * @throws IOException
			 *//*
		  void verifyDeletdViewInSavedViews () throws IOException{
				customPageView1 = excel.readFromExcel(3, 0, 1);
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				String isViewSeleted = util.returnValueFromReactDropDownModel(customPageView1+"edited");
				String isViewSeleted1 = util.returnValueFromReactDropDownModel(customPageView1);
				Assert.assertEquals(isViewSeleted, null);
				Assert.assertEquals(isViewSeleted1, null);
			}
			
		  
			*//**
			 * enableToggle = Enable column 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * findElementAndSenkKeys = Sending the text to input box to create the column
			 * util.getValidationMessage = Get the validation message 
			 * disableToggle  = Disable the column
			 * 
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			
			 void validationCreatePageView () throws IOException, InterruptedException{
				SoftAssert createValMsg = new SoftAssert ();
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				util.selectFromDropDownModal("Create View", driver.findElement(lead.CustomViewModel));
				//util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(1, 1, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.InputBoxSaveCustomView), "");
				util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				util.waitForElementToBeDisplayed(driver.findElement(lead.ValidationMessage));
				createValMsg.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(5000);
				verifyDefaultEnabledColumn();
				String desabledClumn = new String (namesOfToggles);
			    util.disableToggle(driver.findElement(lead.ColumnSelectionBox),desabledClumn);
				util.findElementAndSenkKeys(driver.findElement(lead.InputBoxSaveCustomView), "test");
				util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				Thread.sleep(3000);
				driver.navigate().refresh();
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				//Switching to default view 
				util.selectFromDropDownModal("Default", driver.findElement(lead.SavedPageView));
				createValMsg.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
				createValMsg.assertAll();
			}
			

			
			
			void verifyButtonsBySelectingAlllead () throws InterruptedException{
				String userName        = "tester";
				WebElement table       = driver.findElement(lead.LeadTable);
				String xpath1forJoin   = lead.xpath1forCheckBox;
				String xpath2forJoin   = lead.xpath2forCheckBox;
				String xpath3          = "test";
				String action          = "checkBox";
				util.clickOnActions(userName, table,"");
				
				WebElement selectChkBox = driver.findElement(By.xpath("(//span[@class='slds-checkbox_faux'])[1]"));
				util.waitForElementToBeDisplayed(selectChkBox);
				selectChkBox.click();
				try{
					boolean statusOfAddNoteButton = util.verifyElementStatus(lead.AddNoteOptionInAllSelect);
					boolean statusOfDeleteButton = util.verifyElementStatus(lead.DeleteOptionInAllSelect);
					boolean statusOfChangeOwnerbutton = util.verifyElementStatus(lead.ChangeOwnerInAllSlect);
					boolean statusOfMoreButton = util.verifyElementStatus(lead.MoreOptionInAllSelect);
					Assert.assertEquals(statusOfAddNoteButton, true);
					Assert.assertEquals(statusOfChangeOwnerbutton, true);
					Assert.assertEquals(statusOfDeleteButton, true);
					Assert.assertEquals(statusOfMoreButton, true);
					selectChkBox.click();
				}
				catch (Exception e){
					
				}
			}
			
			
			*//**
			 * Adding log call
			 * clickOnActions  = Clicking on More Action icon based on user name
			 * selectFromDropDownModal  = Select Log a call from More Action dropdown list
		       excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			
			
			 void addLogcallListing () throws IOException, InterruptedException{
				Thread.sleep(3000);
				//TODO: firstPara = row, secandPara = collumn 
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log a Call",driver.findElement(lead.ActionMenuModel));
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 1, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.DetailsLogCall), excel.readFromExcel(4, 1, 1));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(logConfirmation, lead.addLogSucessMessage);
				Thread.sleep(3000);
			}
			
			 
			
			*//**
			 * Add log validations 
			 * addLogValidationMessage = Get the validation message
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			 void addLogValidationsListing () throws InterruptedException, IOException{
				SoftAssert addLogValidationsListing = new SoftAssert();
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log a Call", driver.findElement(lead.ActionMenuModel));
				util.waitForElementAndClick(driver.findElement(lead.SubjectLogCall));
				Thread.sleep(2000);
				driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
				String validationMsg = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				addLogValidationsListing.assertEquals(validationMsg, lead.addLogFieldvaldiationMessage);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				addLogValidationsListing.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
				addLogValidationsListing.assertAll();
			}
			 
			 void addLogValidationsDetails () throws InterruptedException, IOException{
					SoftAssert addLogValidationsDetails = new SoftAssert();
					Thread.sleep(2000);
					util.waitForElementAndClick(driver.findElement(lead.SubjectLogCall));
					driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
					String validationMsg = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
					addLogValidationsDetails.assertEquals(validationMsg, lead.addLogFieldvaldiationMessage);
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					String addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					addLogValidationsDetails.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
					addLogValidationsDetails.assertAll();
				}
			
			 void addLogErrorWhileClosing  () throws IOException, InterruptedException{
				 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					util.selectFromDropDownModal("Log a Call", driver.findElement(lead.ActionMenuModel));
				 util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 1, 0));
				 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				 boolean alertStatus = util.isAlertPresent();
				 Assert.assertEquals(alertStatus, true);
				 util.acceptAlert();
				 driver.navigate().refresh();
			 }
			 
			 void addlogErroWithOutchar () throws InterruptedException, IOException{
				 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				 util.selectFromDropDownModal("Log a Call",driver.findElement(lead.ActionMenuModel));
				 Thread.sleep(3000);
				 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				 boolean alertStatus = util.isAlertPresent();
				 Assert.assertEquals(alertStatus, false);
				 if (alertStatus==true){
					 util.acceptAlert();
				 }
			 }
			 
			 void changeOwner () throws InterruptedException, IOException{
					util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					util.selectFromDropDownModal("Change Lead Owner",driver.findElement(lead.ActionMenuModel));
					Thread.sleep(3000);
					util.handleDropdown(driver.findElement(lead.ChangeleadOwner), lead.changeOwnerTo);
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					try{
					String sucessmessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
					util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
					util.acceptAlert();
					}
					catch (Exception E){
						//do nothing
					}
					String currentOwner = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
					Assert.assertEquals(currentOwner, lead.changeOwnerTo);
					
					
					
			 }
			 
			*//**
			 * Add Note validation 
			 * clickOnActions  = Clicking on More Action icon based on user name
			 * selectFromDropDownModal  = Select Add Note from More Action dropdown list
		       excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			  void addNotevalidationListing() throws InterruptedException, IOException{
				  SoftAssert addNotevalidationMessage = new SoftAssert();
					util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
					util.waitForElementAndClick(driver.findElement(lead.SubjectNote));
					Thread.sleep(2000);
					driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
					String validationMsg = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
					addNotevalidationMessage.assertEquals(validationMsg, lead.addNoteFieldvaldiationMessage);
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					String addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					addNotevalidationMessage.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
					addNotevalidationMessage.assertAll();
				
			}
			
			  void addNotevalidationDetails() throws InterruptedException, IOException{
				  SoftAssert addNotevalidationDetails = new SoftAssert();
				   util.waitForElementAndClick(driver.findElement(leadDetails.MakeNote));
					util.waitForElementAndClick(driver.findElement(lead.SubjectNote));
					Thread.sleep(2000);
					driver.findElement(lead.SubjectNote).sendKeys(Keys.TAB);
					String validationMsg = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
					addNotevalidationDetails.assertEquals(validationMsg, lead.addNoteFieldvaldiationMessage);
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					String addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					addNotevalidationDetails.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
					addNotevalidationDetails.assertAll();
				
			}
			
			  
			  void addNoteErrorWhileClosing  () throws IOException, InterruptedException{
				  util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
					 util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 1, 0));
					 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
					 boolean alertStatus = util.isAlertPresent();
					 Assert.assertEquals(alertStatus, true);
					 util.acceptAlert();
					 driver.navigate().refresh();
				 }
				 
				 void addNoteErroWithOutchar () throws InterruptedException, IOException{
					 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					 util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
					 Thread.sleep(3000);
					 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
					 boolean alertStatus = util.isAlertPresent();
					 Assert.assertEquals(alertStatus, false);
					 if (alertStatus==true){
						 util.acceptAlert();
					 }
				 }
			*//**
			 * Add Note 
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			 void addNoteListing() throws InterruptedException, IOException{
			
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 1, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 1, 1));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(logConfirmation, lead.addNoteSucessMessage);
				Thread.sleep(3000);
			}
			 
			void addNoteInDetails () throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(leadDetails.MakeNote));
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 2, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 2, 1));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(logConfirmation, lead.addNoteSucessMessage);
				Thread.sleep(3000);
			}
			

			 EventEntry evententry = new EventEntry();
			 
			 *//**
			  * Adding Event from lead listing page 
			  * @throws InterruptedException
			  * @throws IOException
			  *//*
			void addEvent () throws InterruptedException, IOException{
			
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				evententry.createEvent(6, 1);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(sucessMEsssage, evententry.successMessage);	
			}
			
			
			void addEventInDeatilspage () throws InterruptedException{
				util.waitForElementAndClick(driver.findElement(leadDetails.NewEvent));
				evententry.createEvent(5, 2);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(sucessMessage, lead.addEventSucessMessage);
			}
			*//**
			 * Tabs out valdiation error for Event
			 * addEventValidationError : Assert all values 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			void tabsOutvalidationEvent () throws InterruptedException, IOException{
				SoftAssert addEventValidationError = new SoftAssert ();
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(evententry.Sujbect));
				driver.findElement(evententry.Sujbect).sendKeys(Keys.TAB);
				String subjectvalError = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
				driver.findElement(evententry.EventType).click();
				driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
				driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
				String eventTypevalError = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
				driver.findElement(evententry.StartDateTime).click();
				driver.findElement(evententry.StartDateTime).sendKeys(Keys.TAB);
				String StartdatevalError = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
				driver.findElement(evententry.EndDateTime).click();
				driver.findElement(evententry.EndDateTime).sendKeys(Keys.TAB);
				String EnddatevalError = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
				addEventValidationError.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
				addEventValidationError.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
				addEventValidationError.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
				addEventValidationError.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String commonvalidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				addEventValidationError.assertEquals(commonvalidation, evententry.commonValidationMessage);
				addEventValidationError.assertAll();
				
			}

			
			void tabsOutvalidationEventInDetails () throws InterruptedException, IOException{
				SoftAssert tabsOutvalidationEventInDetails = new SoftAssert ();
				util.waitForElementAndClick(driver.findElement(leadDetails.NewEvent));
				util.waitForElementAndClick(driver.findElement(evententry.Sujbect));
				driver.findElement(evententry.Sujbect).sendKeys(Keys.TAB);
				String subjectvalError = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
				driver.findElement(evententry.EventType).click();
				driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
				driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
				String eventTypevalError = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
				driver.findElement(evententry.StartDateTime).click();
				driver.findElement(evententry.StartDateTime).sendKeys(Keys.TAB);
				String StartdatevalError = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
				driver.findElement(evententry.EndDateTime).click();
				driver.findElement(evententry.EndDateTime).sendKeys(Keys.TAB);
				String EnddatevalError = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
				tabsOutvalidationEventInDetails.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
				tabsOutvalidationEventInDetails.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
				tabsOutvalidationEventInDetails.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
				tabsOutvalidationEventInDetails.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String commonvalidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				tabsOutvalidationEventInDetails.assertEquals(commonvalidation, evententry.commonValidationMessage);
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				tabsOutvalidationEventInDetails.assertAll();
				
			}
			*//**
			 * Event Common validation 
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			void commonvalidationEvent () throws InterruptedException, IOException{
				SoftAssert addEventCommonvalidation = new SoftAssert ();
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String subjectvalError = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
				String eventTypevalError = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
				String StartdatevalError = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
				String EnddatevalError = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
				addEventCommonvalidation.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
				addEventCommonvalidation.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
				addEventCommonvalidation.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
				addEventCommonvalidation.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
				String commonvalidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				addEventCommonvalidation.assertEquals(commonvalidation, evententry.commonValidationMessage);
				addEventCommonvalidation.assertAll();
			}
			
			void commonvalidationEventDetails () throws InterruptedException, IOException{
				SoftAssert commonvalidationEventDetails = new SoftAssert();
				util.waitForElementAndClick(driver.findElement(leadDetails.NewEvent));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String subjectvalError = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
				String eventTypevalError = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
				String StartdatevalError = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
				String EnddatevalError = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
				commonvalidationEventDetails.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
				commonvalidationEventDetails.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
				commonvalidationEventDetails.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
				commonvalidationEventDetails.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
				String commonvalidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				commonvalidationEventDetails.assertEquals(commonvalidation, evententry.commonValidationMessage);
				commonvalidationEventDetails.assertAll();
			}
			
			*//**
			 * Verifying alert while closing the page 
			 * @throws IOException 
			 * @throws InterruptedException 
			 *//*
			void addEventAlertWhileClosng () throws InterruptedException, IOException{
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				util.sendValue(driver.findElement(evententry.Sujbect), "Test");
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				boolean alert = util.isAlertPresent();
				Assert.assertEquals(alert, true);
				util.acceptAlert();
				
			}
			
			*//**
			 * Adding Attachement from listing page 
			 * uploadFile = Setting path for field which need to uplaod 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			void addAttachement () throws InterruptedException, IOException{
			
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Attachment",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				util.sendValue(driver.findElement(lead.uploadinAttachemnt), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
				util.sendValue(driver.findElement(lead.DetailsInAttachment), "Adding file ");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				try {
				String success = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				driver.navigate().refresh();
				System.out.println(success);
				Assert.assertEquals(success, lead.addAttachmentSucessMessage);

				}
				catch (Exception E){
					driver.navigate().refresh();
				}
				
			}
			
			*//**
			 * Common validation for Attachment 
			 * getValidationMessage = Getting the massage of the validation 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			void attachmentCommonvalidation () throws InterruptedException, IOException{
			
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String commonValidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(commonValidation, lead.commonvalidationAttachment);
			}
			
			void addAttachementInDetails () throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(leadDetails.AddAttachment));
				util.sendValue(driver.findElement(lead.uploadinAttachemnt), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");

				
				Thread.sleep(3000);
				util.sendValue(driver.findElement(lead.DetailsInAttachment), "Adding file ");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String success = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				System.out.println(success);
				Assert.assertEquals(success, lead.addAttachmentSucessMessage);
				
			}
			
			void attachmentCommonvalidationInDetails () throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(leadDetails.AddAttachment));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String commonValidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(commonValidation, lead.commonvalidationAttachment);
			}
			
			



			*//**
			 * ClickOnActions  = Clicking on More Action icon based on user name
			   selectFromDropDownModal  = Select Add Task from More Action dropdown list
			   excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			 void deleteLeadFromListing () throws InterruptedException, IOException{
				util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Change Lead Owner",driver.findElement(lead.ActionMenuModel));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			}
			
			*//**
			 * Verifying Lead Header
			 * headerTitle = Tile of Header
			 * @throws IOException
			 *//*
			 void getLeadDetailsHeader () throws IOException{
				util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
				util.column.click();
				String headerTitle = util.getElementName(driver.findElement(leadDetails.TitleLeadDetails));
				Assert.assertEquals(headerTitle, "LEAD");
			}
			
			*//**
			 * Verify lead details in Details page 
			 * @throws IOException
			 *//*
		      void getLeadDetailsFromDetailsPage () throws IOException{
				String leadName = util.getElementName(driver.findElement(leadDetails.LeadNameDetailsHeader));
				String companyName  = util.getElementName(driver.findElement(leadDetails.CompanyNameDetailsHeader));
				String Designation  = util.getElementName(driver.findElement(leadDetails.DesignationDetailsHeader));
				String MobileNumber = util.getElementName(driver.findElement(leadDetails.MobileNumberDetailsHeader));
				String Email =util.getElementName(driver.findElement(leadDetails.MobileNumberDetailsHeader));
				String expectedLeadName = excel.readFromExcel(1, 1, 1)+" "+excel.readFromExcel(1, 2, 1);
				String expectedCompanyName  = excel.readFromExcel(1, 3, 1);
				String expectedDesignation  = excel.readFromExcel(1, 10, 1);
				String expectedMobileNumber = excel.readFromExcel(1, 8, 1);
				String expectedEmail = excel.readFromExcel(1, 8, 1);
				SoftAssert getLeadDetailsFromDetailsPage = new SoftAssert ();
				getLeadDetailsFromDetailsPage.assertEquals(leadName, expectedLeadName);
				getLeadDetailsFromDetailsPage.assertEquals(companyName, expectedCompanyName);
				getLeadDetailsFromDetailsPage.assertEquals(Designation, expectedDesignation);
				getLeadDetailsFromDetailsPage.assertEquals(MobileNumber, expectedMobileNumber);
				getLeadDetailsFromDetailsPage.assertEquals(Email, expectedEmail);
				getLeadDetailsFromDetailsPage.assertAll();	
			}
			

			*//**
			 * Add log validations in details page
			 * addLogValidationMessage = Get the validation message
			 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			
			void addLogValidationInDetailsPage (){
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), "");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String addLogValidationMessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				Assert.assertEquals(addLogValidationMessage, "This field required");
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
			}
			

			*//**
			 * Add Note validation in Detail Page 
			 * clickOnActions  = Clicking on More Action icon based on user name
			 * selectFromDropDownModal  = Select Add Note from More Action dropdown list
		       excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			
			void addNotevalidationDetailsPage () throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(leadDetails.MakeNote));
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote),"");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String addLogValidationMessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				Assert.assertEquals(addLogValidationMessage, "This field required");
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));	
			}
			


			 
			 
			 *//**
			  * 
			  * @return  value of Entry field after clicking reset 
			  * @throws IOException
			  * @throws InterruptedException
			  *//*
			 public String[] beforeReset() throws IOException, InterruptedException {
				 WebElement CreateButton = driver.findElement(lead.CreateLeadOption);
					util.waitForElementAndClick(CreateButton);
					bulk.createLead(0, 2);
					Thread.sleep(2000);
					util.waitForElementAndClick(driver.findElement(leadEntry.ResetButton));
					Thread.sleep(3000);
					String firstName = driver.findElement(leadEntry.FirstName).getAttribute("value");
					String lastName = driver.findElement(leadEntry.LastName).getAttribute("value");
					String companyName = driver.findElement(leadEntry.CompanyName).getAttribute("value");
					String assignTo = driver.findElement(leadEntry.AssignedTo).getAttribute("value");
					String leadStatus = driver.findElement(leadEntry.LeadStatus).getAttribute("value");
					String email = driver.findElement(leadEntry.Email).getAttribute("value");
					String officeMobile = driver.findElement(leadEntry.Officenumber).getAttribute("value");
					String mobileNumber = driver.findElement(leadEntry.MobileNumber).getAttribute("value");
					String webSite = driver.findElement(leadEntry.WebSite).getAttribute("value");
					String [] value = new String [] {"","","","","","","","",""};
					return value;
						      
			 }
			 
			 *//**
			  * fieldvalueAfterReset  = value of Entry fields
			  * @throws IOException
			  * @throws InterruptedException
			  *//*
			 void verifyAfterReset () throws IOException, InterruptedException{
				 beforeReset();
				 Thread.sleep(3000);
				 String fieldvalueAfterReset = beforeReset()[0] + "," + beforeReset()[1] + "," + beforeReset()[2] + "," +
						 beforeReset()[3] + "," + beforeReset()[4] + "," + beforeReset()[5] + "," +
						 beforeReset()[6] + "," + beforeReset()[7] + "," + beforeReset()[8];
				 
				 String expectedvalue = ",,,,,,,,";
			 }
			 
			 *//**
			  * clickOnActions = Find the name and clicking on Delete
			  * @throws InterruptedException
			  * @throws IOException
			  *//*
			 void deleteLead () throws InterruptedException, IOException{
					util.clickOnActions(excel.readFromExcel(1, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					util.selectFromDropDownModal("Delete Lead",driver.findElement(lead.ActionMenuModel));
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					Object userName = util.loopColumnFindName(excel.readFromExcel(1, 1, 1), driver.findElement(lead.LeadTable));
					Assert.assertNull(userName);
					
			 }
			 
			 *//**
			  * @throws IOException
			 * @throws InterruptedException 
			  * 
			  *//*
			 

			 void verifyRedirctionToDetilspage () throws IOException, InterruptedException{
				 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
					//Select Custom page view from saved page list for Edit
					util.selectFromDropDownModal("Default", driver.findElement(lead.SavedPageView));
					Thread.sleep(3000);
				 String listingURL = driver.getCurrentUrl();
				 String value = excel.readFromExcel(0, 1, 1);
				 try{
					 util.clickOnNameinTable(value);
					 Thread.sleep(4000);
				 }
				 catch (Exception E){
					 driver.close();
					 
				 }
				 String detailsURL = driver.getCurrentUrl();
				 if (listingURL.equals(detailsURL)){
					 driver.close();
					 System.out.println("Test is stopping, as unable to redirect to Details page ");
					 
				 }
				 
			 }
			 
			 void verifyHeaderForDetails () throws IOException{
				
					SoftAssert verifyHeaderForDetails = new SoftAssert ();
					 String leadNameInDeatis = util.getElementName(driver.findElement(leadDetails.LeadNameDetailsHeader));
					 String companyNameDetails = util.getElementName(driver.findElement(leadDetails.CompanyNameDetailsHeader));
					 String DesignationInDetail = util.getElementName(driver.findElement(leadDetails.DesignationDetailsHeader));
					 String mobileNumberInDeatsils = util.getElementName(driver.findElement(leadDetails.MobileNumberDetailsHeader));
					 String email = util.getElementName(driver.findElement(leadDetails.EmailInfoHeader));
					 verifyHeaderForDetails.assertEquals(leadNameInDeatis, excel.readFromExcel(0, 1, 1)+" "+excel.readFromExcel(0, 1, 2));
					 verifyHeaderForDetails.assertEquals(companyNameDetails, excel.readFromExcel(0, 1, 3));
					 verifyHeaderForDetails.assertEquals(DesignationInDetail, excel.readFromExcel(0, 1, 4));
					 verifyHeaderForDetails.assertEquals(mobileNumberInDeatsils, excel.readFromExcel(0, 1, 6));
					 verifyHeaderForDetails.assertEquals(email, excel.readFromExcel(0, 1, 7));
					 verifyHeaderForDetails.assertAll();
					 
			 }
			
			 
			  void tabsValidationlead() throws InterruptedException{
				
					Thread.sleep(3000);
					driver.findElement(leadEntry.LastName).click();
					Thread.sleep(3000);
					 driver.findElement(leadEntry.LastName).sendKeys(Keys.TAB);
					 String lastNameValidation = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
					 driver.findElement(leadEntry.CompanyName).click();
					 Thread.sleep(3000);
					 driver.findElement(leadEntry.LastName).sendKeys(Keys.TAB);
					 String companyNameValidation = util.getValidationMessage(driver.findElement(leadEntry.companyFieldValidation));
					 driver.findElement(leadEntry.LeadStatus).click();
					 driver.findElement(leadEntry.LastName).sendKeys(Keys.TAB);
					 Thread.sleep(3000);
					 String leadStatusValidation = util.getValidationMessage(driver.findElement(leadEntry.leadStatusFieldvaldiation));
					 util.sendValue(driver.findElement(leadEntry.Email), "invalid");
					 Thread.sleep(3000);
					 driver.findElement(leadEntry.Email).sendKeys(Keys.TAB);
					 String emailIdError = util.getValidationMessage(driver.findElement(leadEntry.emailFieldvaldiation));
					 driver.findElement(leadEntry.SaveButton).click();
					 String commonValidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					 System.out.println(commonValidation);
					 SoftAssert tabsError = new SoftAssert ();
					 tabsError.assertEquals(lastNameValidation, leadEntry.lastNameValdiationError);
					 tabsError.assertEquals(companyNameValidation, leadEntry.companyNameValidationError);
					 tabsError.assertEquals(companyNameValidation, leadEntry.leadStatusValidationError);
					 tabsError.assertEquals(emailIdError, leadEntry.emailIDInvalidError);
					 tabsError.assertEquals(commonValidation, leadEntry.companyNameValidationError);
					 tabsError.assertAll();
				
				
				 	
			 }
			  
			  void commonValdiationError () throws InterruptedException{
				    util.sendValue(driver.findElement(leadEntry.Email), "invalidTest");
				    util.sendValue(driver.findElement(leadEntry.WebSite), "invalidWebSite");
					driver.findElement(leadEntry.SaveButton).click();
					String commonValidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					Thread.sleep(3000);
					List <WebElement> fiedlValidationError = driver.findElements(lead.ValidationMessage);
					fiedlValidationError.size();
					ArrayList <String> storeMessages = new ArrayList <String>();
					for (int i=0;fiedlValidationError.size()<0;i++){
						String valMessage = fiedlValidationError.get(i).getText();
						storeMessages.add(valMessage);	
					}
					SoftAssert commonval = new SoftAssert ();
					commonval.assertEquals(storeMessages.contains(leadEntry.lastNameValdiationError),true);
					commonval.assertEquals(storeMessages.contains(leadEntry.companyNameValidationError),true);
					commonval.assertEquals(storeMessages.contains(leadEntry.leadStatusValidationError),true);
					commonval.assertEquals(storeMessages.contains(leadEntry.emailIDInvalidError),true);
					commonval.assertEquals(storeMessages.contains(leadEntry.webSiteInvalidError),true);
					commonval.assertEquals(commonValidation,leadEntry.CommonValidationMEssage);
					commonval.assertAll();
					
					
				}
			  
			   void verifyAlertwhileClosing () throws InterruptedException{
				  util.waitForElementAndClick(driver.findElement(lead.CreateLeadOption));
				  bulk.createLead(0, 2);
				  util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
				  String alertText = util.getAlertMessage();
				  util.acceptAlert();
				  Assert.assertEquals(alertText, leadEntry.alertMessage);
				   
			  }
			  
			  void verifyAlertWithoutChange (){
				  driver.navigate().refresh();
				  util.waitForElementAndClick(driver.findElement(lead.CreateLeadOption));
				  util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
				  boolean alertStatus = util.isAlertPresent();
				  Assert.assertFalse(alertStatus);
				  if (alertStatus==true){
					  util.acceptAlert(); 
				  }
			  }
			  
			  void addLogcallDetails() throws IOException, InterruptedException{
				  driver.navigate().refresh();
					Thread.sleep(3000);
					util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 2, 0));
					util.findElementAndSenkKeys(driver.findElement(lead.DetailsLogCall), excel.readFromExcel(4, 2, 1));
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					Assert.assertEquals(logConfirmation, lead.addLogSucessMessage);
					Thread.sleep(3000);
			  }
			  
			  void inlineEditInLeadTable () throws IOException, InterruptedException{
				  try {
						 if (statusOfActionPopup==true){
							 driver.findElement(lead.CancelOptionActionPopup).click();
							 util.acceptAlert();
						 }
					 }
					 catch(Exception E){ 
					 }
				  Thread.sleep(3000);
				  try {
					util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
					  util.selectFromDropDownModal("Create View",driver.findElement(lead.CustomViewModel));
					  util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 0));
					  util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 2, 0));
					 util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 0));//Enable Company
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 0));//Enable Assign to
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 0));//Enable Lead Status
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 6, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 7, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 8, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 9, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 10, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 11, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 12, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 13, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 14, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 15, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3,29, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 30, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 31, 0));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 19, 0));
					util.sendValue(driver.findElement(lead.InputBoxSaveCustomView), "InLineEditView");
					util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
				  util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
					//Switching to default view 
					util.selectFromDropDownModal("InLineEditView", driver.findElement(lead.SavedPageView));
				Thread.sleep(3000);
				  String emailEdit = "inlineedit@gmail.com";
				  SoftAssert inlineEditInLeadTable = new SoftAssert ();
				  try{
				 Thread.sleep(3000);
			      String companyName  = util.getColumndata("Company", excel.readFromExcel(0, 1, 1));
			      String companyNameEdit = companyName +" "+ "Edited";
				  util.inlineEditInTable("Company", excel.readFromExcel(0, 1, 1));
				  util.sendValue(driver.findElement(leadEntry.CompanyName), companyNameEdit);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  String companyNameAfterEdit  = util.getColumndata("Company", excel.readFromExcel(0, 1, 1));
				  Thread.sleep(3000);
				  inlineEditInLeadTable.assertNotEquals(companyName, companyNameAfterEdit);
				  }
				  catch (Exception E){
					  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				  }
				  try {
					 String designation = util.getColumndata("Designation", excel.readFromExcel(0, 1, 1));
					 String designationEdit = designation +" "+"Edited";
					util.inlineEditInTable("Designation", excel.readFromExcel(0, 1, 1));
					  util.sendValue(driver.findElement(leadEntry.Designation), designationEdit);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(4000);
					  String designationAfterEdit = util.getColumndata("Designation", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(designation, designationAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				}
				  try {
					String leadStatus = util.getColumndata("Lead Status", excel.readFromExcel(0, 1, 1));
					util.inlineEditInTable("Lead Status", excel.readFromExcel(0, 1, 1));
					  util.handleDropDownByIndex(driver.findElement(leadEntry.LeadStatus), 3);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String leadStatusAfterChange = util.getColumndata("Lead Status", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(leadStatus, leadStatusAfterChange);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				  try {
					  String email = util.getColumndata("Email", excel.readFromExcel(0, 1, 1));
					util.inlineEditInTable("Email", excel.readFromExcel(0, 1, 1));
					  util.sendValue(driver.findElement(leadEntry.Email), emailEdit);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String emailAfterEdit = util.getColumndata("Email", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(email, emailAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				  try {
					  String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
					util.inlineEditInTable("Assigned To", excel.readFromExcel(0, 1, 1));
					  util.handleDropDownByIndex(driver.findElement(leadEntry.AssignedTo), 3);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String AssignToAfterEdit = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(AssignTo, AssignToAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				  
				  try {
					  String leadSource = util.getColumndata("Lead Source", excel.readFromExcel(0, 1, 1));
					util.inlineEditInTable("Lead Source", excel.readFromExcel(0, 1, 1));
					  util.handleDropDownByIndex(driver.findElement(leadEntry.LeadSource), 3);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String leadSourceAfterEdit = util.getColumndata("Lead Source", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(leadSource, leadSourceAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				 
				  try {
					  String mobileNumber = util.getColumndata("Mobile Number", excel.readFromExcel(0, 1, 1));
					  String mobileNumberEdit = mobileNumber +" "+"02";
					util.inlineEditInTable("Mobile Number", excel.readFromExcel(0, 1, 1));
					  util.sendValue(driver.findElement(leadEntry.MobileNumber), mobileNumberEdit);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String mobileNumberAfterEdit = util.getColumndata("Mobile Number", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(mobileNumber, mobileNumberAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				  
				  try {
					  String officePhone = util.getColumndata("Office Number", excel.readFromExcel(0, 1, 1));
					  String officePhoneEdit = officePhone +" "+"02";
					util.inlineEditInTable("Mobile Number", excel.readFromExcel(0, 1, 1));
					  util.sendValue(driver.findElement(leadEntry.OfficeNumber), officePhoneEdit);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String officePhoneAfterEdit = util.getColumndata("Office Number", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(officePhone, officePhoneAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				  
				  try {
					  String mainBusiness = util.getColumndata("Main Business", excel.readFromExcel(0, 1, 1));
					 util.inlineEditInTable("Mobile Number", excel.readFromExcel(0, 1, 1));
					 util.handleDropDownByIndex(driver.findElement(leadEntry.MainBusiness), 3);
					  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					  Thread.sleep(3000);
					  String mainBusinessAfterEdit = util.getColumndata("Main Business", excel.readFromExcel(0, 1, 1));
					  inlineEditInLeadTable.assertNotEquals(mainBusiness, mainBusinessAfterEdit);
				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					e.printStackTrace();
				}
				 
			  try {
				  String industry = util.getColumndata("Industry", excel.readFromExcel(0, 1, 1));
				  util.inlineEditInTable("Industry", excel.readFromExcel(0, 1, 1));
				  util.handleDropDownByIndex(driver.findElement(leadEntry.Industry), 3);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(3000);
				  String industryAfterEdit = util.getColumndata("Industry", excel.readFromExcel(0, 1, 1));
				  inlineEditInLeadTable.assertNotEquals(industry, industryAfterEdit);
			  } catch (Exception e) {
				  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				e.printStackTrace();
			  }
			  
			  try {
				  String State = util.getColumndata("State", excel.readFromExcel(0, 1, 1));
				  util.inlineEditInTable("Industry", excel.readFromExcel(0, 1, 1));
				  util.handleDropDownByIndex(driver.findElement(leadEntry.Staet), 3);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(3000);
				  String StateAfterEdit= util.getColumndata("State", excel.readFromExcel(0, 1, 1));
				  inlineEditInLeadTable.assertNotEquals(State, StateAfterEdit);
			  } catch (Exception e) {
				  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				e.printStackTrace();
				
			  }
			  
			  
			  try {
				  String city = util.getColumndata("City", excel.readFromExcel(0, 1, 1));
				  util.inlineEditInTable("City", excel.readFromExcel(0, 1, 1));
				  util.handleDropDownByIndex(driver.findElement(leadEntry.City), 3);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(3000);
				  String cityAfterEdit = util.getColumndata("City", excel.readFromExcel(0, 1, 1));
				  inlineEditInLeadTable.assertNotEquals(city, cityAfterEdit);
			  } catch (Exception e) {
				  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				e.printStackTrace();
			  }
			  
			  inlineEditInLeadTable.assertAll();
			  
			}
			//sdfgsdgfgfghsdf  
			  
			  public String  companyNameAfterEditListing;
			  public String designationAfterEditListing;
			  public String leadStatusAfterEditListing;
			  public String emailAfterEditListing;
			  public String AssignToAfterEditListing;
			  public String leadSourceAfterEditListing;
			  public String mobileNumberAfterEditListing;
			  public String officePhoneAfterEditListing;
			  public String mainBusinessAfterEditListing;
			  public String industryAfterEditListing;
			  public String StateAfterEditListing;
			  public String cityAfterEditListing;
			  
			 void editFromLiStingPage() throws IOException, InterruptedException{
				 SoftAssert editFromLiStingPage = new SoftAssert();
				 String companyName  = util.getColumndata("Company", excel.readFromExcel(0, 1, 1));
				 String designation = util.getColumndata("Designation", excel.readFromExcel(0, 1, 1));
				 String leadStatus = util.getColumndata("Lead Status", excel.readFromExcel(0, 1, 1));
				 String email = util.getColumndata("Email", excel.readFromExcel(0, 1, 1));
				 String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
				 String leadSource = util.getColumndata("Lead Source", excel.readFromExcel(0, 1, 1));
				 String mobileNumber = util.getColumndata("Mobile Number", excel.readFromExcel(0, 1, 1));
				 String officePhone = util.getColumndata("Office Number", excel.readFromExcel(0, 1, 1));
				 String mainBusiness = util.getColumndata("Main Business", excel.readFromExcel(0, 1, 1));
				 String industry = util.getColumndata("Industry", excel.readFromExcel(0, 1, 1));
				 String State = util.getColumndata("State", excel.readFromExcel(0, 1, 1));
				 String city = util.getColumndata("City", excel.readFromExcel(0, 1, 1));
				 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Edit",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				bulk.createLead(0, 1);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String editSuccessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				editFromLiStingPage.assertEquals(editSuccessMessage, lead.editleadSucessMessage);
				 companyNameAfterEditListing  = util.getColumndata("Company", excel.readFromExcel(0, 1, 1));
				 designationAfterEditListing = util.getColumndata("Designation", excel.readFromExcel(0, 1, 1));
				 leadStatusAfterEditListing = util.getColumndata("Lead Status", excel.readFromExcel(0, 1, 1));
				 emailAfterEditListing = util.getColumndata("Email", excel.readFromExcel(0, 1, 1));
				  AssignToAfterEditListing = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
				  leadSourceAfterEditListing = util.getColumndata("Lead Source", excel.readFromExcel(0, 1, 1));
				  mobileNumberAfterEditListing = util.getColumndata("Mobile Number", excel.readFromExcel(0, 1, 1));
				  officePhoneAfterEditListing = util.getColumndata("Office Number", excel.readFromExcel(0, 1, 1));
				  mainBusinessAfterEditListing = util.getColumndata("Main Business", excel.readFromExcel(0, 1, 1));
				  industryAfterEditListing = util.getColumndata("Industry", excel.readFromExcel(0, 1, 1));
				  StateAfterEditListing = util.getColumndata("State", excel.readFromExcel(0, 1, 1));
				  cityAfterEditListing = util.getColumndata("City", excel.readFromExcel(0, 1, 1)); 
				  editFromLiStingPage.assertNotEquals(companyNameAfterEditListing, companyName);
				  editFromLiStingPage.assertNotEquals(designationAfterEditListing, designation);
				  editFromLiStingPage.assertNotEquals(leadStatusAfterEditListing, leadStatus);
				  editFromLiStingPage.assertNotEquals(leadStatusAfterEditListing, email);
				  editFromLiStingPage.assertNotEquals(emailAfterEditListing, AssignTo);
				  editFromLiStingPage.assertNotEquals(AssignToAfterEditListing, leadSource);
				  editFromLiStingPage.assertNotEquals(mobileNumberAfterEditListing, mobileNumber);
				  editFromLiStingPage.assertNotEquals(officePhoneAfterEditListing, officePhone);
				  editFromLiStingPage.assertNotEquals(mainBusinessAfterEditListing, mainBusiness);
				  editFromLiStingPage.assertNotEquals(industryAfterEditListing, industry);
				  editFromLiStingPage.assertNotEquals(StateAfterEditListing, State);
				  editFromLiStingPage.assertNotEquals(cityAfterEditListing, city);
				  
				  editFromLiStingPage.assertAll();
				  
			 }
			  
			  
			  
			  void verifyFilter () throws IOException, InterruptedException{
				  Thread.sleep(4000);
				  SoftAssert verifyFilter = new SoftAssert ();
				  try {
					util.waitForElementAndClick(driver.findElement(lead.FilterOption));
					Thread.sleep(3000);
					try{
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1),"First Name");
					}
					catch(Exception E){
						util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "First Name");
					}
					Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,1));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  Thread.sleep(3000);
					  String leadname1 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname1);
					  verifyFilter.assertNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Company");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Company");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,3));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  try {
					  Thread.sleep(3000);
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					 
						try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Status");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Lead Status");
							}
						Thread.sleep(3000);
						util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Status");
						Thread.sleep(3000);
						  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
						  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0,1,17));
						  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
						  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
						  verifyFilter.assertNotNull(leadname3);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Assigned To");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Assigned To");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,18));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Designation");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Designation");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,4));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Email");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Email");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,7));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Website");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Website");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,18));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Industry");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Industry");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.handleDropdown(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,14));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Country");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Country");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.handleDropdown(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,10));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  try {
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  try{
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Source");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Lead Source");
							}
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.handleDropdown(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,16));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
					  verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  //AND and OR Condiion 
				  
				  try {
						try{
							util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");
							}
							catch(Exception E){
								util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "First Name");
							}
						Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0,1,1));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  util.waitForElementAndClick(driver.findElement(lead.FilterAddNewFilter));
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy2), "First Name");
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator2), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox2), excel.readFromExcel(0,1,2));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
						  String leadname4 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
						  String leadname5 = util.loopColumnFindName(excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2), driver.findElement(lead.LeadTable));
						  verifyFilter.assertNotNull(leadname4);
						  verifyFilter.assertNotNull(leadname5);
						  Thread.sleep(3000);
						  util.waitForElementAndClick(driver.findElement(lead.FilterEdit2));
						  Thread.sleep(3000);
						  util.handleDropdown(driver.findElement(lead.FilterANDOR), "AND");
						  Thread.sleep(3000);
						  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
						  String leadname6 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
						  String leadname7 = util.loopColumnFindName(excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2), driver.findElement(lead.LeadTable));
						  verifyFilter.assertNull(leadname4);
						  verifyFilter.assertNull(leadname5);
						  
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  util.waitForElementAndClick(driver.findElement(lead.FilterOption));
				  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				  driver.navigate().refresh();
				  
				  verifyFilter.assertAll();
				  
			  }
			  
			  TaskEntry taskentry = new TaskEntry ();
			  
			  void addtask () throws InterruptedException, IOException{
				  try {
						 if (statusOfActionPopup==true){
							 driver.findElement(lead.CancelOptionActionPopup).click();
							 util.acceptAlert();
						 }
					 }
					 catch(Exception E){ 
					 }
					util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
					util.selectFromDropDownModal("Add Task",driver.findElement(lead.ActionMenuModel));
					Thread.sleep(3000);
					taskentry.createTask(7, 1);
					util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					Assert.assertEquals(sucessMEsssage, taskentry.taskSucessMessage);
			  }
			  void addtaskInDetails() throws InterruptedException{
				  util.waitForElementAndClick(driver.findElement(leadDetails.NewTask));
				  taskentry.createTask(7, 2);
				  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
					Assert.assertEquals(sucessMEsssage, taskentry.taskSucessMessage);
			  }
			   
			  
			  
			  void importLead () throws InterruptedException, IOException{
				  SoftAssert importLead = new SoftAssert ();
				  util.waitForElementAndClick(driver.findElement(lead.ActionButton));
				  util.selectFromDropDownModal("Import",driver.findElement(lead.ActionDropDownList));
				  Thread.sleep(3000);
				  util.sendValue(driver.findElement(lead.UplaodOptionInIMport), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
				  Thread.sleep(3000);
				  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				  Thread.sleep(2000);
				  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				  String importSuccess = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				  importLead.assertEquals(importSuccess, lead.importSuccessMessage);
				  util.waitForElementAndClick(driver.findElement(lead.LeadMenu));
				  Thread.sleep(3000);
				  String importLeadInListing = util.loopColumnFindName("Import", driver.findElement(lead.LeadTable));
				  Assert.assertEquals(importLeadInListing, "Import");
				  
			  }
			  
			  void changeOwnerforAllLeads () throws InterruptedException, IOException{
				  SoftAssert changeOwnerforAllLeads = new SoftAssert ();
				  util.waitForElementAndClick(driver.findElement(lead.AllSelect));
				  util.waitForElementAndClick(driver.findElement(lead.ChangeOwnerInAllSlect));
				  util.handleDropdown(driver.findElement(lead.ChangeleadOwnerOption), lead.changeOwnerTo);
				  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				  String changeOwnerSucesMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				  changeOwnerforAllLeads.assertEquals(changeOwnerSucesMessage, lead.changeOwnerSucessMessage);
					 try {
						 if (statusOfActionPopup==true){
							 driver.findElement(lead.CancelOptionActionPopup).click();
							 if (util.isAlertPresent()){
							 util.acceptAlert();
							 }
						 }
					 }
					 catch(Exception E){ 
						 if (util.isAlertPresent()){
							 util.acceptAlert();
							 }
					 }
					 
					util.waitForElementAndClick(driver.findElement(lead.AllSelect)); 
					driver.navigate().refresh();
					String AssignedTo1 = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
					String AssignedTo2 = util.getColumndata("Assigned To", excel.readFromExcel(0, 2, 1));
					String AssignedTo13 = util.getColumndata("Assigned To", excel.readFromExcel(0, 3, 1));
					changeOwnerforAllLeads.assertEquals(AssignedTo1, lead.changeOwnerTo);
					changeOwnerforAllLeads.assertEquals(AssignedTo2, lead.changeOwnerTo);
					changeOwnerforAllLeads.assertEquals(AssignedTo13, lead.changeOwnerTo);
					changeOwnerforAllLeads.assertAll();
				  
			  }
			  
			  
			  void addNoteForAll () throws InterruptedException, IOException{
				  util.waitForElementAndClick(driver.findElement(lead.AllSelect));
				  Thread.sleep(3000);
				  util.waitForElementAndClick(driver.findElement(lead.MoreOptionInAllSelect));
				  util.selectFromDropDownModal("Add Note",driver.findElement(lead.AllSelectMoreDropdown));
				  util.sendValue(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 3, 1));
				  util.sendValue(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 3, 2));
				  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				  String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				  Assert.assertEquals(sucessMessage, lead.addNoteSucessMessage);
			  }
			  
			  void verifyLogcallInDetailsPage () throws IOException{
				  SoftAssert verifyLogcallInDetailsPage = new SoftAssert ();
				  String logAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(4,1,0));
				  System.out.println(excel.readFromExcel(4,1,0));
				  System.out.println(logAddedFromListing);
				  String logAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(4,2,0));
				  System.out.println(logAddedFromDetails);
				  
				  verifyLogcallInDetailsPage.assertNotNull(logAddedFromListing);
				  verifyLogcallInDetailsPage.assertNotNull(logAddedFromDetails);
				 
				  verifyLogcallInDetailsPage.assertAll();
			  
			  }
			  
			  void verifyAddNoteInDetailsPage () throws IOException{
				  SoftAssert verifyAddNoteInDetailsPage = new SoftAssert ();
				  String noteAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(5,1,0));
				  String noteAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(5,2,0));
				  String noteAddedFromAllSelect = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(5,3,0));
				  verifyAddNoteInDetailsPage.assertNotNull(noteAddedFromListing);
				  verifyAddNoteInDetailsPage.assertNotNull(noteAddedFromDetails);
				  verifyAddNoteInDetailsPage.assertNotNull(noteAddedFromAllSelect);
				  verifyAddNoteInDetailsPage.assertAll();
			  
			  }
			  
			  
			  void verifyEventAddedInDetailsPage() throws IOException{
				  SoftAssert verifyEventAddedInDetailsPage = new SoftAssert ();
				  String eventAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(6,1,0));
				  String eventAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(6,2,0));
				  verifyEventAddedInDetailsPage.assertNotNull(eventAddedFromListing);
				  verifyEventAddedInDetailsPage.assertNotNull(eventAddedFromDetails);
				  verifyEventAddedInDetailsPage.assertAll();
			  }
			  
			  
			  void verifyTaskAddedInDetailsPage() throws IOException{
				  SoftAssert verifyTaskAddedInDetailsPage = new SoftAssert ();
				  String taskAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(7,1,0));
				  String taskAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(7,2,0));
				  verifyTaskAddedInDetailsPage.assertNotNull(taskAddedFromListing);
				  verifyTaskAddedInDetailsPage.assertNotNull(taskAddedFromDetails);
				  verifyTaskAddedInDetailsPage.assertAll();
			  }
			  
			  void editFromDetailsPage () throws IOException{
				  util.waitForElementAndClick(driver.findElement(leadDetails.EditButtonInDetailsPage));
				  util.sendValue(driver.findElement(leadEntry.CompanyName), excel.readFromExcel(0, 1, 3)+ " "+ "Edited From Details");
				  util.sendValue(driver.findElement(leadEntry.CompanyName), excel.readFromExcel(0, 1, 4)+ " "+ "Edited From Details");
				  util.handleDropdown(driver.findElement(leadEntry.LeadStatus), "Qualified");
				  
			  }
			
			
		}

		
		
		//////////////////////////////////////////////////////Contact Test Cases///////////////////////////////////////////
		
		package Testcases;

		import java.io.IOException;
		import java.util.List;

		import org.json.simple.parser.ParseException;
		import org.openqa.selenium.By;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebElement;
		import org.testng.Assert;
		import org.testng.annotations.Test;
		import org.testng.asserts.SoftAssert;

		import BasePackage.DriverClass;
		import Pages.ContactsEntry;
		import Pages.ContactsListing;
		import Pages.EventEntry;
		import Pages.ExcelReader;
		import Pages.LeadDetails;
		import Pages.LeadEntry;
		import Pages.LeadListing;
		import Pages.PCUtility;

	
		    ContactsEntry contactentry = new ContactsEntry();
			ContactsListing contactlist = new ContactsListing();
			PCUtility util = new PCUtility ();
			LeadListing lead = new LeadListing();
			ExcelReader excel = new ExcelReader ();
			LeadEntry leadEntry = new LeadEntry();
			LeadDetails leadDetails = new LeadDetails ();
			
			public boolean statusOfActionPopup;
			public void addContacts() throws InterruptedException, IOException, ParseException {
				// util.login();
				Thread.sleep(5000);
				util.waitForElementAndClick(driver.findElement(contactlist.Conatctmenu));
				Thread.sleep(5000);
				util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
				Thread.sleep(3000);
				contactentry.contactsCreate(2, 1);
				statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
				util.waitForElementAndClick(driver.findElement(contactentry.Save));
				String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(sucessMessage, contactentry.contactsSucessMessage);

			}

			*//**
			 * leadTable = Lead React table leadName = excel.readFromExcel(1, 1, 1); =
			 * Lead name from Excel sheet windowHandle = Window handler for switching to
			 * New tab softAssert = Assert more than one value leadStatusBeforRefresh =
			 * Verifying the Lead before create switchToNewTab = Switing to new Tab
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
		   public Integer contactPosition;
			void refresh() throws IOException, InterruptedException {
				Thread.sleep(3000);
				String curentURl = driver.getCurrentUrl();
				util.switchToNewTab();
				util.switchbackToMainTab(1);
				driver.get(curentURl);
				Thread.sleep(3000);
				WebElement CreateButton = driver.findElement(contactlist.CreateNew);
				util.waitForElementAndClick(CreateButton);
				contactentry.contactsCreate(2, 2);
				util.waitForElementAndClick(driver.findElement(contactentry.Save));
				Thread.sleep(3000);
				util.switchbackToMainTab(0);
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				String conatctAfterRefresh = util.loopColumnFindName(excel.readFromExcel(2, 0, 1),
						driver.findElement(lead.LeadTable));
				contactPosition = new Integer (util.rowCount);
				Assert.assertEquals(conatctAfterRefresh, excel.readFromExcel(2, 0, 1));
			}

			void latestContactPosition(){
				Assert.assertEquals(contactPosition, "1");
			}
			*//**
			 * bulk.createLead(0, 3) = Creating lead 0 = sheet number, 3 row number
			 * 
			 * @throws InterruptedException
			 *//*

			void saveAndNew() throws InterruptedException {
				WebElement CreateButton = driver.findElement(lead.CreateLeadOption);
				util.waitForElementAndClick(CreateButton);
				contactentry.contactsCreate(2, 3);
				util.waitForElementAndClick(driver.findElement(leadEntry.SaveandNewButton));
				leadtest.statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
				Assert.assertEquals(leadtest.statusOfActionPopup, true);
				try {
					if (leadtest.statusOfActionPopup == true) {
						contactentry.contactsCreate(2, 4);
						util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
					}

				} catch (Exception e) {
					util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
					util.acceptAlert();
				}
				Thread.sleep(3000);
			}

			*//**
			 * recordSelection = Selecting 100 from record selction leadname = Verify
			 * lead in listing page, if lead available in listing page, its returns Lead
			 * name, else null util.loopColuumFindName = Loop the React table and get
			 * the lead name excel.readFromExcel(1, 1, 1) = Read from excel sheet
			 * = @param Sheet Number, Row number and Column number
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			void verifyContactsInListngPage() throws IOException, InterruptedException {
				util.recordSelection("100 rows");
				Thread.sleep(3000);
				SoftAssert contactsStatus = new SoftAssert();
				String contactname1 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1) + " " + excel.readFromExcel(2, 1, 2),
						driver.findElement(lead.LeadTable));
				String contactname2 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2),
						driver.findElement(lead.LeadTable));
				String contactname3 = util.loopColumnFindName(excel.readFromExcel(2, 3, 1) + " " + excel.readFromExcel(2, 3, 2),
						driver.findElement(lead.LeadTable));
				contactsStatus.assertEquals(contactname1, excel.readFromExcel(2, 1, 1) + " " + excel.readFromExcel(0, 1, 2));
				contactsStatus.assertEquals(contactname2, excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(0, 2, 2));
				contactsStatus.assertEquals(contactname3, excel.readFromExcel(2, 3, 1) + " " + excel.readFromExcel(0, 3, 2));
				System.out.println("verifyLeadsInListngPagen value in the table are " + contactname1 + "" + contactname2 + ""
						+ contactname3);
				contactsStatus.assertAll();

			}

			*//**
			 * Verify Search excel.readFromExcel(1, 1, 1) = Read from excel sheet
			 * = @param Sheet Number, Row number and Column number
			 * waitForElementAndClick = Wait for the element and click once element is
			 * displayed
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			void verifySearch(By element) throws IOException, InterruptedException {
				SoftAssert searchCOntact = new SoftAssert();
				util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
				util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(2, 2, 1));
				System.out.println("Sendng values to search box");
				Thread.sleep(4000);
				String contactName1 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2),
						driver.findElement(lead.LeadTable));
				System.out.println("verifyLeadsInListngPagen value in the table are " + contactName1);
				String contactName2 = util.loopColumnFindName(excel.readFromExcel(2, 3, 1), driver.findElement(lead.LeadTable));
				System.out.println(contactName2);
				searchCOntact.assertEquals(contactName1, excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2));
				searchCOntact.assertNull(contactName2);
				driver.navigate().refresh();
				util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
				util.sendValue(driver.findElement(element), excel.readFromExcel(2, 2, 5));
				String leadnameByMobile = util.loopColumnFindName(
						excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2), driver.findElement(lead.LeadTable));
				searchCOntact.assertEquals(leadnameByMobile, excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2));
				searchCOntact.assertAll();
				driver.navigate().refresh();
			}

			*//**
			 * Creating page view clickOnElementIfNotDispayed = If page view is not
			 * displayed, Click on Custom page view button enableToggle = Enable the
			 * column excel.readFromExcel(1, 1, 1) = Read from excel sheet = @param
			 * Sheet Number, Row number and Column number customPageView1 = Name of the
			 * custom page view
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*

			public String customPageViewContacts;

			void createPageView() throws IOException, InterruptedException {
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				util.selectFromDropDownModal("Create View", driver.findElement(lead.CustomViewModel));

				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 2));// Enable
																												// Company
				System.out.println("Ebabled Toggle of Company ");
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 10, 2));// Enable
																												// Assign
																												// to
				System.out.println("Ebabled Toggle of Assigne to");
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 2));// Enable
																												// Lead
																												// Status
				System.out.println("Ebabled Toggle of Lead Status");
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 14, 2));// Enable
																												// Designation
				System.out.println("Ebabled Toggle of Designation");
				util.disableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 8, 2));// Disable
																												// salutaion
				System.out.println("Desable Toggle Saluatation");
				customPageViewContacts = excel.readFromExcel(3, 0, 1);
				util.sendValue(driver.findElement(lead.InputBoxSaveCustomView), customPageViewContacts);
				util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(sucessMessage, lead.createPageSucessMessage);
				Thread.sleep(3000);

			}

			*//**
			 * Verify create page view after creating, columnSizeInCustomPage =
			 * actualColumnSize = Getting column size after redirecting to new custom
			 * page view allColumnNames = Getting all column header names
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			void verifyCreatedPageViewContacts() throws IOException, InterruptedException {
			
				util.tableHeader();
				int actualNoColums = util.actaulHeaderSize;
				int expectedNoColumns = 4;
				SoftAssert verifyCreatedPageViewContacts = new SoftAssert();
				List<String> allColumnNames = util.tableHeader();
				System.out.println(allColumnNames);
				boolean firstColumn = allColumnNames.contains(excel.readFromExcel(3, 5, 2));
				System.out.println(firstColumn);
				boolean thirdColumn = allColumnNames.contains(excel.readFromExcel(3, 10, 2));
				boolean fourthColumn = allColumnNames.contains(excel.readFromExcel(3, 3, 2));
				boolean fifthColumn = allColumnNames.contains(excel.readFromExcel(3, 14, 2));
				verifyCreatedPageViewContacts.assertEquals(firstColumn, true);
				verifyCreatedPageViewContacts.assertEquals(thirdColumn, true);
				verifyCreatedPageViewContacts.assertEquals(fourthColumn, true);
				verifyCreatedPageViewContacts.assertEquals(fifthColumn, true);
				verifyCreatedPageViewContacts.assertAll();
				Thread.sleep(3000);
			}

			// TO DO - Pending from client
			void verifyDefaultViewContacts() throws InterruptedException, IOException {
				
				util.tableHeader();
				int actualColumnSize = util.actaulHeaderSize;
				int expectedColumn = 9;
				SoftAssert verifyDefaultViewContacts = new SoftAssert();
				List<String> allColumnNames = util.tableHeader();
				System.out.println(allColumnNames);
				boolean contactName = allColumnNames.contains("Contact Name");
				boolean accountName = allColumnNames.contains(excel.readFromExcel(3, 5, 2));
				boolean customerID = allColumnNames.contains(excel.readFromExcel(3, 1, 2));
				boolean email = allColumnNames.contains(excel.readFromExcel(3, 6, 2));
				boolean asignTo = allColumnNames.contains(excel.readFromExcel(3, 10, 2));
				boolean desgigantion = allColumnNames.contains(excel.readFromExcel(3, 10, 2));
				boolean createdDate = allColumnNames.contains(excel.readFromExcel(3, 28, 2));
				boolean officephone = allColumnNames.contains(excel.readFromExcel(3, 7, 2));
				boolean state = allColumnNames.contains(excel.readFromExcel(3, 27, 2));
				verifyDefaultViewContacts.assertEquals(accountName, true);
				verifyDefaultViewContacts.assertEquals(asignTo, true);
				verifyDefaultViewContacts.assertEquals(email, true);
				verifyDefaultViewContacts.assertEquals(customerID, true);
				verifyDefaultViewContacts.assertEquals(desgigantion, true);
				verifyDefaultViewContacts.assertEquals(createdDate, true);
				verifyDefaultViewContacts.assertEquals(officephone, true);
				verifyDefaultViewContacts.assertEquals(state, true);
				verifyDefaultViewContacts.assertAll();
				Thread.sleep(3000);

			}

			*//**
			 * Verify the Custom page view in saved page view
			 * clickOnElementIfNotDispayed = Clicking saved page icon
			 * excel.readFromExcel(1, 1, 1) = Read from excel sheet = @param Sheet
			 * Number, Row number and Column number customPageView =
			 * returnValueFromReactDropDownModel = Getting the text from Saved page view
			 * dropdown model
			 * 
			 *//*
			void verifyCustomViewInSavedPageViewsContacts() {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				String customPageView = util.returnValueFromReactDropDownModel(customPageViewContacts);
				System.out.println(customPageView);
				Assert.assertEquals(customPageView, customPageViewContacts);
				try {
					util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
					util.selectFromDropDownModal("customPageViewContacts", driver.findElement(lead.CustomViewModel));
				} catch (Exception E) {

				}
			}

			*//**
			 * Edit custom view excel.readFromExcel(1, 1, 1) = Read from excel sheet
			 * = @param Sheet Number, Row number and Column number
			 * selectFromDropDownModal("Edit View"); = Click on Edit View from the
			 * dropdown list disableToggle = Disable the column
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*
			void editCustomViewContacts() throws IOException, InterruptedException {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				util.selectFromDropDownModal(customPageViewContacts, driver.findElement(lead.SavedPageView));
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				util.selectFromDropDownModal("Edit View", driver.findElement(lead.CustomViewModel));
				util.disableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 2));
				System.out.println("Disabling toggle Toggle");
				util.disableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 2));
				customPageViewContacts = excel.readFromExcel(3, 0, 1);
				util.sendValue(driver.findElement(lead.InputBoxInEditView), customPageViewContacts + " " + "edited");// Editing
																														// //
																														// name
				System.out.println("Disabling toggle Toggle");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInEditPageView));
				String updatedSucess = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(updatedSucess, lead.editPageSucessMessage);
			}

			*//**
			 * allColumnNames = Reading all columns from table header
			 * excel.readFromExcel(1, 1, 1) = Read from excel sheet = @param Sheet
			 * Number, Row number and Column number excel.readFromExcel = Read the data
			 * from excel sheet to disble the column @param Sheet Number, Row number and
			 * Column number
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 *//*

			void pageViewAfterEditContacts() throws IOException, InterruptedException {
				SoftAssert pageViewAfterEditContacts = new SoftAssert();
				List<String> allColumnNames = util.tableHeader();
				System.out.println(allColumnNames);
				boolean thirdColumn = allColumnNames.contains(excel.readFromExcel(3, 5, 2));
				boolean fourthColumn = allColumnNames.contains(excel.readFromExcel(3, 1, 2));
				pageViewAfterEditContacts.assertEquals(thirdColumn, false);
				pageViewAfterEditContacts.assertEquals(fourthColumn, false);
				pageViewAfterEditContacts.assertAll();

			}

			*//**
			 * Verifying page view saved after Edit customPageView = Getting the name
			 * after editing from saved list excel.readFromExcel(1, 1, 1) = Read from
			 * excel sheet = @param Sheet Number, Row number and Column number
			 * 
			 * @throws IOException
			 *//*
			void pageViewInSavedPageAfterEditContacts() throws IOException {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				customPageViewContacts = excel.readFromExcel(3, 0, 1);
				String customPageView = util.returnValueFromReactDropDownModel(customPageViewContacts + " " + "edited");
				System.out.println(customPageView);
				Assert.assertEquals(customPageView, customPageViewContacts + " " + "edited");
			}

			*//**
			 * Delete Page view selectFromDropDownModal = Selecting the customized page
			 * view from saved page view excel.readFromExcel(1, 1, 1) = Read from excel
			 * sheet = @param Sheet Number, Row number and Column number
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			void deletePageViewContacts() throws InterruptedException, IOException {
				customPageViewContacts = excel.readFromExcel(3, 0, 1);
				try {
					util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
					Thread.sleep(4000);
					util.selectFromDropDownModal(customPageViewContacts + " " + "edited",
							driver.findElement(lead.CustomViewModel));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				util.selectFromDropDownModal("Delete View", driver.findElement(lead.CustomViewModel));
				Thread.sleep(3000);
				int columnSizeInCustomPage = 3;
				util.tableHeader();
				int actualColumnSize = util.actaulHeaderSize;
				boolean columnSizeStatus = !(columnSizeInCustomPage == actualColumnSize);
				SoftAssert deletePageViewContacts = new SoftAssert();
				deletePageViewContacts.assertTrue(columnSizeStatus);
				deletePageViewContacts.assertAll();
			}

			void contactsTabsandCommonValidationOutvalidation() throws InterruptedException {
				util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
				driver.findElement(contactentry.LastName).click();
				driver.findElement(contactentry.LastName).sendKeys(Keys.TAB);
				String lastNameValidation = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
				driver.findElement(contactentry.Email).click();
				driver.findElement(contactentry.Email).sendKeys("sdfsdfdsf");
				String emailIdError = util.getValidationMessage(driver.findElement(leadEntry.emailFieldvaldiation));
				SoftAssert contactsTabsOutvalidation = new SoftAssert();
				contactsTabsOutvalidation.assertEquals(lastNameValidation, contactentry.lastNamevaldiationMessage);
				contactsTabsOutvalidation.assertEquals(emailIdError, contactentry.emailValidationMessage);
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				try{
					if (util.isAlertPresent()==true){
						util.acceptAlert();
					}
				}
					catch(Exception e){	
					}
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
				driver.findElement(contactentry.Email).sendKeys("sdfsdfdsf");
				util.waitForElementAndClick(driver.findElement(contactentry.Save));
				String commonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				String lastNameValidation1 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
				String emailIdError1 = util.getValidationMessage(driver.findElement(leadEntry.emailFieldvaldiation));
				contactsTabsOutvalidation.assertEquals(lastNameValidation1, contactentry.lastNamevaldiationMessage);
				contactsTabsOutvalidation.assertEquals(emailIdError1, contactentry.emailValidationMessage);
				contactsTabsOutvalidation.assertEquals(commonError, leadEntry.CommonValidationMEssage);
				contactsTabsOutvalidation.assertAll();
		  
			}

			void verifyAlertwhileClosing() throws InterruptedException {
				util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
				contactentry.contactsCreate(2, 1);
				util.waitForElementAndClick(driver.findElement(contactentry.Cancel));
				String alertText = util.getAlertMessage();
				util.acceptAlert();
				Assert.assertEquals(alertText, leadEntry.alertMessage);
			}

			void verifyAlertWithOutEntering() {
				util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
				util.waitForElementAndClick(driver.findElement(contactentry.Cancel));
				boolean alert = util.isAlertPresent();
				Assert.assertFalse(alert);
				
			}

			void addLogValidationsListing() throws InterruptedException, IOException {
				SoftAssert addLogValidationsListing = new SoftAssert();
				util.clickOnActions(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log a Call", driver.findElement(lead.ActionMenuModel));
				util.waitForElementAndClick(driver.findElement(lead.SubjectLogCall));
				Thread.sleep(2000);
				driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
				String validationMsg = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				addLogValidationsListing.assertEquals(validationMsg, lead.addLogFieldvaldiationMessage);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				String addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				addLogValidationsListing.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
				addLogValidationsListing.assertAll();

			}

			void addLogcallListing() throws IOException, InterruptedException {
				Thread.sleep(3000);
				// TODO: firstPara = row, secandPara = collumn
				util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log a Call", driver.findElement(lead.ActionMenuModel));
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 1, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.DetailsLogCall), excel.readFromExcel(4, 1, 1));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(logConfirmation, lead.addLogSucessMessage);
				Thread.sleep(3000);
			}

			void addNoteListing() throws InterruptedException, IOException {
				util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Note", driver.findElement(lead.ActionMenuModel));
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 1, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 1, 1));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(logConfirmation, lead.addNoteSucessMessage);
				Thread.sleep(3000);
			}

			void addNotevalidationListing() throws InterruptedException, IOException {
				SoftAssert addNotevalidationMessage = new SoftAssert();
				util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Note", driver.findElement(lead.ActionMenuModel));
				util.waitForElementAndClick(driver.findElement(lead.SubjectNote));
				Thread.sleep(2000);
				driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
				String validationMsg = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				addNotevalidationMessage.assertEquals(validationMsg, lead.addNoteFieldvaldiationMessage);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				addNotevalidationMessage.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
				addNotevalidationMessage.assertAll();
			}

			EventEntry evententry = new EventEntry();

			void addEvent() throws InterruptedException, IOException {
				Thread.sleep(3000);
				util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event", driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				evententry.createEvent(6, 1);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				Assert.assertEquals(sucessMEsssage, evententry.successMessage);
			}

			*//**
			 * Tabs out valdiation error for Event addEventValidationError : Assert all
			 * values
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 *//*
			void tabsOutvalidationEvent() throws InterruptedException, IOException {
				SoftAssert addEventValidationError = new SoftAssert();
				util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event", driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(evententry.Sujbect));
				driver.findElement(evententry.Sujbect).sendKeys(Keys.TAB);
				String subjectvalError = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
				driver.findElement(evententry.EventType).click();
				driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
				driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
				String eventTypevalError = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
				driver.findElement(evententry.StartDateTime).click();
				driver.findElement(evententry.StartDateTime).sendKeys(Keys.TAB);
				String StartdatevalError = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
				driver.findElement(evententry.EndDateTime).click();
				driver.findElement(evententry.EndDateTime).sendKeys(Keys.TAB);
				String EnddatevalError = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
				addEventValidationError.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
				addEventValidationError.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
				addEventValidationError.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
				addEventValidationError.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String commonvalidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
				addEventValidationError.assertEquals(commonvalidation, evententry.commonValidationMessage);
				util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
				addEventValidationError.assertAll();

			}

			void addAttachement() throws InterruptedException, IOException {
				driver.navigate().refresh();
				util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Attachment", driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.uploadinAttachemnt));
				util.sendValue(driver.findElement(lead.uploadinAttachemnt), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
				util.sendValue(driver.findElement(lead.DetailsInAttachment), "Adding file ");
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				try {
					String success = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
					driver.navigate().refresh();
					System.out.println(success);
					Assert.assertEquals(success, lead.addAttachmentSucessMessage);

				} catch (Exception E) {
					driver.navigate().refresh();
				}
			}

			void inlineEditInLeadTable() throws IOException, InterruptedException {
				Thread.sleep(3000);
				try {
					util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
					util.selectFromDropDownModal("Create View", driver.findElement(lead.CustomViewModel));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 2, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 2));// Enable
																													// Company
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 2));// Enable
																													// Assign
																													// to
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 2));// Enable
																													// Lead
																													// Status
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 6, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 7, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 8, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 9, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 10, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 11, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 12, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 13, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 14, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 15, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 16, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 17, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 18, 2));
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 19, 2));
					util.sendValue(driver.findElement(lead.InputBoxSaveCustomView), "InLineEditView");
					util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Thread.sleep(3000);
				String emailEdit = "inlineedit@gmail.com";
				SoftAssert inlineEditInLeadTable = new SoftAssert();
				try {
					Thread.sleep(3000);
					String companyName = util.getColumndata("Account Name", excel.readFromExcel(2, 2, 1));
					String companyNameEdit = companyName + " " + "Edited";
					util.inlineEditInTable("Account Name", excel.readFromExcel(2, 2, 1));
					util.sendValue(driver.findElement(contactentry.Accountname), companyNameEdit);
					util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					String companyNameAfterEdit = util.getColumndata("Company", excel.readFromExcel(2, 2, 1));
					Thread.sleep(3000);
					inlineEditInLeadTable.assertNotEquals(companyName, companyNameAfterEdit);
				} catch (Exception E) {

					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));

				}
				try {
					String departMennt = util.getColumndata("Department", excel.readFromExcel(2, 2, 1));
					String designationEdit = departMennt + " " + "Edited";
					util.inlineEditInTable("Department", excel.readFromExcel(2, 2, 1));
					util.sendValue(driver.findElement(contactentry.Department), designationEdit);
					util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					Thread.sleep(4000);
					String designationAfterEdit = util.getColumndata("Designation", excel.readFromExcel(2, 2, 1));
					inlineEditInLeadTable.assertNotEquals(departMennt, designationAfterEdit);
				} catch (Exception e) {

					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));

				}
				try {
					String decisionAuthority = util.getColumndata("Decision Authority", excel.readFromExcel(2, 2, 1));
					util.inlineEditInTable("Decision Authority", excel.readFromExcel(2, 2, 1));
					util.handleDropDownByIndex(driver.findElement(contactentry.DecisionAuthority), 3);
					util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					Thread.sleep(3000);
					String leadStatusAfterChange = util.getColumndata("Decision Authority", excel.readFromExcel(2, 2, 1));
					inlineEditInLeadTable.assertNotEquals(decisionAuthority, leadStatusAfterChange);
				} catch (Exception e) {

					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));

				}
				try {
					String email = util.getColumndata("Email", excel.readFromExcel(2, 2, 1));
					util.inlineEditInTable("Email", excel.readFromExcel(2, 2, 1));
					util.sendValue(driver.findElement(contactentry.Email), emailEdit);
					util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					Thread.sleep(3000);
					String emailAfterEdit = util.getColumndata("Email", excel.readFromExcel(2, 2, 1));
					inlineEditInLeadTable.assertNotEquals(email, emailAfterEdit);
				} catch (Exception e) {

					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));

				}
				try {
					String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(2, 2, 1));
					util.inlineEditInTable("Assigned To", excel.readFromExcel(2, 2, 1));
					util.handleDropDownByIndex(driver.findElement(contactentry.AssignTo), 3);
					util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					Thread.sleep(3000);
					String AssignToAfterEdit = util.getColumndata("Assigned To", excel.readFromExcel(2, 2, 1));
					inlineEditInLeadTable.assertNotEquals(AssignTo, AssignToAfterEdit);
				} catch (Exception e) {

					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));

				}

				try {
					String mobileNumber = util.getColumndata("Mobile Number", excel.readFromExcel(2, 2, 1));
					String mobileNumberEdit = mobileNumber + " " + "02";
					util.inlineEditInTable("Mobile Number", excel.readFromExcel(2, 2, 1));
					util.sendValue(driver.findElement(contactentry.MobileNumber), mobileNumberEdit);
					util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					Thread.sleep(3000);
					String mobileNumberAfterEdit = util.getColumndata("Mobile Number", excel.readFromExcel(2, 2, 1));
					inlineEditInLeadTable.assertNotEquals(mobileNumber, mobileNumberAfterEdit);
				} catch (Exception e) {

					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));

				}

				inlineEditInLeadTable.assertAll();

			}

			void verifyFilter() throws IOException, InterruptedException {
				Thread.sleep(4000);
				SoftAssert verifyFilter = new SoftAssert();
				try {
					util.waitForElementAndClick(driver.findElement(lead.FilterOption));
					Thread.sleep(3000);
					try {
						util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Email");
					} catch (Exception E) {
						util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Email");
					}
					util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 1));
					util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					Thread.sleep(3000);
					String leadname1 = util.loopColumnFindName(
							excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(0, 1, 2),
							driver.findElement(lead.LeadTable));
					verifyFilter.assertNotNull(leadname1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					try {
						util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Company");
					} catch (Exception E) {
						util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Company");
					}
					// util.handleDropdown(driver.findElement(lead.FilterFieldBy1),
					// "Company");
					util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 3));
					util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					String leadname2 = util.loopColumnFindName(
							excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2),
							driver.findElement(lead.LeadTable));
					verifyFilter.assertNotNull(leadname2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));

					try {
						util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Status");
					} catch (Exception E) {
						util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "First Name");
					}
					util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Status");
					util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0, 1, 17));
					util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					String leadname3 = util.loopColumnFindName(
							excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2),
							driver.findElement(lead.LeadTable));
					verifyFilter.assertNotNull(leadname3);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					try {
						util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
						util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");
					} catch (Exception E) {
						util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "First Name");
					}
					util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 1));
					util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					util.waitForElementAndClick(driver.findElement(lead.FilterAddNewFilter));
					util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
					util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");
					util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 2));
					util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					String leadname4 = util.loopColumnFindName(
							excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2),
							driver.findElement(lead.LeadTable));
					String leadname5 = util.loopColumnFindName(
							excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2),
							driver.findElement(lead.LeadTable));
					verifyFilter.assertNotNull(leadname4);
					verifyFilter.assertNotNull(leadname5);
					Thread.sleep(3000);
					util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
					util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					String leadname6 = util.loopColumnFindName(
							excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2),
							driver.findElement(lead.LeadTable));
					String leadname7 = util.loopColumnFindName(
							excel.readFromExcel(0, 2, 1) + " " + excel.readFromExcel(0, 2, 2),
							driver.findElement(lead.LeadTable));
					verifyFilter.assertNotNull(leadname4);
					verifyFilter.assertNull(leadname5);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				verifyFilter.assertAll();
			}
			
			
		*//**
		 * 	
		 * @param name
		 * @param element
		 * @param validationMessageElement
		 * @param valdiationMessage
		 *//*
			
	void test (String [] name,By element ,By validationMessageElement,String valdiationMessage){
		for (int i =0;i<name.length;i++){
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(name);
			driver.findElement(element).sendKeys(Keys.TAB);
			String message = util.getValidationMessage(driver.findElement(validationMessageElement));
			Assert.assertEquals(message, valdiationMessage);;
		}
		
		
	
	void sdfhsdjksd(){
		String name [] = {"",};
		test(name,
				lead.ActionButton, 
				lead.ActionButton, 
				lead.addAttachmentSucessMessage);
	}
		
	
	}
			
		
			
			
			///////////////////////////////////////////DETAILS ADD LOG CALL< EVEVNT Fucntionalyt changes 
				  
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Fucntionaliy Changes >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		  /**
		   * 
		   * @throws IOException
		   *//*
		  void verifyLogcallInDetailsPage () throws IOException{
			 logAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(4,1,0));
			  System.out.println(excel.readFromExcel(4,1,0));
			  System.out.println(logAddedFromListing);
			  logAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(4,2,0));
			  System.out.println(logAddedFromDetails);
			 
			  
			  *//**NEED TO ASSERT IN TEST CASES
			   * SoftAssert verifyLogcallInDetailsPage = new SoftAssert ();
			   * verifyLogcallInDetailsPage.assertNotNull(logAddedFromListing);
			     verifyLogcallInDetailsPage.assertNotNull(logAddedFromDetails);
			     verifyLogcallInDetailsPage.assertAll();
			   *//*
		  
		  }*/
		  /**
		   * 
		   * @throws IOException
		   */
		/*  void verifyAddNoteInDetailsPage () throws IOException{
			  noteAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(5,1,0));
			  noteAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(5,2,0));
			  noteAddedFromAllSelect = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(5,3,0));
			  
			  
			  *//**NEED TO ASSERT IN TEST CASES
			   * SoftAssert verifyAddNoteInDetailsPage = new SoftAssert ();
			   * verifyAddNoteInDetailsPage.assertNotNull(noteAddedFromListing);
			  verifyAddNoteInDetailsPage.assertNotNull(noteAddedFromDetails);
			  verifyAddNoteInDetailsPage.assertNotNull(noteAddedFromAllSelect);
			  verifyAddNoteInDetailsPage.assertAll();
			   *//*
		  
		  }
		  */
		  /**
		   * 
		   * @throws IOException
		   */
		 /* void verifyEventAddedInDetailsPage() throws IOException{
			  eventAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(6,1,0));
			 eventAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(6,2,0));
	
			  *//**NEED TO ASSERT IN TEST CASES
			   * SoftAssert verifyEventAddedInDetailsPage = new SoftAssert ();
			   * verifyEventAddedInDetailsPage.assertNotNull(eventAddedFromListing);
			     verifyEventAddedInDetailsPage.assertNotNull(eventAddedFromDetails);
			     verifyEventAddedInDetailsPage.assertAll();
			   *//*
		  }*/
		  
		 /**
		  * 
		  * @throws IOException
		  */
		/*  void verifyTaskAddedInDetailsPage() throws IOException{
			  
			 taskAddedFromListing = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(7,1,0));
			  taskAddedFromDetails = util.loopActivityTable(driver.findElement(leadDetails.ActivityTablle), excel.readFromExcel(7,2,0));
			 
			  
			  *//**NEED TO ASSERT IN TEST CASES 
			   * SoftAssert verifyTaskAddedInDetailsPage = new SoftAssert ();
			   *  verifyTaskAddedInDetailsPage.assertNotNull(taskAddedFromListing);
			      verifyTaskAddedInDetailsPage.assertNotNull(taskAddedFromDetails);
			      verifyTaskAddedInDetailsPage.assertAll();
			   * @throws IOException
			   *//*
		  }
*/
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Fucntionaliy Changes >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			

package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadListing;
import Pages.PCUtility;



class TestRun{
	
	
	
	
	
}
			
			
			
			
			

