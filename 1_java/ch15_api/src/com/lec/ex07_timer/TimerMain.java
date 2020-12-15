package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); //true: 프로그램 종료되면 timer 종료
		TimerTask task1 = new TimerTaskEx1(); //작업정의객체
		TimerTask task2 = new TimerTaskEx2();//작업정의객체
		timer.schedule(task1,2000); //2초 후에 한번 실행
		timer.schedule(task2,1000,1000); //1초 후부터 1초마다 실행
		Thread.sleep(10000); //10초 대기ㅜ중
		System.out.println("끝");
	}
}
