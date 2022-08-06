package puzzleenglish.com.tests.tests.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import puzzleenglish.com.tests.tests.ui.data.QuestionsData;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class QuestionsPersonalPlanPage {
    ElementsCollection numberQuestion = $$(".welcome-questions__progress");
    ElementsCollection textQuestions = $$(".welcome-questions-title");
    ElementsCollection listAnswer = $$("button.welcome-questions-list-item");

    @Step("Открыть страницу вопросов для личного плана")
    public QuestionsPersonalPlanPage openQuestionsPage() {
        open("/plan_questions");
        return this;
    }

    @Step("Проверить вопрос")
    public QuestionsPersonalPlanPage checkQuestionsData(QuestionsData data) {
        checkNumberQuestion(data.number)
                .checkTextQuestion(data.text)
                .checkListAnswer(data.answers);
        return this;
    }

    @Step("Проверить номер вопроса")
    private QuestionsPersonalPlanPage checkNumberQuestion(Integer number) {
        numberQuestion.shouldHave(itemWithText(format("Вопрос %s Из 5", number)));
        return this;
    }

    @Step("Проверить текст вопроса")
    private QuestionsPersonalPlanPage checkTextQuestion(String text) {
        textQuestions.shouldHave(itemWithText(text));
        return this;
    }

    @Step("Проверить список ответов")
    private QuestionsPersonalPlanPage checkListAnswer(String[] answers) {
        for (String answer : answers) {
            listAnswer.shouldHave(itemWithText(answer));
        }
        return this;
    }

    @Step("Выбрать вариант ответа")
    public QuestionsPersonalPlanPage chooseAnswer(String answer) {
        listAnswer.findBy(attribute("data-ru-text", answer)).click();
        return this;
    }
}
