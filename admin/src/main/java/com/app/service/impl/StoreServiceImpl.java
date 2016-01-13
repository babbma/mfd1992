package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.StoreDao;
import com.app.entity.Store;
import com.app.exception.CustomException;
import com.app.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Resource
	private StoreDao storeDao;
	@Override
	public void save(Store store) throws CustomException {
		// TODO Auto-generated method stub
		storeDao.save(store);
	}

}
