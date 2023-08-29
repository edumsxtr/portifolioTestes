package br.rr.eduardo.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPositiveSteps {

    WebDriver driver = new ChromeDriver();

    @Given("que eu esteja na página de login")
    public void navigateToLoginPage() {
        // Implemente a navegação para a página de login
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("eu insiro o nome de usuário {string} no campo de nome de usuário")
    public void enterUsername(String username) {
        // Implemente o preenchimento do campo de nome de usuário
        WebElement usernameField = driver.findElement(By.id("username")); // Use o ID correto
        usernameField.sendKeys(username);
    }

    @When("eu insiro a senha {string} no campo de senha")
    public void enterPassword(String password) {
        // Implemente o preenchimento do campo de senha
        WebElement passwordField = driver.findElement(By.id("password")); // Use o ID correto
        passwordField.sendKeys(password);
    }

    @When("eu clico no botão de envio")
    public void clickSubmitButton() {
        // Implemente o clique no botão de envio
        WebElement submitButton = driver.findElement(By.id("submit")); // Use o ID correto
        submitButton.click();
    }

    @Then("a URL da nova página deve conter {string}")
    public void verifyNewPageURL(String expectedURL) {
        // Implemente a verificação da URL da nova página
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    @Then("a nova página deve conter o texto esperado:")
    public void verifyNewPageText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Aguarda até 10 segundos
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedText));

        String actualPageText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(actualPageText.contains(expectedText));
    }

    @Then("o botão {string} deve estar visível na nova página")
    public void verifyButtonVisibility(String buttonText) {
        By buttonSelector = By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color");
        
        WebElement logoutButton = driver.findElement(buttonSelector);
        
        Assert.assertTrue(logoutButton.isDisplayed());
    }

  
    @Then("uma mensagem de erro deve ser exibida")
    public void verifyErrorMessageDisplayed() {
        // Implemente a verificação de exibição da mensagem de erro
    }

    @Then("o texto da mensagem de erro deve ser {string}")
    public void verifyErrorMessageText(String expectedErrorMessage) {
        // Implemente a verificação do texto da mensagem de erro
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}