import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HttpRequest{
    int id;

    String apiKey = "free_user_3EBLGYiDccTqWdhU82qxtHIV0E9";
    @Test
    void  getUser(){
        given()
                .queryParam("api_key", apiKey)

        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }
    //@Test(priority=2)
    void  CreatelUsers(){
        HashMap data=new HashMap();
        data.put("name","Ajay");
        data.put("Job","IT Trainer");

        id= given()
        .queryParam("api_key", apiKey).body(data)
                .contentType("application/json")
               .body(data)



                .when()
               .post("https://reqres.in/api/users")
               .jsonPath().getInt("id");

//               .then()
//                .statusCode(201)
//                .log().all();

    }
    //@Test(priority = 3,dependsOnMethods = "CreatelUsers")
    void  UpdateUsers(){
        HashMap data=new HashMap();
        data.put("name","Jhon");
        data.put("Job","Tester");

        given()
        .queryParam("api_key", apiKey)
                .contentType("application/json")
                .body(data)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .log().all();

    }
    //@Test(priority=4)
    void  DeleteUsers(){
        when()
        .delete("https://reqres.in/api/users/1");
    }
}
