package com.app.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

/**
 * 员工controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {
	private static final Logger log =LoggerFactory.getLogger(EmployeeController.class);

	@Resource
	private EmployeeService employeeService;
	/**
	 * 跳转用户下的路径
	 * @param path
	 * @return
	 */
	@RequestMapping("/page/{path}")
	public String urlPath(@PathVariable("path")String path){
		log.info("request path {}" ,path);
		return "employee/"+path;
	}
	
	/**
	 * 登陆
	 * @param emp
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Employee emp){
		log.info("login method");
		return "redirect:/emp/page/login";
	}
	
	
}
