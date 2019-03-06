package Testcases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import Pages.TaskEntry;

public class CommonFeature extends DriverClass{
	//LeadTest leadtest = new LeadTest();
	ContactsEntry contactentry = new ContactsEntry();
	ContactsListing contactlist = new ContactsListing();
	PCUtility util = new PCUtility ();
	LeadListing lead = new LeadListing();
	ExcelReader excel = new ExcelReader ();
	LeadEntry leadEntry = new LeadEntry();
	LeadDetails leadDetails = new LeadDetails ();
	
	EventEntry evententry = new EventEntry();
	TaskEntry taskentry = new TaskEntry ();
	public String importSuccess;
	public  String importLeadInListing;
	public String subjectvalErrorEvent;
	public String eventTypevalErrorEvent;
	public String StartdatevalErrorEvent;
	public String EnddatevalErrorEvent;
	public String commonvalidationEvent;
	public String subjectvalErrorEventDetails;
	public String eventTypevalErrorEventDetails;
	public String StartdatevalErrorEventDetails;
	public String EnddatevalErrorEventDetails;
	public String commonvalidationEventDetails;
	public String companyNameInlineEdit;
	public String companyNameAfteerInlineEdit;
	public boolean firstColumn1;
	public boolean thirdColumn1;
	public boolean fourthColumn1;
	public boolean fifthColumn1;
	public String customPageView;
	public String customPageView1;
	public boolean desabledColumnEditPage;
	public boolean desabledColumn1EditPage;
	public boolean enabledColumnEditPage;
	public boolean enabledColumnEdit1Page1;
	public String tabsOutvalidationMsgforLogs;
	public String addlogCommonError;
	public String LogvalidationMsgInDetails;
	public String addlogCommonErrorInDeatils;
	public String noteSubjectvaldiatinListing;
	public String addnoteCommonError;
	public String noteSubjectvaldiatinDetals;
	public String addnoteCommonErrorDetails;
	public String logAddedFromListing;
	public String logAddedFromDetails;
	public String noteAddedFromListing;
	public String noteAddedFromDetails;
	public String noteAddedFromAllSelect;
	public String eventAddedFromListing;
	public String eventAddedFromDetails;
	public String taskAddedFromListing;
	public String taskAddedFromDetails;
	public boolean secondColumn1;
	//public By dropDownListElement = 

	
	
	/**
	 * 
	 * @param firstColumn = first columm the column which user want to enable
	 * @param seconColumn= second columm the column which user want to enable
	 * @param thirdCloumn= fithirdrst columm the column which user want to enable
	 * @param fourthColumn= fourth columm the column which user want to enable
	 * @param fifithColumn= fifth columm the column which user want to enable
	 * @param desableColumn=  columm the column which user want to desable
	 * @throws IOException= first columm the column which user want to enable
	 * @throws InterruptedException
	 */
void createPageView (String firstColumn,String seconColumn,
		String thirdCloumn, String fourthColumn,String fifithColumn,String desableColumn) throws IOException, InterruptedException{
	util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
	Thread.sleep(3000);
	util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
	util.enableToggle(driver.findElement(lead.ColumnSelectionBox), firstColumn);//Enable First Name
	util.enableToggle(driver.findElement(lead.ColumnSelectionBox), seconColumn);//Enable Company
	System.out.println("Ebabled Toggle of Company ");
	util.enableToggle(driver.findElement(lead.ColumnSelectionBox), thirdCloumn);//Enable Assign to
	System.out.println("Ebabled Toggle of Assigne to");
	util.enableToggle(driver.findElement(lead.ColumnSelectionBox),fourthColumn);//Enable Lead Status
	System.out.println("Ebabled Toggle of Lead Status");
	util.enableToggle(driver.findElement(lead.ColumnSelectionBox),fifithColumn);//Enable Designation
	System.out.println("Ebabled Toggle of Designation");
	util.disableToggle(driver.findElement(lead.ColumnSelectionBox), desableColumn);//Disable Salutation
	System.out.println("Desable Toggle Saluatation");
	//customPageView1 = excel.readFromExcel(3, 0, 1);
	//Sending Custom view name
	util.sendValue(driver.findElement(lead.InputBoxSaveCustomView),excel.readFromExcel(3, 0, 1));
	util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
	String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(sucessMessage, lead.createPageSucessMessage);
	Thread.sleep(3000); 
	
}




/**
 * 
 * @param firstColum =  
 * @param secondColumn
 * @param thirdColumn
 * @param fourthcOlcumn
 * @throws IOException
 * @throws InterruptedException
 */

void verifyCreatedPageView(String firstColum, String secondColumn,String thirdColumn, String fourthcOlcumn) throws IOException, InterruptedException{
	 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	util.tableHeader();
	int actualNoColums = util.actaulHeaderSize;
	int expectedNoColumns = 5;
	//Listing all table header
	List<String> allColumnNames = util.tableHeader();
	System.out.println(allColumnNames);
	//Checking colunmns enabled or not 
	firstColumn1 = allColumnNames.contains(firstColum);
	System.out.println(firstColumn1);
	secondColumn1 = allColumnNames.contains(secondColumn);
	fourthColumn1 = allColumnNames.contains(thirdColumn);
	fifthColumn1 = allColumnNames.contains(fourthcOlcumn);
	Thread.sleep(3000);	
	//Assert Details
	/*NEED TO ASSERT IN TEST CSASES
	 * SoftAssert verifyCreatedPageView = new SoftAssert ();
verifyCreatedPageView.assertEquals(firstColumn1, true);
	verifyCreatedPageView.assertEquals(thirdColumn1, true);
	verifyCreatedPageView.assertEquals(fourthColumn1, true);
	verifyCreatedPageView.assertEquals(fifthColumn1, true);
	verifyCreatedPageView.assertAll ();

	 */
}

/**
 * excel.readFromExcel(3, 0, 1  = Column name reading from excel sheet
 * @throws InterruptedException
 * @throws IOException
 */

void verifyCustomViewInSavedPageViews () throws InterruptedException, IOException{
	 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	 util.waitForElementAndClick( driver.findElement(lead.PageViewOption));
	 //Read the name from saved page view list
	customPageView = util.returnValueFromReactDropDownModel(driver.findElement(lead.CustomViewModel),
			excel.readFromExcel(3, 0, 1));
	Thread.sleep(3000);
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	System.out.println("My Custom view is"+" "+customPageView);
	Assert.assertEquals(customPageView, excel.readFromExcel(3, 0, 1));	
}


/**
 * @param pageViewname = name of Page View
 * @param columnToDisable = Cloumn which need to disable
 * @param secondColumnToDesable = Second column which user want desable
 * @throws IOException
 * @throws InterruptedException
 */
void editCustomView (String pageViewname,String columnToDisable,String secondColumnToDesable) throws IOException, InterruptedException{
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
	Thread.sleep(3000);
	//Select Custom page view from saved page list for Edit
	//(3, 0, 1)  - Custom page view name
    util.editDeletePageView("Edit",excel.readFromExcel(3, 0, 1));
	//Disable the column 
    Thread.sleep(3000);
	util.disableToggle(driver.findElement(lead.ColumnSelectionBox),columnToDisable);
	System.out.println("Disabling toggle Toggle");
	util.disableToggle(driver.findElement(lead.ColumnSelectionBox),secondColumnToDesable);
	customPageView1 = excel.readFromExcel(3, 0, 1);
	util.sendValue(driver.findElement(lead.InputBoxInEditView), pageViewname+" "+"edited");//Editing the Page name
	System.out.println("Disabling toggle Toggle");
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInEditPageView));
	String updatedSucess = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(updatedSucess, lead.editPageSucessMessage);
}

/**
 * 
 * @param desabledColum = Disabled colummn
 * @param DesabledColumn1 = Disabled column
 * @param enabledColumn = Enabled column
 * @param enabledColum2
 * @throws IOException
 * @throws InterruptedException
 */
void pageViewAfterEdit (String desabledColum, String DesabledColumn1, String enabledColumn, String enabledColum2) throws IOException, InterruptedException{
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
	//Switching to default view 
	util.editDeletePageView("Click", customPageView1+" "+"edited");
	Thread.sleep(3000);
	List<String> allColumnNames = util.tableHeader();
	System.out.println(allColumnNames);
	 desabledColumnEditPage = allColumnNames.contains(desabledColum);
	 desabledColumn1EditPage = allColumnNames.contains(DesabledColumn1);
	enabledColumnEditPage = allColumnNames.contains(enabledColumn);
	enabledColumnEdit1Page1 = allColumnNames.contains(enabledColum2);
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	//Checking page view get edited or not
	
	/**NEED TO ASSERT IN TEST CSASES
	 * SoftAssert pageViewAfterEdit = new SoftAssert ();
	 * pageViewAfterEdit.assertEquals(common.enabledColumnEdit1Page1, true);
		pageViewAfterEdit.assertEquals(common.enabledColumnEditPage, false);
		pageViewAfterEdit.assertEquals(desabledColumn1EditPage, false);
		pageViewAfterEdit.assertEquals(desabledColumnEditPage, true);
		pageViewAfterEdit.assertAll ();
		
	 */
}

/**
 * 
 * @throws IOException
 * @throws InterruptedException
 */
void pageViewInSavedPageAfterEdit() throws IOException, InterruptedException{
	driver.navigate().refresh();
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
	customPageView1 = excel.readFromExcel(3,0,1);
	String customPageView = util.returnValueFromReactDropDownModel(driver.findElement(lead.CustomViewModel),customPageView1+" "+"edited");
	System.out.println(customPageView);
	Assert.assertEquals(customPageView, customPageView1+" "+"edited");
	util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
}

/**
 * Deleting page view 
 * customPageView1  = Page view name 
 * excel.readFromExcel(3, 0, 1)  reading from excel (3, Sheet no, 0, row number, 1 Column number)
 * @throws InterruptedException
 * @throws IOException
 */
void deletePageView() throws InterruptedException, IOException {
	driver.navigate().refresh();
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	Thread.sleep(5000);
    util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
    Thread.sleep(3000);
	util.editDeletePageView("Delete", customPageView1+" "+"edited");
	Assert.assertEquals("Page view successfullt deleted", util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage)));
}

/**
 * Verify Deleted page view in saved page after delete
 * @throws IOException
 * @throws InterruptedException
 */
void verifyDeletdViewInSavedViews () throws IOException, InterruptedException{
		customPageView1 = excel.readFromExcel(3, 0, 1);
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
		String isViewSeleted = util.returnValueFromReactDropDownModel(driver.findElement(lead.CustomViewModel),customPageView1+"edited");
		String isViewSeleted1 = util.returnValueFromReactDropDownModel(driver.findElement(lead.CustomViewModel),customPageView1);
		Assert.assertEquals(isViewSeleted, null);
		Assert.assertEquals(isViewSeleted1, null);
	}


/**
 * validation for page view
 * @throws IOException
 * @throws InterruptedException
 */
void validationCreatePageView () throws IOException, InterruptedException{
	util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
	util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
	Thread.sleep(3000);
	//util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(1, 1, 0));
	util.findElementAndSenkKeys(driver.findElement(lead.InputBoxSaveCustomView), "");
	util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
	util.waitForElementToBeDisplayed(driver.findElement(lead.ValidationMessage));
	Thread.sleep(3000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	LeadTest leadtest = new LeadTest();
	leadtest.verifyDefaultEnabledColumn();
	String desabledClumn = new String (leadtest.namesOfToggles);
    util.disableToggle(driver.findElement(lead.ColumnSelectionBox),desabledClumn);
	util.findElementAndSenkKeys(driver.findElement(lead.InputBoxSaveCustomView), "test");
	util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
	Thread.sleep(3000);
	driver.navigate().refresh();
	util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
	//Switching to default view 
	util.waitForElementAndClick(driver.findElement(lead.DefaultView));
	
	
	/*NEED TO ASSERT IN TEST CSASES
	 * SoftAssert createValMsg = new SoftAssert ();
	 * createValMsg.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
	 * createValMsg.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
	createValMsg.assertAll();
	
	 */
}

/**
 * Add log 
 * Call this method and pass the value(Lead, Contacts, etc 
 * @param nameOfUser
 * @throws IOException
 * @throws InterruptedException
 */
void addLogcallListing (String nameOfUser) throws IOException, InterruptedException{
	Thread.sleep(3000);
	//TODO: firstPara = row, secandPara = collumn 
	util.clickOnActions(nameOfUser, driver.findElement(lead.LeadTable), "More Action");
	util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
	util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 1, 0));
	util.findElementAndSenkKeys(driver.findElement(lead.DetailsLogCall), excel.readFromExcel(4, 1, 1));
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(logConfirmation, lead.addLogSucessMessage);
	Thread.sleep(3000);
}

/**
 * 
 * @param nameOfuser 
 * @throws InterruptedException
 * @throws IOException
 */
void addLogValidationsListing (String nameOfuser) throws InterruptedException, IOException{
	util.clickOnActions(nameOfuser, driver.findElement(lead.LeadTable), "More Action");
	util.selectFromDropDownModal("Log Call", driver.findElement(lead.ActionMenuModel));
	util.waitForElementAndClick(driver.findElement(lead.SubjectLogCall));
	Thread.sleep(2000);
	driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
	tabsOutvalidationMsgforLogs = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	 addlogCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));

	/**NEED TO ASSERT IN TEST CSASES
	 * SoftAssert addLogValidationsListing = new SoftAssert();
	 * addLogValidationsListing.assertEquals(tabsOutvalidationMsgforLogs, lead.addLogFieldvaldiationMessage);
	 * addLogValidationsListing.assertEquals(addlogCommonError, leadEntry.CommonValidationMEssage);
	 * addLogValidationsListing.assertAll();
	 */
}
 
void addLogValidationsDetails () throws InterruptedException, IOException{
	
	Thread.sleep(2000);
	util.waitForElementAndClick(driver.findElement(lead.SubjectLogCall));
	driver.findElement(lead.SubjectLogCall).sendKeys(Keys.TAB);
	LogvalidationMsgInDetails = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	addlogCommonErrorInDeatils = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
	/**
	 * NEED TO ASSERT IN TEST CSASES
	 * SoftAssert addLogValidationsDetails = new SoftAssert();
	 * addLogValidationsDetails.assertEquals(LogvalidationMsgInDetails, lead.addLogFieldvaldiationMessage);
	 	addLogValidationsDetails.assertEquals(addlogCommonErrorInDeatils, leadEntry.CommonValidationMEssage);
		addLogValidationsDetails.assertAll();*/
}

/**
 * 
 * @param userName
 * @throws IOException
 * @throws InterruptedException
 */
void addLogErrorWhileClosing  (String userName) throws IOException, InterruptedException{
	 util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Log Call", driver.findElement(lead.ActionMenuModel));
	 util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 1, 0));
	 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
	 boolean alertStatus = util.isAlertPresent();
	 Assert.assertEquals(alertStatus, true);
	 util.acceptAlert();
	 driver.navigate().refresh();
}
/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void addlogErroWithOutchar (String userName) throws InterruptedException, IOException{
	 util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
	 util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
	 Thread.sleep(3000);
	 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
	 boolean alertStatus = util.isAlertPresent();
	 Assert.assertEquals(alertStatus, false);
	 
}

/**
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void changeOwner (String userName,String changeOwnerlable) throws InterruptedException, IOException{
	util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
	util.selectFromDropDownModal(changeOwnerlable,driver.findElement(lead.ActionMenuModel));
	Thread.sleep(3000);
	util.handleDropdown(driver.findElement(lead.ChangeleadOwner), lead.changeOwnerTo);
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	String sucessmessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
	util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
	util.acceptAlert();
	String currentOwner = util.getColumndata("Assigned To",userName);
	Assert.assertEquals(currentOwner, lead.changeOwnerTo);
		
}

/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void addNotevalidationListing(String userName) throws InterruptedException, IOException{
		util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
		util.waitForElementAndClick(driver.findElement(lead.SubjectNote));
		Thread.sleep(2000);
		driver.findElement(lead.SubjectNote).sendKeys(Keys.TAB);
		noteSubjectvaldiatinListing  = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
		
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		addnoteCommonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
	
		/**NEED TO ASSERT IN TEST CSASES
		 *  SoftAssert addNotevalidationMessage = new SoftAssert();
		 *  addNotevalidationMessage.assertEquals(noteSubjectvaldiatinListing, lead.addNoteFieldvaldiationMessage);
		 *  addNotevalidationMessage.assertEquals(addnoteCommonError, leadEntry.CommonValidationMEssage);
		 *  	addNotevalidationMessage.assertAll();
		 */
	
}
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 */
void addNotevalidationDetails() throws InterruptedException, IOException{
	   util.waitForElementAndClick(driver.findElement(leadDetails.MakeNote));
		util.waitForElementAndClick(driver.findElement(lead.SubjectNote));
		Thread.sleep(2000);
		driver.findElement(lead.SubjectNote).sendKeys(Keys.TAB);
		noteSubjectvaldiatinDetals = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		addnoteCommonErrorDetails = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));

		/**NEED TO ASSERT IN TEST CSASES
		 * SoftAssert addNotevalidationDetails = new SoftAssert();
		 * addNotevalidationDetails.assertEquals(noteSubjectvaldiatinDetals, lead.addNoteFieldvaldiationMessage);
		 * addNotevalidationDetails.assertEquals(addnoteCommonErrorDetails, leadEntry.CommonValidationMEssage);
		addNotevalidationDetails.assertAll();
		 */
	
}

/**
 * 
 * @param userName
 * @throws IOException
 * @throws InterruptedException
 */
void addNoteErrorWhileClosing  (String userName) throws IOException, InterruptedException{
	  util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
		 util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 1, 0));
		 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
		 boolean alertStatus = util.isAlertPresent();
		 Assert.assertEquals(alertStatus, true);
		 util.acceptAlert();
		 driver.navigate().refresh();
	 }

/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void addNoteErroWithOutchar (String userName) throws InterruptedException, IOException{
	 util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
	 util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
	 Thread.sleep(3000);
	 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
	 boolean alertStatus = util.isAlertPresent();
	 Assert.assertEquals(alertStatus, false);
}
/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void addNoteListing(String userName) throws InterruptedException, IOException{
	util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
	util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
	util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 1, 0));
	util.findElementAndSenkKeys(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 1, 1));
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(logConfirmation, lead.addNoteSucessMessage);
	Thread.sleep(3000);
}
 
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 */
void addNoteInDetails () throws InterruptedException, IOException{
	util.waitForElementAndClick(driver.findElement(leadDetails.MakeNote));
	util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 2, 0));
	util.findElementAndSenkKeys(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 2, 1));
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(logConfirmation, lead.addNoteSucessMessage);
	Thread.sleep(3000);
}


/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void addEvent (String userName) throws InterruptedException, IOException{
	
	util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
	util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
	Thread.sleep(3000);
	evententry.createEvent(6, 1);
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(sucessMEsssage, evententry.successMessage);	
}

/**
 * 
 * @throws InterruptedException
 */
void addEventInDeatilspage () throws InterruptedException{
	util.waitForElementAndClick(driver.findElement(leadDetails.NewEvent));
	evententry.createEvent(5, 2);
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
	Assert.assertEquals(sucessMessage, lead.addEventSucessMessage);
}
/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */
void tabsOutvalidationEvent (String userName) throws InterruptedException, IOException{
	util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
	util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
	Thread.sleep(3000);
	util.waitForElementAndClick(driver.findElement(evententry.Sujbect));
	driver.findElement(evententry.Sujbect).sendKeys(Keys.TAB);
	subjectvalErrorEvent = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
	driver.findElement(evententry.EventType).click();
	driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
	driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
	eventTypevalErrorEvent = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
	driver.findElement(evententry.StartDateTime).click();
	driver.findElement(evententry.StartDateTime).sendKeys(Keys.TAB);
	StartdatevalErrorEvent = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
	driver.findElement(evententry.EndDateTime).click();
	driver.findElement(evententry.EndDateTime).sendKeys(Keys.TAB);
	EnddatevalErrorEvent = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	commonvalidationEvent = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
	
	
	/*NEED TO ASSERT IN TEST CSASES
	 * SoftAssert addEventValidationError = new SoftAssert ();
	 * addEventValidationError.assertEquals(subjectvalErrorEvent, evententry.SubjectFieldvalError);
	addEventValidationError.assertEquals(eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
	addEventValidationError.assertEquals(StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
	addEventValidationError.assertEquals(EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
	addEventValidationError.assertEquals(commonvalidationEvent, evententry.commonValidationMessage);
	addEventValidationError.assertAll();
	 * 
	 */
	
}


/**
 * 
 * @throws InterruptedException
 * @throws IOException
 */
void tabsOutvalidationEventInDetails () throws InterruptedException, IOException{
	
	util.waitForElementAndClick(driver.findElement(leadDetails.NewEvent));
	util.waitForElementAndClick(driver.findElement(evententry.Sujbect));
	driver.findElement(evententry.Sujbect).sendKeys(Keys.TAB);
	subjectvalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
	driver.findElement(evententry.EventType).click();
	driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
	driver.findElement(evententry.EventType).sendKeys(Keys.TAB);
	eventTypevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
	driver.findElement(evententry.StartDateTime).click();
	driver.findElement(evententry.StartDateTime).sendKeys(Keys.TAB);
	StartdatevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
	driver.findElement(evententry.EndDateTime).click();
	driver.findElement(evententry.EndDateTime).sendKeys(Keys.TAB);
	EnddatevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
	
	util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	commonvalidationEventDetails = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
	
	util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
	

	/*NEED TO ASSERT IN TEST CSASES
	 * SoftAssert tabsOutvalidationEventInDetails = new SoftAssert ();
	 * tabsOutvalidationEventInDetails.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
	tabsOutvalidationEventInDetails.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
	tabsOutvalidationEventInDetails.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
	tabsOutvalidationEventInDetails.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
	tabsOutvalidationEventInDetails.assertEquals(commonvalidation, evententry.commonValidationMessage);
	tabsOutvalidationEventInDetails.assertAll();
	 */
}
/**
 * 
 * @param userName
 * @throws InterruptedException
 * @throws IOException
 */

	void commonvalidationEvent (String userName) throws InterruptedException, IOException{
		
		util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		subjectvalErrorEventDetails= util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
		eventTypevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
		StartdatevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
		EnddatevalErrorEventDetails= util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		commonvalidationEventDetails = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
		
		
		/**NEED TO ASSERT IN TEST CSASES
		 * SoftAssert addEventCommonvalidation = new SoftAssert ();
		 * addEventCommonvalidation.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
		addEventCommonvalidation.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
		addEventCommonvalidation.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
		addEventCommonvalidation.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
		addEventCommonvalidation.assertEquals(commonvalidation, evententry.commonValidationMessage);
		addEventCommonvalidation.assertAll();
		 */
		
	}
	
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 */
	void commonvalidationEventDetails () throws InterruptedException, IOException{
		
		util.waitForElementAndClick(driver.findElement(leadDetails.NewEvent));
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		subjectvalErrorEventDetails= util.getValidationMessage(driver.findElement(evententry.SubjectValidation));
		eventTypevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.EveneTypevaldiation));
		StartdatevalErrorEventDetails = util.getValidationMessage(driver.findElement(evententry.StartDateTimevalidation));
		EnddatevalErrorEventDetails= util.getValidationMessage(driver.findElement(evententry.EndDateTimeValidation));
		
		commonvalidationEventDetails = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
		
		/**NEED TO ASSERT IN TEST CSASES
		 * SoftAssert commonvalidationEventDetails = new SoftAssert();
		 * 	commonvalidationEventDetails.assertEquals(subjectvalError, evententry.SubjectFieldvalError);
		commonvalidationEventDetails.assertEquals(eventTypevalError, evententry.EventTypeFieldvalError);
		commonvalidationEventDetails.assertEquals(StartdatevalError, evententry.StartDateTimeFieldvalError);
		commonvalidationEventDetails.assertEquals(EnddatevalError, evententry.EndDateTimeFieldvalError);
		commonvalidationEventDetails.assertEquals(commonvalidation, evententry.commonValidationMessage);
		commonvalidationEventDetails.assertAll();
		
		 */
	}
	
	/**
	 * 
	 * @param userName
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void addEventAlertWhileClosng (String userName) throws InterruptedException, IOException{
		util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
		util.sendValue(driver.findElement(evententry.Sujbect), "Test");
		util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
		boolean alert = util.isAlertPresent();
		Assert.assertEquals(alert, true);
		util.acceptAlert();
		
	}
	/**
	 * 
	 * @param userName
	 * @param path
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void addAttachement (String userName,String path) throws InterruptedException, IOException{
		
		util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Add Attachment",driver.findElement(lead.ActionMenuModel));
		Thread.sleep(3000);
		util.sendValue(driver.findElement(lead.uploadinAttachemnt), path);
		util.sendValue(driver.findElement(lead.DetailsInAttachment), "Adding file ");
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		try {
		String success = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		driver.navigate().refresh();
		System.out.println(success);
		Assert.assertEquals(success, lead.addAttachmentSucessMessage);

		}
		catch (Exception E){
			driver.navigate().refresh();
		}
	}
	/**
	 * 
	 * @param userName
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void attachmentCommonvalidation (String userName) throws InterruptedException, IOException{
		
		util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		String commonValidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
		Assert.assertEquals(commonValidation, lead.commonvalidationAttachment);
	}
	
	/**
	 * 
	 * @param path
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void addAttachementInDetails (String path) throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadDetails.AddAttachment));
		util.sendValue(driver.findElement(lead.uploadinAttachemnt), "path");
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		String success = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		System.out.println(success);
		Assert.assertEquals(success, lead.addAttachmentSucessMessage);
		
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void attachmentCommonvalidationInDetails () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadDetails.AddAttachment));
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		String commonValidation = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
		Assert.assertEquals(commonValidation, lead.commonvalidationAttachment);
	}
	/**
	 * 
	 * @param userName
	 * @throws InterruptedException
	 * @throws IOException
	 */
	 void deleteLeadFromListing (String userName) throws InterruptedException, IOException{
			util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Change Lead Owner",driver.findElement(lead.ActionMenuModel));
			util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		}
		
	 /**
	  * 
	  * @param userName
	  * @throws IOException
	  */
	 void getLeadDetailsHeader (String userName) throws IOException{
			util.loopColumnFindName(userName, driver.findElement(lead.LeadTable));
			util.column.click();
			String headerTitle = util.getElementName(driver.findElement(leadDetails.TitleLeadDetails));
			Assert.assertEquals(headerTitle, "LEAD");
		}
	
	 
		/**
		 * 
		 * @throws InterruptedException
		 */
		void addLogValidationInDetailsPage () throws InterruptedException{
			util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), "");
			util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			String addLogValidationMessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
			Assert.assertEquals(addLogValidationMessage, "This field required");
			util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
		}
		
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		void addNotevalidationDetailsPage () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(leadDetails.MakeNote));
			util.findElementAndSenkKeys(driver.findElement(lead.SubjectNote),"");
			util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			String addLogValidationMessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
			Assert.assertEquals(addLogValidationMessage, "This field required");
			util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));	
		}
		
		/**
		 * 
		 * @param userName
		 * @throws InterruptedException
		 * @throws IOException
		 */
		 void delete (String userName) throws InterruptedException, IOException{
				util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Delete Lead",driver.findElement(lead.ActionMenuModel));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String userName1 = util.loopColumnFindName(userName, driver.findElement(lead.LeadTable));
				Assert.assertNull(userName1);
				
		 }

		 /**
		  * 
		  * @param userName
		  * @throws IOException
		  * @throws InterruptedException
		  */
		 void verifyRedirctionToDetilspage (String userName) throws IOException, InterruptedException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.waitForElementAndClick(driver.findElement(lead.PageViewOption));
				util.waitForElementAndClick(driver.findElement(lead.DefaultView));
				driver.findElement(lead.PageSearchOption).click();
				driver.findElement(lead.SearchbarOption).sendKeys(userName);
				Thread.sleep(3000);
				util.clickOnActions(userName,
				driver.findElement(lead.LeadTable), "Redirection");

		 }
		 
		  /**
		   * 
		   * @throws IOException
		   * @throws InterruptedException
		   */
		  void addLogcallDetails() throws IOException, InterruptedException{
			  driver.navigate().refresh();
				Thread.sleep(3000);
				util.findElementAndSenkKeys(driver.findElement(lead.SubjectLogCall), excel.readFromExcel(4, 2, 0));
				util.findElementAndSenkKeys(driver.findElement(lead.DetailsLogCall), excel.readFromExcel(4, 2, 1));
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String logConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
				Assert.assertEquals(logConfirmation, lead.addLogSucessMessage);
				Thread.sleep(3000);
		  }
		  
		  /**
		   * 
		   * @param userName
		   * @throws InterruptedException
		   * @throws IOException
		   */
		  void addtask (String userName) throws InterruptedException, IOException{
			
				
				util.clickOnActions(userName, driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Task",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				taskentry.createTask(7, 1);
				util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
				Assert.assertEquals(sucessMEsssage, taskentry.taskSucessMessage);
		  }
		  /**
		   * 
		   * @throws InterruptedException
		   */
		  void addtaskInDetails() throws InterruptedException{
			  util.waitForElementAndClick(driver.findElement(leadDetails.NewTask));
			  taskentry.createTask(7, 2);
			  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				String sucessMEsssage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
				Assert.assertEquals(sucessMEsssage, taskentry.taskSucessMessage);
		  }
		   
		  /**
		   * 
		   * @param path
		   * @param MainMenu
		   * @throws InterruptedException
		   * @throws IOException
		   */
		  void importLead (String path,By MainMenu) throws InterruptedException, IOException{
			  util.waitForElementAndClick(driver.findElement(lead.ActionButton));
			  util.selectFromDropDownModal("Import",driver.findElement(lead.ActionDropDownList));
			  Thread.sleep(3000);
			  util.sendValue(driver.findElement(lead.UplaodOptionInIMport), path);
			  Thread.sleep(3000);
			  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			  Thread.sleep(2000);
			  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			  importSuccess = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
			  util.waitForElementAndClick(driver.findElement(MainMenu));
			  Thread.sleep(3000);
			  importLeadInListing = util.loopColumnFindName("Import", driver.findElement(lead.LeadTable));
		
			  /*NEED TO ASSERT IN TEST CSASES
			   *  SoftAssert importLead = new SoftAssert ();
			   *   importLead.assertEquals(importSuccess, lead.importSuccessMessage);
			   *   importLead.assertEquals(importLeadInListing, "Import");
			   */
			  
		  }
		  /**
		   * 
		   */
		  public String validationMessageImport;
		  void importValidation (By mainMenu,String path) throws InterruptedException{
			  util.waitForElementAndClick(driver.findElement(mainMenu));  
			  util.waitForElementAndClick(driver.findElement(lead.ActionButton));
			  util.selectFromDropDownModal("Import",driver.findElement(lead.ActionDropDownList));
			  Thread.sleep(3000);
			  util.sendValue(driver.findElement(lead.UplaodOptionInIMport), path);
			  Thread.sleep(3000);
			  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			  validationMessageImport = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
			  Assert.assertEquals(validationMessageImport, lead.importmanditoryFiedValidation);
		  }
		  
	
		  /**
		   * 
		   * @throws InterruptedException
		   * @throws IOException
		   */
		  void addNoteForAll (By note) throws InterruptedException, IOException{
			  util.waitForElementAndClick(driver.findElement(lead.AllSelect));
			  Thread.sleep(3000);
			  //util.waitForElementAndClick(driver.findElement(lead.MoreOptionInAllSelect));
			 // util.selectFromDropDownModal("Add Note",driver.findElement(lead.AllSelectMoreDropdown));
			  util.waitForElementAndClick(driver.findElement(note));
			  util.sendValue(driver.findElement(lead.SubjectNote), excel.readFromExcel(5, 3, 1));
			  util.sendValue(driver.findElement(lead.DetailsNote), excel.readFromExcel(5, 3, 2));
			  util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			  String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
			  Assert.assertEquals(sucessMessage, lead.addNoteSucessMessage);
		  }
		  
		  /**
		   * 
		   * @param element = for Sending Values
		   * @param enterMaxChar = Enter Maximum charactres 
		   * @param expected = Expcted error message 
		   * @param validationMessage = Validation message
		   * @throws InterruptedException
		   */
		  void maximumCharTabsvalidation (By elementToSendvalue, String enterMaxChar,String expected,By validationMessageElement) throws InterruptedException{
			  try {
				  driver.findElement(elementToSendvalue).clear(); 
				driver.findElement(elementToSendvalue).sendKeys(enterMaxChar);
				  driver.findElement(elementToSendvalue).sendKeys(Keys.TAB);
				  String actual = util.getValidationMessage(driver.findElement(validationMessageElement));
				  Thread.sleep(3000);
				  Assert.assertEquals(actual, expected);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
		  /**
		   * 
		   * @param fiedType = the Element where user need to enter
		   * @param value = value to Enter
		   * @param errorElement = Error Element
		   * @param message = Expecetd validationMessage 
		   */
		   void fieldTypevalidationError (By fiedType,String value,By errorElement){
			   try {
				driver.findElement(fiedType).clear();
				   driver.findElement(fiedType).sendKeys(value);
				   driver.findElement(fiedType).sendKeys(Keys.TAB);
  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		  
		   void commmonfieldTypevalidationError (By fiedType,String value,By errorElement){
			   try {
				driver.findElement(fiedType).clear();
				   driver.findElement(fiedType).sendKeys(value);
				   util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			}
		  
		  /**
		   * 
		   * @param emailID
		   * @throws InterruptedException
		   */
		  void emailtabsOutvalidation(By emailID,String action,By emailvalidationElement) throws InterruptedException{
			  Thread.sleep(3000);
			  SoftAssert emailtabsOutvalidation = new SoftAssert();
			  String [] alertError = {"alert1","alert2","alert3","alert4","alert5","alert6","alert7","alert1","alert8","alert9","alert10","alert11","alert12","alert13","alert14","alert14","alert14"};
			  String [] invalidEmailID = {"plainaddress","#@%^%#$@#$@#.com","@domain.com",
					 "Joe Smith <email@domain.com>","email.domain.com","email@domain@domain.com",".email@domain.com","email.@domain.com","email..email@domain.com",
					 "あいうえお@domain.com","email@domain.com (Joe Smith)","email@domain",
					 "email@-domain.com","email@domain.web","email@111.222.333.44444","email@domain..com"};
			   int size = invalidEmailID.length;
			   for (int i =0;i<size;i++){
				   System.out.println(i);
				   int softSize = alertError.length;
				   bb:
				   for (int j=0;j<softSize;j++){
					System.out.println(j);
				   driver.findElement(emailID).clear();
				   util.sendValue(driver.findElement(emailID), invalidEmailID[i]);
				   Thread.sleep(3000);
				   //If user want to check, tabs out validation, The it will switch to If case
				   //Call the method and Pass "tabs" for tabs out validation and Else "common" for common validation
				   if (action=="tabs"){
					   Thread.sleep(2000);
				   driver.findElement(emailID).sendKeys(Keys.TAB);
				   driver.findElement(emailID).sendKeys(Keys.TAB);
                       try {
						alertError[j] = util.getValidationMessage(driver.findElement(emailvalidationElement));
						  try{
                          emailtabsOutvalidation.assertEquals(alertError[j],leadEntry.emailIDInvalidError);
						  }
						  catch(AssertionError e){
								Assert.fail();
						  }
					} catch (Exception e) {
					
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
				   else {
					   //Else Do common validation
					   Thread.sleep(3000);
					   try{
					   util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					   }
					   catch(Exception e){
						   util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
					   }
					   try {
							alertError[j] = util.getValidationMessage(driver.findElement(emailvalidationElement));
							  try{
	                          emailtabsOutvalidation.assertEquals(alertError[j],leadEntry.emailIDInvalidError);
							  }
							  catch(AssertionError e){
									Assert.fail();
							  }
						} catch (Exception e) {
						
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				   }
                       break bb;
				   }
			   }
			   
			   emailtabsOutvalidation.assertAll();
		  }
		  
		  /**
		   * 
		   * @param webSite
		   * @param action
		   * @throws InterruptedException
		   */
		  void webSitevalidation(By webSite,String action,By EmailvalidationElement) throws InterruptedException{
			  Thread.sleep(3000);
			  SoftAssert webSitevalidation = new SoftAssert();
			  String [] alertError = {"alert1","alert2","alert3","alert4","alert5","alert6","alert7","alert1","alert8","alert9","alert10","alert11","alert12","alert13","alert14","alert14","alert14"};
			 //List of invalid Web Site 
			  String [] invalidWebSite = {"http://",
					  "sdfdfgfsdfsdg",
					  "http://..",
					  "example.com",
					  "http://?",
					  "http://??",
					  "http://??/",
					  "http://#",
					  "http://##",
					  "http://##/",
					  "http://foo.bar?q=Spaces should be encoded",
					  "//",
					  "//a",
					  "///a",
					  "///",
					  "http:///a",
					  "foo.com",
					  "rdar://1234",
					  "h://test",
					  "http:// shouldfail.com",
					  ":// should fail",
					  "http://foo.bar/foo(bar)baz quux",
					  "ftps://foo.bar/",
					  "http://-error-.invalid/",
					  "http://.www.foo.bar./"};
			   int size = invalidWebSite.length;
			   for (int i =0;i<size;i++){
				   System.out.println(i);
				   int softSize = alertError.length;
				   bb:
				   for (int j=0;j<size;j++){
					System.out.println(j);
				   driver.findElement(webSite).clear();
				   util.sendValue(driver.findElement(webSite), invalidWebSite[i]);
				   Thread.sleep(3000);
				   //If Action is tabs, then do Tabs out validation
				   if (action=="tabs"){
				   driver.findElement(webSite).sendKeys(Keys.TAB);
                       try {
						alertError[j] = util.getValidationMessage(driver.findElement(EmailvalidationElement));
						try{
						webSitevalidation.assertEquals(alertError[j], leadEntry.webSiteInvalidError);
						}
						catch(AssertionError e){
							Assert.fail();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
				   //Else do Common validation 
				   else {
					   Thread.sleep(3000);
					   util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
					   try {
							alertError[j] = util.getValidationMessage(driver.findElement(EmailvalidationElement));
							webSitevalidation.assertEquals(alertError[j], leadEntry.webSiteInvalidError);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				   }
                       break bb;
				   }
			   }
			   webSitevalidation.assertAll();
		  }
		  
		  /**
		   * 
		   * @param customValues = The additional value apart from entry form 
		   * Fucntion = Get the Entry form Label Values and Compare Filter by Values
		   * Entry for Values and Filter By Values should same,This function will check both values and return pass or fail
		   * @throws InterruptedException
		   * customValues =Some Option we are not listing in Entry form such as lead Converted, lead Created, etc
		   * Hence We have to Append he value on Entry form Lable values 
		   */
		  void checkFilterByValues (String [] customValues) throws InterruptedException{
			  driver.navigate().refresh();
			  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
			  Thread.sleep(3000);
			  //Get the All label and Get the Text and store as Array list 
			  List lableNames = util.returnDropDownList(lead.ActionPopUp, leadEntry.EntryLabels);
			  //Convert to list to String
			  String valuesCommaSeparated = String.join(",", lableNames)+","+String.join(",",customValues);
			 // String valuesWithCustomValues = valuesCommaSeparated+(Arrays.toString(customValues));
			  System.out.println(valuesCommaSeparated);
			  //System.out.println(valuesCommaSeparated  +" "+ "This is the value with CustomValues");
			  util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
			  Thread.sleep(3000);
			  //Click on Filter Option 
			  util.waitForElementAndClick(driver.findElement(lead.FilterOption));
			  Thread.sleep(2000);
			  util.waitForElementAndClick(driver.findElement(lead.FilterFieldBy1));
			  //Get the values from Filter By Dropdown list 
			  List filterValues = util.returnDropDownList(lead.FilterFieldBy1,By.xpath("//div[@role='option']"));
			  String filterValuesComaSeperated = String.join(",", filterValues);
			 // System.out.println(filterValuesComaSeperated);
			  //Filter by value and Entry form label should be same
			  boolean statusOfList = util.compareList(valuesCommaSeparated, filterValuesComaSeperated);
			  Assert.assertEquals(statusOfList, true);
  
		  }
		  
		  
		  
		 /**
		  * 
		  * @param firstName
		  * @param operator
		  * @param selection
		  * @param valueToCompare
		  * @throws InterruptedException
		  * @throws NullPointerException
		  */
		  void operatorListvalidation(By firstName,By operator,String selection,String valueToCompare) throws InterruptedException,NullPointerException{
			  util.waitForElementAndClick(driver.findElement(firstName));
			  Thread.sleep(2000);
			  util.handleDropdown(driver.findElement(firstName), selection);
			  Thread.sleep(3000);
			  util.waitForElementAndClick(driver.findElement(operator));
			  Thread.sleep(3000);
			  List values = util.returnDropDownList(operator,By.xpath("//div[@role='option']"));
			  System.out.println(values + " "+ "List values");
			  String valuesCommaSeparated = String.join(",", values);
			  System.out.println(valuesCommaSeparated + " "+ "Separated by coma");
			  boolean statusOfList = util.compareList(valuesCommaSeparated, valueToCompare);
			  Assert.assertEquals(statusOfList, true);
			  
		  }
		  
		  String readFieldType(By elementForTypeCheck){
			String type = driver.findElement(elementForTypeCheck).getTagName();
			System.out.println("The Field Type is "+""+type);
			return type;  
		  }
		  
		  
	/**
	 * 	  
	 * @param nameOfuser = The name user wants to Add
	 * @param valType = Which validation you want 
	 * @throws InterruptedException = 
	 * @throws IOException
	 */
		  
    void selectActions(String nameOfuser, String actionname) throws InterruptedException{
    	util.clickOnActions(nameOfuser, driver.findElement(lead.LeadTable), "More Action");
		util.selectFromDropDownModal(actionname, driver.findElement(lead.ActionMenuModel));  
		  }
   
/**
 * 
 * @param name = array list for Type of charactrts 
 * @param element = Element to click 
 * @param validationMessageElement = Validation Element 
 * @param valdiationMessage = valdiation Message 
 * @throws InterruptedException = 
 */
	void commonvalidationsFieldTypes (String [] name,By element ,By validationMessageElement,String valdiationMessage) throws InterruptedException{
		SoftAssert coomonVa = new SoftAssert();
		for (int i =0;i<name.length;i++){
			System.out.println(name.length);
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(name[i]);
			try{
            util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			}
			catch(Exception e){
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			}
            try{
			String message = util.getValidationMessage(driver.findElement(validationMessageElement));
			coomonVa.assertEquals(message, valdiationMessage);
            }
            catch (AssertionError e) {
    			Assert.fail();
            }
		}
		coomonVa.assertAll();
}
	
	/**
	 * 
	 * @param name = array list for Type of charactrts 
 * @param element = Element to click 
 * @param validationMessageElement = Validation Element 
 * @param valdiationMessage = valdiation Message 
	 */
	void tabsOutvalidationsFieldTypes (String [] name,By element ,By validationMessageElement,String valdiationMessage){
		SoftAssert tabsval = new SoftAssert();
		for (int i =0;i<name.length;i++){
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(name[i]);
			driver.findElement(element).sendKeys(Keys.TAB);
			try{
			String message = util.getValidationMessage(driver.findElement(validationMessageElement));
			tabsval.assertEquals(message, valdiationMessage);;
			}
			catch (AssertionError e) {
    			Assert.fail();
            }
			}
		tabsval.assertAll();
		}
	
	
	 /**
	  * 
	  * @param element = Element to click
	  * @param validationElement = Element for validation 
	  * @param valMessage = Element message 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void commonValidationFieldType(String [] arrayValues,By element,By validationElement,String valMessage) throws InterruptedException, IOException{
		 String [] name = arrayValues;
		 commonvalidationsFieldTypes(name, element,
				 validationElement,
				 valMessage);
	 }
	 
	 /**
	  * 
	  * @param element  = Element to for click
	  * @param validationElement = Element for validation message 
	  * @param valMessage = Vadlaition message 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void tabsOutValidationFieldType (String [] arrayValues,By element,By validationElement,String valMessage) throws InterruptedException, IOException{
		 String [] name = arrayValues;
		 tabsOutvalidationsFieldTypes(name, element,
				 validationElement,
				 valMessage);
	 }
	 
	/**
	 * 
	 * @param headerName
	 * @param nameOfUser
	 * @param inlineEditBox
	 * @param action
	 * @param EmailvalidationElement
	 * @throws InterruptedException
	 */
	 void inlineEmailIdValidation(String headerName,String nameOfUser,By inlineEditBox,String action,By EmailvalidationElement) throws InterruptedException{
		 util.inlineEditInTable(headerName, nameOfUser);
		 Thread.sleep(3000);
		 emailtabsOutvalidation(inlineEditBox,action,EmailvalidationElement);
		/* if (!(action=="tabs")){
			 try{
				 util.inlineEditInTable(headerName, nameOfUser); 
			 }
			 catch(AssertionError e){
				 Assert.fail();
			 }
		 } */
	 }
	 
	 /**
	  * 
	  * @param headerName
	  * @param nameOfUser
	  * @param inlineEditBox
	  * @param action  //pass "tabs" for tabs out validation, else it will perform common validation
	  * @param EmailvalidationElement
	  * @throws InterruptedException
	  */
	 void inlineWeSitevaldiation(String headerName,String nameOfUser,By inlineEditBox,String action,By EmailvalidationElement) throws InterruptedException{
		 util.inlineEditInTable(headerName, nameOfUser);
		 Thread.sleep(3000);
		 emailtabsOutvalidation(inlineEditBox, action,EmailvalidationElement);
		 /*if (!(action=="tabs")){
			 try{
				 util.inlineEditInTable(headerName, nameOfUser); 
			 }
			 catch(AssertionError e){
				 Assert.fail();
			 }
		 }  */
	 }
	 
	 
	 /**
	  * 
	  * @param headerName = Header name of the Table
	  * @param nameOfUser = Name of the User
	  * @param arrayValues = values for Validation
	  * @param element = Element for Validation 
	  * @param validationElement = Element for Validiaton error element
	  * @param valMessage = validation message 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void inlineEditTabsOutValidation (String headerName,String nameOfUser,String []arrayValues,
			 By element,By validationElement,String valMessage) throws InterruptedException, IOException{
		 util.inlineEditInTable(headerName, nameOfUser);
		 Thread.sleep(2000);
		 tabsOutValidationFieldType(arrayValues, element, validationElement, valMessage);
	 }
	 
	 /**
	  * 
	  * @param headerName = Header name of the Table
	  * @param nameOfUser = Name of the User
	  * @param arrayValues = values for Validation
	  * @param element = Element for Validation 
	  * @param validationElement = Element for Validiaton error element
	  * @param valMessage = validation message 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void inlineEditCommonValdiation(String headerName,String nameOfUser,String []arrayValues,
			 By element,By validationElement,String valMessage) throws InterruptedException, IOException{
		 util.inlineEditInTable(headerName, nameOfUser);
		 Thread.sleep(2000);
		 commonValidationFieldType(arrayValues, element, validationElement, valMessage);
		 
	 }
	 
	 /**
	  * 
	  * @param ele1
	  * @param ele2
	  * @param ele3
	  * @param ele4
	  * @param ele5
	  * @param ele6
	  * @param ele7
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 
	public  String [] attributeValues;
	public String[] getAttribute(String user,By ele1,By ele2,By ele3,By ele4,By ele5,By ele6,By ele7) throws InterruptedException, IOException{
		util.recordSelection("100");
		util.clickOnActions(user, driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Edit",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			//Get the Some Field values 
			try{
			String attribute1 = driver.findElement(ele1).getAttribute("value");
			String attribute2 = driver.findElement(ele2).getAttribute("value");
			String attribute3 = driver.findElement(ele3).getAttribute("value");
			String attribute4 = driver.findElement(ele4).getAttribute("value");
			String attribute5 = driver.findElement(ele5).getAttribute("value");
			String attribute6 = driver.findElement(ele6).getAttribute("value");
			String attribute7 = driver.findElement(ele7).getAttribute("value");
			String [] attributeValues = new String[] {attribute1,attribute2,attribute3,attribute4,attribute5,attribute6,attribute7};
			}
			catch(Exception e){
				
			}
			util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
			return attributeValues;
        
	 }
	   /**
	    * 
	    * @param beforeEdit = values Before Edit
	    * @param aferEdit = Values After Edit
	    */
	  public void compareArrays (String [] beforeEdit,String [] aferEdit){
		  Assert.assertFalse( Arrays.equals(beforeEdit, aferEdit) );
	  }
	  /**
	   * Discard the inline edit changes and Verify the Changes are not saved 
	   * @param headerName 
	   * @param nameOfUser
	   * @param elementToSenValues
	   * @throws InterruptedException
	   */
	  void discardInlineEditChanges (String headerName, String nameOfUser,By elementToSenValues) throws InterruptedException{
		  //Get Current Column Data
		  String currentColumnData = util.getColumndata(headerName, nameOfUser);
		  util.inlineEditInTable(headerName, nameOfUser);
		  Thread.sleep(2000);
		  //Edit by using inline Edit and Save
		  driver.findElement(elementToSenValues).sendKeys(currentColumnData+ " "+ "Edited");
		  driver.findElement(lead.InlineEditSaveButtonTable).click();
		  Thread.sleep(3000);
		  //Click on Discard to roll back the inline edit changes 
		  driver.findElement(lead.InlineEditBuikDiscardButton).click();
		  Thread.sleep(3000);
		  //Get the Column data after Edit
		  String columnValueAfterDiscard = util.getColumndata(headerName, nameOfUser);
		  Assert.assertNotEquals(currentColumnData, columnValueAfterDiscard);
	  }
	  
	  /**
	   * 
	   * @param activity = Activity which need to verify 
	   * @param nameToVerify = Values which is added to listing 
	   * @param table = Activity table
	   */
	  void verifyactivityLisiInDetails (WebElement activity,String nameToVerify,WebElement table){
		  activity.click();
		  String value= util.loopColumnFindName(nameToVerify, table);
		  Assert.assertNotNull(value);
		  
	  }
	  
	  /**
	     *
	     * @param valueInActivitytable = Entry which want to Edit
	     * @throws InterruptedException
	     */
		  void editFromActivitytable(WebElement activity,String valueInActivitytable,By subject,By details)throws InterruptedException{
		      //Click on Individual adtion from the activity table
			  activity.click();
			  util.clickOnActions(valueInActivitytable, driver.findElement(lead.LeadTable), "More Action");
			  //Click on Edit buttin from the Dropdown box
			  util.selectFromDropDownModal("Edit",driver.findElement(lead.ActionMenuModel));
			  Thread.sleep(2000);
			  //Get the current value of Subject and Details
			  String subjectvalue = driver.findElement(subject).getAttribute("value");
			  String detailsValue = driver.findElement(details).getAttribute("value");
			  //Edit the value to to update the activity
			  String editSubject = subjectvalue + " "+ "Edited";
			  String editDetails = details + " "+ "Edited";
			  driver.findElement(subject).sendKeys(editSubject);
			  driver.findElement(details).sendKeys(editDetails);
			  //Click on Update Button 
			  util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
			  Thread.sleep(2000);
			  //Verity Edited details are updated in Activity table
			  verifyactivityLisiInDetails(activity, 
					  editSubject,
					  driver.findElement(lead.LeadTable));
			  //Verify Edited details are updated in Activity table
			  verifyactivityLisiInDetails(activity, 
					  editDetails,
					  driver.findElement(lead.LeadTable));
			  SoftAssert edit = new SoftAssert();
			  edit.assertNotNull(editSubject);
			  edit.assertNotNull(editDetails);
			  edit.assertAll();	  
		  }

	    /**
	     *
	     * @param valueInActivitytable = Entry which want to Delete
	     * @throws InterruptedException
	     */
		  void deleteFromActiityTable(WebElement activity,String valueInActivitytable)throws InterruptedException{
	          //Click on Individual adtion from the activity table
			  util.waitForElementAndClick(activity);
	          util.clickOnActions(valueInActivitytable, driver.findElement(lead.LeadTable), "More Action");
	          //Click on Delete buttin from the Dropdown box
	          util.selectFromDropDownModal("Delete",driver.findElement(lead.ActionMenuModel));
	          util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
	          Assert.assertNull(util.loopColumnFindName(valueInActivitytable, driver.findElement(lead.LeadTable)));
	      }
		  
		  
		  
}		
	 







