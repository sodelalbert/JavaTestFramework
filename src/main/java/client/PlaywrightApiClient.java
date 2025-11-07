package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import config.Config;

import java.util.Map;

public class PlaywrightApiClient {

    private final APIRequestContext requestContext;

    public PlaywrightApiClient(Playwright playwright) {

        this.requestContext = playwright.request().newContext(new APIRequest.NewContextOptions().
                setBaseURL(Config.get("base.url")).
                setExtraHTTPHeaders(Map.of(
                        "Content-Type", "application/json",
                        "Accept", "application/json"
                )));
    }

    public JsonObject get(String endpoint) {
        var response = requestContext.get(endpoint);
        return new Gson().fromJson(response.text(), JsonObject.class);
    }


    public JsonObject post(String endpoint, RequestOptions headers) {
        var response = requestContext.post(endpoint, headers);
        return new Gson().fromJson(response.text(), JsonObject.class);
    }

}
