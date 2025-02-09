package tests.api;

import api.Specs;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetSpecificUser {

    @Test
    void getSpecificUser () {

        Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());

        RestAssured
                .given()
                .when()
                .pathParam("userId", "2")
                    .get("/users/{userId}")
                .then()
                    .statusCode(200);

    }
}
