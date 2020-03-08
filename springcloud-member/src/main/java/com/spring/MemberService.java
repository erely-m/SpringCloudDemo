package com.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.IMemberService;
import com.spring.entity.User;

@RestController
public class MemberService implements IMemberService{

	@RequestMapping("getMember")
	public User getMember(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setSex("man");
		return user;
	}
	@RequestMapping("getHystrix")
	public String getHystrix() {
		
		return "getHystrix";
	}

}
