package com.app.util;

import com.app.entity.easyui.PageHelper;
import com.app.entity.sub.PageBean;

public class PageUtil {

	/**
	 * 验证pagebean
	 * @param bean
	 */
	public static void validatePageBean(PageBean bean){
		if(bean.getPageNumber()<=0){
			bean.setPageNumber(1);
		}
		if(bean.getPageSize()<=0){
			bean.setPageSize(10);
		}
		
		if(bean.getTotal()<0){
			bean.setTotal(0);
		}
		
		int totalPages = bean.getTotal()% bean.getPageSize()==0?
				bean.getTotal()/ bean.getPageSize():
				bean.getTotal()/bean.getPageSize()+1;
		if(bean.getPageNumber()> totalPages){
			bean.setPageNumber(totalPages);
		}
	}
	
	/**
	 * 将pagehelper转化成pagebean
	 * @param helper 
	 * @return
	 */
	public static PageBean convert(PageHelper helper){
		return new PageBean(helper.getRows(),helper.getPage());
	}
}
