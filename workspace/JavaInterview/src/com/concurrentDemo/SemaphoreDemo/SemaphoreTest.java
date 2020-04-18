package com.concurrentDemo.SemaphoreDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest {

	public static void main(String[] args) {
		//�����̳߳�
		ExecutorService executorService = Executors.newCachedThreadPool();
		ResourcePool pool = new ResourcePool();
		for(int i=0;i<=300;i++){
			executorService.submit(new Consumer("������"+i, pool));
		}
		executorService.shutdown();
	}
}
