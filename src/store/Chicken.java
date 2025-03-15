package store;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.ChickenDTO;
import Super.Super;



public class Chicken extends Super {
    private ChickenDAO chickendao = ChickenDAO.getInstance();
	
	Scanner in = new Scanner(System.in);
	
	 
	public Chicken() {
		
	}
  


	@Override
	public void add() {
		ChickenDTO cdto = new ChickenDTO();
		Super s = new Super();
		System.out.println("치킨의 종류를 쓰시오");
		String menuname = in.nextLine();
		System.out.println("치킨의 사이즈를 쓰시오");
		String csize = in.nextLine();
		System.out.println("치킨의 조리 방식을 쓰시오");
		String ccook = in.nextLine();
		System.out.println("치킨의 점수를 쓰시오");
		String cscore = in.nextLine();
		System.out.println("타입을 쓰시오");
		String type = in.nextLine();
		
		cdto.setMenuname(menuname);
		cdto.setCsize(csize);
		cdto.setCcook(ccook);
		cdto.setCscore(cscore);
		cdto.setType(type);
		
		
		chickendao.insert(cdto,s);
		
		
		super.add();
		
	}



	@Override
	public void select() {
		chickendao.select();
		
	}

	@Override
	public void delete() {
		System.out.println("삭제할 치킨 메뉴 이름을 쓰시오");
		String menuname = in.nextLine();
		
		chickendao.delete(menuname);
		super.delete();
		
	}

	@Override
	public void update() {
		ChickenDTO cdto = new ChickenDTO();
		System.out.println("수정할 치킨을 입력하시오");
		String chicken = in.nextLine();
			System.out.println("수정할 부분을 입력하시오");
			System.out.println("1.사이즈 2.조리 방식 3.치킨의 점수");
			String selectnum = in.nextLine();
			switch(selectnum) {
			case"1": 
				System.out.println("수정할 사이즈를 쓰시오");
				String csize = in.nextLine(); 
			chickendao.updatesize(chicken,csize);break;
			case"2": 
				System.out.println("수정할 요리 방식을 쓰시오");
				String ccook = in.nextLine();
			chickendao.updatecook(chicken,ccook); break;
			case"3": 
				System.out.println("수정할 평점을 쓰시오");
				String cscore = in.nextLine();
			chickendao.updatescore(chicken,cscore);  break;
			}
		
		System.out.println("프렌차이즈에서 수정할 것이 있는가? y/n");
		String yn = in.nextLine();
		switch(yn) {
		case"y": super.update(); break;
		case"n": break;
		}
		
		
	}
	
	
	
	
}
