package com.app.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.entity.Area;
import com.app.entity.Employee;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.service.OrderService;
import com.app.util.DateUtil;

@Controller
@RequestMapping("/order")
@SessionAttributes(value={"u","as"})
public class OrderController {

	private static final Logger log =LoggerFactory.getLogger(OrderController.class);
	@Resource
	private OrderService orderService;
	
	/**
	 * 跳转订单下的路径
	 * @param path
	 * @return
	 */
	@RequestMapping("/page/{path}")
	public String urlPath(@PathVariable("path")String path){
		log.info("request path {}" ,path);
		return "order/"+path;
	}
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
	private @ResponseBody DataGrid list(PageHelper helper,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date beginTime,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endTime,
			@RequestParam(required=false)Integer status,
			@RequestParam(required=false)String likeCode,
			@RequestParam(required=false)String likeDealer,
			@RequestParam(required=false)String likeStore,
			@ModelAttribute("u")Employee emp,@ModelAttribute("as")Set<Area> as){
		Map<String, Object> params = new HashMap<String, Object>();
		if(beginTime==null && endTime==null){
			params.put("beginTime", DateUtil.currentDayBegin());
		}
		if(beginTime!=null){
			params.put("beginTime", beginTime);
		}
		if(endTime!=null){
			params.put("endTime", endTime);
		}
		
		if(status!=null && status.intValue()!=-1){
			params.put("ostatus", status);
		}
		if(likeCode!=null&& !"".equals(likeCode)){
			params.put("likeCode", likeCode);
		}
		if(likeDealer!=null && !"".equals(likeDealer)){
			params.put("likeDealer", likeDealer);
		}
		if(likeStore!=null && !"".equals(likeStore)){
			params.put("likeStore", likeStore);
		}
		emp.setArea(as);
		return orderService.findPageList(helper, params, emp);
	}
}
