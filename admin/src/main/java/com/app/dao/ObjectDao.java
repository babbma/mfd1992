package com.app.dao;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.entity.sub.PageBean;

public interface ObjectDao<T> {

	void save(T t);
	void delete(T t);
	void update(T t);
	T findById(Serializable id);
	
	/**
	 * 单个对象的集合查询
	 * 会自定根据map的key拼接where条件
	 * @param params 参数
	 * @return 对象的集合
	 */
	List<T> findByList(Map<String, Object> params);
	/**
	 * count查询
	 * 会自定根据map的key拼接where条件
	 * @param params 参数
	 * @return count值
	 */
	Long findCount(Map<String, Object> params);
	
	/**
	 * 单个对象的分页查询
	 * 会自定根据map的key拼接where条件
	 * @param bean 分页对象
	 * @param params 参数
	 * @return 分页对象的集合
	 */
	List<T> findPageList(PageBean bean,Map<String, Object> params);
}
