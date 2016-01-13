package com.app.service;

import com.app.entity.Dealer;
import com.app.exception.CustomException;

public interface DealerService {

	void save(Dealer dealer)throws CustomException;
}
