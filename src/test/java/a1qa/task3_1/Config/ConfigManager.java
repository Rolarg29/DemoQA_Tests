package a1qa.task3_1.Config;

import static org.aeonbits.owner.ConfigCache.getOrCreate;

public class ConfigManager {

    private ConfigManager() {
    }

    public static Configuration configuration() {
        return getOrCreate(Configuration.class);
    }
}
