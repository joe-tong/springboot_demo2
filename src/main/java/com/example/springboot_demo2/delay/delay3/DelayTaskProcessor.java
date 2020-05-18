package com.example.springboot_demo2.delay.delay3;

import com.example.springboot_demo2.util.DateUtil;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/7 17:06
 */
public class DelayTaskProcessor implements Runnable {

    private DelayQueue<DelayTask> delayQueue = new DelayQueue<>();


    public DelayQueue<DelayTask> getDelayQueue() {
        return delayQueue;
    }

    public void setDelayQueue(DelayQueue<DelayTask> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        System.out.println("task start "+ DateUtil.formatDate(new Date()));
        while(!Thread.interrupted()){
            try {
                DelayTask task = delayQueue.take();
                System.out.println(task.getMsg()+"_____"+ DateUtil.formatDate(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
