package Pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BasePackage.DriverClass;

public class LeadListing extends DriverClass {

	/**
	 * 
	 * Initiating all lead listing Elements 
	 * 
	 * @throws InterruptedException
	 */
	public By ValidationMessage = By.xpath("//span[@class='help-block']");
	public By ReactDropdownModel = By.id("//ul[@class='slds-dropdown__list pc_custome-view']");
	public By LeadMenu = By.xpath("//span[@data-localize='label.menu.leads']");
	public By BreacCrumbsInLIstingPage = By.xpath("//ol[@class='breadcrumb']");
	public By LeadTable = By.xpath("//div[@class='ReactTable']");
	public By ColumnSelectionBox = By
			.xpath("//div[@class='slds-popover__body']");
	public By ActionPopUp = By.xpath("//div[@class='slds-modal__container']");
	public By CreateLeadOption = By.xpath("//button[contains(text(),'Create New')]");
	public By PageSearchOption = By.xpath("//input[@id='searchright']");
	public By SearchbarOption = By.id("searchright");
	public By RefreshOption = By.xpath("(//button[@class='slds-button slds-button--icon-border-filled'])[1]");
	public By FilterOption = By.xpath(
			"(//button[@class='slds-button slds-button--icon-border-filled'])[2]");
	
	//public By FilterBy1 = By.xpath("(//div[@class='css-1hwfws3'])[1]");
	
	public By SaveOptionInEditPageView = By
			.xpath("//button[contains(text(),'UPDATE')]");
	public By CreatePageViewOption = By.xpath("//button[@class='slds-button slds-button_brand saveBtn']");
	public By InputBoxInEditView = By.name("viewName");
	public By PageViewOption = By.xpath(
			"(//button[@class='slds-button slds-button--icon-more'])[1]");
	public By CustompageOption = By.xpath(
			
"(//button[@class='slds-button slds-button--icon-more'])[1]");
	public By MoreActionOption = By
			.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-border-filled more moreHover']");
	
	public By BredCrumHome = By.xpath("//ol[@class='breadcrumb']");
	public By LeadTitle= By.xpath("//label[@class='breadcrumbLabel']");
	public By DropDownInLeadCreatePage = By.xpath("//div[@class='Select-placeholder']");
	
	public By CreateNewOption = By.xpath("//button[contains(text(),'Create New')]");
	public By MoreOptionInAllSelect = By.xpath(
			"(//button[@title='Delete Record'])[2]");
	public By DeleteOptionInAllSelect = By.xpath(
			"//span[@class='pc_hideIcon']//button[5]");
	public By AddNoteOptionInAllSelect = By.xpath(
			"//span[@class='pc_hideIcon']//button[4]");
	public By ChangeOwnerInAllSlect = By.xpath("//span[@class='pc_hideIcon']//button[1]");
	public By CreateCustomPageViewButton = By.xpath("(//button[@class='slds-button slds-button--icon-container slds-button--icon-x-small'])[1]");
	public By AssignActivitySetAllSelect = By.xpath("//button[@title='Assign Activity']");
	
	
	public By CustomPageViewList = By
			.xpath("//ul[@class='slds-dropdown__list pc_custome-view']");
	public By SavedPageView = By
			.xpath("//ul[@class='slds-dropdown__list pc_custome-view']");
	public By MoreActionList = By.xpath("//ul[@class='dropdown__list slds-dropdown--length-5']");
	public By SubjectNote = By.name("G15");
	public By DetailsNote = By.xpath("//textarea[@id='G16']");
	/*public By TaskSubject = By.id("f734");
	public By TaskTypeIn= By.xpath(
			"//span[@id='react-select-2--value']//div[@class='Select-placeholder'][contains(text(),'Select...')]");
	public By PriorityTask = By.xpath(
			"//span[@id='react-select-4--value']//div[@class='Select-placeholder'][contains(text(),'Select...')]");
	public By StatusTask = By.xpath(
			"//span[@id='react-select-5--value']//div[@class='Select-placeholder'][contains(text(),'Select...')]");

	public By SubjectEvent = By.id("f718");
	public By DetailsEventSubject = By.id("f720");
	public By EventTypeListing = By.xpath(
			"(//span[@class='Select-arrow-zone'])[1]");
	public By AssignToEvent = By.xpath(
			"(//span[@class='Select-arrow-zone'])[2]");
	public By RemiderBeforeEventListing = By.xpath(
			"(//span[@class='Select-arrow-zone'])[3]");
	public By AllEventRadioOption = By.xpath("//div[@class='react-toggle-track']");*/
	
	public By UplaodAttachmentOption = By.xpath("//input[@id='f785']");
	public By DetailsAttachmentOption= By.xpath("//textarea[@id='G19']");
	public By ChangeleadOwnerOption = By.xpath("//div[contains(@class,'css-1hwfws3')]");
	public By ChangeleadOwner = By.xpath("//div[contains(@class,'css-1hwfws3')]");
	public By SubjectLogCall = By.xpath("//input[@id='G15']");
	public By DetailsLogCall = By.xpath("//textarea[@id='G16']");
	public By SaveOptionInActionPopup = By.xpath("//button[@class='pc_colorBtn']");
	public By CancelOptionActionPopup  = By
			.xpath("//button[@class='pc_cancel']");
	public By PaginationRecordSelction = By.xpath("//span[contains(@class,'select-wrap -pageSizeOptions')]//select");
	public By PaginationPrevious = By.xpath("//div[@class='-previous']");
	public By pageJumpPagination = By.className("-pageJump");
	/*public String xpath1forCheckBox = "html/body/div[1]/div/div[2]/section/div/div/div/div[3]/div[3]/div[1]/div[2]/div[";
	public String xpath2forCheckBox = "]/div/div[1]/span/label/span";
	public String xpath1forAction = "html/body/div[1]/div/div[2]/section/div/div/div/div[3]/div[2]/div/table/tbody/tr[";
	public String xpath2forAction = "]/td[10]";*/
	public String  colorOfToggleDisabled = "rgba(77, 77, 77, 1)";
	public String  colorOfToggleEnabled = "rgba(249, 122, 30, 1)";
	public String createPageSucessMessage = "Save Success";
	public String editPageSucessMessage = "Updated Success";
	public String addLogSucessMessage = "Save Success";
	public String addNoteSucessMessage = "Save Success";
	public String addEventSucessMessage = "Save Success";
	public String addTaskSucessMessage = "Save Success";
	public String addAttachmentSucessMessage = "Save Success";
	public String editleadSucessMessage = "Update Success";
	public By InputBoxSaveCustomView = By.name("viewName");
	public String changeOwnerSucessMessage = "Save Sucess";
	public String DeletetLeadSucessMessage = "Save Sucess";
	public String addLogFieldvaldiationMessage = "Subject is required";
	public String addNoteFieldvaldiationMessage = "Subject is required";
	public By uploadinAttachemnt = By.xpath("//input[@type='file']");
	public By DetailsInAttachment = By.xpath("//textarea[@id='G19']");
	public String commonvalidationAttachment = "Please enter required fields";
	public String changeOwnerTo = "Dev";
	public By InlineEditSaveButtonTable = By.xpath("//button[@title='Save Edit']");
	public By InlineEditCancelButtonTable = By.xpath("//button[@title='Cancel Edit']");
	public By CustomViewModel = By.xpath("//ul[@class='slds-dropdown__list pc_custome-view']");
	public By ActionMenuModel  = By.xpath("//ul[@class='dropdown__list slds-dropdown--length-5']");
	public By FilterFieldBy1 = By.xpath("(//div[@class='css-1hwfws3'])[1]");
	public By FilterFieldBy2 = By.xpath("(//div[@class='css-1hwfws3'])[4]");
	public By FilterOperator1 = By.xpath("(//div[@class='css-1hwfws3'])[2]");
	public By FilterOperator2 = By.xpath("(//div[@class='css-1hwfws3'])[5]");
	public By FiltervalueInputtextBox1 = By.xpath("(//input[@name='value'])[1]");
	public By FiltervalueInputtextBox2 = By.xpath("(//input[@name='value'])[2]");
	public By FilterValueInputDropdown1 = By.xpath("(//div[@class='css-1hwfws3'])[3]");
	public By FilterValueInputDropdown2 = By.xpath("(//div[@class='css-1hwfws3'])[6]");
	public By FilterSaveButton = By.xpath("//button[contains(@title,'Apply')]");
	public By FilterEdit1  = By.xpath("(//button[@title='Edit'])[1]");
	public By FilterEdit2  = By.xpath("(//button[@title='Edit'])[2]");
	public By FilterAddNewFilter = By.xpath("//label[contains(@class,'addFilterRow')] ");
	public By FilterANDOR   = By.xpath("//select[contains(@name,'condition')]");
	public By ActionButton = By.xpath("//div[@class='absolute-positioned slds-dropdown ignore-react-onclickoutside slds-dropdown--right']");
	public By ActionDropDownList = By.xpath("//div[contains(@class,'slds-dropdown slds-dropdown_right slds-dropdown_actions more_divCss')]");
	public By UplaodOptionInIMport = By.xpath("//input[@type='file']");
	public String importSuccessMessage = "Lead imported sucessfully";
	public By AllSelect = By.xpath("//span[contains(@class,'checkboxHeadDesign')]//span[@class='slds-checkbox_faux']");
	public By AllSelectMoreDropdown = By.xpath("//ul[@class='slds-dropdown__list']");
	public String importmanditoryFiedValidation = "Please select required fieds";
	public String logCallvalidationMessage = "This field required";
	public String logCallMaxCharvalidationMessae = "-------------";
	public By DefaultView = By.xpath("//span[@title='Default']");
	public By InlineEditBulkSaveButton = By.xpath("//button[contains(text(),'Save')]");
	public By InlineEditBuikDiscardButton = By.xpath("//button[contains(text(),'Discard')]");
	public String [] customValues = {"Lead Converted","Lead Created By","Lead Created","Lead Modified"};
	public String deletepageView = "Deleted Sucesfully";
	
	

	public String [] firstNameArry = {"firstnamefirstnamefirstnamefirstnamefirst",
					"@#$%^&*()","text!@#$%^"};
	
	public String [] lastNameArry = {"","firstnamefirstnamefirstnamefirstnamefirstfirstnamefirstnamefirstnamefirstnamefirs",
					"@#$%^&*()","text!@#$%^"};


	public  String [] designationArry = {"firstnamefirstnamefirstnamefirstnamefirstfirst",
					"@#$%^&*()","text6546456456!@#$%^"};


	public  String [] companyArry = {"","firstnamefirstnamefirstnamefirstnamefirstfirst",
					"@#$%^&*()","text6546456456!@#$%^"};


	public String [] officeNumberArry = {"9865985989865989865989565985989659865989898888",
					"@#$%^&*()","dfgdfgfdgdfgfdg^","698989898dsfdsfds","959595959@##$$$)("};
     
	public String [] mobileNumberArry = {"9865985989865989865989565985989659865989898888",
					"@#$%^&*()","dfgdfgfdgdfgfdg^","698989898dsfdsfds","959595959@##$$$)("};
					
	public String [] postalCoceArry = {"986598598986598986598",
					"@#$%^&*()","dfgdfgfdgdfgfdg^","698989898dsfdsfds","959595959@##$$$)("};


	public  String [] logSubjectArry = {
							 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
							 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
							 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                                     + "maximummaximummaximummaximummaximummaximummaximumma"
                                      +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"

					 };

	public String [] eventSubjectArry = {
						 "","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
							 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
							 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                                  + "maximummaximummaximummaximummaximummaximummaximumma"
                                   +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
				 };


	public String [] eventLocationArry = {
						 "@#$%^&","ghghsdjkghdsjkghd","maximummaximummaximummaximummaximummaximummaximummax"
							 		+ "imummaximummaximummaximummaximummaximummaximummaximummaximummaximu"
							 		+ "mmaximummaximummaximummaximummaximummaximummaximummaximum"
                                  + "maximummaximummaximummaximummaximummaximummaximumma"
                                   +"ximummaximummaximummaximummaximummaximummaximummaghfhggg"
				 };				 
					
					
	public String [] accountNameArry = {"","firstnamefirstnamefirstnamefirstnamefirstfirstnamefirstnamefirstnamefirstnamefirs",
			"@#$%^&*()","text!@#$%^"};
	
	public String [] opportunityNameArry = {"","firstnamefirstnamefirstnamefirstnamefirstfirstnamefirstnamefirstnamefirstnamefirs",
			"@#$%^&*()","text!@#$%^"};
	
	
	public String [] amountArry = {"9865985989865989865989565985989659865989898888",
			"@#$%^&*()","dfgdfgfdgdfgfdg^","698989898dsfdsfds","959595959@##$$$)("};
	
	

	
	


}
