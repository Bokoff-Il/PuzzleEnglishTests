package puzzleenglish.com.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/app.properties")
public interface AppConfig extends Config {
    @DefaultValue("https://puzzle-english.com")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("91.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    @DefaultValue("selenoid.autotests.cloud/wd/hub")
    String remoteDriverUrl();
}
