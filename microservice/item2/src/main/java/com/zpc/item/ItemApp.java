/**
 * @author Jia
 * @description
 * @date 2020/6/16
 */
package com.zpc.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication//申明这是一个Spring Boot项目
@EnableEurekaClient
//@ComponentScan(basePackages = {"com.zpc.item.*"})//手动指定bean组件扫描范围
public class ItemApp {
    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class, args);
    }
}