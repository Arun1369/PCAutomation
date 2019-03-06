package Testcases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePackage.DriverClass;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.LeadEntry;
import Pages.LeadListing;
import Pages.PCUtility;
import Pages.Profile;

public class ProfileTest extends DriverClass {

	LeadListing leadlisting = new LeadListing();
	Profile profile = new Profile ();
	PCUtility util = new PCUtility();
	LeadEntry leadEntry = new LeadEntry();
	

	public String lead = "Lead";
	public String contacts = "Contact";
	public String accounts = "Account";
	public String opportunity = "Opportunity";
	public String task = "Task";
	public String event = "Event";
	
	
	
	
	
	
	
	public final int test = 1;
	public final int read = 5;
	public final int edit = 10;
	public final int create = 15;
	public final int delete = 20;
	public final int deletAll = 25;
	
	
	


	@Test(priority = test)
	void test () throws InterruptedException{
		util.login("goyal.yashendra@gmail.com", "Yash@2222");
		Thread.sleep(15000);
		util.sendValue(driver.findElement(By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Lead Status')])//ancestor::div[1]/div//input")), "sdfgsdgg");
		
	}
	/**
	 * Click on read checkbox, Verify no other checkbox is enabled 
	 * @throws InterruptedException
	 */
	@Test(priority = read)
	void read() throws InterruptedException{
		SoftAssert pro = new SoftAssert();
		profile.setPermission("Read", lead, "Click");
		pro.assertEquals(profile.setPermission("Read", lead, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", lead, "read"), false);
		pro.assertEquals(profile.setPermission("Create", lead, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", lead, "read"), false);
		pro.assertAll();
	}
   
	/**
	 * Click on Edit verify Read and Edit checkbox are enabled and Delete and Created Desabled 
	 * 
	 */
	@Test(priority = edit)
	void edit() throws InterruptedException{
		SoftAssert pro = new SoftAssert();
		profile.setPermission("Edit", accounts, "Click");
		pro.assertEquals(profile.setPermission("Read", accounts, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", accounts, "read"), true);
		pro.assertEquals(profile.setPermission("Create", accounts, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", accounts, "read"), false);
		profile.setPermission("Edit", accounts, "Click");
		pro.assertEquals(profile.setPermission("Read", accounts, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", accounts, "read"), false);
		pro.assertEquals(profile.setPermission("Create", accounts, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", accounts, "read"), false);
		pro.assertAll();
	}
	
	/**
	 * Click on Create, Verify Raad and Create Checkbox is Enabled and Edit And Delete is desabled 
	 * @throws InterruptedException
	 */
	@Test(priority = create)
	void create() throws InterruptedException{
		SoftAssert pro = new SoftAssert();
		profile.setPermission("Create", contacts, "Click");
		pro.assertEquals(profile.setPermission("Read", contacts, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", contacts, "read"), false);
		pro.assertEquals(profile.setPermission("Create", contacts, "read"), true);
		pro.assertEquals(profile.setPermission("Delete", contacts, "read"), false);
		profile.setPermission("Create", contacts, "Click");
		pro.assertEquals(profile.setPermission("Read", contacts, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", contacts, "read"), false);
		pro.assertEquals(profile.setPermission("Create", contacts, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", contacts, "read"), false);
		pro.assertAll();
	}
	
	/**
	 * Click on Delete, Verify Read, Edit and Delete is enabled and Create Checkbox is desabled 
	 * @throws InterruptedException
	 */
	@Test(priority = delete)
	void delete() throws InterruptedException{
		SoftAssert pro = new SoftAssert();
		profile.setPermission("Delete", task, "Click");
		pro.assertEquals(profile.setPermission("Read", task, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", task, "read"), true);
		pro.assertEquals(profile.setPermission("Create", task, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", task, "read"), true);
		profile.setPermission("Delete", task, "Click");
		pro.assertEquals(profile.setPermission("Read", task, "read"), true);
		pro.assertEquals(profile.setPermission("Edit", task, "read"), true);
		pro.assertEquals(profile.setPermission("Create", task, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", task, "read"), false);
		profile.setPermission("Delete", task, "Click");
		profile.setPermission("Edit", task, "Click");
		pro.assertEquals(profile.setPermission("Edit", task, "read"), false);
		pro.assertEquals(profile.setPermission("Delete", task, "read"), false);
		pro.assertAll();
	}
	
	/**
	 * Enable All checkbox and uncheck Read, Verify All Checkbox is desabled 
	 * @throws InterruptedException
	 */
	@Test(priority = deletAll)
	void deleteAllCheckBox () throws InterruptedException{
		SoftAssert del = new SoftAssert();
		profile.setPermission("Read", event, "Click");
		profile.setPermission("Create", event, "Click");
		profile.setPermission("Edit", event, "Click");
		profile.setPermission("Delete", event, "Click");
		profile.setPermission("Read", event, "Click");
		del.assertEquals(profile.setPermission("Read", event, "read"), false);
		del.assertEquals(profile.setPermission("Edit", event, "read"), false);
		del.assertEquals(profile.setPermission("Create", event, "read"), false);
		del.assertEquals(profile.setPermission("Delete", event, "read"), false);
		del.assertAll();
	
	}
	
	void onlyReadProfile () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
		profile.setPermission("Read", lead, "Click");
		profile.setPermission("Read", contacts, "Click");
		profile.setPermission("Read", accounts, "Click");
		profile.setPermission("Read", opportunity, "Click");
		util.waitForElementAndClick(driver.findElement(leadlisting.SaveOptionInActionPopup));	
	}
	
	void readAndCreateProfile () throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
		profile.setPermission("Read", lead, "Click");
		profile.setPermission("Create", lead, "Click");
		profile.setPermission("Read", contacts, "Click");
		profile.setPermission("Create", contacts, "Click");
		profile.setPermission("Read", accounts, "Click");
		profile.setPermission("Create", accounts, "Click");
		profile.setPermission("Read", opportunity, "Click");
		profile.setPermission("Create", opportunity, "Click");
		util.waitForElementAndClick(driver.findElement(leadlisting.SaveOptionInActionPopup));
	}
	
	void readCreateEdit() throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
		profile.setPermission("Read", lead, "Click");
		profile.setPermission("Create", lead, "Click");
		profile.setPermission("Edit", lead, "Click");
		profile.setPermission("Read", contacts, "Click");
		profile.setPermission("Create", contacts, "Click");
		profile.setPermission("Edit", contacts, "Click");
		profile.setPermission("Read", accounts, "Click");
		profile.setPermission("Create", accounts, "Click");
		profile.setPermission("Edit", accounts, "Click");
		profile.setPermission("Read", opportunity, "Click");
		profile.setPermission("Create", opportunity, "Click");
		profile.setPermission("Edit", opportunity, "Click");
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
	}
	
	void readCreateEditDelete() throws InterruptedException{
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
		profile.setPermission("Read", lead, "Click");
		profile.setPermission("Delete", lead, "Click");
		profile.setPermission("Create", lead, "Click");
		profile.setPermission("Read", contacts, "Click");
		profile.setPermission("Delete", contacts, "Click");
		profile.setPermission("Create", contacts, "Click");
		profile.setPermission("Read", accounts, "Click");
		profile.setPermission("Delete", accounts, "Click");
		profile.setPermission("Create", accounts, "Click");
		profile.setPermission("Read", opportunity, "Click");
		profile.setPermission("Delete", opportunity, "Click");
		profile.setPermission("Create", opportunity, "Click");
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
	}
	
	
	void profileValidation() throws InterruptedException{
		SoftAssert profileval = new SoftAssert();
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
		profile.setPermission("Read", lead, "Click");
		util.waitForElementAndClick(driver.findElement(profile.CreateNew));
		String fieldvalidation = util.getValidationMessage(driver.findElement(profile.ProfileNameValidation));
		boolean commonValidation = util.verifyElementStatus(leadEntry.CommonValidation);
		profileval.assertEquals(fieldvalidation, profile.profileNameValdiationMessage);
		profileval.assertEquals(commonValidation, true);
		profileval.assertAll();	
	}
	
	
	void maptest (){
		Map<String, WebElement> map = new HashMap<String, WebElement>();
		WebElement table = driver.findElement(By.xpath("//div[@class='panel panel-default']"));
		List <WebElement> alllabel = table.findElements(By.className("control-label"));
		List <WebElement>  allLabelElement = table.findElements(By.className("slds-input"));
		for (int i =0;i<alllabel.size();i++){
			String labelName = alllabel.get(i).getText();
			for (int j=0;j<allLabelElement.size();j++){
				if (j==0){
					map.put(labelName, allLabelElement.get(j));
					break;
				}
				
					
		
				
			}
			
		}
		
	
		
		
	
		
	}
}

