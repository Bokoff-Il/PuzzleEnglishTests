package puzzleenglish.com.tests.tests.ui.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import puzzleenglish.com.tests.tests.ui.data.QuestionsData;
import puzzleenglish.com.tests.tests.ui.pages.MainPage;
import puzzleenglish.com.tests.tests.ui.pages.QuestionsPersonalPlanPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("UI")
@Feature("Главная страница")
@Owner("ibokov")
@Tag("ui")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    QuestionsPersonalPlanPage questionsPersonalPlanPage = new QuestionsPersonalPlanPage();

    @Test
    @AllureId("11243")
    @DisplayName("Проверка заголовков и наличия кнопки 'Начать заниматься' на главной странице")
    void checkTitleAndButton() {
       mainPage.openMainPage()
               .checkMainTitle("Выучите английский с Puzzle English\nи верните 30% за обучение! ")
               .checkSubTitle("Нескучное онлайн-обучение английскому языку с помощью игр и интересных заданий в любое удобное для вас время ")
               .checkButtonStartStudy("Начать заниматься");
    }
    @Test
    @AllureId("11244")
    @DisplayName("Проверка вопросов личного плана")
    void checkQuestionsPersonalPlan() {
        QuestionsData firstQuestionsData = new QuestionsData().setFirstQuestions();
        QuestionsData secondQuestionsData = new QuestionsData().setSecondQuestions();
        QuestionsData thirdQuestionsData = new QuestionsData().setThirdQuestions();
        QuestionsData fourthQuestionsData = new QuestionsData().setFourthQuestions();
        QuestionsData fifthQuestionsData = new QuestionsData().setFifthQuestions();

        questionsPersonalPlanPage.openQuestionsPage()
                .checkQuestionsData(firstQuestionsData)
                .chooseAnswer("Совсем ноль")
                .checkQuestionsData(secondQuestionsData)
                .chooseAnswer("45 минут")
                .checkQuestionsData(thirdQuestionsData)
                .chooseAnswer("Работать")
                .checkQuestionsData(fourthQuestionsData)
                .chooseAnswer("Разговорный")
                .checkQuestionsData(fifthQuestionsData)
                .chooseAnswer("Самостоятельно");
    }
}