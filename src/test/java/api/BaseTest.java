package api;

import client.PlaywrightApiClient;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@UsePlaywright
public abstract class BaseTest {
    public static Playwright playwright;
    public static PlaywrightApiClient playwrightApiClient;

    @BeforeAll
    static void setUpAll() {

    }

    @AfterAll
    static void tearDownAll() {

    }

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();
        playwrightApiClient = new PlaywrightApiClient(playwright);

    }

    @AfterEach
    void tearDown() {

    }


}
