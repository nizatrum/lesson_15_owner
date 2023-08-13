package owner_tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner_tests.config.IOSConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class IOSTest {
    @Test
    public void testIOS() {
        IOSConfig config = ConfigFactory.create(IOSConfig.class, System.getProperties());
        assertThat(config.deviceName()).isEqualTo("iPhone Last");
        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("11");
    }
}
