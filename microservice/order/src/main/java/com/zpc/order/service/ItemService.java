package com.zpc.order.service;


import com.zpc.order.entity.Item;
import com.zpc.order.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zpc.order.feign.ItemFeignClient;


@Service
public class ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;

    //@Value("${myspcloud.item.url}")
    //private String itemUrl;

    @Autowired
    OrderProperties orderProperties;

    public Item queryItemById(Long id) {
        // 该方法走eureka注册中心调用(这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("===========普通queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }

    /**
     * 进行容错处理
     * fallbackMethod的方法参数个数类型要和原方法一致
     *
     * @param id
     * @return
     */
    @Autowired
    private ItemFeignClient itemFeignClient;

    public Item queryItemById3(Long id) {
        String itemUrl = "http://app-item/item/{id}";
        //Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        Item result = itemFeignClient.queryItemById(id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }

    /**
     * 请求失败执行的方法
     * fallbackMethod的方法参数个数类型要和原方法一致
     *
     * @param id
     * @return
     */
    public Item queryItemByIdFallbackMethod(Long id) {
        return new Item(id, "查询商品信息出错!", null, null, null);
    }

}
