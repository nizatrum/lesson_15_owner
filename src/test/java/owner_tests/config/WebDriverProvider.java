package owner_tests.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.function.Supplier;


public class WebDriverProvider implements Supplier<WebDriver> {
    // if using legacy config
    //private final LegacyWebDriverConfig config;
    private final WebDriverConfig config;
    public WebDriverProvider() {
        // if using legacy config
        // this.config = new LegacyWebDriverConfig();
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }
    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }
    private WebDriver createWebDriver() {
        if (Objects.nonNull(config.getBrowser())) {
            switch (config.getBrowser()) {
                case FIREFOX: {
                    return new FirefoxDriver();
                }
                case CHROME: {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    System.setProperty("webdriver.chrome.driver","/Users/macbook/Downloads/chromedriver-mac-arm64/chromedriver");
                    return new ChromeDriver(options);
                }
                default: {
                    throw new RuntimeException("This browser type is not supported");
                }
            }
        }
        throw new RuntimeException("Browser cannot be null");
    }
}
