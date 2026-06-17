import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJSONResponsedata {


@Test
    void ParseJsondata(){

      //Approch------>for small json data

               /*given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/book")
                .then()
                .statusCode(200).header("Content-Type","application/json")
                .body("[2].title",equalTo("Harry Potter and the Philosopher's Stone"));*/


        //ApprochII------->By Using TestNg-Assertions

     /*Response res=   given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/book");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"), "application/json");

        String booktitle =res.jsonPath().getString("[2].title");
        {Assert.assertEquals(booktitle,"Harry Potter and the Philosopher's Stone");*/


    //approch3---->json object
    Response res=   given()
            .contentType(ContentType.JSON)
            .when()
            .get("http://localhost:3000/book");
     //fing book titlle

    Boolean Status=false;
      JSONArray jsonObj=new JSONArray(res.asString());
//      String s=jsonObj.getJSONObject(4).getString("title");
//     System.out.println(s);
     for(int i=0;i<jsonObj.length();i++){

        String bookTitle=jsonObj.getJSONObject(i).get("title").toString();
        if(bookTitle.equalsIgnoreCase("Harry Potter and the Philosopher's Stone")){

            Status=true;
            break;
        }


    }
     Assert.assertEquals(Status,true);

     //find total price
    double TotalPrice=0;
    for(int i=0;i<jsonObj.length();i++){

        String bookTitle=jsonObj.getJSONObject(i).get("price").toString();
        TotalPrice+=Double.parseDouble(bookTitle);



    }
    System.out.println(TotalPrice);
    Assert.assertEquals(TotalPrice,1000.5);


    }
}
