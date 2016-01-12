package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.OrderDao;
import com.app.entity.Area;
import com.app.entity.Dealer;
import com.app.entity.Employee;
import com.app.entity.Order;
import com.app.entity.OrderList;
import com.app.entity.Product;
import com.app.entity.Store;
import com.app.entity.config.Constant;
import com.app.entity.datagrid.OrderDG;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.entity.sub.PageBean;
import com.app.service.OrderService;
import com.app.util.PageUtil;

@Service
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderDao orderDao;
	@Override
	public DataGrid findPageList(PageHelper helper, Map<String, Object> params,Employee emp) {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		
		if((emp==null || emp.getArea()==null || emp.getArea().isEmpty()) && emp.getRole().intValue()== Constant.ADMIN){
			return dg;
		}else if(Constant.ADMIN.intValue() == emp.getRole().intValue()){
			List<Integer> area = new ArrayList<Integer>();
			for(Area item:emp.getArea()){
				area.add(item.getId());
			}
			params.put("areaIds", area);
		}
		
		Long cnt = orderDao.pageCount(params);
		
		dg.setTotal(cnt);
		
		PageBean bean = PageUtil.convert(helper);
		bean.setTotal(cnt.intValue());
		
		List<Object[]> list = orderDao.pageList(bean, params);
		List<OrderDG> dgList = new ArrayList<OrderDG>();
		for(Object[] item:list){
			dgList.add(new OrderDG((Order)item[0],(OrderList)item[1],(Product)item[2],(Dealer)item[3],(Store)item[4]));
		}
		dg.setRows(dgList);
		return dg;
	}

}
