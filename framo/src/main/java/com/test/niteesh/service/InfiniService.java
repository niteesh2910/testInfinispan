package com.test.niteesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.niteesh.dao.InfiniDAO;
import com.test.niteesh.entity.ApplicationProperty;

@Service
public class InfiniService {

	@Autowired InfiniDAO infiDao;
	
//	@Cacheable(value = "common", key = "#token", unless="#result==null")
	public List<ApplicationProperty> getAllProps(String token) { 
		return infiDao.getAllProps(token);
	}

}
