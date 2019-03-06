package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class LeadEntry  extends DriverClass {
	
	/**
	 * Initiating all lead Entry Elements 
	 */
	
	public By InlineEditDropDownElement = By.xpath("//div[@class='css-1hwfws3']");
	public By Salutation = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Salutation')])//ancestor::div[1]/div//input");
	public By LeadStatus = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Lead Status')])//ancestor::div[1]/div//input");
	public By AssignedTo = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Assigned To')])//ancestor::div[1]/div//input");
	public By LeadSource = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Lead Source')])//ancestor::div[1]/div//input");
	public By MainBusiness = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Main Business')])//ancestor::div[1]/div//input");
	public By Industry = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Industry')])//ancestor::div[1]/div//input");
	public By CancelButton = By.xpath("(//button[@class='pc_cancel'])[1]");
	public By ResetButton = By.xpath("(//button[@class='pc_cancel'])[2]");
	public By SaveandNewButton = By.xpath("(//button[@class='pc_cancel'])[3]");
	public By SaveButton = By.xpath("//button[@class='pc_colorBtn']");
	public By FirstName = By.name("G2");
	public By Officenumber = By.name("G9");
	public By MobileNumber = By.name("L258");
	public By LastName = By.name("G3");
	public By CompanyName = By.name("G4");
	public By Designation = By.name("G8");
	public By Email = By.name("G6");
	public By WebSite = By.name("G7");
	public By CompanyDeScription = By.name("G16");
	public By OfficeNumber = By.name("G9");
	public By PostalCode = By.name("G14");
	public By Street = By.name("G10");
	public By Country = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'Country')])//ancestor::div[1]/div//input");
	public By Staet = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'State')])//ancestor::div[1]/div//input");
	public By City = By.xpath("(//div[@class='panel panel-default']//span[contains(text(), 'City')])//ancestor::div[1]/div//input");
	public String lastNameValdiationError = "Last name is required!";
	public String companyNameValidationError = "Company Name is required!";
	public String leadStatusValidationError = "Please select lead status";
	public String emailIDInvalidError = "Invalid email Id";
	public String webSiteInvalidError   = "Please enter valid URL";
	public By CommonValidation = By.xpath("//div[@class='slds-notify slds-notify_toast slds-theme_warning']");
	public By CommonSucessMessage = By.className("notif__container ");
	public String CommonValidationMEssage = "Please enter required fields";
	public String leadSucessMessage = "Save Success";
	public String alertMessage = "You have unsaved changes, do you really want to close?";
	public By lastnameFieldValdiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Last Name')])//ancestor::div[1]/div//span");
	public By companyFieldValidation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Company')])//ancestor::div[1]/div//span");
	public By leadStatusFieldvaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Lead Status')])//ancestor::div[1]/div//span");
	public By emailFieldvaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Email')])//ancestor::div[1]/div//span");
	public By webSiteFieldvaldiation = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Web Site')])//ancestor::div[1]/div//span");
	public By FirstNamevalidationError = By.xpath("(//span[@class='help-block'])[1]");
	public String firstNamecharExceedvalidation = "Allowd only 50 characrtes";
	public String lastNamecharExceedvalidation = "Allowd only 50 characrtes";
	public String comcpanyExceedvalidation = "Allowd only 50 characrtes";
	public String designationcharExceedvalidation = "Allowd only 50 characrtes";
	public String mobileExceedvalidation = "Allowd only 50 characrtes";
	public String postalCodecharExceedvalidation = "Allowd only 50 characrtes";
	public String addresscharExceedvalidation = "Allowd only 50 characrtes";
	public String officecharExceedvalidation = "Allowd only 50 characrtes";
	public By DesignationValidationError = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Designation')])//ancestor::div[1]/div//span");
	public By PostalCodeValidationError = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Postal Code')])//ancestor::div[1]/div//span");
	public By MobileNumbervaldiationError = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Mobile Number')])//ancestor::div[1]/div//span");
	public By AddressvalidationError = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Address')])//ancestor::div[1]/div//span");
	public By OfficeNumberValidationError = By.xpath(" (//div[@class='panel panel-default']//span[contains(text(), 'Office Phone')])//ancestor::div[1]/div//span");
	public String designationFieldvalidationError = "Please enter valid charactres";
	public String mobileNumbervalidationError = "Please enter valid charactres";
	public By EntryLabels = By.xpath("(//label[@class='control-label'])/p/span/span[not(@class='required-field')]");
	
	
			

	
	
	
	

}
