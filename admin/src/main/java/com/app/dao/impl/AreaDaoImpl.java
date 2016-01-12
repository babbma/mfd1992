package com.app.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.dao.AreaDao;
import com.app.entity.Area;
@Repository
public class AreaDaoImpl extends ObjectDaoImpl<Area> implements AreaDao {

	@Override
	protected String addParams(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		String temp = super.addParams(hql, params);
		if(params.containsKey("ids")){
			temp+=" and id in (:ids)";
		}
		return temp;
	}

	
	
}
