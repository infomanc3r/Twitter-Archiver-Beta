package com.twitterarchiver.archiver.daos;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.twitterarchiver.archiver.dynamodb.models.Tweet;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 *  A DynamoDao object uses a DynamoDBMapper to mediate access between the program and a DynamoDB database.
 *  The DynamoDBMapper uses AWS login credentials set in ~\.aws\config.
 */
@Singleton
public class DynamoDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Instantiates a DynamoDao object.
     *
     * @param dynamoDBMapper The {@link DynamoDBMapper} used to interact with the catalog table.
     */
    @Inject
    public DynamoDao(DynamoDBMapper dynamoDBMapper) { this.dynamoDBMapper = dynamoDBMapper; }

    /**
     * This method loops through a provided List and publishes each Tweet object to the DynamoDB database.
     *
     * @param tweets a List of Tweet objects to be published on the DynamoDB database.
     * @return true if tweets are published without an exception being thrown.
     */
    public boolean publishTweets(List<Tweet> tweets) {
        if (tweets == null) {
            throw new RuntimeException("Tweets to save cannot be null!");
        }
        for (Tweet current : tweets) {
            dynamoDBMapper.save(current);
        }
        return true;
    }

}
