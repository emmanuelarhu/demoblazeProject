package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * ContactModal class containing all elements and actions for the contact modal
 */
public class ContactModal extends BasePage {

    private final SelenideElement modalTitle = $("h4").$(byText("New message"));
    private final SelenideElement contactEmailField = $("#recipient-email");
    private final SelenideElement contactNameField = $("#recipient-name");
    private final SelenideElement messageField = $("#message-text");
    private final SelenideElement contactEmailLabel = $("[aria-labelledby='exampleModalLabel']").$("form").$("div").$(byText("Contact Email:"));
    private final SelenideElement contactNameLabel = $("[aria-labelledby='exampleModalLabel']").$("form").$("div").$(byText("Contact Name:"));
    private final SelenideElement messageLabel = $("[aria-labelledby='exampleModalLabel']").$("form").$("div").$(byText("Message:"));
    private final SelenideElement sendMessageButton = $("button").$(byText("Send message"));
    private final SelenideElement closeButton = $("[aria-labelledby='exampleModalLabel']").$(byText("Close"));

    /**
     * Send message with provided details
     * @param email Contact email
     * @param name Contact name
     * @param message Message content
     */
    public void sendMessage(String email, String name, String message) {
        logger.info("Sending message with email: {} and name: {}", email, name);
        fillInput(contactEmailField, email);
        fillInput(contactNameField, name);
        fillInput(messageField, message);

        // Handle potential alert dialog
        handleAlert();
        clickElement(sendMessageButton);
    }

    /**
     * Close the contact modal
     */
    public void close() {
        logger.info("Closing contact modal");
        clickElement(closeButton);
    }

    // Getter methods for verification
    public SelenideElement getModalTitle() { return modalTitle; }
    public SelenideElement getContactEmailField() { return contactEmailField; }
    public SelenideElement getContactNameField() { return contactNameField; }
    public SelenideElement getMessageField() { return messageField; }
    public SelenideElement getContactEmailLabel() { return contactEmailLabel; }
    public SelenideElement getContactNameLabel() { return contactNameLabel; }
    public SelenideElement getMessageLabel() { return messageLabel; }
    public SelenideElement getSendMessageButton() { return sendMessageButton; }
    public SelenideElement getCloseButton() { return closeButton; }
}