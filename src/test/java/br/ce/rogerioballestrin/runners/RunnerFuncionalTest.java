package br.ce.rogerioballestrin.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.ce.rogerioballestrin.steps",
		tags = {"~@ignore", "@funcionais"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerFuncionalTest {

	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rogerio Ballestrin\\eclipse-workspace\\CursoCucumber\\chromedriver.exe");
		driver.get("https://srbarriga.herokuapp.com");
	    driver.findElement(By.id("email")).sendKeys("b@b.com");
		driver.findElement(By.id("senha")).sendKeys("b");
	    driver.findElement(By.tagName("button")).click();
	    driver.findElement(By.linkText("reset")).click();
	    driver.quit();
	}
}