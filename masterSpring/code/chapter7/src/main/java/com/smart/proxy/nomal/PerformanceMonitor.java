package com.smart.proxy.nomal;

public class PerformanceMonitor {
    //通过一个ThreadLocal保存与调用线程相关的性能监视信息
    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();

    //启动对某一目标方法的性能监视
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformace mp = new MethodPerformace(method);
        performaceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformace mp = performaceRecord.get();
        //打印出方法性能监视的结果信息
        mp.printPerformace();
    }
}
