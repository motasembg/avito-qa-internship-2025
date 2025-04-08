package api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetItemTests {
    static final String AVITO_URL = "https://qa-internship.avito.com";

    @Test
    public void testGetItemById() {
        Response response = given()
                .baseUri(AVITO_URL)
                .contentType(ContentType.JSON)
                .body("{\"sellerId\":234567,\"name\":\"Fetched Item\",\"price\":99,\"stats\":{\"views\":0}}")
                .when()
                .post("/api/1/item")
                .then()
                .statusCode(200)
                .extract().response();

        int createdId = response.path("id");

        given()
                .baseUri(AVITO_URL)
                .when()
                .get("/api/1/item/" + createdId)
                .then()
                .statusCode(200)
                .body("id", equalTo(createdId))
                .body("name", equalTo("Fetched Item"));
    }
}
