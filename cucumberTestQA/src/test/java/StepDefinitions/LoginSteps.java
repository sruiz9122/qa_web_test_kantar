package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		String projectPath = System.getProperty("user.dir");
		String controllerPath = "/src/test/resources/drivers/chromedriver.exe";
		
		System.out.println("Inside Step - browser is open");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver" ,projectPath + controllerPath);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("user is on url {string}")
	public void user_is_on_url(String url) {
		System.out.println("Inside Step - user is on engkantar com");
		driver.navigate().to(url);
	}

	@And("user enters username {string}")
	public void user_enters_username(String strUser) throws InterruptedException {
		System.out.println("Inside Step - user enters username");

		driver.findElement(By.name("user")).sendKeys(strUser);
		
		Thread.sleep(2000);

	}

	@And("user enters password {string}")
	public void user_enters_password(String strPass) throws InterruptedException {
		System.out.println("Inside Step - user enters password");

		driver.findElement(By.name("password")).sendKeys(strPass);
		
		Thread.sleep(2000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		System.out.println("Inside Step - clicks on login button");

		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside Step - user is navigated to the home page");
		
		driver.getPageSource().contains("Welcome");
		
		Thread.sleep(2000);	
		
		driver.close();
		driver.quit();
	}

}
