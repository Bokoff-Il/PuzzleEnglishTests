package puzzleenglish.com.tests.tests.ui.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import puzzleenglish.com.tests.config.PuzzleEnglish;
import puzzleenglish.com.tests.tests.ui.pages.MainPage;
import puzzleenglish.com.tests.tests.ui.pages.SignInPopup;

@Epic("UI")
@Feature("Авторизация")
@Owner("ibokov")
@Tag("ui")
public class LoginTests extends TestBase {

    MainPage mainPage = new MainPage();
    SignInPopup signInPopup = new SignInPopup();
    PuzzleEnglish puzzleEnglish = ConfigFactory.create(PuzzleEnglish.class);
    String email = puzzleEnglish.email();
    String password = puzzleEnglish.password();


    @Test
    @AllureId("11241")
    @DisplayName("Проверка ввода неверного email при авторизации")
    void fillInvalidEmail() {
        mainPage.openMainPage()
                .clickSignIn();
        signInPopup.checkWindow()
                .checkTitle("Войти")
                .fillEmail("1111")
                .fillPassword("1111")
                .clickSignIn()
                .checkErrorSignIn("Введён неверный email");
    }

    @Test
    @AllureId("11240")
    @DisplayName("Проверка ввода неверного пароля при авторизации")
    void fillIncorrectPassword() {
        mainPage.openMainPage()
                .clickSignIn();
        signInPopup.checkWindow()
                .checkTitle("Войти")
                .fillEmail(email)
                .fillPassword("1111")
                .clickSignIn()
                .checkErrorSignIn("Неверный пароль");
    }

    @Test
    @AllureId("11242")
    @DisplayName("Успешная авторизация")
    void successfulAuthorization() {
        mainPage.openMainPage()
                .clickSignIn();

        signInPopup.checkWindow()
                .checkTitle("Войти")
                .fillEmail(email)
                .fillPassword(password)
                .clickSignIn();

        mainPage.checkPersonalPlan("Личный план");
    }
}
