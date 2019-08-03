package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by admin on 2019/1/23 0:44
 *
 * @Author: created by admin
 * @Date: created in 0:44 2019/1/23
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */
//@EnableFeignClients(basePackages= {"com.atguigu.springcloud"})
//@ComponentScan("com.atguigu.springcloud")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class DeptConsumer80_Feign_App {

    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
