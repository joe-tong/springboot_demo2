package com.example.springboot_demo2;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class TestController {

    public static void main(String[] args) {
        Integer preNum = -21;
        Integer nextNum = preNum + 1;

        String preNumStr = String.valueOf(preNum);
        String nextNumStr = String.valueOf(nextNum);
        String bodyNum = "00000000";

        int initNumC = Integer.parseInt(preNumStr + bodyNum);
        int nextNumC = Integer.parseInt(nextNumStr + bodyNum);
        AtomicInteger authNum = new AtomicInteger(initNumC);
        System.out.println(authNum.incrementAndGet());
        if (initNumC > nextNum) {

        }


    }
}
