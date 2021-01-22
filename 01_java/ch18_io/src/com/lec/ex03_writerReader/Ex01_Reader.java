package com.lec.ex03_writerReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {

			reader = new FileReader("txtFile/txt2");
			while (true) {
				int i = reader.read();
				if(i==-1) break;
				System.out.print((char)i);
			}

			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(reader!=null) reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
