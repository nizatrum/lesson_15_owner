package owner_tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner_tests.config.IOSConfig;
import owner_tests.config.MobileConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {
    @Test
    public void testIOS() {
        System.setProperty("device", "iphone");
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.deviceName()).isEqualTo("iPhone Last");
        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("11");
    }
@Test
    public void testAndroid() {
        System.setProperty("device", "pixel");
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.deviceName()).isEqualTo("Google Pixel XL");
        assertThat(config.platformName()).isEqualTo("Android");
        assertThat(config.platformVersion()).isEqualTo("13.0");
    }
}
