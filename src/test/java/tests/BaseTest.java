package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PageManager;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.closeWebDriver;

/**
 * BaseTest class containing common setup and teardown for all tests
 */
public class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected PageManager pm;
    protected SoftAssertions softly;

    @BeforeSuite(alwaysRun = true)
    @Step("Setup test suite")
    public void setUpSuite() {
        logger.info("Setting up test suite");

        // Configure Selenide
        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        Configuration.browserSize = "1920x1080";
        Configuration.headless = Boolean.parseBoolean(System.getProperty("selenide.headless", "false"));
        Configuration.timeout = 10000;
        Configuration.reopenBrowserOnFail = true;
        Configuration.clickViaJs = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        // Setup WebDriverManager based on browser
        setupWebDriver();

        // Enable Allure Selenide listener
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        logger.info("Test suite setup completed");
    }

    @BeforeMethod(alwaysRun = true)
    @Step("Setup test method")
    public void setUp() {
        logger.info("Setting up test method");
        pm = new PageManager();
        softly = new SoftAssertions();
    }

    @AfterMethod(alwaysRun = true)
    @Step("Teardown test method")
    public void tearDown(ITestResult result) {
        logger.info("Tearing down test method");

        // Take screenshot on failure
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test failed: {}", result.getName());
            takeScreenshotOnFailure(result.getName());
        }

        try {
            // Assert all soft assertions
            softly.assertAll();
        } finally {
            // Close browser
            closeWebDriver();
        }
    }

    @AfterSuite(alwaysRun = true)
    @Step("Teardown test suite")
    public void tearDownSuite() {
        logger.info("Tearing down test suite");
        SelenideLogger.removeListener("AllureSelenide");
        logger.info("Test suite teardown completed");
    }

    /**
     * Setup WebDriver based on browser type
     */
    private void setupWebDriver() {
        String browser = Configuration.browser;
        logger.info("Setting up WebDriver for browser: {}", browser);

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                break;
            default:
                logger.warn("Unknown browser: {}. Defaulting to Chrome", browser);
                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
                break;
        }
    }

    /**
     * Take screenshot on test failure and attach to Allure report
     * @param testName Name of the failed test
     */
    @Step("Take screenshot on failure")
    private void takeScreenshotOnFailure(String testName) {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot on failure - " + testName, "image/png",
                    new ByteArrayInputStream(screenshot), "png");
                logger.info("Screenshot taken and attached to Allure report for failed test: {}", testName);
            }
        } catch (Exception e) {
            logger.error("Failed to take screenshot on test failure: {}", e.getMessage());
        }
    }

    /**
     * Take manual screenshot for debugging purposes
     * @param description Description for the screenshot
     */
    @Step("Take manual screenshot: {description}")
    protected void takeScreenshot(String description) {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(description, "image/png", new ByteArrayInputStream(screenshot), "png");
                logger.info("Manual screenshot taken: {}", description);
            }
        } catch (Exception e) {
            logger.error("Failed to take manual screenshot: {}", e.getMessage());
        }
    }
}