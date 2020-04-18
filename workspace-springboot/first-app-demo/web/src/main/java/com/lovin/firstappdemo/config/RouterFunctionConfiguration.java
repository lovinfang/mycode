package com.lovin.firstappdemo.config;

import com.lovin.firstappdemo.domain.User;
import com.lovin.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *  请求接口:ServletRequest 或者 HttpServletRequest
     *  响应接口:ServletResponse 或者 HttpServletResponse
     *  Spring5.0 重新定义了服务请求和响应接口
     *  请求接口:ServletRequest
     *  响应接口:ServletResponse
     *  即可支持Servlet规范，也可以支持自定义，比如 Netty(Web Server)
     *  以本例
     *  定义Get请求，并且返回所有的用户对象URI: /person/fina/all
     *  Flux 是 0 - N 个对象集合
     *  Mono 是 0 - 1 个对象集合
     *  Reactive 中的Flux 或者 Mono 它是异步处理(非阻塞)
     *  集合对象基本上是同步处理(阻塞)
     *  Flux 或者 Mono 都是 Publisher
     *
     *  http://localhost:8080//person/find/all  异步获取结果
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                serverRequest -> {
                    //返回所有的用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
