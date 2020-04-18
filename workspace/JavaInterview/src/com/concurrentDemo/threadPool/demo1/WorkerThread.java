package com.concurrentDemo.threadPool.demo1;

public class WorkerThread implements Runnable{

	private String _command;
	
	public WorkerThread(String s){
		this._command = s;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start. Command = "+_command);
		processCommand();
		System.out.println(Thread.currentThread().getName()+" End.");
	}

	private void processCommand() {
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
    public String toString(){
        return this._command;
    }
}
