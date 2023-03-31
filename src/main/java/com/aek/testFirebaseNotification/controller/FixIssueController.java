package com.aek.testFirebaseNotification.controller;

import com.aek.testFirebaseNotification.model.Request0;
import com.aek.testFirebaseNotification.service.TLFixIssueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping("/fixIssue")
@Controller
public class FixIssueController {

    @Autowired
    private TLFixIssueService tlFixIssueService;

    @PostMapping(value = "/fixTLProAutoSubmitProd")
    public @ResponseBody String fixTLProAutoSubmitProd(@RequestBody Request0 request0) throws Exception {
        log.info("======= ENTER fixTLProAutoSubmitProd ===========");
        tlFixIssueService.fixTLProAutoSubmitProd(request0);
        log.info("======= END fixTLProAutoSubmitProd ===========");
        return "OKkkkkkkkkk";
    }
}
