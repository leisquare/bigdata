package com.lec.ex04_buffered;

import java.io.*;

// 키보드로부터 파일이름을 받아 해당파일 출력.
public class Ex02_bufferedReaderKeyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // 그냥 싹 다 가져온다(대신 스트링으로 받아오므로 다른
																						// 형으로 받으려면 형변환 해줘야함)
		Reader reader = null;
		BufferedReader br = null;
		System.out.println("읽어올 파일 이름은?");
		try {
			String filename = keyboard.readLine();
			File file = new File(filename);
			if (file.exists()) {
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					System.out.println(line);
				}

			} else {
				System.out.println("입력하신 파일이 존재하지 않습니다.");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					;
				br.close();

			} catch (Exception e) {
				System.out.println("예외발생.");
			}
		}
	}
}
