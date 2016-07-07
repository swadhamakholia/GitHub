// Github Page after the repository has been created but the files are yet to be uploaded.

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creating_repo {
	private WebDriver driver;

	@FindBy(xpath="//div[@class='url-box']/span/input")
	private WebElement githubHttpsLink;

	public Creating_repo(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isRemoteLinkDisplayed() {
		if(githubHttpsLink.isDisplayed())
			return true;
		else
			return false;
	}

	public String getRemoteLink(){
		return githubHttpsLink.getAttribute("value");
	}

	public Created_repoPage Refresh() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(2000);
		return new Created_repoPage(driver);
	}
}
