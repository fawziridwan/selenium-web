package com.automation.stepdefinitions;

import com.automation.config.BaseTest;
import com.automation.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinition {

    private final BaseTest baseTest;
    private LoginPage loginPage;

    public LoginStepDefinition(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("I am on the Sauce Demo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        loginPage = new LoginPage(baseTest.getDriver(), baseTest.getWait());
        loginPage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login Page is Not Displayed");
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("I should be redirected to the inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        Assert.assertTrue(baseTest.getDriver().getCurrentUrl().contains("inventory.html"),
                "Not redirected to inventory page. Current URL: " + baseTest.getDriver().getCurrentUrl());
    }

    @When("I try to log in with {string} and {string}")
    public void iTryToLogInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see an error message containing {string}")
    public void iShouldSeeAnErrorMessageContaining(String message) {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not visible");
        String actualErrorMessage = loginPage.getFlashMessage();
        Assert.assertTrue(actualErrorMessage.contains(message),
                "Error message text does not contain the expected text. Actual: " + actualErrorMessage + ", Expected: " + message);
    }
}