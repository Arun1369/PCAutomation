package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class ContactsListing extends DriverClass{
	public By Conatctmenu = By.xpath("//span[contains(text(),'Contacts')]");
	public By CreateNew = By.xpath("//button[contains(text(),'Create New')]");
	public By AddNoteAllSelect = By.xpath("//span[@class='pc_hideIcon']//button[4]");
	

}
