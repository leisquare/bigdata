package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//1. 스트림 객체 생성(inputStream, outputStream)
//2. 읽고쓰기(파일의 끝까지 반복)
//3. 스트림 닫기
public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null; // FileInputStream으로 해도 된다.
		OutputStream os = null;
		try {
			is = new FileInputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\leaf.jpg"); // \n, \b 등에 기능이 있기 때문에
																								// 그 부분들을 역슬래시 두개로
																								// 쳐줘야한다.
			os = new FileOutputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\leaf1.jpg");
			int cnt = 0;
			while (true) {
				++cnt;
				int i = is.read(); // 1byte 읽는거
				if (i == -1)
					break;
				os.write(i);
			}
			System.out.println(cnt);
			System.out.println("파일복사성공");
		} catch (FileNotFoundException e) {
			System.out.println("파일이나 폴더못찾음" + e.getMessage());
		} catch (IOException e) {
			System.out.println("읽고쓸때 예외발생" + e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
