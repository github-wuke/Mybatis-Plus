package com.wuke;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 项目启动时执行
 */
@Slf4j
@Component
@Order(Integer.MIN_VALUE)
public class ProjectInitApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        log.info("项目开始进行初始化...");
    }
}
