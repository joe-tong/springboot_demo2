package com.example.springboot_demo2.arthas;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/18 11:38
 */
@Api(tags = "arthas监控中心")
@RestController
@RequestMapping("monitor")
@Slf4j
public class ArthasController {


    @ApiOperation(value = "cpu飙高检测")
    @GetMapping("cpu/high")
    public void cpuHigh(){
        log.debug("cpuHigh cpu飙高检测");
        Arthas.cpu();
    }

    @ApiOperation(value = "线程阻塞")
    @GetMapping("thread/block")
    public void threadBlock() {
        log.debug("threadBlock 线程阻塞");
        // 模拟线程阻塞
        Arthas.thread();
    }

    @ApiOperation(value = "线程死锁")
    @GetMapping("thread/dead")
    public void threadDead() {
        log.debug("threadDead 线程死锁 ");
        // 模拟线程死锁
        Arthas.deadThread();
    }

    @ApiOperation(value = "多线程hashMap死锁")
    @GetMapping("hash/dead")
    public void hashSet() {
        log.debug("hashSet 多线程hashMap死锁");
       // 不断的向 hashSet 集合增加数据
        Arthas.addHashSetThread();
    }
}
