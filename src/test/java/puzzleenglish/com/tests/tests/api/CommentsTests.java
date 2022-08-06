package puzzleenglish.com.tests.tests.api;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import puzzleenglish.com.tests.tests.api.models.Response;
import puzzleenglish.com.tests.tests.api.models.comment.Comment;
import puzzleenglish.com.tests.tests.api.models.comment.CommentsResponse;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static puzzleenglish.com.tests.tests.api.specs.Specs.requestComments;
import static puzzleenglish.com.tests.tests.api.specs.Specs.responseSuccess;

@Epic("API")
@Feature("Комментарии")
@Owner("ibokov")
@Tag("api")
public class CommentsTests {

    @Test
    @AllureId("11306")
    @DisplayName("Проверка комментариев пользователя")
    public void checkUsersComments() {
        CommentsResponse response = given()
                .spec(requestComments)
                .formParam("page", 1)
                .formParam("user_id", 10144779)
                .when()
                .post("/getMyComments")
                .then()
                .spec(responseSuccess)
                .extract().as(CommentsResponse.class);

        Comment[] comments = response.getComments();

        assertThat(comments.length).isEqualTo(1);
        assertThat(comments[0].getCommentId()).isEqualTo("10513973");
        assertThat(comments[0].getCommentAuthor()).isEqualTo("bokoff.il");
        assertThat(comments[0].getCommentContent()).isEqualTo("Спасибо за урок");
    }

    @Test
    @AllureId("11307")
    @DisplayName("Проверка избранных комментариев пользователя")
    public void checkUsersFavoriteComments() {
        CommentsResponse response = given()
                .spec(requestComments)
                .formParam("offset", 0)
                .formParam("type", 1)
                .formParam("user_id", 10144779)
                .when()
                .post("/getFavoriteComments")
                .then()
                .spec(responseSuccess)
                .extract().as(CommentsResponse.class);

        Comment[] comments = response.getComments();

        assertThat(comments.length).isEqualTo(2);

        assertThat(comments[0].getCommentId()).isEqualTo("10227966");
        assertThat(comments[0].getCommentAuthor()).isEqualTo("Мария");
        assertThat(comments[0].getCommentContent()).isEqualTo("Мы уже готовы - We are already ready.");

        assertThat(comments[1].getCommentId()).isEqualTo("10504696");
        assertThat(comments[1].getCommentAuthor()).isEqualTo("d-olinka");
        assertThat(comments[1].getCommentContent()).isEqualTo("Здравствуйте. Видео не включается второй день, невозможно пройти урок");
    }

    @Test
    @AllureId("11308")
    @DisplayName("Проверка комментариев на посте")
    public void checkPostsComments() {
        Response response = given()
                .spec(requestComments)
                .formParam("post_id", 3018)
                .formParam("phrase_index", 0)
                .formParam("pe_type", "mt_atom")
                .when()
                .post("/getComments")
                .then()
                .spec(responseSuccess)
                .extract().as(Response.class);

        Comment[] comments = response.getResponse().getComments();

        assertThat(comments).isNotEmpty();
        assertThat(response.getResponse().getAllCommentsCount()).isEqualTo(13);
    }
}