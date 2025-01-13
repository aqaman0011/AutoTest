package tests.api;

import api.Specs;
import api.pojos.PostCreateNewUserOrderReq;
import api.pojos.PutUpdateUserDateResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PutUpdateUserDate {

    @Test
    void putUpdateUserDate () {

        Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());
        PostCreateNewUserOrderReq orderReq = new PostCreateNewUserOrderReq("morpheus", "zion resident");


        PutUpdateUserDateResponse orderRes = RestAssured
                .given()
                .when()
                    .body(orderReq)
                    .put("/users/2")
                .then()
                    .statusCode(200)
                .extract().response().as(PutUpdateUserDateResponse.class);

        assertEquals(orderReq.getName(), orderRes.getName(),"Имя пользователя не совпадает");
        assertEquals(orderReq.getJob(), orderRes.getJob(), "Профессия пользователя не совпадает");
        assertNotNull(orderRes.getUpdatedAt(), "Поле updatedAt отсутствует или пустое");

    }

}
