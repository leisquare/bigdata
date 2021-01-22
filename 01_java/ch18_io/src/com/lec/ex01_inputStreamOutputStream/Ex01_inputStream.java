package com.lec.ex01_inputStreamOutputStream;
//1. 파일을 연다(Stream 객체 생성) 2. 데이터를 읽는다.(1or 2byte) 3. 파일을 닫는다.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex01_inputStream {

	public static void main(String[] args) {

		InputStream is = null;

		try {
			is = new FileInputStream("txtFile/txt1"); // 1단계
			// 2. 데이터 읽기(1byte단위로 반복)
			while (true) {
				int i = is.read();// 1byte 읽기
				if (i == -1)
					break;
//				System.out.println((char)i +"-아스키코드: "+i);
				System.out.print((char) i);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// 3. 파일 닫기
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
			}

		}

	}

}
