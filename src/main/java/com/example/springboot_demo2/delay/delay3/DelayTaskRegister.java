package com.example.springboot_demo2.delay.delay3;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/7 16:48
 */
public class DelayTaskRegister {
    public static void main(String[] args) {
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

        DelayTask task1 = new DelayTask();
        DelayTask task2 = new DelayTask();
        DelayTask task3 = new DelayTask();

        task1.setExecuteTime(TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS) + System.currentTimeMillis());
        task1.setMsg("DelayTask-1");
        task1.setTaskType("taskType-1");

        task2.setExecuteTime(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS) + System.currentTimeMillis());
        task2.setMsg("DelayTask-2");
        task2.setTaskType("taskType-2");

        task3.setExecuteTime(TimeUnit.MILLISECONDS.convert(10, TimeUnit.SECONDS) + System.currentTimeMillis());
        task3.setMsg("DelayTask-3");
        task3.setTaskType("taskType-3");

        delayQueue.offer(task1);
        delayQueue.offer(task2);
        delayQueue.offer(task3);

        DelayTaskProcessor processor = new DelayTaskProcessor();
        processor.setDelayQueue(delayQueue);

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(processor);


        AtomicBoolean a = new AtomicBoolean(false);
        boolean andSet = a.getAndSet(true);
        System.out.println(andSet);
        System.out.println(a);

    }
}
