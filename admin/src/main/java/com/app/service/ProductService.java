package com.app.service;

import com.app.entity.Product;
import com.app.exception.CustomException;

public interface ProductService {

	void save(Product product)throws CustomException;
}
