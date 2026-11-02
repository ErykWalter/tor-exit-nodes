package io.ynd.torexitnodes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class HelloResourceTest {

    @Test
    void helloShouldReturnWorld() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200);
    }
}
