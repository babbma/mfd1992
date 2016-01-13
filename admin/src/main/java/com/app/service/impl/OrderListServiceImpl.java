package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.OrderListDao;
import com.app.entity.OrderList;
import com.app.exception.CustomException;
import com.app.service.OrderListService;
@Service
public class OrderListServiceImpl implements OrderListService {
	@Resource
	private OrderListDao orderListDao;
	@Override
	public void save(OrderList orderlist) throws CustomException {
		// TODO Auto-generated method stub
		orderListDao.save(orderlist);
	}

}
