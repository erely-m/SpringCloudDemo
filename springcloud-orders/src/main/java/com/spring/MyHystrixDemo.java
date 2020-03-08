package com.spring;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

public class MyHystrixDemo extends HystrixCommand<String> {

    public MyHystrixDemo(String name,String key){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(name)).andCommandKey(HystrixCommandKey.Factory.asKey(key)));
    }

    @Override
    protected String run() throws Exception {
        return "test";
    }

    public static void main(String[] args) {
        System.out.println(new MyHystrixDemo("test","test").execute());
    }
}
