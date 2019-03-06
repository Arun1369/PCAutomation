package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePackage.DriverClass;
import Pages.AccountsDetails;
import Pages.AccountsEntry;
import Pages.AccountsListing;
import Pages.ExcelReader;
import Pages.LeadDetails;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.PCUtility;
import Pages.UserDetails;
import Pages.UserEntry;
import Pages.UserListing;

public class UsersTest extends DriverClass{
	
	UserDetails userdetails = new UserDetails();
	UserListing userlist = new UserListing();
	UserEntry userentry = new UserEntry();
	
	PCUtility util = new PCUtility ();
	LeadListing lead = new LeadListing();
	ExcelReader excel = new ExcelReader ();
	LeadEntry leadEntry = new LeadEntry();
	LeadTest leadtest = new LeadTest ();
	CommonFeature common = new CommonFeature();
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
		@Test(priority=addUser)
		public void addUser() throws InterruptedException, IOException, ParseException {
			//util.login();
			Thread.sleep(5000);
			util.waitForElementAndClick(driver.findElement(userlist.SettingsMenu));
			util.waitForElementAndClick(driver.findElement(userlist.UsersMenu));
			driver.navigate().refresh();
			Thread.sleep(5000);
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			Thread.sleep(3000);
			//Creating first User
			userentry.createUser(11, 1);
			statusOfActionPopup = util.verifyElementStatus(lead.ActionPopUp);
			util.waitForElementAndClick(driver.findElement(userentry.Save));
			String sucessMessage = util.getValidationMessage(driver.findElement(leadEntry.CommonSucessMessage));
			Assert.assertEquals(sucessMessage, userentry.UserCreateSucessMessage);
			
			
		}
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
		@Test(priority=verifyUserInListngPage)
		void verifyAccountsInListngPage() throws IOException, InterruptedException {
			util.recordSelection("100 rows");
			Thread.sleep(3000);
			SoftAssert userStatus = new SoftAssert();
			String user = util.loopColumnFindName(excel.readFromExcel(11, 1, 0),
					driver.findElement(lead.LeadTable));
			userStatus.assertEquals(user, excel.readFromExcel(11, 1, 0));
			userStatus.assertAll();
		}
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
		@Test(priority=verifySearchInAccount)
		void verifySearchInAccount() throws IOException, InterruptedException {
			driver.navigate().refresh();
			util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
			util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(11, 1, 0));
			System.out.println("Sendng values to search box");
			Thread.sleep(4000);
			String userName= util.loopColumnFindName(excel.readFromExcel(11, 1, 0),
					driver.findElement(lead.LeadTable));
			System.out.println("verifyLeadsInListngPagen value in the table are " + userName);
			String userName2 = util.loopColumnFindName(excel.readFromExcel(11, 2, 0), driver.findElement(lead.LeadTable));
			System.out.println(userName2);
			SoftAssert searchUser = new SoftAssert();
			driver.navigate().refresh();
			Thread.sleep(3000);
			util.waitForElementAndClick(driver.findElement(lead.PageSearchOption));
			util.sendValue(driver.findElement(lead.SearchbarOption), excel.readFromExcel(11, 1, 3));
			Thread.sleep(3000);
			driver.navigate().refresh();
			String leadnameByMobile = util.loopColumnFindName(
					excel.readFromExcel(11, 1, 0), driver.findElement(lead.LeadTable));
			searchUser.assertEquals(leadnameByMobile, excel.readFromExcel(11, 1, 0));
			searchUser.assertEquals(userName, excel.readFromExcel(11, 1, 0));
			searchUser.assertNull(userName2);
			searchUser.assertAll();
		}
	
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException 
		 */

		@Test(priority=firstNamefieldvalidationInContacts)
		void firstNamefieldvalidationInContacts() throws InterruptedException, IOException{
			Thread.sleep(3000);
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			//Call the method from commonfeature call for validation for first name
			common.tabsOutValidationFieldType(lead.firstNameArry,
					userentry.FirstName,
					userentry.FirstNameValidation, 
					userentry.firstNameValidationMessage);
			common.commonValidationFieldType(lead.firstNameArry,
					userentry.FirstName,
					userentry.FirstNameValidation, 
					userentry.firstNameValidationMessage);
			
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		
		@Test(priority=lastNameFieldvaldidationContact)
		void lastNameFieldvaldidationContact() throws InterruptedException, IOException{
			Thread.sleep(3000);
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			//Last name valiadtion
			common.tabsOutValidationFieldType(lead.lastNameArry,
					userentry.LastName,
					userentry.LastNameValidation, 
					userentry.lastNameValidationMessage);
			common.commonValidationFieldType(lead.lastNameArry,
					userentry.LastName,
					userentry.LastNameValidation, 
					userentry.lastNameValidationMessage);
		}
		
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		
		@Test(priority=designationFieldvalidationContact)
		void designationFieldvalidationContact() throws InterruptedException, IOException{
			Thread.sleep(3000);
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			common.tabsOutValidationFieldType(lead.designationArry,
					userentry.Designation,
					userentry.DesignationValidation, 
					userentry.DesignationValidationMessage);
			common.commonValidationFieldType(lead.designationArry,
					userentry.Designation,
					userentry.DesignationValidation, 
					userentry.DesignationValidationMessage);
		}
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 */
		
		@Test(priority=departmentFiedlvalidationError)
		void departmentFiedlvalidationError() throws InterruptedException, IOException {
			Thread.sleep(3000);
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			common.tabsOutValidationFieldType(lead.designationArry,
					userentry.Department,
					userentry.DepartmentValidation, 
					userentry.DepartmentValidationMessage);
			common.commonValidationFieldType(lead.designationArry,
					userentry.Department,
					userentry.DepartmentValidation, 
					userentry.DepartmentValidationMessage);
			
		}
		
		
		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException 
		 */

		@Test(priority=mobilefieldvalidationInContacts)
		void mobilefieldvalidationInContacts() throws InterruptedException, IOException{
			Thread.sleep(3000);
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			//Call the method from commonfeature call for validation for first name
			common.tabsOutValidationFieldType(lead.firstNameArry,
					userentry.Mobile,
					userentry.MobileNumberValidation, 
					userentry.mobileNumberValidationMessage);
			common.commonValidationFieldType(lead.firstNameArry,
					userentry.Mobile,
					userentry.MobileNumberValidation, 
					userentry.mobileNumberValidationMessage);
		}
		
		//Verify tabs and Common validation if user not selected the profile while creating the user
		@Test(priority=profilevalidatinError)
		void profileValidatinError () throws InterruptedException{
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			driver.findElement(userentry.Profile).click();
			driver.findElement(userentry.Profile).sendKeys(Keys.TAB);
			String valMessage = util.getValidationMessage(driver.findElement(userentry.ProfileValidation));
			Assert.assertEquals(valMessage, userentry.profileValidationMessage);	
		}
       
		/**
		 * Verify Common Validation Error 
		 * @throws InterruptedException
		 */
		void commonValidationError () throws InterruptedException{
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			util.waitForElementAndClick(driver.findElement(userentry.Save));
			//Check Common validation elemnt present or note
			boolean commonValidation = util.verifyElementStatus(leadEntry.CommonValidation);
			Assert.assertEquals(commonValidation, true);
			WebElement test = driver.findElement(By.xpath("//android.widget.ImageView[@index='0']/android.widget.Button[@index='0']"));
			test.click();
		}
		
		void createUserWithSave () throws InterruptedException{
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			Thread.sleep(3000);
			//Creating first User
			userentry.createUser(11, 1);
			util.waitForElementAndClick(driver.findElement(userentry.Save));
		
			//elementToVisisble.click();
			Thread.sleep(3000);
			
			//TODO User Verification test Case is penging
		}
		
		void createUserWithSaveAndActivate(){
			util.waitForElementAndClick(driver.findElement(userlist.CreateNew));
			Thread.sleep(3000);
			//Creating first User
			userentry.createUser(11, 1);
			util.waitForElementAndClick(driver.findElement(userentry.SaveAndActivate));
		}
}
