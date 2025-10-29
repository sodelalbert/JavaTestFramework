package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import config.Config;

import java.util.HashMap;
import java.util.Map;

public class PlaywrightApiClient {

    private final Map<String, String> headers = new HashMap<>();
    private final APIRequestContext requestContext;

    public PlaywrightApiClient(Playwright playwright) {

        this.requestContext = playwright.request().newContext(new APIRequest.NewContextOptions().
                setBaseURL(Config.get("base.url")).
                setExtraHTTPHeaders(headers));

    }

    public JsonObject get(String endpoint, Map<String, String> headers) {

        this.headers.putAll(headers);
        var response = requestContext.get(endpoint, RequestOptions.create().setHeader(headers)); // set headers fix
        return new Gson().fromJson(response.text(), JsonObject.class);
    }


    public JsonObject post(String endpoint,  Map<String, String> headers, JsonObject body) {
        this.headers.putAll(headers);
        var response = requestContext.post(endpoint,  RequestOptions.create().setData(body).setHeader(headers));
        return new Gson().fromJson(response.text(), JsonObject.class);
    }


//    public Map<String, String> getHeaders() {
//        return headers;

//    }
//    public APIResponse get(String endpoint) {
//        return requestContext.get(endpoint);

//    }

//    Authorization via token .setHeader("Authorization", "Bearer " + token)
    // TODO: Finalize POST, PUT and DELETE
}
