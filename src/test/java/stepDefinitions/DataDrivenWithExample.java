package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class DataDrivenWithExample {
	WebDriver driver;

	@Given("^User navigates to Bank Guru Home Page \"(.*)\"$")
	public void navigateToBankGuru(String url) {
		ChromeDriverManager.getInstance().version("76.0.3809.132").setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("^User input \"(.*)\" and \"(.*)\"$")
	public void inputUserNameAndPassword(String username, String password) {
		WebElement USERID = driver.findElement(By.xpath("//input[@name='uid']"));
		USERID.sendKeys(username);
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD.sendKeys(password);

	}

	@And("^Click Login button$")
	public void clickLogin() {
		WebElement LOGIN = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		LOGIN.click();

	}

	@And("^I verify \"(.*)\" is displayed correctly$")
	public void verifyUsername(String username) {
		WebElement USERNAMELBL = driver.findElement(By.xpath("//td[contains(text(),\"Manger\")]"));
		String userNameActual = USERNAMELBL.getText();
		Assert.assertTrue(userNameActual.contains(username));
	}

	@Then("^Close Chrome browser$")
	public void closeBrowser() {
		driver.quit();
	}
}
