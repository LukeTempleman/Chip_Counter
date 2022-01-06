import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.List;

import org.junit.jupiter.api.*;
import Layer1_EntryPoint.webApi;
import org.junit.jupiter.api.Test;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;




public class ApiTest {
    public static webApi server;

    @BeforeAll
    public static void startServer() {
        server = new webApi();
        server.start(5000);
    }

    @AfterAll
    public static void stopServer() {
        server.stop();
    }

    @Test
    @DisplayName("GET /session/{id}")
    public void TestgetOneSession() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:5000/session/2").asJson();
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaders().getFirst("Content-Type"));
       // JSONObject jsonObject = response.getBody().getObject();
    }
}
