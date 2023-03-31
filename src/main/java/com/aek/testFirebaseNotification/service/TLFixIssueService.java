package com.aek.testFirebaseNotification.service;

import com.aek.testFirebaseNotification.model.Request0;
import com.aek.testFirebaseNotification.util.RestServiceUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TLFixIssueService {
    @Autowired
    private RestServiceUtil restServiceUtil;

    public String fixTLProAutoSubmitProd(Request0 request0) throws Exception {
        log.info("request0 : {}", request0);
        String url = "https://tlproplus-api.thailife.com/TLPromptBackendWs/1.0/rest/nbapplication/autoSubmitNBAPPService";

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, request0.getBearer());

        Request1 request1 = new Request1();
        Body body = new Body();
        Datas datas = new Datas();
        datas.setPaymentslipno(request0.getPaymentsplipno());
        body.setData(datas);

        request1.setHeaders(new Headers());
        request1.setBody(body);

        Object response = restServiceUtil.callRestServicePost(headers, url, request1, Object.class);
        log.info("response : {}", response);
        return "OKkkkkkkkkk";
    }
}

@Data
class Request1 {
    private Body body;
    private Headers headers;
}

@Data
class Body {
    Datas data;
}

@Data
class Datas {
    private String paymentslipno;
}

@Data
class Headers {
    @JsonProperty("uID")
    private String uID;
}
