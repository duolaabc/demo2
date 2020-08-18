package com.imooc.demo.web;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/webservice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@DefaultProperties(defaultFallback = "timeOutError")
public class HystrixTestController {

    /**
     * 该方法是对接口调用超时的处理方法
     */
    public String timeOutError() {
        return "time out";
    }



}