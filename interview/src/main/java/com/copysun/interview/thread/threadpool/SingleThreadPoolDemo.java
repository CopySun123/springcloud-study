package com.copysun.interview.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author copysun
 * @Date: Create in 13:36 2022/7/22
 * @Desc SingleThreadPool
 * 创建的是单线程化的线程池，只会用唯一一个工作线程执行任务，可以指定按照是否是先入先出，还是优先级来执行任务。
 * 同样使用无界队列，核心线程数和最大线程数都是1个，同样keepAliveTime为0，可选择是否使用默认线程工厂。
 */
public class SingleThreadPoolDemo {
	public static void main(String[] args) {
		test1();
	}

	public static void test1(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//循环创建10个线程
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				executorService.submit(()->{
					//模拟业务处理
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					System.out.println("使用 newSingleThreadPool-->创建线程："+Thread.currentThread().getName());
				});
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
