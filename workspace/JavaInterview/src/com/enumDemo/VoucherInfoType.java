package com.enumDemo;

public enum VoucherInfoType {

	TRADE,SIMPLE_ORDER,PAYMENT,REFUND,CONTROL;
	
	private final String code = "";
	private final String message = "";
	
	public static VoucherInfoType getByCode(String code){
		if(null == code || "".equals(code)){
			return null;
		}
		
		for(VoucherInfoType type :values()){
			if(type.getCode().equalsIgnoreCase(code)){
				return type;
			}
		}
		
		return null;
	}
	
	
	public String getCode(){
		return code;
	}
	
	public String getMessage(){
		return message;
	}
}
