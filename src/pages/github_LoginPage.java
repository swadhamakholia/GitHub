// Github Login Page

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class github_LoginPage {

	WebDriver driver;

	@FindBy(id="login_field")
	WebElement userName;

	@FindBy(name="password")
	WebElement passWord;

	@FindBy(name="commit")
	WebElement signIn;


	public github_LoginPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void setUserName(String strUserName){

		userName.sendKeys(strUserName); // Sets username in textbox
	}

	public void setPassword(String strPassword){

		passWord.sendKeys(strPassword);   //Sets password in password textbox
	}

	public void clickLogin(){

		signIn.click();
	}



	public String getLoginTitle(){

		return    driver.getTitle();  //Get the title of Login Page
	}


	public void loginToGithub(String strUserName,String strPasword){

		this.setUserName(strUserName);      //Fill user name
		this.setPassword(strPasword);      //Fill password
	}

}

