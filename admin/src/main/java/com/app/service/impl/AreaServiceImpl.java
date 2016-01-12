package com.app.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.AreaDao;
import com.app.entity.Area;
import com.app.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Resource
	private AreaDao areaDao;
	@Override
	public List<Area> findCityList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		//添加区分城市的参数
		params.put("level", 1);
		return areaDao.findByList(params);
	}

	@Override
	public List<Area> findProvinceList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		//添加省份的参数
		params.put("level", 0);
		return areaDao.findByList(params);
	}

	
}
