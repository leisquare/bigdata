package com.lec.ex03_point;

public class Point3D extends Point {

	private int z;	
	public void point3DPrint() {
		System.out.println("3차원 좌표: "+getX() +","+getY()+","+z);
	}
	public String point3dInfoString(){
		return "3차원 좌표: "+getX()+","+getY()+","+z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	

	
	
}
