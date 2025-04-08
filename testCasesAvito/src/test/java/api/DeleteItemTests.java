package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class DeleteItemTests {

    static final String AVITO_URL = "https://qa-internship.avito.com";

    @Test
    public void testDeleteExistingItem() {
        Response response = given()
                .baseUri(AVITO_URL)
                .contentType(ContentType.JSON)
                .body("{\"sellerId\":456789,\"name\":\"Item to Delete\",\"price\":150,\"stats\":{\"views\":2}}")
                .when()
                .post("/api/1/item")
                .then()
                .statusCode(200)
                .extract().response();

        Integer id = response.path("id");
        if (id == null) {
            throw new RuntimeException("ID not returned. Cannot test delete item!");
        }

        given()
                .baseUri(AVITO_URL)
                .when()
                .delete("/api/2/item/" + id)
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteInvalidItemId() {
        given()
                .baseUri(AVITO_URL)
                .when()
                .delete("/api/2/item/0")
                .then()
                .statusCode(404);
    }
}
