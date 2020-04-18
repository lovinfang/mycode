package com.chat.netty.chatNettyDemo.protocol;
/**
 * 
 * @author lovin
 * @createTime 2018年10月9日 下午10:27:57
 * 
 */
public class MessageStatus {

	public static final String LOGIN="LOGIN";
	public static final String LOGOUT="LOGOUT";
	public static final String CHAT="CHAT";
	public static final String SYSTEM="SYSTEM";
	
	public static boolean isSFP(String msg){
		return msg.matches("^\\[(SYSTEM|LOGIN|LOGOUT|CHAT)\\]");
	}
}
