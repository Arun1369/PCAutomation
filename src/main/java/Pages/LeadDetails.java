package Pages;

import org.openqa.selenium.By;


/**
 * Initiating all lead details Elements 
 * 
 */

import BasePackage.DriverClass;

public class LeadDetails extends DriverClass {
	public By SaveInlineEdit = By
			.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-border-filled add addHover'])[1]");
	public By CancelinleEdit = By
			.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-border-filled add addHover'])[2]");
	public By InformationSection = By
			.xpath("(//a[contains(text(),'Information')])[1]");
	public By ValidationMessage = By.xpath("//span[@class='help-block']");
	public By ReactDropdownModel = By.id("//ul[@class='slds-dropdown__list pc_custome-view']");
/*
	public By LogCall = By.xpath("//a[contains(text(),'Log Call')]");
	public By SubjectLogcall = By.id("form-element-02");
	public By DetailsLogCall = By.id("textarea-id-01");
	public By TaskTypeAddtask = By.xpath("(//select[@class='slds-select'])[1]");
	public By AssignTaskD = By.xpath("(//select[@class='slds-select'])[2]");
	public By TaskSubject = By.xpath("(//input[@class='slds-input'])[2]");
*/
	public By NewTask= By.xpath("//a[contains(text(),'Add Task')]");
	public By NewEvent = By.xpath("//a[contains(text(),'Add Event')]");
	public By MakeNote = By.xpath("//a[contains(text(),'Add Note')]");
	public By LogCall = By.xpath("//a[contains(text(),'Log Call')]");
	public By AddAttachment = By.xpath("//a[contains(text(),'Add Attachment')]");
	public By ActivitySet = By.id("tabs-example-default-slds-tabs--tab-5");
	public By Informations = By.xpath("//li[@title='INFORMATION']");
	public By CompanyInformation = By.xpath("//li[@id='tabs-example-default-slds-tabs--tab-0']");
	public By AddressInformation = By.xpath("//li[@id='tabs-example-default-slds-tabs--tab-1']");
	public By CustomInformation = By.xpath("//li[@id='tabs-example-default-slds-tabs--tab-2']");
	public By SubjectLogCall = By.id("f702");

	public By ActivityTable = By.xpath(
			"html/body/div/div/div[2]/section/div/div[2]/div/div[1]/section/fieldset/div/div/div[1]/div/div[1]/div");

	public By ActionButtonIn = By.xpath(
			"//button[@class='slds-button slds-button_icon slds-button_icon-border-filled preview previewHover']");
	

public By ProcessBar = By.className("slds-path__nav");

public By MarkAsTemplateButton = By
	.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-border-filled more filterHover']");
public By EmailButtonInDetailsPage = By
	.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-border-filled more previewHover']");
public By EditButtonInDetailsPage = By.xpath(
	"//div[contains(@class,'show-grid pc_slds-show-gridd pc_panel slds-float_right')]//button[2]");
public By DeteteOption = By.xpath("//div[contains(@class,'show-grid pc_slds-show-gridd pc_panel slds-float_right')]//button[2]");
public By PrintButtonInDetailsPage = By
	.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-border-filled more moreHover']");
public By ExpandButtonInDetailsPage = By.xpath("//button[@title='Expand Sales Coaching Tab Panels']");
public By TitleLeadDetails = By.xpath("//span[@class='pc_lead-name pc-word-wrap ']");
public By LeadNameDetailsHeader = By.xpath("//span[@class='pc_lead-name pc-word-wrap ']");
public By CompanyNameDetailsHeader = By.xpath("(//div[@class='slds-lead-CompName pc-word-wrap slds-text-heading_small'])[1]");
public By DesignationDetailsHeader = By.xpath("(//div[@class='slds-lead-CompName pc-word-wrap slds-text-heading_small'])[2]");
public By MobileNumberDetailsHeader = By.xpath("(//div[@class='slds-lead-CompName pc-word-wrap slds-text-heading_small'])[3]");
public By EmailInfoHeader = By.xpath("(//div[@class='slds-lead-CompName pc-word-wrap slds-text-heading_small'])[4]");
public By CompanyDescriptionDetails = By.xpath("(//span[@class='form-control-static'])[1]");
public By AnualTurnOnerDetails = By.xpath("(//span[@class='form-control-static'])[2]");
public By NoOfStaffDetails = By.xpath("(//span[@class='form-control-static'])[3]");
public By MainBusinnesDetails = By.xpath("(//span[@class='form-control-static'])[4]");
public By IndustryDetails = By.xpath("(//span[@class='form-control-static'])[5]");
public By InlineEditDetails = By.className("fa fa-pencil slds-col--padded");
public By MarkStatusAsComplet = By.xpath("//button[contains(@class,'slds-path-markcomp sld-mstatus')]");
public By ActivityTablle = By.xpath("//table[@class='slds-table slds-table_bordered slds-table--header-fixed slds-table_fixed-layout slds-table_resizable-cols']/tbody");

}
