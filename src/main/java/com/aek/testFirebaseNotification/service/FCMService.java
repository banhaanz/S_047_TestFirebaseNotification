package com.aek.testFirebaseNotification.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.TopicManagementResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/* Depends on : FirebaseConfig.java */
@Slf4j
@Service
public class FCMService {
    private final String TOPIC = "TEST_NOTI";
    private final String token1 = "cu1GMUdCeHbGAe_2VznaAg:APA91bHjPiMDttIEeOesbcNFcwpVhpnvIeF48yx0qCmWr10RWe9d2YV5th3VOicniut5PfScrlOICr4sP_bhR2i-PnqZ3OdgIxaVoGiLXXAdUPbE8ykLDpygSdOpox2hHhpQOT4pFekQ";
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public String sendNotification(String title, String body) throws Exception {
        log.info("======== ENTER sendNotification =======");
        Notification notification = Notification
                .builder()
                .setTitle(title)
                .setBody(body)
                .build();

        Message msg = Message.builder()
                .setToken(token1)
//                .setTopic(TOPIC)
                .putData("title", "testttt")
                .setNotification(notification)
                .build();

        String id = firebaseMessaging.send(msg);
        return id;
    }

    public String subscribeNotification() throws Exception {
        log.info("======== ENTER subscribeNotification =======");
        List<String> targetList = Arrays.asList(
                token1,
                "dsdfsdfsdfsdf-mock");

        TopicManagementResponse fcmTopicResponse = firebaseMessaging.subscribeToTopic(targetList ,TOPIC);
        log.info("fcmTopicResponse : {}", fcmTopicResponse.toString());

        return "subscribeNotification OKKKK";
    }
}
