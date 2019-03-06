package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.ExcelReader;
import Pages.LeadEntry;
import Pages.PCUtility;

public class BulkLeads extends DriverClass {

	Logger logger;
	StringBuffer verificationErrors = new StringBuffer();
	PCUtility util = new PCUtility();
	LeadEntry entry = new LeadEntry();
	ExcelReader excel = new ExcelReader();
	String cellValue;

	@Test(priority = 1)
	void login() throws InterruptedException, IOException, ParseException {
		driver.findElement(By.xpath("  input[@id='username']")).sendKeys("tester@mailinator.com");
		driver.findElement(By.xpath("  input[@id='inputPassword']")).sendKeys("12345678");
		driver.findElement(By.xpath("  button[@type='submit']")).click();
		Thread.sleep(3000);
		util.waitForElementAndClick(
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/aside[1]/div/nav/ul/li[3]/a/span/span")));
		   util.waitForElementAndClick(driver.findElement(By.xpath("html/body/div[1]/div/div[2]/aside[1]/div/nav/ul/li[3]/a/span/span")));
		driver.findElement(By.xpath("  button[contains(text(),'CREATE NEW')]")).click();
		Thread.sleep(3000);
		List<List<HSSFCell>> data = excel.getSheetData(0);
		System.out.println(data.size());
		List <String > cellValues = new ArrayList <String>();
		for (int i = 1; i < data.size(); i++) {
			Thread.sleep(3000);
		if (data==null||data.isEmpty()){
			data.add(null);
			
		}
	         List list = data.get(i);
			System.out.println();
			for (int j = 0; j < list.size() - 1; j++) {
				HSSFCell lang = (HSSFCell) list.get(list.size() - 1);
				HSSFCell cell = (HSSFCell) list.get(j);
				switch (j) {
				case 0:
					try {
						util.handleDropdown(driver.findElement(entry.Salutation), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
					
						break;
					} catch (Exception e) {
						   
						e.printStackTrace();
						break;
					}
				case 1:
					try {
						util.sendValue(driver.findElement(entry.FirstName), cell.getStringCellValue());
						  break;
					} catch (Exception e) {
						  
						e.printStackTrace();
					
					}
					break;
				case 2:
					try {
						util.sendValue(driver.findElement(entry.LastName), cell.getStringCellValue());
						  break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						
					}
					break;
				case 3:
					try {
						util.sendValue(driver.findElement(entry.CompanyName), cell.getStringCellValue());
						
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}
				case 4:
					try {
						util.sendValue(driver.findElement(entry.Designation), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

			/*	case 5:
					try {
						util.sendValue(driver.findElement(entry.OfficeNumber), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}*/
				/*case 6:
					try {
						util.sendValue(driver.findElement(entry.MobileNumber), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}*/
				case 7:
					try {
						util.sendValue(driver.findElement(entry.Email), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}
				case 8:
					try {
						util.sendValue(driver.findElement(entry.WebSite), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}
				case 9:
					try {
						util.sendValue(driver.findElement(entry.Street), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 10:
					try {
						util.handleDropdown(driver.findElement(entry.Country), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 11:
					try {
						util.handleDropdown(driver.findElement(entry.Staet), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 12:
					try {
						util.handleDropdown(driver.findElement(entry.City), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 13:
					try {
						util.sendValue(driver.findElement(entry.PostalCode), ((int) cell.getNumericCellValue()) + "");
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}
					

				case 14:
					try {
						util.handleDropdown(driver.findElement(entry.Industry), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 15:
					try {
						util.sendValue(driver.findElement(entry.CompanyDeScription), cell.getStringCellValue());
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 16:
					try {
						util.handleDropdown(driver.findElement(entry.LeadSource), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 17:
					try {
						util.handleDropdown(driver.findElement(entry.LeadStatus), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				case 19:
					try {
						Thread.sleep(3000);
						util.handleDropdown(driver.findElement(entry.AssignedTo), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						System.out.println(i);
						break;
					} catch (Exception e) {
						     
						e.printStackTrace();
						break;
					}

				default:
					break;
				}

			}

			util.waitForElementAndClick(driver.findElement(entry.SaveandNewButton));
			Thread.sleep(3000);

		}

	}
	void createLead(int sheetNo, int rowNo) throws InterruptedException {
		/*Thread.sleep(3000);
		List<List<HSSFCell>> data = excel.getSheetData(sheetNo);
		List headerList = data.get(0);

		for (int i = 1; i < data.size(); i++) {
			Thread.sleep(3000);
			List list = data.get(rowNo);
			System.out.println(list);
			// TEST CODE START 
			HashMap <String,String> linkedHashMap = new HashMap<String, String>(); 
			for (int l = 0; l < list.size(); l++){
				 linkedHashMap.put(headerList.get(l).toString(), list.get(l).toString());
			 }
			
			util.sendValue(driver.findElement(entry.FirstName), linkedHashMap.get("FirstName"));
			util.sendValue(driver.findElement(entry.LastName), linkedHashMap.get("LastName"));
			util.sendValue(driver.findElement(entry.CompanyName), linkedHashMap.get("CompanyName"));
			util.sendValue(driver.findElement(entry.Designation), linkedHashMap.get("Designation"));
			util.sendValue(driver.findElement(entry.OfficeNumber), linkedHashMap.get("OfficeNumber"));
			util.sendValue(driver.findElement(entry.MobileNumber), linkedHashMap.get("MobileNumber"));
			util.sendValue(driver.findElement(entry.Email), linkedHashMap.get("Email"));
			util.sendValue(driver.findElement(entry.WebSite), linkedHashMap.get("WebSite"));
			System.out.println(linkedHashMap.get("Industry"));
			System.out.println(linkedHashMap.get("LastName"));
			*/
			
			
			 
		List<List<HSSFCell>> data = excel.getSheetData(sheetNo);
		System.out.println(data);
		System.out.println(data.size());
		for (int i = 1; i < data.size(); i++) {
			Thread.sleep(3000);
			List list = data.get(rowNo);
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.size());
				HSSFCell lang = (HSSFCell) list.get(list.size()-1);
				System.out.println(lang);
				HSSFCell cell = (HSSFCell) list.get(j);
				switch (j) {
				case 0:
					try {
						util.handleDropdown(driver.findElement(entry.Salutation), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 1:
					try {
						if (cell.getStringCellValue().isEmpty()||cell.getStringCellValue()==null){
							System.out.println(cell.getStringCellValue());
							break;}
							else {
						util.sendValue(driver.findElement(entry.FirstName), cell.getStringCellValue());
							}
						
					} catch (Exception e) {
					
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						util.sendValue(driver.findElement(entry.LastName), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						util.sendValue(driver.findElement(entry.CompanyName), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						util.sendValue(driver.findElement(entry.Designation), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
 
			/*	case 5:
					try {
						util.sendValue(driver.findElement(entry.OfficeNumber), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					try {
						util.sendValue(driver.findElement(entry.MobileNumber), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;*/
				case 7:
					try {
						util.sendValue(driver.findElement(entry.Email), cell.getStringCellValue());
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 8:
					try {
						util.sendValue(driver.findElement(entry.WebSite), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 9:
					try {
						util.sendValue(driver.findElement(entry.Street), cell.getStringCellValue());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 10:
					try {
						util.handleDropdown(driver.findElement(entry.Country), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 11:
					try {
						util.handleDropdown(driver.findElement(entry.Staet), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				case 12:
					try {
						util.handleDropdown(driver.findElement(entry.City), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 13:
					try {
						util.sendValue(driver.findElement(entry.PostalCode), ((int) cell.getNumericCellValue()) + "");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 14:
					try {
						util.handleDropdown(driver.findElement(entry.Industry), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 15:
					try {
						util.sendValue(driver.findElement(entry.CompanyDeScription), cell.getStringCellValue());
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 16:
					try {
						util.handleDropdown(driver.findElement(entry.LeadSource), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 17:
					
						util.handleDropdown(driver.findElement(entry.LeadStatus), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + i);
						
					break;
				case 18:
					try {
						util.handleDropdown(driver.findElement(entry.AssignedTo), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + j);
						System.out.println(i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();	
					}
					break;
					
				case 19:
					try {
						util.handleDropdown(driver.findElement(entry.MainBusiness), cell.getStringCellValue());
						System.out.println(cell.getStringCellValue() + " : " + j);
						System.out.println(i);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;	
					}
					return;
				default:
					break;
				}

			}
		}
		Thread.sleep(3000);
	}
	}
	
	
		


