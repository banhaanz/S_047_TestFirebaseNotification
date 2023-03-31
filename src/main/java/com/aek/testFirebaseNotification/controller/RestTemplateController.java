package com.aek.testFirebaseNotification.controller;

import com.aek.testFirebaseNotification.model.DataMockM;
import com.aek.testFirebaseNotification.util.RestServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RestTemplateController {
    @Autowired
    private RestServiceUtil restServiceUtil;

    @GetMapping(value = "/testCallPost")
    public @ResponseBody String testCallPost() throws Exception {
        log.info("======= ENTER testCallPost ===========");
        String url = "http://localhost:8085/test";
        Object response = restServiceUtil.callRestServicePost(null, url, null, Object.class);
        log.info("response : {}", response);
        log.info("======= END testCallPost ===========");
        return "OKkkkkkkkkk";
    }

    @PostMapping(value = "/test")
    public @ResponseBody DataMockM test() throws Exception {
        log.info("======= ENTER test ===========");
        log.info("======= END test ===========");
        return new DataMockM(null, null, 0, false, "testPost");
    }
}
