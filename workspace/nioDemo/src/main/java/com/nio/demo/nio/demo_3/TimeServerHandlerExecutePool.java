package com.nio.demo.nio.demo_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author lovin
 * @createTime 2018年10月8日 下午4:10:06
 * 
 */
public class TimeServerHandlerExecutePool {

	private ExecutorService executor;
	
	public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120l, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
	}

	public void execute(Runnable task) {
		executor.execute(task);
	}

}
