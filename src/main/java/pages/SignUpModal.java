package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * SignUpModal class containing all elements and actions for the signup modal
 */
public class SignUpModal extends BasePage {

    private final SelenideElement modalTitle = $(byText("Sign up ×"));
    private final SelenideElement usernameField = $("#sign-username");
    private final SelenideElement passwordField = $("#sign-password");
    private final SelenideElement usernameLabel = $("[aria-labelledby='signInModalLabel']").$("form").$("div").$(byText("Username:"));
    private final SelenideElement passwordLabel = $("[aria-labelledby='signInModalLabel']").$("form").$("div").$(byText("Password:"));
    private final SelenideElement signUpButton = $("button").$(byText("Sign up"));
    private final SelenideElement closeButton = $("[aria-labelledby='signInModalLabel']").$(byText("Close"));

    /**
     * Perform signup with provided credentials
     * @param username Username to signup with
     * @param password Password to signup with
     */
    public void signUp(String username, String password) {
        logger.info("Performing signup with username: {}", username);
        fillInput(usernameField, username);
        fillInput(passwordField, password);

        // Handle potential alert dialog
        handleAlert();
        clickElement(signUpButton);
    }

    /**
     * Close the signup modal
     */
    public void close() {
        logger.info("Closing signup modal");
        clickElement(closeButton);
    }

    // Getter methods for verification
    public SelenideElement getModalTitle() { return modalTitle; }
    public SelenideElement getUsernameField() { return usernameField; }
    public SelenideElement getPasswordField() { return passwordField; }
    public SelenideElement getUsernameLabel() { return usernameLabel; }
    public SelenideElement getPasswordLabel() { return passwordLabel; }
    public SelenideElement getSignUpButton() { return signUpButton; }
    public SelenideElement getCloseButton() { return closeButton; }
}