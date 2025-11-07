package api;

import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class SampleApiTestSuite extends BaseTest {

    @Test
    void testApiConnection1() {

        var response = playwrightApiClient.get("/posts/1");
        assert response != null;
    }

    @Test
    void testApiConnection2() {
        System.out.println("SampleApiTestSuite 2");
    }
}
