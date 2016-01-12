package com.app.service;

import java.util.Map;

import com.app.entity.Employee;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;

public interface OrderService {

	DataGrid findPageList(PageHelper helper ,Map<String, Object> params,Employee emp);
}
