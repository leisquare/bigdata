package com.lec.ex08_decimalFormat;

import java.text.DecimalFormat;

//숫자자리에 : # 있으면 출력 없으면 출력안함 0 반드시 출력 
// , %(퍼센트 표현) E(지수형)
public class Ex02 {
	public static void main(String[] args) {
		double number = 1234567.8889;
		DecimalFormat df1 = new DecimalFormat("00000000.00000");
		System.out.println(df1.format(number));
		DecimalFormat df2 = new DecimalFormat("########.#####");
		System.out.println(df2.format(number));
		DecimalFormat df3 = new DecimalFormat("#,#.000##"); // 콤마는 하나만 있어도 반영되고 0과 샵 섞어쓸수있다.
		System.out.println(df3.format(number));
		DecimalFormat df4 = new DecimalFormat("#.##%"); // 백분율출력
		System.out.println(df4.format(number));
		DecimalFormat df5 = new DecimalFormat("#.##E00"); // 1.23E06 1.23 * 10의 6승 이라는 뜻이다.
		System.out.println(df5.format(number));
	}

}
