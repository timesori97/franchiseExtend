package main;

import java.util.ArrayList;
import java.util.Scanner;

import Super.Super;
import store.Chicken;


public class Admin {
	Chicken c = new Chicken();
	Scanner in = new Scanner(System.in);

	Admin() {
		boolean f = true;
		while (f) {

			System.out.println("1.치킨 등록 2.치킨 조회 3.치킨 삭제 4.치킨 수정");
			String selectnum = in.nextLine();

			switch (selectnum) {
			case "1":
				c.add();
				break;
			case "2":
				c.select();
				break;
			case "3":
				c.delete();
				break;
			case "4":
				c.update();
				break;
			default:
				System.out.println("이전 메뉴로 돌아갑니다");
				f = false;
				break;
			}
		}
	}

}
