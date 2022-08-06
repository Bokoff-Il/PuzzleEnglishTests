package puzzleenglish.com.tests.tests.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import puzzleenglish.com.tests.config.RemoteWebDriver;
import puzzleenglish.com.tests.tests.ui.helpers.Attach;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        RemoteWebDriver remoteWebDriver = ConfigFactory.create(RemoteWebDriver.class);
        String login = remoteWebDriver.login();
        String password = remoteWebDriver.password();

        String remote = System.getProperty("remote", "selenoid.autotests.cloud/wd/hub");

        Configuration.baseUrl = System.getProperty("baseUrl", "https://puzzle-english.com");
        Configuration.remote = "https://" + login + ":" + password + "@" + remote;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
