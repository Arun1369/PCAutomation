package Testcases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.CalendarPC;
import Pages.EventEntry;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.PCUtility;
import junit.framework.Assert;

@Listeners(ListenersClass.class)

public class  LeadTestSuite extends DriverClass{
	LeadTest leadtest = new LeadTest();
	LeadListing leadListing = new LeadListing ();
	ExcelReader excel = new ExcelReader();
	LeadDetails leadDetails = new LeadDetails();
	LeadEntry entry = new LeadEntry ();
	PCUtility util = new PCUtility();
	BulkLeads bulk = new BulkLeads ();
	public ITestResult result;
	public String executionStatus;
	public String PASS;
	private String FAIL;
	public static int column = 0;
	CalendarPC calendar = new CalendarPC();
	Logger logger;
	StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
	/**
	 * All Lead Test cases from "LeadTest.java" will call here and run it as test suite for abstraction 
	 * @throws InterruptedException
	 */
	
	
	//PropertyConfigurator.("Log.properties");
	
	@BeforeMethod
	void thinkTime() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(3000);
		 try {
			 if (leadtest.statusOfActionPopup==true){
				 try{
				 driver.findElement(leadListing.CancelOptionActionPopup).click();
				 }
				 catch(Exception d){
					 
				 }
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

	/*@AfterMethod
	void updateTestStatus(){
		String testStatus =ListenersClass.status;
		excel.readFromExcel(sheetNo, row, );
	}*/
	
	LeadEntry leadentry = new LeadEntry();
	//private By element1;
	//private By element;
	
	@Test (priority =1)
	 void login() throws InterruptedException, IOException, ParseException{
		//leadtest.login();	
	util.waitForElementAndClick(driver.findElement(By.xpath("html/body/div[1]/div/div[2]/aside[1]/div/nav/ul/li[3]/a/span/span")));
	Thread.sleep(3000);

	
	}

public int pageCount;
	CommonFeature common = new CommonFeature();
	@Test (priority =70)
	 void tabsvalidationOutInvalidEmailID() throws InterruptedException, IOException{
          leadtest.invalidemailTabsOutValidationlead();
	}
	@Test (priority =60)
	void commonValidationOutInvalidEmailID() throws InterruptedException, IOException{
         leadtest.invalidemailCommonValidationlead();
	}
	
	@Test (priority =80)
	void tabsValidationOutInvalidweSite() throws InterruptedException, IOException{
         leadtest.webSiteTabsvaldiationError();
	}
	
	@Test (priority =90)
	void commonValidationOutInvalidweSite() throws InterruptedException, IOException{
         leadtest.webSiteCommonvaldiationError();
	}
	
	@Test (priority =100)
	void atabsOutmaxiMumCharvalidationError() throws InterruptedException{
	    leadtest.tabsOutmaxCharValidationLead();
	}

	
	@Test (priority =110)
	void commoNmaxiMumCharvalidationError() throws InterruptedException{
	    leadtest.commonMaxCharExceedvalidation();
	}
  
/*	@Test (priority =120)
	void fieldTypevaldiationError() throws InterruptedException{
	    leadtest.fiedTypevalidationTabs();
	}
	

	@Test (priority =130)
	void fieldTypevaldiationErrorCommon() throws InterruptedException{
	    leadtest.fieldTypeCommonValidationError();
	}*/
	
	@Test (priority =120)
	void firstNamefieldvalidationIn() throws InterruptedException, IOException{
		leadtest.firstNamefieldvalidationIn();
	}
	@Test (priority =121)
	void lastNameFieldvaldidation() throws InterruptedException, IOException{
		leadtest.lastNameFieldvaldidation();
	}
	@Test (priority =122)
	void designationFieldvalidation() throws InterruptedException, IOException{
		leadtest.designationFieldvalidation();
	}
	@Test (priority =123)
	void departmentFiedlvalidationError() throws InterruptedException, IOException{
		leadtest.companyValidation();
	}
	@Test (priority =124)
	void officeNumberFieldvalidation() throws InterruptedException, IOException{
		leadtest.officeNumberFieldvalidation();
	}
	@Test (priority =125)
	void mobileNumberFieldValdiation() throws InterruptedException, IOException{
		leadtest.mobileNumberFieldValdiation();
	}
	@Test (priority =126)
	void postCodeFieldValidation() throws InterruptedException, IOException{
		leadtest.postCodeFieldValidation();
		
	}
	
	@Test (priority =20)
	void refresh () throws IOException, InterruptedException{
		leadtest.refresh();
		
		
	}
	
	@Test (priority =25)
	void createLead () throws InterruptedException, IOException{
		leadtest.createLead();
		
		
	}
	@Test (priority =30)
	void saveandNew () throws InterruptedException, IOException{
		leadtest.saveAndNew();
		
	}
	
	@Test (priority =40)
	void verifyLeadsInListngPage () throws IOException, InterruptedException{
		leadtest.verifyLeadsInListngPage();
	}
	
	@Test (priority =50)
	void verifySearch () throws IOException, InterruptedException{
		driver.navigate().refresh();
		leadtest.verifySearch();
	}
	 
	@Test (priority =150)
	void tabsOutvalidation() throws InterruptedException{
		leadtest.tabsValidationlead();
	}
	
	@Test (priority =140)
	void commonvalidation() throws InterruptedException{
		leadtest.commonValdiationError();
	}
	
	void stateValidation() throws InterruptedException{
		leadtest.statevalidationWithOutCountry();
	}
	
	
	
	@Test (priority =160)
	void verifyDefaultView () throws InterruptedException, IOException{
		driver.navigate().refresh();	
		leadtest.verifyDefaultView();
	}
	
	@Test (priority =170)
	void verifyDefaultEnabledColumn () throws InterruptedException{
		leadtest.verifyDefaultEnabledColumn();
	}
	
	@Test (priority =180)
	void createPageView () throws IOException, InterruptedException{
		leadtest.createPageView();
	}
	
	@Test (priority =190)
	void verifyCreatedPageView () throws IOException, InterruptedException{
		leadtest.verifyCreatedPageView();
	}
	
	@Test (priority =200)
	void verifyCustomViewInSavedPageViews () throws InterruptedException, IOException{
		leadtest.verifyCustomViewInSavedPageViews();
	}
	
	@Test (priority =210)
	void isSelecetdPageView (){
		leadtest.isSelecetdPageView();
	}
	
	@Test (priority =220)
	void editCustomView () throws IOException, InterruptedException{
		leadtest.editCustomView();
	}
	
	@Test (priority =230)
	void pageViewAfterEdit () throws IOException, InterruptedException{
		leadtest.pageViewAfterEdit();
	}
	
	@Test (priority =240)
	void pageViewInSavedPageAfterEdit () throws IOException, InterruptedException{
		leadtest.pageViewInSavedPageAfterEdit();
	}
	
	@Test (priority =250)
	void deletePageView () throws InterruptedException, IOException{
		leadtest.deletePageView();
	}
	
	@Test (priority =260)
	void verifyDeletdViewInSavedViews () throws IOException, InterruptedException{
		leadtest.verifyDeletdViewInSavedViews();
	}
	
	@Test (priority =270)
	void avalidationCreatePageView () throws IOException, InterruptedException{
		leadtest.validationCreatePageView();
	}
	@Test (priority =280)
	void pageViewnameAlreadyExist() throws InterruptedException, IOException{
		leadtest.alreadyExistpageViewName();
	}
	//Verify the alert message 
	@Test (priority =290)
	void verifyAlertWhileCancel () throws InterruptedException{
		
		leadtest.verifyAlertwhileClosing();
	}
	
	@Test (priority =300)
	void verityAlertWithOutChange () throws InterruptedException{
		leadtest.verifyAlertWithoutChange();
	}
	
	@Test (priority =310)
	void verifyReset () throws IOException, InterruptedException{
		String values =  leadtest.beforeReset().toString();
		System.out.println("values after reset is "+values);
		String regularExpession = "^[a-zA-Z]+$";
		boolean statusAfterReset = util.regulaExpressionChecks(regularExpession,values);
		util.waitForElementAndClick(driver.findElement(entry.CancelButton));
		Assert.assertFalse(statusAfterReset);
		util.acceptAlert();
	}
	
	//@Test (priority =23)
	void verifySaveNew () throws InterruptedException{
		
	}
	
	@Test (priority =320)
	 void addLogCall() throws InterruptedException, IOException, ParseException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addLogcallListing();
	}
	@Test (priority =330)
	void addLogValdiationListing () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addLogValidationsListing();
	}
	
	@Test (priority =340)
	void addLogErrorWhileCancel () throws IOException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addLogErrorWhileClosing();
	}
	@Test (priority =350)
	void addLogErrorWithOutChar () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addlogErroWithOutchar();
	}
	@Test (priority =351)
	void logTabsvalidationWithFieldType() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.logSubjecttabsOutValidation();
	}
	
	@Test (priority =352)
	void logCommonvalidationwithFieldType() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.logSubjectCommonValidation();
	}
	@Test (priority =360)
	 void addNoteListing() throws InterruptedException, IOException, ParseException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addNoteListing();
	}
	@Test (priority =370)
	void addNoteValdiationListing () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addNotevalidationListing();
	}
	
	@Test (priority =380)
	void addNoteErrorWhileCancel () throws IOException, InterruptedException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addNoteErrorWhileClosing();
	}
	@Test (priority =390)
	void addNoteErrorWithOutChar () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addNoteErroWithOutchar();
	}
	@Test (priority =391)
	void addNoteTabsOutvalidationFieldType() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.noteSubjecttabsOutValidation();
		
	}
	
	@Test (priority =392)
	void addNoteCommonOutvalidationFieldType() throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.noteSubjectCommonValidation();
	}
	@Test (priority =400)
	void addEvent () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addEvent();
	}

	@Test (priority =410) 
	void tabsOutvaldiationEvent () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.tabsOutvalidationEvent();
	}
	
	@Test (priority =420) 
	void commonvalidationEvent () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.commonvalidationEvent();
	}
	
	@Test (priority =430) 
	void alertWhileClosing () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addEventAlertWhileClosng();
	}
	@Test (priority =431) 
	void eventSubjecttabsvalidationError () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.EventSubjecttabsOutValidation();
	}
	@Test (priority =432) 
	void eventSubjectCommonvalidationError () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.EventSubjectCommonValidation();
	}
	@Test (priority =433) 
	void locationEventCommonvalidationError () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.EventLocationtabsOutValidation();
	}
	@Test (priority =434) 
	void locationEventtabsvalidationError () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.EventLocationCommonValidation();
	}
	
	@Test (priority =440) 
	void addAttachment () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.addAttachement();
	}
	@Test (priority =450) 
	void commonValidationAttachment () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		leadtest.attachmentCommonvalidation();
	}

	@Test (priority =451)
	void discardInlineEdit () throws InterruptedException, IOException{
		leadtest.discardInlineEdit();
	}
	
	@Test (priority =460)
	void inlineEditTable () throws InterruptedException, IOException{
		
		leadtest.inlineEditInLeadTable();
	}
	
	@Test (priority =470)
	void editFromListingpage () throws IOException, InterruptedException{
		util.acceptUnExpectedError();
		leadtest.editFromLiStingPage();
	}
	
	@Test (priority =471)
	void emailInlineEditTabsOutalidation() throws InterruptedException, IOException{
		leadtest.emailInlineEditTabsOutalidation();
	}
	@Test (priority =472)
	void emailInlneEditCommonValidation() throws InterruptedException, IOException{
		leadtest.emailInlneEditCommonValidation();
	}
	
	@Test (priority =473)
	void webSiteInlinetabsOutValidationError () throws InterruptedException, IOException{
		leadtest.webSiteInlinetabsOutValidationError();
	}
	
	@Test (priority =474)
	void webSiteInlineEditCommonvalidationError() throws InterruptedException, IOException{
		leadtest.webSiteInlineEditCommonvalidationError();
	}
	
	@Test (priority =475)
	void inlineTabsNumericalNumbervalidation() throws InterruptedException, IOException{
		leadtest.inlineTabsNumericalNumbervalidation();
	}
	
	void inlineCommonNumericalNumbervaldation() throws InterruptedException, IOException{
		leadtest.inlineCommonNumericalNumbervaldation();
	}
	@Test (priority =476)
	void inlineEditTabsOutValidationForAlphenumeric() throws InterruptedException, IOException{
		leadtest.inlineEditTabsOutValidationForAlphenumeric();
	}
	@Test (priority =477)
	void inlineEditCommovalidationForAlphanumeric() throws InterruptedException, IOException{
		leadtest.inlineEditCommovalidationForAlphanumeric();
	}
	@Test (priority =478)
	void inlineEditTabOutTextFieldvalidation () throws InterruptedException, IOException{
		leadtest.inlineEditTabOutTextFieldvalidation();
	}
	@Test (priority =479)
	 void inlineEditCommonTextieldValidation() throws InterruptedException, IOException{
		 leadtest.inlineEditCommonTextieldValidation();
	 }

	@Test (priority =480)
	void changeOwner () throws InterruptedException, IOException{
		//
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		 util.acceptUnExpectedError();
		leadtest.changeOwner();
	}
	
	@Test (priority =490)
	void latestleadPosition () throws IOException{
		leadtest.verifylateastLead();
	}
	@Test (priority =500)
	void addTaskinListing() throws InterruptedException, IOException{
		leadtest.addtask();
	}
	
	@Test (priority =510)
	void importLead () throws IOException, InterruptedException{
		leadtest.importLead();
	}
	
	@Test (priority =520)
	void verifyaddNoteAllUsers () throws InterruptedException, IOException{
		util.waitForElementAndClick(driver.findElement(leadListing.LeadMenu));
		leadtest.addNoteForAll();
	}
	
	@Test (priority =530) 
	void changeOwnerForAllLead() throws InterruptedException, IOException{
		leadtest.changeOwnerforAllLeads();
	}
	@Test (priority =540) 
	void filter () throws IOException, InterruptedException{
		leadtest.verifyFilter();
	}
	@Test (priority =541) 
	void statevalidation() throws InterruptedException{
		driver.navigate().refresh();
		util.waitForElementAndClick(driver.findElement(leadListing.FilterOption));
		leadtest.statevalidationWithOutCountry();
	}
	@Test (priority =542) 
	void firstNameOpertorsvaldiation () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(leadListing.FilterOption));
		leadtest.firstNameOperators();
	}
	@Test (priority =543) 
	void leadConvertedOpertorsvaldiation () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		util.waitForElementAndClick(driver.findElement(leadListing.FilterOption));
		leadtest.leadConvertedOperators();
	}
	
	@Test (priority =544) 
	void leadCreatedOpertorsvaldiation () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		util.waitForElementAndClick(driver.findElement(leadListing.FilterOption));
		leadtest.leadCreatedOperators();
	}
	
	@Test (priority =545) 
	void assignedOpertorsvaldiation () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(leadListing.RefreshOption));
		util.waitForElementAndClick(driver.findElement(leadListing.FilterOption));
		leadtest.assignToOpertor();
	}
	
	@Test (priority =546) 
	void checkFilterByValues () throws InterruptedException{
		leadtest.checkFilterByValues();
	}
	@Test (priority =550) 
	void verifyRedirectionToDetailsPage () throws IOException, InterruptedException{
		driver.navigate().refresh();
		leadtest.verifyRedirctionToDetilspage();
	}
	@Test (priority =560) 
	void verifyHeaderInDetails() throws IOException{
		leadtest.verifyHeaderForDetails();
	}
	
	@Test (priority =570) 
	void addLogInDetails() throws IOException, InterruptedException{
		leadtest.addLogcallDetails();
	}
	
	@Test (priority =580) 
	void addLogValidationDetails () throws InterruptedException, IOException{
		leadtest.addLogValidationsDetails();
	}
	
	@Test (priority =590) 
	void verifyLogInLogtable () throws IOException{
		leadtest.verifyLogcallInDetailsPage();
	}
	@Test (priority =591) 
	void addLogtabsOutvalidationInDetail() throws InterruptedException, IOException{
		leadtest.logSubjectTabOutValidationDetails();
	}
	@Test (priority =592) 
	void addlogCommonValidationDetails() throws InterruptedException, IOException{
		leadtest.logSubjectCommonvalidationDetails();
	}
	@Test (priority =593)
	void deleteLogCallFromDetail() throws InterruptedException, IOException{
		leadtest.deleteLogCallFromActivityTable();
	}
	
	@Test (priority =594)
	void editLogCallFromDetailsPage() throws InterruptedException, IOException{
		leadtest.editLogCallFrometails();
	}
	
	
	
	@Test (priority =600)
	void addNoteInDetails () throws InterruptedException, IOException{
		leadtest.addNoteInDetails();
	}
	
	@Test (priority =610)
	void addNotevalidationInDetails () throws InterruptedException, IOException{
		leadtest.addNotevalidationDetails();
	}
	
	@Test (priority =620)
	void verifyNoteIndetails() throws IOException{
		leadtest.verifyAddNoteInDetailsPage();
	}
	
	@Test (priority =621) 
	void addnotetabsOutvalidationInDetail() throws InterruptedException, IOException{
		leadtest.logSubjectTabOutValidationDetails();
	}
	@Test (priority =622) 
	void addnoteCommonValidationDetails() throws InterruptedException, IOException{
		leadtest.logSubjectCommonvalidationDetails();
	}
	
	@Test (priority =623) 
	void deleteNoteFromDetails() throws InterruptedException, IOException{
		leadtest.deleteNoteFromActivityTable();
	}
	@Test (priority =624) 
	void editNoteFromDetailspage() throws InterruptedException, IOException{
		leadtest.editNoteFromDetails();
	}
	
	@Test (priority =630)
	void addEventInDetails () throws InterruptedException, IOException{
		leadtest.addEventInDeatilspage();
	}
	
	
	@Test (priority =640)
	void eventtabsOutvaldiationDetails() throws InterruptedException, IOException{
		leadtest.tabsOutvalidationEventInDetails();
	}
	
	@Test (priority =650)
	void eventCommonvalidationDetails () throws InterruptedException, IOException{
		leadtest.commonvalidationEventDetails();
	}
	
	@Test (priority =660)
	void verifyEventInDetails() throws IOException{
		leadtest.verifyEventAddedInDetailsPage();
	}
	@Test (priority =661)
	void eventtabsOutvalidationInDetails() throws InterruptedException, IOException{
		leadtest.eventtabsOutValdiationDetails();
	}
	@Test (priority =662)
	void eventCommonvalidationInDetails() throws InterruptedException, IOException{
		leadtest.commonvalidationEventInDetails();
	}
	@Test (priority =663)
	void deleteEventFromDetailsPage() throws InterruptedException, IOException{
		leadtest.deleteEventFromActivityTable();
	}
	
	@Test (priority =664)
	void editEventFromDetails() throws InterruptedException, IOException{
		leadtest.editEventFromDetails();
	}
	
	
	@Test (priority =670)
	void addAttachmentInDetails () throws InterruptedException, IOException{
		leadtest.addAttachementInDetails();
	}
	
	
	@Test (priority =680)
	void addAttchemntvalidation() throws InterruptedException, IOException{
		leadtest.attachmentCommonvalidationInDetails();
	}

	@Test (priority =690)
	void addtaskInDetails() throws InterruptedException{
		leadtest.addtaskInDetails();
	}
	
	
	@Test (priority =700)
	void verifytaskInDetails() throws IOException{
		leadtest.verifyTaskAddedInDetailsPage();
	}
	@Test (priority =701)
	void deleteTaskFromDetails() throws InterruptedException, IOException{
		leadtest.deletetaskFromActivityTable();
	}
	@Test (priority =702)
	void edittaskFromDetails() throws InterruptedException, IOException{
		leadtest.editTaskFromDetails();
	}
	
	@Test (priority =705)
	void inlinedEditDetailsPage () throws InterruptedException, IOException{
		leadtest.inlinedEditDetailsPage();
	}
	
	@Test (priority =710)
	void checkHeaderAfterInlineEdit() throws InterruptedException, IOException{
		leadtest.checkHeaderAfterInlineEdit();
	}
	
	@Test (priority =715)
	void editFromDetailsPage() throws InterruptedException, IOException{
		leadtest.editFromDetailsPage();
		
	}
	@Test (priority =720)
	void deleteLeadFromDetailsPage() throws InterruptedException{
		leadtest.deleteLeadFromDetailsPage();
	}
	
	@Test (priority =725)
	void deleteLeadInListingPage() throws InterruptedException, IOException{
		leadtest.deleteLeadInListingPage();
	}
	}


