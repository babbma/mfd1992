package com.app.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControl {

	@Resource
	private UserService userService;
	

	@RequestMapping("/list")
	public String findall(ModelMap map){
		map.addAttribute("list",userService.findAllUser());
		map.addAttribute("msg", "success");
		return "user/list";
	}
	@RequestMapping("/update")
	public String update(ModelMap map,String id){
		userService.update(id);
		map.addAttribute("msg", "success");
		return "user/list";
	}
	@RequestMapping("/remove")
	public String remove(ModelMap map,String id){
		userService.delete(id);
		map.addAttribute("msg", "success");
		return "user/list";
	}
	
	@RequestMapping("/save")
	public String save(ModelMap map){
		User user = new User();
		user.setName("jack");
		user.setPwd("123");
		userService.save(user);
		map.addAttribute("msg", "success");
		return "user/list";
	}
}
