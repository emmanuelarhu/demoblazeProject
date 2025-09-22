package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PageManager;

import static com.codeborne.selenide.Selenide.closeWebDriver;

/**
 * BaseTest class containing common setup and teardown for all tests
 */
public class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected PageManager pm;
    protected SoftAssertions softly;

    @BeforeSuite
    public void setUpSuite() {
        logger.info("Setting up test suite");

        // Configure WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.reopenBrowserOnFail = true;
        Configuration.clickViaJs = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        // Enable Selenide logging (Allure integration can be added later if needed)
        // SelenideLogger.addListener("AllureSelenide", new io.qameta.allure.selenide.AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up test method");
        pm = new PageManager();
        softly = new SoftAssertions();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down test method");
        try {
            // Assert all soft assertions
            softly.assertAll();
        } finally {
            // Close browser
            closeWebDriver();
        }
    }
}