package Testcases;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePackage.DriverClass;
import Pages.ContactsEntry;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.PCUtility;
import Pages.TaskEntry;
import Pages.TaskListing;

public class TaskTest extends DriverClass{
	PCUtility util = new PCUtility ();
	LeadListing lead = new LeadListing();
	ExcelReader excel = new ExcelReader ();
	LeadEntry leadEntry = new LeadEntry();
	LeadDetails leadDetails = new LeadDetails ();
	LeadTest leadtest = new LeadTest ();
	TaskEntry taskentry = new TaskEntry();
	TaskListing tasklist = new TaskListing ();
	ContactsEntry contactentry = new ContactsEntry ();
	
	public final int createTask = 10;
	public final int refresh = 20;
	public final int addtaskvalidation = 30;
	public final int taskSubjecttabsvalidation = 31;
	public final int taskSubjectCommonvalidation = 32;
	public final int dailyReccurvaldiation = 33;
	public final int weeklyReccurValidation = 34;
	public final int monthlyReccurValidation = 35;
	public final int yearlyReccurvaldiation = 36;
	public final int verifySearch = 40;
	public final int createPageViewTask = 50;
	public final int verifyCreatedPageViewTask = 60;
	public final int verifyDefaultViewTask = 70;
	public final int verifyCustomViewInSavedPageViewsTask = 80;
	public final int editCustomViewContacts = 90;
	public final int pageViewAfterEditTask = 100;
	public final int addLogcallListing = 110;
	public final int addLogValidationsListingtask = 110;
	public final int addLogErrorWhileClosingLogtask = 120;
	public final int addlogErroWithOutcharLogTask = 130;
	public final int logSubjecttabsOutValidation = 131;
	public final int logSubjectCommonValidation = 132;
	
	public final int addNoteListing = 140;
	public final int noteSubjecttabsOutValidation = 141;
	public final int noteSubjectCommonValidation = 142;
	public final int addAttachement = 150;
	public final int inlineEditInLeadTable = 160;
	
	
	
	
	

	public boolean statusOfActionPopup;
	/**
	 * 
	 * @throws InterruptedException
	 */
	@BeforeMethod
	void thinkTime() throws InterruptedException{
		Thread.sleep(3000);
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
		
		
	}
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 * @throws ParseException
 */
	@Test(priority=createTask)
	void createTask () throws InterruptedException, IOException, ParseException{
		//util.login();
		Thread.sleep(3000);
		util.waitForElementAndClick(driver.findElement(tasklist.TaskMenu));
		Thread.sleep(4000);
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
		Thread.sleep(3000);
		taskentry.createTask(7, 1);
		statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
		util.waitForElementAndClick(driver.findElement(lead.SaveOptionInActionPopup));
		String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonValidation));
		Assert.assertEquals(sucessMessage, taskentry.taskSucessMessage);	
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

	@Test(priority=refresh)
	void refresh() throws IOException, InterruptedException {
		Thread.sleep(3000);
		
		String curentURl = driver.getCurrentUrl();
		util.switchToNewTab();
		util.switchbackToMainTab(1);
		driver.get(curentURl);
		Thread.sleep(3000);
		WebElement CreateButton = driver.findElement(tasklist.CreateNew);
		util.waitForElementAndClick(CreateButton);
		contactentry.contactsCreate(7, 2);
		util.waitForElementAndClick(driver.findElement(contactentry.Save));
		Thread.sleep(3000);
		util.switchbackToMainTab(0);
		util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
		String subjectAfterRefresh = util.loopColumnFindName(
				excel.readFromExcel(7, 1, 0) , driver.findElement(lead.LeadTable));
		Assert.assertEquals(subjectAfterRefresh, excel.readFromExcel(7, 1, 0));
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority=addtaskvalidation)
	void addtaskvalidation() throws InterruptedException{
		 try {
			 if (statusOfActionPopup==true){
				 driver.findElement(lead.CancelOptionActionPopup).click();
				 util.acceptAlert();
			 }
		 }
		 catch(Exception E){ 
		 }
			util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
			 driver.findElement(taskentry.Subject).click();
			 driver.findElement(taskentry.Subject).sendKeys(Keys.TAB);
			 String subjectValidation = util.getValidationMessage(driver.findElement(taskentry.SubjectValidation));
			 driver.findElement(taskentry.AssignTo).click();
			 driver.findElement(taskentry.AssignTo).sendKeys(Keys.TAB);
			 String assigneTo = util.getValidationMessage(driver.findElement(taskentry.AssignToValidation));
			 SoftAssert addtaskvalidation = new SoftAssert ();
			 util.waitForElementAndClick(driver.findElement(contactentry.Save));
			 addtaskvalidation.assertAll();
			 addtaskvalidation.assertEquals(subjectValidation, taskentry.SubjectvalidationMessage);
			 addtaskvalidation.assertEquals(assigneTo,taskentry.AssignToValdiationMessage);
			 addtaskvalidation.assertAll();
	}
    /**
     * 
     * @throws InterruptedException
     * @throws IOException
     */
	@Test(priority=taskSubjecttabsvalidation)
	 void taskSubjecttabsvalidation () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
			 Thread.sleep(3000);
			 common.tabsOutValidationFieldType(new String []{
					 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
						 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
						 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                             + "maximummaximummaximummaximummaximummaximummaximumma"
                              +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
			 },lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=taskSubjectCommonvalidation)
	 void taskSubjectCommonvalidation() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
		 Thread.sleep(3000);
		 common.commonValidationFieldType(
				 new String []{
						 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
							 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
							 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                                 + "maximummaximummaximummaximummaximummaximummaximumma"
                                  +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
				 },lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	/**
	 * 
	 * @throws NullPointerException
	 * @throws InterruptedException
	 */
	
	@Test(priority=dailyReccurvaldiation)
	void dailyReccurvaldiation() throws NullPointerException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
		common.operatorListvalidation(taskentry.FrequencyRecurring,
				taskentry.RepeatRecurring, 
				"Daily",
				"Every Day,Every Alternate Day,Custom");
	}
	/**
	 * 
	 * @throws NullPointerException
	 * @throws InterruptedException
	 */
	@Test(priority=weeklyReccurValidation)
	void weeklyReccurValidation() throws NullPointerException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
		common.operatorListvalidation(taskentry.FrequencyRecurring,
				taskentry.RepeatRecurring, "Weekly",
				"Every Week,Alternate Week,Custom");
		common.operatorListvalidation(taskentry.RepeatRecurring,
				taskentry.RepeatONRecurring, "Custom",
				"Monday,Tuesday,Wednesday,thursday,Friday,Saturday,Sunday");
	}
	
	/**
	 * 
	 * @throws NullPointerException
	 * @throws InterruptedException
	 */
	
	@Test(priority=monthlyReccurValidation)
	void monthlyReccurValidation() throws NullPointerException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
		common.operatorListvalidation(taskentry.FrequencyRecurring,
				taskentry.RepeatRecurring, "Monthly",
				"Every Month,Eventy Alternate Month,Custom");
		
		common.operatorListvalidation(taskentry.RepeatRecurring,
				taskentry.RepeatONRecurring, "Custom",
				"Monday,Tuesday,Wednesday,thursday,Friday,Saturday,Sunday");
		
	}
	/**
	 * 
	 * @throws NullPointerException
	 * @throws InterruptedException
	 */
	@Test(priority=yearlyReccurvaldiation)
	void yearlyReccurvaldiation() throws NullPointerException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(tasklist.CreateNew));
		common.operatorListvalidation(taskentry.FrequencyRecurring,
				taskentry.RepeatONRecurring, "Yearly",
				"Every Month,Eventy Alternate Month,Custom");
	}
	
	
	
	
	/**
	 * Verify Search 
	 * excel.readFromExcel(1, 1, 1)  = Read from excel sheet  = @param Sheet Number, Row number and Column number 
	 * waitForElementAndClick  = Wait for the element and click once element is displayed
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	@Test(priority=verifySearch)
	 void verifySearch () throws IOException, InterruptedException{
		SoftAssert search = new SoftAssert ();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(7, 1, 0));
		Thread.sleep(4000);
		String leadname = util.loopColumnFindName(excel.readFromExcel(7, 1, 0), driver.findElement(lead.LeadTable));
		System.out.println("testArun"+excel.readFromExcel(7, 1, 0) );
		System.out.println("verifyLeadsInListngPagen value in the table are " + leadname);
		String leadname2 = util.loopColumnFindName(excel.readFromExcel(7, 2, 0), driver.findElement(lead.LeadTable));
		search.assertEquals(leadname, excel.readFromExcel(7, 1, 0));
		search.assertNull(leadname2);		
		driver.navigate().refresh();
		util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
		util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(7, 1, 4));
		String leadnameByMobile = util.loopColumnFindName(excel.readFromExcel(7, 1, 0), driver.findElement(lead.LeadTable));
		search.assertEquals(leadnameByMobile, excel.readFromExcel(7, 1, 0));
		driver.navigate().refresh();
		util.sendValue(driver.findElement(lead.SearchbarOption), "Contacted");
		Thread.sleep(4000);
		driver.navigate().refresh();
		//TO DO LOGIC
		String statusContacted = util.loopColumnFindName("Contacted", driver.findElement(lead.LeadTable));
		String statusContacted1 = util.loopColumnFindName("New", driver.findElement(lead.LeadTable));
		String statusContacted2 = util.loopColumnFindName("Not Contacted", driver.findElement(lead.LeadTable));
		search.assertEquals(statusContacted, "Contacted");
		search.assertNull(statusContacted1);
		search.assertNull(statusContacted2);
		search.assertAll();
		
	}
	 
	/**
	 * 
	 */
	 CommonFeature common = new CommonFeature();
	 @Test(priority=createPageViewTask)
	 void createPageViewTask () throws IOException, InterruptedException{
			common.createPageView( excel.readFromExcel(3, 1, 3), 
					excel.readFromExcel(3, 2, 3),
					excel.readFromExcel(3, 3, 3),
					excel.readFromExcel(3, 4, 3), 
					excel.readFromExcel(3, 5, 3),
					excel.readFromExcel(3, 6, 3));
			
		}
	 
	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority=verifyCreatedPageViewTask)
	 void verifyCreatedPageViewTask() throws IOException, InterruptedException {
		 common.verifyCreatedPageView(
				 excel.readFromExcel(3, 2, 3),
				 excel.readFromExcel(3, 2, 3),
				 excel.readFromExcel(3, 3, 3), 
				 excel.readFromExcel(3, 4, 3));
		 SoftAssert verifyCreatedPageViewTask = new SoftAssert ();
		 verifyCreatedPageViewTask.assertEquals(common.firstColumn1, true);
		 verifyCreatedPageViewTask.assertEquals(common.thirdColumn1, true);
		 verifyCreatedPageViewTask.assertEquals(common.fourthColumn1, true);
		 verifyCreatedPageViewTask.assertEquals(common.fifthColumn1, true);
		 verifyCreatedPageViewTask.assertAll ();
	
	}
	 
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 @Test(priority=verifyDefaultViewTask)
	 void verifyDefaultViewTask() throws InterruptedException, IOException {
			util.tableHeader();
			int actualColumnSize = util.actaulHeaderSize;
			int expectedColumn = 9;
			SoftAssert verifyDefaultViewTask = new SoftAssert();
			List<String> allColumnNames = util.tableHeader();
			System.out.println(allColumnNames);
			boolean contactName = allColumnNames.contains("Contact Name");
			boolean accountName = allColumnNames.contains(excel.readFromExcel(3, 1, 3));
			boolean customerID = allColumnNames.contains(excel.readFromExcel(3, 2, 3));
			boolean email = allColumnNames.contains(excel.readFromExcel(3, 3, 3));
			boolean asignTo = allColumnNames.contains(excel.readFromExcel(3, 4, 3));
			boolean desgigantion = allColumnNames.contains(excel.readFromExcel(3, 5, 3));
			boolean createdDate = allColumnNames.contains(excel.readFromExcel(3, 6, 3));
			boolean officephone = allColumnNames.contains(excel.readFromExcel(3, 7, 3));
			boolean state = allColumnNames.contains(excel.readFromExcel(3, 8, 3));
			verifyDefaultViewTask.assertEquals(accountName, true);
			verifyDefaultViewTask.assertEquals(asignTo, true);
			verifyDefaultViewTask.assertEquals(email, true);
			verifyDefaultViewTask.assertEquals(customerID, true);
			verifyDefaultViewTask.assertEquals(desgigantion, true);
			verifyDefaultViewTask.assertEquals(createdDate, true);
			verifyDefaultViewTask.assertEquals(officephone, true);
			verifyDefaultViewTask.assertEquals(state, true);
			verifyDefaultViewTask.assertAll();
			Thread.sleep(3000);

		}

	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 @Test(priority=verifyCustomViewInSavedPageViewsTask)
	 void verifyCustomViewInSavedPageViewsTask() throws InterruptedException, IOException {
			common.verifyCustomViewInSavedPageViews();
		}

	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority=editCustomViewContacts)
	 void editCustomViewContacts() throws IOException, InterruptedException {
			common.editCustomView(excel.readFromExcel(3, 0, 1),
					excel.readFromExcel(3, 4, 3), 
					excel.readFromExcel(3, 5, 3));

		}
	 
	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority=pageViewAfterEditTask)
		void pageViewAfterEditTask() throws IOException, InterruptedException {
			common.pageViewAfterEdit(excel.readFromExcel(3, 1, 3),
					excel.readFromExcel(3, 2, 3),
					excel.readFromExcel(3, 4, 3), 
					excel.readFromExcel(3, 5, 3));
			
			SoftAssert pageViewAfterEditTask = new SoftAssert ();
			pageViewAfterEditTask.assertEquals(common.enabledColumnEdit1Page1, true);
			pageViewAfterEditTask.assertEquals(common.enabledColumnEditPage, true);
			pageViewAfterEditTask.assertEquals(common.desabledColumn1EditPage, false);
			pageViewAfterEditTask.assertEquals(common.desabledColumnEditPage, false);
			pageViewAfterEditTask.assertAll ();

		}
      /**
       * 
       * @throws InterruptedException
       * @throws IOException
       */
	 void alReadyExistPageViewValidation() throws InterruptedException, IOException{
		 leadtest.alreadyExistpageViewName();
	 }
	 
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 void deletePageView() throws InterruptedException, IOException{
		 common.deletePageView();
	 }
	 
	 void deletePageViewInSavedPage() throws IOException, InterruptedException{
		  common.verifyDeletdViewInSavedViews();
	 }
	 
	 void validationCreatePageViewTask ()throws IOException, InterruptedException{
			 common.validationCreatePageView();
			 SoftAssert validationCreatePageViewTask = new SoftAssert ();
			 validationCreatePageViewTask.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "This field is required");
			 validationCreatePageViewTask.assertEquals(util.getValidationMessage(driver.findElement(lead.ValidationMessage)), "Please select at least one column to create");
			 validationCreatePageViewTask.assertAll();
		 }

	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority=addLogcallListing)
	 void addLogcallListing () throws IOException, InterruptedException{
		common.addLogcallListing(excel.readFromExcel(7, 1, 0));
	}
	 
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 
	 @Test(priority=addLogValidationsListingtask)
	 void addLogValidationsListing () throws InterruptedException, IOException{
			common.addLogcallListing(excel.readFromExcel(7, 1, 0));
			SoftAssert addLogValidationsListingtask = new SoftAssert();
			addLogValidationsListingtask.assertEquals(common.tabsOutvalidationMsgforLogs, lead.addLogFieldvaldiationMessage);
			addLogValidationsListingtask.assertEquals(common.addlogCommonError, leadEntry.CommonValidationMEssage);

		}
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	
	@Test(priority=logSubjecttabsOutValidation)
	 void logSubjecttabsOutValidation () throws InterruptedException, IOException{
		 util.clickOnActions(excel.readFromExcel(7, 1, 0), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Log a Call",driver.findElement(lead.ActionMenuModel));
			 Thread.sleep(3000);
			 common.tabsOutValidationFieldType(new String []{
					 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
						 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
						 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                              + "maximummaximummaximummaximummaximummaximummaximumma"
                               +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
			 },lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	@Test(priority=logSubjectCommonValidation)
	 void logSubjectCommonValidation() throws InterruptedException, IOException{
		 util.clickOnActions(excel.readFromExcel(7, 1, 0), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Log a Call",driver.findElement(lead.ActionMenuModel));
		 Thread.sleep(3000);
		 common.commonValidationFieldType(
				 new String []{
						 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
							 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
							 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                                  + "maximummaximummaximummaximummaximummaximummaximumma"
                                   +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
				 },lead.SubjectLogCall, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 } 
	 
	@Test(priority=noteSubjecttabsOutValidation)
	 void noteSubjecttabsOutValidation () throws InterruptedException, IOException{
		 util.clickOnActions(excel.readFromExcel(7, 1, 0), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			Thread.sleep(3000);
			 common.tabsOutValidationFieldType(new String []{
					 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
						 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
						 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                             + "maximummaximummaximummaximummaximummaximummaximumma"
                              +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
			 },lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 
	@Test(priority=noteSubjectCommonValidation)
	 void noteSubjectCommonValidation() throws InterruptedException, IOException{
		 util.clickOnActions(excel.readFromExcel(7, 1, 0), driver.findElement(lead.LeadTable), "More Action");
			util.selectFromDropDownModal("Add Note",driver.findElement(lead.ActionMenuModel));
			Thread.sleep(3000);
			 common.commonValidationFieldType(new String []{
					 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
						 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
						 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                             + "maximummaximummaximummaximummaximummaximummaximumma"
                              +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
			 },lead.SubjectNote, lead.ValidationMessage, lead.addLogFieldvaldiationMessage);
	 }
	 
     /**
      * 
      * @throws IOException
      * @throws InterruptedException
      */
		@Test(priority=addLogErrorWhileClosingLogtask)
		 void addLogErrorWhileClosing  () throws IOException, InterruptedException{
			 common.addLogErrorWhileClosing(excel.readFromExcel(7, 1, 0));
			
		 }
		
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		@Test(priority=addlogErroWithOutcharLogTask)
		 void addlogErroWithOutcharLog () throws InterruptedException, IOException{
			 common.addlogErroWithOutchar(excel.readFromExcel(7, 1, 0));
		
		 }
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 @Test(priority=addNoteListing)
	 void addNoteListing() throws InterruptedException, IOException{
		common.addNoteListing(excel.readFromExcel(7, 1, 0));
	}
	
	 /**
	  * 
	  * @throws InterruptedException
	  * @throws IOException
	  */
	 @Test(priority=addAttachement)
		void addAttachement () throws InterruptedException, IOException{
			common.addAttachement(excel.readFromExcel(7, 1, 0), "C:\\Users\\nichiuser\\Desktop\\Autoite\\import.csv");
			
	 }

	 /**
	  * 
	  * @throws IOException
	  * @throws InterruptedException
	  */
	 @Test(priority=inlineEditInLeadTable)
		void inlineEditInLeadTable () throws IOException, InterruptedException{
			driver.navigate().refresh();
			  Thread.sleep(3000);
			  try {
				util.waitForElementAndClick(driver.findElement(lead.CustompageOption));
				  util.selectFromDropDownModal("Create View",driver.findElement(lead.CustomViewModel));
				  util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 1, 2));
				  util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 2, 2));
				 util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 3, 2));//Enable Company
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 4, 2));//Enable Assign to
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3, 5, 2));//Enable Lead Status
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
					util.enableToggle(driver.findElement(lead.ColumnSelectionBox), excel.readFromExcel(3,16, 2));
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
			  SoftAssert inlineEditInLeadTable = new SoftAssert ();
			  try{
			 Thread.sleep(3000);
		      String companyName  = util.getColumndata("Account Name", excel.readFromExcel(2, 2, 1));
		      String companyNameEdit = companyName +" "+ "Edited";
			  util.inlineEditInTable("Account Name", excel.readFromExcel(2, 2, 1));
			  util.sendValue(driver.findElement(contactentry.Accountname), companyNameEdit);
			  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
			  String companyNameAfterEdit  = util.getColumndata("Company", excel.readFromExcel(2, 2, 1));
			  Thread.sleep(3000);
			  inlineEditInLeadTable.assertNotEquals(companyName, companyNameAfterEdit);
			  }
			  catch (Exception E){
				
					  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
					  util.acceptUnExpectedError();
					  
				
			  }
			  try {
				 String departMennt = util.getColumndata("Department", excel.readFromExcel(2, 2, 1));
				 String designationEdit = departMennt +" "+"Edited";
				util.inlineEditInTable("Department", excel.readFromExcel(2, 2, 1));
				  util.sendValue(driver.findElement(contactentry.Department), designationEdit);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(4000);
				  String designationAfterEdit = util.getColumndata("Designation", excel.readFromExcel(2, 2, 1));
				  inlineEditInLeadTable.assertNotEquals(departMennt, designationAfterEdit);
			} catch (Exception e) {
				
					
						  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
						  util.acceptUnExpectedError();
					
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
						  util.acceptUnExpectedError();
					
			}
			  try {
				  String email = util.getColumndata("Email", excel.readFromExcel(0, 1, 1));
				util.inlineEditInTable("Email", excel.readFromExcel(0, 1, 1));
				  util.sendValue(driver.findElement(contactentry.Email), emailEdit);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(3000);
				  String emailAfterEdit = util.getColumndata("Email", excel.readFromExcel(0, 1, 1));
				  inlineEditInLeadTable.assertNotEquals(email, emailAfterEdit);
			} catch (Exception e) {
			
						  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
						  util.acceptUnExpectedError();
				
			}
			  try {
				  String AssignTo = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
				util.inlineEditInTable("Assigned To", excel.readFromExcel(0, 1, 1));
				  util.handleDropDownByIndex(driver.findElement(contactentry.AssignTo), 3);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(3000);
				  String AssignToAfterEdit = util.getColumndata("Assigned To", excel.readFromExcel(0, 1, 1));
				  inlineEditInLeadTable.assertNotEquals(AssignTo, AssignToAfterEdit);
			} catch (Exception e) {
				
					 
						  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));
						  util.acceptUnExpectedError();
					
			}
			  
			  try {
				  String mobileNumber = util.getColumndata("Mobile Number", excel.readFromExcel(0, 1, 1));
				  String mobileNumberEdit = mobileNumber +" "+"02";
				util.inlineEditInTable("Mobile Number", excel.readFromExcel(0, 1, 1));
				  util.sendValue(driver.findElement(contactentry.MobileNumber), mobileNumberEdit);
				  util.waitForElementAndClick(driver.findElement(lead.InlineEditSaveButtonTable));
				  Thread.sleep(3000);
				  String mobileNumberAfterEdit = util.getColumndata("Mobile Number", excel.readFromExcel(0, 1, 1));
				  inlineEditInLeadTable.assertNotEquals(mobileNumber, mobileNumberAfterEdit);
			} catch (Exception e) {
			
						  util.waitForElementAndClick(driver.findElement(lead.RefreshOption));	
						  util.acceptUnExpectedError();
					 
			}
			  util.acceptUnExpectedError();
		  inlineEditInLeadTable.assertAll();
		  
		}
		
      
	 
	
	
}
