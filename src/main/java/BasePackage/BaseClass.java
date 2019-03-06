package BasePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.JavaMail;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass extends DriverClass{
	//InputValues input = new InputValues ();
	JavaMail javamail = new JavaMail();
	DriverClass driverclass = new DriverClass();
	
	/**
	 * Launch the Application  
	 * @Return Return the url from propery file and load the web page 
	 * 
	 */
	@BeforeSuite
	// Launching Application 
	public final void launchAUTApplication () throws IOException
	{
		
		driverclass.launchBrowser(DriverClass.getValuesFromPropertiesFile("BrowserName"));			
		driver.manage().window().maximize();
			javamail.main(null);
		
	}
	
	
	
	
	@AfterSuite
	//Closing Application 
	public void cleanUp()
	{
		
		
		driver.close();	
    }
	
}
