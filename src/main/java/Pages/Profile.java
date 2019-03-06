package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class Profile extends DriverClass{
	
	public By profileName = By.name("profileName");
	public By CreateNew = By.xpath("//button[contains(text(),'Create New')]");
	public By ProfileNameValidation = By.xpath("(//span[@class='help-block'])[3]");
	
	
	
	
	
	public String profileNameValdiationMessage = "";
	
	
	
	public int indexOFHeader;
	public int indexOfModule;
	
	
	/**
	 * Call this function to click on checkbox for profile 
	 * Pass Action (Create, Edit.Delete and Read) and Module name 
	 * 
	 * @param header
	 * @param module
	 */
	//Index of module 
	public int indexOfModules ;
	public WebElement checkBox;
	//Checking checkbox is checked or not
	public boolean isCheckBoxSelected;
	
	
	public boolean setPermission(String header,String module,String action) throws InterruptedException{
		//permissionHeader = header element which will return 4 element "Read, Created, Edit and Delete"
		WebElement permissionHeader = driver.findElement(By.xpath("(//div[@class='row'])[3]"));
		//List each the Header under permissionHeader, which will return 4 element "Read, Created, Edit and Delete"
		List <WebElement> eachHeaders = permissionHeader.findElements(By.className("col-lg-2"));
		System.out.println(eachHeaders.size());
		//Loop the header and get index of header if Header name is matchigng
		for (int i=0;i<eachHeaders.size();i++){
			String headerNames = eachHeaders.get(i).getText();
			System.out.println(headerNames);
			if (headerNames.equalsIgnoreCase(header)){
				this.indexOFHeader = i;
				System.out.println(i);
				break;	
			}	
		}
	   //List all Modules 
		List <WebElement> allPermissionSets = driver.findElements(By.xpath("(//div[@class='row'])[3]/following-sibling::div"));
	    for (int j=0;j<allPermissionSets.size();j++){
	    	WebElement allDiv = allPermissionSets.get(j).findElement(By.className("col-lg-4"));
	    	System.out.println(allDiv.getText());
	    	if (allDiv.getText().equalsIgnoreCase(module)){
	    		//List all Checkbox in the module 
	    		List <WebElement> allCheckBox = allPermissionSets.get(j).findElements(By.className("slds-checkbox--faux"));
	    		System.out.println(allCheckBox.size());
	    		//Create the Web Element for Checkbox 
	    		this.checkBox = allCheckBox.get(this.indexOFHeader);
	    		//If Action is Click, Click on the Checkbox 
	    		if (action.equalsIgnoreCase("Click")){
		    		checkBox.click();
		    		break;

	    		}
	    		else {	
	    			//Else verify is checkbox is selected or Not
	    		int indexOfIsChecked = this.indexOFHeader+1;
	    		//Create the Checkbos xpath using the mosule index postion 
	    		this.isCheckBoxSelected = driver.findElement(By.xpath("(//input[@name='"+module+"'])["+indexOfIsChecked+"]")).isSelected();
	    		System.out.println(By.xpath("(//input[@name='"+module+"'])["+indexOfIsChecked+"]"));
	    		
	    		}
	    		
	    	}
	    	

		}
	    Thread.sleep(3000);
	    //retuen Status of checkbox 
		return this.isCheckBoxSelected;
	 
	}
	
	

}
