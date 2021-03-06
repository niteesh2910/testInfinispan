package com.test.niteesh.service;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.spring.provider.SpringEmbeddedCacheManager;
import org.jboss.as.clustering.infinispan.DefaultCacheContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@EnableCaching
@Configuration
public class CacheConfig {

	private static final String COMMON_CACHE_NAME = "common";
	private static final String CACHE_CONTAINER_JNDI ="cache.container.jndi";
	private static final Logger logger = Logger.getLogger(CacheConfig.class.getName());
	
	@Autowired
	Environment env;
	 
	@Bean
	public SpringEmbeddedCacheManager cacheManager() throws IOException, NamingException {
		logger.info("******************************Inside Cache config*********************************");
		Context context = new InitialContext();  
		DefaultCacheContainer container = (DefaultCacheContainer) context.lookup(env.getRequiredProperty(CACHE_CONTAINER_JNDI));
		logger.info("container........................."+ container);
		logger.info("container Default Cache..........."+ container.getDefaultCacheName());
		logger.info("container common cache exist......"+ container.cacheExists(COMMON_CACHE_NAME));
		org.infinispan.configuration.cache.Configuration configuration = new ConfigurationBuilder().clustering().cacheMode(CacheMode.DIST_SYNC).build();
		if(!container.cacheExists(COMMON_CACHE_NAME)) {
			container.createCache(COMMON_CACHE_NAME, configuration);
		}
		
		Set<String> caches = container.getCacheNames();
		for (String cache : caches) {
			logger.info("cache........................."+ cache);
		}
		
		EmbeddedCacheManager cacheManager = container.startCaches(COMMON_CACHE_NAME);
		
		cacheManager.addListener(new ClusterListener(4));
		cacheManager.getCache(COMMON_CACHE_NAME).addListener(new CacheListener());
		
		return new SpringEmbeddedCacheManager(cacheManager);
	}
}
