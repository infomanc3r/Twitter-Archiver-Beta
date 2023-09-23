package com.twitterarchiver.archiver.controllers;

import com.twitterarchiver.archiver.App;
import com.twitterarchiver.archiver.dagger.ApplicationComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mastodon")
public class MastodonController {
    private static final ApplicationComponent component = App.component;
    private String bearerToken = "";

    @GetMapping("/getPost")
    public ResponseEntity<?> getPost() {

        


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
