// Github Page after the repository has been created and files are uploaded.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ReadInfo.ReadFile;

public class Created_repoPage {

	WebDriver driver;
	WebElement PushedFile;

	public Created_repoPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		PushedFile = driver.findElement(By.xpath("//div[@class='file-wrap']//a[text()='"+ReadFile.Read_file("filename")+"']"));
	}

	public String getFileName(){
		return PushedFile.getText();
	}

}

