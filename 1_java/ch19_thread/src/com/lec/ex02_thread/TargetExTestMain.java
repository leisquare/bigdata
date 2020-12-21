package com.lec.ex02_thread;

public class TargetExTestMain {
	public static void main(String[] args) {
		// 쓰레드 생성 = target01.run()을 수행
		Thread target01 = new TargetEx01();
		// TargetEx01 target01 = new TargetEx01();
		target01.setName("A"); // 쓰레드 이름 생성
		// 쓰레드 생성 = targer02.run()을 수행
		Thread target02 = new TargetEx01();
		target02.setName("B");
		target01.start();
		target02.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("나는 main함수");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block

			}
		}
	}
}
