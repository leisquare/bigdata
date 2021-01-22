package com.lec.ex01_runnable;

public class TargetEx02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("반갑습니다" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}

	}

}
