package com.lovin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan("com.lovin.mapper")
@ComponentScan(basePackages= {"com.lovin", "org.n3r.idworker"})
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class SpringbootStarterMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStarterMasterApplication.class, args);
	}
}
