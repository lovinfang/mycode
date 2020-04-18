package com.lovin.soa.proxy.advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.lovin.soa.cluster.Cluster;
import com.lovin.soa.configBean.Reference;
import com.lovin.soa.invoke.Invocation;
import com.lovin.soa.invoke.Invoke;

/** 
 * @Description InvokeInvocationHandler 这个是一个advice，在这个advice里面就进行了rpc的远程调用
 * rpc类型有：http、rmi、netty
 *  
 * @ClassName   InvokeInvocationHandler 
 * @Date        2018年08月04日 下午07:09:51 
 * @Author      lovin 
 */
public class InvokeInvocationHandler implements InvocationHandler{
	
	private Invoke invoke;
	
	private Reference reference;
	
	public InvokeInvocationHandler(Invoke invoke, Reference reference) {
		super();
		this.invoke = invoke;
		this.reference = reference;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//在这个invoke里面最终要调用多个远程的provider
        System.out.print("已经获取到了代理实例，已经调到了InvokeInvocationHandler.invoke");
        Invocation invocation = new Invocation();
        invocation.setMethod(method);
        invocation.setObjs(args);
        invocation.setReference(reference);
        invocation.setInvoke(invoke);
        Cluster cluster = reference.getClusters().get(reference.getCluster());
        String result = invoke.invoke(invocation);
        return result;
	}

}
