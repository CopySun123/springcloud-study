package com.copysun.interview.thread.sequence;

/**
 * @Author copysun
 * @Date: Create in 10:05 2022/7/28
 * @Desc 主线程中使用join()来实现对线程的阻塞.
 */
public class Demo3 {

	private static final Object lock1=new Object();
	private static final Object lock2=new Object();

	private static Boolean t1Run=false;
	private static final Boolean t2Run=false;



	public static void main(String[] args) throws InterruptedException {

		Thread t1=new Thread(()->{
			synchronized (lock1){
				System.out.println("1、产品经理规划新需求");
				t1Run=true;
				lock1.notify();
			}

		});

		Thread t2=new Thread(()->{
			synchronized (lock1){
				if(!t1Run){
					System.out.println("开发人员先休息会…");
					try {
						lock1.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
			synchronized (lock2){
				System.out.println("2、开发人员开发新需求功能");
				lock2.notify();
			}
		});

		Thread t3=new Thread(()->{
			synchronized (lock2){
				if(!t2Run){
					System.out.println("测试人员先休息会…");
					try {
						lock2.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				System.out.println("3、测试人员测试新功能");
			}
		});
		System.out.println("早上上班:");
		t3.start();
		t1.start();
		t2.start();
	}
}
