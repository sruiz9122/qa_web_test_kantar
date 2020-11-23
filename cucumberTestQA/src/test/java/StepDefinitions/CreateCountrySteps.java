package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class CreateCountrySteps {

	WebDriver driver = null;

	@Given("Open the site and log in username {string} and password {string}")
	public void open_the_site_and_log_in_username_and_password(String string, String string2) throws InterruptedException {
		System.out.println("Inside Step - log in user");

		String projectPath = System.getProperty("user.dir");
		String controllerPath = "/src/test/resources/drivers/chromedriver.exe";

		System.out.println("Inside Step - browser is open");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver" ,projectPath + controllerPath);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.navigate().to("https://amrs-dev.engkantar.com/");
		driver.findElement(By.name("user")).sendKeys(string);
		driver.findElement(By.name("password")).sendKeys(string2);
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		driver.getPageSource().contains("Welcome");

		Thread.sleep(2000);

	}

	@When("Into Home-Location-Countries")
	public void into_home_location_countries() throws InterruptedException {
		System.out.println("Inside Step - Into Home-Location-Countries");
		driver.findElement(By.xpath("//*[@id=\'left-panel\']/nav/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\'left-panel\']/nav/ul/li[1]/ul/li[1]")).click();

		Thread.sleep(2000);
	}

	@And("Click add button")
	public void click_add_button() throws InterruptedException {
		System.out.println("Inside Step - Click add button");
		driver.findElement(By.xpath("//*[@id=\'countryTable_wrapper\']/div[2]/div[1]/a")).click();
		Thread.sleep(2000);
	}

	@And("Click edit button")
	public void click_edit_button() throws InterruptedException {
		System.out.println("Inside Step - Click edit button");
		driver.findElement(By.xpath("//*[@id=\'countryTable\']/tbody/tr[1]/td[1]/a[1]")).click();
		Thread.sleep(2000);
	}

	@And("Insert Code {string}")
	public void insert_code(String string) throws InterruptedException {
		System.out.println("Inside Step - Insert into Code");
		driver.findElement(By.xpath("//*[@id=\'countryTable\']/tbody/tr[1]/td[2]/span/div/form/div/div[1]/div/input")).sendKeys(string);
		Thread.sleep(2000);
	}

	@And("Insert Name {string}")
	public void insert_name(String string) throws InterruptedException {
		System.out.println("Inside Step - Insert into Name");
		driver.findElement(By.xpath("//*[@id='s2id_autogen2']")).click();
		driver.findElement(By.xpath("//*[@id='s2id_autogen2']")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id='s2id_autogen2']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@And("Click save button")
	public void click_save_button() throws InterruptedException {
		System.out.println("Inside Step - Click save button");
		driver.findElement(By.xpath("//*[@id=\'countryTable\']/tbody/tr[1]/td[1]/a[3]/i")).click();
		Thread.sleep(2000);
	}

	@Then("User create a country")
	public void user_create_a_country() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
