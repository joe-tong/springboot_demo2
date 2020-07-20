package com.example.springboot_demo2.ThreadLocal;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/20 14:16
 */
public class ThreadLocalWithStaticEmbellish implements Runnable {

    private static final int NCPU = Runtime.getRuntime().availableProcessors();

    private static ThreadLocal<List<String>> threadLocal = ThreadLocal.withInitial(() -> {
        System.out.println("thread-" + Thread.currentThread().getName() + " init thread local");
        return new ArrayList<>();
    });

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            List<String> li = threadLocal.get();
            li.add(Thread.currentThread().getId() + "_" + RandomUtils.nextInt(0, 10));
            threadLocal.set(li);
        }
        System.out.println("[Thread-" + Thread.currentThread().getName() + "], list=" + threadLocal.get());
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalWithStaticEmbellish tl = new ThreadLocalWithStaticEmbellish();
        for (int i = 0; i < NCPU + 1; i++) {
            Thread thread = new Thread(tl, String.valueOf((char) (i + 97)));
            thread.start(); thread.join();
        }
    }
}
