package com.concurrentDemo.SemaphoreDemo;

/**
 * 资源类
 * @author fangyw
 *
 */
public class Resource {

	//资源名称
	private String resourceName;
	//资源状态，判断资源是否被占用
	private boolean busy;
	
	public Resource(String resourceName) {  
        super();  
        this.resourceName = resourceName;  
    }  
  
    public String getResourceName() {  
        return resourceName;  
    }  
  
    public boolean isBusy() {  
        return busy;  
    }  
  
    public void setBusy(boolean busy) {  
        this.busy = busy;  
    }  
}
