package com.app.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.service.DealerService;

@Controller
@RequestMapping("/dealer")
public class DealerController {

	private static final Logger log =LoggerFactory.getLogger(DealerController.class);
	@Resource
	private DealerService dealerService;
	
	/**
	 * 跳转商户下的路径
	 * @param path
	 * @return
	 */
	@RequestMapping("/page/{path}")
	public String urlPath(@PathVariable("path")String path){
		log.info("request path {}" ,path);
		return "dealer/"+path;
	}
	
	@RequestMapping("/list")
	private @ResponseBody DataGrid list(PageHelper helper){
		return null;
	}
}
