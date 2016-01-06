package com.lykos.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多个子线程处理结果后 返回主线程做处理
 * @author Administrator  Lykos
 * 
 */
public class MultiThreadTest {
	public static void main(String[] args) throws ExecutionException,
			InterruptedException {
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建两个有返回值的任务
		Callable c1 = new MyCallable("1");
		Callable c2 = new MyCallable("2");
		Callable c3 = new MyCallable("2");
		// 执行任务并获取Future对象
		Future f1 = pool.submit(c1);//提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future
		Future f2 = pool.submit(c2);//启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
		// 从Future对象上获取任务的返回值，并输出到控制台

		pool.shutdown();//启动一次顺序关闭，执行以前提交的任务，但不接受新任务。

		while (!pool.isTerminated()) {// 如果关闭后所有任务都已完成，则返回 true。
		}
		System.out.println("Finished all threads");
		System.out.println(">>>" + (Long)f1.get());
		System.out.println(">>>" + f2.get().toString());
	}
}

class MyCallable implements Callable {
	private String oid;

	MyCallable(String oid) {
		this.oid = oid;
	}

	@Override
	public Long call() throws Exception {
		return Long.parseLong(oid );
	}
	
	

}
