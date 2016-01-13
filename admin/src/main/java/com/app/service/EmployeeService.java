package com.app.service;

import java.util.Map;

import com.app.entity.Employee;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.exception.CustomException;

public interface EmployeeService {
	Employee login(Employee emp)throws CustomException;
	
	DataGrid findPageList(PageHelper helper,Map<String, Object> params);
	void save(Employee emp)throws CustomException;
	void save(Employee emp,Integer[] area)throws CustomException;
	void update(Employee emp,Integer[] area)throws CustomException;
	
	Employee findById(Integer id);
	void delete(Integer id)throws CustomException;
}
