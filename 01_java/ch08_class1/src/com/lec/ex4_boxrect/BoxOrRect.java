package com.lec.ex4_boxrect;

/* 클래스
 * 데이터(속성)
 * -width:int
 * -height:int
 * -depth:int
 * -volume:int
 * 메소드(기능)
 * -3차원 부피계산, volume 세팅
 * -2차원 넓이계산, volume 세팅
 */
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;
//생성자
	public BoxOrRect() {
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
	}

//메서드
	public void calNsetVolume() {
		if(depth!=0) {
			volume = width*height*depth;
		}else {
			volume = width*height;
		}
	}
	
//겟셋
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}

}