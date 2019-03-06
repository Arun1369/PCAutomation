

package Testcases;

import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.security.auth.callback.Callback;
import javax.swing.plaf.synth.SynthSpinnerUI;

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
import org.testng.asserts.Assertion;
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


class LeadTest extends DriverClass{
	
	
	/**
	 * Author : QA Team - Nichi in software solution pvt ltd 
	 * Lead Test Cases - 
	 */
	ExcelReader excel ;
	PCUtility util = new PCUtility();
	LeadListing lead = new LeadListing ();
	LeadEntry leadEntry = new LeadEntry();
	LeadDetails leadDetails = new LeadDetails ();
	public String customPageView1;
	boolean firstColumn,thirdColumn,fourthColumn,fifthColumn= false;
	BulkLeads bulk =new BulkLeads ();
	CommonFeature common = new CommonFeature();
	

	
	 void login() throws InterruptedException, IOException, ParseException {
		excel = new ExcelReader();
		util.login(excel.readFromExcel(1, 1, 1), excel.readFromExcel(1, 2, 1));
		Log.info("Login to Application");
	
	}
		
	
	
	
	

	
	/**
	 * leadTable = Lead React table
	 * leadName = excel.readFromExcel(1, 1, 1); = Lead name from Excel sheet
	 * windowHandle = Window handler for switching to New tab 
	 * softAssert = Assert more than one value
	 * leadStatusBeforRefresh = Verifying the Lead before create 
	 * switchToNewTab  = Switing to new Tab 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	 
	 void refresh () throws IOException, InterruptedException{ 
		Thread.sleep(3000);
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
		
		util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
		util.waitForElementAndClick(driver.findElement(lead.DefaultView));
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		String leadNameAfterRefresh = util.loopColumnFindName(excel.readFromExcel(0, 2, 1),driver.findElement(lead.LeadTable));
		Log.info(leadNameAfterRefresh + " " +"name found after refresh ");
		Assert.assertEquals(leadNameAfterRefresh, excel.readFromExcel(0, 2, 1));
		
	}
	
	/**
	 * Create Lead
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	 void createLead () throws InterruptedException, IOException{
		Thread.sleep(3000);
		WebElement CreateButton = driver.findElement(lead.CreateLeadOption);
		util.waitForElementAndClick(CreateButton);
		Thread.sleep(3000);
		statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		//Creating first lead from first row
		bulk.createLead(0, 1);
		util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
		String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		customPageView1 =  excel.readFromExcel(3, 0, 1);
		//Verifying the success message 
		Assert.assertEquals(sucessMessage, leadEntry.leadSucessMessage);
		Thread.sleep(3000);
		
	}
	 
	 
	
	 /**
	  * bulk.createLead(0, 3) = Creating lead 0 = sheet number, 3 row number
	  * @throws InterruptedException
	  */
	 public boolean statusOfActionPopup;
	void saveAndNew () throws InterruptedException, IOException{
		driver.navigate().refresh();
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		//Creating third lead from 
		Thread.sleep(2000);
		bulk.createLead(0, 3);
		util.waitForElementAndClick(driver.findElement(leadEntry.SaveandNewButton));
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
		verifyLeadsInListngPage();
		System.out.println(lasterPositionOfLeads + " "+ "Lastet position of leads ");
	}
	
	Integer lasterPositionOfLeads;
	void verifylateastLead() throws IOException{
		Assert.assertEquals(lasterPositionOfLeads, "1");
	}
	
	/**
	 * recordSelection = Selecting 100 from record selction 
	 * leadname  = Verify lead in listing page, if lead available in listing page, its returns Lead name, else null
	 * util.loopColuumFindName  = Loop the React table and get the lead name
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	 void verifyLeadsInListngPage () throws IOException, InterruptedException{
		util.recordSelection("100 rows");
		Thread.sleep(3000);
		SoftAssert leadsStatus = new SoftAssert ();
		String leadname1 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) , driver.findElement(lead.LeadTable));
		String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 2, 1), driver.findElement(lead.LeadTable));
		String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) , driver.findElement(lead.LeadTable));
		leadsStatus.assertEquals(leadname1, excel.readFromExcel(0, 1, 1) );
		leadsStatus.assertEquals(leadname2, excel.readFromExcel(0, 2, 1) );
		leadsStatus.assertEquals(leadname3, excel.readFromExcel(0, 3, 1) );
		System.out.println("verifyLeadsInListngPagen value in the table are " + leadname1 +""+leadname2+""+leadname3);
		leadsStatus.assertAll();
		
		
	}
	
	
	/**
	 * Verify Search 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * waitForElementAndClick  = Wait for the element and click once element is displayed
	 * @throws IOException
	 * @throws InterruptedException
	 */
	 void verifySearch () throws IOException, InterruptedException{
		SoftAssert search = new SoftAssert ();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		//Search for Second lead
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(0, 2, 1));
		Thread.sleep(4000);
		//verify Second lead is avilable in list
		String leadname = util.loopColumnFindName(excel.readFromExcel(0, 2, 1), driver.findElement(lead.LeadTable));
		System.out.println("testArun"+excel.readFromExcel(0, 2, 1) );
		System.out.println("verifyLeadsInListngPagen value in the table are " + leadname);
		//verity third lead. Expecting null as third lead lead should not available
		Thread.sleep(3000);
		String leadname2 = util.loopColumnFindName(excel.readFromExcel(1, 3, 1), driver.findElement(lead.LeadTable));
		search.assertEquals(leadname2, excel.readFromExcel(0, 2, 1) );
		//Expecting null, because searching only second lead
		search.assertNull(leadname2);		
		driver.navigate().refresh();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		//Serching with Second lead mobile number
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(0, 2, 5));
		Thread.sleep(3000);
		String leadnameByMobile = util.loopColumnFindName(excel.readFromExcel(0, 2, 1), driver.findElement(lead.LeadTable));
		search.assertEquals(leadnameByMobile, excel.readFromExcel(0, 2, 1));
		driver.navigate().refresh();
	//Searching with Laed Status
		util.sendValue(driver.findElement(lead.SearchbarOption), "Contacted");
		String statusContacted = util.loopColumnFindName("Contacted", driver.findElement(lead.LeadTable));
		//Checking lead status with "New" Available or not"
		String statusContacted1 = util.loopColumnFindName("New", driver.findElement(lead.LeadTable));
		//Searching with lead Status "Not Contacted" is available or not in lead table
		String statusContacted2 = util.loopColumnFindName("Not Contacted", driver.findElement(lead.LeadTable));
		driver.navigate().refresh();
		search.assertEquals(statusContacted, "Contacted");
		//If Status "NEW" is not available, will return as null
		search.assertNull(statusContacted1);
		//If Status "Not Contacted" is not available, will return as null
		search.assertNull(statusContacted2);
		search.assertAll();
		
	}
	
	/**
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
	 */
	public String namesOfToggles;
	void verifyDefaultEnabledColumn () throws InterruptedException{
		
			util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
			util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
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
		
		
	}
	
	
	/**
	 * Creating page view 
	 * Call the method and pass the column string
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	
	 */
	
	 void createPageView () throws IOException, InterruptedException{
		 
		 common.createPageView(
				 excel.readFromExcel(3, 1, 0),
				 excel.readFromExcel(3, 3, 0), 
				 excel.readFromExcel(3, 4, 0), 
				 excel.readFromExcel(3, 5, 0),
				 excel.readFromExcel(3, 11, 0), 
				 excel.readFromExcel(3, 15, 0));
		 driver.navigate().refresh();
		
	}
	//Checking Create custom page view validation while entering same name which is already exist 
	 void alreadyExistpageViewName() throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				Thread.sleep(3000);
				util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
				util.sendValue(driver.findElement(lead.InputBoxSaveCustomView), excel.readFromExcel(3, 0, 1));
				util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
				String valmessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
				Assert.assertEquals(valmessage, "Page view already exist");
	 }
	/**
	 * Verify create page view after creating, 
	 * columnSizeInCustomPage = 
	 * actualColumnSize = Getting column size after redirecting to new custom page view
	 * allColumnNames = Getting all column header names
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	 void verifyCreatedPageView() throws IOException, InterruptedException{
		 common.verifyCreatedPageView(excel.readFromExcel(3, 3, 0),
				 excel.readFromExcel(3, 4, 0), excel.readFromExcel(3, 5, 0), excel.readFromExcel(3, 11, 0));
		 
		 SoftAssert verifyCreatedPageView = new SoftAssert ();
		 verifyCreatedPageView.assertEquals(common.firstColumn1, true);
		 verifyCreatedPageView.assertEquals(common.thirdColumn1, true);
		 verifyCreatedPageView.assertEquals(common.fourthColumn1, true);
		 verifyCreatedPageView.assertEquals(common.fifthColumn1, true);
		 verifyCreatedPageView.assertAll ();
		
	}
	
	void verifyDefaultView () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
		//Switching to default view 
		util.waitForElementAndClick(driver.findElement(lead.DefaultView));
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
	/**
	 * Verify the Custom page view in saved page view 
	 * clickOnElementIfNotDispayed = Clicking saved page icon 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * customPageView = returnValueFromReactDropDownModel = Getting the text from Saved page view dropdown model
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 */
	 void verifyCustomViewInSavedPageViews () throws InterruptedException, IOException{
		 common.verifyCustomViewInSavedPageViews();
	
	}
	
	/**
	 * Verifying page view is selected or note
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * tick = Select icon in saved page view list
	 * allNames = All saved page names from saved page view list 
	 * customPageView1 = Customized page view which is cerated 
	 * 
	 * 
	 */
	 
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
	
	/**
	 * Edit custom view 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * selectFromDropDownModal("Edit View"); = Click on Edit View from the dropdown list 
	 * disableToggle  = Disable the column
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void editCustomView () throws IOException, InterruptedException{
		common.editCustomView(excel.readFromExcel(3, 0, 1), excel.readFromExcel(3, 3, 0), excel.readFromExcel(3, 4, 0));
		
	}
	
	/**
	 * allColumnNames  = Reading all columns from table header
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * excel.readFromExcel = Read the data from excel sheet to disble the column @param Sheet Number, Row number and Column number
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	void pageViewAfterEdit () throws IOException, InterruptedException{
		common.pageViewAfterEdit(excel.readFromExcel(3, 3, 0), excel.readFromExcel(3, 4, 0), excel.readFromExcel(3, 1, 0),
				excel.readFromExcel(3, 5, 0));
		SoftAssert pageViewAfterEditLead = new SoftAssert ();
		pageViewAfterEditLead.assertEquals(common.enabledColumnEdit1Page1, true);
		pageViewAfterEditLead.assertEquals(common.enabledColumnEditPage, true);
		pageViewAfterEditLead.assertEquals(common.desabledColumn1EditPage, false);
		pageViewAfterEditLead.assertEquals(common.desabledColumnEditPage, false);
		pageViewAfterEditLead.assertAll ();
		
		
	}
	
	
	/**
	 * Verifying page view saved after Edit 
	 * customPageView = Getting the name after editing from saved list 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 *
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	void pageViewInSavedPageAfterEdit() throws IOException, InterruptedException{
		common.pageViewInSavedPageAfterEdit();
		
	}
	
	
	/**
	 * Delete Page view
	 * selectFromDropDownModal = Selecting the customized page view from saved page view 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	 void deletePageView() throws InterruptedException, IOException {
		 common.deletePageView();
	
   }

	/**
	 * Verifying deleted view in saved page view list
	 * clickOnElementIfNotDispayed  = Open saved page view list 
	 * isViewSeleted  = Verify deleted page view in saved page view list 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
  void verifyDeletdViewInSavedViews () throws IOException, InterruptedException{
	  common.verifyDeletdViewInSavedViews();
		
	}
	
  
	/**
	 * enableToggle = Enable column 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * findElementAndSenkKeys = Sending the text to input box to create the column
	 * util.getValidationMessage = Get the validation message 
	 * disableToggle  = Disable the column
	 * 
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	 void validationCreatePageView () throws IOException, InterruptedException{
		 driver.navigate().refresh();
		 common.validationCreatePageView();
		 SoftAssert createValMsg = new SoftAssert ();
		 createValMsg.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
		 createValMsg.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
		createValMsg.assertAll();
		
	}
	
	 

	 void verifyButtonsBySelectingAlllead () throws InterruptedException{
		String userName        = "tester";
		WebElement table       = driver.findElement(lead.LeadTable);
		//String xpath1forJoin   = lead.xpath1forCheckBox;
		//String xpath2forJoin   = lead.xpath2forCheckBox;
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
	
	
	/**
	 * Adding log call
	 * clickOnActions  = Clicking on More Action icon based on user name
	 * selectFromDropDownModal  = Select Log a call from More Action dropdown list
       excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	
	 void addLogcallListing () throws IOException, InterruptedException{
		 common.addLogcallListing(excel.readFromExcel(0, 1, 1));
	
	}
	
	 
	
	/**
	 * Add log validations 
	 * addLogValidationMessage = Get the validation message
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	 void addLogValidationsListing () throws InterruptedException, IOException{
		 common.addLogValidationsListing(excel.readFromExcel(0, 1, 1));
			SoftAssert addLogValidationsListing = new SoftAssert();
			  addLogValidationsListing.assertEquals(common.tabsOutvalidationMsgforLogs, lead.addLogFieldvaldiationMessage);
			  addLogValidationsListing.assertEquals(common.addlogCommonError, leadEntry.CommonValidationMEssage);
			  addLogValidationsListing.assertAll();
			 
	
	}
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  * Checking Add log validation In details Page 
	  */
	 void addLogValidationsDetails () throws InterruptedException, IOException{
		 common.addLogValidationsDetails();
		 SoftAssert addLogValidationsDetails = new SoftAssert();
		  addLogValidationsDetails.assertEquals(common.LogvalidationMsgInDetails, lead.addLogFieldvaldiationMessage);
		 	addLogValidationsDetails.assertEquals(common.addlogCommonErrorInDeatils, leadEntry.CommonValidationMEssage);
			addLogValidationsDetails.assertAll();
			
		}
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	 void addLogErrorWhileClosing  () throws IOException, InterruptedException{
		 common.addLogErrorWhileClosing(excel.readFromExcel(0, 1, 1));
		
	 }
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void addlogErroWithOutchar () throws InterruptedException, IOException{
		 common.addlogErroWithOutchar(excel.readFromExcel(0, 1, 1));
	
	 }
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void changeOwner () throws InterruptedException, IOException{
		 common.changeOwner(excel.readFromExcel(0, 1, 1),"Change Assignee");
		
			
			
			
	 }
	 
	/**
	 * Add Note validation 
	 * clickOnActions  = Clicking on More Action icon based on user name
	 * selectFromDropDownModal  = Select Add Note from More Action dropdown list
       excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	  void addNotevalidationListing() throws InterruptedException, IOException{
		  common.addNotevalidationListing(excel.readFromExcel(0, 1, 1));
		  SoftAssert addNotevalidationDetails = new SoftAssert();
			  addNotevalidationDetails.assertEquals(common.noteSubjectvaldiatinListing, lead.addNoteFieldvaldiationMessage);
			  addNotevalidationDetails.assertEquals(common.addnoteCommonError, leadEntry.CommonValidationMEssage);
			addNotevalidationDetails.assertAll();
		 
		
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
		  common.addNoteErrorWhileClosing(excel.readFromExcel(0, 1, 1));
		 
		 }
		 
		 void addNoteErroWithOutchar () throws InterruptedException, IOException{
               common.addNoteErroWithOutchar(excel.readFromExcel(0, 1, 1));; 
		 }
	/**
	 * Add Note 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	 void addNoteListing() throws InterruptedException, IOException{
	     common.addNoteListing(excel.readFromExcel(0, 1, 1));
		
	}
	/**
	 * Add Note from Details page verify its listing or note in activity Table 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void addNoteInDetails () throws InterruptedException, IOException{
		common.addNoteInDetails();
		common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
				excel.readFromExcel(5, 2, 0), 
				driver.findElement(lead.LeadTable));
		common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
				excel.readFromExcel(5, 2, 1), 
				driver.findElement(lead.LeadTable));
		
	}
	

	 EventEntry evententry = new EventEntry();
	 
	 /**
	  * Adding Event from lead listing page 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	void addEvent () throws InterruptedException, IOException{
		common.addEvent(excel.readFromExcel(0, 1, 1));
	
	}
	
	
	void addEventInDeatilspage () throws InterruptedException, IOException{
		common.addEventInDeatilspage();
		common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent),
				excel.readFromExcel(5, 2, 0),
				driver.findElement(lead.LeadTable));
		
	}
	/**
	 * Tabs out valdiation error for Event
	 * addEventValidationError : Assert all values 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void tabsOutvalidationEvent () throws InterruptedException, IOException{
		common.tabsOutvalidationEvent(excel.readFromExcel(0, 1, 1));
		SoftAssert addEventValidationError = new SoftAssert ();
		 addEventValidationError.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
		addEventValidationError.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
		addEventValidationError.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
		addEventValidationError.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
		addEventValidationError.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
		addEventValidationError.assertAll();
		 
		
	
	}

	
	void tabsOutvalidationEventInDetails () throws InterruptedException, IOException{
		common.tabsOutvalidationEventInDetails();
		SoftAssert addEventValidationErrorDetails = new SoftAssert ();
		addEventValidationErrorDetails.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
		addEventValidationErrorDetails.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
		addEventValidationErrorDetails.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
		addEventValidationErrorDetails.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
		addEventValidationErrorDetails.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
		addEventValidationErrorDetails.assertAll();
		
		
	}
	/**
	 * Event Common validation 
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void commonvalidationEvent () throws InterruptedException, IOException{
		common.commonvalidationEvent(excel.readFromExcel(0, 1, 1));
		SoftAssert commonvalidationEvent = new SoftAssert ();
		commonvalidationEvent.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
		commonvalidationEvent.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
		commonvalidationEvent.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
		commonvalidationEvent.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
		commonvalidationEvent.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
		commonvalidationEvent.assertAll();
	
	}
	
	void commonvalidationEventDetails () throws InterruptedException, IOException{
		common.commonvalidationEventDetails();
		SoftAssert commonvalidationEventDetails = new SoftAssert ();
		commonvalidationEventDetails.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
		commonvalidationEventDetails.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
		commonvalidationEventDetails.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
		commonvalidationEventDetails.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
		commonvalidationEventDetails.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
		commonvalidationEventDetails.assertAll();
		
	}
	
	/**
	 * Verifying alert while closing the page 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	void addEventAlertWhileClosng () throws InterruptedException, IOException{
		common.addEventAlertWhileClosng(excel.readFromExcel(0, 1, 1));;
		
		
	}
	
	/**
	 * Adding Attachement from listing page 
	 * uploadFile = Setting path for field which need to uplaod 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void addAttachement () throws InterruptedException, IOException{
	  common.addAttachement(excel.readFromExcel(0, 1, 1), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
	
	}
	
	/**
	 * Common validation for Attachment 
	 * getValidationMessage = Getting the massage of the validation 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void attachmentCommonvalidation () throws InterruptedException, IOException{
	
	common.attachmentCommonvalidation(excel.readFromExcel(0, 1, 1));;
		
	}
	
	void addAttachementInDetails () throws InterruptedException, IOException{
		common.addAttachementInDetails("C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");;
		
	}
	
	void attachmentCommonvalidationInDetails () throws InterruptedException, IOException{
		common.attachmentCommonvalidationInDetails();
		
	}
	
	



	/**
	 * ClickOnActions  = Clicking on More Action icon based on user name
	   selectFromDropDownModal  = Select Add Task from More Action dropdown list
	   excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	 void deleteLeadFromListing () throws InterruptedException, IOException{
		 common.deleteLeadFromListing(excel.readFromExcel(0, 1, 1));
		
	}
	
	/**
	 * Verifying Lead Header
	 * headerTitle = Tile of Header
	 * @throws IOException
	 */
	 void getLeadDetailsHeader () throws IOException{
		util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		util.column.click();
		String headerTitle = util.getElementName(driver.findElement(leadDetails.TitleLeadDetails));
		Assert.assertEquals(headerTitle, "LEAD");
	}
	
	/**
	 * Verify lead details in Details page 
	 * @throws IOException
	 */
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
	

	/**
	 * Add log validations in details page
	 * addLogValidationMessage = Get the validation message
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	void addLogValidationInDetailsPage () throws InterruptedException{
		common.addLogValidationInDetailsPage();
		
	}
	

	/**
	 * Add Note validation in Detail Page 
	 * clickOnActions  = Clicking on More Action icon based on user name
	 * selectFromDropDownModal  = Select Add Note from More Action dropdown list
       excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	void addNotevalidationDetailsPage () throws InterruptedException, IOException{
		common.addNotevalidationDetailsPage();

	}
	


	 
	 
	 /**
	  * 
	  * @return  value of Entry field after clicking reset 
	  * @throws IOException
	  * @throws InterruptedException
	  */
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
	 
	 /**
	  * fieldvalueAfterReset  = value of Entry fields
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 void verifyAfterReset () throws IOException, InterruptedException{
		 beforeReset();
		 Thread.sleep(3000);
		 String fieldvalueAfterReset = beforeReset()[0] + "," + beforeReset()[1] + "," + beforeReset()[2] + "," +
				 beforeReset()[3] + "," + beforeReset()[4] + "," + beforeReset()[5] + "," +
				 beforeReset()[6] + "," + beforeReset()[7] + "," + beforeReset()[8];
		 
		 String expectedvalue = ",,,,,,,,";
	 }
	 
	 /**
	  * clickOnActions = Find the name and clicking on Delete
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void deleteLead () throws InterruptedException, IOException{
		 common.delete(excel.readFromExcel(0, 1, 1));
		
			
	 }
	 

	 

	 void verifyRedirctionToDetilspage () throws IOException, InterruptedException{
		 common.verifyRedirctionToDetilspage(excel.readFromExcel(0, 1, 1));
	
	 }
	 /**
	  * 
	  * @throws IOException
	  * excel.readFromExcel(0, 1, 3) - reading the details from Excel sheet
	  */
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
	
	 /**
	  * 
	  * @throws InterruptedException
	  */
	  void tabsValidationlead() throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
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
	  /**
	   * 
	   * @throws InterruptedException
	   */
	  void commonValdiationError () throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
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
	  /**
	   * 
	   * @throws InterruptedException
	   */
	   void verifyAlertwhileClosing () throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateLeadOption));
		  bulk.createLead(0, 2);
		  util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
		  String alertText = util.getAlertMessage();
		  util.acceptAlert();
		  Assert.assertEquals(alertText, leadEntry.alertMessage);
		   
	  }
	  /**
	   * 
	   * @throws InterruptedException
	   */
	  void verifyAlertWithoutChange () throws InterruptedException{
		  driver.navigate().refresh();
		  util.waitForElementAndClick(driver.findElement(lead.CreateLeadOption));
		  util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
		  boolean alertStatus = util.isAlertPresent();
		  System.out.println(alertStatus +"Alert Status");
		  Assert.assertFalse(alertStatus);
		  if (alertStatus==true){
			  util.acceptAlert(); 
		  }
	  }
	  /**
	   * 
	   * @throws IOException
	   * @throws InterruptedException
	   */
	  void addLogcallDetails() throws IOException, InterruptedException{
		  common.addLogcallDetails();
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall),
				  excel.readFromExcel(4, 2, 0), 
				  driver.findElement(lead.LeadTable));
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall),
				  excel.readFromExcel(4, 2, 1), 
				  driver.findElement(lead.LeadTable));
		
	  }
	  
	  //Discard the inline edit changes and Verify the Changes are not saved 
	  void discardInlineEdit() throws InterruptedException, IOException{
		  common.discardInlineEditChanges("Company", excel.readFromExcel(0, 1, 1), leadEntry.CompanyName);
	  }
	  
	  
	  
	  /**
	   * 
	   * @throws IOException
	   * @throws InterruptedException
	   */
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
			  util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
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
			driver.navigate().refresh();
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
			  util.acceptUnExpectedError();
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
			util.acceptUnExpectedError();
		}
		  try {
			String leadStatus = util.getColumndata("Lead Status", excel.readFromExcel(0, 1, 1));
			util.inlineEditInTable("Lead Status", excel.readFromExcel(0, 1, 1));
			  util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
			  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			  Thread.sleep(3000);
			  String leadStatusAfterChange = util.getColumndata("Lead Status", excel.readFromExcel(0, 1, 1));
			  inlineEditInLeadTable.assertNotEquals(leadStatus, leadStatusAfterChange);
		} catch (Exception e) {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();
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
			util.acceptUnExpectedError();
			e.printStackTrace();
		}
		  try {
			  String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
			util.inlineEditInTable("Assigned To", excel.readFromExcel(0, 1, 1));
			  util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
			  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			  Thread.sleep(3000);
			  String AssignToAfterEdit = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
			  inlineEditInLeadTable.assertNotEquals(AssignTo, AssignToAfterEdit);
		} catch (Exception e) {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();
			e.printStackTrace();
		}
		  
		
			  String leadSource = util.getColumndata("Lead Source", excel.readFromExcel(0, 1, 1));
			util.inlineEditInTable("Lead Source", excel.readFromExcel(0, 1, 1));
			  util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
			  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			  Thread.sleep(3000);
			  String leadSourceAfterEdit = util.getColumndata("Lead Source", excel.readFromExcel(0, 1, 1));
			  inlineEditInLeadTable.assertNotEquals(leadSource, leadSourceAfterEdit);
		
		 
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
			util.acceptUnExpectedError();
			e.printStackTrace();
		}
		  
		  try {
			  String officePhone = util.getColumndata("Office Number", excel.readFromExcel(0, 1, 1));
			  String officePhoneEdit = officePhone +" "+"02";
			util.inlineEditInTable("Office Number", excel.readFromExcel(0, 1, 1));
			  util.sendValue(driver.findElement(leadEntry.OfficeNumber), officePhoneEdit);
			  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			  Thread.sleep(3000);
			  String officePhoneAfterEdit = util.getColumndata("Office Number", excel.readFromExcel(0, 1, 1));
			  inlineEditInLeadTable.assertNotEquals(officePhone, officePhoneAfterEdit);
		} catch (Exception e) {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();
			e.printStackTrace();
		}
		  
		  try {
			  String mainBusiness = util.getColumndata("Main Business", excel.readFromExcel(0, 1, 1));
			 util.inlineEditInTable("Main Business", excel.readFromExcel(0, 1, 1));
			 util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
			  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			  Thread.sleep(3000);
			  String mainBusinessAfterEdit = util.getColumndata("Main Business", excel.readFromExcel(0, 1, 1));
			  inlineEditInLeadTable.assertNotEquals(mainBusiness, mainBusinessAfterEdit);
		} catch (Exception e) {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();
			e.printStackTrace();
		}
		 
	  try {
		  String industry = util.getColumndata("Industry", excel.readFromExcel(0, 1, 1));
		  util.inlineEditInTable("Industry", excel.readFromExcel(0, 1, 1));
		  util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
		  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
		  Thread.sleep(3000);
		  String industryAfterEdit = util.getColumndata("Industry", excel.readFromExcel(0, 1, 1));
		  inlineEditInLeadTable.assertNotEquals(industry, industryAfterEdit);
	  } catch (Exception e) {
		  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		  util.acceptUnExpectedError();
		e.printStackTrace();
	  }
	  
	  try {
		  String State = util.getColumndata("State", excel.readFromExcel(0, 1, 1));
		  util.inlineEditInTable("State", excel.readFromExcel(0, 1, 1));
		  util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
		  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
		  Thread.sleep(3000);
		  String StateAfterEdit= util.getColumndata("State", excel.readFromExcel(0, 1, 1));
		  inlineEditInLeadTable.assertNotEquals(State, StateAfterEdit);
	  } catch (Exception e) {
		  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		  util.acceptUnExpectedError();
		e.printStackTrace();
		
	  }
	  
	  
	  try {
		  String city = util.getColumndata("City", excel.readFromExcel(0, 1, 1));
		  util.inlineEditInTable("City", excel.readFromExcel(0, 1, 1));
		  util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
		  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
		  Thread.sleep(3000);
		  String cityAfterEdit = util.getColumndata("City", excel.readFromExcel(0, 1, 1));
		  inlineEditInLeadTable.assertNotEquals(city, cityAfterEdit);
	  } catch (Exception e) {
		  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		  util.acceptUnExpectedError();
		e.printStackTrace();
	  }
	  util.acceptUnExpectedError();
	  inlineEditInLeadTable.assertAll();
	  
	}
	
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
	  
	  
	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  * 5 the user changing to 6 th user 
	  * 5 th User Edited to 6 th User 
	  */
	 void editFromLiStingPage() throws IOException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		//Creating 5 Lead from excel 
		bulk.createLead(0, 5);
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		Thread.sleep(3000);
		//Verifying the details in Edit Screen
		String [] valueBeforeEdit = common.getAttribute(excel.readFromExcel(0, 5, 1),
				leadEntry.CompanyName, 
				leadEntry.AssignedTo, 
				leadEntry.Email, 
				leadEntry.LeadStatus, 
				leadEntry.OfficeNumber, 
				leadEntry.Designation, 
				leadEntry.Country);
		Thread.sleep(3000);
		//Click on Edit in 5 the User
		 util.clickOnActions(excel.readFromExcel(0, 5, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Edit",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			//Edit and adding details to 6 User
			bulk.createLead(0, 6);
			util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			Thread.sleep(3000);
			//Verifying 6 user details got Affected or Not
			String [] valuesAfterEdit = common.getAttribute(excel.readFromExcel(0, 6, 1),
					leadEntry.CompanyName, 
					leadEntry.AssignedTo, 
					leadEntry.Email, 
					leadEntry.LeadStatus, 
					leadEntry.OfficeNumber, 
					leadEntry.Designation, 
					leadEntry.Country);
			common.compareArrays(valueBeforeEdit, valuesAfterEdit);
	 }

	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  */
	void verifyFilter() throws IOException, InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		SoftAssert verifyFilter = new SoftAssert();
		util.waitForElementAndClick(driver.findElement(lead.FilterOption));
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");
		//Filter By Lead name
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 1));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		Thread.sleep(3000);
		String leadname1 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname1);
		verifyFilter.assertNull(leadname2);
		//Filter By Company
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Company");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 3));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname4 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname4);
		String leadname5 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname5);
		Thread.sleep(3000);
		//Filter By lead Status
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Status");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0, 1, 17));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname3);
		//Filter By Assigned to
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Assigned To");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0, 1, 18));
		Thread.sleep(2000);
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		Thread.sleep(3000);
		String leadname6 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname6);
		String leadname7 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname7);
		
		//Filter By Designation
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Designation");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 4));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname8 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname8);
		String leadname9 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname9);

		//Filter By Email
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Email");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 7));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname10 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname10);
		String leadname11 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname11);
 
		//Filter By Web Site
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Website");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 8));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname14 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname14);
		String leadname12 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname12);
        //Filter By Industry
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Industry");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0, 1, 14));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname15 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname15);
		String leadname16 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname16);
        //Filter By Country
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Country");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0, 1, 10));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname17 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname17);
		String leadname18 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname18);
        //Filter By Lead Source
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Lead Source");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0, 1, 16));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname19 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname15);
		String leadname20 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname19);

		// AND and OR Condiion

		util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");

		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(0, 1, 1));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		util.waitForElementAndClick(driver.findElement(lead.FilterAddNewFilter));
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
		util.handleDropdown(driver.findElement(lead.FilterFieldBy2), "First Name");
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterOperator2), "Equal to");
		util.sendValue(driver.findElement(lead.FiltervalueInputtextBox2), excel.readFromExcel(0, 1, 2));
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname21 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		String leadname22 = util.loopColumnFindName(excel.readFromExcel(0, 2, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNotNull(leadname21);
		verifyFilter.assertNotNull(leadname22);
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.FilterEdit2));
		Thread.sleep(3000);
		util.handleDropdown(driver.findElement(lead.FilterANDOR), "AND");
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
		String leadname23 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
		String leadname24 = util.loopColumnFindName(excel.readFromExcel(0, 2, 1), driver.findElement(lead.LeadTable));
		verifyFilter.assertNull(leadname23);
		verifyFilter.assertNull(leadname24);
		util.waitForElementAndClick(driver.findElement(lead.FilterOption));
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		driver.navigate().refresh();
		verifyFilter.assertAll();

	}
	  
	  TaskEntry taskentry = new TaskEntry ();
	private String lastNameval1;
	private String lastNameval2;
	private String lastNameval3;
	private String designationErro1;
	private String mobileNumberError1;
	private String mobileNumberError2;
	  
	  void addtask () throws InterruptedException, IOException{
		  common.addtask(excel.readFromExcel(0, 1, 1));
	  }
	  void addtaskInDetails() throws InterruptedException{
		  common.addtaskInDetails();
		 
	  }
	   
	  
	  
	  void importLead () throws InterruptedException, IOException{
		  common.importLead("C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv", lead.LeadMenu);
		  SoftAssert importLead = new SoftAssert ();
		  importLead.assertEquals(common.importSuccess, lead.importSuccessMessage);
		  importLead.assertEquals(common.importLeadInListing, "Import");
		  importLead.assertAll();
		    
	  }
	  
	  void importLeadValidation() throws InterruptedException{
		  common.importValidation(lead.LeadMenu, "C:\\Users\\nichiuser\\Desktop\\Autoite\\importValidation.csv");
	  }
	  
	  
	  void changeOwnerforAllLeads () throws InterruptedException, IOException{
		  SoftAssert changeOwnerforAllLeads = new SoftAssert ();
		  util.waitForElementAndClick(driver.findElement(lead.AllSelect));
		  util.waitForElementAndClick(driver.findElement(lead.ChangeOwnerInAllSlect));
		  util.handleDropdown(driver.findElement(lead.ChangeleadOwnerOption), lead.changeOwnerTo);
		  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		  String changeOwnerSucesMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		  
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
			changeOwnerforAllLeads.assertEquals(changeOwnerSucesMessage, lead.changeOwnerSucessMessage);
			String AssignedTo1 = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
			String AssignedTo2 = util.getColumndata("Assigned To", excel.readFromExcel(0, 2, 1));
			String AssignedTo13 = util.getColumndata("Assigned To", excel.readFromExcel(0, 3, 1));
			changeOwnerforAllLeads.assertEquals(AssignedTo1, lead.changeOwnerTo);
			changeOwnerforAllLeads.assertEquals(AssignedTo2, lead.changeOwnerTo);
			changeOwnerforAllLeads.assertEquals(AssignedTo13, lead.changeOwnerTo);
			changeOwnerforAllLeads.assertAll();
		  
	  }
	  
	  
	  void addNoteForAll () throws InterruptedException, IOException{
		 common.addNoteForAll(lead.AddNoteOptionInAllSelect);
	  }
	  /**
	   * 
	   * @throws IOException
	   * Checking Added log available in detial page 
	   */
	  void verifyLogcallInDetailsPage () throws IOException{
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall), 
				 excel.readFromExcel(4,1,0), 
				 driver.findElement(lead.LeadTable));
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall), 
				 excel.readFromExcel(4,2,0), 
				 driver.findElement(lead.LeadTable));
	  }
	  
	  void verifyAddNoteInDetailsPage () throws IOException{
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
					 excel.readFromExcel(5,1,0), 
					 driver.findElement(lead.LeadTable));
			 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
					 excel.readFromExcel(5,2,0), 
					 driver.findElement(lead.LeadTable));
			 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
					 excel.readFromExcel(5,3,0), 
					 driver.findElement(lead.LeadTable));
	  }
	  
	  /**
	   * 
	   * @throws IOException
	   */
	  void verifyEventAddedInDetailsPage() throws IOException{
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
					 excel.readFromExcel(6,1,0), 
					 driver.findElement(lead.LeadTable));
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
					 excel.readFromExcel(6,2,0), 
					 driver.findElement(lead.LeadTable));
	  }
	  
	  /**
	   * 
	   * @throws IOException
	   */
	  void verifyTaskAddedInDetailsPage() throws IOException{
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
					 excel.readFromExcel(7,1,0), 
					 driver.findElement(lead.LeadTable));
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
					 excel.readFromExcel(7,2,0), 
					 driver.findElement(lead.LeadTable));
	  }
	   /**
	    * 
	    *//*
	  void editFromDetailsPage () throws IOException, InterruptedException{
		  util.waitForElementAndClick(driver.findElement(leadDetails.EditButtonInDetailsPage));
		  util.sendValue(driver.findElement(leadEntry.CompanyName), excel.readFromExcel(0, 1, 3)+ " "+ "Edited From Details");
		  util.sendValue(driver.findElement(leadEntry.CompanyName), excel.readFromExcel(0, 1, 4)+ " "+ "Edited From Details");
		  util.handleDropdown(driver.findElement(leadEntry.LeadStatus), "Qualified");
		  
	  }*/
	      /**
	       * 
	       * @throws InterruptedException
	       */
	  void invalidemailTabsOutValidationlead() throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  common.emailtabsOutvalidation(leadEntry.Email,"tabs",leadEntry.emailFieldvaldiation);
	  }
         /**
          * 
          * @throws InterruptedException
          */
	  void invalidemailCommonValidationlead() throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  common.emailtabsOutvalidation(leadEntry.Email,"common",leadEntry.emailFieldvaldiation);
		  
	  }
	  /**
	   * 
	   * @throws InterruptedException
	   */
	  void webSiteTabsvaldiationError() throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  common.webSitevalidation(leadEntry.WebSite, "tabs",leadEntry.webSiteFieldvaldiation);
	  }

	  /**
	   * 
	   * @throws InterruptedException
	   */
	  void webSiteCommonvaldiationError() throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  Thread.sleep(3000);
		  common.webSitevalidation(leadEntry.WebSite, "common",leadEntry.webSiteFieldvaldiation);
	  }

	/**
	 * 
	 * @throws InterruptedException
	 */
	  void tabsOutmaxCharValidationLead () throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  try {
			common.maximumCharTabsvalidation(leadEntry.FirstName, 
					  "Like any other social media site Facebook has len", 
					  leadEntry.firstNamecharExceedvalidation, 
					  leadEntry.FirstNamevalidationError);
		} catch (AssertionError e) {
			Assert.fail();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			common.maximumCharTabsvalidation(leadEntry.LastName,
					  "Like any other social media site Facebook has len Like any other social media site Fac",
					  leadEntry.lastNamecharExceedvalidation, 
					  leadEntry.lastnameFieldValdiation);
		} catch (AssertionError e) {
			Assert.fail();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			common.maximumCharTabsvalidation(leadEntry.CompanyName,
					  "Like any other social media site Facebook has len Like"
					  + " any other social media site FacSnapchat's caption character limit is 250. "
					  + "Twitter's character limit is 2len Like any other social media site FacSnapchat's caption character limit is 250. Twitter's character limit is 2", 
					  leadEntry.comcpanyExceedvalidation, 
					  leadEntry.companyFieldValidation);
		} catch (AssertionError e) {
			Assert.fail();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  try {
			common.maximumCharTabsvalidation(leadEntry.Designation,
					  "Like any other social media site Facebook has len", 
					  leadEntry.designationcharExceedvalidation, 
					  leadEntry.DesignationValidationError);
		} catch (AssertionError e) {
			Assert.fail();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.maximumCharTabsvalidation(leadEntry.PostalCode, 
					  "8568863363  545454554 54545454545 5745454545 4545585858", 
					  leadEntry.postalCodecharExceedvalidation, 
					  leadEntry.PostalCodeValidationError);
		} catch (AssertionError e) {
			Assert.fail();
		}
		  
		  try {
			common.maximumCharTabsvalidation(leadEntry.OfficeNumber, 
					  "8568863363  545454554 54545454545 5745454545 4545585858",
					  leadEntry.officecharExceedvalidation, 
					  leadEntry.OfficeNumberValidationError);
		} catch (AssertionError e) {
			Assert.fail();
			e.printStackTrace();
		}
		  try {
			common.maximumCharTabsvalidation(leadEntry.MobileNumber,
					  "8568863363  545454554 54545454545 5745454545 4545585858",
					  leadEntry.mobileExceedvalidation,
					  leadEntry.MobileNumbervaldiationError);
		} catch (AssertionError e) {
			Assert.fail();
			e.printStackTrace();
		}
	  }
	  
	  /**
	   * 
	   * @throws InterruptedException
	   */
	  void commonMaxCharExceedvalidation () throws InterruptedException{
		  Thread.sleep(3000);
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  bulk.createLead(0, 49);
		  util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
		  String valMsg = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
		  Assert.assertEquals(valMsg, leadEntry.CommonValidationMEssage);
		  
	  }
	  
	/*  void fiedTypevalidationTabs () throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  SoftAssert fiedTypevalidation = new SoftAssert();
		  Thread.sleep(3000);
		  try {
			common.fieldTypevalidationError(leadEntry.LastName,
					  "      ",
					  leadEntry.lastnameFieldValdiation);
			lastNameval1 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.fieldTypevalidationError(leadEntry.LastName,
					  "@!%^&*(",
					  leadEntry.lastnameFieldValdiation);
			lastNameval2 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.fieldTypevalidationError(leadEntry.LastName,
					  "4564564565",
					  leadEntry.lastnameFieldValdiation);
			lastNameval3 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  try {
			common.fieldTypevalidationError(leadEntry.Designation,
					  "@#$%^&&",
					  leadEntry.DesignationValidationError
					 );
		designationErro1 = util.getValidationMessage(driver.findElement(leadEntry.DesignationValidationError));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.fieldTypevalidationError(leadEntry.MobileNumber,
					  "@#$%^&&",
					  leadEntry.MobileNumbervaldiationError);
			 mobileNumberError1 = util.getValidationMessage(driver.findElement(leadEntry.MobileNumbervaldiationError));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  try {
			common.fieldTypevalidationError(leadEntry.MobileNumber,
					  "@test mobile number",
					  leadEntry.MobileNumbervaldiationError
					  );
			mobileNumberError2 = util.getValidationMessage(driver.findElement(leadEntry.MobileNumbervaldiationError));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  fiedTypevalidation.assertEquals(lastNameval1, leadEntry.lastNameValdiationError);
		fiedTypevalidation.assertEquals(lastNameval2, leadEntry.lastNameValdiationError);
		fiedTypevalidation.assertEquals(lastNameval3, leadEntry.lastNameValdiationError);
		fiedTypevalidation.assertEquals(designationErro1, leadEntry.designationFieldvalidationError);
		fiedTypevalidation.assertEquals(mobileNumberError1, leadEntry.mobileNumbervalidationError);
		fiedTypevalidation.assertEquals(mobileNumberError2, leadEntry.mobileNumbervalidationError);
		fiedTypevalidation.assertAll();
		  
	  }
	
	  
	  void fieldTypeCommonValidationError () throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  Thread.sleep(3000);
		  SoftAssert commonFieldType = new SoftAssert();
		  Thread.sleep(3000);
		  try {
			common.commmonfieldTypevalidationError(leadEntry.LastName,
					  "      ",
					  leadEntry.lastnameFieldValdiation);
			lastNameval1 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.commmonfieldTypevalidationError(leadEntry.LastName,
					  "@!%^&*(",
					  leadEntry.lastnameFieldValdiation);
			lastNameval2 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.commmonfieldTypevalidationError(leadEntry.LastName,
					  "4564564565",
					  leadEntry.lastnameFieldValdiation);
			lastNameval3 = util.getValidationMessage(driver.findElement(leadEntry.lastnameFieldValdiation));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  try {
			common.commmonfieldTypevalidationError(leadEntry.Designation,
					  "@#$%^&&",
					  leadEntry.DesignationValidationError
					 );
		designationErro1 = util.getValidationMessage(driver.findElement(leadEntry.DesignationValidationError));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  try {
			common.commmonfieldTypevalidationError(leadEntry.MobileNumber,
					  "@#$%^&&",
					  leadEntry.MobileNumbervaldiationError);
			 mobileNumberError1 = util.getValidationMessage(driver.findElement(leadEntry.MobileNumbervaldiationError));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  try {
			common.commmonfieldTypevalidationError(leadEntry.MobileNumber,
					  "@test mobile number",
					  leadEntry.MobileNumbervaldiationError
					  );
			mobileNumberError2 = util.getValidationMessage(driver.findElement(leadEntry.MobileNumbervaldiationError));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  *//**
		   * 
		   *//*
		  
		  commonFieldType.assertEquals(lastNameval1, leadEntry.lastNameValdiationError);
		  commonFieldType.assertEquals(lastNameval2, leadEntry.lastNameValdiationError);
		  commonFieldType.assertEquals(lastNameval3, leadEntry.lastNameValdiationError);
		  commonFieldType.assertEquals(designationErro1, leadEntry.designationFieldvalidationError);
		  commonFieldType.assertEquals(mobileNumberError1, leadEntry.mobileNumbervalidationError);
		  commonFieldType.assertEquals(mobileNumberError2, leadEntry.mobileNumbervalidationError);
		  commonFieldType.assertAll();
	 
	  }
	 
	  */

		void firstNamefieldvalidationIn() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.firstNameArry,
					leadEntry.FirstName,
					leadEntry.FirstNamevalidationError, 
					leadEntry.firstNamecharExceedvalidation);
			common.commonValidationFieldType(lead.firstNameArry,
					leadEntry.FirstName,
					leadEntry.FirstNamevalidationError, 
					leadEntry.firstNamecharExceedvalidation);
			
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */

		void lastNameFieldvaldidation() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.lastNameArry,
					leadEntry.LastName,
					leadEntry.lastnameFieldValdiation, 
					leadEntry.lastNameValdiationError);
			common.commonValidationFieldType(lead.lastNameArry,
					leadEntry.LastName,
					leadEntry.lastnameFieldValdiation, 
					leadEntry.lastNameValdiationError);
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */

		void designationFieldvalidation() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.designationArry,
					leadEntry.Designation,
					leadEntry.DesignationValidationError, 
					leadEntry.designationFieldvalidationError);
			common.commonValidationFieldType(lead.designationArry,
					leadEntry.Designation,
					leadEntry.DesignationValidationError, 
					leadEntry.designationFieldvalidationError);
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void companyValidation() throws InterruptedException, IOException {
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.companyArry,
					leadEntry.CompanyName,
					leadEntry.companyFieldValidation, 
					leadEntry.companyNameValidationError);
			common.commonValidationFieldType(lead.companyArry,
					leadEntry.CompanyName,
					leadEntry.companyFieldValidation, 
					leadEntry.companyNameValidationError);
			
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void officeNumberFieldvalidation() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.officeNumberArry,
					leadEntry.Officenumber,
					leadEntry.OfficeNumberValidationError, 
					leadEntry.officecharExceedvalidation);
			common.commonValidationFieldType(lead.officeNumberArry,
					leadEntry.Officenumber,
					leadEntry.OfficeNumberValidationError, 
					leadEntry.officecharExceedvalidation);
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */

		void mobileNumberFieldValdiation() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.mobileNumberArry,
					leadEntry.MobileNumber,
					leadEntry.MobileNumbervaldiationError, 
					leadEntry.mobileNumbervalidationError);
			common.commonValidationFieldType(lead.mobileNumberArry,
					leadEntry.MobileNumber,
					leadEntry.MobileNumbervaldiationError, 
					leadEntry.mobileNumbervalidationError);
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */

		void postCodeFieldValidation() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			common.tabsOutValidationFieldType(lead.postalCoceArry,
					leadEntry.PostalCode,
					leadEntry.PostalCodeValidationError, 
					leadEntry.postalCodecharExceedvalidation);
			common.commonValidationFieldType(lead.postalCoceArry,
					leadEntry.PostalCode,
					leadEntry.PostalCodeValidationError, 
					leadEntry.postalCodecharExceedvalidation);
		}

	  /**
	   * 
	   * @throws InterruptedException
	   */
		 void statevalidationWithOutCountry() throws InterruptedException{
			 util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			 util.waitForElementAndClick(driver.findElement(leadEntry.Staet));
			 List list = util.returnDropDownList(leadEntry.Staet,By.xpath("//div[@role='option']"));
			 Assert.assertTrue(list.isEmpty());
		 }
		 
		 /**
		 * @throws InterruptedException 
		  * 
		  */
		 void firstNameOperators () throws InterruptedException{
			common.operatorListvalidation(lead.FilterFieldBy1,
					lead.FilterOperator1,
					"First Name", 
					"Not equal to,Is empty,Contains,Does not contain,Starts with,Is not empty,Equal to");
			//Verify the value type is input or Dropdown values 
			Assert.assertEquals("input", common.readFieldType(lead.FiltervalueInputtextBox1));
		 }
		 
		 /**
		  * 
		  * @throws InterruptedException
		  */
		 
		//Verify the value type is input or Dropdown values 
		 void leadConvertedOperators () throws InterruptedException{
				common.operatorListvalidation(lead.FilterFieldBy1,
						lead.FilterOperator1,
						"Lead Converted", 
						"Not equal to,Equal to");
				Assert.assertNotEquals("input", common.readFieldType(lead.FilterValueInputDropdown1));
			 }
			
		 /**
		  * 
		  * @throws InterruptedException
		  */
		 void leadCreatedOperators () throws InterruptedException{
				common.operatorListvalidation(lead.FilterFieldBy1,
						lead.FilterOperator1,
						"Lead Created", 
						"Not equal to,Equal to,Less than,Greater than,Less or equal,Greater or equal, Is empty,Is not empty");
			 }
		/**
		 * @throws InterruptedException 
		 * @throws NullPointerException 
		 * 	
		 */
		 void assignToOpertor() throws NullPointerException, InterruptedException{
			 common.operatorListvalidation(lead.FilterFieldBy1,
						lead.FilterOperator1,
						"Assigned To", 
						"Not equal to,Equal to,Is empty,Is not empty");
			 Assert.assertNotEquals("input", common.readFieldType(lead.FilterValueInputDropdown1));
		 }
		 
		 
		 
		 void checkFilterByValues() throws InterruptedException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 common.checkFilterByValues(lead.customValues);
		 }
		 
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void logSubjectCommonValidation() throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log a Call",driver.findElement(lead.ActionMenuModel));
			 Thread.sleep(3000);
			 common.commonValidationFieldType(
					lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		 
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void logSubjecttabsOutValidation () throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
				 Thread.sleep(3000);
				 common.tabsOutValidationFieldType(lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		 
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 
		 void noteSubjectCommonValidation() throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				 common.commonValidationFieldType(lead.logSubjectArry,lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 
		 void noteSubjecttabsOutValidation () throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				Thread.sleep(3000);
				 common.tabsOutValidationFieldType(lead.logSubjectArry,lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		
		 /**
		  * Call the commonValidationFieldType  methos and pass Anonymous array
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void EventSubjecttabsOutValidation () throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
			 Thread.sleep(3000);
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				 common.tabsOutValidationFieldType(lead.eventLocationArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
		 }
		
		 /**
		  * Call the commonValidationFieldType  methos and pass Anonymous array
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void EventSubjectCommonValidation() throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
			 Thread.sleep(3000);
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				common.commonValidationFieldType(lead.eventLocationArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
		 }
		 
		 
		 /**
		  * Call the tabsOutValidationFieldType  methos and pass Anonymous array
		  * @throws InterruptedException
		  * @throws IOException
		  */

		 void EventLocationtabsOutValidation () throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
			 //Selecting event from the Action button
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				 common.tabsOutValidationFieldType(lead.eventLocationArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
		 }
		
		 /**
		  * Call the commonValidationFieldType  methos and pass Anonymous array
		  * @throws IOException
		  * ClickOnActions Click on action button based on username
		  */
		 void EventLocationCommonValidation() throws InterruptedException, IOException{
			 util.clickOnActions(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				//create anonymous array to pass the one time value
				common.commonValidationFieldType(lead.eventLocationArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
		 }
		 /**
		  * Checking log tabs out validation In detaila page 
		  * @throws InterruptedException
		  * @throws IOException
		  */
				 
		 void logSubjectTabOutValidationDetails() throws InterruptedException, IOException{
			 common.tabsOutValidationFieldType(new String []{
					 "","ghghsdjkghdsjkghd","maximimlimitmaximimlimitmaximimlimitmaximimlimitmaximimlimit"
			 },lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		 /**
		  * Checking Subject commonvalidation In Details
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 //Use same validation for the note also and Event Subject Also 
		 void logSubjectCommonvalidationDetails() throws InterruptedException, IOException{
			 common.tabsOutValidationFieldType(lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		 /**Event Tabs out Validation inDetails
		 * @throws IOException 
		 * @throws InterruptedException 
		  * 
		  */
		 void eventtabsOutValdiationDetails() throws InterruptedException, IOException{
			 try {
				 //Tabs out validation for the subject
				common.tabsOutValidationFieldType(lead.eventSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
			Assert.fail();
			}
			 //Tabs out validation for location
			 common.tabsOutValidationFieldType(lead.eventSubjectArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void commonvalidationEventInDetails () throws InterruptedException, IOException{
			 try {
				 //Common validation for the Subject
				common.commonValidationFieldType(lead.eventSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				Assert.fail();
			}
			 //Common validation for Location 
			 common.commonValidationFieldType(lead.eventLocationArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
		 }
		 
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void emailInlineEditTabsOutalidation() throws InterruptedException, IOException{
			 Thread.sleep(3000);
			 common.inlineEmailIdValidation("Email",excel.readFromExcel(0, 1, 1), leadEntry.Email, "tabs",leadEntry.emailFieldvaldiation);
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void emailInlneEditCommonValidation() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 common.inlineEmailIdValidation("Email", excel.readFromExcel(0, 1, 1), leadEntry.Email, "common",leadEntry.emailFieldvaldiation);
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void webSiteInlinetabsOutValidationError() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(3000);
			 common.inlineWeSitevaldiation("Website", excel.readFromExcel(0, 1, 1), leadEntry.WebSite, "tabs",leadEntry.webSiteFieldvaldiation); 
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void webSiteInlineEditCommonvalidationError() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(3000);
			 common.inlineWeSitevaldiation("Website", excel.readFromExcel(0, 1, 1), leadEntry.WebSite, "common",leadEntry.webSiteFieldvaldiation);
		 }
		 /**
		  * Tabs out validation for inline Edit for Mobile Number
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void inlineTabsNumericalNumbervalidation() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditTabsOutValidation("Mobile Number", 
					 excel.readFromExcel(0, 1, 1), new String [] {"alphebeitcal","@#$%^&*()","99225alpheNumeric"}, 
					 leadEntry.MobileNumber, 
					 leadEntry.MobileNumbervaldiationError, leadEntry.webSiteInvalidError);
		 }
		 /**
		  * Common validation for inline edit for mobile number
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void inlineCommonNumericalNumbervaldation() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditCommonValdiation("Mobile Number", 
					 excel.readFromExcel(0, 1, 1), new String [] {"alphebeitcal","@#$%^&*-=+()","99225alpheNumeric"}, 
					 leadEntry.MobileNumber, 
					 leadEntry.MobileNumbervaldiationError, leadEntry.webSiteInvalidError);
		 }
		 
		 /**
		  * Inline edit tabs out validation for aplenumeric 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void inlineEditTabsOutValidationForAlphenumeric() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditTabsOutValidation("Designation", 
					 excel.readFromExcel(0, 1, 1), new String [] {"@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 leadEntry.Designation, 
					 leadEntry.DesignationValidationError, leadEntry.designationFieldvalidationError);
		 }
		 
		 /**
		  * Inline edit common validation for aplenumeric 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void inlineEditCommovalidationForAlphanumeric() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditCommonValdiation("Designation", 
					 excel.readFromExcel(0, 1, 1), new String [] {"@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 leadEntry.Designation, 
					 leadEntry.DesignationValidationError, leadEntry.designationFieldvalidationError);
		 }
		 
		 /**
		  *  Inline edit tabs out  validation for Text Field
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void inlineEditTabOutTextFieldvalidation() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditTabsOutValidation("Company", 
					 excel.readFromExcel(0, 1, 1), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 leadEntry.CompanyName, 
					 leadEntry.companyFieldValidation, leadEntry.companyNameValidationError);
		 }
		 
		 /**
		  * Inline edit common validation for Text Field
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 void inlineEditCommonTextieldValidation() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditCommonValdiation("Company", 
					 //passing test values to anonymous array
					 excel.readFromExcel(0, 1, 1), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 leadEntry.CompanyName, 
					 leadEntry.companyFieldValidation, leadEntry.companyNameValidationError);
			 
		 }
		/**
		 * @throws InterruptedException 
		 *Oprn lead menu and Click the user which need to details page
		 *Once details page is open, Perform inline Edit button 
		 *Create 7 th Lead 
		 * @throws IOException 
		 * Verifying lead details got Edited 
		 * 7 th user editing to 8 th User		 * 
		 */
		 void inlinedEditDetailsPage() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.LeadMenu));
			 util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			 //Creating 7 th Lead
			 bulk.createLead(0, 7);
			 util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			 //taking 7 User details 
			 String [] valueBeforeEdit = common.getAttribute(excel.readFromExcel(0, 7, 1),
						leadEntry.CompanyName, 
						leadEntry.AssignedTo, 
						leadEntry.Email, 
						leadEntry.LeadStatus, 
						leadEntry.OfficeNumber, 
						leadEntry.Designation, 
						leadEntry.Country);
				Thread.sleep(3000);
				util.recordSelection("100");
				//Redirecting to 7 the User Details page 
			 util.clickOnActions(excel.readFromExcel(0, 7, 1),
					 driver.findElement(lead.LeadTable),
					 "Redirection");
			 //Click On Edit button and Changing to 8 users
			 util.inlineEditInInformationSection(driver.findElement(leadDetails.InformationSection));
			 //Creating to 8 th User
			 bulk.createLead(0, 8);
			 util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			 util.waitForElementAndClick(driver.findElement(lead.LeadMenu));
			 util.recordSelection("100");
			 //Getting 8 user Details 
			 String [] valueAfterEdit = common.getAttribute(excel.readFromExcel(0, 8, 1),
						leadEntry.CompanyName, 
						leadEntry.AssignedTo, 
						leadEntry.Email, 
						leadEntry.LeadStatus, 
						leadEntry.OfficeNumber, 
						leadEntry.Designation, 
						leadEntry.Country);
				Thread.sleep(3000);
				common.compareArrays(valueBeforeEdit, valueAfterEdit);
			
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  * Changing to 8 the 7 users details 
		  */
		 void checkHeaderAfterInlineEdit() throws InterruptedException, IOException{
			SoftAssert checkHeaderAfterInlineEdit = new SoftAssert();
			util.recordSelection("100");
			 util.clickOnActions(excel.readFromExcel(0, 8, 1),
					 driver.findElement(lead.LeadTable),
					 "Redirection");
			 util.inlineEditInInformationSection(driver.findElement(leadDetails.InformationSection));
			 bulk.createLead(0, 7);
			 util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
			 String leadName = util.getElementName(driver.findElement(leadDetails.LeadNameDetailsHeader));
			 String ComplanyName =util.getElementName(driver.findElement(leadDetails.CompanyNameDetailsHeader)); 
             String Designation = util.getElementName(driver.findElement(leadDetails.DesignationDetailsHeader));
             String emailId = util.getElementName(driver.findElement(leadDetails.EmailInfoHeader));
             checkHeaderAfterInlineEdit.assertEquals(leadName, excel.readFromExcel(0, 7, 1)+""+excel.readFromExcel(0, 7, 2));
             checkHeaderAfterInlineEdit.assertEquals(ComplanyName, excel.readFromExcel(0, 7, 3));
             checkHeaderAfterInlineEdit.assertEquals(Designation,excel.readFromExcel(0, 7, 4));
             checkHeaderAfterInlineEdit.assertEquals(emailId, excel.readFromExcel(0, 7, 7));
             checkHeaderAfterInlineEdit.assertAll();	 
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 * Editing the User 7 to 8, its Edting he lead using the Edit Button
		 */
		 void editFromDetailsPage() throws InterruptedException, IOException{
			SoftAssert editFromDetailsPage = new SoftAssert();
			util.waitForElementAndClick(driver.findElement(leadDetails.EditButtonInDetailsPage));
			bulk.createLead(0, 8);
			util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
			String leadName = util.getElementName(driver.findElement(leadDetails.LeadNameDetailsHeader));
			 String ComplanyName =util.getElementName(driver.findElement(leadDetails.CompanyNameDetailsHeader)); 
            String Designation = util.getElementName(driver.findElement(leadDetails.DesignationDetailsHeader));
            String emailId = util.getElementName(driver.findElement(leadDetails.EmailInfoHeader));
            editFromDetailsPage.assertEquals(leadName, excel.readFromExcel(0, 8, 1)+""+excel.readFromExcel(0, 8, 2));
            editFromDetailsPage.assertEquals(ComplanyName, excel.readFromExcel(0, 8, 3));
            editFromDetailsPage.assertEquals(Designation,excel.readFromExcel(0, 8, 4));
            editFromDetailsPage.assertEquals(emailId, excel.readFromExcel(0, 8, 7));
            editFromDetailsPage.assertAll();	 
		}
		/**
		 * @throws InterruptedException 
		 * 
		 */
		 void deleteLeadFromDetailsPage () throws InterruptedException{
			SoftAssert deleteFromDetails = new SoftAssert();
			String currenturl = driver.getCurrentUrl();
			util.waitForElementAndClick(driver.findElement(leadDetails.DeteteOption));
			String deleteConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
			String urlAfterDelete = driver.getCurrentUrl();
			deleteFromDetails.assertNotEquals(currenturl, urlAfterDelete);
			deleteFromDetails.assertEquals(deleteConfirmation, lead.DeletetLeadSucessMessage);
			deleteFromDetails.assertAll();
		}
		/**
		 * Delete 8 user from details page and verify the 8 user is available or note
		 * @throws InterruptedException
		 * @throws IOException
		 */
		 void deleteLeadInListingPage () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.LeadMenu));
			util.recordSelection("100");
			String userName = util.loopColumnFindName(excel.readFromExcel(0, 8, 1), driver.findElement(lead.LeadTable));
			Assert.assertNull(userName);
		}
		/**
		 * Delete log Call entry from details page 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void deleteLogCallFromActivityTable() throws InterruptedException, IOException{
			common.deleteFromActiityTable(driver.findElement(leadDetails.LogCall), 
					//Delete Log call which added from detail page
					excel.readFromExcel(4, 2, 0));
		}
		/**
		 * Delete note entry from details page 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void deleteNoteFromActivityTable() throws InterruptedException, IOException{
			common.deleteFromActiityTable(driver.findElement(leadDetails.MakeNote), 
					//Delete Note which added from detail page
					excel.readFromExcel(5, 2, 0));
		}
		/**
		 * Delete Event entry from details page
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void deleteEventFromActivityTable() throws InterruptedException, IOException{
			//Delete Event which added from detail page
			common.deleteFromActiityTable(driver.findElement(leadDetails.NewEvent), 
					excel.readFromExcel(6, 2, 0));
		}
		/**
		 * Delete Task entry from details page
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void deletetaskFromActivityTable() throws InterruptedException, IOException{
			//Delete Task which added from detail page
			common.deleteFromActiityTable(driver.findElement(leadDetails.NewTask), 
					excel.readFromExcel(7, 2, 0));
		}
		/**
		 * Edit Log Call from details page and Verify Log call after Edit
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void editLogCallFrometails() throws InterruptedException, IOException{
			common.editFromActivitytable(driver.findElement(leadDetails.LogCall), 
					excel.readFromExcel(4, 1, 0), 
					lead.SubjectLogCall, 
					lead.DetailsLogCall);
		}
		/**
		 * Edit Note from details page and Verify Note after Edit
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void editNoteFromDetails () throws InterruptedException, IOException{
			common.editFromActivitytable(driver.findElement(leadDetails.LogCall), 
					excel.readFromExcel(5, 1, 0), 
					lead.SubjectNote, 
					lead.DetailsNote);
		}
		/**
		 * Edit Event from details page and Verify Event after Edit
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void editEventFromDetails () throws InterruptedException, IOException{
			common.editFromActivitytable(driver.findElement(leadDetails.LogCall), 
					excel.readFromExcel(6, 1, 0), 
					evententry.Sujbect, 
					evententry.Details);
		}
		/**
		 * Edit Task from details page and Verify Task after Edit
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void editTaskFromDetails() throws InterruptedException, IOException{
			common.editFromActivitytable(driver.findElement(leadDetails.LogCall), 
					excel.readFromExcel(7, 1, 0), 
					taskentry.Subject, 
					taskentry.Details);
		}
}

