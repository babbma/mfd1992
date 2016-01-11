package com.app.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.Area;
import com.app.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Resource
	private AreaService areaService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<Area> list(){
		return null;
	}
}
