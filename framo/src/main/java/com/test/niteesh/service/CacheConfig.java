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
	private static final String LOOKUP_CACHE_NAME = "lookup";
	private static final String TOKEN_CACHE_NAME = "token";
	private static final String COMPANY_CACHE_NAME = "company";
	private static final String VENDOR_CACHE_NAME = "vendor";
	private static final String ALL_COMPANY_CACHE_NAME = "allcompany";
	private static final String COUNTRY_CACHE_NAME = "country";
	private static final String LOCATION_CACHE_NAME = "location";
	private static final String PRODUCT_CACHE_NAME = "product";
	private static final String PRODUCT_MAPPING_CACHE_NAME = "product_mapping";
	private static final String PO_STATUS_CACHE_NAME = "po_status";
	private static final String NOTIFICATION_ALERT_CONFIGS_CACHE_NAME = "notificationAlertConfigs";
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
		org.infinispan.configuration.cache.Configuration configuration = new ConfigurationBuilder().clustering().cacheMode(CacheMode.LOCAL).build();
		if(!container.cacheExists(COMMON_CACHE_NAME)) {
			container.createCache(COMMON_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(LOOKUP_CACHE_NAME)) {
			container.createCache(LOOKUP_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(TOKEN_CACHE_NAME)) {
			container.createCache(TOKEN_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(COMPANY_CACHE_NAME)) {
			container.createCache(COMPANY_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(VENDOR_CACHE_NAME)) {
			container.createCache(VENDOR_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(ALL_COMPANY_CACHE_NAME)) {
			container.createCache(ALL_COMPANY_CACHE_NAME, configuration);
		}
		
		if(!container.cacheExists(COUNTRY_CACHE_NAME)) {
			container.createCache(COUNTRY_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(LOCATION_CACHE_NAME)) {
			container.createCache(LOCATION_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(PRODUCT_CACHE_NAME)) {
			container.createCache(PRODUCT_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(PRODUCT_MAPPING_CACHE_NAME)) {
			container.createCache(PRODUCT_MAPPING_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(PO_STATUS_CACHE_NAME)) {
			container.createCache(PO_STATUS_CACHE_NAME, configuration);
		}
		if(!container.cacheExists(NOTIFICATION_ALERT_CONFIGS_CACHE_NAME)) {
			container.createCache(NOTIFICATION_ALERT_CONFIGS_CACHE_NAME, configuration);
		}
		
		Set<String> caches = container.getCacheNames();
		for (String cache : caches) {
			logger.info("cache........................."+ cache);
		}
		
		EmbeddedCacheManager cacheManager = container.startCaches(
				COMMON_CACHE_NAME, LOOKUP_CACHE_NAME, TOKEN_CACHE_NAME,
				COMPANY_CACHE_NAME, VENDOR_CACHE_NAME, ALL_COMPANY_CACHE_NAME,
				COUNTRY_CACHE_NAME, LOCATION_CACHE_NAME, PRODUCT_CACHE_NAME,
				PRODUCT_MAPPING_CACHE_NAME, PO_STATUS_CACHE_NAME,
				NOTIFICATION_ALERT_CONFIGS_CACHE_NAME);
		
		return new SpringEmbeddedCacheManager(cacheManager);
	}
}
