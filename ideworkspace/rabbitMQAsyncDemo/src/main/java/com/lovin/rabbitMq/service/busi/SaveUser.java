package com.lovin.rabbitMq.service.busi;

import com.lovin.rabbitMq.vo.User;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/25
 * 创建时间: 16:19
 * 写db
 */
@Service
public class SaveUser {

    private ConcurrentHashMap<String,User> userData =
            new ConcurrentHashMap<String, User>();

    public void saveUser(User user){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userData.putIfAbsent(user.getUserId(),user);
    }

    public User getUser(String userId){
        return userData.get(userId);
    }


}
