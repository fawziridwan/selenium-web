package com.automation.page;

import com.automation.config.ConfigReader;
import com.automation.utils.ApplicationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final ApplicationUtils utils;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.utils = new ApplicationUtils(driver, wait);
        PageFactory.initElements(driver, this);
    }

    // Page Factory Locators
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement flashMessage;

    @FindBy(className = "login_logo")
    private WebElement loginHeader;

    public void navigateToLoginPage() {
        utils.navigateToUrl(ConfigReader.getBaseUrl());
        utils.waitForElementToBeVisible(loginHeader);
    }

    public void login(String username, String password) {
        utils.enterText(usernameField, username);
        utils.enterText(passwordField, password);
        utils.clickElement(loginButton);
    }

    public String getFlashMessage() {
        return utils.getElementText(flashMessage);
    }

    public boolean isLoginPageDisplayed() {
        return utils.isElementDisplayed(loginHeader) && utils.isElementDisplayed(usernameField) && utils.isElementDisplayed(passwordField);
    }

    public boolean isErrorMessageDisplayed() {
        return utils.isElementDisplayed(flashMessage);
    }
}