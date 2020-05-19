package com.example.springboot_demo2.thread.thread1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/18 14:56
 */
public class Producer implements Runnable {
    /**
     * 产品容器
     */
    private final List<Integer> container;

    public Producer(List<Integer> container) {
        this.container = container;
    }

    /**
     * 生产者生产方法
     *
     * @throws InterruptedException
     */
    private void produce() throws InterruptedException {
        //产品容器容量
        int capacity = 5;
        synchronized (container) {
            System.out.println("生产container：" + container.toString());
            //当容器已满,暂停生产
            while (container.size() == capacity) {
                System.out.println("...容器已经满了，暂停生产...");
                container.wait();
            }
            Random random = new Random();
            int p = random.nextInt(50);
            //模拟1秒生产一个产品
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("生产产品：" + p);
            container.add(p);
            container.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("produce error");
            }
        }
    }
}