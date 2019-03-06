package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class UserListing extends DriverClass{
	public By SettingsMenu = By.xpath("//span[contains(text(),'Setting')]");
	public By UsersMenu = By.xpath("//h3[contains(text(),'User')]");
	public By CreateNew = By.xpath("//button[contains(text(),'Create New')]");

}
