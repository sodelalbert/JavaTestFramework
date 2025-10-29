package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import config.Config;

import java.util.HashMap;
import java.util.Map;

public class PlaywrightApiClient {

    private final Map<String, String> headers = new HashMap<>();
    private final APIRequestContext requestContext;

    public PlaywrightApiClient(Playwright playwright) {

        this.requestContext = playwright.request().newContext(new APIRequest.NewContextOptions().
                setBaseURL(Config.get("url.backend")).
                setExtraHTTPHeaders(headers));

    }

//    public Map<String, String> getHeaders() {
//        return headers;
//    }

//    public APIResponse get(String endpoint) {
//        return requestContext.get(endpoint);
//    }

//    Authorization via token .setHeader("Authorization", "Bearer " + token)

    public JsonObject get(String endpoint, Map<String, String> headers) {
        this.headers.putAll(headers);
        var response = requestContext.get(endpoint);
        return new Gson().fromJson(response.text(), JsonObject.class);
    }
    // TODO: Finalize POST, PUT and DELETE
}
