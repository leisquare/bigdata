package com.lec.ex04_buffered;

import java.io.*;

public class Ex01_BufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/txt3.txt");
			br = new BufferedReader(reader);
			while(true) {
				String line = br.readLine();
				if(line ==null)break;
				System.out.println(line);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();

			} catch (Exception e) {

			}
		}
	}
}
