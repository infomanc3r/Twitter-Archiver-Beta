package com.twitterarchiver.archiver.dagger;

import com.twitterarchiver.archiver.daos.TweetsDao;
import dagger.Component;

@Component(modules = {
        DaoModule.class,
})
public interface ApplicationComponent {

    TweetsDao provideTweetsDao();

}
