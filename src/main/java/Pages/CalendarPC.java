package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.DriverClass;

public class CalendarPC extends DriverClass{
	/*
	WebElement calendarContainer;


	public CalendarPC(final WebElement calendarContainer) {
		this.calendarContainer = calendarContainer;
	}*/

	static final String[] MONTHS = new String[] { 
			"Jan", "Feb", "Mar", "Apr", "May", 
			"Jun", "Jul", "Aug", "Sep", "Oct",
			"Nov", "Dec" 
			};

	/**
	 * 
	 * @param value1
	 * @throws InterruptedException
	 */
		public void setDate(String value1) throws InterruptedException {
		    final int dd;
			final int mm;
			final int yyyy;
			String date = value1.trim();
			String dateParts[] = date.split("/");
	        String day  = dateParts[0];
	        String month  = dateParts[1];
	        String year = dateParts[2];
	        dd = Integer.parseInt(day);
			mm = Integer.parseInt(month);
			yyyy = Integer.parseInt(year.trim());
			// Open months

			clickCalendarTitle();
			// Open Year range
			clickCalendarTitle();

			// is year present on calendar? no then navigate in loop;
			while (true) {
				final int no = checkYear(yyyy);
				if (no == 0) {
					break;
				} else if (no == -1) {
					goLeft();
				} else if (no == 1) {
					goRight();
				} else {
					System.out.println("Invalid option.");
				}
			}


		// select year
		//clickElementByText("" + yyyy);
		
		clickElementByText(String.valueOf(yyyy));
		System.out.println(String.valueOf(yyyy));
		

		// select month
		// convert int onth in MMM format
		final String monthToSelect = MONTHS[mm - 1];
		clickElementByText(monthToSelect);

		// select date
		selectDateByText(dd);

	}

		//Click on Right 
	private void goRight() {
		next.click();
		wait(1);
	}

	//Click on Left
	private void goLeft() {
		prev.click();
		wait(1);

	}

	private void selectDateByText(final int dd) {
		// select date excluding from other month.
		// Select all TD tags which are not having class as ajax__calendar_other
		final List<WebElement> allDates = driver.findElements(
				By.xpath(xpath));
		allDates.get(dd - 1).click();
		wait(2);
	}

	//Click on text from calendar 
	private void clickElementByText(final String txt) {
		driver.findElement(By.xpath("//td[contains(text(),'"+txt+"')]")).click();
		System.out.println(By.xpath("//td[contains(text(),'"+txt+"')]"));
		wait(2);
		//span[contains(text(),'Oct')]

	}

	public WebElement ele1;

	WebElement heading;
	WebElement next;
	WebElement prev;
	String xpath;
	
	
	private void clickCalendarTitle() {
		//Creating the id array for the each calendar
		String titles [] = {"(//th[@class='rdtSwitch'])[1]","(//th[@class='rdtSwitch'])[2]","(//th[@class='rdtSwitch'])[3]","(//th[@class='rdtSwitch'])[4]","(//th[@class='rdtSwitch'])[5]"};
		for (int i=0;i<titles.length;i++){
			WebElement titleOfCalendar = driver.findElement(By.xpath(titles[i]));
			if (titleOfCalendar.isDisplayed()){
				titleOfCalendar.click();
                 int titleOfCalendarposition = i+1;
                 System.out.println(titleOfCalendarposition);
                 //Save the header, next, prev for Each calendar by passing the index of array
                heading = driver.findElement(By.xpath("(//th[@class='rdtSwitch'])["+titleOfCalendarposition+"]"));
                 next = driver.findElement(By.xpath("(//th[@class='rdtNext'])["+titleOfCalendarposition+"]"));
                 prev = driver.findElement(By.xpath("(//th[@class='rdtPrev'])["+titleOfCalendarposition+"]"));
                 //Creating the Sring to get the day in the current month and exclude the previous month in calendar 
                xpath = "(//div[@class='rdtDays'])["+titleOfCalendarposition+"]/table/tbody/tr/td[@class!='rdtDay rdtOld']";
                 break;
			}
		}
		//driver.findElement(By.className("switch")).click();
		wait(2);
	}
	PCUtility util = new PCUtility();
	/**
	 * Creating wait
	 * @param sec
	 */
	private void wait(final int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (final Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 
	 * @param yyyy
	 * @return
	 * @throws InterruptedException
	 */
	int checkYear(final int yyyy) throws InterruptedException {
		WebElement title1 = heading;
		//Get the Text from the calendar title
		final String title = title1.getText();
		//Spliting from text
		String value[] = title.split("-");
		//Trimming the year if has space 
        String ar1 = value[0].trim();
        System.out.println(ar1);
        String ar2 = value[1].trim();
   				//By.xpath("//th[@class='switch']")).getText();
        //Converting to String to int
		final int min = Integer.parseInt(ar1);
		final int max = Integer.parseInt(ar2);
		// yyyy is less than range return -1
		if (yyyy < min) {
			return -1;
		}
		/// yyyy is greater than range retrun 1
		if (yyyy > max) {
			return 1;
		}
		/// yyyy in with in range return 0
		return 0;
	}
	

}
