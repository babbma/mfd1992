package com.app.dao.help;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.entity.sub.PageBean;

public class HibernateDaoHelp<T> {

	
	@SuppressWarnings("unchecked")
	public HibernateDaoHelp() {
		super();
		//初始化的时候将泛型的class获得到
		this.clazz= (Class<T>)((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}


	protected Class<T> clazz;
	//使用注解注入sessionfactory
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//获得session的方法
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 查询单个对象的集合
	 * @param hql hql查询语句
	 * @param params 参数
	 * @return 单个对象的集合
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findList(String hql ,Map<String, Object> params){
		return getSession().createQuery(hql).setProperties(params).list();
	}
	
	
	/**
	 * 查询对象数组的对象集合
	 * @param hql hql查询语句
	 * @param params 参数
	 * @return 对象数组的集合
	 */
	@SuppressWarnings("unchecked")
	protected List<Object[]> findObjectArrayList(String hql ,Map<String, Object> params){
		return getSession().createQuery(hql).setProperties(params).list();
	}
	
	
	/**
	 * 查询数量
	 * @param hql
	 * @param params
	 * @return
	 */
	protected Long findLong(String hql,Map<String,Object> params){
		return (Long) getSession().createQuery(hql).setProperties(params).uniqueResult();
	}
	
	
	/**
	 * 单个对象的分页查询
	 * @param hql hql查询语句
	 * @param bean 分页对象
	 * @param params 参数
	 * @return 单个对象的集合
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findPageList(String hql ,PageBean bean, Map<String, Object> params){
		return getSession().createQuery(hql)
				.setProperties(params)
				.setFirstResult(bean.getPageSize()*(bean.getPageNumber()-1))
				.setMaxResults(bean.getPageSize()).list();
	}
		
	/**
	 * <p>对象数组的分页查询</p>
	 * @param hql hql查询语句
	 * @param bean 分页对象
	 * @param params 参数
	 * @return 对象数组的集合
	 */
	@SuppressWarnings("unchecked")
	protected List<Object[]> findObjectArrayPageList(String hql ,PageBean bean, Map<String, Object> params){
		return getSession().createQuery(hql)
				.setProperties(params)
				.setFirstResult(bean.getPageSize()*(bean.getPageNumber()-1))
				.setMaxResults(bean.getPageSize()).list();
	}
	
	
	/**
	 * <p>查询单个对象</p>
	 * <p>按照主键查询</p>
	 * @param id 主键
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	protected T findById(Serializable id){
		return (T) getSession().get(clazz, id);
	}
	
	/**
	 * 删除
	 * @param t
	 */
	protected void delete(T t){
		getSession().delete(t);
	}
	
	/**
	 * 修改
	 * @param t
	 */
	protected void update(T t){
		getSession().update(t);
	}
	
	/**
	 * 保存
	 * @param t
	 */
	protected void save(T t){
		getSession().save(t);
	}
	
	
	/**
	 * <p>将最原始的hql语句拼接条件</p>
	 * <p>按照paramsmap的集合来拼接</p>
	 * <p>只要存在对应的参数，就会将该属性添加到where条件中</p>
	 * <p>要确保map中的key值是在entity中的属性中是存在的</p>
	 * @param hql hql查询语句
	 * @param params 参数
	 * @return 拼接完成的语句
	 */
	protected String addParams(String hql ,Map<String, Object> params){
		StringBuffer sb = new StringBuffer(hql);
		if(hql.indexOf(" where ")==-1 ){
			sb.append(" where 1=1 ");
		}
		Field[] fs = clazz.getDeclaredFields();
		for(Field item:fs){
			Type ftype = item.getGenericType();
			String fieldTypeName = ftype.getClass().getName();
			String name = item.getName();
			if(fieldTypeName.equals("java.lang.String")
					||fieldTypeName.startsWith("java.lang.")
					|| fieldTypeName.equals("java.util.Date")){
				if(params.containsKey(name)){
					sb.append(" and ")
					.append(name).append("=:").append(name).append(" ");
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 按照entity的属性拼接count语句
	 * @return count查询语句
	 */
	protected String getCountFromHql(){
		String ClassName = clazz.getSimpleName();
		String alias = ClassName.substring(0,1).toLowerCase();
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(").append(alias).append(")")
		.append(" from ").append(ClassName).append(" ").append(alias).append(" ");
		return sb.toString();
	}
	
	/**
	 * 按照entity拼接list查询语句
	 * @return list查询语句
	 */
	protected String getQueryForHql(){
		String ClassName =clazz.getSimpleName();
		String alias = ClassName.substring(0,1).toLowerCase();
		StringBuffer sb = new StringBuffer();
		sb.append(" from ").append(ClassName).append(" ").append(alias).append(" ");
		return sb.toString();
	}
	
}
