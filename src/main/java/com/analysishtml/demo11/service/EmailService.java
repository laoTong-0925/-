package com.analysishtml.demo11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 发送邮件时发布事件
     */
    public void sendEmail(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("first eamil send success.");
        // 发布事件
        applicationContext.publishEvent(new MyEvent(applicationContext));

        System.out.println("second eamil send callBack.");
    }
}
