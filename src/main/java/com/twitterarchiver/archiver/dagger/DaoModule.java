package com.twitterarchiver.archiver.dagger;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.twitterarchiver.archiver.daos.DynamoDao;
import com.twitterarchiver.archiver.daos.TweetsDao;
import com.twitterarchiver.archiver.dynamodb.DynamoDbClientProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {
    @Provides
    public TweetsDao provideTweetsDao(DynamoDBMapper mapper) { return new TweetsDao(mapper); }

    @Provides
    public DynamoDao provideDynamoDao(DynamoDBMapper mapper) { return new DynamoDao(mapper); }

    @Provides
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2));
    }
}
