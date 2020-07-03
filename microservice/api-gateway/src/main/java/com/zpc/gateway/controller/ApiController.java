package com.zpc.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jia
 * @description
 * @date 2020/7/3
 */

@RestController
public class ApiController {

    /**
     * 健康检查
     * @return
     */
    @RequestMapping("/health")
    public String healthCheck() {
        return "OK";
    }

}
