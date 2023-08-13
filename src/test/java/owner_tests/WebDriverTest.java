package owner_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import owner_tests.config.WebDriverProvider;


public class WebDriverTest {
    WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }
    @Test
    public void testGitHubTitle() {
        Assertions.assertEquals(driver.getTitle(), "GitHub: Let’s build from here · GitHub");
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}
