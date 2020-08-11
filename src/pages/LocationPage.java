package pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPage {
	public WebDriver driver;
	
    public By allDay = By.className("day-NhBOb");
    public By nameOfTheDay = By.className("dayName-1UpF5");
    public By listOfHours = By.className("meetingTime-1g52A");
    public By listOfPersons = By.className("meeting-14qIm");
    
	
    public LocationPage(WebDriver driver) {

        this.driver = driver;
    }
    
    // print today's meeting hours
    public void operationHoursToday() {
    	Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // get the day number of the week
		
		List<WebElement> today = driver.findElements(allDay);
		WebElement today_Info = today.get(dayOfWeek-1);

		String day = today_Info.findElement(nameOfTheDay).getText(); // get the day name of today
		System.out.println("Today is " + day);

		// printing list of hours for the day
		List<WebElement> hours = today_Info.findElements(listOfHours);

		System.out.println("Today's operation Hours");
		for (WebElement operationHours : hours) { 				// print the all operation hours 
			String operationHoursToday = operationHours.getText();
			System.out.println(operationHoursToday);
		}
		
    	
    }
    
    // print number of meeting the each person has a particular day of the week
    // can be done easily using css selectors or xpath.. but followed instruction 
    public void printMeetings(String dayName) {

		String nameOfDays [] = {"sun","mon","tue","wed","thu","fri"}; 
		List<WebElement> today = driver.findElements(allDay);
		WebElement today_Info;
		List<WebElement> allpersons;

		for(int day = 0; day < nameOfDays.length; day++) { 
			
			if (dayName.toLowerCase().contains(nameOfDays[day])){
				today_Info = today.get(day);
				allpersons = today_Info.findElements(listOfPersons);
				System.out.println(dayName + " meetings info:");
				String person [] = new String [allpersons.size()];
				
				for (int i= 0; i<allpersons.size(); i++) {
					String personName = allpersons.get(i).getText();
					String [] personNameOnly = personName.split("\\n");			//get only persons name
					person[i]= personNameOnly[1];
				}
							
		        int numberOfMeetings=1;    //Variable for getting Repeated word count
		        
		        for(int i=0;i<person.length;i++) {        
		        	
		           for(int j=i+1;j<person.length;j++) {	
		        	   
		        	   if(person[i].equals(person[j])) { 			//Checking for both strings are equal
		                 numberOfMeetings=numberOfMeetings+1;    	//if equal increment the count
		                 person[j]="0"; 							//Replace repeated words by zero
		              }
		           }
		           if(person[i]!="0")
		           System.out.println(person[i]+" has "+numberOfMeetings);
		           numberOfMeetings=1;
		           
		          }
			}

		}
			 
	}
      
        
}
