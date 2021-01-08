package com.lec.student;

public class StudentDto {
	private int rank;
	private String sno;
	private String sname;
	private int mno;
	private int score;
	private int sexpel;
	private String mname;

	// insert용
	public StudentDto(String sno, String sname, int mno, int score, int sexpel) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.mno = mno;
		this.score = score;
		this.sexpel = sexpel;
	}

	// select용


	public StudentDto(int rank, String sname, int score, String mname) {
		this.rank = rank;
		this.sname = sname;
		this.score = score;
		this.mname = mname;
	}

	@Override
	public String toString() {
		return rank+"등" + "\t" + sname + "\t" + mname + "\t" + score;
	}

	public String getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public int getMno() {
		return mno;
	}

	public int getScore() {
		return score;
	}

	public int getSexpel() {
		return sexpel;
	}

	public String getMname() {
		return mname;
	}

}
