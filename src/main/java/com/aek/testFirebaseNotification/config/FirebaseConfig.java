package com.aek.testFirebaseNotification.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

@Configuration
public class FirebaseConfig {
    private final String firebaseServiceAccountJson = "firebase/service-account.json";

    @Bean
    FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }

    @Bean
    FirebaseApp firebaseApp() throws Exception{
        URL resource = Thread.currentThread().getContextClassLoader().getResource(firebaseServiceAccountJson);
        FileInputStream serviceAccount = new FileInputStream(new File(resource.toURI()));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);
    }
}
