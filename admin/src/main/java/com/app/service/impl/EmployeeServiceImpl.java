package com.app.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.AreaDao;
import com.app.dao.EmployeeDao;
import com.app.entity.Area;
import com.app.entity.Employee;
import com.app.entity.config.Constant;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.entity.sub.PageBean;
import com.app.exception.CustomException;
import com.app.service.EmployeeService;
import com.app.util.MD5Util;
import com.app.util.PageUtil;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private AreaDao areaDao;
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
	@Override
	public DataGrid findPageList(PageHelper helper, Map<String, Object> params)  {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		PageBean bean = PageUtil.convert(helper);
		params.put("role", Constant.ADMIN);
		Long cnt = employeeDao.findCount(params);
		bean.setTotal(cnt.intValue());
		dg.setTotal(cnt);
		dg.setRows(employeeDao.findPageList(bean, params));
		return dg;
	}
	@Override
	public void save(Employee emp, Integer[] area) throws CustomException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			//检查手机号码是否存在
			params.put("phone", emp.getPhone());
			Long cnt = employeeDao.findCount(params);
			if(cnt >0){
				throw new CustomException("该账号已经存在！");
			}
			
			if(emp.getJobNumber()==null || "".equals(emp.getJobNumber())){
				emp.setJobNumber(emp.getPhone());
			}
			if(emp.getName()==null ||"".equals(emp.getName())){
				emp.setName(emp.getPhone());
			}
			if(emp.getPwd()==null || "".equals(emp.getPwd())){
				emp.setPwd(emp.getPhone());
			}
			emp.setPwd(MD5Util.MD5(emp.getPwd()));
			emp.setRole(Constant.ADMIN);
			
			employeeDao.save(emp);
			
			//添加管理的区域
			if(area!=null && area.length!=0){
				params.clear();
				params.put("ids", area);
				List<Area> areas =areaDao.findByList(params);
				
				Set<Area> set = new HashSet<Area>();
				set.addAll(areas);
				emp.setArea(set);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomException(e.getMessage(),e);
		}
	}
	
	
	

}
