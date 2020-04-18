package com.concurrentDemo;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) {
		fun();
	}

	private static void fun() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		//±‡–¥futuretask¿‡
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				long b = new Date().getTime();
				System.out.println("call begin"+b);
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<100000;i++){
					sb.append(i).append(",");
				}
				System.out.println("call end "+(new Date().getTime() - b));
				return sb.toString();
			}
		});
		
		executor.execute(task);
		
		long begin = new Date().getTime();
		System.out.println("begin"+begin);
		try {
			task.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("end "+(new Date().getTime() - begin));
		
		begin = new Date().getTime();  
        System.out.println("begin" + begin);  
        try {  
            task.get();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
        System.out.println("end  " + (new Date().getTime() - begin));
        
        executor.shutdown();
		
	}
}
