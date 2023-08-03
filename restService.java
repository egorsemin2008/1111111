package restservice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.internal.requests.OrderingRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class restService {
    @Test
    public void rest() {
        // String baseUrl = "https://reqres.in/api/api/users?page=2";

        String id = given()
                .expect()
                //.body("page", equalTo(2))
                //.body("total", equalTo(12))
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().asString();
    }
@Test
        public void postCreate(){
        String reqUrl = "https://reqres.in/api/users";
        String reqBody = "{\n" +
                "    \"name\": \"name\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .when()
                .body(reqBody)
                .post(reqUrl)
                .then().log().all()
                .statusCode(201);
                //.body("job", equalTo("leader"));





}
}
