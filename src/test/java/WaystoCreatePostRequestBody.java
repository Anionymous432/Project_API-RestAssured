import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
/*How many ways we can create request body
1) using HashMap
2) using Org.json
3) using POJO (Plain Old Java Object)
4) using external json file

 */

public class WaystoCreatePostRequestBody {
    // creating reuest body by using hashmap
    //@Test(priority = 1)
    void testCreatePostRequestBodyhashmap() {
        HashMap data = new HashMap();
        data.put("name", "John Doe");
        data.put("loaction", "Hyderbad");
        data.put("phone", "9747449094");
         String[] arr={"java","C"};
         data.put("course", arr);


         given()
                 .contentType("application/json")
                 .body(data)
                .when()
                        .post("http://localhost:3000/students")

                 .then()
                 .statusCode(201)
                 .body("name",equalTo("John Doe"))
                 .body("loaction",equalTo("Hyderbad"))
                 .body("course[0]",equalTo("java"))
                 .body("course[1]",equalTo("C"))
                 .header("Content-Type", "application/json; charset=utf-8")
                 .log().all();

    }
  @Test(priority = 2)
    void DeleteCreatePostRequestBody() {

        given()
                .when()
                .delete("http://localhost:3000/students/O1n1REbzXU0")
                .then()
                .statusCode(200);
  }

  // creating reuest body by using Org.json
  //@Test(priority = 3)
    void testCreatePostRequestBodyOrgjson() {
       JSONObject data = new JSONObject();
        data.put("name", "John Doe");
        data.put("loaction", "Hyderbad");
        data.put("phone", "9747449094");
        String[] arr={"java","C"};
        data.put("course", arr);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("John Doe"))
                .body("loaction",equalTo("Hyderbad"))
                .body("course[0]",equalTo("java"))
                .body("course[1]",equalTo("C"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();

    }
    @Test(priority = 2)
    void DeleteCreatePostRequestBodyJson() {

        given()
                .when()
                .delete("http://localhost:3000/students/qzUD8ufCTsc")
                .then()
                .statusCode(200);



    }

    // creating reuest body by using Org.json
    @Test
    void testCreatePostRequestBodyPOJO() {
        POJO data = new POJO();
        data.setName("John Doe");
        data.setLoaction( "Hyderbad");
        data.setPhone("9747449094");
        String[] arr={"java","C"};
        data.setCourse(arr);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("John Doe"))
                .body("loaction",equalTo("Hyderbad"))
                .body("course[0]",equalTo("java"))
                .body("course[1]",equalTo("C"))
                .header("Content-Type", containsString("application/json"))
                .log().all();

    }
    @Test(priority = 2)
    void DeleteCreatePostRequestBodyPOJO() {

        given()
                .when()
                .delete("http://localhost:3000/students/VdSw13hgA2k")
                .then()
                .statusCode(200);



    }

    //using external json file
    @Test(priority = 2)
    void testCreatePostRequestBodyExternalFile() throws FileNotFoundException {
        File f=new File(".//Student.json");
        FileReader fr=new FileReader(f);
        JSONTokener jt=new JSONTokener(fr);

        JSONObject data = new JSONObject(jt);
        data.put("name", "John Doe");
        data.put("loaction", "Hyderbad");
        data.put("phone", "9747449094");
        String[] arr={"java","C"};
        data.put("course", arr);
        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("John Doe"))
                .body("loaction",equalTo("Hyderbad"))
                .body("course[0]",equalTo("java"))
                .body("course[1]",equalTo("C"))
                .header("Content-Type", containsString("application/json"))
                .log().all();

    }
    @Test(priority = 2)
    void DeleteCreatePostRequestBodyExternalFile() {

        given()
                .when()
                .delete("http://localhost:3000/students/yaEhwBYg1aw")
                .then()
                .statusCode(200);



    }

}
