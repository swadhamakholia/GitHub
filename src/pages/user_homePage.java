// Github Page after the user has signed-in.

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class user_homePage {

	WebDriver driver;

	@FindBy(xpath="//div[@class='boxed-group-action']/a")
	WebElement NewRepo;

	public user_homePage(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getUserName() {
		if(driver instanceof JavascriptExecutor) {
			String userName= (String)((JavascriptExecutor)driver).executeScript("return document.getElementsByClassName(\"css-truncate-target\")[0].textContent;");
			return(userName);
		}
		else {
			return("web page not js enabled");

		}

	}

	public void clickNewRepo() {
		NewRepo.click();
	}
}
