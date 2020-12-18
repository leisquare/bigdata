package com.lec.ex03_writerReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("txtFile/txt3.txt");
		//	char[] st = {};
			String str = "안녕하세요 \r\n 자바를 공부하는 중입니다.";
		//	char[] st = str.toCharArray(); //스트링을 char배열로,.
			writer.write(str);
					
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer!=null) writer.close();
			}catch(Exception ignire) {
			}
		}
	}
}
