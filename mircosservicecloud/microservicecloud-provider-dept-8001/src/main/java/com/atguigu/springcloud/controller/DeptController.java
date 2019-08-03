package com.atguigu.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by admin on 2019/1/10 0:54
 *
 * @Author: created by admin
 * @Date: created in 0:54 2019/1/10
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

@RestController
public class DeptController {

    private static final Logger logger  = LoggerFactory.getLogger(DeptController.class);


    @Autowired
    private DiscoveryClient client;



    @RequestMapping(value="/dept/getHello",method=RequestMethod.POST)
    public String hello(){
        return  "hello";
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


    @PostMapping(value = "/dept/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file,@RequestParam("prefixName")String prefixName) {
        logger.info("获取上传文件，file={}",file.getOriginalFilename());
        logger.info("获取上传文件参数，prefixName={}",prefixName);

        return file.getName();
    }



    @PostMapping(value = "/upload-file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestPart("file") MultipartFile file) {
        logger.info("服务端经过微服务接收到文件：fileName={}",file.getOriginalFilename());
        return file.getOriginalFilename();
    }
}
