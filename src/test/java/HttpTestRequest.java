import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import app.UserManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.apache.http.entity.ContentType.getOrDefault;




@Test
public class HttpTestRequest {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup() throws IOException
    {
    client = HttpClientBuilder.create().build();
    response = client.execute(new HttpGet("https://api.github.com/"));
    }

    @AfterMethod
    public void cleanup() throws IOException
    {
        client.close();
        response.close();

    }

    @Test
    public void statusIs200() throws IOException {


        System.out.println("statusIs200\n");
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);


    }
    @Test
    public void applicationIsJson() throws IOException {


        System.out.println("statusIs200\n");
        Assert.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/json");


    }

    @Test
    public void characterSetIsUTF8() throws IOException {
        Assert.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");

    }

    public void softAssertContinueToTheEnd() throws IOException  {
        //arrange
        CloseableHttpClient client = HttpClientBuilder.create().build();
        SoftAssert sa = new SoftAssert();
        //act
        CloseableHttpResponse response = client.execute(new HttpGet("https://api.github.com/"));
        //assert
        System.out.println("softAssertContinueToTheEnd\n");
        sa.assertEquals(response.getStatusLine().getStatusCode(), 200);
        sa.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/json");
        sa.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");
        client.close();
        response.close();
        sa.assertAll();

    }


    public void NonExistingUserReturnsNull() {

    }
}

