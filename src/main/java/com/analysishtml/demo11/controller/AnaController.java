package com.analysishtml.demo11.controller;

import com.analysishtml.demo11.service.AnaHtml;
import com.analysishtml.demo11.service.EmailService;
import com.analysishtml.demo11.service.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AnaController {
    
    @Autowired
    AnaHtml anaHtml;
    @Autowired
    EmailService emailService;

    @RequestMapping(path = "/get")
    public String get() {
            try {
                boolean info = anaHtml.getInfo();
                if (info)
                    return "ok";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "no" ;
    }

    @RequestMapping("aop")
    public String aop(){
        int i=8/0;
        System.out.println(8/1);
        return "1";
    }
    @RequestMapping("li")
    public String li(){
        int i=8/1;
        emailService.sendEmail();
        return "1";
    }
}
