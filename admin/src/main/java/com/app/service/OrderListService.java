package com.app.service;

import com.app.entity.OrderList;
import com.app.exception.CustomException;

public interface OrderListService {

	void save(OrderList orderlist)throws CustomException;
}
