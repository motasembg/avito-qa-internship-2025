package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateItemTests {
    static final String URL = "https://qa-internship.avito.com";

    @Test
    public void createItem() {
//        String response =
        given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body("{\"sellerId\":123456,\"name\":\"Test Item\",\"price\":100,\"stats\":{\"views\":5}}")
                .when()
                .post("/api/1/item")
                .then()
                .statusCode(200)
                .body("sellerId", equalTo(123456))
                .body("name", equalTo("Test Item"))
                .body("price", equalTo(100));
//                .extract().asString();
//        System.out.println("Response: " + response);
    }
    @Test
    public void testCreateItemWithEmptyBody(){
//        String response =
        given()
        .baseUri(URL)
                .contentType(ContentType.JSON)
                .body("{}")
                .when()
                .post("/api/1/item")
                .then()
                .statusCode(200);
//                .extract().asString();
//        System.out.println("Response: " + response);
    }
}
