package puzzleenglish.com.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/webdriver.properties")
public interface RemoteDriverConfig extends Config {
    String login();
    String password();
}