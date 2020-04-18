package com.lovin.soa.redis;

import redis.clients.jedis.JedisPubSub;

/** 
 * @Description redis的发布与订阅，跟我们的activemq中的topic消息消费机制差不多 如何横向添加后台服务端机器，发布订阅模式来进行注册机器
 * 是一个广播形式的消费消息 
 * @ClassName   RedisServerRegistry 
 * @Date        2018年08月11日 下午9:22:48 
 * @Author      lovin 
 */

public class RedisServerRegistry extends JedisPubSub {
    
    /* 
     * @see 当往频道其实就是队列，当往里面发布消息的时候，这个方法就会触发
     */
    @Override
    public void onMessage(String channel, String message) {
        
    }
    
    @Override
    public void subscribe(String... channels) {
        // TODO Auto-generated method stub
        super.subscribe(channels);
    }
    
}
