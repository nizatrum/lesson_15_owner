package owner_tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner_tests.config.AuthConfig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {

    @Test
    public void testLocalFile() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        assertThat(config.username()).isEqualTo("root");
        assertThat(config.password()).isEqualTo("dfltpwd");
    }

    @Test
    public void testRemoteFile() throws Exception {
        String content = "username=murtazintr\npassword=qwert";
        Path props = Paths.get("/tmp/auth.properties");
        Files.write(props, content.getBytes(StandardCharsets.UTF_8));

        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        assertThat(config.username()).isEqualTo("murtazintr");
        assertThat(config.password()).isEqualTo("qwert");
    }
}
