package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

/**
 * Base page class containing common functionality for all page objects
 */
public class BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    /**
     * Navigate to specified URL
     * @param url URL to navigate to
     */
    @Step("Navigate to URL: {url}")
    public void goTo(String url) {
        logger.info("Navigating to URL: {}", url);
        open(url);
    }

    /**
     * Click on specified element
     * @param element SelenideElement to click
     */
    @Step("Click element")
    public void clickElement(SelenideElement element) {
        logger.debug("Clicking element: {}", element);
        element.shouldBe(Condition.visible, DEFAULT_TIMEOUT);
        element.click();
    }

    /**
     * Fill input field with specified text
     * @param element SelenideElement input field
     * @param text Text to fill
     */
    @Step("Fill input with text: {text}")
    public void fillInput(SelenideElement element, String text) {
        logger.debug("Filling input field with text: {}", text);
        element.shouldBe(Condition.visible, DEFAULT_TIMEOUT);
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

    /**
     * Take screenshot and attach to Allure report
     */
    @Step("Take screenshot")
    public void takeScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
            logger.debug("Screenshot taken and attached to Allure report");
        } catch (Exception e) {
            logger.error("Failed to take screenshot: {}", e.getMessage());
        }
    }

    /**
     * Get current page title
     * @return Page title
     */
    public String getPageTitle() {
        return title();
    }

    /**
     * Wait for element to be visible with custom timeout
     * @param element SelenideElement to wait for
     */
    protected void waitForElementToBeVisible(SelenideElement element) {
        element.shouldBe(Condition.visible, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for modal to close
     * @param modalElement Modal element to wait for
     */
    @Step("Wait for modal to close")
    protected void waitForModalToClose(SelenideElement modalElement) {
        modalElement.shouldBe(Condition.hidden, DEFAULT_TIMEOUT);
    }
}