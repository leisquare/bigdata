package com.lec.superExerd;

public class Super_Dto {
	private int cid;
	private String cTel;
	private String cName;
	private int cPoint;
	private int cAmount;
	private int levelNo;
	private String levelNames;
	private int low;
	private int high;
	private int forLevelup;

	public Super_Dto(int cid, String cTel, String cName, int cPoint, int cAmount, String levelNames,int forLevelup) {
		super();
		this.cid = cid;
		this.cTel = cTel;
		this.cName = cName;
		this.cPoint = cPoint;
		this.cAmount = cAmount;
		this.levelNames = levelNames;
		this.forLevelup = forLevelup;
	}

	@Override
	public String toString() {
		return cid + "\t" + cTel + "\t" + cName + "\t" + cPoint + "\t" + cAmount + "\t" + levelNames + "\t" + forLevelup;
	}

	public int getCid() {
		return cid;
	}

	public String getcTel() {
		return cTel;
	}

	public String getcName() {
		return cName;
	}

	public int getcPoint() {
		return cPoint;
	}

	public int getcAmount() {
		return cAmount;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public String getLevelname() {
		return levelNames;
	}

	public int getLow() {
		return low;
	}

	public int getHigh() {
		return high;
	}

	public int getForLevelup() {
		return forLevelup;
	}

}
