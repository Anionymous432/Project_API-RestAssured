import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PathQueryParaAndCookies {

    //Path and Query Parameters
     @Test
    void  PathQueryPara(){

        String apiKey = "free_user_3EBLGYiDccTqWdhU82qxtHIV0E9";
        given()
                .pathParam("Mypath", "users")
                .pathParam("userId", 7)
                .queryParam("api_key", apiKey)
                .queryParam("page", 2)
//                .queryParam("id", 7)

                .when()
                .get("https://reqres.in/api/{Mypath}/{userId}")
                .then()
                .statusCode(200)
                .log().all();
    }

    //Coookies

    @Test
    void TestCookie(){
         given()
                 .when()
                 .get("https://www.google.com/")
                 .then()
                 .cookie("AEC","AaJma5uuUmp9b8IE3g-wu01kwmDcbhi17D1HSH4uA85TF1gI_z43ZzdJksM")
                 .log().all();
    }

    @Test
    void GetCookies(){
       Response res= given()
                 .when()
                 .get("https://www.google.com/");

//       String Cookies=res.getCookie("AEC");
//        System.out.println("Cookies value is:"+Cookies);
        Map<String,String> cookies = res.getCookies();

        //String cookies=res.getCookies().get("AEC");
        //System.out.println(cookies);
        for(String key:cookies.keySet()){
            System.out.println(key+": "+cookies.get(key));
        }
        

    }
}
