package com.app.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.dao.ObjectDao;
import com.app.dao.help.HibernateDaoHelp;
import com.app.entity.sub.PageBean;
import com.app.util.PageUtil;

public class ObjectDaoImpl<T> extends HibernateDaoHelp<T> implements ObjectDao<T>{
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		super.save(t);
	}

	

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		super.delete(t);
	}


	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		super.update(t);
	}


	@Override
	public T findById( Serializable id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}



	@Override
	public List<T> findByList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findList(this.addParams(this.getQueryForHql(),params), params);
	}



	@Override
	public Long findCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findLong(this.addParams(getCountFromHql(),params), params);
	}

	
	
	@Override
	public List<T> findPageList(PageBean bean, Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageUtil.validatePageBean(bean);
		return super.findPageList(this.addParams(getQueryForHql(),params), bean, params);
	}



	
}
