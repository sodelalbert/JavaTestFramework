package api;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import config.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@UsePlaywright
public abstract class BaseTest {
    public static Playwright playwright;

    @BeforeAll
    static void setUpAll() {
        playwright = Playwright.create();
        System.out.println(Config.get("url.backend"));
    }

    @AfterAll
    static void tearDownAll() {

    }

    @BeforeEach
    void setUp() {
        var playwright = Playwright.create();

//        Map<String, String> headers = new HashMap<>();
//        headers.put("Accept", "application/vnd.github.v3+json");
//
//
//        APIRequestContext request = playwright.request().newContext(new APIRequest.NewContextOptions()
//                .setBaseURL(Config.get("url.backend"))
//                .setExtraHTTPHeaders(headers));
//
//        APIResponse response = request.get("/posts/1");
//        System.out.println(Arrays.toString(response.body()));
//
//        JsonArray json = new Gson().fromJson(response.text(), JsonArray.class);


    }

    @AfterEach
    void tearDown() {

    }


}
