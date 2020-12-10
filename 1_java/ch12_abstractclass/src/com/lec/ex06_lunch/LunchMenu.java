package com.lec.ex06_lunch;

public abstract class LunchMenu {
	

	private int rice; //쌀값(1인)
	private int bulgogi;
	private int soup;
	private int banana;
	private int milk;
	private int almond;
	
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super();
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.milk = milk;
		this.almond = almond;
	}
	
	//식대 계산하는 메소드는 추상메소드로.
	public abstract int calculate ();
	
	
	
	//겟셋
	
	public int getRice() {
		return rice;
	}

	public int getBulgogi() {
		return bulgogi;
	}

	public int getSoup() {
		return soup;
	}

	public int getBanana() {
		return banana;
	}

	public int getMilk() {
		return milk;
	}

	public int getAlmond() {
		return almond;
	}


	
	
	
}
