package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class OpportunityListing extends DriverClass{
	public By OpportunityMenu = By.xpath("//a[@href='/listing/opportunity']");
	public By CreateNew = By.xpath("//button[contains(text(),'Create New')]");
	public By AddNoteAll = By.xpath("//span[@class='pc_hideIcon']//button[5]");

}
