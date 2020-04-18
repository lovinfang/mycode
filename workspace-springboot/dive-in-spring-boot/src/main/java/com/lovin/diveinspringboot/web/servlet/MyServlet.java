package com.lovin.diveinspringboot.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * asyncSupported:是否支持异步非阻塞方式，默认是false，如果不修改成yes 异步方式抛出如下错误
 * It is illegal to call this method if the current request is not in asynchronous mode
 */
@WebServlet(urlPatterns = "/my/servlet",asyncSupported = true)
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /** 同步方式 */
        /*resp.getWriter().println("Hello,world,servlet");*/

        /**
         * 异步非阻塞方式
         */

        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(()->{
            try {
                resp.getWriter().println("Hello,world,servlet");
                //触发完成   如果不添加asyncContext.complete，则会抛出超时异常，并且不能写在外面
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//        asyncContext.complete();
    }
}
