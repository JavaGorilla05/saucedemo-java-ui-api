package api;

import io.qameta.allure.Step;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.LoginBodyModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthApi {
    public static RequestSpecification requestSpec = given()
            .baseUri("https://reqres.in")
            .basePath("/api")
            .contentType(JSON)
            .log().all();

    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    @Step("Авторизация через API для получения токена")
    public String getToken(String email, String password) {
        LoginBodyModel credentials = new LoginBodyModel();
        credentials.setEmail(email);
        credentials.setPassword(password);

        LoginResponseModel response = given(requestSpec)
                .body(credentials)
                .post("/login")
                .then()
                .spec(responseSpec200)
                .extract().as(LoginResponseModel.class);

        return response.getToken();
    }
}
