package com.app.service;

import java.util.Map;

import com.app.entity.Employee;
import com.app.entity.Order;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.exception.CustomException;

public interface OrderService {

	void save(Order order)throws CustomException;
	DataGrid findPageList(PageHelper helper ,Map<String, Object> params,Employee emp);
}
