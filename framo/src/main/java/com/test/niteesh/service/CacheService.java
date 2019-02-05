package com.test.niteesh.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.niteesh.entity.ApplicationProperty;

@Service
public class CacheService {
	
//	@Autowired
//	CacheManager cacheManager;

//	@Cacheable(value = "common", key = "#token", unless="#result==null")
    public List<ApplicationProperty> getAllProps(String token) {
//		Cache cache = cacheManager.getCache("common");
		return null;
    }
}
