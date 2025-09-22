package pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

/**
 * Base page class containing common functionality for all page objects
 */
public class BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    /**
     * Navigate to specified URL
     * @param url URL to navigate to
     */
    public void goTo(String url) {
        logger.info("Navigating to URL: {}", url);
        open(url);
    }

    /**
     * Click on specified element
     * @param element SelenideElement to click
     */
    public void clickElement(SelenideElement element) {
        logger.debug("Clicking element: {}", element);
        element.click();
    }

    /**
     * Fill input field with specified text
     * @param element SelenideElement input field
     * @param text Text to fill
     */
    public void fillInput(SelenideElement element, String text) {
        logger.debug("Filling input field with text: {}", text);
        element.clear();
        element.setValue(text);
    }

    /**
     * Check if element is visible
     * @param element SelenideElement to check
     * @return true if visible, false otherwise
     */
    public boolean isElementVisible(SelenideElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            logger.debug("Element not visible: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Get text content of element
     * @param element SelenideElement to get text from
     * @return text content
     */
    public String getElementText(SelenideElement element) {
        return element.getText();
    }

    /**
     * Handle browser alerts/dialogs by accepting them
     */
    public void handleAlert() {
        try {
            switchTo().alert().accept();
            logger.debug("Alert handled successfully");
        } catch (Exception e) {
            logger.debug("No alert present or error handling alert: {}", e.getMessage());
        }
    }

    /**
     * Wait for page to load completely
     */
    public void waitForPageLoad() {
        // Selenide handles waiting automatically, but this method can be extended if needed
        logger.debug("Waiting for page load");
    }
}