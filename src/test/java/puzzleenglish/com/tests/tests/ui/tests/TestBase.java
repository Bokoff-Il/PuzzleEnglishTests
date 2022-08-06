package puzzleenglish.com.tests.tests.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import puzzleenglish.com.tests.config.APIConfig;
import puzzleenglish.com.tests.config.AppConfig;
import puzzleenglish.com.tests.config.RemoteDriverConfig;
import puzzleenglish.com.tests.tests.ui.helpers.Attach;
import puzzleenglish.com.tests.tests.ui.pages.MainPage;
import puzzleenglish.com.tests.tests.ui.pages.QuestionsPersonalPlanPage;
import puzzleenglish.com.tests.tests.ui.pages.SignInPopup;

import static java.lang.String.format;


public class TestBase {

    MainPage mainPage = new MainPage();
    QuestionsPersonalPlanPage questionsPersonalPlanPage = new QuestionsPersonalPlanPage();
    SignInPopup signInPopup = new SignInPopup();
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        AppConfig appConfig = ConfigFactory.create(AppConfig.class);
        RemoteDriverConfig remoteDriverConfig = ConfigFactory.create(RemoteDriverConfig.class);

        String login = remoteDriverConfig.login();
        String password = remoteDriverConfig.password();
        String remoteDriverUrl = appConfig.remoteDriverUrl();

        Configuration.baseUrl = appConfig.baseUrl();
        Configuration.remote = format("https://%s:%s@%s", login, password, remoteDriverUrl);
        Configuration.browser = appConfig.browser();
        Configuration.browserSize = appConfig.browserSize();
        Configuration.browserVersion = appConfig.browserVersion();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
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
