package com.app.service;

import com.app.entity.Employee;
import com.app.exception.CustomException;

public interface EmployeeService {
	public Employee login(Employee emp)throws CustomException;
}
