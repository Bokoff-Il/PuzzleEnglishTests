package puzzleenglish.com.tests.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    SelenideElement mainTitle = $(".new-main__title");
    SelenideElement subTitle = $(".new-main__subtitle");
    SelenideElement startStudyButton = $(".new-main__orange-btn");
    SelenideElement signInButton = $(".btn_secondary");
    SelenideElement personPlan = $(".redesign-plan-top");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Проверить заголовок страницы")
    public MainPage checkMainTitle(String title) {
        checkText(mainTitle, title);
        return this;
    }

    @Step("Проверить подзаголовок страницы")
    public MainPage checkSubTitle(String title) {
        checkText(subTitle, title);
        return this;
    }

    @Step("Проверить наличие кнопки Начать заниматься")
    public MainPage checkButtonStartStudy(String text) {
        checkButton(startStudyButton, text);
        return this;
    }

    @Step("Проверить наличие кнопки и текст на кнопке")
    private MainPage checkButton(SelenideElement locator, String text) {
        locator.shouldBe(visible);
        locator.shouldHave(text(text));
        return this;
    }

    @Step("Проверить подзаголовок страницы")
    private MainPage checkText(SelenideElement locator, String text) {
        locator.shouldHave(text(text));
        return this;
    }

    @Step("Нажать кнопку Начать заниматься")
    public MainPage clickStartStudyButton() {
        startStudyButton.click();
        return this;
    }

    @Step("Нажать кнопку Вход")
    public MainPage clickSignIn() {
        signInButton.click();
        return this;
    }

    @Step("Проверить что открыта страница с Личным планом")
    public MainPage checkPersonalPlan(String text) {
        personPlan.shouldHave(text(text));
        return this;
    }
}
