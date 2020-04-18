package com.lovin.soa.invoke;

/** 
 * @Description 返回String，用json的方式进行通信 
 * @ClassName   Invoke 
 * @Date        2018年08月04日 下午7:23:19 
 * @Author      lovin 
 */
public interface Invoke {

	public String invoke(Invocation invocation) throws Exception;
}
