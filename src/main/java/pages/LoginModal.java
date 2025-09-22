package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * LoginModal class containing all elements and actions for the login modal
 */
public class LoginModal extends BasePage {

    private final SelenideElement modalTitle = $(byText("Log in ×"));
    private final SelenideElement usernameField = $("#loginusername");
    private final SelenideElement passwordField = $("#loginpassword");
    private final SelenideElement usernameLabel = $("[aria-labelledby='logInModalLabel']").$("form").$("div").$(byText("Username:"));
    private final SelenideElement passwordLabel = $("[aria-labelledby='logInModalLabel']").$("form").$("div").$(byText("Password:"));
    private final SelenideElement loginButton = $("button").$(byText("Log in"));
    private final SelenideElement closeButton = $("[aria-labelledby='logInModalLabel']").$(byText("Close"));

    /**
     * Perform login with provided credentials
     * @param username Username to login with
     * @param password Password to login with
     */
    public void login(String username, String password) {
        logger.info("Performing login with username: {}", username);
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
    public SelenideElement getModalTitle() { return modalTitle; }
    public SelenideElement getUsernameField() { return usernameField; }
    public SelenideElement getPasswordField() { return passwordField; }
    public SelenideElement getUsernameLabel() { return usernameLabel; }
    public SelenideElement getPasswordLabel() { return passwordLabel; }
    public SelenideElement getLoginButton() { return loginButton; }
    public SelenideElement getCloseButton() { return closeButton; }
}