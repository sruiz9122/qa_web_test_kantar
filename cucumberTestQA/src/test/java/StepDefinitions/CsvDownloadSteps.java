package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cvsRead.CsvRead;
import io.cucumber.java.en.*;

public class CsvDownloadSteps {
	
	CsvRead csvRead;
	
	WebDriver driver = null;
	
	@Given("Csv Open the site and log in username {string} and password {string}")
	public void csv_open_the_site_and_log_in_username_and_password(String string, String string2) throws InterruptedException {
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

	@When("Csv Into Home-Location-Countries")
	public void csv_into_home_location_countries() throws InterruptedException {
		System.out.println("Inside Step - Into Home-Location-Countries");
		driver.findElement(By.xpath("//*[@id=\'left-panel\']/nav/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\'left-panel\']/nav/ul/li[1]/ul/li[1]")).click();

		Thread.sleep(2000);
	}

	@And("Click download CSV button")
	public void click_download_csv_button() throws InterruptedException {
		System.out.println("Inside Step - Click download CSV button");
		driver.findElement(By.xpath("//*[@id=\'ToolTables_countryTable_0\']/span")).click();
		Thread.sleep(2000);
	}

	@Then("Check CSV")
	public void check_csv() throws InterruptedException {
		System.out.println("Inside Step - Check CSV");
		CsvRead.main(null);
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
