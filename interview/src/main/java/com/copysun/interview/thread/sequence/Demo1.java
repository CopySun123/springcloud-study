package com.copysun.interview.thread.sequence;

/**
 * @Author copysun
 * @Date: Create in 10:05 2022/7/28
 * @Desc join是Theard的方法，作用是调用线程需等待该join()线程执行完成后，才能继续用下运行。
 */
public class Demo1 {

	public static void main(String[] args) {

		Thread t1=new Thread(()->{
			System.out.println("1、产品经理规划新需求");
		});

		Thread t2=new Thread(()->{
			try {
				t1.join();
				System.out.println("2、开发人员开发新需求功能");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		Thread t3=new Thread(()->{
			try {
				t2.join();
				System.out.println("3、测试人员测试新功能");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
		System.out.println("早上上班:");
		t1.start();
		t2.start();
		t3.start();
	}
}
