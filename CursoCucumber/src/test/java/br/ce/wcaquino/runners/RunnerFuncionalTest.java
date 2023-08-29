package br.ce.wcaquino.runners;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.jupiter.CucumberExtension;

@ExtendWith(CucumberExtension.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"br.ce.wcaquino.steps", "br.ce.wcaquino.config"},
    tags = {"@funcionais"},
    plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
    monochrome = false,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    dryRun = false,
    strict = false
)
public class RunnerFuncionalTest {

    @BeforeAll
    public static void reset() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
        driver.findElement(By.id("email")).sendKeys("a@a");
        driver.findElement(By.name("senha")).sendKeys("a");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
