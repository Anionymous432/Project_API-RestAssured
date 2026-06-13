package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgExample {
    @Test
    public void testMethod1() {
        Response response=RestAssured.get("https://reqres.in/api/my-app/collections/todos/recordsSend");
        System.out.println("The response is "+response.getStatusCode());
        System.out.println("The response is "+response.getBody().asString());
        System.out.println("The response is "+response.getTime());
        System.out.println(response.getBody());

        int responseCode=response.getStatusCode();

        Assert.assertEquals(responseCode,403);
    }
}
