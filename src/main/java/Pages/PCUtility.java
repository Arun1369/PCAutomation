package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BaseClass;
import bsh.util.Util;

public class PCUtility extends BaseClass {
	LeadDetails leadDetails = new LeadDetails();
	public By Testcall = By.xpath("sdfsd");
	public boolean elementStatus = false;
	public WebElement columValue;
	public String colorOfToggleButton;
	public String columntext;
	public int i;
	public int sizeOfProcessbar;
	public String colorOfPorcessbar;
	public WebElement moreActionIcon;
	public int rowCount;
	public int rowCountActivity;
	public int userRow;
	public int userRowAcitvity;
	public String colorOfToggle;
	public List<WebElement> row;
	public List<WebElement> rowActivity;
	public int actaulHeaderSize;
	public WebElement toggle;
	public WebElement inlineEditPlaceHolder;
	public WebElement inlineEditButton1;
	
	public ArrayList<String> tabs;
	public WebElement toggleTumb;
	
	
	LeadListing lead = new LeadListing();

	/**
	 * @author QA Team - Nichi in software solution pvt ltd Common methods used
	 *         to call for test cases excecution
	 * 
	 * @throws InterruptedException
	 * 
	 */

	/**
	 * Click in the Alert box
	 */
	public String alertText;
    //Its customized methof for the Customized pop up. Model vs pop up
	public String getAlertMessage() {
		try {
			if (isAlertPresent() == true) {
				//Getting element based on Customized pop up window
				//Getting text of the alert pop window 
				alertText = driver.findElement(By.xpath("(//div[@class='slds-modal__content'])[2]")).getText();
			}
		} catch (Exception e) {
			System.out.println(e + "Alert not diaplyed");
		}
		return alertText;
	}
	/**
	 * Accept Alert pop up
	 */
	public void acceptAlert() {
		try {
			if (isAlertPresent() == true) {
				//Accept alert
				//Click on OK button on Customized pop up
			driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral']")).click();
			}
		} catch (Exception e) {
			System.out.println("Alert not present");
			e.printStackTrace();
		}
	}

	public Alert alert;

	/**
	 * Checking alert is displayed or note
	 * 
	 * @return = true of alert is present else false
	 */
	public boolean isAlertPresent() {
		try {
			//Checking alert based pop model content, Taking one part of element one of the 
			//Getting boolean object based on the visibility
			boolean status = verifyElementStatus(By.xpath("//button[@class='slds-button slds-button--neutral']"));
		
			return status;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()

	/**
	 * 
	 * @param element
	 *            = Element to be retuned the name
	 * @return = Name of Element ie: Name of Icon
	 */
	public String getElementName(WebElement element) {
		try {
			// get element name and Storing
			//WebElement element = driver.findElement(elementToGetName);
			String name = element.getText();
			return name;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * @param element
	 *            = Element which need to verify its visible or not
	 * @return elementStatus boolean value
	 */
	public boolean verifyElementStatus(By element) {
		
		boolean elementStatus = driver.findElements(element).size() != 0;
		System.out.println(elementStatus);
		return elementStatus;
	}

	/**
	 * 
	 * @param elementToScrolDown
	 *            = Element to Scrolldown the page
	 */
	public void scrollDownPage(By elementToScrolDown) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			// Scrolldown the page
			// elementToScrolDown - Element whete has to scroll
			
			js.executeScript("arguments[0].scrollIntoView();", elementToScrolDown);
		} catch (Exception e) {
			System.out.println("element not fount to scrolldown " + e);
		}
	}

	/*
	 * String comparison Passing regular expression and Comparing
	 * expression - Call the method and pass the regular expression 
	 * valueForverioficatio = Value to verify with regular expression
	 */
	public boolean regulaExpressionChecks(String expression, String valueForverioficatio) {
		boolean result = false;
		// Checking keyword using regular experssion
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(valueForverioficatio);
		if (matcher.find())
			result = true;
		else {
			result = false;
		}
		return result;

	}

	/**
	 * 
	 * @param nameValue
	 *            = Name of value to be present in dropdown list
	 */
	public void waitForValueToPresentFromDropDownList(String nameValue) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(lead.PaginationRecordSelction),
					nameValue));
		} catch (Exception e) {
			System.out.println(e + "value is not displayed from dropdown list");
		}
	}

	/**
	 * 
	 * @param element
	 *            = Which element to be displayed
	 */
	public void waitForElementToBeDisplayed(WebElement element) {
		try {
			// Wait for 15 Sec
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e + "Element not displayed");

		}
	}

	/**
	 * 
	 * @param element
	 *            = Element of Dropdown list
	 * @param value
	 *            = Value to Select
	 */
	public void selectByValueFromDropDownList(WebElement element, String value) {
		try {
			// Select value from dropdown model
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e + "Element is visible while selecting from the dropdown");
		}
	}

	/**
	 * 
	 * @param element
	 *            = Element for the Dropdown
	 * @param object
	 *            = Value to select from dropdown
	 * @throws InterruptedException 
	 */
	public void handleDropdown(WebElement element, String value) throws InterruptedException {
		
			// Wait for 15 sec
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(Keys.TAB);
		actions.build().perform();
		
			//driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]")).click();
			
			/*Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, 15);
				// List all option from the react dropdown list
				List<WebElement> options = driver.findElements(By.className("css-xp4uvy"));
				for (WebElement option : options) {
					// If Option name is matching, click on name
					if (option.getText().equalsIgnoreCase(value)) {
						option.click();
						Thread.sleep(3000);
						// If is matching, break the fucntion and no need to loop
						// again
						break;
					}
				}
		} catch (Exception E) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("Selected");
		}
		*/
	}

	public Select select;

	public void handleDropDownByIndex(WebElement element, int index) {
		
		element.click();
		
		// Wait for 15 sec
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// List all option from the react dropdown list
		List<WebElement> options = driver.findElements(By.className("css-v73v8k"));
		options.get(index).click();
		
		//Change method based on New Requirment 
	/*	try {
			Select select = new Select(element);
			// Select value by index number
			select.selectByIndex(index);
		} catch (Exception E) {
			select.selectByIndex(2);

		}*/
	}

	/**
	 * 
	 * @param radioTable
	 *            = Element of Toggle Button
	 * @param valueToSelect
	 *            = Value to Select
	 * @param tagname
	 *            = Tag name of CSS
	 */
	public void selectradioButton(WebElement radioTable, String valueToSelect, String tagname) {
		WebElement table = radioTable;
		// List all radio button
		List<WebElement> allOptions = driver.findElements(By.tagName(tagname));
		for (WebElement option : allOptions) {
			System.out.println("Option value " + option.getText());
			try {
				if (valueToSelect.equals(option.getText())) {
					option.click();
					break;
				}

			} catch (Exception e) {
				System.out.println(e + "Found error while selcting the radio button");

			}
		}
	}

	/**
	 * 
	 * @param element
	 *            = Element where need to write the keys values
	 * @param sendKey
	 *            = The text which need to write
	 */
	public void findElementAndSenkKeys(WebElement element, String sendKey) {
		try {
			// Find element snd Send Keys
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(sendKey);
		} catch (Exception e) {
			System.out.println(e + "Error found while find element and send keys ");
		}
	}

	/**
	 * 
	 * @param element
	 *            = Element to Send the keys (Input box)
	 * @param sendKey
	 *            = Keyword for sending to input box
	 */
	public void sendValue(WebElement element, String sendKey) {
		// Wait for element and click for 30 sec
					WebDriverWait wait = new WebDriverWait(driver, 30);
					WebElement elementToVisisble = element;
					wait.until(ExpectedConditions.visibilityOf(elementToVisisble));
					Actions actions = new Actions(driver);
					actions.moveToElement(elementToVisisble).click().build().perform();
					elementToVisisble.clear();
					elementToVisisble.sendKeys(sendKey);
		
		
	}

	/**
	 * 
	 * @param element
	 *            = The Element which want to wait
	 * @throws InterruptedException 
	 */
	public void waitForElementAndClick(WebElement element) throws InterruptedException {
		try {
			// Wait for element and click for 30 sec
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement elementToVisisble = element;
			wait.until(ExpectedConditions.visibilityOf(elementToVisisble));
			Actions actions = new Actions(driver);
			actions.moveToElement(elementToVisisble).click().build().perform();
			//elementToVisisble.click();
			Thread.sleep(3000);
			System.out.println("Element clicked");
		} catch (NullPointerException e) {
			System.out.println(e + "Error fount finding the element and Click");

		}
		Thread.sleep(2000);
	}

	/**
	 * 
	 * @param infoName
	 *            = lable name in Information tab Section = Where all
	 *            Inforamtion are listed allElement = Listing All Informations
	 *            elementName = Element name, which user want to edit using
	 *            Inline Edits Button1 = Inline Edit button
	 */

	public void inlineEdit(String infoName, WebElement section) {

		try {
			WebElement infoSection = section;
			// List All element of Inline Infromation
			List<WebElement> allElement = infoSection.findElements(By.className("slds-form-element"));
			allElement.size();
			System.out.println(allElement.size());
			// 1= Element
			for (int i = 0; i < allElement.size(); i++) {
				List<WebElement> allElement1 = allElement.get(i).findElements(By.className("slds-form-element__label"));
				// J = Element inside the element
				for (int j = 0; j < allElement1.size(); j++) {
					// Getting text of element
					String name = allElement1.get(j).getText();
					System.out.println(name);
					// Inforname = name of Element in information list
					if (name.equals(infoName)) {
						System.out.println("sdfsdsdfsdfd");
						// if InfoName is matching, then click in inline edit
						// button
						WebElement inlineEditButton = allElement.get(i).findElement(By.className("inlineeditIcon"));
						inlineEditButton.click();
						return;

					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error while returning element for inline edit");
		}

	}

	/**
	 * 
	 * @param elementToClick
	 *            = To click the Dropdown Element options = Text from the
	 *            fropdown Option = Each Text from the dropdown
	 * @param valueToselect
	 */
	public void selectReactDropDown(WebElement elementToClick, String valueToselect) {

		// driver.findElement(By.className("Select-control")).click();
		// Click on element where react model dropdown
		elementToClick.click();

		try {
			// Wait for 15 sec
			WebDriverWait wait = new WebDriverWait(driver, 15);
			// List all option from the react dropdown list
			List<WebElement> options = driver.findElements(By.className("css-v73v8k"));
			for (WebElement option : options) {
				// If Option name is matching, click on name
				if (option.getText().equalsIgnoreCase(valueToselect)) {
					option.click();
					Thread.sleep(3000);
					// If is matching, break the fucntion and no need to loop
					// again
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e + "Error found on Selcting dropdown from react Dropdown");

		}
	}

	/**
	 * 
	 * @param elementToClick
	 * @param number
	 */
	public void selectReactDropDownBasedOnIndex(WebElement elementToClick, int number) {

		// driver.findElement(By.className("Select-control")).click();
		// Click on react dropdiwn model
		elementToClick.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			// List the all option from the Dropdown list
			List<WebElement> options = driver.findElements(By.className("css-v73v8k"));
			// Click on Option (value) based on index number
			options.get(number).click();
		} catch (Exception e) {
			System.out.println(e + "Error found on Selcting dropdown from react Dropdown");

		}
	}

	/**
	 * allNames = Returning text from the dropdown list names = Converitng to
	 * String from webelement and saving
	 * 
	 * @param valueToSelect
	 *            = value to select from the Dropdownmodel
	 */
	public void selectFromDropDownModal(String valueToSelect, WebElement element) {
		try {
			WebElement model = element;
			// List all element from the dropdown model
			List<WebElement> allNames = model.findElements(By.tagName("li"));
			for (WebElement name : allNames) {
				// getting text and storing to the element name
				String names = name.getText();
				System.out.println(names);
				// if name is matching, go and Click f
				if (name.getText().contains(valueToSelect)) {
					// waitForElementToBeDisplayed(name);
					name.click();
					System.out.println("Clicked to Element from dropdown model");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e + "Found error by selecting the model dropdown");
		}
	}

	/**
	 * 
	 * @param valueToSelect
	 *            = Text which want to verify react dropdown list
	 * @return true if its present
	 */
	public boolean statusOfText(String valueToSelect) {
		try {
			// List all value from dropdown
			List<WebElement> allNames = driver.findElements(By.tagName("li"));
			for (WebElement name : allNames) {
				// Get all names from the dropdown list
				String names = name.getText();
				// If name is matches,
				if (name.getText().equals(valueToSelect)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e + "Found error by selecting the model dropdown");
		}
		// If return is not matching. return false
		return false;
	}

	/**
	 * 
	 * @param columnBox
	 *            = List of All columns
	 * @param toggleName
	 *            = Name of Toogle
	 * @return Color of Toogle Button
	 * 
	 */
	public String getColorOfToggle(WebElement columnBox, String toggleName) {
		try {
			// declare the Toggle box
			WebElement toggleBox = columnBox;
			// List the all element from the toggle box
			List<WebElement> toggles = toggleBox
					.findElements(By.xpath("//div[@class='slds-dropdown__item iconDeleteHeight']"));
			// i = each element from the toggle box
			for (int i = 0; i < toggles.size(); i++) {
				// Get the name of the coloumn from toggle box
				String names = toggles.get(i).findElement(By.className("pc-view_label")).getText();
				System.out.println(names);
				// If Name of column name is matching, return the color of the
				// toggle button
				if (names.equals(toggleName)) {
					// Toggle = If Name is matching, save toggle element
					toggle = toggles.get(i).findElement(By.className("react-toggle-track"));
					// ToggleTumb = If Name is matching, return Toggle postition
					// where user can click
					toggleTumb = toggles.get(i).findElement(By.className("react-toggle-thumb"));
					// colorOfToggle = If name is matching, Get the color of the
					// toggle
					colorOfToggle = toggle.getCssValue("background-color");
					System.out.println(colorOfToggle);
					return colorOfToggle;
				}
			}

		} catch (Exception e) {
			System.out.println(e + "Error found while clicking the toggle button");
		}
		// If Column name is not matching, return null
		return null;
	}

	/**
	 * 
	 * @param columnBox
	 *            = List of All Columns
	 * @param toggleName
	 *            = Name of Toggle
	 */
	public void enableToggle(WebElement columnBox, String toggleName) {
		try {
			String n = toggleName;
			WebElement t = columnBox;
			// Call getColorToggle function to get all Columns of
			getColorOfToggle(t, n);
			// Store the color of the toggle
			String color = colorOfToggle;
			// If toggle is Disabled, click on toggle button to enable the
			// column
			if (color.equals(lead.colorOfToggleDisabled)) {
				toggle.click();
			} else {
				// do nothing
			}
		} catch (Exception e) {
			System.out.println("Error while enabling the toggle ");

		}
	}

	/**
	 * 
	 * @param columnBox
	 *            = List of All Columns
	 * @param toggleName
	 *            = Name of Toggle
	 */
	public void disableToggle(WebElement columnBox, String toggleName) {
		try {
			String n = toggleName;
			WebElement t = columnBox;
			// Calling function
			getColorOfToggle(t, n);
			// Storing the Colour of toggle
			String color = colorOfToggle;
			// If color is enabled, disable the color
			if (!color.equalsIgnoreCase(lead.colorOfToggleDisabled)) {
				toggleTumb.click();
				System.out.println("Clicked");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error while disabling the toggle");
		}
	}

	/**
	 * 
	 * @param valueToSelect
	 *            = Select the value from the record selection
	 */
	public void recordSelection(String valueToSelect) {
		try{
		waitForElementToBeDisplayed(driver.findElement(lead.PaginationRecordSelction));
		Select select = new Select(driver.findElement(lead.PaginationRecordSelction));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.name(valueToSelect)));
		select.selectByVisibleText(valueToSelect);
		Thread.sleep(4000);
		}
		catch(Exception e){
			System.out.println("Unable to select the record from record selection");
		}

	}

	/**
	 * 
	 * @param name
	 *            = Value to Verify in the table is visible or not
	 * @param table
	 *            = Lead react table
	 * @return = If name is present it will return Name else return null
	 */

	public WebElement column;
	public int colunmCount;;
	public int j;
	public List<WebElement> col;

	public String loopColumnFindName(String name, WebElement table) {
		try {
			// Declare Lead table
			WebElement tableName = table;
			// List the all row in the column
			row = driver.findElements(By.className("rt-tr-group"));
			rowCount = row.size();
			System.out.println(row.size());
			ArrayList<String> tableNames = new ArrayList<String>();
			// i = Row
			for (i = 0; i < row.size(); i++) {
				//List All column in each
				col = row.get(i).findElements(By.className("rt-td"));
				col.size();
				// j = Column
				for (j = 0; j < col.size(); j++) {
					// Get the column element
					column = col.get(j);
					// Get the coloumn string
					String leadName = col.get(j).getText();
					// Add All column name to Array
					tableNames.add(leadName);
					System.out.println(leadName);
					// if Lead name equal or contain, then,
					// userRow = Save the user row colunmCount = Save the user
					// column
					if (leadName.equalsIgnoreCase(name) || leadName.contains(name)) {
						userRow = i;
						colunmCount = j;
						System.out.println(name);
						// If lead name is equal, return name
						return name;
					}
				}
			}
		}

		catch (Exception e) {

		}
		// If lead name is not matching, return null
		return null;

	}

	/**
	 * Click on Element if it not displayed
	 * 
	 * @param elementToVisible
	 *            = Welement to visible
	 * @param elementToClick
	 *            = Where user wants to click
	 */
	public void clickOnElementIfNotDispayed(By elementToVisible, WebElement elementToClick) {
		// Status of Element
		boolean status = verifyElementStatus(elementToVisible);
		// if element is present, return true
		if (status == false) {
			elementToClick.click();
		} else {
			// do nothing
		}

	}

	/**
	 * 
	 * @param name
	 *            = Name of which user want to verify in the table
	 * @param table
	 *            = Lead react table
	 * @param action
	 *            = CheckBox = Clicking on Checkbox to select the leads, More
	 *            Action = Click on more action to select the Activity
	 * @throws InterruptedException
	 */
	public void clickOnActions(String name, WebElement table, String action) throws InterruptedException {
		String n = name;
		WebElement t = table;
		// Calling the function
		// If Name is matching, Save the name
		String findName = loopColumnFindName(n, t);
		System.out.println(findName);
		Thread.sleep(3000);
		try {
			// If lead name displayed, then check the user want to click the
			// Checkbox or more Action
			if (!(findName == null)) {
				// If user want to click on checkbox
				if (action.equalsIgnoreCase("CheckBox")) {
					try {
						/*
						 * Read the specific user checkbox and then Select the
						 * respective checkbox
						 */
						WebElement chkbox = row.get(userRow).findElement(By.className("slds-checkbox_faux"));
						System.out.println(userRow);
						chkbox.click();
					} catch (Exception e) {
					}
					//Click on Avatar icon and redirected to Details page 
				} else if(action.equalsIgnoreCase("Redirection")) {
					try {
						WebElement moreAction = row.get(userRow).findElement(By.className("module_avatar"));
						moreAction.click();
					} catch (Exception e) {
					}
				}
				else {
					//Click on Individual Action button
					try{
						WebElement moreAction = row.get(userRow).findElement(By.className("slds-button__icon"));
						moreAction.click();
					}
					catch(Exception e){
						System.out.println("More Action not found");
					}
			
				}
				
			}
		} catch (Exception e) {
		}
		Thread.sleep(3000);
	}

	/**
	 * 
	 * @param path
	 *            = Path of AutoIT images
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uploadImages(String path) throws IOException, InterruptedException {
		/*
		 * Thread.sleep(5000); Run the AutoIT script in Run time
		 */

		Runtime.getRuntime().exec(path);
	}

	/**
	 * 
	 * @param element
	 *            = Element name of Pipeline stage bar
	 * @param value
	 *            = Name of the each stages
	 * @param action
	 *            = Click and get the color or Get the color getting color
	 */
	public void getColorOfPipelineStageBar(WebElement element, String value, String action) {
		try {
			/*
			 * Declaring pipeline stage bar Listing each element from the
			 * Pipeline stage Bar
			 */
			WebElement processbars = element;
			List<WebElement> processBar = driver.findElements(By.tagName("li"));
			sizeOfProcessbar = processBar.size();
			List<String> processBarString = new ArrayList<String>();
			for (WebElement bars : processBar) {
				// Read the Each Stages and Add to Array
				String name = bars.getText();
				processBarString.add(name);
				/*
				 * If Stage is Match getColor = Read the Color of Specific stage
				 * clickAndGetColor = Click the stage and get color
				 * mouseHoverAndGetColor = Mouse hover and get the color of the
				 * stage
				 * 
				 */
				if (name.equals(value)) {
					switch (action) {

					case "getColor":
						colorOfPorcessbar = bars.getCssValue("background-color");
						break;
					case "clickAndGetColor":
						bars.click();
						colorOfPorcessbar = bars.getCssValue("background-color");
						break;
					case "mouseHoverAndGetColor":
						Actions mouseHover = new Actions(driver);
						mouseHover.moveToElement(bars).build().perform();
						colorOfPorcessbar = bars.getCssValue("background-color");
						break;
					}
				}
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 
	 * @param rows
	 *            = Select record selection
	 */
	public void selectPagination(String rows) {
		try {
			/*
			 * rowSelection = Select the All entry from the pagination selection
			 * 
			 */
			WebElement rowSelection = driver.findElement(lead.PaginationRecordSelction);
			waitForElementToBeDisplayed(rowSelection);
			Select select = new Select(rowSelection);
			try {
				waitForValueToPresentFromDropDownList(rows);
				select.selectByValue(rows);
			} catch (Exception e) {
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Switching to New Tab
	 * 
	 * @throws InterruptedException
	 */
	public void switchToNewTab() throws InterruptedException {
		// Swith to new Tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());

	}

	// Switch back to old tab
	public void switchbackToMainTab(int number) throws InterruptedException {
		driver.switchTo().window(tabs.get(number));
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws InterruptedException
	 */
	public void login(String userName, String password) throws InterruptedException {
		WebElement name = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='inputPassword']"));
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		waitForElementToBeDisplayed(name);
		name.sendKeys(userName);
		waitForElementToBeDisplayed(pass);
		pass.sendKeys(password);
		waitForElementToBeDisplayed(signInButton);
		signInButton.click();
		Thread.sleep(2000);
	}

	/**
	 * 
	 * @return Return all header from the table
	 */

	public WebElement allCheckBox;

	public List<String> tableHeader() {
		// List all header
		List<String> allHeader = null;
		try {
			/*
			 * tableHeader = List the All table header header = List the All
			 * table Contents Get the header name and Add to Arry
			 */
			WebElement tableHeader = driver.findElement(By.xpath("//div[@class='rt-tr']"));
			waitForElementToBeDisplayed(tableHeader);
			List<WebElement> header = tableHeader.findElements(By.className("rt-resizable-header-content"));
			allCheckBox = header.get(0);
			allHeader = new ArrayList();
			int headerSize = header.size();
			// Cubstract Action Column and check box column
			actaulHeaderSize = headerSize - 2;
			System.out.println(actaulHeaderSize);
			for (WebElement eachHeader : header) {
				String names = eachHeader.getText();
				allHeader.add(names);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allHeader;

	}
 /**
  * 
  * @param selectElement = Element for Dropdown
  * @return = List of dopdown list
  */
	
	public List <String> returnDropDownList (By selectElement,By listElement){
		WebElement dpElement = driver.findElement(selectElement);
		List <WebElement> allElements = dpElement.findElements(listElement);
		List<String> allDropdown = new ArrayList();
		for (WebElement all:allElements){
			String values = all.getText();
			allDropdown.add(values);	
		}
		return allDropdown;
	
	}
	/**
	 * Comparing the ArrayList 
	 * @param value
	 * @param valueToCompare
	 * @return  True or false after comparison 
	 */
	public boolean compareList(String value,String valueToCompare){
		ArrayList<String> listOne = new ArrayList<>(Arrays.asList(value));
	        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList(valueToCompare));   
	        //Sorting first ArrayList
	        Collections.sort(listOne);
	        //Sorting Second Arraylist
	        Collections.sort(listTwo);
	        //Compare unequal lists example
	        boolean isEqual = listOne.equals(listTwo);
			return isEqual;  
	}
	
	
	
	
	public int headerCount;
	public int k;
	public WebElement columnElement;
	public String columnData;
	public int headerCountForInlineXpath;
	public int rowCountForInlineXpath;

	/**
	 * Get the Column data from web table based on Row and Header
	 * 
	 * @param headerName
	 * @param nameOfUser
	 * @throws InterruptedException 
	 */
	public String getColumndata(String headerName, String nameOfUser) throws InterruptedException {
	
			/**
			 * header = List all Header Content
			 * 
			 */
			WebElement tableHeader = driver.findElement(By.xpath("//div[@class='rt-tr']"));
			waitForElementToBeDisplayed(tableHeader);
			System.out.println(tableHeader);
			List<WebElement> header = tableHeader.findElements(By.className("rt-resizable-header-content"));
			header.size();
			System.out.println(header.size());
			List<String> headerNames = new ArrayList<String>();
			// k = header variable
			for (k = 0; k < header.size(); k++) {
				// Read the header name and save
				String nameOfHeader = header.get(k).getText();
				if (nameOfHeader.equalsIgnoreCase(headerName)) {
					System.out.println(nameOfHeader);
					System.out.println("Your Header is" + " " + nameOfHeader);
					headerNames.add(nameOfHeader);
					// headerCount = header specific count
					headerCount = k;
					// Sum headerCount + 1 to use for x path creation
					headerCountForInlineXpath = 1 + k;
					System.out.println("Your header count is" + " " + k);
					// Break when header name is found
					break;
				}
			}
			//}
			// Calling method
			loopColumnFindName(nameOfUser, driver.findElement(lead.LeadTable));
			Thread.sleep(2000);
			// Declearing the user specific row
			int rowOfUser = i;
			// Declearing the rowcount fot xpath creation
			rowCountForInlineXpath = 1 + i;
			System.out.println(rowOfUser + " " + "Row count");
			// Read the coloumn data
			columnData = col.get(k).getText();
			System.out.println(columnData);
			// Get the Sepcific column element
			columnElement = col.get(k).findElement(By.className("react-table-col"));
			System.out.println(columnElement);
			// inlieditIconInTable =
			// columnElement.findElement(By.xpath("//span[@class='edit-icon fa
			// fa-sm fa-1x fa-pencil']"));
			System.out.println(columnData + "" + "Your column data is");
			// If Column data is found, return the Column date
			return columnData;
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error while getting the column data");
			//
		
		
	}

	/**
	 * 
	 * @param headerName
	 *            = Find the Header name to get the column number
	 * @param nameOfUser
	 *            = Name of the user to find out the row number
	 * @throws InterruptedException
	 */
	public void inlineEditInTable(String headerName, String nameOfUser) throws InterruptedException {
		try {
			// Calling the fucntion to get the coloumn data
			getColumndata(headerName, nameOfUser);
			// Mouse hover colum element to view the inline edit button
			WebElement placeForMouseHover = columnElement;
			Actions builder = new Actions(driver);
			builder.moveToElement(columnElement).build().perform();
			System.out.println(columnElement);
			Thread.sleep(3000);
			System.out.println("Mouse hover element >>>>>>>>>>>>>>>>>>>>>>>>>>");
			try {
				// Store the xpath for inline button for specific user
				String xpath1 = "//div[@class='rt-tbody']//div[";
				String xpath2 = "]//div[1]//div[";
				String xpath3 = "]//div[1]//span[2]";
				// Creating x path inline edit for specific user by using
				// Specific row and column count
				WebElement inlineEditIconInTable = driver.findElement(
						By.xpath(xpath1 + rowCountForInlineXpath + xpath2 + headerCountForInlineXpath + xpath3));
				System.out.println(inlineEditIconInTable);
				inlineEditIconInTable.click();
				Thread.sleep(3000);
			} catch (Exception E) {
				/*
				 * If there is one user in table, Switch to catch Here only pass
				 * the Colum count, as Row count always 1 , as only one row
				 */
				String xpath1 = "//div[@class='rt-tr -odd']//div[";
				String xpath2 = "]//div[1]//span[2]";
				WebElement inlineEditIconInTable = driver
						.findElement(By.xpath(xpath1 + headerCountForInlineXpath + xpath2));
				System.out.println(inlineEditIconInTable);
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(inlineEditIconInTable).build().perform();
				inlineEditIconInTable.click();
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in inline edit");

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param valueToselect
	 *            = Value to return from react dropdown list
	 * @return
	 */
	public String returnValueFromReactDropDownModel(WebElement model,String valueToselect) {
		WebElement element = model;
		try {
			/*
			 * Return the name from the dropdown model
			 */
			List<WebElement> allNames = element.findElements(By.tagName("li"));
			for (WebElement name : allNames) {
				String names = name.getText();
				if (name.getText().equals(valueToselect)) {
					waitForElementToBeDisplayed(name);
					return name.getText();
				}
			}
		} catch (Exception e) {
			System.out.println(e + "Found error by selecting the model dropdown");
		}
		return null;
	}

	
	/**
	 * 
	 * @param validationElement
	 *            = Element for validation messages
	 * @return validation message as Strig
	 */
	public String getValidationMessage(WebElement validationElement) {
		try {
			/*
			 * 
			 */
			waitForElementToBeDisplayed(validationElement);
			String validationMessage = validationElement.getText();
			return validationMessage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *            = Activity table
	 * @param value
	 *            = Value to pass
	 * @return if value is present in table, will return the name else null
	 */
	public int m;
	public int n;
	public List<WebElement> colOFActivityTable;

	public String loopActivityTable(WebElement table, String value) {
		try {
			WebElement tableName = table;
			rowActivity = tableName.findElements(By.tagName("tr"));
			rowCountActivity = rowActivity.size();
			System.out.println(rowActivity.size() + " " + "size of row");
			ArrayList<String> tableNames = new ArrayList<String>();
			for (m = 0; m < rowActivity.size(); m++) {
				colOFActivityTable = rowActivity.get(m).findElements(By.tagName("td"));
				colOFActivityTable.size();
				System.out.println(colOFActivityTable.size() + " " + "Size of TD");
				for (n = 0; n < colOFActivityTable.size(); n++) {
					String name = colOFActivityTable.get(n).getText();
					tableNames.add(name);
					System.out.println(name);
					System.out.println(value);
					if (name.contains(value)||name.equalsIgnoreCase(value)) {
						userRowAcitvity = m;
						System.out.println(m);
						return value;
						
					}
				}
			}
		}

		catch (Exception e) {

		}
		return null;
	}

	public int o;
	public int headerCountOfActivityTable;
	public String columnDataActivityTable;
	public WebElement columnElementActivitytable;

	public String getColumnDataFromActivityTable(WebElement table, String headerName, String value) {
		try {
			WebElement tableName = table;
			// Liting all header of activity table
			List<WebElement> header = tableName.findElements(By.tagName("th"));
			header.size();
			List<String> headerNames = new ArrayList<String>();
			// o = headr size
			for (o = 0; o < header.size(); o++) {
				// Getting text of header
				String nameOfHeader = header.get(o).getText();
				System.out.println(nameOfHeader);
				// Checkking header name is marched or note
				if (nameOfHeader.equalsIgnoreCase(headerName)) {
					System.out.println("Your Header is" + " " + nameOfHeader);
					headerNames.add(nameOfHeader);
					// Saving header postion of
					headerCountOfActivityTable = o;
					System.out.println(0);
					break;
				}
			}
			Thread.sleep(3000);
			// Calling loop method
			loopActivityTable(table, value);
			// m = Saving row count of user
			int rowOfUser = m;
			// Getting texy of activity table
			columnDataActivityTable = colOFActivityTable.get(o).getText();
			System.out.println(columnDataActivityTable);
			columnElementActivitytable = colOFActivityTable.get(o);
			// inlieditIconInTable =
			// columnElement.findElement(By.xpath("//span[@class='edit-icon fa
			// fa-sm fa-1x fa-pencil']"));
			System.out.println(columnDataActivityTable + "" + "Your column data is");
			return columnDataActivityTable;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error while getting the column data");
			;
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 * @param value
	 * @param statusToSelec
	 */
	public void changeTaskStatus(WebElement table, String value, String statusToSelec) {
		loopActivityTable(table, value);
		try {
			WebElement chkbox = rowActivity.get(userRowAcitvity).findElement(By.xpath("//select"));
			selectByValueFromDropDownList(chkbox, statusToSelec);
		} catch (Exception e) {

		}

	}

	/**
	 * value = Column name nameColoumXpath = xpath/ Creating xpath by passing
	 * value
	 * 
	 */

	public void clickOnNameinTable(String value) {
		try {
			// Creating xpath and getting the column value
			String nameColoumXpath = "//span[@title='" + value + "']";
			System.out.println(nameColoumXpath);
			// Find the element and clicking by using xpath
			driver.findElement(By.xpath(nameColoumXpath)).click();
		} catch (Exception e) {
			System.out.println(e + "Unable to click on Name ");

		}
	}
/**
 * 
 * @throws InterruptedException
 * @throws IOException
 * @throws ParseException
 */
	public void login() throws InterruptedException, IOException, ParseException {
		ExcelReader excel = new ExcelReader();
		login(excel.readFromExcel(1, 1, 1), excel.readFromExcel(1, 2, 1));

	}

	/**
	 * 
	 * @param action = String, Call this method and pass the Argument "Click, Edit or Delete
	 * @param pageName
	 * @throws InterruptedException
	 */
	public void editDeletePageView(String action,String pageName) throws InterruptedException{
		WebElement table = driver.findElement(lead.CustomViewModel);
		List <WebElement> allElements = table.findElements(By.tagName("li"));
		for (int i=0;i<allElements.size();i++){
			String elementNames = allElements.get(i).getText();
			System.out.println(elementNames);
			//Click on Edit button
			if (elementNames.equals(pageName)){
				//Creating View Count, Add 1  as, its index format 
			   int pageCount =i;
				System.out.println(pageCount + "my page count");
				//Mouse Hover Action
				Actions builder = new Actions(driver);
				WebElement  mouseHoberElement = allElements.get(i);
				builder.moveToElement(mouseHoberElement).build().perform();
				Thread.sleep(3000);
				System.out.println("Mouse Over Lementy");
				//If Action is Edit, Then click on Edit button
				if (action=="Edit"){
					waitForElementAndClick(driver.findElement(By.xpath("(//span[@class='tableViewsIcons'])["+pageCount+"]//button[1]")));
					Thread.sleep(3000);
					break;
				}
				//If Action is Delete, then Click on Delete Button
				else if(action=="Delete"){
				driver.findElement(By.xpath("(//span[@class='tableViewsIcons'])["+pageCount+"]//button[2]")).click();
				Thread.sleep(3000);
				break;
				}
				//If Action is click, then Click on Custom view to navigate 
				else if(action=="Click"){
					driver.findElement(By.xpath("//span[@title='"+pageName+"']")).click();
					break;
				}
			}
		}
				
		
		/*	//Click on Delete Button
			else if(elementNames.equals(pageName)&&action=="Delete"){
				int pageCount =i+1;
				System.out.println(pageCount + "my page count");
				Actions builder = new Actions(driver);
				WebElement  mouseHoberElement = driver.findElement(By.xpath("//ul[@class='slds-dropdown__list pc_custome-view']//li["+pageCount+"]"));
				builder.moveToElement(mouseHoberElement).build().perform();
				Thread.sleep(3000);
				System.out.println("Mouse hovering to page view ");
				try{
					//
				driver.findElement(By.xpath("//ul[@class='slds-dropdown__list pc_custome-view']//li["+pageCount+"]//span[2]//button[2]")).click();
				}
				catch(Exception e){
					driver.findElement(By.xpath("//ul[@class='slds-dropdown__list pc_custome-view']//li[2]")).click();
					
				}
				break;
				}
			//Click on Page View 
			else if (elementNames.equals(pageName)&&action=="Click"){
				driver.findElement(By.xpath("//span[@title='"+pageName+"']")).click();
				break;
			}
		}*/
	}
	/**
	 * Inline Edit In Details page
	 * Just Mouse hover any of the field and Click on Any of Edit button, It will open the Edit form 
	 */
	public By MouseOverElementInDetailpage = By.xpath("//span[@class='pc_task-name pc-word-wrap transaction-info']");
	public By inlineEditIconIndetilaPage = By.xpath("//span[@class='edit-icon fa fa-sm fa-1x fa-pencil']");
		public void inlineEditInInformationSection (WebElement informationSectionElement) throws InterruptedException{
			waitForElementAndClick(informationSectionElement);
			Thread.sleep(5000);
			//Mouse hover the Element 
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(MouseOverElementInDetailpage)).build().perform();
			//Click on Inline Edit button
			driver.findElement(inlineEditIconIndetilaPage).click();
			Thread.sleep(4000);
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isUnExpectedAlertPresent() 
		{ 
		    try 
		    {   //if Alert is present, return true
		        driver.switchTo().alert(); 
		        return true; 
		    }   // try 
		    catch (NoAlertPresentException Ex) 
		    { 
		        return false; 
		    }   // catch 
		}   	
		
	/**Handle Unexpected Error and Click on Bulk save in inline Edit button 
	 * Its method for while inline Edit
	 */
	public void acceptUnExpectedError(){
		try{
			//Check if Alert is present or not
			if(isUnExpectedAlertPresent()==true){
				//Switching to Alert
			  Alert alert = driver.switchTo().alert();
			  String alertMessage= driver.switchTo().alert().getText();
			  System.out.println(alertMessage);
			  //Click on OK on Alert 
			  alert.accept();
			  try{
				  //If inline Edit Bulk save button displayed, then Click on Save button 
				  if (driver.findElement(lead.InlineEditBulkSaveButton).isDisplayed()){
					  driver.findElement(lead.InlineEditBulkSaveButton).click();
					  System.out.println("Clicked on save button");
					  Thread.sleep(3000);
					   }
			  }
			  catch(Exception d){
				  System.out.println("Save button not found");  
			  }
			}
			else {
				try{
					//Click on Bulk save button if it is present 
				driver.findElement(lead.InlineEditBulkSaveButton).click();
				}
				catch(Exception h){	
				}
			}
		}
		catch(Exception e){
			System.out.println("Accepting the alert");
		}
	}
}
