package tests.api;

import api.Specs;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

// Добавил AllureTestNg listener для интеграции с TestNG
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class GetSingleResourceWithHamcrestChecking {

    // Настройка RestAssured для Allure
    @BeforeClass
    public void setup() {
        RestAssured.filters(new AllureRestAssured()); // Добавляем фильтр для Allure
    }


    @Test
    public void getSingleResource () {
        //Specs.instalSpec(Specs.requestSpec("https://reqres.in", "/api"), Specs.responseSpec());

        RestAssured
                .given()
                    .baseUri("https://reqres.in/api")
                .when()
                    .pathParam("unknown", "2")
                    .get("/{unknown}")
                .then()
                .statusCode(200)
                .body("data.name", hasItem("fuchsia rose")) // Проверяем, что в массиве есть пользователь с именем "fuchsia rose"
                .body("total_pages", equalTo(2)) // Проверяем, что total_pages равен "2"
                .body("data", hasSize(6)); // Проверяем, что массив data содержит 6 элементов


    }
}
