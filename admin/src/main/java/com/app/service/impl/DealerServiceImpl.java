package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.DealerDao;
import com.app.entity.Dealer;
import com.app.exception.CustomException;
import com.app.service.DealerService;

@Service
public class DealerServiceImpl implements DealerService {

	@Resource
	private DealerDao dealerDao;
	@Override
	public void save(Dealer dealer) throws CustomException {
		// TODO Auto-generated method stub
		dealerDao.save(dealer);
	}

}
