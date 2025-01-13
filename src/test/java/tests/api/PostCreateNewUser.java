package tests.api;


import api.Specs;
import api.pojos.PostCreateNewUserOrderReq;
import api.pojos.PostCreateNewUserOrderResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class PostCreateNewUser {
    @Test
    void postCreateNewUser () {

        Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());

        PostCreateNewUserOrderReq orderReq = new PostCreateNewUserOrderReq("morpheus", "leader");


        PostCreateNewUserOrderResponse orderResponse = RestAssured
                .given()
                .when()
                    .body(orderReq)
                    .post("/users")
                .then()
                    .statusCode(201)
                .extract().response().as(PostCreateNewUserOrderResponse.class);

        assertEquals(orderReq.getName(), orderResponse.getName(),"Имя пользователя не совпадает");
        assertEquals(orderReq.getJob(), orderResponse.getJob(), "Профессия пользователя не совпадает");
        assertNotNull(orderResponse.getId(), "Поле Id отсутствует или пустое");
        assertNotNull(orderResponse.getCreatedAt(), "Поле createdAt отсутствует или пустое");

    }
}
