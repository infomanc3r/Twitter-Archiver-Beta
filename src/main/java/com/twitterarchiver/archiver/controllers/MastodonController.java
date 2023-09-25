package com.twitterarchiver.archiver.controllers;

import com.twitterarchiver.archiver.App;
import com.twitterarchiver.archiver.dagger.ApplicationComponent;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

        String mastodonResponse = null;

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        URIBuilder uriBuilder = null;
        HttpGet httpGet = null;
        try {
            uriBuilder = new URIBuilder("https://truthsocial.com/api/v1/accounts/107780257626128497/statuses?exclude_replies=true&with_muted=true&limit=1");
            httpGet = new HttpGet(uriBuilder.build());

            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            // Convert JSON to string - consider processing the JSON directly
            if (null != entity) {
                mastodonResponse = EntityUtils.toString(entity, "UTF-8");
            }

        } catch (Exception e) {
            System.out.println("Error building URI: " + e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
