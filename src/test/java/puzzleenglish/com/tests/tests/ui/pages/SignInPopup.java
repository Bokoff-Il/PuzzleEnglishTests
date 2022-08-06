package puzzleenglish.com.tests.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignInPopup {
    SelenideElement container = $("#signInPopup");
    SelenideElement email = $("#email");
    SelenideElement password = $("#password");
    SelenideElement signInButton = $(".signin-sign-in-form__button");

    @Step("Проверить заголовок попапа")
    public SignInPopup checkTitle(String text) {
        container.$(".puzzle-modal__title").shouldHave(text(text));
        return this;
    }

    @Step("Проверить, что открыто окно входа")
    public SignInPopup checkWindowExist() {
        container.shouldBe(visible);
        return this;
    }

    @Step("Ввести email")
    public SignInPopup fillEmail(String text) {
        email.setValue(text);
        return this;
    }

    @Step("Ввести пароль")
    public SignInPopup fillPassword(String text) {
        password.setValue(text);
        return this;
    }

    @Step("Нажать кнопку Войти на сайт")
    public SignInPopup clickSignIn() {
        signInButton.click();
        return this;
    }

    @Step("Проверить наличие ошибки входа")
    public SignInPopup checkErrorSignIn(String text) {
        container.$$(".puzzle-modal__error").shouldHave(itemWithText(text));
        return this;
    }
}
