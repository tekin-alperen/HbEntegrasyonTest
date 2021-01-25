import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class ApiTest {

    @Test
    public void ResponseCode(){
     String baseUri="https://generator.swagger.io";
        RestAssured.baseURI=baseUri;

        RequestSpecification request=RestAssured
                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));

        Response response=request

                .when()
                .get("/api/swagger.json")

                 .then()
                .statusCode(200)
                .extract().response();
        int responseCode=response.getStatusCode();

        Assert.assertEquals("Bir sorunla karşılaşıldı",responseCode,200);

    }


}
