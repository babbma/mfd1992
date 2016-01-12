package com.app.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Employee;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.Json;
import com.app.entity.easyui.PageHelper;
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
	
	/**
	 * 管理员列表
	 * @param helper 分页对象
	 * @param emp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public DataGrid list(PageHelper helper,Employee emp ){
		Map<String,Object> params = new HashMap<String, Object>();
		return employeeService.findPageList(helper, params);
	}
	
	/**
	 * 添加管理员
	 * @param emp 管理员
	 * @param area 管理员管理的区域
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Json save(Employee emp,@RequestParam("area[]")Integer[] area){
		Json json = new Json();
		try {
			employeeService.save(emp, area);
			json.setSuccess(true);
			json.setMsg("添加成功！");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
}
