package com.app.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.entity.Employee;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.service.OrderService;

@Controller
@RequestMapping("/order")
@SessionAttributes("u")
public class OrderController {

	@Resource
	private OrderService orderService;
	/**
	 * 分页查询订单信息
	 * @param helper
	 * @param beginTime
	 * @param endTime
	 * @param status
	 * @param likeCode
	 * @param likeDealer
	 * @param likeStore
	 * @param emp
	 * @return
	 */
	@RequestMapping("/list")
	private @ResponseBody DataGrid list(PageHelper helper,@RequestParam(required=false)Date beginTime,
			@RequestParam(required=false)Date endTime,
			@RequestParam(required=false)Integer status,
			@RequestParam(required=false)String likeCode,
			@RequestParam(required=false)String likeDealer,
			@RequestParam(required=false)String likeStore,
			@ModelAttribute("u")Employee emp){
		Map<String, Object> params = new HashMap<String, Object>();
		
		
		return orderService.findPageList(helper, params, emp);
	}
}
