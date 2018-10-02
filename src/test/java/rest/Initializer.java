package rest;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Initializer {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = 8080;
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://jsonplaceholder.typicode.com";
        }
        RestAssured.baseURI = baseHost;
    }
}
