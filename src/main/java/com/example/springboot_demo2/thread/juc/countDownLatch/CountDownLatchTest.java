package com.example.springboot_demo2.thread.juc.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/21 14:33
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Doctor(countDownLatch)).start();
        new Thread(new Nurse(countDownLatch)).start();

        countDownLatch.await();
        System.out.println("完成一单任务");
    }

    static class Doctor implements Runnable {
        private CountDownLatch countDownLatch;

        public Doctor(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("开始诊断");
            try {
                Thread.sleep(3000);
                System.out.println("开始服务");
            } catch (InterruptedException e) {
            }finally {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }


        }
    }

    static class Nurse implements Runnable {
        private CountDownLatch countDownLatch;

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public Nurse(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("开始接皮条");
            try {
                Thread.sleep(5000);
                System.out.println("成功揽客");
            } catch (InterruptedException e) {
            }finally {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }
    }
}
