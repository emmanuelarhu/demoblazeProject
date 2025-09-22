package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * SignUpModal class containing all elements and actions for the signup modal
 */
public class SignUpModal extends BasePage {

    private final SelenideElement modalDialog = $("#signInModal");
    private final SelenideElement modalTitle = $("#signInModalLabel");
    private final SelenideElement usernameField = $("#sign-username");
    private final SelenideElement passwordField = $("#sign-password");
    private final SelenideElement usernameLabel = $("label[for='sign-username']");
    private final SelenideElement passwordLabel = $("label[for='sign-password']");
    private final SelenideElement signUpButton = $("#signInModal .btn-primary");
    private final SelenideElement closeButton = $("#signInModal .btn-secondary");

    /**
     * Wait for signup modal to be visible
     */
    public void waitForModalToLoad() {
        waitForElementToBeVisible(modalDialog);
        waitForElementToBeVisible(usernameField);
    }

    /**
     * Perform signup with provided credentials
     * @param username Username to signup with
     * @param password Password to signup with
     */
    public void signUp(String username, String password) {
        logger.info("Performing signup with username: {}", username);
        waitForModalToLoad();
        fillInput(usernameField, username);
        fillInput(passwordField, password);
        clickElement(signUpButton);

        // Handle potential alert dialog
        handleAlert();
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