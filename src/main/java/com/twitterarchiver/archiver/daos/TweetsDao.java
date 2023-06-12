package com.twitterarchiver.archiver.daos;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Singleton
public class TweetsDao {

    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Instantiates a TweetsDao object.
     */
    @Inject
    public TweetsDao(DynamoDBMapper dynamoDBMapper) { this.dynamoDBMapper = dynamoDBMapper; }

    public JSONObject getTweetsById(String userId, String bearerToken) throws IOException, URISyntaxException {

        JSONObject response = new JSONObject();

        // if bearer token is valid, return a JSONObject containing tweets from userId
        if (null != bearerToken) {
            response = getTweetsFromAPI(userId, bearerToken);
            System.out.println(response);
        } else {
            System.out.println("There was a problem getting your bearer token. " +
                    "Please make sure you set the BEARER_TOKEN environment variable in application.properties!");
        }
        return response;
    }

    /**
     * This method calls the v2 User Tweet timeline endpoint on the Twitter API using provided converted user ID.
     *
     * @param userId The converted userId to retrieve tweets for.
     * @param bearerToken The bearerToken used to authenticate access to the Twitter API.
     * */
    private JSONObject getTweetsFromAPI(String userId, String bearerToken) throws IOException, URISyntaxException {

        String tweetResponse = null;

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        URIBuilder uriBuilder = new URIBuilder(String.format("https://api.twitter.com/2/users/%s/tweets", userId));

        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("tweet.fields", "created_at"));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        // Convert JSON to string - consider processing the JSON directly
        if (null != entity) {
            tweetResponse = EntityUtils.toString(entity, "UTF-8");
        }

        return new JSONObject(tweetResponse);

    }   // TODO: use builder pattern to construct a Request object that can dynamically include tweet attributes

}
