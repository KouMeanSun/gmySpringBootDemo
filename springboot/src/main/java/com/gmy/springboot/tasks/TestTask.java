package com.gmy.springboot.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class TestTask {

//    private static final SimpleDateFormat dataFormate = new SimpleDateFormat("HH:mm:ss");

    //定义每3秒执行任务
//    @Scheduled(fixedRate = 3000)
    //cron 表达式测试网址 ,springboot 不支持年，表达式只有6位
    // cron.qqe2.com

//    @Scheduled(cron = "4-40 * * * * ? ")
//    public  void reportCurrentTime(){
//        System.out.println("现在时间："+dataFormate.format(new Date()));
//    }
}
