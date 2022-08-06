package puzzleenglish.com.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/api.properties")
public interface APIConfig extends Config {
    String baseUri();
    String cookieName();
    String cookieValue();
}
