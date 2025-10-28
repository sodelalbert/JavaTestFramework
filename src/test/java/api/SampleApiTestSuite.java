package api;

import client.PlaywrightApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@UsePlaywright
public class SampleApiTestSuite extends BaseTest {

    @Test
    void testApiConnection1() {
        var pac = new PlaywrightApiClient(playwright);

        // Setting Headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");

        // Parsing response
        var response = pac.get("/posts/1", headers);


        //JsonObject jResponse = new Gson().fromJson(response.text(), JsonObject.class);

        System.out.println(response);

       // Setting Body


    }

    @Test
    void testApiConnection2() {
        System.out.println("SampleApiTestSuite 2");
    }
}
