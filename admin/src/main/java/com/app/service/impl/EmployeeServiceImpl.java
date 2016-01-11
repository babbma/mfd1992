package com.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.entity.Employee;
import com.app.exception.CustomException;
import com.app.service.EmployeeService;
import com.app.util.MD5Util;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	@Override
	public Employee login(Employee emp) throws CustomException{
		// TODO Auto-generated method stub
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("phone", emp.getPhone());
			List<Employee> list = employeeDao.findByList(params);
			if(list==null || list.isEmpty()){
				throw new CustomException("该账号不存在！");
			}else{
				Employee employ= list.get(0);
				if(!employ.getPwd().equals(MD5Util.MD5(emp.getPwd()))){
					throw new CustomException("密码不正确！");
				}else{
					return employ;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage(),e);
		}
	}

}
