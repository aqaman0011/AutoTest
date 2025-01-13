package tests.api;

import api.Specs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetSpecificUser {

    @Test
    void getSpecificUser () {

        Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());

        RestAssured
                .given()
                .when()
                    .get("/users/2")
                .then()
                    .statusCode(200);

    }
}
