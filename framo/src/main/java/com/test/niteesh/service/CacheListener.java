package com.test.niteesh.service;

//import org.infinispan.notifications.Listener;
//import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
//import org.infinispan.notifications.cachelistener.annotation.CacheEntryExpired;
//import org.infinispan.notifications.cachelistener.annotation.CacheEntryModified;
//import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
//import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
//import org.infinispan.notifications.cachelistener.event.CacheEntryExpiredEvent;
//import org.infinispan.notifications.cachelistener.event.CacheEntryModifiedEvent;
//import org.infinispan.notifications.cachelistener.event.CacheEntryRemovedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Listener(clustered = true)
public class CacheListener {

	Logger logger = LoggerFactory.getLogger(CacheListener.class.getName());
	
//   @CacheEntryCreated
//   public void entryCreated(CacheEntryCreatedEvent<String, Object> event) {
//      if (!event.isOriginLocal()) {
//    	  logger.info("CacheListener-- Entry for event.getKey(): {} entryCreated", event.getKey());
//      }
//   }
//   
//   @CacheEntryModified
//   public void entryModified(CacheEntryModifiedEvent<String, Object> event) {
//      if (!event.isOriginLocal()) {
//    	  logger.info("CacheListener-- Entry for event.getKey(): {} modified by another node in the cluster", event.getKey());
//      }
//   }
//   
//   @CacheEntryExpired
//   public void entryExpired(CacheEntryExpiredEvent<String, Object> event) {
//      if (!event.isOriginLocal()) {
//    	  logger.info("CacheListener-- Entry for event.getKey(): {} expired in the cluster", event.getKey());
//      }
//   }
//   
//   @CacheEntryRemoved
//   public void entryRemoved(CacheEntryRemovedEvent<String, Object> event) {
//      if (!event.isOriginLocal()) {
//    	  logger.info("CacheListener-- Entry for event.getKey(): {} removed by another node in the cluster", event.getKey());
//      }
//   }
}
