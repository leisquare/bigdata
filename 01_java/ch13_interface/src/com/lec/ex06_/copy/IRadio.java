package com.lec.ex06_.copy;

public class IRadio implements IVolume {
	private int RadioVolume = 10;

	@Override
	public void volumeUP() {
		if ((RadioVolume += 1) <= 30) {
			RadioVolume += 1;
		}
	}

	@Override
	public void volumeUP(int level) {
		RadioVolume += level;
		if (RadioVolume <= 30) {
			System.out.println("볼륨을 "+level+" 올려 볼륨이 현재 "+RadioVolume);
		}else if((RadioVolume) > 30){
			RadioVolume = 30;
			System.out.println("볼륨이 현재 최대. 현재"+RadioVolume);
		}
	}

	@Override
	public void volumeDown() {
		if ((RadioVolume -= 1) >= 0) {
			RadioVolume -= 1;
		}
	}

	@Override
	public void volumeDown(int level) {
		if ((RadioVolume -= level) >= 0) {
			RadioVolume -= level;
		}
	}

	public int getRadioVolume() {
		return RadioVolume;
	}
	
}
