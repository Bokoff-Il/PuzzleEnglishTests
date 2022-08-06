package puzzleenglish.com.tests.tests.ui.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("UI")
@Feature("Авторизация")
@Owner("ibokov")
@Tag("ui")
public class LoginTests extends TestBase {

    String email = appConfig.email();
    String password = appConfig.password();

    @Test
    @AllureId("11242")
    @DisplayName("Успешная авторизация")
    void successfulAuthorization() {
        mainPage.openPage()
                .clickSignIn();

        signInPopup.checkWindow()
                .checkTitle("Войти")
                .fillEmail(email)
                .fillPassword(password)
                .clickSignIn();

        mainPage.checkPersonalPlan("Личный план");
    }

    @Test
    @AllureId("11241")
    @DisplayName("Проверка ввода неверного email при авторизации")
    void fillInvalidEmail() {
        mainPage.openPage()
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
        mainPage.openPage()
                .clickSignIn();
        signInPopup.checkWindow()
                .checkTitle("Войти")
                .fillEmail(email)
                .fillPassword("1111")
                .clickSignIn()
                .checkErrorSignIn("Неверный пароль");
    }
}