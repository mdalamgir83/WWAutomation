package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindWorkshopPage {
	
	public WebDriver driver;
	public String expectedPageTitle = "Find WW Studios & Meetings Near You | WW USA";
    public By inputLocation = By.id("location-search");
    public By searchButton = By.id("location-search-cta");
    public By allLocations = By.className("linkUnderline-1_h4g");
    public By allDistances = By.className("distance-OhP63");
    public By locationTitle = By.className("locationName-1jro_");

    public FindWorkshopPage (WebDriver driver) {

        this.driver = driver;
    }
    
    //
    public WebElement inputLocation() {
    	return driver.findElement(inputLocation);
    }
    
    public WebElement searchButton() {
    	return driver.findElement(searchButton);
    }
    
    //validate Find a Workshop page title matched
    public void isPageTitleMatched() {

       String actualTitle = driver.getTitle();
       if (expectedPageTitle.contains(actualTitle))
    	   System.out.println("Work Shop page title matched");
       else
    	   System.out.println("Work Shop title didn't match");
    }
    
    // get any location name, distance and and match location name after selecting
    public void locationDetails(int row) {
    	// get location name
    	String locationName = driver.findElements(allLocations).get(row).getText();
    	System.out.println("Location Title: " + locationName);
    	
    	// get location distance
    	String distance = driver.findElements(allDistances).get(row).getText();
    	System.out.println("Location Distance: " + distance);
    	
    	//get actual Location tile
    	driver.findElements(allLocations).get(row).click();
    	String actualTitle = driver.findElements(locationTitle).get(row).getText();
		
    	// validate actual location tile match
    	if (actualTitle.equals(locationName))
    		System.out.println("Location title matched after selecting");
    	else
    		System.out.println("Location title did not matched after selecting");
  }
  
    


}
