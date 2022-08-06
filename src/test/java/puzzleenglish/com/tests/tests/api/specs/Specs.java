package puzzleenglish.com.tests.tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import puzzleenglish.com.tests.config.ApiConfig;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static puzzleenglish.com.tests.tests.api.helpers.CustomApiListener.withCustomTemplates;

public class Specs {
    static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class);

    public static RequestSpecification requestUsers = with()
            .filter(withCustomTemplates())
            .baseUri(apiConfig.baseUri())
            .basePath("/api2")
            .cookie(apiConfig.cookieName(), apiConfig.cookieValue())
            .contentType(JSON);

    public static RequestSpecification requestComments = with()
            .filter(withCustomTemplates())
            .baseUri(apiConfig.baseUri())
            .basePath("/api2/comments")
            .cookie(apiConfig.cookieName(), apiConfig.cookieValue())
            .contentType("application/x-www-form-urlencoded");

    public static ResponseSpecification responseSuccess = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.BODY)
            .build();
}