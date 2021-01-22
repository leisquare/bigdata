package com.lec.ex02_dataInputStreamoutputStream;

import java.io.*;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null; //파일인풋트스팅
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\dataFile.dat");
			dis = new DataInputStream(fis);
			String name = dis.readUTF();
			int grade = dis.readInt();
			double score = dis.readDouble();
			System.out.println("파일로부터 입력받은 값은 "+name+"\t"+grade+"\t"+score);
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
