package com.nio.demo.nio.demo_4;

/**
 * 
 * @author lovin
 * @createTime 2018年10月8日 下午4:50:27
 * 
 */
public class TimeServer {

	public static void main(String[] args) {
		int port=8080; //服务端默认端口
		MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}
}

