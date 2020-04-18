package com.lovin.framework.service;

public class FrameworkTestServiceImpl implements FrameworkTestService{

	public String sleep(String param) {
		System.out.println("Provider->FrameworkTestServiceImpl-sleep:param:"+param);
		return "Provider->FrameworkTestServiceImpl-sleep:param:"+param;
	}

}
