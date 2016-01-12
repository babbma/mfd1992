package com.app.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.dao.OrderDao;
import com.app.entity.Order;
import com.app.entity.sub.PageBean;
@Repository
public class OrderDaoImpl extends ObjectDaoImpl<Order> implements OrderDao {

	@Override
	public Long pageCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		String hql=" select count(o) from Order o ,OrderList ol ,Product p,Store s ,Dealer d "
				+ "where o.id = ol.orderId and o.storeId = s.id and ol.productId = p.id and p.dealerId = d.id ";
		hql=addParams(hql, params);
		return findLong(hql, params);
	}

	@Override
	public List<Object[]> pageList(PageBean bean, Map<String, Object> params) {
		// TODO Auto-generated method stub
		String hql=" select o,ol,p,d,s from Order o ,OrderList ol ,Product p,Store s ,Dealer d "
				+ "where o.id = ol.orderId and o.storeId = s.id and ol.productId = p.id and p.dealerId = d.id ";
		hql=addParams(hql, params);
		hql+=" order by o.orderDate desc ";
		return findObjectArrayPageList(hql, bean, params);
	}

	@Override
	protected String addParams(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		String temp = super.addParams(hql, params);
		if(params.containsKey("areaIds")){
			temp+=" and d.area.id in (:areaIds)";
		}
		if(params.containsKey("beginTime")){
			temp+=" and o.orderDate >=:beginTime";
		}
		if(params.containsKey("endTime")){
			temp+=" and o.orderDate <=endTime";
		}
		if(params.containsKey("likeCode")){
			temp+=" and o.code like '%:likeCode%'";
		}
		if(params.containsKey("likeDealerName")){
			temp+=" and d.name  like '%:likeDealerName%'";
		}
		if(params.containsKey("likeStoreName")){
			temp+=" and s.name like '%:likeStoreName%'";
		}
		return temp;
	}
	
	

}
