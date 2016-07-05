package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class github_HomePage {
	
	 WebDriver driver;
	 
	 @FindBy(xpath="//a[text()='Sign in']")
	 WebElement signin;

	 public github_HomePage (WebDriver driver){

	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }
	 
	 public String getHomeTitle(){

 		return    driver.getTitle();  //Return the title of Home Page
 	}
	
	public void ClickSignIn(){

  	   signin.click();  
  
	}
	
	

}
