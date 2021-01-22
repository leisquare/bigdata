package com.lec.ex02_dataInputStreamoutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_ProductWrite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OutputStream fos = null;
		DataOutputStream dos = null;
		String key = null;

		String name;
		int price;
		int ps;

		try {// 보조스트림은 기본스트림을 통해서만 생성.

			while (true) {
				System.out.println("추가할 데이터가 있습니까? (y/x)");
				fos = new FileOutputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\product.dat",true);
				dos = new DataOutputStream(fos);
				key = sc.next();
				
				if (key.equalsIgnoreCase("y")) {
				System.out.println("상품명?");
				name = sc.next();
				dos.writeUTF(name); // 스트링저장

				System.out.println("가격?");
				price = sc.nextInt();
				dos.writeInt(price); //

				System.out.println("갯수?");
				ps = sc.nextInt();
				dos.writeInt(ps); // int값 저장

				System.out.println("저장완료. 추가할 데이터가 없으면 x를 누르시오.");
				
				}
				else if (key.equalsIgnoreCase("x")) {
					break;
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
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
