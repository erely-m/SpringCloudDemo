package com.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.User;

public interface IMemberService {

	@RequestMapping("getMember")
	public User getMember(@RequestParam("name") String name);
	
	@RequestMapping("getHystrix")
	public String getHystrix();
	
}
