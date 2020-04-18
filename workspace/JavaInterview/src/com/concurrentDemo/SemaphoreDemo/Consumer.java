package com.concurrentDemo.SemaphoreDemo;

public class Consumer implements Runnable{

	//����������
	private String consumerName;
	
	//��Դ��
	private ResourcePool pool;
	
	public Consumer(String consumerName,ResourcePool pool){
		this.consumerName = consumerName;
		this.pool = pool;
		System.out.println("������:"+consumerName);
	}
	
	public void consumeResourceFromPool(){
		//����Դ���л�ȡ��Դ
		try {
			Resource rs = pool.fetchResource();
			if(rs != null){
				//ʹ����Դ
				System.out.println(consumerName+"����ʹ��"+rs.getResourceName());
				Thread.sleep(5000);
				//ʹ����ϣ��ͷ���Դ
				System.out.println(consumerName+"ʹ��"+rs.getResourceName()+"���");
				pool.releaseResource(rs);
			}else{
				System.out.println(consumerName+"�޷�����κ���Դ!");
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
