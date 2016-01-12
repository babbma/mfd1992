package com.app.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.dao.EmployeeDao;
import com.app.entity.Employee;
@Repository
public class EmployeeDaoImpl extends ObjectDaoImpl<Employee> implements EmployeeDao {

	@Override
	protected String addParams(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		String temp =  super.addParams(hql, params);
		if(params.containsKey("notid")){
			temp+=" and id !=:notid";
		}
		if(params.containsKey("notids")){
			temp+=" and id not in (:notids)";
		}
		return temp;
	}

	
	
}
