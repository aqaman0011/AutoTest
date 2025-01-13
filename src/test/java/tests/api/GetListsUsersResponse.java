package tests.api;

import api.Specs;
import api.pojos.GetListUsersResponse;
import api.pojos.UserData;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class GetListsUsersResponse {

    @Test
    void getListUsers() {

        Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());

        GetListUsersResponse response = RestAssured
                .given()
                .when()
                    .get("/users?page=2")
                .then()
                    .statusCode(200)
                .extract().response().as(GetListUsersResponse.class);

        //Сохраняю список юзеров
        List<UserData> users = response.getData();

        assertFalse(users.isEmpty(), "Список пользователей пуст"); // Проверка, что список не пустой
        assertEquals(response.getPage(), 2, "Страница не совпадает"); // Проверка правильной страницы
        assertEquals(users.size(), 6, "Количество пользователей не совпадает"); // Проверка количества пользователей

        UserData firstUser = users.get(0);
        assertFalse(firstUser.getEmail().isEmpty(), "Email первого пользователя пуст");
        assertFalse(firstUser.getFirstName().isEmpty(), "Имя первого пользователя пустое");
        assertFalse(firstUser.getLastName().isEmpty(), "Фамилия первого пользователя пустая");
    }
}
