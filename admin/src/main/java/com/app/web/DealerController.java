package com.app.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.service.DealerService;

@Controller
@RequestMapping("/dealer")
public class DealerController {

	@Resource
	private DealerService dealerService;
	
	@RequestMapping("/list")
	private @ResponseBody DataGrid list(PageHelper helper){
		return null;
	}
}
