package com.concurrentDemo.SemaphoreDemo;

/**
 * ��Դ��
 * @author fangyw
 *
 */
public class Resource {

	//��Դ����
	private String resourceName;
	//��Դ״̬���ж���Դ�Ƿ�ռ��
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
