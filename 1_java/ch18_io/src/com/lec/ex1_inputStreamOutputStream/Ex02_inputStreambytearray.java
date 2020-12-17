package com.lec.ex1_inputStreamOutputStream;

import java.io.*;

public class Ex02_inputStreambytearray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/txt1");
			byte[] bs = new byte[10];
			while(true) {
				int readByteCount = is.read(bs); //이렇게 해야 10바이트씩 읽는다.
				if(readByteCount == -1)break;
				for(int i = 0 ; i<readByteCount ; i++) {
					System.out.println((char)bs[i]);
				}
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
