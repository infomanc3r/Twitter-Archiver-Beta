package com.twitterarchiver.archiver.dagger;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.twitterarchiver.archiver.daos.DynamoDao;
import com.twitterarchiver.archiver.daos.TweetsDao;
import dagger.Component;

@Component(modules = {
        DaoModule.class,
})
public interface ApplicationComponent {

    DynamoDao provideDynamoDao();
    TweetsDao provideTweetsDao();
    DynamoDBMapper provideDynamoDBMapper();

}
