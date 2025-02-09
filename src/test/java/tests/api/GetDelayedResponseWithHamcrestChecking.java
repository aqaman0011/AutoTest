package tests.api;

import api.Specs;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class GetDelayedResponseWithHamcrestChecking {

    @Test
    public void getDelayedResponse () {
        Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());

        RestAssured
                .given()
                .when()
                    .pathParam("users", "users")
                    .queryParam("delay", 3)
                    .get("/{users}")
                .then()
                    .statusCode(200)
                .body("$", hasKey("page")) // Проверяем, что JSON содержит ключ "page"
                .body("data[0].email", containsString("@reqres.in")); // Проверяем, что email содержит домен "@reqres.in"






    }

}
