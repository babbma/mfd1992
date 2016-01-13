package com.app.service;

import com.app.entity.Store;
import com.app.exception.CustomException;

public interface StoreService {

	void save(Store store)throws CustomException;
}
