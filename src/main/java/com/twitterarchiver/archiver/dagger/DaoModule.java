package com.twitterarchiver.archiver.dagger;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.twitterarchiver.archiver.daos.TweetsDao;
import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {
    @Provides
    public TweetsDao provideTweetsDao() { return new TweetsDao(); }

}
