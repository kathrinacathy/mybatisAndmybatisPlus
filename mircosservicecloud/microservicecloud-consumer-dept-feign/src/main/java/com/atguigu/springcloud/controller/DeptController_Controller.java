package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feign.FileUploadFeignServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2019/1/23 0:33
 *
 * @Author: created by admin
 * @Date: created in 0:33 2019/1/23
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */
//@RestController
@Controller
public class DeptController_Controller {
//    private static final String REST_URL_PERFIX= "http://localhost:8001";
//    private static final String REST_URL_PERFIX= "http://microservicecloud-dept:8001";
//    @Autowired
//    RestTemplate restTemplate;
private static final Logger logger  = LoggerFactory.getLogger(DeptController_Controller.class);

    @Autowired
    FileUploadFeignServiceClient fileUploadFeignServiceClient;


    @RequestMapping(value = "/consumer/fileUpload",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String upload(@RequestPart("file")MultipartFile file , HttpServletRequest request, HttpServletResponse response) {
        logger.info("附件上传到controller：{},{},{},{}",file.getName(),file.getContentType(),file.getOriginalFilename(),file.getSize());
        String upload = fileUploadFeignServiceClient.fileUpload(file);
        logger.info("上传文件结束：文件名={}",upload);
        return upload;
    }





}
