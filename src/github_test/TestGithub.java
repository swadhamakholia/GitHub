// Test cases for the GitHub automation.

package github_test;

import pages.*;
import ReadInfo.ReadFile;
import commandExec.commandExec;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGithub {

	WebDriver driver;
	github_HomePage home_obj;
	github_LoginPage login_obj;
	user_homePage user_obj;
	New_RepoPage rep_obj;
	Created_repoPage Created_obj;
	Creating_repo Creating_obj;

	@BeforeTest
	public void setup(){

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://github.com/");

	}

	@Test
	public void testGithubHome(){

		home_obj = new github_HomePage(driver);  												//Create Home Page object
		String HomePageTitle = home_obj.getHomeTitle();											//fetch home page title
		Assert.assertTrue(HomePageTitle.contains("How people build software · GitHub"));  		//Verify  page title
		home_obj.ClickSignIn();

	}

	@Test(dependsOnMethods= {"testGithubHome"})
	public void testGithubLogin() {

		login_obj = new github_LoginPage(driver);    												// Create Login page object
		String loginPageTitle = login_obj.getLoginTitle();   
		Assert.assertTrue(loginPageTitle.contains("Sign in to GitHub"));   							//Verify login page title
		login_obj.loginToGithub(ReadFile.Read_file("username"), ReadFile.Read_file("password"));  	//login to application
		login_obj.clickLogin();

	}
	@Test(dependsOnMethods= {"testGithubLogin"})
	public void testUserHomePage() {

		user_obj= new user_homePage(driver);
		String user= user_obj.getUserName();
		Assert.assertTrue(user.contains(ReadFile.Read_file("username"))); 
		user_obj.clickNewRepo();

	}

	@Test(dependsOnMethods= {"testUserHomePage"})
	public void testNewRepoPage() {

		rep_obj= new New_RepoPage(driver);
		String NewRepPageTitle = rep_obj.getRepTitle(); 
		Assert.assertEquals(NewRepPageTitle,"Create a New Repository"); 
		rep_obj.setRepName(ReadFile.Read_file("repository"));
		rep_obj.ClickCreateRepo();

	}

	@Test(dependsOnMethods= {"testNewRepoPage"})
	public void testLinkPage() {

		Creating_obj = new Creating_repo(driver);													
		Assert.assertEquals(Creating_obj.isRemoteLinkDisplayed(), true);

	}

	@Test(dependsOnMethods= {"testNewRepoPage"})
	public void CommandExec(){
		System.out.println((new java.util.Date()).getTime());
		List<String> commands = new ArrayList<String>();
		commands.add("cd Desktop");
		commands.add("mkdir "+ReadFile.Read_file("repository"));
		commands.add("cd "+ReadFile.Read_file("repository"));
		commands.add("touch "+ReadFile.Read_file("filename"));
		commands.add("git init");		
		commands.add("git remote add origin 'https://"+ReadFile.Read_file("username")+":"+ReadFile.Read_file("password")+"@github.com/"+ReadFile.Read_file("username")+"/"+ReadFile.Read_file("repository")+".git'");
		commands.add("git add .");
		commands.add("git commit -m \""+(new java.util.Date()).getTime()+"\"");
		commands.add("git push "+"'https://"+ReadFile.Read_file("username")+":"+ReadFile.Read_file("password")+"@github.com/"+ReadFile.Read_file("username")+"/"+ReadFile.Read_file("repository")+".git'"+" master");
		ReadFile.writeToFile("src/ScriptCommands.sh",commands);
		commandExec gitCommands = new commandExec();
		String[] str_arr = {"sh","src/ScriptCommands.sh"};
		System.out.println(gitCommands.execCommand(str_arr));
	}

	@Test(dependsOnMethods= {"CommandExec"})
	public void TestPushedFile() throws InterruptedException{
		Created_obj = Creating_obj.Refresh();
		Assert.assertEquals(ReadFile.Read_file("filename"), Created_obj.getFileName());

	}
}



