package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class Roles extends DriverClass{
	
	
	public By CreateNew = By.xpath("//button[contains(text(),'Create New')]");
	public By RoleName = By.name("roleName");
	public By ReportsTo = By.xpath("//div[@class='css-1hwfws3']");
	public By RoleNameValidation = By.xpath("(//span[@class='help-block'])[1]");
	
	
	

}
