package com.zpc.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jia
 * @description 开启配置服务
 * @date 2020/6/24
 */

@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class ConfigApplication {
    public static void main(String[] args){
        SpringApplication.run(ConfigApplication.class, args);
    }
}
