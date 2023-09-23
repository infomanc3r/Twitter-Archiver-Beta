package com.twitterarchiver.archiver.utils;

import com.twitterarchiver.archiver.models.Tweet;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static List<Tweet> tweetJsonToTweetObjects(String userId, JSONObject response) {

        List<Tweet> tweetList = new ArrayList<>();
        JSONArray jsonArray = response.getJSONArray("data");

        for(int i = 0 ; i < jsonArray.length(); i++) {
            tweetList.add(new Tweet(userId,
                    jsonArray.getJSONObject(i).getString("text"),
                    jsonArray.getJSONObject(i).getString("created_at")));
        }

        return tweetList;

    }   // TODO: convert timestamps into more readable format
}
