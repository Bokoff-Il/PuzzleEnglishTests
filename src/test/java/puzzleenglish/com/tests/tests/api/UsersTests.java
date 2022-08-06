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
        Achievement expectedFirstAchievement = new Achievement();
        expectedFirstAchievement.setTitle("Превзошел своего Тичера");
        expectedFirstAchievement.setDescription("Пройден любой курс Тичера");
        expectedFirstAchievement.setProgress(100);
        Achievement expectedSecondAchievement = new Achievement();
        expectedSecondAchievement.setTitle("Словоед");
        expectedSecondAchievement.setDescription("Добавлено 100 слов в словарь");
        expectedSecondAchievement.setProgress(100);

        Response response = given()
                .spec(requestUsers)
                .when()
                .get("/userLK/getProgressPage?userId=" + userId)
                .then()
                .spec(responseSuccess)
                .extract().as(Response.class);

        Achievement[] actualAchievementList = response.getResponse().getUserInfo().getAchievements();

        assertThat(actualAchievementList[0]).isEqualTo(expectedFirstAchievement);
        assertThat(actualAchievementList[1]).isEqualTo(expectedSecondAchievement);
    }
}