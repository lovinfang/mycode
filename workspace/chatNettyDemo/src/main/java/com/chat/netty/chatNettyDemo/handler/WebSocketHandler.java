package com.chat.netty.chatNettyDemo.handler;


import com.chat.netty.chatNettyDemo.processor.MessageProcessor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * 
 * @author lovin
 * @createTime 2018年10月9日 下午10:27:57
 * 
 */
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	private MessageProcessor processor = new MessageProcessor();
	
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		//服务端与客户端的WebSocket交互
		processor.messageHandler(ctx.channel(), msg.text());
	}

	//客户端连接断开事件
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		processor.logout(ctx.channel());
	}

}
