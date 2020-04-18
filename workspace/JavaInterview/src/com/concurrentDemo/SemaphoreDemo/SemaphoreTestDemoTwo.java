package com.concurrentDemo.SemaphoreDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTestDemoTwo {

	public static void main(String[] args) {
		//�����̳߳�
		ExecutorService exec = Executors.newCachedThreadPool();
		//ֻ��5���߳�ͬʱ����
		final Semaphore semp = new Semaphore(5);
		//ģ��20���ͻ��˷���
		for(int i = 0;i<20;i++){
			final int NO = i;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						//��ȡ���
						semp.acquire();
						System.out.println("Accessing:"+NO);
						Thread.sleep((long)(Math.random()*10000));
						//��������ͷ�
						semp.release();
						System.out.println("--------------"+semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		//�˳��̳߳�
		exec.shutdown();
	}
}
