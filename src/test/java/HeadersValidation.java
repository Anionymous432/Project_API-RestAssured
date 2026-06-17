import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class HeadersValidation {

   // @Test
    void TestHeader(){
        given()
        .when()
        .get("https://www.google.com/")
        .then()
        .header("Content-Type","text/html; charset=ISO-8859-1")
        .log().all();
    }
@Test(priority = 1)
    void GetHeaders(){
        Response res= given()
        .when()
                .get("https://www.google.com/");



        //single header info
//        String header=res.getHeader("Content-Type");
//        System.out.println("Content-type"+header);

        //Multi-headers info
       Headers myheaders= res.getHeaders();
        for(Header hd:myheaders){
            System.out.println("Header Name: "+hd.getName()+", Header Value: "+hd.getValue());
        }

    }


    //Log

    @Test(priority = 2)
    void TestLogs(){
        given()
        .when()
                .get("https://www.google.com/")
                .then()
                .log().all();//for print all sections
               //.log().body();//for print only body section
                //.log().headers();//for print only headers section
                //.log().status();//for print only status code section
                //.log().cookies();//for print only cookies section
                //.log().ifValidationFails();//for print all sections if any validation fails


    }

}
