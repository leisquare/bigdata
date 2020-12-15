package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("*****작업 1: 2초 후에 한번 예정");
	}

}
