package utils;

import io.restassured.http.ContentType;
import models.OwnerPojoModel;
import models.RomeNumber;
import static io.restassured.RestAssured.given;
import static utils.ConfProperties.*;

public class APIUtils {
    public static RomeNumber getNumber(String url) {
        RomeNumber romeNumber = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .statusCode(202)
                .extract().body().as(RomeNumber.class);
        return romeNumber;
    }

    public static void postOwnerFiledRequest(OwnerPojoModel ownerPojoModel) {
        given()
                .contentType(ContentType.JSON)
                .body(ownerPojoModel)
                .when()
                .post(getProperty("POSTURL"))
                .then()
                .statusCode(201);
    }
    public static void postDeleteOwnerFiled(String url) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .statusCode(200);
    }

    public static RomeNumber getNumberOwner(String url) {
        RomeNumber romeNumberOwner = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .statusCode(202)
                .extract().body().as(RomeNumber.class);
        return romeNumberOwner;
    }
}