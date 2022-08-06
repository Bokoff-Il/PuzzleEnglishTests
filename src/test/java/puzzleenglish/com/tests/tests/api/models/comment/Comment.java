package puzzleenglish.com.tests.tests.api.models.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    @JsonProperty("comment_ID")
    String commentId;

    @JsonProperty("comment_author")
    String commentAuthor;

    @JsonProperty("comment_content")
    String commentContent;

}
