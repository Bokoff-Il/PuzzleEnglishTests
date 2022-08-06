package puzzleenglish.com.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/puzzleenglish.properties")
public interface PuzzleEnglish extends Config {
    String email();
    String password();
}