package Testcases;

import java.io.IOException;
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
import Pages.AccountsDetails;
import Pages.AccountsEntry;
import Pages.AccountsListing;
import Pages.EventEntry;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.PCUtility;
import Pages.TaskEntry;
@Listeners(ListenersClass.class)
public class AccountsTest extends DriverClass{
	PCUtility util = new PCUtility ();
	LeadListing lead = new LeadListing();
	ExcelReader excel = new ExcelReader ();
	LeadEntry leadEntry = new LeadEntry();
	LeadDetails leadDetails = new LeadDetails ();
	LeadTest leadtest = new LeadTest ();
	CommonFeature common = new CommonFeature();
	AccountsEntry accountentry = new AccountsEntry();
	AccountsListing accountlist = new AccountsListing();
	AccountsDetails accountdetails = new AccountsDetails();
	
	String [] customValue = {"Accounts Created By","Account Created"};
	public final int addAccounts = 10;
	public final int refresh = 20;
	public final int latestAccountPosition = 30;
	public final int saveAndNew = 40;
	public final int verifyAccountsInListngPage = 50;
	public final int verifySearchInAccount = 60;
	public final int createPageView = 70;
	public final int verifyCreatedPageViewAccounts = 80;
	public final int verifyDefaultViewAccounts = 90;
	public final int verifyCustomViewInSavedPageViewsAccounts = 100;
	public final int editCustomViewAccounts = 110;
	public final int pageViewAfterEditAccounts = 120;
	public final int alreadyExistpageViewNameAccounts = 130;
	public final int pageViewInSavedPageAfterEditAccounts = 140;
	public final int deletePageViewAccounts = 140;
	public final int verifyDeletdViewInSavedViewsAccounts = 140;
	public final int tabsOutvalidationInValidaEmailAccounts    = 141;
	public final int commonValidationEmailIDAccounts   = 142;
	public final int acccountNameFieldvaldidationAccount  = 144;
	public final int designationFieldvalidationAccount   = 145;
	
	public final int officeNumberFieldvalidation    = 147;
	public final int mobileNumberFieldValdiation   = 148;
	public final int postCodeFieldValidation   = 149;
	public final int validationCreatePageViewAccounts = 150;
	public final int accountManditiryTabsoutvalidation = 152;
	public final int accountManditoryCommonValidation = 153;
	
	public final int AccountsTabsandCommonValidationOutvalidation = 160;
	public final int webSiteTabsvaldiationError = 160;
	public final int webSiteCommonvaldiationError = 160;

	public final int verifyAlertwhileClosing = 170;
	public final int verifyAlertWithOutEntering = 180;
	public final int statevalidationWithOutCountry = 181;
	public final int addLogcallListing = 190;
	public final int addLogValidationsListingAccounts =200;
	public final int addLogErrorWhileClosingLog = 210;
	public final int addlogErroWithOutcharLog =220;
	public final int logSubjecttabsOutValidation =221;
	public final int logSubjectCommonValidation =222;
	public final int addNoteListing = 230;
	public final int addNotevalidationListingAccounts = 240;
	public final int addNoteErrorWhileClosing = 250;
	public final int addNoteErroWithOutchar =260;
	public final int noteSubjecttabsOutValidation = 261;
	public final int noteSubjectCommonValidation = 262;
	public final int addEvent = 270;
	public final int tabsOutvalidationEventAccounts = 280;
	public final int  commonvalidationEventAccounts =290;
	public final int  EventSubjecttabsOutValidation =291;
	public final int  EventSubjectCommonValidation =292;
	public final int  EventLocationtabsOutValidation =293;
	public final int  EventLocationCommonValidation =294;
	public final int addAttachement = 300;
	public final int addTaskInAccounts = 310;
	public final int addNoteForAll = 330;
	public final int changeOwnerforAllLeads = 340;
	public final int discardInlineEdit = 341;
	public final int inlineEditInTable = 350;
	public final int webSiteInlinetabsOutValidationError = 351;
	public final int webSiteInlineEditCommonvalidationError = 352;
	
	public final int emailInlineEditTabsOutalidationAccounts = 360;
	public final int emailInlneEditCommonValidationAccounts = 370;
	public final int inlineTabsNumericalNumbervalidation	 = 380;
	public final int inlineCommonNumericalNumbervaldation = 390;
	public final int inlineEditTabsvalidationForAlphanumeric = 400;
	public final int inlineEditCommovalidationForAlphanumeric = 410;
	public final int inlineEditTabOutTextFieldvalidation = 420;
	public final int inlineEditCommonTextieldValidation = 430;
	public final int verifyFilter = 431;
	public final int checkFilterByValues = 432;
	public final int verifyRedirectionToDetailsPage= 435;
	public final int verifyHeaderForDetails= 440;
	public final int addLogcallDetails= 450;
	public final int addLogValidationsDetails= 460;
	public final int verifyLogcallInDetailsPage= 470;
	public final int logSubjectTabOutValidationDetails= 480;
	public final int logSubjectCommonvalidationDetails= 490;
	public final int deleteLogCallFromActivityTable	= 491;
	public final int editLogCallFrometails	= 492;
	public final int addNoteInDetails= 500;
	public final int addNotevalidationInDetails= 510;
	public final int verifyNoteIndetails= 520;
	public final int addnotetabsOutvalidationInDetail= 521;
	public final int addnoteCommonValidationDetails= 530;
	public final int deleteNoteFromActivityTable= 531;
	public final int editNoteFromDetails= 532;
	public final int addEventInDetails= 540;
	public final int eventtabsOutvaldiationDetails= 541;
	public final int eventCommonvalidationDetails= 542;
	public final int verifyEventInDetails= 550;
	public final int eventtabsOutvalidationInDetails= 555;
	public final int eventCommonvalidationInDetails= 560;
	public final int deleteEventFromActivityTable= 561;
	public final int editEventFromDetails= 562;
	public final int addAttachmentInDetails= 565;
	public final int addAttchemntvalidation= 570;
	public final int addtaskInDetails= 600;
	public final int verifytaskInDetails= 605;
	public final int deletetaskFromActivityTable= 606;
	public final int editTaskFromDetails= 607;
	public final int inlinedEditDetailsPage= 610;
	public final int checkHeaderAfterInlineEdit= 615;
	public final int editFromDetailsPage= 620;
	public final int deleteLeadFromDetailsPage=625;
	public final int deleteInListingPage= 630;
	
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
	void testmethod() throws InterruptedException, IOException, ParseException{
		//util.login();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(accountlist.AccountMenu));
		
		editFromDetailsPage();	
	}
	
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 * @throws ParseException
 */
	@Test(priority=addAccounts)
	public void addAccounts() throws InterruptedException, IOException, ParseException {
		//util.login();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(accountlist.AccountMenu));
		driver.navigate().refresh();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		Thread.sleep(3000);
		//Creating first Account
		accountentry.accountsCreate(9, 1);
		statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		util.waitForElementAndClick(driver.findElement(accountentry.Save));
		String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		Assert.assertEquals(sucessMessage, accountentry.AccountSucessMessage);
		
		
	}

	/**
	 * Table =  React table AccountsName = excel.readFromExcel(1, 1, 1); =
	 * Lead name from Excel sheet windowHandle = Window handler for switching to
	 * New tab softAssert = Assert more than one value leadStatusBeforRefresh =
	 * Verifying the Lead before create switchToNewTab = Switing to new Tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
   public Integer accountPosition;
   @Test(priority=refresh)
	void refresh() throws IOException, InterruptedException {
		Thread.sleep(3000);
		String curentURl = driver.getCurrentUrl();
		util.switchToNewTab();
		util.switchbackToMainTab(1);
		driver.get(curentURl);
		Thread.sleep(3000);
		WebElement CreateButton = driver.findElement(accountlist.CreateNew);
		util.waitForElementAndClick(CreateButton);
		accountentry.accountsCreate(9, 2);
		util.waitForElementAndClick(driver.findElement(accountentry.Save));
		Thread.sleep(3000);
		util.switchbackToMainTab(0);
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		String conatctAfterRefresh = util.loopColumnFindName(excel.readFromExcel(9,2,0),
				driver.findElement(lead.LeadTable));
         accountPosition =  util.rowCount;
		System.out.println(accountPosition + "" + "My contacts position");
		Assert.assertEquals(conatctAfterRefresh, excel.readFromExcel(9,2,0));
	}

   @Test(priority=latestAccountPosition)
	void latestContactPosition(){
		Assert.assertEquals(accountPosition, "1");
	}
	/**
	 * bulk.createLead(0, 3) = Creating lead 0 = sheet number, 3 row number
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 */

	@Test(priority=saveAndNew)
	void saveAndNew() throws InterruptedException, IOException {
		WebElement CreateButton = driver.findElement(accountlist.CreateNew);
		util.waitForElementAndClick(CreateButton);
		accountentry.accountsCreate(9, 3);
		util.waitForElementAndClick(driver.findElement(leadEntry.SaveandNewButton));
		leadtest.statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		try {
			if (leadtest.statusOfActionPopup == true) {
				accountentry.accountsCreate(9, 4);
				util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
			}

		} catch (Exception e) {
			util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
			util.acceptAlert();
		}
		verifyAccountsInListngPage();
		Thread.sleep(3000);
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
	
	@Test(priority=verifyAccountsInListngPage)
	void verifyAccountsInListngPage() throws IOException, InterruptedException {
		util.recordSelection("100 rows");
		Thread.sleep(3000);
		SoftAssert accountsStatus = new SoftAssert();
		String accountname1 = util.loopColumnFindName(excel.readFromExcel(9, 1, 1),
				driver.findElement(lead.LeadTable));
		String accountname2 = util.loopColumnFindName(excel.readFromExcel(9, 2, 1),
				driver.findElement(lead.LeadTable));
		String accountname3 = util.loopColumnFindName(excel.readFromExcel(9, 3, 1),
				driver.findElement(lead.LeadTable));
		accountsStatus.assertEquals(accountname1, excel.readFromExcel(9, 1, 1));
		accountsStatus.assertEquals(accountname2, excel.readFromExcel(9, 2, 1));
		accountsStatus.assertEquals(accountname3, excel.readFromExcel(9, 3, 1));
		System.out.println("verifyLeadsInListngPagen value in the table are " + accountname1 + "" + accountname2 + ""
				+ accountname3);
		accountsStatus.assertAll();
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
	@Test(priority=verifySearchInAccount)
	void verifySearchInAccount() throws IOException, InterruptedException {
		driver.navigate().refresh();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(9, 2, 1));
		System.out.println("Sendng values to search box");
		Thread.sleep(4000);
		String contactName1 = util.loopColumnFindName(excel.readFromExcel(9, 2, 1),
				driver.findElement(lead.LeadTable));
		System.out.println("verifyLeadsInListngPagen value in the table are " + contactName1);
		String contactName2 = util.loopColumnFindName(excel.readFromExcel(9, 3, 1), driver.findElement(lead.LeadTable));
		System.out.println(contactName2);
		SoftAssert searchAccounts = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(9, 2, 5));
		Thread.sleep(3000);
		driver.navigate().refresh();
		String leadnameByMobile = util.loopColumnFindName(
				excel.readFromExcel(9, 2, 1), driver.findElement(lead.LeadTable));
		searchAccounts.assertEquals(leadnameByMobile, excel.readFromExcel(9, 2, 1));
		searchAccounts.assertEquals(contactName1, excel.readFromExcel(9, 2, 1));
		searchAccounts.assertNull(contactName2);
		searchAccounts.assertAll();
		
	}

	public String customPageViewContacts;
    /**
     * 
     * @throws InterruptedException
     */
	
	@Test(priority=tabsOutvalidationInValidaEmailAccounts)
	void tabsOutvalidationInValidaEmailAccounts () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		Thread.sleep(3000);
		common.emailtabsOutvalidation(accountentry.EmaileContact, "tabs", accountentry.EmailValidation);
	}
	/**
	 * 
	 * @throws InterruptedException
	 */
	
	@Test(priority=commonValidationEmailIDAccounts)
	void commonValidationEmailIDAccounts() throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		Thread.sleep(3000);
		common.emailtabsOutvalidation(accountentry.EmaileContact, "tabs", accountentry.EmailValidation);
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	

	@Test(priority=acccountNameFieldvaldidationAccount)
	void acccountNameFieldvaldidationAccount() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		common.tabsOutValidationFieldType(lead.accountNameArry,
				accountentry.AccontName,
				accountentry.AccountNameValidation, 
				accountentry.accountNamevalidationMessage);
		common.commonValidationFieldType(lead.accountNameArry,
				accountentry.AccontName,
				accountentry.AccountNameValidation, 
				accountentry.accountNamevalidationMessage);
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=designationFieldvalidationAccount)
	void designationFieldvalidationAccount() throws InterruptedException, IOException {
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		common.tabsOutValidationFieldType(lead.designationArry,
				accountentry.Designation,
				accountentry.Designationvalidation, 
				accountentry.designationValidationMessage);
		common.commonValidationFieldType(lead.designationArry,
				accountentry.Designation,
				accountentry.Designationvalidation, 
				accountentry.designationValidationMessage);
		
	}
	
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(priority=mobileNumberFieldValdiation)
	void mobileNumberFieldValdiation() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		common.tabsOutValidationFieldType(lead.mobileNumberArry,
				accountentry.MobileContact,
				accountentry.MobileValidation, 
				accountentry.mobileNumbervalidationMessage);
		common.commonValidationFieldType(lead.mobileNumberArry,
				accountentry.MobileContact,
				accountentry.MobileValidation, 
				accountentry.mobileNumbervalidationMessage);
	}
	
	/**
	   * 
	   * @throws InterruptedException
	   * call web site validation method from common method 
	   */
	@Test(priority=webSiteTabsvaldiationError)
	  void webSiteTabsvaldiationError() throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  common.webSitevalidation(accountentry.WebSite, "tabs",leadEntry.webSiteFieldvaldiation);
	  }

	  /**
	   * 
	   * @throws InterruptedException
	   * call web site validation method from common method 
	   */
	@Test(priority=webSiteCommonvaldiationError)
	  void webSiteCommonvaldiationError() throws InterruptedException{
		  util.waitForElementAndClick(driver.findElement(lead.CreateNewOption));
		  Thread.sleep(3000);
		  common.webSitevalidation(accountentry.WebSite, "common",leadEntry.webSiteFieldvaldiation);
	  }

	  /**
		 * 
		 * @throws IOException
		 * @throws InterruptedException
		 * Enabled the column 
		 * 
		 */
	
	@Test(priority=createPageView)
		void createPageView() throws IOException, InterruptedException {
			common.createPageView(
					//reading the column name from excel sheet
					excel.readFromExcel(3, 1, 4),
					excel.readFromExcel(3, 3, 4),
					excel.readFromExcel(3, 5, 4),
					excel.readFromExcel(3, 6, 4), 
					excel.readFromExcel(3, 7, 4), 
					excel.readFromExcel(3, 10, 4));
		}

		/**
		 * Verify create page view after creating, columnSizeInCustomPage =
		 * actualColumnSize = Getting column size after redirecting to new custom
		 * page view allColumnNames = Getting all column header names
		 * 
		 * @throws IOException
		 * @throws InterruptedException
		 */
		@Test(priority=verifyCreatedPageViewAccounts)
		void verifyCreatedPageViewAccounts() throws IOException, InterruptedException {
			driver.navigate().refresh();
			 common.verifyCreatedPageView(
					 excel.readFromExcel(3, 5, 4),
					 excel.readFromExcel(3, 6, 4),
					 excel.readFromExcel(3, 3, 4), 
					 excel.readFromExcel(3, 7, 4));
			 SoftAssert verifyCreatedPageViewContacts = new SoftAssert ();
			 verifyCreatedPageViewContacts.assertEquals(common.firstColumn1, true);
			 verifyCreatedPageViewContacts.assertEquals(common.secondColumn1, true);
			 verifyCreatedPageViewContacts.assertEquals(common.fourthColumn1, true);
			 verifyCreatedPageViewContacts.assertEquals(common.fifthColumn1, true);
			 verifyCreatedPageViewContacts.assertAll ();
		
		}
		
		// TO DO - Pending from client
		@Test(priority=verifyDefaultViewAccounts)
		void verifyDefaultViewAccounts() throws InterruptedException, IOException {
			util.tableHeader();
			SoftAssert verifyDefaultViewContacts = new SoftAssert();
			List<String> allColumnNames = util.tableHeader();
			System.out.println(allColumnNames);
			boolean accountName = allColumnNames.contains("Account Name");
			boolean accountType = allColumnNames.contains(excel.readFromExcel(3, 3, 4));
			boolean customerID = allColumnNames.contains(excel.readFromExcel(3, 3, 4));
			boolean email = allColumnNames.contains(excel.readFromExcel(3, 6, 4));
			boolean asignTo = allColumnNames.contains(excel.readFromExcel(3, 10, 4));
			boolean desgigantion = allColumnNames.contains(excel.readFromExcel(3, 10, 4));
			boolean createdDate = allColumnNames.contains(excel.readFromExcel(3, 28, 4));
			boolean officephone = allColumnNames.contains(excel.readFromExcel(3, 7, 4));
			boolean state = allColumnNames.contains(excel.readFromExcel(3, 27, 4));
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
		@Test(priority=verifyCustomViewInSavedPageViewsAccounts)
		void verifyCustomViewInSavedPageViewsAccounts() throws InterruptedException, IOException {
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
		@Test(priority=editCustomViewAccounts)
		void editCustomViewAccounts() throws IOException, InterruptedException {
			common.editCustomView(excel.readFromExcel(3, 0, 1),
					excel.readFromExcel(3, 6, 4), 
					excel.readFromExcel(3, 7, 4));

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

		@Test(priority=pageViewAfterEditAccounts)
		void pageViewAfterEditAccounts() throws IOException, InterruptedException {
			common.pageViewAfterEdit(excel.readFromExcel(3, 6, 4),
					excel.readFromExcel(3, 7, 4),
					excel.readFromExcel(3, 5, 4), 
					excel.readFromExcel(3, 3, 2));
			
			SoftAssert pageViewAfterEditAccounts = new SoftAssert ();
			//After Editing check the columns are gets desabled 
			pageViewAfterEditAccounts.assertEquals(common.enabledColumnEdit1Page1, true);
			pageViewAfterEditAccounts.assertEquals(common.enabledColumnEditPage, true);
			pageViewAfterEditAccounts.assertEquals(common.desabledColumn1EditPage, false);
			pageViewAfterEditAccounts.assertEquals(common.desabledColumnEditPage, false);
			pageViewAfterEditAccounts.assertAll ();

		}

		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 * Checking Create custom page view validation while entering same name which is already exist 
		 */
			@Test(priority=alreadyExistpageViewNameAccounts)
			 void alreadyExistpageViewNameAccounts() throws InterruptedException, IOException{
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
			@Test(priority=deletePageViewAccounts)
			void deletePageViewAccounts() throws InterruptedException, IOException {
				 common.deletePageView();
			}

			/**
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 */
			@Test(priority=verifyDeletdViewInSavedViewsAccounts)
			 void verifyDeletdViewInSavedViewsAccounts () throws IOException, InterruptedException{
				  common.verifyDeletdViewInSavedViews();
					
				}
				//Validation for create Page
				@Test(priority=validationCreatePageViewAccounts)
			 void validationCreatePageViewAccounts () throws IOException, InterruptedException{
				 common.validationCreatePageView();
				 SoftAssert validationCreatePageViewContacts = new SoftAssert ();
				 validationCreatePageViewContacts.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
				 validationCreatePageViewContacts.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
				 validationCreatePageViewContacts.assertAll();
			 }	
		/**
		 * 
		 * @throws InterruptedException
		 */
	   @Test(priority=accountManditiryTabsoutvalidation)
		void accountManditiryTabsoutvalidation() throws InterruptedException{
			SoftAssert accounttabs = new SoftAssert ();
			util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
			Thread.sleep(3000);
			driver.findElement(accountentry.AccontName).click();
			//Tabs out with out entering Account name
			driver.findElement(accountentry.AccontName).sendKeys(Keys.TAB);
			String accountvalidationMessge = util.getValidationMessage(driver.findElement(accountentry.AccountNameValidation));
			accounttabs.assertEquals(accountvalidationMessge, accountentry.accountNamevalidationMessage);
			driver.findElement(accountentry.Source).click();
			//Tabs out with out entering Account name
			driver.findElement(accountentry.Source).sendKeys(Keys.TAB);
			String leadSourceValidation = util.getValidationMessage(driver.findElement(accountentry.SourceValidation));
			accounttabs.assertEquals(leadSourceValidation, accountentry.sourceValidatiionMessage);
			accounttabs.assertAll();	
		}
     
	   //Checking common validation for the Account page 
	   @Test(priority=accountManditoryCommonValidation)
	   void accountManditoryCommonValidation() throws InterruptedException{
		   SoftAssert commonAccount = new SoftAssert();
		   util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
		   util.waitForElementAndClick(driver.findElement(accountentry.Save));
		   String accountvalidationMessge = util.getValidationMessage(driver.findElement(accountentry.AccountNameValidation));
			String leadSourceValidation = util.getValidationMessage(driver.findElement(accountentry.SourceValidation));
			String commonError = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
			commonAccount.assertEquals(leadSourceValidation, accountentry.sourceValidatiionMessage);
			commonAccount.assertEquals(accountvalidationMessge, accountentry.accountNamevalidationMessage);
			commonAccount.assertEquals(commonError, leadEntry.CommonValidationMEssage);
			commonAccount.assertAll();
	   }

	   /**
	    * 
	    * @throws InterruptedException
	    * Checking alert message while closing the window after entering the charectrets 
	    */
	   		@Test(priority=verifyAlertwhileClosing)
	   	void verifyAlertwhileClosing() throws InterruptedException {
	   		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
	   		accountentry.accountsCreate(2, 1);
	   		util.waitForElementAndClick(driver.findElement(accountentry.Cancel));
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
	   		util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
	   		util.waitForElementAndClick(driver.findElement(accountentry.Cancel));
	   		boolean alert = util.isAlertPresent();
	   		Assert.assertFalse(alert);
	   		
	   	}
	    

			/**
			   * 
			   * @throws InterruptedException
			   */
			@Test(priority=statevalidationWithOutCountry)
				 void statevalidationWithOutCountry() throws InterruptedException{
					 util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
					 util.waitForElementAndClick(driver.findElement(accountentry.StateBilling));
					 //Listing the State list, Expected this should be empty
					 List list = util.returnDropDownList(accountentry.StateBilling,By.xpath("//div[@role='option']"));
					 Assert.assertTrue(list.isEmpty());
				 }
			 	
			/**
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 * Add log validation 
			 */
			@Test(priority=addLogValidationsListingAccounts)
		void addLogValidationsListingAccounts() throws InterruptedException, IOException {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			common.addLogcallListing(excel.readFromExcel(9, 2, 0));
			SoftAssert addLogValidationsListingAccounts = new SoftAssert();
			addLogValidationsListingAccounts.assertEquals(common.tabsOutvalidationMsgforLogs, lead.addLogFieldvaldiationMessage);
			addLogValidationsListingAccounts.assertEquals(common.addlogCommonError, leadEntry.CommonValidationMEssage);
			addLogValidationsListingAccounts.assertAll();

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
			common.addLogcallListing(excel.readFromExcel(9,2,0));
		}
	     /**
	      * 
	      * @throws IOException
	      * @throws InterruptedException
	      * Check the Error while cancelling the pop up page after entering the characters 
	      */
		@Test(priority=addLogErrorWhileClosingLog)
		 void addLogErrorWhileClosingLog  () throws IOException, InterruptedException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 common.addLogErrorWhileClosing(excel.readFromExcel(9,2,0));
			
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		@Test(priority=addlogErroWithOutcharLog)
		 void addlogErroWithOutcharLog () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 common.addlogErroWithOutchar(excel.readFromExcel(9,2,0));
		
		 }
		
		/**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		
		@Test(priority=logSubjecttabsOutValidation)
		 void logSubjecttabsOutValidation () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
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
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
			 Thread.sleep(3000);
			 common.commonValidationFieldType(
					 lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
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
		
		
		
		
		
		
		
		@Test(priority=addNoteListing)
		void addNoteListing() throws InterruptedException, IOException {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			common.addNoteListing(excel.readFromExcel(9,2,0));
		}
		
		
		@Test(priority=addNotevalidationListingAccounts)
		void addNotevalidationListingAccounts() throws InterruptedException, IOException {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			common.addNotevalidationListing(excel.readFromExcel(9,2,0));
			SoftAssert addNotevalidationListingAccounts = new SoftAssert();
			addNotevalidationListingAccounts.assertEquals(common.noteSubjectvaldiatinListing, lead.addNoteFieldvaldiationMessage);
			addNotevalidationListingAccounts.assertEquals(common.addnoteCommonError, leadEntry.CommonValidationMEssage);
			addNotevalidationListingAccounts.assertAll();
		}

		@Test(priority=addNoteErrorWhileClosing)
		void addNoteErrorWhileClosingNote  () throws IOException, InterruptedException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			  common.addNoteErrorWhileClosing(excel.readFromExcel(9,2,0));
			 
			 }
		@Test(priority=addNoteErroWithOutchar)
			 void addNoteErroWithOutchar () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
	             common.addNoteErroWithOutchar(excel.readFromExcel(9,2,0));; 
			 }
		
		
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 
		@Test(priority=noteSubjecttabsOutValidation)
		 void noteSubjecttabsOutValidation () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
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
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				 common.commonValidationFieldType(lead.logSubjectArry,lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
		 }
		
		EventEntry evententry = new EventEntry();

		@Test(priority=addEvent)
		void addEvent() throws InterruptedException, IOException {
			common.addEvent(excel.readFromExcel(9,2,0));
		}

		/**
		 * Tabs out valdiation error for Event addEventValidationError : Assert all
		 * values
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		
		@Test(priority=tabsOutvalidationEventAccounts)
		void tabsOutvalidationEventAccounts() throws InterruptedException, IOException {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			common.tabsOutvalidationEvent(excel.readFromExcel(9,2,0));
			SoftAssert tabsOutvalidationEventAccounts = new SoftAssert ();
			tabsOutvalidationEventAccounts.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
			tabsOutvalidationEventAccounts.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
			tabsOutvalidationEventAccounts.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
			tabsOutvalidationEventAccounts.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
			tabsOutvalidationEventAccounts.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
			tabsOutvalidationEventAccounts.assertAll();

		}
		
		@Test(priority=commonvalidationEventAccounts)

		void commonvalidationEventAccounts () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			common.commonvalidationEvent(excel.readFromExcel(9,2,0));
			SoftAssert commonvalidationEventAccounts = new SoftAssert ();
			commonvalidationEventAccounts.assertEquals(common.subjectvalErrorEvent, evententry.SubjectFieldvalError);
			commonvalidationEventAccounts.assertEquals(common.eventTypevalErrorEvent, evententry.EventTypeFieldvalError);
			commonvalidationEventAccounts.assertEquals(common.StartdatevalErrorEvent, evententry.StartDateTimeFieldvalError);
			commonvalidationEventAccounts.assertEquals(common.EnddatevalErrorEvent, evententry.EndDateTimeFieldvalError);
			commonvalidationEventAccounts.assertEquals(common.commonvalidationEvent, evententry.commonValidationMessage);
			commonvalidationEventAccounts.assertAll();
		}
		
		
		 /**
		  * Call the commonValidationFieldType  methos and pass Anonymous array
		  * @throws InterruptedException
		  * @throws IOException
		  */
		
		@Test(priority=EventSubjecttabsOutValidation)
		 void EventSubjecttabsOutValidation () throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				 common.tabsOutValidationFieldType(lead.eventSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
		 }
		
		@Test(priority=EventSubjectCommonValidation)
		 void EventSubjectCommonValidation() throws InterruptedException, IOException{
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
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
			 util.clickOnActions(excel.readFromExcel(9,2,0), driver.findElement(lead.LeadTable), "More Action");
				util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
				Thread.sleep(3000);
				//create anonymous array to pass the one time value
				common.commonValidationFieldType(lead.eventLocationArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
		 } 
		 
		 
		@Test(priority=addAttachement)
		void addAttachement() throws InterruptedException, IOException {
			util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 common.addAttachement(excel.readFromExcel(9,2,0), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
		}

		@Test(priority=discardInlineEdit)
		void discardInlineEdit() throws InterruptedException, IOException{
			common.discardInlineEditChanges("Address", excel.readFromExcel(2, 2, 1), accountentry.Address);
		}

		@Test(priority=inlineEditInTable)
		/**
		 * 
		 * @throws IOException
		 * @throws InterruptedException
		 */
		void inlineEditInLeadTable() throws IOException, InterruptedException {
			Thread.sleep(3000);
			try {
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 2, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 4));// Enable																								// Company
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 4));// Enable																							// to
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 4));// Enable																				// Status
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 6, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 7, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 8, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 9, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 10, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 11, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 12, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 13, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 14, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 15, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 16, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 17, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 18, 4));
				util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 19, 4));
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
				String companyName = util.getColumndata("Web Site", excel.readFromExcel(9, 2, 0));
				String companyNameEdit = companyName + " " + "Edited";
				util.inlineEditInTable("Web Site", excel.readFromExcel(9, 2, 0));
				util.sendValue(driver.findElement(accountentry.WebSite), companyNameEdit);
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				String companyNameAfterEdit = util.getColumndata("Web Site", excel.readFromExcel(9, 2, 0));
				Thread.sleep(3000);
				inlineEditInLeadTable.assertNotEquals(companyName, companyNameAfterEdit);
			} catch (Exception E) {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.acceptUnExpectedError();

			}
			try {
				String departMennt = util.getColumndata("Department", excel.readFromExcel(9, 2, 0));
				String designationEdit = departMennt + " " + "Edited";
				util.inlineEditInTable("Department", excel.readFromExcel(9, 2, 0));
				util.sendValue(driver.findElement(accountentry.DepartmentContact), designationEdit);
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				Thread.sleep(4000);
				String designationAfterEdit = util.getColumndata("Department", excel.readFromExcel(9, 2, 0));
				inlineEditInLeadTable.assertNotEquals(departMennt, designationAfterEdit);
			} catch (Exception e) {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.acceptUnExpectedError();
			}
			try {
				String decisionAuthority = util.getColumndata("Account Type", excel.readFromExcel(9, 2, 0));
				util.inlineEditInTable("Account Type", excel.readFromExcel(9, 2, 0));
				util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				Thread.sleep(3000);
				String leadStatusAfterChange = util.getColumndata("Decision Authority", excel.readFromExcel(9,2,0));
				inlineEditInLeadTable.assertNotEquals(decisionAuthority, leadStatusAfterChange);
			} catch (Exception e) {
				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.acceptUnExpectedError();

			}
			try {
				String email = util.getColumndata("Email", excel.readFromExcel(9,2,0));
				util.inlineEditInTable("Email", excel.readFromExcel(9,2,0));
				util.sendValue(driver.findElement(accountentry.EmaileContact), emailEdit);
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				Thread.sleep(3000);
				String emailAfterEdit = util.getColumndata("Email", excel.readFromExcel(9,2,0));
				inlineEditInLeadTable.assertNotEquals(email, emailAfterEdit);
			} catch (Exception e) {

				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.acceptUnExpectedError();

			}
			try {
				String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(9,2,0));
				util.inlineEditInTable("Assigned To", excel.readFromExcel(9,2,0));
				util.handleDropDownByIndex(driver.findElement(leadEntry.InlineEditDropDownElement), 3);
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				Thread.sleep(3000);
				String AssignToAfterEdit = util.getColumndata("Assigned To", excel.readFromExcel(9,2,0));
				inlineEditInLeadTable.assertNotEquals(AssignTo, AssignToAfterEdit);
			} catch (Exception e) {

				util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				util.acceptUnExpectedError();

			}

			try {
				String mobileNumber = util.getColumndata("Mobile Number", excel.readFromExcel(9,2,0));
				String mobileNumberEdit = mobileNumber + " " + "02";
				util.inlineEditInTable("Mobile Number", excel.readFromExcel(9,2,0));
				util.sendValue(driver.findElement(accountentry.MobileContact), mobileNumberEdit);
				util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				Thread.sleep(3000);
				String mobileNumberAfterEdit = util.getColumndata("Mobile Number", excel.readFromExcel(9,2,0));
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
		 @Test(priority=webSiteInlinetabsOutValidationError)
		 void webSiteInlinetabsOutValidationError() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(3000);
			 common.inlineWeSitevaldiation("Web Site", excel.readFromExcel(0, 1, 1), accountentry.WebSite, "tabs",accountentry.WebSiteValidation); 
		 }
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		 
		 @Test(priority=webSiteInlineEditCommonvalidationError)
		 void webSiteInlineEditCommonvalidationError() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(3000);
			 common.inlineWeSitevaldiation("Web Site", excel.readFromExcel(0, 1, 1), accountentry.WebSite, "common",accountentry.WebSiteValidation);
		 }
		 
		 
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		
		@Test(priority=emailInlineEditTabsOutalidationAccounts)
		 void emailInlineEditTabsOutalidationAccounts() throws InterruptedException, IOException{
			 Thread.sleep(3000);
			 common.inlineEmailIdValidation("Email", excel.readFromExcel(9,2,0),accountentry.EmaileContact, "tabs",accountentry.EmailValidation);
		 }
		
		 /**
		  * 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		
		@Test(priority=emailInlneEditCommonValidationAccounts)
		 void emailInlneEditCommonValidationAccounts() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(3000);
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 common.inlineEmailIdValidation("Email", excel.readFromExcel(9,2,0), accountentry.EmaileContact, "common",accountentry.EmailValidation);
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
					 excel.readFromExcel(9,2,0), new String [] {"alphebeitcal","@#$%^&*()","99225alpheNumeric"}, 
					 accountentry.MobileContact, 
					 accountentry.MobileValidation, accountentry.mobileNumberValidationMessage);
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
					 excel.readFromExcel(9,2,0), new String [] {"alphebeitcal","@#$%^&*-=+()","99225alpheNumeric"}, 
					 accountentry.MobileContact, 
					 accountentry.MobileValidation, accountentry.mobileNumberValidationMessage);
		 }
		 
		 /**
		  * Inline edit tabs out validation for aplenumeric 
		  * @throws InterruptedException
		  * @throws IOException
		  */
		@Test(priority=inlineEditTabsvalidationForAlphanumeric)
		 void inlineEditTabsvalidationForAlphanumeric() throws InterruptedException, IOException{
			 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			 util.acceptUnExpectedError();
			 Thread.sleep(5000);
			 common.inlineEditTabsOutValidation("Designation", 
					 excel.readFromExcel(9,2,0), new String [] {"@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 accountentry.Designation, 
					 accountentry.Designationvalidation, accountentry.designationValidationMessage);
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
					 excel.readFromExcel(9,2,0), new String [] {"@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 accountentry.Designation, 
					 accountentry.Designationvalidation, accountentry.designationValidationMessage);
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
					 excel.readFromExcel(9,2,0), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 accountentry.DepartmentContact, 
					 accountentry.Departmentvalidation, accountentry.departmentvalidationMessage);
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
					 excel.readFromExcel(9,2,0), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
					 accountentry.DepartmentContact, 
					 accountentry.Departmentvalidation, accountentry.departmentvalidationMessage);
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
					 util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Account Name");
					Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,1));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  Thread.sleep(3000);
					  String leadname1 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  String leadname2 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname1);
					  verifyFilterContacts.assertNull(leadname2);
			
				
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "First Name");
							
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(9,1,6));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname3 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname3);
					  String leadname4 = util.loopColumnFindName(excel.readFromExcel(9, 2, 1), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname4);
			
				  
				
					  Thread.sleep(3000);
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
				
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Source");
						Thread.sleep(3000);
						  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
						  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(9,1,16));
						  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
						  String leadname5 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
						  String leadname6 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
						  verifyFilterContacts.assertNotNull(leadname5);
						  verifyFilterContacts.assertNull(leadname6);
					
				
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Assigned To");
							
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(9,1,17));
					  Thread.sleep(2000);
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  Thread.sleep(3000);
					  String leadname7 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname7);
					  String leadname8 = util.loopColumnFindName(excel.readFromExcel(9, 2, 1), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname8);
				
				
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Designation");
						
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(9,1,13));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname9 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname9);
					  String leadname10 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname10);
			
				
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
					
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Email");
						
						
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(9,1,10));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname11 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname11);
					  String leadname12 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname12);
			
				  
			
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
			
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Mobile Number");
						
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(9,1,9));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname13 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname13);
					  String leadname14 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname14);
			
			
					  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
				
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Country");
						
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(9,1,14));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  String leadname15 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname15);
					  String leadname16 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
					  verifyFilterContacts.assertNotNull(leadname16);
			

				  //AND and OR Condiion 
				  
				
							util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Account Name");
						
						Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(9,1,0));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
					  util.waitForElementAndClick(driver.findElement(lead.FilterAddNewFilter));
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
					  util.handleDropdown(driver.findElement(lead.FilterFieldBy2), "Account Name");
					  Thread.sleep(3000);
					  util.handleDropdown(driver.findElement(lead.FilterOperator2), "Equal to");
					  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox2), excel.readFromExcel(9,2,0));
					  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
						  String leadname17 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
						  String leadname18 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
						  verifyFilterContacts.assertNotNull(leadname17);
						  verifyFilterContacts.assertNotNull(leadname18);
						  Thread.sleep(3000);
						  util.waitForElementAndClick(driver.findElement(lead.FilterEdit2));
						  Thread.sleep(3000);
						  util.handleDropdown(driver.findElement(lead.FilterANDOR), "AND");
						  Thread.sleep(3000);
						  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
						  String leadname19 = util.loopColumnFindName(excel.readFromExcel(9, 1, 0), driver.findElement(lead.LeadTable));
						  String leadname20 = util.loopColumnFindName(excel.readFromExcel(9, 2, 0), driver.findElement(lead.LeadTable));
						  verifyFilterContacts.assertNull(leadname19);
						  verifyFilterContacts.assertNull(leadname20);
						  
					
				  util.waitForElementAndClick(driver.findElement(lead.FilterOption));
				  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				  driver.navigate().refresh();
				  verifyFilterContacts.assertAll();
				  
			  }

			
			@Test (priority =checkFilterByValues) 
			 void checkFilterByValues() throws InterruptedException{
				 util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
				 common.checkFilterByValues(customValue);
			 }
			/**
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 */
			@Test(priority=addNoteForAll)
			void addNoteForAll () throws InterruptedException, IOException{
				 common.addNoteForAll(accountlist.AddNoteAll);
			  }
			
			/**
			 * Redirecting to details page
			 * @throws IOException
			 * @throws InterruptedException
			 */
			
			@Test(priority=verifyRedirectionToDetailsPage)
			void verifyRedirectionToDetailsPage () throws IOException, InterruptedException{
				driver.navigate().refresh();
				 common.verifyRedirctionToDetilspage(excel.readFromExcel(9, 2, 0));
			}
			
			
			 /**
			  * 
			  * @throws IOException
			  * excel.readFromExcel(0, 1, 3) - reading the details from Excel sheet
			  */
			@Test(priority=verifyHeaderForDetails)
			 void verifyHeaderForDetails () throws IOException{
					 SoftAssert verifyHeaderForDetailsAccounts = new SoftAssert ();
					 String leadNameInDeatis = util.getElementName(driver.findElement(accountdetails.AccountNameDetailsHeader));
					 String companyNameDetails = util.getElementName(driver.findElement(accountdetails.AccountTypeDetailsHeader));
					 String DesignationInDetail = util.getElementName(driver.findElement(accountdetails.OfficePhoneDetailsHeader));
					 String mobileNumberInDeatsils = util.getElementName(driver.findElement(accountdetails.AssignToDetailsHeader));
					 String email = util.getElementName(driver.findElement(accountdetails.WebSiteDetailsHeader));
					 verifyHeaderForDetailsAccounts.assertEquals(leadNameInDeatis, excel.readFromExcel(9, 2, 0));
					 verifyHeaderForDetailsAccounts.assertEquals(companyNameDetails, excel.readFromExcel(9, 2, 18));
					 verifyHeaderForDetailsAccounts.assertEquals(DesignationInDetail, excel.readFromExcel(9, 2, 17));
					 verifyHeaderForDetailsAccounts.assertEquals(mobileNumberInDeatsils, excel.readFromExcel(9, 2, 2));
					 verifyHeaderForDetailsAccounts.assertEquals(email, excel.readFromExcel(9, 2, 1));
					 verifyHeaderForDetailsAccounts.assertAll(); 
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
					//Calling the method from lead test
			@Test(priority=addEventInDetails)
					void addEventInDetails () throws InterruptedException, IOException{
						leadtest.addEventInDeatilspage();
						common.verifyactivityLisiInDetails(driver.findElement(leadDetails.NewEvent),
								excel.readFromExcel(5, 2, 0),
								driver.findElement(lead.LeadTable));
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
				util.waitForElementAndClick(driver.findElement(accountlist.AccountMenu));
				 util.waitForElementAndClick(driver.findElement(accountlist.CreateNew));
				 //Creating 7 th Account
				 accountentry.accountsCreate(9, 7);
				 util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				 //taking 7th User details from Edit page
				 String [] valueBeforeEdit = common.getAttribute(excel.readFromExcel(9, 7, 0),
						 accountentry.AccountType, 
						 accountentry.AssignedTo, 
						 accountentry.EmaileContact, 
						 accountentry.DepartmentContact, 
						 accountentry.OfficeMobile, 
						 accountentry.Designation, 
						 accountentry.CountryBilling);
					Thread.sleep(3000);
					util.recordSelection("100");
					//Redirecting to 7 the User Details page 
				 util.clickOnActions(excel.readFromExcel(9, 7, 0),
						 driver.findElement(lead.LeadTable),
						 "Redirection");
				 //Click On Edit button and Changing to 8th accounts details
				 util.inlineEditInInformationSection(driver.findElement(accountdetails.InformationSection));
				 //Creating to 8 th User //hence 7 the user details updated with 8 th users details
				 accountentry.accountsCreate(9, 8);
				 util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
				 util.waitForElementAndClick(driver.findElement(accountlist.AccountMenu));
				 util.recordSelection("100");
				 //Getting 8th user Details 
				 String [] valueAfterEdit = common.getAttribute(excel.readFromExcel(9, 8, 0),
						 accountentry.AccountType, 
						 accountentry.AssignedTo, 
						 accountentry.EmaileContact, 
						 accountentry.DepartmentContact, 
						 accountentry.OfficeMobile, 
						 accountentry.Designation, 
						 accountentry.CountryBilling);
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
				SoftAssert checkHeaderAfterInlineEditAccounts = new SoftAssert();
				util.recordSelection("100");
				 util.clickOnActions(excel.readFromExcel(9, 8, 0),
						 driver.findElement(lead.LeadTable),
						 "Redirection");
				 util.inlineEditInInformationSection(driver.findElement(accountdetails.InformationSection));
				 //Edit the 8 the Account changing to 7 th user details 
				 accountentry.accountsCreate(9, 7);
				 util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
				 String accountName = util.getElementName(driver.findElement(accountdetails.AccountNameDetailsHeader));
				 String accountType =util.getElementName(driver.findElement(accountdetails.AccountTypeDetailsHeader)); 
		         String assignedTo = util.getElementName(driver.findElement(accountdetails.AssignToDetailsHeader));
		         String webSite = util.getElementName(driver.findElement(accountdetails.AssignToDetailsHeader));
		         checkHeaderAfterInlineEditAccounts.assertEquals(accountName, excel.readFromExcel(9, 7, 0));
		         checkHeaderAfterInlineEditAccounts.assertEquals(accountType, excel.readFromExcel(9, 7, 18));
		         checkHeaderAfterInlineEditAccounts.assertEquals(assignedTo,excel.readFromExcel(2, 7, 17));
		         checkHeaderAfterInlineEditAccounts.assertEquals(webSite, excel.readFromExcel(2, 7, 1));
		         checkHeaderAfterInlineEditAccounts.assertAll();	 
			}
			/**
			 * 
			 * @throws InterruptedException
			 * @throws IOException
			 * Editing the User 7 to 8, its Edting he lead using the Edit Button
			 */
			@Test(priority=editFromDetailsPage)
			public void editFromDetailsPage() throws InterruptedException, IOException{
				SoftAssert editFromDetailsPageAccounts = new SoftAssert();
				util.waitForElementAndClick(driver.findElement(accountdetails.EditButtonInDetailsPage));
				accountentry.accountsCreate(9, 8);
				util.waitForElementAndClick(driver.findElement(By.xpath("(//button[@class='pc_colorBtn'])[2]")));
				String accountName = util.getElementName(driver.findElement(accountdetails.AccountNameDetailsHeader));
				 String accountType =util.getElementName(driver.findElement(accountdetails.AccountTypeDetailsHeader)); 
		         String assignedTo = util.getElementName(driver.findElement(accountdetails.AssignToDetailsHeader));
		         String webSite = util.getElementName(driver.findElement(accountdetails.WebSiteDetailsHeader));;
		         editFromDetailsPageAccounts.assertEquals(accountName, excel.readFromExcel(9, 7, 0));
		         editFromDetailsPageAccounts.assertEquals(accountType, excel.readFromExcel(9, 7, 18));
		         editFromDetailsPageAccounts.assertEquals(assignedTo,excel.readFromExcel(2, 7, 17));
		         editFromDetailsPageAccounts.assertEquals(webSite, excel.readFromExcel(2, 7, 1));
		        editFromDetailsPageAccounts.assertAll();	 
			}
			/**
			 * @throws InterruptedException 
			 * 
			 */
			@Test(priority=deleteLeadFromDetailsPage)
			public void deleteLeadFromDetailsPage () throws InterruptedException{
				SoftAssert deleteFromDetailsAccounts = new SoftAssert();
				String currenturl = driver.getCurrentUrl();
				util.waitForElementAndClick(driver.findElement(accountdetails.DeteteOption));
				String deleteConfirmation = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
				String urlAfterDelete = driver.getCurrentUrl();
				deleteFromDetailsAccounts.assertNotEquals(currenturl, urlAfterDelete);
				deleteFromDetailsAccounts.assertEquals(deleteConfirmation, lead.DeletetLeadSucessMessage);
				deleteFromDetailsAccounts.assertAll();
			}
			/**
			 * Delete 8 user from details page and verify the 8 user is available or note
			 * @throws InterruptedException
			 * @throws IOException
			 */
			@Test(priority=deleteInListingPage)
			public void deleteLeadInListingPage () throws InterruptedException, IOException{
				util.waitForElementAndClick(driver.findElement(accountlist.AccountMenu));
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
