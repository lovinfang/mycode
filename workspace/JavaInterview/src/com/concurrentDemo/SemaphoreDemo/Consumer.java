package com.concurrentDemo.SemaphoreDemo;

public class Consumer implements Runnable{

	//消费者名称
	private String consumerName;
	
	//资源池
	private ResourcePool pool;
	
	public Consumer(String consumerName,ResourcePool pool){
		this.consumerName = consumerName;
		this.pool = pool;
		System.out.println("创建了:"+consumerName);
	}
	
	public void consumeResourceFromPool(){
		//从资源池中获取资源
		try {
			Resource rs = pool.fetchResource();
			if(rs != null){
				//使用资源
				System.out.println(consumerName+"正在使用"+rs.getResourceName());
				Thread.sleep(5000);
				//使用完毕，释放资源
				System.out.println(consumerName+"使用"+rs.getResourceName()+"完毕");
				pool.releaseResource(rs);
			}else{
				System.out.println(consumerName+"无法获得任何资源!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumeResourceFromPool();
	}

}
