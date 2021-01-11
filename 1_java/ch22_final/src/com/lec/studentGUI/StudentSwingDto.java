package com.lec.studentGUI;

public class StudentSwingDto {

	private int Rank;
	private String sNo;
	private String sName;
	private int mNo;
	private int score;
	private int sExpel;
	private String mName;
	
	
	
	
	//insert용
	public StudentSwingDto(int rank, String sNo, String sName, int mNo, int score, int sExpel) {
		this.Rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mNo = mNo;
		this.score = score;
	}

	public StudentSwingDto(int rank, String sName, String mName, int score) {
		this.Rank = rank;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}	
	
	public StudentSwingDto(String sNo, String sName, String mName, int score) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.score = score;
		this.mName = mName;
	}

	

	@Override
	public String toString() {
		if(Rank !=0) {
			return Rank+"등" + "\t" + sName + "\t" + mName + "\t" + score;
		} else {
			return sNo+"\t"+sName+"\t"+mName+"\t"+score;
		}
	}

	
	
	
	public int getRank() {
		return Rank;
	}

	public String getsNo() {
		return sNo;
	}

	public String getsName() {
		return sName;
	}

	public int getmNo() {
		return mNo;
	}

	public int getScore() {
		return score;
	}

	public int getsExpel() {
		return sExpel;
	}

	public String getmName() {
		return mName;
	}
	
	
	
	
	
	
}
