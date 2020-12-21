package com.lec.ex03_threadN_object1;
//쓰레드 N개가 작업개체 1개를 공유 - runnable을 반드시 이용 
public class ThreadEx implements Runnable {
	private int num=0;
	
	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			String threadName = Thread.currentThread().getName();
			if(threadName.equals("A")) {
				System.out.println("A수행중");
				num ++;
			}
			System.out.println(threadName + "의 num = "+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}

	}

}
