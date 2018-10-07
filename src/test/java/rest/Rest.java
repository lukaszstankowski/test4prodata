package rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Comparator.comparing;

public class Rest extends Initializer {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldGetHighestValueForUserId() throws IOException {

        Response response = RestAssured.given().get("/posts");
        String responseBody = response.getBody().asString();

        List<Model> list = objectMapper.readValue(responseBody, new TypeReference<List<Model>>() {
        });

        Long highestValue = list.stream().max(comparing(v -> v.userId)).orElseThrow(NoSuchElementException::new).userId;
        System.out.println("Highest value returned from the request for userId: " + highestValue);
    }

    @Test
    public void shouldGetHighestValueForId() throws IOException {

        Response response = RestAssured.given().get("/posts?userId=" + 10);
        String responseBody = response.getBody().asString();

        List<Model> list = objectMapper.readValue(responseBody, new TypeReference<List<Model>>() {
        });

        Model model = list.stream().max(comparing(v -> v.id)).orElseThrow(NoSuchElementException::new);
        System.out.println("For user ID: " + model.userId + " the highest value returned from request for id is: " + model.id);
    }

    @Test
    public void shouldAddNewCommentForPostIdReturnedFromSecondScenario() {
        String json = "{\"postId\":\"100\", \"name\":\"testTitle\", \"email\":\"test@test.pl\", \"body\":\"ed ut perspiciatis unde omnis iste natus error sit doloremque laudantium\"}";

        Response response = RestAssured.given()
                .body(json)
                .when()
                .post("/comments");

        assert response.statusCode() == HttpStatus.SC_CREATED;
    }
}
