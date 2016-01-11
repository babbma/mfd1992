package com.app.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

/**
 * 员工controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
@SessionAttributes("u")
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
	public String login(Employee emp,ModelMap model,RedirectAttributes attr){
		log.info("login method");
		try{
			Employee e = employeeService.login(emp);
			attr.addFlashAttribute("u", e);
			return "redirect:/emp/page/index";
		} catch (Exception e) {
			// TODO: handle exception
//			model.addAttribute("msg",e.getMessage());
			attr.addFlashAttribute("message", e.getMessage());
			log.error(e.getMessage());
			return "redirect:/emp/page/login";
		}
		
	}
	/**
	 * 退出系统的方法
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String loginout(ModelMap model){
		log.info("logout method");
		model.remove("u");
		return "employee/login";
	}
	
	
}
