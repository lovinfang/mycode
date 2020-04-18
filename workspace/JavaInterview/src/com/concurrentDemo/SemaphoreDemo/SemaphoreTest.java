package com.concurrentDemo.SemaphoreDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest {

	public static void main(String[] args) {
		//创建线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		ResourcePool pool = new ResourcePool();
		for(int i=0;i<=300;i++){
			executorService.submit(new Consumer("消费者"+i, pool));
		}
		executorService.shutdown();
	}
}
