import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ParsingXMLResponsedata {

    @Test
    void getUsers() throws Exception{
      //Approch1--->Simple
        /*given()
                .contentType("application/xml")
                .when()
                .get("http://localhost:5000/courses")
                .then()
                .statusCode(200)
                .body("Course.item[0].courseName",equalTo("Computer Science"))
                .log().body();*/

        //Approch2---->Storing response into Variable
        Response res=given()
                .contentType("application/xml")
                .when()
                .get("http://localhost:5000/courses");

        assertEquals(res.statusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");

        String CourseNamw=res.xmlPath().getString("Course.item[0].courseName");
        assertEquals(CourseNamw,"Computer Science");

        //Approch 3---->Dynamically Parsing







    }
}
