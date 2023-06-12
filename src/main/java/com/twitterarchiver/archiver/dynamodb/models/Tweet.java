package com.twitterarchiver.archiver.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.Objects;

@DynamoDBTable(tableName = "tweets")
public class Tweet {

    private String userID;
    private String tweet;
    private String timestamp;

    public Tweet(String userID, String tweet, String timestamp) {
        this.userID = userID;
        this.tweet = tweet;
        this.timestamp = timestamp;
    }   // TODO: refactor into builder pattern

    @DynamoDBHashKey(attributeName = "userID")
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet1 = (Tweet) o;
        return getUserID().equals(tweet1.getUserID()) && getTweet().equals(tweet1.getTweet()) && getTimestamp().equals(tweet1.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getTweet(), getTimestamp());
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "userHandle='" + userID + '\'' +
                ", tweet='" + tweet + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
