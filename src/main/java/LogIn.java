import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class LogIn {

    public void UserSuccessfulLogin() throws JsonProcessingException {
        RestAssured.baseURI = "https://cinema-planner-372520.uc.r.appspot.com";
        RequestSpecification request = RestAssured.given();
        UserLogin userLogin = new UserLogin("dev@mpillz.com", "dev");
        ObjectMapper mapper = new ObjectMapper();

        //deserialization - convert stream of data into objects
        String json = mapper.writeValueAsString(userLogin);
        request.body(json);
        request.header(new Header("Content-Type", "application/json"));
        Response response = request.post("/api/v1/auth/login");

        //get status code
        System.out.println(response.getStatusLine());
        ResponseBody body = response.getBody();

        System.out.println(body.asString());


    }
}

// Cmd + n to generate code (constructor, getters, setters)
// Opt + cmd + v to assign to variable