package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * LoginModal class containing all elements and actions for the login modal
 */
public class LoginModal extends BasePage {

    private final SelenideElement modalDialog = $("#logInModal");
    private final SelenideElement modalTitle = $("#logInModalLabel");
    private final SelenideElement usernameField = $("#loginusername");
    private final SelenideElement passwordField = $("#loginpassword");
    private final SelenideElement usernameLabel = $("label[for='loginusername']");
    private final SelenideElement passwordLabel = $("label[for='loginpassword']");
    private final SelenideElement loginButton = $("#logInModal .btn-primary");
    private final SelenideElement closeButton = $("#logInModal .btn-secondary");

    /**
     * Wait for login modal to be visible
     */
    public void waitForModalToLoad() {
        waitForElementToBeVisible(modalDialog);
        waitForElementToBeVisible(usernameField);
    }

    /**
     * Perform login with provided credentials
     * @param username Username to login with
     * @param password Password to login with
     */
    public void login(String username, String password) {
        logger.info("Performing login with username: {}", username);
        waitForModalToLoad();
        fillInput(usernameField, username);
        fillInput(passwordField, password);
        clickElement(loginButton);
    }

    /**
     * Close the login modal
     */
    public void close() {
        logger.info("Closing login modal");
        clickElement(closeButton);
    }

    // Getter methods for verification
    public SelenideElement getModalDialog() { return modalDialog; }
    public SelenideElement getModalTitle() { return modalTitle; }
    public SelenideElement getUsernameField() { return usernameField; }
    public SelenideElement getPasswordField() { return passwordField; }
    public SelenideElement getUsernameLabel() { return usernameLabel; }
    public SelenideElement getPasswordLabel() { return passwordLabel; }
    public SelenideElement getLoginButton() { return loginButton; }
    public SelenideElement getCloseButton() { return closeButton; }
}