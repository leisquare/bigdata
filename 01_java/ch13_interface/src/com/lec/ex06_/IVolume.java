package com.lec.ex06_;

public interface IVolume { // 필요한 상수 선언
	public void volumeUP();

	public void volumeUP(int level);

	public void volumeDown();

	public void volumeDown(int level);
}

//맥스 미니멈 볼륨을 여기서 선언해도 좋다. 만약 라디오/티비에서 선언한다면 private 을 쓰는게 좋을듯.