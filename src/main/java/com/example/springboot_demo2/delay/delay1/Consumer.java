package com.example.springboot_demo2.delay.delay1;

import com.example.springboot_demo2.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.logging.SimpleFormatter;

public class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message take = queue.take();
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody());
                System.out.println("current time "+ DateUtil.formatDate(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}