package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_RepoPage {
		
		WebDriver driver;
	
		@FindBy(id="repository_name")
		WebElement Rep_name;

		 @FindBy(xpath="//div[@class='with-permission-fields']/button")
		 WebElement CreateRepo;
		 
		public New_RepoPage (WebDriver driver){

	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }
		
		public void setRepName(String RepoName){

			Rep_name.sendKeys(RepoName); 		// Sets username in text-box
		}
	 
		public String getRepTitle(){
		
 		return    driver.getTitle();  			//Return the title of Home Page
		}
	
		public void ClickCreateRepo(){

			CreateRepo.click();  
  	   
		}
	
	

}


