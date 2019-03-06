package Testcases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePackage.DriverClass;
import Pages.ContactDetails;
import Pages.ContactsEntry;
import Pages.ContactsListing;
import Pages.EventEntry;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.PCUtility;
import Pages.TaskEntry;

@Listeners(ListenersClass.class)

public  class ContactsTest extends DriverClass{
	
    ContactsEntry contactentry = new ContactsEntry();
	ContactsListing contactlist = new ContactsListing();
	ContactDetails contactdetails = new ContactDetails();
	PCUtility util = new PCUtility ();
	LeadListing lead = new LeadListing();
	ExcelReader excel = new ExcelReader ();
	LeadEntry leadEntry = new LeadEntry();
	LeadDetails leadDetails = new LeadDetails ();
	LeadTest leadtest = new LeadTest ();
	CommonFeature common = new CommonFeature();
	String [] customValue = {"Contact Created By", "Contact Create"};
	
	public final int addContacts = 10;
	public final int refresh = 20;
	public final int latestContactPosition = 30;
	public final int saveAndNew = 40;
	public final int verifyContactsInListngPage = 50;
	public final int verifySearchInContact = 60;
	public final int createPageView = 70;
	public final int verifyCreatedPageViewContacts = 80;
	public final int verifyDefaultViewContacts = 90;
	public final int verifyCustomViewInSavedPageViewsContacts = 100;
	public final int editCustomViewContacts = 110;
	public final int pageViewAfterEditContacts = 120;
	public final int alreadyExistpageViewNameContacts = 121;
	public final int pageViewInSavedPageAfterEditContacts = 130;
	public final int deletePageViewContacts = 140;
	public final int tabsOutvalidationInValidaEmailContacts    = 141;
	public final int commonValidationEmailIDContacts   = 142;
	public final int firstNamefieldvalidationInContacts   = 143;
	public final int lastNameFieldvaldidationContact  = 144;
	public final int designationFieldvalidationContact   = 145;
	public final int departmentFiedlvalidationError    = 146;
	public final int officeNumberFieldvalidation    = 147;
	public final int mobileNumberFieldValdiation   = 148;
	public final int postCodeFieldValidation   = 149;
	public final int validationCreatePageViewContacts = 150;
	public final int contactsTabsandCommonValidationOutvalidation = 160;
	public final int verifyAlertwhileClosing = 170;
	public final int verifyAlertWithOutEntering = 180;
	public final int statevalidationWithOutCountry = 181;
	public final int addLogcallListing = 190;
	public final int addLogValidationsListingContacts =200;
	public final int addLogErrorWhileClosingLog = 210;
	public final int addlogErroWithOutcharLog =220;
	public final int logSubjecttabsOutValidation =221;
	public final int logSubjectCommonValidation =222;
	public final int addNoteListing = 230;
	public final int addNotevalidationListingContacts = 240;
	public final int addNoteErrorWhileClosing = 250;
	public final int addNoteErroWithOutchar =260;
	public final int noteSubjecttabsOutValidation = 261;
	public final int noteSubjectCommonValidation = 262;
	public final int addEvent = 270;
	public final int tabsOutvalidationEventContacts = 280;
	public final int  commonvalidationEventContacts =290;
	public final int  EventSubjecttabsOutValidation =291;
	public final int  EventSubjectCommonValidation =292;
	public final int  EventLocationtabsOutValidation =293;
	public final int  EventLocationCommonValidation =294;
	public final int addAttachement = 300;
	public final int addTaskInContacts = 310;
	public final int changeAssignee = 320;
	public final int addNoteForAll = 330;
	public final int changeOwnerforAll = 340;
	public final int discardInlineEdit = 341;
	public final int inlineEditInLeadTable = 350;
	public final int emailInlineEditTabsOutalidationContacts = 351;
	public final int emailInlneEditCommonValidationContacts = 352;
	public final int inlineTabsNumericalNumbervalidation	 = 353;
	public final int inlineCommonNumericalNumbervaldation = 354;
	public final int inlineCommonalphanumericalvaldation = 355;
	public final int inlineEditCommovalidationForAlphanumeric = 356;
	public final int inlineEditTabOutTextFieldvalidation = 357;
	public final int inlineEditCommonTextieldValidation = 358;
	public final int verifyFilter = 360;
	public final int checkFilterByValues = 361;
	public final int verifyRedirectionToDetailsPage = 364;
	public final int verifyHeaderForDetails = 365;
	public final int addLogcallDetails = 370;
	public final int addLogValidationsDetails = 375;
	public final int verifyLogcallInDetailsPage = 380;
	public final int logSubjectTabOutValidationDetails = 385;
	public final int logSubjectCommonvalidationDetails = 390;
	public final int deleteLogCallFromActivityTable = 391;
	public final int editLogCallFrometails = 392;
	public final int addNoteInDetails = 395;
	public final int addNotevalidationInDetails = 400;
	public final int verifyNoteIndetails = 405;
	public final int addnotetabsOutvalidationInDetail = 410;
	public final int addnoteCommonValidationDetails = 415;
	public final int deleteNoteFromActivityTable = 416;
	public final int editNoteFromDetails = 417;
	public final int addEventInDetails = 420;
	public final int eventtabsOutvaldiationDetails = 425;
	public final int eventCommonvalidationDetails = 430;
	public final int verifyEventInDetails = 435;
	public final int eventtabsOutvalidationInDetails = 440;
	public final int eventCommonvalidationInDetails = 445;
	public final int editEventFromDetails = 446;
	public final int deleteEventFromActivityTable = 447;
	public final int addAttachmentInDetails = 450;
	public final int addAttchemntvalidation = 455;
	public final int addtaskInDetails = 466;
	public final int verifytaskInDetails = 470;
	public final int deletetaskFromActivityTable = 471;
	public final int editTaskFromDetails = 472;
	public final int inlinedEditDetailsPage = 480;
    public final int checkHeaderAfterInlineEdit = 485;
    public final int editFromDetailsPage = 490;
    public final int deleteLeadFromDetailsPage = 495;
    public final int deleteLeadInListingPage = 500;

	public boolean statusOfActionPopup;
	
	@BeforeMethod
	void thinkTime() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(3000);
		 try {
			 if (statusOfActionPopup==true){
				 util.waitForElementAndClick(driver.findElement(lead.CancelOptionActionPopup));
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
		
		
	}
	
	//@Test(priority=1)
	void testMethod() throws InterruptedException, IOException, ParseException{
		util.login();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(contactlist.Conatctmenu));
		util.recordSelection("100 rows");
		editCustomViewContacts();
		 //util.waitForElementAndClick(driver.findElement(lead.AllSelect));
	
		
	}
	
	
	
	
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 * @throws ParseException
 */
	@Test(priority=addContacts)
	public void addContacts() throws InterruptedException, IOException, ParseException {
		util.login();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(contactlist.Conatctmenu));
		driver.navigate().refresh();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		Thread.sleep(3000);
		contactentry.contactsCreate(2, 1);
		statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		util.waitForElementAndClick(driver.findElement(contactentry.Save));
		String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		Assert.assertEquals(sucessMessage, contactentry.contactsSucessMessage);
		System.out.println("Add contacts is failed");
	
	}

	/**
	 * leadTable = Lead React table leadName = excel.readFromExcel(1, 1, 1); =
	 * Lead name from Excel sheet windowHandle = Window handler for switching to
	 * New tab softAssert = Assert more than one value leadStatusBeforRefresh =
	 * Verifying the Lead before create switchToNewTab = Switing to new Tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
   public Integer contactPosition;
   @Test(priority=refresh)
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
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		String conatctAfterRefresh = util.loopColumnFindName(excel.readFromExcel(2, 2, 1),
				driver.findElement(lead.LeadTable));
		Thread.sleep(3000);
		contactPosition = util.rowCount;
		System.out.println(contactPosition + "" + "My contacts position");
		Assert.assertEquals(conatctAfterRefresh, excel.readFromExcel(2, 2, 1));
	}

   @Test(priority=latestContactPosition)
	void latestContactPosition(){
		Assert.assertEquals(contactPosition, "1");
	}
	/**
	 * bulk.createLead(0, 3) = Creating lead 0 = sheet number, 3 row number
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 */

	@Test(priority=saveAndNew)
	void saveAndNew() throws InterruptedException, IOException {
		WebElement CreateButton = driver.findElement(contactlist.CreateNew);
		util.waitForElementAndClick(CreateButton);
		contactentry.contactsCreate(2, 3);
		util.waitForElementAndClick(driver.findElement(leadEntry.SaveandNewButton));
		leadtest.statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
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
		verifyContactsInListngPage();
	}

	/**
	 * recordSelection = Selecting 100 from record selction leadname = Verify
	 * lead in listing page, if lead available in listing page, its returns Lead
	 * name, else null util.loopColuumFindName = Loop the React table and get
	 * the lead name excel.readFromExcel(1, 1, 1) = Read from excel sheet
	 * = @param Sheet Number, Row number and Column number
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	@Test(priority=verifyContactsInListngPage)
	void verifyContactsInListngPage() throws IOException, InterruptedException {
		util.recordSelection("100 rows");
		Thread.sleep(3000);
		SoftAssert contactsStatus = new SoftAssert();
		String contactname1 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1),
				driver.findElement(lead.LeadTable));
		String contactname2 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1),
				driver.findElement(lead.LeadTable));
		String contactname3 = util.loopColumnFindName(excel.readFromExcel(2, 3, 1),
				driver.findElement(lead.LeadTable));
		contactsStatus.assertEquals(contactname1, excel.readFromExcel(2, 1, 1));
		contactsStatus.assertEquals(contactname2, excel.readFromExcel(2, 2, 1));
		contactsStatus.assertEquals(contactname3, excel.readFromExcel(2, 3, 1));
		System.out.println("verifyLeadsInListngPagen value in the table are " + contactname1 + "" + contactname2 + ""
				+ contactname3);
		contactsStatus.assertAll();
	}

	/**
	 * Verify Search excel.readFromExcel(1, 1, 1) = Read from excel sheet
	 * = @param Sheet Number, Row number and Column number
	 * waitForElementAndClick = Wait for the element and click once element is
	 * displayed
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority=verifySearchInContact)
	void verifySearchInContact() throws IOException, InterruptedException {
		driver.navigate().refresh();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(2, 2, 1));
		System.out.println("Sendng values to search box");
		Thread.sleep(4000);
		String contactName1 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1),
				driver.findElement(lead.LeadTable));
		System.out.println("verifyLeadsInListngPagen value in the table are " + contactName1);
		String contactName2 = util.loopColumnFindName(excel.readFromExcel(2, 3, 1), driver.findElement(lead.LeadTable));
		System.out.println(contactName2);
		SoftAssert searchCOntact = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(2, 2, 6));
		Thread.sleep(3000);
		driver.navigate().refresh();
		String leadnameByMobile = util.loopColumnFindName(
				excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2), driver.findElement(lead.LeadTable));
		searchCOntact.assertEquals(leadnameByMobile, excel.readFromExcel(2, 2, 1));
		searchCOntact.assertEquals(contactName1, excel.readFromExcel(2, 2, 1));
		searchCOntact.assertNull(contactName2);
		searchCOntact.assertAll();
		
	}

	/**
	 * Creating page view clickOnElementIfNotDispayed = If page view is not
	 * displayed, Click on Custom page view button enableToggle = Enable the
	 * column excel.readFromExcel(1, 1, 1) = Read from excel sheet = @param
	 * Sheet Number, Row number and Column number customPageView1 = Name of the
	 * custom page view
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public String customPageViewContacts;
    /**
     * 
     * @throws InterruptedException
     * call the email validation method from commonfeatures class
     * tabs = keys for tabs out validation 
     */
	
	@Test(priority=tabsOutvalidationInValidaEmailContacts)
	void tabsOutvalidationInValidaEmailContacts () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		Thread.sleep(3000);
		//tabs = keys for tabs out validation 
		common.emailtabsOutvalidation(contactentry.Email, "tabs", contactentry.EmailFieldvalidationContacts);
	}
	/**
	 * 
	 * @throws InterruptedException
	 */
	
	@Test(priority=commonValidationEmailIDContacts)
	void commonValidationEmailIDContacts() throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		Thread.sleep(3000);
		//call the email validation method from commonfeatures class
		//common = keys for tabs out validation 
		common.emailtabsOutvalidation(contactentry.Email,"common",contactentry.EmailFieldvalidationContacts);
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 */

	@Test(priority=firstNamefieldvalidationInContacts)
	void firstNamefieldvalidationInContacts() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		//Call the method from commonfeature call for validation for first name
		common.tabsOutValidationFieldType(lead.firstNameArry,
				contactentry.Firstname,
				contactentry.FirstNameValidation, 
				contactentry.firstNameValidationMessage);
		common.commonValidationFieldType(lead.firstNameArry,
				contactentry.Firstname,
				contactentry.FirstNameValidation, 
				contactentry.firstNameValidationMessage);
		
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=lastNameFieldvaldidationContact)
	void lastNameFieldvaldidationContact() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		//Last name valiadtion
		common.tabsOutValidationFieldType(lead.lastNameArry,
				contactentry.LastName,
				contactentry.LastNamevalidation, 
				contactentry.lastNamevaldiationMessage);
		common.commonValidationFieldType(lead.lastNameArry,
				contactentry.LastName,
				contactentry.LastNamevalidation, 
				contactentry.lastNamevaldiationMessage);
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=designationFieldvalidationContact)
	void designationFieldvalidationContact() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		common.tabsOutValidationFieldType(lead.designationArry,
				contactentry.Designation,
				contactentry.DesignationValidation, 
				contactentry.DesignationValidationMessage);
		common.commonValidationFieldType(lead.designationArry,
				contactentry.Designation,
				contactentry.DesignationValidation, 
				contactentry.DesignationValidationMessage);
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=departmentFiedlvalidationError)
	void departmentFiedlvalidationError() throws InterruptedException, IOException {
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		common.tabsOutValidationFieldType(lead.designationArry,
				contactentry.Department,
				contactentry.DepartmentValidation, 
				contactentry.DepartmentValidationMessage);
		common.commonValidationFieldType(lead.designationArry,
				contactentry.Department,
				contactentry.DepartmentValidation, 
				contactentry.DepartmentValidationMessage);
		
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=officeNumberFieldvalidation)
	void officeNumberFieldvalidation() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		common.tabsOutValidationFieldType(lead.officeNumberArry,
			
				contactentry.OfficeMobile,
				contactentry.OfficeNumberValidation, 
				contactentry.OfficeNumberValidationMessage);
		common.commonValidationFieldType(lead.officeNumberArry,
				contactentry.OfficeMobile,
				contactentry.OfficeNumberValidation, 
				contactentry.OfficeNumberValidationMessage);
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=mobileNumberFieldValdiation)
	void mobileNumberFieldValdiation() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		common.tabsOutValidationFieldType(lead.mobileNumberArry,
				contactentry.MobileNumber,
				contactentry.MobileNumbervalidation, 
				contactentry.mobileNumbervalidationMessage);
		common.commonValidationFieldType(lead.mobileNumberArry,
				contactentry.MobileNumber,
				contactentry.MobileNumbervalidation, 
				contactentry.mobileNumbervalidationMessage);
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=postCodeFieldValidation)
	void postCodeFieldValidation() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		Thread.sleep(3000);
		common.tabsOutValidationFieldType(lead.postalCoceArry,
				contactentry.PostalCode,
				contactentry.PostalCodeValidation, 
				contactentry.postalCodevalidationMessage);
		common.commonValidationFieldType(lead.postalCoceArry,
				contactentry.PostalCode,
				contactentry.PostalCodeValidation, 
				contactentry.postalCodevalidationMessage);
	}
	
	
	@Test(priority=createPageView)
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void createPageView() throws IOException, InterruptedException {
		//Call the create page view mrthod from common class
		common.createPageView(
				//reading the column name from excel sheet
				excel.readFromExcel(3, 5, 2),
				excel.readFromExcel(3, 10, 2),
				excel.readFromExcel(3, 3, 2),
				excel.readFromExcel(3, 14, 2), 
				excel.readFromExcel(3, 15, 2), 
				excel.readFromExcel(3, 7, 2));
	
	}

	/**
	 * Verify create page view after creating, columnSizeInCustomPage =
	 * actualColumnSize = Getting column size after redirecting to new custom
	 * page view allColumnNames = Getting all column header names
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority=verifyCreatedPageViewContacts)
	void verifyCreatedPageViewContacts() throws IOException, InterruptedException {
		driver.navigate().refresh();
		 common.verifyCreatedPageView(
				 excel.readFromExcel(3, 5, 2),
				 excel.readFromExcel(3, 10, 2),
				 excel.readFromExcel(3, 3, 2), 
				 excel.readFromExcel(3, 15, 2));
		 SoftAssert verifyCreatedPageViewContacts = new SoftAssert ();
		 verifyCreatedPageViewContacts.assertEquals(common.firstColumn1, true);
		 verifyCreatedPageViewContacts.assertEquals(common.secondColumn1, true);
		 verifyCreatedPageViewContacts.assertEquals(common.fourthColumn1, true);
		 verifyCreatedPageViewContacts.assertEquals(common.fifthColumn1, true);
		 verifyCreatedPageViewContacts.assertAll ();
	
	}

	// TO DO - Pending from client
	@Test(priority=verifyDefaultViewContacts)
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

	/**
	 * 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * Verify Created page View in Ssaved Page View list 
	 */
	@Test(priority=verifyCustomViewInSavedPageViewsContacts)
	void verifyCustomViewInSavedPageViewsContacts() throws InterruptedException, IOException {
		//Call the method from Commonfeature
		common.verifyCustomViewInSavedPageViews();
	}

	/**
	 * Edit custom view excel.readFromExcel(1, 1, 1) = Read from excel sheet
	 * = @param Sheet Number, Row number and Column number
	 * selectFromDropDownModal("Edit View"); = Click on Edit View from the
	 * dropdown list disableToggle = Disable the column
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(priority=editCustomViewContacts)
	void editCustomViewContacts() throws IOException, InterruptedException {
		common.editCustomView(excel.readFromExcel(3, 0, 1),
				excel.readFromExcel(3, 5, 2), 
				excel.readFromExcel(3, 1, 2));

	}

	/**
	 * allColumnNames = Reading all columns from table header
	 * excel.readFromExcel(1, 1, 1) = Read from excel sheet = @param Sheet
	 * Number, Row number and Column number excel.readFromExcel = Read the data
	 * from excel sheet to disble the column @param Sheet Number, Row number and
	 * Column number
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Test(priority=pageViewAfterEditContacts)
	void pageViewAfterEditContacts() throws IOException, InterruptedException {
		common.pageViewAfterEdit(excel.readFromExcel(3, 5, 2),
				excel.readFromExcel(3, 1, 2),
				excel.readFromExcel(3, 3, 2), 
				excel.readFromExcel(3, 15, 2));
		
		SoftAssert pageViewAfterEditContacts = new SoftAssert ();
		pageViewAfterEditContacts.assertEquals(common.enabledColumnEdit1Page1, true);
		pageViewAfterEditContacts.assertEquals(common.enabledColumnEditPage, true);
		pageViewAfterEditContacts.assertEquals(common.desabledColumn1EditPage, false);
		pageViewAfterEditContacts.assertEquals(common.desabledColumnEditPage, false);
		pageViewAfterEditContacts.assertAll ();

	}

	/**
	 * Verifying page view saved after Edit customPageView = Getting the name
	 * after editing from saved list excel.readFromExcel(1, 1, 1) = Read from
	 * excel sheet = @param Sheet Number, Row number and Column number
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@Test(priority=pageViewInSavedPageAfterEditContacts)
	void pageViewInSavedPageAfterEditContacts() throws IOException, InterruptedException {
		common.pageViewInSavedPageAfterEdit();

	}
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 * Checking Create custom page view validation while entering same name which is already exist 
 */
	@Test(priority=alreadyExistpageViewNameContacts)
	 void alreadyExistpageViewNameContacts() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
		//Entering the page view name which is already exist 
		util.sendValue(driver.findElement(lead.InputBoxSaveCustomView), excel.readFromExcel(3, 0, 1));
		util.waitForElementAndClick(driver.findElement(lead.CreatePageViewOption));
		//Getting already existing validation message 
		String valmessage = util.getValidationMessage(driver.findElement(lead.ValidationMessage));
		//Assertting the messages 
		Assert.assertEquals(valmessage, "Page view already exist");
}
	/**
	 * Delete Page view selectFromDropDownModal = Selecting the customized page
	 * view from saved page view excel.readFromExcel(1, 1, 1) = Read from excel
	 * sheet = @param Sheet Number, Row number and Column number
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=deletePageViewContacts)
	void deletePageViewContacts() throws InterruptedException, IOException {
		 common.deletePageView();
	}

	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	 void verifyDeletdViewInSavedViewsContacts () throws IOException, InterruptedException{
		  common.verifyDeletdViewInSavedViews();
			
		}
		//Validation for create Page
		@Test(priority=validationCreatePageViewContacts)
	 void validationCreatePageViewContacts () throws IOException, InterruptedException{
		 common.validationCreatePageView();
		 SoftAssert validationCreatePageViewContacts = new SoftAssert ();
		 validationCreatePageViewContacts.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
		 validationCreatePageViewContacts.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
		 validationCreatePageViewContacts.assertAll();
	 }
		
		@Test(priority=contactsTabsandCommonValidationOutvalidation)
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
/**
 * 
 * @throws InterruptedException
 * Checking alert message while closing the window after entering the charectrets 
 */
		@Test(priority=verifyAlertwhileClosing)
	void verifyAlertwhileClosing() throws InterruptedException {
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		contactentry.contactsCreate(2, 1);
		util.waitForElementAndClick(driver.findElement(contactentry.Cancel));
		String alertText = util.getAlertMessage();
		util.acceptAlert();
		Assert.assertEquals(alertText, leadEntry.alertMessage);
	}

		/**
		 * 
		 * @throws InterruptedException
		 * Checking the Error status by closing the window with out entering the charactrets 
		 */
		@Test(priority=verifyAlertWithOutEntering)
	void verifyAlertWithOutEntering() throws InterruptedException {
		util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		util.waitForElementAndClick(driver.findElement(contactentry.Cancel));
		boolean alert = util.isAlertPresent();
		Assert.assertFalse(alert);
		
	}
 
		/**
		   * 
		   * @throws InterruptedException
		   */
		@Test(priority=statevalidationWithOutCountry)
			 void statevalidationWithOutCountry() throws InterruptedException{
				 util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
				 util.waitForElementAndClick(driver.findElement(contactentry.State));
				 //Listing the State list, Expected this should be empty
				 List list = util.returnDropDownList(contactentry.State,By.xpath("//div[@role='option']"));
				 Assert.assertTrue(list.isEmpty());
			 }
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 * Add log validation 
		 */
		@Test(priority=addLogValidationsListingContacts)
	void addLogValidationsListingContacts() throws InterruptedException, IOException {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			common.addLogValidationsListing(excel.readFromExcel(2, 2, 1));
		SoftAssert addLogValidationsListingContacts = new SoftAssert();
		addLogValidationsListingContacts.assertEquals(common.tabsOutvalidationMsgforLogs, lead.addLogFieldvaldiationMessage);
		addLogValidationsListingContacts.assertEquals(common.addlogCommonError, leadEntry.CommonValidationMEssage);
		addLogValidationsListingContacts.assertAll();

	}
		/**
		 * 
		 * @throws IOException
		 * @throws InterruptedException
		 * Add Log from listing
		 * Call the method from common method 
		 */
	@Test(priority=addLogcallListing)
	void addLogcallListing() throws IOException, InterruptedException {
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		common.addLogcallListing(excel.readFromExcel(2, 2, 1));
	}
     /**
      * 
      * @throws IOException
      * @throws InterruptedException
      * Check the Error while cancelling the pop up page after entering the characters 
      */
	@Test(priority=addLogErrorWhileClosingLog)
	 void addLogErrorWhileClosing  () throws IOException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 common.addLogErrorWhileClosing(excel.readFromExcel(2, 2, 1));
		
	 }
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=addlogErroWithOutcharLog)
	 void addlogErroWithOutcharLog () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 common.addlogErroWithOutchar(excel.readFromExcel(2, 2, 1));
	
	 }
	
	/**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=logSubjecttabsOutValidation)
	 void logSubjecttabsOutValidation () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
			 Thread.sleep(3000);
			 common.tabsOutValidationFieldType(lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=logSubjectCommonValidation)
	 void logSubjectCommonValidation() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
		 Thread.sleep(3000);
		 common.commonValidationFieldType(
				 lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	 
	
	
	@Test(priority=addNoteListing)
	void addNoteListing() throws InterruptedException, IOException {
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		common.addNoteListing(excel.readFromExcel(2, 2, 1));
	}
	
	
	@Test(priority=addNotevalidationListingContacts)
	void addNotevalidationListingContacts() throws InterruptedException, IOException {
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		common.addNotevalidationListing(excel.readFromExcel(2, 2, 1));
		SoftAssert addNotevalidationListingContacts = new SoftAssert();
		addNotevalidationListingContacts.assertEquals(common.noteSubjectvaldiatinListing, lead.addNoteFieldvaldiationMessage);
		addNotevalidationListingContacts.assertEquals(common.addnoteCommonError, leadEntry.CommonValidationMEssage);
		addNotevalidationListingContacts.assertAll();
	}

	@Test(priority=addNoteErrorWhileClosing)
	void addNoteErrorWhileClosingNote  () throws IOException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		  common.addNoteErrorWhileClosing(excel.readFromExcel(2, 2, 1));
		 
		 }
	@Test(priority=addNoteErroWithOutchar)
		 void addNoteErroWithOutchar () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
             common.addNoteErroWithOutchar(excel.readFromExcel(2, 2, 1));; 
		 }
	
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 
	@Test(priority=noteSubjecttabsOutValidation)
	 void noteSubjecttabsOutValidation () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			Thread.sleep(3000);
			 common.tabsOutValidationFieldType(lead.logSubjectArry,lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 
	@Test(priority=noteSubjectCommonValidation)
	 void noteSubjectCommonValidation() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			 common.commonValidationFieldType(lead.logSubjectArry,lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	EventEntry evententry = new EventEntry();

	@Test(priority=addEvent)
	void addEvent() throws InterruptedException, IOException {
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		common.addEvent(excel.readFromExcel(2, 2, 1));
	}

	/**
	 * Tabs out valdiation error for Event addEventValidationError : Assert all
	 * values
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=tabsOutvalidationEventContacts)
	void tabsOutvalidationEventContacts() throws InterruptedException, IOException {
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		common.tabsOutvalidationEvent(excel.readFromExcel(2, 2, 1));
		SoftAssert tabsOutvalidationEventContacts = new SoftAssert ();
		tabsOutvalidationEventContacts.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
		tabsOutvalidationEventContacts.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
		tabsOutvalidationEventContacts.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
		tabsOutvalidationEventContacts.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
		tabsOutvalidationEventContacts.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
		tabsOutvalidationEventContacts.assertAll();

	}
	
	@Test(priority=commonvalidationEventContacts)

	void commonvalidationEventContacts () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		common.commonvalidationEvent(excel.readFromExcel(2, 2, 1));
		SoftAssert commonvalidationEventContacts = new SoftAssert ();
		commonvalidationEventContacts.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
		commonvalidationEventContacts.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
		commonvalidationEventContacts.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
		commonvalidationEventContacts.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
		commonvalidationEventContacts.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
		commonvalidationEventContacts.assertAll();
	}
	
	
	 /**
	  * Call the commonValidationFieldType  methos and pass Anonymous array
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=EventSubjecttabsOutValidation)
	 void EventSubjecttabsOutValidation () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			 common.tabsOutValidationFieldType(lead.eventSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
	 }
	
	@Test(priority=EventSubjectCommonValidation)
	 void EventSubjectCommonValidation() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			common.commonValidationFieldType(lead.eventSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
	 }
	 
	 
	 /**
	  * Call the tabsOutValidationFieldType  methos and pass Anonymous array
	  * @throws InterruptedException
	  * @throws IOException
	  */

	@Test(priority=EventLocationtabsOutValidation)
	 void EventLocationtabsOutValidation () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2,2, 1), driver.findElement(lead.LeadTable), "More Action");
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
	@Test(priority=EventLocationCommonValidation)
	 void EventLocationCommonValidation() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.clickOnActions(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			//create anonymous array to pass the one time value
			common.commonValidationFieldType(lead.eventLocationArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
	 } 
	 
	 
	@Test(priority=addAttachement)
	void addAttachement() throws InterruptedException, IOException {
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 common.addAttachement(excel.readFromExcel(2, 2, 1), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
	}

	@Test(priority=discardInlineEdit)
	void discardInlineEdit() throws InterruptedException, IOException{
		common.discardInlineEditChanges("Address", excel.readFromExcel(2, 2, 1), contactentry.Address);
	}
	
	
	
	
	
	
	@Test(priority=inlineEditInLeadTable)
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void inlineEditInLeadTable() throws IOException, InterruptedException {
		Thread.sleep(3000);
		try {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
			util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
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
			String companyNameAfterEdit = util.getColumndata("Account Name", excel.readFromExcel(2, 2, 1));
			Thread.sleep(3000);
			inlineEditInLeadTable.assertNotEquals(companyName, companyNameAfterEdit);
		} catch (Exception E) {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();

		}
		try {
			String departMennt = util.getColumndata("Department", excel.readFromExcel(2, 2, 1));
			String designationEdit = departMennt + " " + "Edited";
			util.inlineEditInTable("Department", excel.readFromExcel(2, 2, 1));
			util.sendValue(driver.findElement(contactentry.Department), designationEdit);
			util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			Thread.sleep(4000);
			String designationAfterEdit = util.getColumndata("Department", excel.readFromExcel(2, 2, 1));
			inlineEditInLeadTable.assertNotEquals(departMennt, designationAfterEdit);
		} catch (Exception e) {

			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();

		}
		try {
			String decisionAuthority = util.getColumndata("Decision Authority", excel.readFromExcel(2, 2, 1));
			util.inlineEditInTable("Decision Authority", excel.readFromExcel(2, 2, 1));
			util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
			util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			Thread.sleep(3000);
			String leadStatusAfterChange = util.getColumndata("Decision Authority", excel.readFromExcel(2, 2, 1));
			inlineEditInLeadTable.assertNotEquals(decisionAuthority, leadStatusAfterChange);
		} catch (Exception e) {

			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();

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
			util.acceptUnExpectedError();

		}
		try {
			String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(2, 2, 1));
			util.inlineEditInTable("Assigned To", excel.readFromExcel(2, 2, 1));
			//util.handleDropDownByIndex(driver.findElement(contactentry.AssignTo), 3);
			util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
			util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			Thread.sleep(3000);
			String AssignToAfterEdit = util.getColumndata("Assigned To", excel.readFromExcel(2, 2, 1));
			inlineEditInLeadTable.assertNotEquals(AssignTo, AssignToAfterEdit);
		} catch (Exception e) {

			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.acceptUnExpectedError();

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
			util.acceptUnExpectedError();

		}
		util.acceptUnExpectedError();
		inlineEditInLeadTable.assertAll();
	}
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=emailInlineEditTabsOutalidationContacts)
	 void emailInlineEditTabsOutalidationContacts() throws InterruptedException, IOException{
		 Thread.sleep(3000);
		 common.inlineEmailIdValidation("Email", excel.readFromExcel(2, 2, 1),contactentry.Email, "tabs",contactentry.EmailFieldvalidationContacts);
	 }
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=emailInlneEditCommonValidationContacts)
	 void emailInlneEditCommonValidationContacts() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(3000);
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 common.inlineEmailIdValidation("Email", excel.readFromExcel(2, 2, 1), contactentry.Email, "common",contactentry.EmailFieldvalidationContacts);
	 }
	
	 /**
	  * Tabs out validation for inline Edit for Mobile Number
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=inlineTabsNumericalNumbervalidation)
	 void inlineTabsNumericalNumbervalidation() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(5000);
		 common.inlineEditTabsOutValidation("Mobile Number", 
				 excel.readFromExcel(2, 2, 1), new String [] {"alphebeitcal","@#$%^&*()","99225alpheNumeric"}, 
				 contactentry.MobileNumber, 
				 contactentry.MobileNumbervalidation, contactentry.mobileNumbervalidationMessage);
	 }
	 
	 
	 /**
	  * Common validation for inline edit for mobile number
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=inlineCommonNumericalNumbervaldation)
	 void inlineCommonNumericalNumbervaldation() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(5000);
		 common.inlineEditCommonValdiation("Mobile Number", 
				 excel.readFromExcel(2, 2, 1), new String [] {"alphebeitcal","@#$%^&*-=+()","99225alpheNumeric"}, 
				 contactentry.MobileNumber, 
				 contactentry.MobileNumbervalidation, contactentry.mobileNumbervalidationMessage);
	 }
	 
	 /**
	  * Inline edit tabs out validation for aplenumeric 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=inlineCommonalphanumericalvaldation)
	 void inlineEditTabsOutValidationForAlphenumeric() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(5000);
		 common.inlineEditTabsOutValidation("Designation", 
				 excel.readFromExcel(2, 2, 1), new String [] {"@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
				 contactentry.Designation, 
				 contactentry.DesignationValidation, contactentry.DesignationValidationMessage);
	 }
	 
	 
	 /**
	  * Inline edit common validation for aplenumeric 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=inlineEditCommovalidationForAlphanumeric)
	 void inlineEditCommovalidationForAlphanumeric() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(5000);
		 common.inlineEditCommonValdiation("Designation", 
				 excel.readFromExcel(2, 2, 1), new String [] {"@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
				 contactentry.Designation, 
				 contactentry.DesignationValidation, contactentry.DesignationValidationMessage);
	 }
	 
	 /**
	  *  Inline edit tabs out  validation for Text Field
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=inlineEditTabOutTextFieldvalidation)
	 void inlineEditTabOutTextFieldvalidation() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(5000);
		 common.inlineEditTabsOutValidation("Department", 
				 excel.readFromExcel(2, 2, 1), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
				 contactentry.Department, 
				 contactentry.DepartmentValidation, contactentry.DepartmentValidationMessage);
	 }
	 
	 /**
	  * Inline edit common validation for Text Field
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=inlineEditCommonTextieldValidation)
	 void inlineEditCommonTextieldValidation() throws InterruptedException, IOException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		 util.acceptUnExpectedError();
		 Thread.sleep(5000);
		 common.inlineEditCommonValdiation("Department", 
				 excel.readFromExcel(2, 2, 1), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
				 contactentry.Department, 
				 contactentry.DepartmentValidation, contactentry.DepartmentValidationMessage);
	 }
 
	 
/**
 * 
 * @throws IOException
 * @throws InterruptedException
 */
	@Test(priority=verifyFilter)
	  void verifyFilter () throws IOException, InterruptedException{
		 util.acceptUnExpectedError();
		  Thread.sleep(4000);
		  SoftAssert verifyFilterContacts = new SoftAssert ();
		 
			util.waitForElementAndClick(driver.findElement(lead.FilterOption));
			Thread.sleep(3000);
			
			  util.handleDropdown(driver.findElement(lead.FilterFieldBy1),"First Name");
			
			//Filter By Contact name
			Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,1));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  Thread.sleep(3000);
			  String leadname11 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
			  String leadname12 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname11);
			  verifyFilterContacts.assertNull(leadname12);
		
			  //Filter By Account name
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
			 util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Account Name");
				
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,3));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  String leadname13 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname13);
			  String leadname14 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname14);
		
		    //Filter By Decision Authority
			  Thread.sleep(3000);
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
			
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Decision Authority");
				
				Thread.sleep(3000);
				util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Decision Authority");
				Thread.sleep(3000);
				  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
				  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(2,1,14));
				  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
				  String leadname1 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
				  String leadname2 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
				  verifyFilterContacts.assertNotNull(leadname1);
				  verifyFilterContacts.assertNull(leadname2);
		
				  //Filter By Assigned To
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
              util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Assigned To");
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(2,1,16));
			  Thread.sleep(2000);
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  Thread.sleep(3000);
			  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname3);
			  String leadname4 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname4);
	         //Filter By designation
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Designation");
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,4));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  String leadname5 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname5);
			  String leadname6 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname6);

		//Filter By email
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Email");
				
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,7));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  String leadname7 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname7);
			  String leadname8 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname8);
	
			  //Filter by mobile number
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
			
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Mobile Number");
				
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,6));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  String leadname9 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname9);
			  String leadname10 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname10);
	
	
			  //Filter bY country
			  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
		
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Country");
				
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0,1,10));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  String leadname15 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname15);
			  String leadname16 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1), driver.findElement(lead.LeadTable));
			  verifyFilterContacts.assertNotNull(leadname16);
	

		  //AND and OR Condiion 
		  
	
					util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");
				
				Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,1));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
			  util.waitForElementAndClick(driver.findElement(lead.FilterAddNewFilter));
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
			  util.handleDropdown(driver.findElement(lead.FilterFieldBy2), "First Name");
			  Thread.sleep(3000);
			  util.handleDropdown(driver.findElement(lead.FilterOperator2), "Equal to");
			  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox2), excel.readFromExcel(2,1,2));
			  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
				  String leadname17 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
				  String leadname18 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
				  verifyFilterContacts.assertNotNull(leadname17);
				  verifyFilterContacts.assertNotNull(leadname18);
				  Thread.sleep(3000);
				  util.waitForElementAndClick(driver.findElement(lead.FilterEdit2));
				  Thread.sleep(3000);
				  util.handleDropdown(driver.findElement(lead.FilterANDOR), "AND");
				  Thread.sleep(3000);
				  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
				  String leadname19 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1), driver.findElement(lead.LeadTable));
				  String leadname20 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1), driver.findElement(lead.LeadTable));
				  verifyFilterContacts.assertNull(leadname19);
				  verifyFilterContacts.assertNull(leadname20);
		
		  util.waitForElementAndClick(driver.findElement(lead.FilterOption));
		  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		  driver.navigate().refresh();
		  verifyFilterContacts.assertAll();
		  
	  }

	
	
	@Test (priority =checkFilterByValues) 
	 void checkFilterByValues() throws InterruptedException{
		
		 common.checkFilterByValues(customValue);
	 }
	
	 /**
	 * @throws InterruptedException 
	  * 
	  */
	 void firstNameOperators () throws InterruptedException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.waitForElementAndClick(driver.findElement(lead.FilterOption));
		common.operatorListvalidation(lead.FilterFieldBy1,
				lead.FilterOperator1,
				"First Name", 
				"Not equal to,Is empty,Contains,Does not contain,Starts with,Is not empty,Equal to");
	 }
	 
	 /**
	  * 
	  * @throws InterruptedException
	  */
	 void leadConvertedOperators () throws InterruptedException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.waitForElementAndClick(driver.findElement(lead.FilterOption));
			common.operatorListvalidation(lead.FilterFieldBy1,
					lead.FilterOperator1,
					"Lead Converted", 
					"Not equal to,Equal to");
		 }
		
	 /**
	  * 
	  * @throws InterruptedException
	  */
	 void leadCreatedOperators () throws InterruptedException{
		 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			util.waitForElementAndClick(driver.findElement(lead.FilterOption));
			common.operatorListvalidation(lead.FilterFieldBy1,
					lead.FilterOperator1,
					"Lead Created", 
					"Not equal to,Equal to,Less than,Greater than,Less or equal,Greater or equal, Is empty,Is not empty");
		 }
		
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
  
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=changeOwnerforAll)
	  void changeOwnerforAll () throws InterruptedException, IOException{
		  SoftAssert changeOwnerforAllLeadsContacts = new SoftAssert ();
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
			changeOwnerforAllLeadsContacts.assertEquals(changeOwnerSucesMessage, lead.changeOwnerSucessMessage);
			String AssignedTo1 = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
			String AssignedTo2 = util.getColumndata("Assigned To", excel.readFromExcel(0, 2, 1));
			String AssignedTo13 = util.getColumndata("Assigned To", excel.readFromExcel(0, 3, 1));
			changeOwnerforAllLeadsContacts.assertEquals(AssignedTo1, lead.changeOwnerTo);
			changeOwnerforAllLeadsContacts.assertEquals(AssignedTo2, lead.changeOwnerTo);
			changeOwnerforAllLeadsContacts.assertEquals(AssignedTo13, lead.changeOwnerTo);
			changeOwnerforAllLeadsContacts.assertAll();
		  
	  }
	  
	/*@Test(priority=addTaskInContacts)
	  void addTaskInContacts() throws InterruptedException, IOException{
		  common.addtask(excel.readFromExcel(2, 2, 1));
	  }*/
	 
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=changeAssignee)
	  void changeAssignee () throws InterruptedException, IOException{
		  common.changeOwner(excel.readFromExcel(2, 2, 1), "Change Assignee");
	  }
	 
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=addNoteForAll)
	void addNoteForAll () throws InterruptedException, IOException{
		Thread.sleep(3000);
		 common.addNoteForAll(contactlist.AddNoteAllSelect);
	  }
	
	/**
	 * Redirecting to details page
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	@Test(priority=verifyRedirectionToDetailsPage)
	void verifyRedirectionToDetailsPage () throws IOException, InterruptedException{
		driver.navigate().refresh();
		 common.verifyRedirctionToDetilspage(excel.readFromExcel(2, 2, 1));
	}
	
	 /**
	  * 
	  * @throws IOException
	  * excel.readFromExcel(0, 1, 3) - reading the details from Excel sheet
	  */
	@Test(priority=verifyHeaderForDetails)
	 void verifyHeaderForDetails () throws IOException{
			 SoftAssert verifyHeaderForDetails = new SoftAssert ();
			 String leadNameInDeatis = util.getElementName(driver.findElement(contactdetails.ContactNameDetailsHeader));
			 String companyNameDetails = util.getElementName(driver.findElement(contactdetails.AccountNameDetailsHeader));
			 String DesignationInDetail = util.getElementName(driver.findElement(contactdetails.DesignationDetailsHeader));
			 String mobileNumberInDeatsils = util.getElementName(driver.findElement(contactdetails.MobileNumberDetailsHeader));
			 String email = util.getElementName(driver.findElement(contactdetails.EmailInfoHeader));
			 verifyHeaderForDetails.assertEquals(leadNameInDeatis, excel.readFromExcel(0, 1, 1)+" "+excel.readFromExcel(0, 1, 2));
			 verifyHeaderForDetails.assertEquals(companyNameDetails, excel.readFromExcel(0, 1, 3));
			 verifyHeaderForDetails.assertEquals(DesignationInDetail, excel.readFromExcel(0, 1, 4));
			 verifyHeaderForDetails.assertEquals(mobileNumberInDeatsils, excel.readFromExcel(0, 1, 6));
			 verifyHeaderForDetails.assertEquals(email, excel.readFromExcel(0, 1, 7));
			 verifyHeaderForDetails.assertAll(); 
	 }
	
	 /**
	   * 
	   * @throws IOException
	   * @throws InterruptedException
	   */
	@Test(priority=addLogcallDetails)
	  void addLogcallDetails() throws IOException, InterruptedException{
		  common.addLogcallDetails();
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall),
				  excel.readFromExcel(4, 2, 0), 
				  driver.findElement(lead.LeadTable));
		  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall),
				  excel.readFromExcel(4, 2, 1), 
				  driver.findElement(lead.LeadTable));
		
	  }
	  
	  /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  * Checking Add log validation In details Page 
		  */
	@Test(priority=addLogValidationsDetails)
		 void addLogValidationsDetails () throws InterruptedException, IOException{
			leadtest.addLogValidationsDetails();	
			}
	 
		 /**
		  * 
		  * @throws IOException
		  * Calling method from l log call 
		  */
	@Test(priority=verifyLogcallInDetailsPage)
		 void verifyLogcallInDetailsPage() throws IOException{
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall), 
				 excel.readFromExcel(4,1,0), 
				 driver.findElement(lead.LeadTable));
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.LogCall), 
				 excel.readFromExcel(4,2,0), 
				 driver.findElement(lead.LeadTable));
		 }
		  
		 //Calling the method from lead test
	@Test(priority=logSubjectTabOutValidationDetails)
		 void logSubjectTabOutValidationDetails() throws InterruptedException, IOException{
			 leadtest.logSubjectTabOutValidationDetails();
		 }
		//Calling the method from lead test
	@Test(priority=logSubjectCommonvalidationDetails)
		 void logSubjectCommonvalidationDetails() throws InterruptedException, IOException{
			 leadtest.logSubjectCommonvalidationDetails();
		 }
	
	/**
	 * Delete log Call entry from details page 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=deleteLogCallFromActivityTable)
	void deleteLogCallFromActivityTable() throws InterruptedException, IOException{
		common.deleteFromActiityTable(driver.findElement(leadDetails.LogCall), 
				//Delete Log call which added from detail page
				excel.readFromExcel(4, 2, 0));
	}
	
	
	
	
	
	
	
	
		//Calling the method from lead test 
	@Test(priority=addNoteInDetails)
		 void addNoteInDetails () throws InterruptedException, IOException{
				leadtest.addNoteInDetails();
				common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
						excel.readFromExcel(5, 2, 0), 
						driver.findElement(lead.LeadTable));
				common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
						excel.readFromExcel(5, 2, 1), 
						driver.findElement(lead.LeadTable));
			}
		 
		//Calling the method from lead test
	@Test(priority=addNotevalidationInDetails)
			void addNotevalidationInDetails () throws InterruptedException, IOException{
				leadtest.addNotevalidationDetails();
			}
			
			//Calling the method from lead test
	@Test(priority=verifyNoteIndetails)
			void verifyNoteIndetails() throws IOException{
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
				 excel.readFromExcel(5,1,0), 
				 driver.findElement(lead.LeadTable));
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.MakeNote), 
				 excel.readFromExcel(5,2,0), 
				 driver.findElement(lead.LeadTable));
			}
			
			//Calling the method from lead test
	@Test(priority=addnotetabsOutvalidationInDetail)
			void addnotetabsOutvalidationInDetail() throws InterruptedException, IOException{
				leadtest.logSubjectTabOutValidationDetails();
			}
			//Calling the method from lead test
	@Test(priority=addnoteCommonValidationDetails)
			void addnoteCommonValidationDetails() throws InterruptedException, IOException{
				leadtest.logSubjectCommonvalidationDetails();
			}
	
	
	/**
	 * Delete note entry from details page 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=deleteNoteFromActivityTable)
	void deleteNoteFromActivityTable() throws InterruptedException, IOException{
		common.deleteFromActiityTable(driver.findElement(leadDetails.MakeNote), 
				//Delete Note which added from detail page
				excel.readFromExcel(5, 2, 0));
	}
	
	
	
	
	
			//Calling the method from lead test
	@Test(priority=addEventInDetails)
			void addEventInDetails () throws InterruptedException, IOException{
				leadtest.addEventInDeatilspage();
			}
			
			//Calling the method from lead test
	@Test(priority=eventtabsOutvaldiationDetails)
			void eventtabsOutvaldiationDetails() throws InterruptedException, IOException{
				leadtest.tabsOutvalidationEventInDetails();
			}
			
			//Calling the method from lead test
	@Test(priority=eventCommonvalidationDetails)
			void eventCommonvalidationDetails () throws InterruptedException, IOException{
				leadtest.commonvalidationEventDetails();
			}
			
			//Calling the method from lead test
	@Test(priority=verifyEventInDetails)
			void verifyEventInDetails() throws IOException{
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
				 excel.readFromExcel(6,1,0), 
				 driver.findElement(lead.LeadTable));
	  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
				 excel.readFromExcel(6,2,0), 
				 driver.findElement(lead.LeadTable));
			}
			//Calling the method from lead test
	@Test(priority=eventtabsOutvalidationInDetails)
			void eventtabsOutvalidationInDetails() throws InterruptedException, IOException{
				leadtest.eventtabsOutValdiationDetails();
			}
			//Calling the method from lead test
	@Test(priority=eventCommonvalidationInDetails)
			void eventCommonvalidationInDetails() throws InterruptedException, IOException{
				leadtest.commonvalidationEventInDetails();
			}
	
	/**
	 * Delete Event entry from details page
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=deleteEventFromActivityTable)
	void deleteEventFromActivityTable() throws InterruptedException, IOException{
		//Delete Event which added from detail page
		common.deleteFromActiityTable(driver.findElement(leadDetails.NewEvent), 
				excel.readFromExcel(6, 2, 0));
	}
	
	
	
			//Calling the method from lead test
	@Test(priority=addAttachmentInDetails)
			void addAttachmentInDetails () throws InterruptedException, IOException{
				leadtest.addAttachementInDetails();
			}
			
			//Calling the method from lead test
	@Test(priority=addAttchemntvalidation)
			void addAttchemntvalidation() throws InterruptedException, IOException{
				leadtest.attachmentCommonvalidationInDetails();
			}

			//Calling the method from lead test
	@Test(priority=addtaskInDetails)
			void addtaskInDetails() throws InterruptedException{
				leadtest.addtaskInDetails();
			}
			
			//Calling the method from lead test
	@Test(priority=verifytaskInDetails)
			void verifytaskInDetails() throws IOException{
		 common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
				 excel.readFromExcel(7,1,0), 
				 driver.findElement(lead.LeadTable));
	  common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent), 
				 excel.readFromExcel(7,2,0), 
				 driver.findElement(lead.LeadTable));
			}
	
	/**
	 * Delete Task entry from details page
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=deletetaskFromActivityTable)
	void deletetaskFromActivityTable() throws InterruptedException, IOException{
		//Delete Task which added from detail page
		common.deleteFromActiityTable(driver.findElement(leadDetails.NewTask), 
				excel.readFromExcel(7, 2, 0));
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
	
	@Test(priority=inlinedEditDetailsPage)
	 void inlinedEditDetailsPage() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(contactlist.Conatctmenu));
		 util.waitForElementAndClick(driver.findElement(contactlist.CreateNew));
		 //Creating 7 th Lead
		 contactentry.contactsCreate(2, 7);
		 util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		//Creating to 8 th User //hence 7 the user details updated with 8 th users details
		 String [] valueBeforeEdit = common.getAttribute(excel.readFromExcel(2, 7, 1),
				 contactentry.Accountname, 
				 contactentry.AssignTo, 
				 contactentry.Email, 
				 contactentry.Department, 
				 contactentry.OfficeMobile, 
				 contactentry.Designation, 
				 contactentry.Country);
			Thread.sleep(3000);
			util.recordSelection("100");
			//Redirecting to 7 the User Details page 
		 util.clickOnActions(excel.readFromExcel(2, 7, 1),
				 driver.findElement(lead.LeadTable),
				 "Redirection");
		 //Click On Edit button and Changing to 8 users
		 util.inlineEditInInformationSection(driver.findElement(contactdetails.InformationSection));
		 //Creating to 8 th User
		 contactentry.contactsCreate(2, 8);
		 util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		 util.waitForElementAndClick(driver.findElement(contactlist.Conatctmenu));
		 util.recordSelection("100");
		 //Getting 8 user Details 
		 String [] valueAfterEdit = common.getAttribute(excel.readFromExcel(2, 8, 1),
				 contactentry.Accountname, 
				 contactentry.AssignTo, 
				 contactentry.Email, 
				 contactentry.Department, 
				 contactentry.OfficeMobile, 
				 contactentry.Designation, 
				 contactentry.Country);
			Thread.sleep(3000);
			common.compareArrays(valueBeforeEdit, valueAfterEdit);
		
	 }
	 
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  * Changing to 8 the 7 users details 
	  */
	@Test(priority=checkHeaderAfterInlineEdit)
	public void checkHeaderAfterInlineEdit() throws InterruptedException, IOException{
		SoftAssert checkHeaderAfterInlineEdit = new SoftAssert();
		util.recordSelection("100");
		 util.clickOnActions(excel.readFromExcel(2, 8, 1),
				 driver.findElement(lead.LeadTable),
				 "Redirection");
		 util.inlineEditInInformationSection(driver.findElement(contactdetails.InformationSection));
		 contactentry.contactsCreate(2, 7);
		 util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
		 String contactName = util.getElementName(driver.findElement(contactdetails.ContactNameDetailsHeader));
		 String ComplanyName =util.getElementName(driver.findElement(contactdetails.AccountNameDetailsHeader)); 
         String Designation = util.getElementName(driver.findElement(contactdetails.DesignationDetailsHeader));
         String emailId = util.getElementName(driver.findElement(contactdetails.EmailInfoHeader));
         checkHeaderAfterInlineEdit.assertEquals(contactName, excel.readFromExcel(2, 7, 1)+""+excel.readFromExcel(2, 7, 2));
         checkHeaderAfterInlineEdit.assertEquals(ComplanyName, excel.readFromExcel(2, 7, 3));
         checkHeaderAfterInlineEdit.assertEquals(Designation,excel.readFromExcel(2, 7, 4));
         checkHeaderAfterInlineEdit.assertEquals(emailId, excel.readFromExcel(2, 7, 7));
         checkHeaderAfterInlineEdit.assertAll();	 
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * Editing the User 7 to 8, its Edting he lead using the Edit Button
	 */
	@Test(priority=editFromDetailsPage)
	public void editFromDetailsPage() throws InterruptedException, IOException{
		SoftAssert editFromDetailsPage = new SoftAssert();
		util.waitForElementAndClick(driver.findElement(contactdetails.EditButtonInDetailsPage));
		contactentry.contactsCreate(2, 8);
		util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
		String contactName = util.getElementName(driver.findElement(contactdetails.ContactNameDetailsHeader));
		 String ComplanyName =util.getElementName(driver.findElement(contactdetails.AccountNameDetailsHeader)); 
        String Designation = util.getElementName(driver.findElement(contactdetails.DesignationDetailsHeader));
        String emailId = util.getElementName(driver.findElement(contactdetails.EmailInfoHeader));
        editFromDetailsPage.assertEquals(contactName, excel.readFromExcel(2, 8, 1)+""+excel.readFromExcel(2, 8, 2));
        editFromDetailsPage.assertEquals(ComplanyName, excel.readFromExcel(2, 8, 3));
        editFromDetailsPage.assertEquals(Designation,excel.readFromExcel(2, 8, 4));
        editFromDetailsPage.assertEquals(emailId, excel.readFromExcel(2, 8, 7));
        editFromDetailsPage.assertAll();	 
	}
	/**
	 * @throws InterruptedException 
	 * 
	 */
	@Test(priority=deleteLeadFromDetailsPage)
	public void deleteLeadFromDetailsPage () throws InterruptedException{
		SoftAssert deleteFromDetails = new SoftAssert();
		String currenturl = driver.getCurrentUrl();
		util.waitForElementAndClick(driver.findElement(contactdetails.DeteteOption));
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
	@Test(priority=deleteLeadInListingPage)
	public void deleteLeadInListingPage () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(contactlist.Conatctmenu));
		util.recordSelection("100");
		String userName = util.loopColumnFindName(excel.readFromExcel(0, 8, 1), driver.findElement(lead.LeadTable));
		Assert.assertNull(userName);
	}
	
	/**
	 * Edit Log Call from details page and Verify Log call after Edit
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=editLogCallFrometails)
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
	@Test(priority=editNoteFromDetails)
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
	@Test(priority=editEventFromDetails)
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
	
	TaskEntry taskentry = new TaskEntry();
	@Test(priority=editTaskFromDetails)
	void editTaskFromDetails() throws InterruptedException, IOException{
		common.editFromActivitytable(driver.findElement(leadDetails.LogCall), 
				excel.readFromExcel(7, 1, 0), 
				taskentry.Subject, 
				taskentry.Details);
	}
	
	
	
	
}
