package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;
	public String pageUrl = "https://www.weightwatchers.com/us/";
	public String expectedPageTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
    public By findWorkShop = By.className("Icon_icon__wrapper__3dIsp");

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    // click on "Find a Workshop"
    public void goToWorkShopPage() {

        driver.findElement(findWorkShop).click();
    }
    
    //validate the home page title
    public void isPageTitleMatched() {

       String actualTitle = driver.getTitle(); // get actual home page title
       if (expectedPageTitle.equals(actualTitle))
    	   System.out.println("Home page title matched");
       else
    	   System.out.println("Home page title didn't match");
    }
    
}

