package com.lovin.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动springboot必须有SpringBootApplication这个注解
 */
@SpringBootApplication
public class GirlApplication {

    /**
     * 1、第一种启动方式是执行此程序
     * 2、第二种启动方式是在cmd中进入到pom.xml目录   mvn spring-boot:run
     * 3、第三种启动方式是先 mvn install进行打包  然后 D:\workspace-springboot\target>java -jar girl-0.0.1-SNAPSHOT.jar
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
