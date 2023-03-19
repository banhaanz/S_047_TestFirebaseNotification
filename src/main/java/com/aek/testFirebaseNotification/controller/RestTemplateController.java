package com.aek.testFirebaseNotification.controller;

import com.aek.testFirebaseNotification.exception.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplateBuilder builder;

    @GetMapping(value = "/testCallRest")
    public @ResponseBody String testPost() throws Exception {
        String url = "http://10.202.104.25/naosweb/decisionFunctionApi/Param/naosNCBChecking";
        Object response = this.callRestServicePost(null, url, null, Object.class);
        log.info("response : {}", response);
        return "OKkkkkkkkkk";
    }

    public <T> T callRestServicePost(HttpHeaders headers, String url, Object requestBody, Class<T> type) throws Exception {
        ResponseEntity<String> response = null;
        URI uri = new URI(url);
        RestTemplate restTemplate = this.builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        log.info("Calling URL : " + url);
        HttpEntity<Object> request = new HttpEntity(requestBody, headers);
        response = restTemplate.postForEntity(uri, request, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("RestService response body : {}", response.getBody());
            return new ObjectMapper().readValue(response.getBody(),type);
        } else {
            log.error(response.getBody());
            throw new Exception("callRestServicePost ERROR");
        }
    }

}
