package com.lec.ex02_map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import com.lec.ex01_list.Customer;
public class Ex03_CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Customer> customers 
								= new HashMap<String, Customer>();
		while(true){
			System.out.print("회원가입을 진행하시겠습니까(Y/N)?");
			answer = scanner.nextLine().trim();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")) { 
				System.out.print("가입할 회원의 이름은 ?");
				name = scanner.nextLine();
				System.out.print("가입할 회원의 폰번호는 ?");
				phone = scanner.nextLine();
				System.out.print("가입할 회원의 주소는 ?");
				address = scanner.nextLine();
				customers.put(phone, new Customer(name,phone,address));
			}
		}
		scanner.close();
		if(customers.isEmpty()) {
			System.out.println("가입한 회원이 없습니다");
		}else {
			System.out.println("가입한 회원 리스트 목록");
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}//while
		}//if
	}//main
}//class