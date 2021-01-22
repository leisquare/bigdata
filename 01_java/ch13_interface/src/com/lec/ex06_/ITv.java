package com.lec.ex06_;

public class ITv implements IVolume {
	private int TvVolume = 20;

	@Override
	public void volumeUP() {
		TvVolume += 2;
		if (TvVolume <= 50) {
			System.out.println("볼륨을 2 올려 볼륨이 현재 " + TvVolume);
		} else if ((TvVolume) > 50) {
			TvVolume = 50;
			System.out.println("볼륨이 현재 최대. 현재" + TvVolume);
		}
	}

	@Override
	public void volumeUP(int level) {
		TvVolume += level;
		if (TvVolume <= 50) {
			System.out.println("볼륨을 " + level + "올려 볼륨이 현재 " + TvVolume);
		} else if ((TvVolume) > 50) {
			TvVolume = 50;
			System.out.println("볼륨이 현재 최대. 현재" + TvVolume);
		}
	}

	@Override
	public void volumeDown() {
		if ((TvVolume -= 2) >= 0) {
			TvVolume -= 2;
		}
	}

	@Override
	public void volumeDown(int level) {
		if ((TvVolume -= level) >= 0) {
			TvVolume -= level;
		}
	}

}
