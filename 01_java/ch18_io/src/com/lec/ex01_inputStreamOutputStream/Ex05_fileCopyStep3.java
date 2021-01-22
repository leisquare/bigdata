package com.lec.ex01_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//1. 스트림 객체 생성(inputStream, outputStream)
//2. 읽고쓰기(파일의 끝까지 반복)
//3. 스트림 닫기
public class Ex05_fileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null; // FileInputStream으로 해도 된다.
		OutputStream os = null;
		try {
			File originalFile = new File("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\leaf.jpg");
			
			is = new FileInputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\leaf.jpg"); // \n, \b 등에 기능이 있기 때문에 그 부분들을 역슬래시 두개로 쳐줘야한다.
			os = new FileOutputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\leaf2.jpg");
			int cnt = 0;
//			int length = 0;
//			if(originalFile.length>2100000000) {
//				length = 2100000000;
//			}else {
//				length = (int) originalFile.length();
//			}  //length가 2100000000이상인 경우는 해줘야... 
			
			byte[] bs = new byte[(int)originalFile.length()]; //1kb씩 이 배열에 읽어들이는 목적
			while (true) {
				++cnt;
				int readByteCount = is.read(bs); 
				if (readByteCount == -1)
					break;
				os.write(bs,0,readByteCount); //bs배열의 0번 인덱스부터 readByteCount 바이트만큼만 파일에 쓰기. 
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
