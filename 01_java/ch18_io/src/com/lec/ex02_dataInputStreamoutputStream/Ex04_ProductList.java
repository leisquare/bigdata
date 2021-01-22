package com.lec.ex02_dataInputStreamoutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class Ex04_ProductList {
		public static void main(String[] args) {
			ArrayList<Product> products = new ArrayList<Product>();
			InputStream fis = null; //파일인풋트스팅
			DataInputStream dis = null;
			try {
				fis = new FileInputStream("E:\\kim_jiwon\\src\\1_java\\ch18_io\\txtFile\\product.dat");
				dis = new DataInputStream(fis);
				while(true) {
					String name = dis.readUTF();
					int price = dis.readInt();
					int ps = dis.readInt();
					products.add(new Product(name, price, ps));
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (IOException e) {
				System.out.println("목록을 출력합니다.");
			}finally {
				try {
					if(dis!=null) dis.close();
					if(fis!=null) fis.close();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			System.out.println("물건명 \t가격 \t재고 수");
			
			for (Product product : products) {
				System.out.println(product);
			}
//				System.out.println(name+"\t"+product+"\t"+ps);
		}
	}
	
	

