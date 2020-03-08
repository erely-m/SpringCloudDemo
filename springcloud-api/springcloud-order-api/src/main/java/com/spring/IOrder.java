package com.spring;

import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.User;

public interface IOrder {
	
	@RequestMapping("getOrder2Member")
	public User getOrder2Member(String name);
	
	@RequestMapping("getHystrix")
	public String getHystrix();

}
