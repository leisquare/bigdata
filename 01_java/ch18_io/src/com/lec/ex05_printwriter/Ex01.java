package com.lec.ex05_printwriter;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		OutputStream os = null;
		Writer writer = null;
		try {
			// printWriter = new PrintWriter("txtFile/out.txt");
			// os = new FileOutputStream("txtFile/out.txt");
			// printWriter = new PrintWriter(os);

			writer = new FileWriter("txtFile/out.txt");
			printWriter = new PrintWriter(writer); // 스트림 객체생성

			System.out.println("안녕하세요 \n 반갑습니다.");
			printWriter.println("안녕하세요 \r\n 반갑습니다.");
			System.out.println("개행자동안될에정\n");
			printWriter.print("개행안될예정 \\r\\n");

			System.out.printf("%5s %3d %3d %5.1f\n", "홍길동", 99, 98, 98.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n", "홍길동", 99, 98, 98.5);
			System.out.printf("%5s %3d %3d %5.1f\n", "김길동", 100, 100, 100);
			printWriter.printf("%5s %3d %3d %5.1f\r\n", "김길동", 100, 100, 100.0);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception e) {

			}
		}
	}
}
