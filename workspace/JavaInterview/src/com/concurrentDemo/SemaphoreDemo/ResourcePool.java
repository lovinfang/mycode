package com.concurrentDemo.SemaphoreDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 资源池类
 * @author fangyw
 *
 */
public class ResourcePool {

	//资源数目
	private static final int RESOURCE_SIZE = 10;
	//构建资源集合
	private List<Resource> resources = new ArrayList<Resource>(){{
		for(int i=0;i<RESOURCE_SIZE;i++){
			add(new Resource("资源"+i));
		}
	}};
	//控制资源范围的信号量，最多只能提供 RESOURCE_SIZE 个资源被访问
	private Semaphore semaphore = new Semaphore(RESOURCE_SIZE);
	
	/**
	 * 获取资源
	 * @return
	 * @throws InterruptedException
	 */
	public Resource fetchResource() throws InterruptedException{
		//获取访问资源的许可
		semaphore.acquire();
		Resource rs = null;
		for(Resource resource : resources){
			if(!resource.isBusy()){
				//返回一个空闲资源
				rs = resource;
				//设置资源状态 
				rs.setBusy(true);
				System.out.println("资源池分配"+rs.getResourceName());
				break;
			}
		}
		return rs;
	}
	
	public void releaseResource(Resource resource){
		//设置资源状态 
		resource.setBusy(false);
		System.out.println("资源池回收"+resource.getResourceName());
		//释放一个资源许可
		semaphore.release();
	}
}
