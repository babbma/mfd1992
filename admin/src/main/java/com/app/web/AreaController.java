package com.app.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * 省份的集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/plist")
	public List<Area> list(){
		Map<String, Object> params = new HashMap<String, Object>();
		return areaService.findProvinceList(params);
		
	}
	
	/**
	 * 城市的集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/clist")
	public List<Area> cityList(){
		Map<String, Object> params = new HashMap<String, Object>();
		return areaService.findCityList(params);
	}
}
