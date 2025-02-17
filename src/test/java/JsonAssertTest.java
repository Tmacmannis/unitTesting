import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_StrictFalse_WrongData() throws JSONException {
        String expectedResponse = "{\"id\": 2,\"name\":\"Ball\"}";
        JSONAssert.assertNotEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:Ball}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
