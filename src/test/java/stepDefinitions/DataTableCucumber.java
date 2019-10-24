package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class DataTableCucumber {
	WebDriver driver;

	@Given("^New User navigates to Bank Guru Home Page \"(.*)\"$")
	public void navigateToBankGuruN(String url) {
		ChromeDriverManager.getInstance().version("76.0.3809.132").setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

//	@When("^I type account with user and pass$")
//	public void inputUserNameAndPassword() {
//		WebElement USERID = driver.findElement(By.xpath("//input[@name='uid']"));
//		USERID.sendKeys();
//		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name='password']"));
//		PASSWORD.sendKeys();
//
//	}

	@When("^I type account with user and pass$")
	public void i_type_account_with_user_and_pass(DataTable table) {
		for (Map<String, String> data : table.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(data.get("username"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
		}

	}

	@And("^User Click Login button$")
	public void clickLogin() {
		WebElement LOGIN = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		LOGIN.click();

	}

	@When("^User verifies message log in successfully welcome to manager \"(.*)\"$")
	public void i_verify_message_log_in_successfully_welcome_to_manager(String welcomeLbl) throws Throwable {
		WebElement WELCOMELBL = driver.findElement(By.xpath("//marquee[@behavior='alternate']"));
		String acctualMessage = WELCOMELBL.getText();
		Assert.assertTrue(acctualMessage.contains(welcomeLbl));
	}

	@And("^User End chrome browser$")
	public void close_chrome_browser() throws Throwable {
		driver.close();

	}
}
