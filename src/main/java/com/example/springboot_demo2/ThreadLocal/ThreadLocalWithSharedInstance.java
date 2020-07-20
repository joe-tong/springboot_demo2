package com.example.springboot_demo2.ThreadLocal;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Joe
 * @Description: 如果记录在 ThreadLocal 中的是一个线程共享的外部对象呢？
 * 先来看 第 1 个问题，如果我们记录的是一个外部线程共享的对象，虽然我们以当前线程私有的 ThreadLocal
 * 对象作为 key 对其进行了存储，但是恶魔终究是恶魔，共享的本质并不会因此而改变，这种情况下的访问还是需要进行同步控制，
 * 最好的方法就是从源头屏蔽掉这类问题。我们来举个例子：
 * @Date 2020/5/20 11:46
 */
public class ThreadLocalWithSharedInstance implements Runnable {

    // list 是一个事实共享的实例，即使被 ThreadLocal 修饰
    private static List<String> list = new ArrayList<>();
    private ThreadLocal<List<String>> threadLocal = ThreadLocal.withInitial(() -> list);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            List<String> li = threadLocal.get();
            li.add(Thread.currentThread().getName() + "_" + RandomUtils.nextInt(0, 10));
            threadLocal.set(li);
        }
        System.out.println("[Thread-" + Thread.currentThread().getName() + "], list=" + threadLocal.get());
    }

    public static void main(String[] args) throws Exception {
        Thread ta = new Thread(new ThreadLocalWithSharedInstance(), "a");
        Thread tb = new Thread(new ThreadLocalWithSharedInstance(), "b");
        Thread tc = new Thread(new ThreadLocalWithSharedInstance(), "c");
        ta.start(); ta.join();
        tb.start(); tb.join();
        tc.start(); tc.join();
    }
}