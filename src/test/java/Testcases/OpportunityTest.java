package Testcases;

import java.io.IOException;

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
import Pages.EventEntry;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.OpportunityDetails;
import Pages.OpportunityEntry;
import Pages.OpportunityListing;
import Pages.PCUtility;
import Pages.TaskEntry;
@Listeners(ListenersClass.class)
public class OpportunityTest extends DriverClass{
	
	PCUtility util = new PCUtility ();
	LeadListing lead = new LeadListing();
	ExcelReader excel = new ExcelReader ();
	LeadEntry leadEntry = new LeadEntry();
	LeadDetails leadDetails = new LeadDetails ();
	LeadTest leadtest = new LeadTest ();
	CommonFeature common = new CommonFeature();
	OpportunityListing opplist = new OpportunityListing();
	OpportunityDetails oppdetails = new OpportunityDetails();
	OpportunityEntry oppentry = new OpportunityEntry();
	
	
	String [] customValue = {"Opportunity Created By","Opportunity Created"};
	public final int addAccounts = 10;
	public final int addOpportunity = 20;
	public final int refresh = 30;
	public final int latestOpportunityPosition = 40;
	public final int saveAndNew = 50;
	public final int verifyOpportuniysInListngPage = 60;
	public final int verifySearchInOpportunity = 70;
	public final int opportunityNameFieldvaldidation = 80;
	public final int amountFieldValdiation = 90;
	public final int createPageView = 100;
	public final int verifyCreatedPageViewOpportunity = 110;
	public final int verifyCustomViewInSavedPageViewsOpportunity = 120;
	public final int editCustomViewOpportunity = 130;
	public final int pageViewAfterEditOpportunity = 140;
	public final int alreadyExistpageViewNameOpportunity = 150;
	public final int deletePageViewOpportunity = 160;
	public final int verifyDeletdViewInSavedViewsOpportunity = 170;
	public final int validationCreatePageViewOpportunity = 180;
	public final int opportunityManditiryTabsoutvalidation = 190;
	public final int opportunityManditoryCommonValidation = 200;
	public final int verifyAlertwhileClosing = 210;
	public final int verifyAlertWithOutEntering = 220;
	public final int addLogValidationsListingOpportunity = 230;
	public final int addLogcallListing = 240;
	public final int addLogErrorWhileClosingLog = 250;
	public final int addlogErroWithOutcharLog = 260;
	public final int logSubjecttabsOutValidation = 270;
	public final int logSubjectCommonValidation = 280;
	public final int addNoteListing = 290;
	public final int addNotevalidationListingOpportunity = 300;
	public final int addNoteErrorWhileClosing = 310;
	public final int addNoteErroWithOutchar = 320;
	public final int noteSubjecttabsOutValidation = 330;
	public final int noteSubjectCommonValidation = 340;
	public final int addEvent = 350;
	public final int tabsOutvalidationEventAccounts = 360;
	public final int commonvalidationEventAccounts = 370;
	public final int EventSubjecttabsOutValidation = 380;
	public final int EventSubjectCommonValidation = 390;
	public final int EventLocationtabsOutValidation = 400;
	public final int EventLocationCommonValidation = 410;
	public final int addAttachement = 420;
	public final int inlineEditInLeadTable = 430;
	public final int inlineTabsNumericalNumbervalidation = 440;
	public final int inlineCommonNumericalNumbervaldation = 450;
	public final int inlineEditTabOutTextFieldvalidation = 460;
	public final int inlineEditCommonTextieldValidation = 470;
	public final int verifyFilter = 480;
	public final int checkFilterByValues = 481;
	public final int verifyRedirectionToDetailsPage = 490;
	public final int verifyHeaderForDetails = 500;
	public final int addLogcallDetails = 510;
	public final int addLogValidationsDetails = 520;
	public final int verifyLogcallInDetailsPage = 530;
	public final int logSubjectTabOutValidationDetails = 540;
	public final int logSubjectCommonvalidationDetails = 550;
	public final int deleteLogCallFromActivityTable	 = 551;
	public final int editLogCallFrometails	 = 552;
	public final int addNoteInDetails = 560;
	public final int addNotevalidationInDetails = 570;
	public final int verifyNoteIndetails = 580;
	public final int addnotetabsOutvalidationInDetail = 590;
	public final int addnoteCommonValidationDetails = 600;
	public final int deleteNoteFromActivityTable = 601;
	public final int editNoteFromDetails = 602;
	public final int addEventInDetails = 610;
	public final int eventtabsOutvaldiationDetails = 605;
	public final int eventCommonvalidationDetails = 610;
	public final int verifyEventInDetails = 615;
	public final int eventtabsOutvalidationInDetails = 620;
	public final int eventCommonvalidationInDetails = 625;
	public final int deleteEventFromActivityTable = 630;
	public final int editEventFromDetails = 631;
	public final int addAttachmentInDetails = 635;
	public final int addAttchemntvalidation = 640;
	public final int addtaskInDetails = 645;
	public final int verifytaskInDetails = 650;
	public final int deletetaskFromActivityTable = 655;
	public final int editTaskFromDetails = 656;
	
	
	
	
	
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
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 * @throws ParseException
 */
	@Test(priority=addOpportunity)
	public void addOpportunity() throws InterruptedException, IOException, ParseException {
		//util.login();
		Thread.sleep(5000);
		util.waitForElementAndClick(driver.findElement(opplist.OpportunityMenu));
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
		Thread.sleep(3000);
		//Creating first Opportunity
		oppentry.opportunityCreate(10, 1);
		statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		util.waitForElementAndClick(driver.findElement(oppentry.Save));
		String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
		Assert.assertEquals(sucessMessage, oppentry.opportunitySucessMessage);
		System.out.println("Add Opportunitys is failed");
		
	}

	/**
	 * Table =  React table OpportunitysName = excel.readFromExcel(1, 1, 1); =
	 * Lead name from Excel sheet windowHandle = Window handler for switching to
	 * New tab softAssert = Assert more than one value leadStatusBeforRefresh =
	 * Verifying the Lead before create switchToNewTab = Switing to new Tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
   public Integer OpportunityPosition;
   @Test(priority=refresh)
	void refresh() throws IOException, InterruptedException {
		Thread.sleep(3000);
		String curentURl = driver.getCurrentUrl();
		util.switchToNewTab();
		util.switchbackToMainTab(1);
		driver.get(curentURl);
		Thread.sleep(3000);
		WebElement CreateButton = driver.findElement(opplist.CreateNew);
		util.waitForElementAndClick(CreateButton);
		oppentry.opportunityCreate(10, 2);
		util.waitForElementAndClick(driver.findElement(oppentry.Save));
		Thread.sleep(3000);
		util.switchbackToMainTab(0);
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		String conatctAfterRefresh = util.loopColumnFindName(excel.readFromExcel(10,2,0),
				driver.findElement(lead.LeadTable));
         OpportunityPosition =util.rowCount;
		System.out.println(OpportunityPosition + "" + "My contacts position");
		Assert.assertEquals(conatctAfterRefresh, excel.readFromExcel(10,2,0));
	}

   @Test(priority=latestOpportunityPosition)
	void latestOpportunityPosition(){
		Assert.assertEquals(OpportunityPosition, "1");
	}
   
   /**
	 * bulk.createLead(0, 3) = Creating lead 0 = sheet number, 3 row number
	 * 
	 * @throws InterruptedException
 * @throws IOException 
	 */

	@Test(priority=saveAndNew)
	void saveAndNew() throws InterruptedException, IOException {
		WebElement CreateButton = driver.findElement(opplist.CreateNew);
		util.waitForElementAndClick(CreateButton);
		oppentry.opportunityCreate(10, 3);
		util.waitForElementAndClick(driver.findElement(leadEntry.SaveandNewButton));
		leadtest.statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		try {
			if (leadtest.statusOfActionPopup == true) {
				//Create 4th Opportunity
				oppentry.opportunityCreate(10, 4);
				util.waitForElementAndClick(driver.findElement(leadEntry.SaveButton));
			}

		} catch (Exception e) {
			util.waitForElementAndClick(driver.findElement(leadEntry.CancelButton));
			util.acceptAlert();
		}
		verifyOpportuniysInListngPage();
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
	
	@Test(priority=verifyOpportuniysInListngPage)
	void verifyOpportuniysInListngPage() throws IOException, InterruptedException {
		util.recordSelection("100 rows");
		Thread.sleep(3000);
		SoftAssert oppStatus = new SoftAssert();
		String oppname1 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0),
				driver.findElement(lead.LeadTable));
		String oppname2 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0),
				driver.findElement(lead.LeadTable));
		String oppname3 = util.loopColumnFindName(excel.readFromExcel(10, 3, 0),
				driver.findElement(lead.LeadTable));
		oppStatus.assertEquals(oppname1, excel.readFromExcel(10, 1, 0));
		oppStatus.assertEquals(oppname2, excel.readFromExcel(10, 2, 0));
		oppStatus.assertEquals(oppname3, excel.readFromExcel(10, 3, 0));
		System.out.println("verifyLeadsInListngPagen value in the table are " + oppname1 + "" + oppname2 + ""
				+ oppname3);
		oppStatus.assertAll();
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
	@Test(priority=verifySearchInOpportunity)
	void verifySearchInOpportunity() throws IOException, InterruptedException {
		driver.navigate().refresh();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(10, 2, 0));
		System.out.println("Sendng values to search box");
		Thread.sleep(4000);
		String oppName1 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0),
				driver.findElement(lead.LeadTable));
		System.out.println("verifyLeadsInListngPagen value in the table are " + oppName1);
		String oppName2 = util.loopColumnFindName(excel.readFromExcel(10, 3, 0), driver.findElement(lead.LeadTable));
		System.out.println(oppName2);
		SoftAssert searchOpp = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(10, 2, 5));
		Thread.sleep(3000);
		driver.navigate().refresh();
		String oppByMobile = util.loopColumnFindName(
				excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
		searchOpp.assertEquals(oppByMobile, excel.readFromExcel(10, 2, 0));
		searchOpp.assertEquals(oppName1, excel.readFromExcel(10, 2, 0));
		searchOpp.assertNull(oppName2);
		searchOpp.assertAll();
		
	}
	
	@Test(priority=opportunityNameFieldvaldidation)
	void opportunityNameFieldvaldidation() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
		common.tabsOutValidationFieldType(lead.opportunityNameArry,
				oppentry.OpportunityName,
				oppentry.OpportunityNamevaldiation, 
				oppentry.opportunityValidationMessage);
		common.commonValidationFieldType(lead.opportunityNameArry,
				oppentry.OpportunityName,
				oppentry.OpportunityNamevaldiation, 
				oppentry.opportunityValidationMessage);
	}

	@Test(priority=amountFieldValdiation)
	void amountFieldValdiation() throws InterruptedException, IOException{
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
		common.tabsOutValidationFieldType(lead.amountArry,
				oppentry.Amount,
				oppentry.Amountvaldiation, 
				oppentry.amountValidationMessage);
		common.commonValidationFieldType(lead.amountArry,
				oppentry.Amount,
				oppentry.Amountvaldiation, 
				oppentry.amountValidationMessage);
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
						excel.readFromExcel(3, 1, 5),
						excel.readFromExcel(3, 2, 5),
						excel.readFromExcel(3, 3, 5),
						excel.readFromExcel(3, 4, 5), 
						excel.readFromExcel(3, 5, 5), 
						excel.readFromExcel(3, 6, 5));
			}
	
	
		/**
		 * Verify create page view after creating, columnSizeInCustomPage =
		 * actualColumnSize = Getting column size after redirecting to new custom
		 * page view allColumnNames = Getting all column header names
		 * 
		 * @throws IOException
		 * @throws InterruptedException
		 */
		@Test(priority=verifyCreatedPageViewOpportunity)
		void verifyCreatedPageViewOpportunity() throws IOException, InterruptedException {
			driver.navigate().refresh();
			 common.verifyCreatedPageView(
					 excel.readFromExcel(3, 1, 5),
					 excel.readFromExcel(3, 2, 5),
					 excel.readFromExcel(3, 3, 5), 
					 excel.readFromExcel(3, 4, 5));
			 SoftAssert verifyCreatedPageViewOpportunity = new SoftAssert ();
			 verifyCreatedPageViewOpportunity.assertEquals(common.firstColumn1, true);
			 verifyCreatedPageViewOpportunity.assertEquals(common.secondColumn1, true);
			 verifyCreatedPageViewOpportunity.assertEquals(common.fourthColumn1, true);
			 verifyCreatedPageViewOpportunity.assertEquals(common.fifthColumn1, true);
			 verifyCreatedPageViewOpportunity.assertAll ();
		
		}
	

		/**
		 * 
		 * @throws InterruptedException 
		 * @throws IOException 
		 * Verify Created page View in Ssaved Page View list 
		 */
		@Test(priority=verifyCustomViewInSavedPageViewsOpportunity)
		void verifyCustomViewInSavedPageViewsOpportunity() throws InterruptedException, IOException {
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
		@Test(priority=editCustomViewOpportunity)
		void editCustomViewOpportunity() throws IOException, InterruptedException {
			common.editCustomView(excel.readFromExcel(3, 0, 1),
					excel.readFromExcel(3, 2, 5), 
					excel.readFromExcel(3, 3, 5));

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

		@Test(priority=pageViewAfterEditOpportunity)
		void pageViewAfterEditOpportunity() throws IOException, InterruptedException {
			common.pageViewAfterEdit(excel.readFromExcel(3, 2, 5),
					excel.readFromExcel(3, 3, 5),
					excel.readFromExcel(3, 4, 5), 
					excel.readFromExcel(3, 5, 5));
			
			SoftAssert pageViewAfterEditOpportunity = new SoftAssert ();
			//After Editing check the columns are gets desabled 
			pageViewAfterEditOpportunity.assertEquals(common.enabledColumnEdit1Page1, true);
			pageViewAfterEditOpportunity.assertEquals(common.enabledColumnEditPage, true);
			pageViewAfterEditOpportunity.assertEquals(common.desabledColumn1EditPage, false);
			pageViewAfterEditOpportunity.assertEquals(common.desabledColumnEditPage, false);
			pageViewAfterEditOpportunity.assertAll ();

		}


		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 * Checking Create custom page view validation while entering same name which is already exist 
		 */
			@Test(priority=alreadyExistpageViewNameOpportunity)
			 void alreadyExistpageViewNameOpportunity() throws InterruptedException, IOException{
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
			@Test(priority=deletePageViewOpportunity)
			void deletePageViewOpportunity() throws InterruptedException, IOException {
				 common.deletePageView();
			}

			/**
			 * 
			 * @throws IOException
			 * @throws InterruptedException
			 */
			@Test(priority=verifyDeletdViewInSavedViewsOpportunity)
			 void verifyDeletdViewInSavedViewsOpportunity () throws IOException, InterruptedException{
				  common.verifyDeletdViewInSavedViews();
					
				}
			
			//Validation for create Page
			@Test(priority=validationCreatePageViewOpportunity)
		 void validationCreatePageViewOpportunity () throws IOException, InterruptedException{
			 common.validationCreatePageView();
			 SoftAssert validationCreatePageViewContacts = new SoftAssert ();
			 validationCreatePageViewContacts.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
			 validationCreatePageViewContacts.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
			 validationCreatePageViewContacts.assertAll();
		 }	
			
		
			 @Test(priority=opportunityManditiryTabsoutvalidation)
				void opportunityManditiryTabsoutvalidation() throws InterruptedException{
					SoftAssert opptabs = new SoftAssert ();
					util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
					Thread.sleep(3000);
					driver.findElement(oppentry.AccountName).click();
					//Tabs out with out entering Account name
					driver.findElement(oppentry.AccountName).sendKeys(Keys.TAB);
					String accountvalidationMessge = util.getValidationMessage(driver.findElement(oppentry.AccountNamevaldiation));
					opptabs.assertEquals(accountvalidationMessge, oppentry.accountNameValdiationMessage);
					driver.findElement(oppentry.OpportunityName).click();
					//Tabs out with out entering Account name
					driver.findElement(oppentry.OpportunityName).sendKeys(Keys.TAB);
					String oppNameValidation = util.getValidationMessage(driver.findElement(oppentry.OpportunityNamevaldiation));
					driver.findElement(oppentry.Amount).click();
					//Tabs out with out entering Account name
					driver.findElement(oppentry.Amount).sendKeys(Keys.TAB);
					String amountValidation = util.getValidationMessage(driver.findElement(oppentry.OpportunityNamevaldiation));
					opptabs.assertEquals(oppNameValidation, oppentry.opportunityValidationMessage);
					opptabs.assertEquals(accountvalidationMessge, oppentry.accountNameValdiationMessage);
					opptabs.assertEquals(amountValidation, oppentry.amountValidationMessage);
					opptabs.assertAll();	
				}
		     
			   //Checking common validation for the Account page 
			   @Test(priority=opportunityManditoryCommonValidation)
			   void opportunityManditoryCommonValidation() throws InterruptedException{
				   SoftAssert commonOpp = new SoftAssert();
				   util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
				   util.waitForElementAndClick(driver.findElement(oppentry.Save));
				   String accountvalidationMessge = util.getValidationMessage(driver.findElement(oppentry.AccountNamevaldiation));
					String oppNameValidation = util.getValidationMessage(driver.findElement(oppentry.OpportunityNamevaldiation));
					String amountValidation = util.getValidationMessage(driver.findElement(oppentry.OpportunityNamevaldiation));
					commonOpp.assertEquals(oppNameValidation, oppentry.opportunityValidationMessage);
					commonOpp.assertEquals(accountvalidationMessge, oppentry.accountNameValdiationMessage);
					commonOpp.assertEquals(amountValidation, oppentry.amountValidationMessage);
					commonOpp.assertAll();
			   }
		
			   /**
			    * 
			    * @throws InterruptedException
			    * Checking alert message while closing the window after entering the charectrets 
			    */
			   		@Test(priority=verifyAlertwhileClosing)
			   	void verifyAlertwhileClosing() throws InterruptedException {
			   		util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
			   		oppentry.opportunityCreate(10, 1);
			   		util.waitForElementAndClick(driver.findElement(oppentry.Cancel));
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
			   		util.waitForElementAndClick(driver.findElement(opplist.CreateNew));
			   		util.waitForElementAndClick(driver.findElement(oppentry.Cancel));
			   		boolean alert = util.isAlertPresent();
			   		Assert.assertFalse(alert);
			   		
			   	}
			    
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			   		/**
					 * 
					 * @throws InterruptedException
					 * @throws IOException
					 * Add log validation 
					 */
					@Test(priority=addLogValidationsListingOpportunity)
				void addLogValidationsListingOpportunity() throws InterruptedException, IOException {
						util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					common.addLogcallListing(excel.readFromExcel(10, 2, 0));
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
					common.addLogcallListing(excel.readFromExcel(10,2,0));
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
					 common.addLogErrorWhileClosing(excel.readFromExcel(10,2,0));
					
				 }
				 /**
				  * 
				  * @throws InterruptedException
				  * @throws IOException
				  */
				@Test(priority=addlogErroWithOutcharLog)
				 void addlogErroWithOutcharLog () throws InterruptedException, IOException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					 common.addlogErroWithOutchar(excel.readFromExcel(10,2,0));
				
				 }
				
				/**
				  * 
				  * @throws InterruptedException
				  * @throws IOException
				  */
				
				@Test(priority=logSubjecttabsOutValidation)
				 void logSubjecttabsOutValidation () throws InterruptedException, IOException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
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
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
						util.selectFromDropDownModal("Log Call",driver.findElement(lead.ActionMenuModel));
					 Thread.sleep(3000);
					 common.commonValidationFieldType(
							 lead.logSubjectArry,lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
				 }
				 
				
				
				@Test(priority=addNoteListing)
				void addNoteListing() throws InterruptedException, IOException {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					common.addNoteListing(excel.readFromExcel(10,2,0));
				}
				
				
				@Test(priority=addNotevalidationListingOpportunity)
				void addNotevalidationListingOpportunity() throws InterruptedException, IOException {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					common.addNotevalidationListing(excel.readFromExcel(10,2,0));
					SoftAssert addNotevalidationListingAccounts = new SoftAssert();
					addNotevalidationListingAccounts.assertEquals(common.noteSubjectvaldiatinListing, lead.addNoteFieldvaldiationMessage);
					addNotevalidationListingAccounts.assertEquals(common.addnoteCommonError, leadEntry.CommonValidationMEssage);
					addNotevalidationListingAccounts.assertAll();
				}

				@Test(priority=addNoteErrorWhileClosing)
				void addNoteErrorWhileClosingNote  () throws IOException, InterruptedException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					  common.addNoteErrorWhileClosing(excel.readFromExcel(10,2,0));
					 
					 }
				@Test(priority=addNoteErroWithOutchar)
					 void addNoteErroWithOutchar () throws InterruptedException, IOException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
			             common.addNoteErroWithOutchar(excel.readFromExcel(10,2,0));; 
					 }
				
				
				 /**
				  * 
				  * @throws InterruptedException
				  * @throws IOException
				  */
				 
				@Test(priority=noteSubjecttabsOutValidation)
				 void noteSubjecttabsOutValidation () throws InterruptedException, IOException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
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
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
						util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
						Thread.sleep(3000);
						 common.commonValidationFieldType(lead.logSubjectArry,lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
				 }
				
				EventEntry evententry = new EventEntry();

				@Test(priority=addEvent)
				void addEvent() throws InterruptedException, IOException {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					common.addEvent(excel.readFromExcel(10,2,0));
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
					common.tabsOutvalidationEvent(excel.readFromExcel(10,2,0));
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
					common.commonvalidationEvent(excel.readFromExcel(10,2,0));
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
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
						util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
						Thread.sleep(3000);
						 common.tabsOutValidationFieldType(lead.eventSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
				 }
				
				@Test(priority=EventSubjectCommonValidation)
				 void EventSubjectCommonValidation() throws InterruptedException, IOException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
						util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
						Thread.sleep(3000);
						common.commonValidationFieldType(lead.logSubjectArry,evententry.Sujbect, evententry.SubjectValidation, evententry.SubjectFieldvalError);
				 }
				 
				 
				 /**
				  * Call the tabsOutValidationFieldType  methos and pass Anonymous array
				  * @throws InterruptedException
				  * @throws IOException
				  */

				@Test(priority=EventLocationtabsOutValidation)
				 void EventLocationtabsOutValidation () throws InterruptedException, IOException{
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					 util.clickOnActions(excel.readFromExcel(10,2, 1), driver.findElement(lead.LeadTable), "More Action");
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
					 util.clickOnActions(excel.readFromExcel(10,2,0), driver.findElement(lead.LeadTable), "More Action");
						util.selectFromDropDownModal("Add Event",driver.findElement(lead.ActionMenuModel));
						Thread.sleep(3000);
						//create anonymous array to pass the one time value
						common.commonValidationFieldType(lead.eventLocationArry,evententry.Location, evententry.LocatinValdiationMessage,evententry.locationvalmessage);
				 } 
				 
				 
				@Test(priority=addAttachement)
				void addAttachement() throws InterruptedException, IOException {
					util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					 common.addAttachement(excel.readFromExcel(10,2,0), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
				}
			

		/*		@Test(priority=inlineEditInLeadTable)
				*//**
				 * 
				 * @throws IOException
				 * @throws InterruptedException
				 *//*
				void inlineEditInLeadTable() throws IOException, InterruptedException {
					Thread.sleep(3000);
					try {
						util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
						util.waitForElementAndClick(driver.findElement(lead.CreateCustomPageViewButton));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 4));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 2, 4));
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 4));// Enable
																														// Company
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 4));// Enable
																														// Assign
																														// to
						util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 4));// Enable
																														// Lead
																														// Status
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
						util.sendValue(driver.findElement(contactentry.Email), emailEdit);
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
						util.sendValue(driver.findElement(contactentry.MobileNumber), mobileNumberEdit);
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
				*/

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
					 common.inlineEditTabsOutValidation("Amount", 
							 excel.readFromExcel(10,2,0), new String [] {"alphebeitcal","@#$%^&*()","99225alpheNumeric"}, 
							 oppentry.Amount, 
							 oppentry.Amountvaldiation, oppentry.amountValidationMessage);
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
							 excel.readFromExcel(10,2,0), new String [] {"alphebeitcal","@#$%^&*-=+()","99225alpheNumeric"}, 
							 oppentry.Amount, 
							 oppentry.Amountvaldiation, oppentry.amountValidationMessage);
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
							 excel.readFromExcel(10,4,0), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
							 oppentry.OpportunityName, 
							 oppentry.OpportunityNamevaldiation, oppentry.opportunityValidationMessage);
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
							 excel.readFromExcel(10,4,0), new String [] {"","@#$%^&*()-=+","alphenu!@@$#_-=+%121232"}, 
							 oppentry.OpportunityName, 
							 oppentry.OpportunityNamevaldiation, oppentry.opportunityValidationMessage);
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
							
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy1),"Opportunity Name");
							Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
							  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(10,1,0));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  Thread.sleep(3000);
							  String leadname13 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
							  String leadname14 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname13);
							  verifyFilterContacts.assertNull(leadname14);
					
						 
							  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							
									  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Account Name");
									
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
							  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(10,1,3));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  String leadname2 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname2);
							  String leadname3 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname3);
					
				
							  Thread.sleep(3000);
							  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							 
						 util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Source");
								Thread.sleep(3000);
								  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
								  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(10,1,10));
								  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
								  String leadname4 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
								  String leadname5 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
								  verifyFilterContacts.assertNotNull(leadname4);
								  verifyFilterContacts.assertNull(leadname5);
						
						
							  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
									  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Assigned To");
								
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(10,1,5));
							  Thread.sleep(2000);
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  Thread.sleep(3000);
							  String leadname6 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname6);
							  String leadname7 = util.loopColumnFindName(excel.readFromExcel(10, 2, 1), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname7);
					
						
							  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							 
									  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Amount");
						
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
							  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(10,1,1));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  String leadname8 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname8);
							  String leadname9 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname9);
						
						 
						/*  
						  try {
							  util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
							  try{
									  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Mobile Number");
									}
									catch(Exception E){
										util.handleDropdown(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")), "Mobile Number");
									}
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
							  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(2,1,6));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  String leadname2 = util.loopColumnFindName(excel.readFromExcel(2, 1, 1) + " " + excel.readFromExcel(2, 1, 2), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname2);
							  String leadname3 = util.loopColumnFindName(excel.readFromExcel(2, 2, 1) + " " + excel.readFromExcel(2, 2, 2), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname2);
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
							  util.handleDropdown(driver.findElement(lead.FilterValueInputDropdown1), excel.readFromExcel(0,1,10));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  String leadname2 = util.loopColumnFindName(excel.readFromExcel(0, 1, 1) + " " + excel.readFromExcel(0, 1, 2), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname2);
							  String leadname3 = util.loopColumnFindName(excel.readFromExcel(0, 3, 1) + " " + excel.readFromExcel(0, 3, 2), driver.findElement(lead.LeadTable));
							  verifyFilterContacts.assertNotNull(leadname2);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 */

						  //AND and OR Condiion 
						  
						
									util.waitForElementAndClick(driver.findElement(lead.FilterEdit1));
									  util.handleDropdown(driver.findElement(lead.FilterFieldBy1), "Opportunity Name");
									
								Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator1), "Equal to");
							  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox1), excel.readFromExcel(10,1,0));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
							  util.waitForElementAndClick(driver.findElement(lead.FilterAddNewFilter));
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterANDOR), "OR");
							  util.handleDropdown(driver.findElement(lead.FilterFieldBy2), "Opportunity Name");
							  Thread.sleep(3000);
							  util.handleDropdown(driver.findElement(lead.FilterOperator2), "Equal to");
							  util.sendValue(driver.findElement(lead.FiltervalueInputtextBox2), excel.readFromExcel(10,2,0));
							  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
								  String leadname10 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
								  String leadname11 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
								  verifyFilterContacts.assertNotNull(leadname10);
								  verifyFilterContacts.assertNotNull(leadname11);
								  Thread.sleep(3000);
								  util.waitForElementAndClick(driver.findElement(lead.FilterEdit2));
								  Thread.sleep(3000);
								  util.handleDropdown(driver.findElement(lead.FilterANDOR), "AND");
								  Thread.sleep(3000);
								  util.waitForElementAndClick(driver.findElement(lead.FilterSaveButton));
								  String leadname15 = util.loopColumnFindName(excel.readFromExcel(10, 1, 0), driver.findElement(lead.LeadTable));
								  String leadname16 = util.loopColumnFindName(excel.readFromExcel(10, 2, 0), driver.findElement(lead.LeadTable));
								  verifyFilterContacts.assertNull(leadname15);
								  verifyFilterContacts.assertNull(leadname16);
							
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
					 * Redirecting to details page
					 * @throws IOException
					 * @throws InterruptedException
					 */
					
					@Test(priority=verifyRedirectionToDetailsPage)
					void verifyRedirectionToDetailsPage () throws IOException, InterruptedException{
						driver.navigate().refresh();
						 common.verifyRedirctionToDetilspage(excel.readFromExcel(10, 2, 0));
					}
					
					 /**
					  * 
					  * @throws IOException
					  * excel.readFromExcel(0, 1, 3) - reading the details from Excel sheet
					  */
					@Test(priority=verifyHeaderForDetails)
					 void verifyHeaderForDetails () throws IOException{
							 SoftAssert verifyHeaderForDetailsOppo = new SoftAssert ();
							 String oppNameInDeatis = util.getElementName(driver.findElement(oppdetails.AccountNameDetailsHeader));
							 String AccountNameDetails = util.getElementName(driver.findElement(oppdetails.AccountNameDetailsHeader));
							 String amount = util.getElementName(driver.findElement(oppdetails.AmountDetailsHeader));
							 String status = util.getElementName(driver.findElement(oppdetails.StatusDetailsHeader));
							 String assignedTo = util.getElementName(driver.findElement(oppdetails.AssignedToDetailsHeader));
							 verifyHeaderForDetailsOppo.assertEquals(oppNameInDeatis, excel.readFromExcel(10, 2, 0));
							 verifyHeaderForDetailsOppo.assertEquals(AccountNameDetails, excel.readFromExcel(10, 2, 3));
							 verifyHeaderForDetailsOppo.assertEquals(amount, excel.readFromExcel(10, 2, 1));
							 verifyHeaderForDetailsOppo.assertEquals(status, excel.readFromExcel(10, 2, 8));
							 verifyHeaderForDetailsOppo.assertEquals(assignedTo, excel.readFromExcel(10, 2, 5));
							 verifyHeaderForDetailsOppo.assertAll(); 
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
								//After Adding verify Event is added or note
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
