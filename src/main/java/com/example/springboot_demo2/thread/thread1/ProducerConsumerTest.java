package com.example.springboot_demo2.thread.thread1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Joe
 * @Description:
 * Java实现生产者消费者的方式有：wait && notify、BlockingQueue、Lock && Condition等
 *
 * wait、notify注意事项：
 * (1)可以使用wait（）和nBlockingQueueotify（）方法在Java中实现线程间通信。不只是一个或两个线程，而是多个线程可以使用这些方法相互通信。
 * (2)在synchronized方法或synchronized块中调用wait（），notify（）和notifyAll（）方法，否则JVM将抛出IllegalMonitorStateException。
 * (3)从while（条件）循环调用wait和notify方法，而不是从if（）块调用，因为要重复检查条件，而不仅仅是一次。
 * (4)多使用notifyAll方法而不是notify。
 * @Date 2020/5/18 14:57
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        List<Integer> container = new ArrayList<>();
        Thread producer = new Thread(new Producer(container));
        Thread consumer = new Thread(new Consumer(container));
        producer.start();
        consumer.start();
    }
}