package com.spring;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.entity.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderService implements IOrder {

    @Autowired
    FeignClient1 feign;

    @RequestMapping("getorder2member")
    public User getOrder2Member(String name) {
        // TODO Auto-generated method stub
        return feign.getMember(name);
    }

    @RequestMapping("geteway")
    public String getGeteway(HttpServletRequest request) {

        System.out.println("接收到请求" + request.getRemoteHost());
        return "处理请求成功8002";


    }

    @HystrixCommand(fallbackMethod = "orderToUserInfoFallback")
    @RequestMapping("getHystrix")
    public String getHystrix() {
        System.out.println("getHystrix:当前线程池" + Thread.currentThread().getName());
        return feign.getHystrix();
    }

    @RequestMapping("/orderToUserInfoFallback")
    public String orderToUserInfoFallback() {

        System.out.println("orderToUserInfoFallback:当前线程池" + Thread.currentThread().getName());
        return "系统错误!!!!";
    }
}
