package com.copysun.interview.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author copysun
 * @Date: Create in 10:22 2022/7/22
 * @Desc CachedThreadPool
 * 可缓存线程池，先查看线程池中有没有之前创建的线程，如果有则直接使用。
 * 否则就新创建一个新的线程加入线程池中，我们经常用此类线程池来执行一些业务处理时间很短的任务。
 */
public class CachedThreadPoolDemo {
	public static void main(String[] args) {
		test1();
		//test2();
	}

	/**
	 * 由于业务处理事件较短，立马会用缓存中的哪一个线程继续执行
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 */
	public static void test1(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		//循环创建10个线程
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				executorService.submit(()->{
					//模拟业务处理
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					System.out.println("使用 newCachedThreadPool-->创建线程："+Thread.currentThread().getName());
				});
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-1
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-2
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-3
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-4
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-5
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-6
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-7
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-8
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-9
	 * 使用 newCachedThreadPool-->创建线程：pool-1-thread-10
	 */
	public static void test2(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		//循环创建10个线程
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				executorService.submit(()->{
					//模拟业务处理
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					System.out.println("使用 newCachedThreadPool-->创建线程："+Thread.currentThread().getName());
				});
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
