package puzzleenglish.com.tests.tests.api;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import puzzleenglish.com.tests.tests.api.models.user.Achievement;
import puzzleenglish.com.tests.tests.api.models.Response;
import puzzleenglish.com.tests.tests.api.models.user.Rating;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static puzzleenglish.com.tests.tests.api.specs.Specs.requestUsers;
import static puzzleenglish.com.tests.tests.api.specs.Specs.responseSuccess;

@Epic("API")
@Feature("Пользователи")
@Owner("ibokov")
@Tag("api")
public class UsersTests {
    @Test
    @AllureId("11309")
    @DisplayName("Проверка рейтинга пользователей")
    public void checkUserForRating() {
       Response response = given()
                .spec(requestUsers)
                .when()
                .get("/user/getUsersForRating")
                .then()
                .spec(responseSuccess)
                .extract().as(Response.class);

       Rating[] ratings = response.getResponse().getRating();
       assertThat(ratings).isNotEmpty();
    }

    @Test
    @AllureId("11310")
    @DisplayName("Проверка наград пользователя")
    public void checkAchievements() {
        String userId = "10144779";
        Achievement[] expectedAchievementList = {
                new Achievement().setAchievements("Превзошел своего Тичера", "Пройден любой курс Тичера", 100),
                new Achievement().setAchievements("Словоед", "Добавлено 100 слов в словарь", 100),
                new Achievement().setAchievements("Упорство и труд", "Выполнены 10 заданий Личного плана", 100),
                new Achievement().setAchievements("Не теряя времени", "На сайте 5 дней подряд", 100),
                new Achievement().setAchievements("Есть план!", "Пройдено ознакомление с личным планом", 100),
                new Achievement().setAchievements("10-ый уровень взят!", "Получен 10-ый уровень", 80),
                new Achievement().setAchievements("Игроман", "Сыграно 100 игр", 17),
                new Achievement().setAchievements("Поболтаем?", "Оставлено 10 комментариев", 10),
                new Achievement().setAchievements("Важный шаг", "Пройден тест на уровень языка", 0),
                new Achievement().setAchievements("Puzzle Hero", "3 дня в топе рейтинга", 0)
        };

        Response response = given()
                .spec(requestUsers)
                .when()
                .get("/userLK/getProgressPage?userId=" + userId)
                .then()
                .spec(responseSuccess)
                .extract().as(Response.class);

        Achievement[] actualAchievementList = response.getResponse().getUserInfo().getAchievements();

        for (int i = 0; i < expectedAchievementList.length; i++) {
            assertThat(actualAchievementList[i]).isEqualTo(expectedAchievementList[i]);
        }
    }
}