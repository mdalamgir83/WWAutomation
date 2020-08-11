package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LocationPage;
import pages.FindWorkshopPage;


public class BaseTest {

	static WebDriver driver;
	static HomePage home;
	static FindWorkshopPage workShop;
	static LocationPage locationPage;
	static String nameOfDays [] = {"sunday","monday","tuesday","wednesday","thursday","friday"};
	
	public static void main(String[] args) {
         
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe"); //setting Firefox browser path
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        home = new HomePage(driver);
        driver.get(home.pageUrl);		//Navigate to WW home page
		home.isPageTitleMatched();  	// matching home page title as expected
		home.goToWorkShopPage();		//click "Find a Workshop"
		
		workShop = new FindWorkshopPage(driver);
		workShop.isPageTitleMatched();				// matching Workshop page title as expected
		workShop.inputLocation().sendKeys("10011"); // searching for meetings for zipcode: 10011
		workShop.searchButton().click();
		workShop.locationDetails(0); //getting first location name, distance and matching location name after selecting
		
		locationPage = new LocationPage(driver);
		locationPage.operationHoursToday(); 		// print TODAY’s hours of operation 
		locationPage.printMeetings("Thursday"); // print number of meeting  each person has on Thursday
		
	/*  // print number of meeting the each person has a particular day of the week
		for(int i=0; i < nameOfDays.length; i++) 	
		{
			locationPage.printMeetings(nameOfDays[i]);
		} */
		
	} 
	



}
