package cucumberframework.steps;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "/chromdriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

	}
	
	@Given("User navigates to the {string} website")
	public void user_navigates_to_the_website(String url) {
		this.driver.get(url);
	}

	@Given("User click on Login portal")
	public void user_click_on_login_portal() {
	//	this.driver.findElement(By.xpath("//**[@id=\"login-portal\"]")).click();
		
		this.driver.findElement(By.id("login-portal")).click();	
	}

	@Given("User enters valid username {string}")
	public void user_enters_valid_username(String username) {
		
		//String winHandlerBefore = driver.getWindowHandle();
		
		for (String winHandler: driver.getWindowHandles()) {
			driver.switchTo().window(winHandler);
		}
		
		//this.driver.findElement(By.xpath("//*[@id="text"]")).sendKeys(username);
		this.driver.findElement(By.id("text")).sendKeys(username);
	}

	@Given("User enters valid password {string}")
	public void user_enters_valid_password(String password) {
		//this.driver.findElement(By.xpath("//*[@id="password"]")).sendKeys(password);
		this.driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		//this.driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		this.driver.findElement(By.id("login-button")).click();
	}

	@Then("An alert is displayed to the user with {string}")
	public void an_alert_is_displayed_to_the_user_with(String message) throws Throwable {
		// Web site throws the alert and we are here catching the alert and if we get alert then 
		// it means test is successful.
		try {
			
		}catch(Exception ex) {
			if (ex.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
				Alert a = driver.switchTo().alert();
				a.accept(); //Clicks on Ok
				assertEquals(a.getText(), message);
				driver.close();
				
			}
		}
		
		//WebElement askQuestionButton = 	this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div/a"));
		//assertEquals(true, askQuestionButton.isDisplayed());   
	}


}
