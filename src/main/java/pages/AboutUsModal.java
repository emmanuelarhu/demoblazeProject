package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * AboutUsModal class containing all elements and actions for the about us modal
 */
public class AboutUsModal extends BasePage {

    private final SelenideElement modalTitle = $(byText("About us ×"));
    private final SelenideElement videoMessage = $(byText("No compatible source was"));
    private final SelenideElement closeButton = $("#videoModal").$(byText("Close"));

    /**
     * Close the about us modal
     */
    public void close() {
        logger.info("Closing about us modal");
        clickElement(closeButton);
    }

    // Getter methods for verification
    public SelenideElement getModalTitle() { return modalTitle; }
    public SelenideElement getVideoMessage() { return videoMessage; }
    public SelenideElement getCloseButton() { return closeButton; }
}