package puzzleenglish.com.tests.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import puzzleenglish.com.tests.tests.api.models.comment.Comment;
import puzzleenglish.com.tests.tests.api.models.user.Achievement;
import puzzleenglish.com.tests.tests.api.models.user.Rating;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PuzzleEnglishResponse {
    Boolean status;
    UserResponse response;

    public Achievement[] getAchievements() {
        return response.userInfo.achievements;
    }

    public Rating[] getRating() {
        return response.rating;
    }

    public Comment[] getComments() {
        return response.comments;
    }

    public Integer getCountComments() {
        return response.getAllCommentsCount();
    }
}
