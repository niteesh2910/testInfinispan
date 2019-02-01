package com.test.niteesh.service;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachemanagerlistener.annotation.ViewChanged;
import org.infinispan.notifications.cachemanagerlistener.event.ViewChangedEvent;

@Listener
public class ClusterListener {
	Logger logger = Logger.getLogger(ClusterListener.class.getName());

	public CountDownLatch clusterFormedLatch = new CountDownLatch(1);
	public CountDownLatch shutdownLatch = new CountDownLatch(1);
	private final int expectedNodes;

	public ClusterListener(int expectedNodes) {
		this.expectedNodes = expectedNodes;
	}

	@ViewChanged
	public void viewChanged(ViewChangedEvent event) {
		logger.info("ClusterListener---- View changed: ----"+ event.getNewMembers());

		if (event.getCacheManager().getMembers().size() == expectedNodes) {
			clusterFormedLatch.countDown();
		} else if (event.getNewMembers().size() < event.getOldMembers().size()) {
			shutdownLatch.countDown();
		}
	}
}
