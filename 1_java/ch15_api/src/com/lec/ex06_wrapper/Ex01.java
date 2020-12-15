package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) {
			System.out.println("i와 j는 같다.");
		}
		Integer obj1 = new Integer(10);
		Integer obj2 = new Integer(10);
		if("Hello".equals(i)) { //if("Hello".equals(new Integer(1)))과 같다.
			System.out.println("같다");
		}else {
			System.out.println("같지 않다");
		}
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 2의 데이터는 같다.");
		}
		int total = obj1.intValue()+obj2.intValue();
	}

}
