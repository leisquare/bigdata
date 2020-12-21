package com.lec.ex01_runnable;

public class TargetEx01 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("안녕하세요" + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			} // (0.5초 휴식)
		}

	}

}
