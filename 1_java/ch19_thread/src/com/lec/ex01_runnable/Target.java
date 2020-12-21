package com.lec.ex01_runnable;

public class Target implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread Target");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "의 i =" + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}

		}

	}

}
