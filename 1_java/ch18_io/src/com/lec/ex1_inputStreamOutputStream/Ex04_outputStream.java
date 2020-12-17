package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/out1.txt"); // 1. 스트링객체생성. true 추가시 파일에 append, 없으면 덮어씀.
			String str = "모두 다 안녕이 필요한 시국\r\r";
			byte[] bs = str.getBytes(); // 스트링을 바이트배열로
			os.write(bs);
		} catch (FileNotFoundException e) {
			System.out.println("파일못찾음" + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일쓰기오류" + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception ignore) {
			}

		}

	}
}
