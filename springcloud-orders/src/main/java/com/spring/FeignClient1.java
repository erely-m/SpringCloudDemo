package com.spring;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-member")
public interface FeignClient1 extends IMemberService  {



}
