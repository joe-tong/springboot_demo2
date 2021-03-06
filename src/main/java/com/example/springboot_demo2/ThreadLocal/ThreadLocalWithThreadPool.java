package com.example.springboot_demo2.ThreadLocal;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/20 11:52
 */
public class ThreadLocalWithThreadPool implements Callable<Boolean> {

    private static final int NCPU = Runtime.getRuntime().availableProcessors();

    private ThreadLocal<List<String>> threadLocal = ThreadLocal.withInitial(() -> {
        System.out.println("thread-" + Thread.currentThread().getId() + " init thread local");
        return new ArrayList<>();
    });

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 5; i++) {
            List<String> li = threadLocal.get();
            li.add(Thread.currentThread().getId() + "_" + RandomUtils.nextInt(0, 10));
            threadLocal.set(li);
        }
        System.out.println("[Thread-" + Thread.currentThread().getId() + "], list=" + threadLocal.get());
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("cpu core size : " + NCPU);
        List<Callable<Boolean>> tasks = new ArrayList<>(NCPU * 2);
        ThreadLocalWithThreadPool tl = new ThreadLocalWithThreadPool();
        for (int i = 0; i < NCPU * 2; i++) {
            tasks.add(tl);
        }
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Future<Boolean>> futures = es.invokeAll(tasks);
        for (final Future<Boolean> future : futures) {
            future.get();
        }
        es.shutdown();
    }
}
