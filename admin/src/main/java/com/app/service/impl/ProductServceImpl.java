package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.entity.Product;
import com.app.exception.CustomException;
import com.app.service.ProductService;

@Service
public class ProductServceImpl implements ProductService {

	@Resource
	private ProductDao productDao;
	@Override
	public void save(Product product) throws CustomException {
		// TODO Auto-generated method stub
		productDao.save(product);
	}
}
