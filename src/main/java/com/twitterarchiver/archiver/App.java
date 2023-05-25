package com.twitterarchiver.archiver;

import com.twitterarchiver.archiver.dagger.ApplicationComponent;
import com.twitterarchiver.archiver.dagger.DaggerApplicationComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static final ApplicationComponent component = DaggerApplicationComponent.create();

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}