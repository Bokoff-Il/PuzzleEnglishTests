package puzzleenglish.com.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/api.properties")
public interface ApiConfig extends Config {
    @DefaultValue("https://puzzle-english.com")
    String baseUri();

    String cookieName();

    String cookieValue();
}
