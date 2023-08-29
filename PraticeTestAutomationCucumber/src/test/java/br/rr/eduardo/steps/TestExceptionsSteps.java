package br.rr.eduardo.steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class TestExceptionsSteps {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Dado("que a página está aberta")
    public void abrirPagina() {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @Quando("eu clico no botão Adicionar")
    public void clicarNoBotaoAdicionar() {
        WebElement botaoAdicionar = driver.findElement(By.id("add_btn"));
        botaoAdicionar.click();
    }

    @Então("o campo de entrada da linha 2 deve estar visível")
    public void verificarCampoLinha2Visivel() {
        By campoLinha2Locator = By.cssSelector("#row2 > input");

        try {
            WebElement campoLinha2 = wait.until(ExpectedConditions.visibilityOfElementLocated(campoLinha2Locator));
            Assert.assertTrue(campoLinha2.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("O campo de entrada da linha 2 não está visível.");
        } finally {
            driver.quit();
        }
        
    }
}
