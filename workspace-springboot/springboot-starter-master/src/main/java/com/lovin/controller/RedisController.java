package com.lovin.controller;

import com.lovin.pojo.JSONResult;
import com.lovin.pojo.SysUser;
import com.lovin.pojo.User;
import com.lovin.utils.JsonUtils;
import com.lovin.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JSONResult test() {
        //数据默认存储在redis 第1 个数据库中   select 1 然后查看

        redisTemplate.opsForValue().set("redis-cache", "hello lovinfang~~~~~~");

        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("lovinfang");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        redisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        System.out.println("----:"+redisTemplate.opsForValue().get("redis-cache"));

        SysUser jsonUser = JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("json:user"), SysUser.class);

        return JSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public JSONResult getJsonList() {

        User user = new User();
        user.setAge(18);
        user.setName("方亚文");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("lovinfang");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello lovinfang");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JSONResult.ok(userListBorn);
    }
}
