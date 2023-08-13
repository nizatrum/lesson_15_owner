package owner_tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner_tests.config.FruitsConfig;
import static org.assertj.core.api.Assertions.assertThat;


public class FruitsTest {
    @Test
    public void testArray() {
        System.setProperty("array", "orange,banana,apple");
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArray()).containsExactly("orange", "banana", "apple");
    }

    @Test
    public void testArrayWithDefault() {
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArrayWithDefault())
                .containsExactlyInAnyOrder("orange","watermelon","lemon","strawberry","mango","banana","apple" );
    }

    @Test
    public void testList() {
        System.setProperty("list", "orange,banana,apple");
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsList()).containsExactly("orange", "banana", "apple");
    }

    @Test
    public void testListWithSeparator() {
        System.setProperty("list-with-separator", "orange;banana;apple");
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsWithSeparator()).containsExactly("orange", "banana", "apple");
    }
}
