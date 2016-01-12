package com.app.dao;

import java.util.List;
import java.util.Map;

import com.app.entity.Order;
import com.app.entity.sub.PageBean;

public interface OrderDao extends ObjectDao<Order> {

	Long pageCount(Map<String,Object> params);
	/**
	 * 查询
	 * 顺序依次为order order_list product dealer store
	 * @param bean 分页对象
	 * @param params 参数
	 * @return
	 */
	List<Object[]> pageList(PageBean bean ,Map<String, Object> params);
}
