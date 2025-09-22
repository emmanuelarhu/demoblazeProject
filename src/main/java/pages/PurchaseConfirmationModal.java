package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * PurchaseConfirmationModal class containing all elements and actions for the purchase confirmation modal
 */
public class PurchaseConfirmationModal extends BasePage {

    private final SelenideElement thankYouHeading = $("h2").$(byText("Thank you for your purchase!"));
    private final SelenideElement okButton = $("button").$(byText("OK"));

    /**
     * Click OK button to close confirmation modal
     */
    public void clickOk() {
        logger.info("Clicking OK button on purchase confirmation");
        clickElement(okButton);
    }

    // Getter methods for verification
    public SelenideElement getThankYouHeading() { return thankYouHeading; }
    public SelenideElement getOkButton() { return okButton; }
}