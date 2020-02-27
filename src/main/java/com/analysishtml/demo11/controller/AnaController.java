package com.analysishtml.demo11.controller;

import com.analysishtml.demo11.service.AnaHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class AnaController {
    
    @Autowired
    AnaHtml anaHtml;

    @ResponseBody
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
}
