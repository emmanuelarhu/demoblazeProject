package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

/**
 * AboutUsModal test class containing tests for about us modal elements and functionality
 */
public class AboutUsModalTest extends BaseTest {

    @Test(description = "Verify about us modal elements and close functionality")
    public void verifyAboutUsModalElementsAndCloseFunctionality() {
        logger.info("Starting about us modal verification test");

        // Navigate to homepage and open about us modal
        pm.homePage.navigateToHomePage();
        pm.homePage.clickAboutUs();

        // Verify about us modal elements
        softly.assertThat(pm.aboutUsModal.getModalTitle().is(visible))
                .as("About us modal title should be visible")
                .isTrue();

        softly.assertThat(pm.aboutUsModal.getVideoMessage().is(visible))
                .as("Video message should be visible")
                .isTrue();

        softly.assertThat(pm.aboutUsModal.getCloseButton().is(visible))
                .as("Close button should be visible")
                .isTrue();

        // Close the modal
        pm.aboutUsModal.close();

        logger.info("About us modal verification test completed");
    }
}