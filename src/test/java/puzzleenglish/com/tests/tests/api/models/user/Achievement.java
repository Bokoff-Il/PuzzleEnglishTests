package puzzleenglish.com.tests.tests.api.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Achievement {
    String title;
    String description;
    Integer progress;
}