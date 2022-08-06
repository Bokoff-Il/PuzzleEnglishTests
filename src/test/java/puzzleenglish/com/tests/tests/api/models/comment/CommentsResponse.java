package puzzleenglish.com.tests.tests.api.models.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsResponse {
    String success;
    Comment[] comments;
}