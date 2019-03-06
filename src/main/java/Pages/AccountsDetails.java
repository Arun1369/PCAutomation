package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class AccountsDetails extends DriverClass{
	
	public By InformationSection = By
			.xpath("//a[contains(text(),'Information')]");
	public By ValidationMessage = By.xpath("//span[@class='help-block']");
	public By NewTask= By.xpath("//a[contains(text(),'Add Task')]");
	public By NewEvent = By.xpath("//a[contains(text(),'Add Event')]");
	public By MakeNote = By.xpath("//a[contains(text(),'Add Note')]");
	public By AddAttachment = By.xpath("//a[contains(text(),'Add Attachment')]");
	public By ActivitySet = By.id("tabs-example-default-slds-tabs--tab-5");
	public By Informations = By.xpath("//li[@title='INFORMATION']");
	public By ActivityTable = By.xpath(
			"html/body/div/div/div[2]/section/div/div[2]/div/div[1]/section/fieldset/div/div/div[1]/div/div[1]/div");
	public By EditButtonInDetailsPage = By.xpath(
			"//div[contains(@class,'show-grid pc_slds-show-gridd pc_panel slds-float_right')]//button[2]");
		public By DeteteOption = By.xpath("//div[contains(@class,'show-grid pc_slds-show-gridd pc_panel slds-float_right')]//button[2]");
		public By PrintButtonInDetailsPage = By
			.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-border-filled more moreHover']");
		public By ExpandButtonInDetailsPage = By.xpath("//button[@title='Expand Sales Coaching Tab Panels']");
		public By TitleLeadDetails = By.xpath("//span[@class='pc_lead-name pc-word-wrap ']");
		public By AccountNameDetailsHeader = By.xpath("//span[@class='pc_lead-name pc-word-wrap ']");
		public By AccountTypeDetailsHeader = By.xpath("(//div[@class='slds-opportunity-CompName pc-word-wrap slds-text-heading_small'])[1]");
		public By OfficePhoneDetailsHeader = By.xpath("(//div[@class='slds-opportunity-CompName pc-word-wrap slds-text-heading_small'])[2]");
		public By AssignToDetailsHeader= By.xpath("(//div[@class='slds-opportunity-CompName pc-word-wrap slds-text-heading_small'])[3]");
		public By WebSiteDetailsHeader = By.xpath("(//div[@class='slds-opportunity-CompName pc-word-wrap slds-text-heading_small'])[4]");


}
