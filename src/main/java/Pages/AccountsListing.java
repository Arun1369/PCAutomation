package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class AccountsListing extends DriverClass{
	public By AccountMenu = By.xpath("//a[@href='/listing/account']");
	public By CreateNew = By.xpath("//button[contains(text(),'Create New')]");
	public By AddNoteAll = By.xpath("//span[@class='pc_hideIcon']//button[4]");

}
