package com.test.niteesh.service;

import java.io.IOException;
import java.util.logging.Logger;

import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.spring.provider.SpringEmbeddedCacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {

	private static final String COMMON_CACHE_NAME = "common";
	Logger logger = Logger.getLogger(CacheConfig.class.getName());
	
	@Bean
	public SpringEmbeddedCacheManager cacheManager() throws IOException {
		logger.info("******************************Inside Cache config*********************************");
		EmbeddedCacheManager cacheManager =  new DefaultCacheManager("infinispan.xml");
		cacheManager.addListener(new ClusterListener(4));
		cacheManager.getCache(COMMON_CACHE_NAME).addListener(new CacheListener());
		return new SpringEmbeddedCacheManager(cacheManager);
	}
}
