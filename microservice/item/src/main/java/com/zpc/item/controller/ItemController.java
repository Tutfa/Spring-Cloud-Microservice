package com.zpc.item.controller;
//import com.zpc.item.config.JdbcConfigBean;
import com.zpc.item.entity.Item;
import com.zpc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evan
 */
@RestController
public class ItemController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private ItemService itemService;
   /* @Autowired
    private JdbcConfigBean jdbcConfigBean;*/
    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "item/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        System.out.println("service port："+port);
        return this.itemService.queryItemById(id);
    }

    /**
     * 健康检查
     * @return
     */
    @RequestMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    /*@GetMapping(value = "testconfig")
    public String testconfig(){
        return this.jdbcConfigBean.toString();
    }*/
}
