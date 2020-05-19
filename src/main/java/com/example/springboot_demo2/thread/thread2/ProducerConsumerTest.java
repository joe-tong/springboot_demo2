package com.example.springboot_demo2.thread.thread2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/18 15:33
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        List<Integer> container = new ArrayList<>();
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        Thread producer = new Thread(new Producer(container,lock,producerCondition,consumerCondition));
        Thread consumer = new Thread(new Consumer(container,lock,producerCondition,consumerCondition));
        producer.start();
        consumer.start();
    }
}