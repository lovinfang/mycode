package com.concurrentDemo.SemaphoreDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * ��Դ����
 * @author fangyw
 *
 */
public class ResourcePool {

	//��Դ��Ŀ
	private static final int RESOURCE_SIZE = 10;
	//������Դ����
	private List<Resource> resources = new ArrayList<Resource>(){{
		for(int i=0;i<RESOURCE_SIZE;i++){
			add(new Resource("��Դ"+i));
		}
	}};
	//������Դ��Χ���ź��������ֻ���ṩ RESOURCE_SIZE ����Դ������
	private Semaphore semaphore = new Semaphore(RESOURCE_SIZE);
	
	/**
	 * ��ȡ��Դ
	 * @return
	 * @throws InterruptedException
	 */
	public Resource fetchResource() throws InterruptedException{
		//��ȡ������Դ�����
		semaphore.acquire();
		Resource rs = null;
		for(Resource resource : resources){
			if(!resource.isBusy()){
				//����һ��������Դ
				rs = resource;
				//������Դ״̬ 
				rs.setBusy(true);
				System.out.println("��Դ�ط���"+rs.getResourceName());
				break;
			}
		}
		return rs;
	}
	
	public void releaseResource(Resource resource){
		//������Դ״̬ 
		resource.setBusy(false);
		System.out.println("��Դ�ػ���"+resource.getResourceName());
		//�ͷ�һ����Դ���
		semaphore.release();
	}
}
