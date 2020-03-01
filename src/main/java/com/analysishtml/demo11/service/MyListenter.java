package com.analysishtml.demo11.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Async
@Component
public class MyListenter implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听...");
            // 监听发送邮件事件
            if(event instanceof MyEvent){
                System.out.println("监听到了..");
                System.out.println(Thread.currentThread().getName());
            }
    }
}
