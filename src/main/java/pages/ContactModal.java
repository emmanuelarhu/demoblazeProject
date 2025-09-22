package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * ContactModal class containing all elements and actions for the contact modal
 */
public class ContactModal extends BasePage {

    private final SelenideElement modalDialog = $("#exampleModal");
    private final SelenideElement modalTitle = $("#exampleModalLabel");
    private final SelenideElement contactEmailField = $("#recipient-email");
    private final SelenideElement contactNameField = $("#recipient-name");
    private final SelenideElement messageField = $("#message-text");
    private final SelenideElement contactEmailLabel = $("label[for='recipient-email']");
    private final SelenideElement contactNameLabel = $("label[for='recipient-name']");
    private final SelenideElement messageLabel = $("label[for='message-text']");
    private final SelenideElement sendMessageButton = $("#exampleModal .btn-primary");
    private final SelenideElement closeButton = $("#exampleModal .btn-secondary");

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