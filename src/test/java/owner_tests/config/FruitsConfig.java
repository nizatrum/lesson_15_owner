package owner_tests.config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {

    @Key("array")
    String[] getFruitsArray();
    @Key("array-with-default")
    @DefaultValue("orange,apple,watermelon,lemon,strawberry,mango,banana")
    String[] getFruitsArrayWithDefault();
    @Key("list")
    List<String> getFruitsList();

    @Key("list-with-separator")
    @Separator(";")
    List<String> getFruitsWithSeparator();

}
