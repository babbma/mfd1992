package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.entity.Area;

public interface AreaService {

	/**
	 * 所有市区的集合
	 * @param params 参数
	 * @return
	 */
	List<Area> findCityList(Map<String,Object> params);
	
	/**
	 * 所有省份的集合
	 * @param params 参数
	 * @return
	 */
	List<Area> findProvinceList(Map<String, Object> params);
}
