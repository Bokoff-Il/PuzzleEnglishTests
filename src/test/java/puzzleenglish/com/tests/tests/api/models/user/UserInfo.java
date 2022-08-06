package puzzleenglish.com.tests.tests.api.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
    String rating;
    public Achievement[] achievements;
}



