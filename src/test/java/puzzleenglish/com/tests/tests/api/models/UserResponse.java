package puzzleenglish.com.tests.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import puzzleenglish.com.tests.tests.api.models.comment.Comment;
import puzzleenglish.com.tests.tests.api.models.user.Rating;
import puzzleenglish.com.tests.tests.api.models.user.UserInfo;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    @JsonProperty("user_info")
    public UserInfo userInfo;
    public Rating[] rating;
    public Comment[] comments;
    public Integer allCommentsCount;
}
