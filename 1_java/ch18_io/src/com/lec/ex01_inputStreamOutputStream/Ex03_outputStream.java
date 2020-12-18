package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;

		try {
			os = new FileOutputStream("txtFile/out.txt");// 1. 파일열기(스트링 객체 생성)
			byte[] bs = { 'h', 'e', 'l', 'l', 'o', '\r', '\n', 'j', 'a', 'v', 'a' };
			for (int i = 0; i < bs.length; i++) {
				os.write(bs[i]); // 2. 파일에 데이터 쓰기(반복)
			}
			System.out.println("성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		
	}
}
