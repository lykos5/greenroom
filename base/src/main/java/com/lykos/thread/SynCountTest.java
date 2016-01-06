package com.lykos.thread;
/**
 * 线程计数器的使用
 * Lykos
 */
import java.util.concurrent.CountDownLatch;

public class SynCountTest{
	public static void main(String[] args) {
		try{
			int count = 1000;
			//线程计数器
			CountDownLatch countdownlatch = new CountDownLatch(count);
			for(int i=0;i<count-1;i++){
				Player p = new Player("线程："+i,countdownlatch);
				p.start();
			}
			System.out.println("主线程等待前");
			countdownlatch.await();//主线程等待
			System.out.println("主线程执行完毕");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


class Player extends Thread{
	private String name;
	private CountDownLatch countDownLatch;
	public Player(String name,CountDownLatch countDownLatch){
		this.name = name;
		this.countDownLatch = countDownLatch;
	}
	@Override
	public void run(){
		try{
			System.out.println("这是线程："+name+"开始");
			Thread.sleep(1000*10);
			System.out.println("这是线程："+name+"结束");
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//订数器减一
			countDownLatch.countDown();
		}
	}
}
