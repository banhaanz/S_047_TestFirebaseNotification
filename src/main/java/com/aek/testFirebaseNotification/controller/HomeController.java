package com.aek.testFirebaseNotification.controller;

import com.aek.testFirebaseNotification.exception.ValidateException;
import com.aek.testFirebaseNotification.model.DataMockM;
import com.aek.testFirebaseNotification.model.TestRequestM;
import com.aek.testFirebaseNotification.properties.AppProperties;
import com.aek.testFirebaseNotification.service.FCMService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    private AppProperties appProperties;
    @Autowired
    private FCMService fcmService;

    @GetMapping("/")
    public @ResponseBody DataMockM hello() {
        log.info("||-------------------- RUN GET ---------------------------||");
        log.info("test get prop = {}", appProperties.getName());

        System.err.println("this is ERROR");
        return new DataMockM(appProperties.getId(),
                "HELLOOOO!!!!",
                appProperties.getAge(),
                appProperties.isWork(),
                appProperties.getMessage());
    }

    @CrossOrigin
    @GetMapping("/sendNotiFCM")
    public @ResponseBody DataMockM sendNotiFCM(@RequestParam("title") String title, @RequestParam("body") String body) throws Exception {
        log.info("||-------------------- sendNotiFCM start ---------------------------||");

        String id = fcmService.sendNotification(title, body);

        return new DataMockM(id,
                "",
                0,
                false,
                "SEND NOTI SUCCESS");
    }

    @CrossOrigin
    @GetMapping("/subscribeNotiFCM")
    public @ResponseBody DataMockM subscribeNotiFCM() throws Exception {
        log.info("||-------------------- subscribeNotiFCM start ---------------------------||");
        fcmService.subscribeNotification();

        return new DataMockM(null,
                "",
                0,
                false,
                "SUBSCRIBE NOTI SUCCESS");
    }


    @PostMapping(value = "/testPost")
    public @ResponseBody String testPost(@Valid @RequestBody TestRequestM requestM, BindingResult errors) {
        if(errors.hasErrors()){
            System.out.println(requestM.toString());
            throw  new ValidateException(errors);
        }
        System.out.println(requestM.toString());
        return "OKkkkkkkkkk";
    }

}
