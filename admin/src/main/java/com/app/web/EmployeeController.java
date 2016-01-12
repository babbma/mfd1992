package com.app.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

import com.app.entity.Area;
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
@SessionAttributes(value={"u","as"})
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
			log.info("area info {}",e.getArea());
			attr.addFlashAttribute("as", e.getArea());
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
		model.remove("as");
		return "employee/login";
	}
	
	/**
	 * 管理员列表
	 * @param helper 分页对象
	 * @param emp
	 * @return
	 */
	
	@RequestMapping("/list")
	public @ResponseBody DataGrid list(PageHelper helper,Employee emp ){
		Map<String,Object> params = new HashMap<String, Object>();
		return employeeService.findPageList(helper, params);
	}
	
	/**
	 * 添加管理员
	 * @param emp 管理员
	 * @param area 管理员管理的区域
	 * @return
	 */
	@RequestMapping("/save")
	public @ResponseBody Json save(Employee emp,@RequestParam(value="areas",required=false)Integer[] areas){
		Json json = new Json();
		try {
			employeeService.save(emp, areas);
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
	
	
	/**
	 * 修改员工信息 
	 * 如果不填写 ，默认使用原来的值
	 * @param emp 员工信息
	 * @param areas 员工管理的区域
	 * @return 处理结果
	 */
	@RequestMapping("/edit")
	public @ResponseBody Json edit(Employee emp,@RequestParam(value="areas",required=false)Integer[] areas){
		Json json = new Json();
		try {
			employeeService.update(emp, areas);
			json.setSuccess(true);
			json.setMsg("修改成功！");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	
	/**
	 * 根据用户的id 
	 * 查询该用户的所管理的区域
	 * @param id emp id
	 * @return
	 */
	@RequestMapping("/empareas")
	public @ResponseBody Set<Area> empAreas(Integer id){
		return employeeService.findById(id).getArea();
	}
	
	
	/**
	 * 删除指定的用户
	 * @param id emp id
	 * @return 
	 */
	@RequestMapping("/delete")
	public @ResponseBody Json remove(Integer id){
		Json json = new Json();
		try {
			employeeService.delete(id);
			json.setSuccess(true);
			json.setMsg("删除成功！");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	
	
	
}
