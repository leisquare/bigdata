package com.lec.ex02_dataInputStreamoutputStream;

import java.io.*;

public class Ex01_dataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;

		try {// 보조스트림은 기본스트림을 통해서만 생성.
			fos = new FileOutputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("홍길동"); // 스트링저장
			dos.writeInt(2); // int값 저장
			dos.writeDouble(95.9); // int값 저장
			System.out.println("저장완료");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println();
			}
		}
	}
}
