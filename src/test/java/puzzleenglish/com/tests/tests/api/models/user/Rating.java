package puzzleenglish.com.tests.tests.api.models.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {
    @JsonProperty("user_id")
    String userId;
    String rownum;
    String rank;
}
