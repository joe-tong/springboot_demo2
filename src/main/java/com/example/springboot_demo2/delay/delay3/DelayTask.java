package com.example.springboot_demo2.delay.delay3;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/7 16:37
 */
public class DelayTask implements Delayed {
    private long executeTime;
    private String msg;
    private String taskType;

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask task = (DelayTask)o;
//        if (this.executeTime>task.getExecuteTime()){
//            return 1;
//        }else if (this.executeTime == task.getExecuteTime()){
//            return 0;
//        }else {
//            return -1;
//        }
        int i = (int) (this.executeTime - (task.getExecuteTime()));
        System.out.println("aaa"+i);
        return i;
    }
}
