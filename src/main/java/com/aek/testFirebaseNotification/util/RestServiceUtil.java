package com.aek.testFirebaseNotification.util;

import com.aek.testFirebaseNotification.exception.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Component
public class RestServiceUtil {
    @Autowired
    private RestTemplateBuilder builder;

    public <T> T callRestServicePost(HttpHeaders headers, String url, Object requestBody, Class<T> type) throws Exception {
        ResponseEntity<String> response = null;
        URI uri = new URI(url);
        RestTemplate restTemplate = this.builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        HttpEntity<Object> request = new HttpEntity(requestBody, headers);
        log.info("Calling URL : " + url);
        log.info("request : " + request);
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
