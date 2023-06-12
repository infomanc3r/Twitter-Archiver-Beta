package com.twitterarchiver.archiver.controllers;

import com.twitterarchiver.archiver.App;
import com.twitterarchiver.archiver.dagger.ApplicationComponent;
import com.twitterarchiver.archiver.daos.DynamoDao;
import com.twitterarchiver.archiver.daos.TweetsDao;
import com.twitterarchiver.archiver.dynamodb.models.Tweet;
import com.twitterarchiver.archiver.utils.JsonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Controller {
    private static final ApplicationComponent component = App.component;
    private DynamoDao dynamoDao = component.provideDynamoDao();
    private TweetsDao tweetsDao = component.provideTweetsDao();

    @Value("${bearer.token}")
    private String bearerToken;

    @GetMapping("/archive")
    public ResponseEntity<?> archiveTweets(@RequestParam(value = "userId") String userId) throws IOException, URISyntaxException {
        // Retrieve tweets (in form of JSONObject)
        System.out.println("bearer token currently:" + bearerToken);
        JSONObject response = tweetsDao.getTweetsById(userId, bearerToken);

        // Convert tweets from Json to a list of Tweet objects
        List<Tweet> tweets = JsonUtils.tweetJsonToTweetObjects(userId, response);

        // Publish the tweets to the DynamoDB database
        dynamoDao.publishTweets(tweets);

        return new ResponseEntity<>(HttpStatus.OK);

    }   // TODO: add input checking/tests for input checking, logging, handle exceptions, better response
}
