package com.twitterarchiver.archiver.controllers;

import com.twitterarchiver.archiver.App;
import com.twitterarchiver.archiver.dagger.ApplicationComponent;
import com.twitterarchiver.archiver.daos.TweetsDao;
import com.twitterarchiver.archiver.models.Tweet;
import com.twitterarchiver.archiver.utils.JsonUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController("twitter")
public class TwitterController {
    private static final ApplicationComponent component = App.component;
    private TweetsDao tweetsDao = component.provideTweetsDao();

    private String bearerToken = "AAAAAAAAAAAAAAAAAAAAAJCBoAEAAAAAdBqKwDlBYpt0x1K7ph1ggDnbui8%3DPRJtLq1uuuTb0bYBOFAQ1PAwpDkBnDG0VKQ5q7T2zyfhFyCFn1";


    @GetMapping("/archive")
    public ResponseEntity<?> archiveTweets(@RequestParam(value = "userId") String userId) throws IOException, URISyntaxException {
        // Retrieve tweets (in form of JSONObject)
        System.out.println("bearer token currently:" + bearerToken);
        JSONObject response = tweetsDao.getTweetsById(userId, bearerToken);

        // Convert tweets from Json to a list of Tweet objects
        List<Tweet> tweets = JsonUtils.tweetJsonToTweetObjects(userId, response);

        return new ResponseEntity<>(HttpStatus.OK);

    }   // TODO: add input checking/tests for input checking, logging, handle exceptions, better response

    @PostMapping("/sendTweet")
    public ResponseEntity<?> sendTweet(@RequestParam(value = "tweet") String tweet) throws IOException, URISyntaxException {

        JSONObject response = tweetsDao.sendTweet(tweet, bearerToken);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
