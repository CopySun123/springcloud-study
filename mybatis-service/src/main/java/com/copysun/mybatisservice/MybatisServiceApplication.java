package com.copysun.mybatisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hspcadmin
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class MybatisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisServiceApplication.class, args);
    }

}
