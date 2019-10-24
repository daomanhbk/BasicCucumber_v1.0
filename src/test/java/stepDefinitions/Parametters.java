package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Parametters {
	WebDriver driver;

	@When("^I navigate to Log in Bank guru page \"(.*)\"$")
	public void i_navigate_to_Log_in_Bank_guru_page(String url) throws Throwable {
		ChromeDriverManager.getInstance().version("76.0.3809.132").setup();
		driver = new ChromeDriver();
		driver.get(url);

	}

	@When("^I input account with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_input_account_with_username_and_password(String username, String password) throws Throwable {
		WebElement USERID = driver.findElement(By.xpath("//input[@name='uid']"));
		USERID.sendKeys(username);
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD.sendKeys(password);
	}

	@When("^Click Login$")
	public void click_Login() throws Throwable {
		WebElement LOGIN = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		LOGIN.click();
	}

	@When("^I verify message log in successfully welcome to manager \"(.*)\"$")
	public void i_verify_message_log_in_successfully_welcome_to_manager(String welcomeLbl) throws Throwable {
		WebElement WELCOMELBL = driver.findElement(By.xpath("//marquee[@behavior='alternate']"));
		String acctualMessage = WELCOMELBL.getText();
		Assert.assertTrue(acctualMessage.contains(welcomeLbl));
	}

	@When("^close chrome browser$")
	public void close_chrome_browser() throws Throwable {
		driver.close();

	}
}
