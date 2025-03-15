package Super;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.ChickenDTO;

public class Super {

	 private String fname;
	 private String faddr;
	 private String mname;
     private String type;
 	 Scanner in = new Scanner(System.in);
 	 private SuperDAO superdao = new SuperDAO();
	public Super() {
		
	}
	
	public void Superin(String fname,String faddr,String mname,String type) {
		this.fname = fname;
		this.faddr = faddr;
		this.mname = mname;
		this.type = type;
	}
	
	public void add() {
		    ChickenDTO cdto = new ChickenDTO(); 
		    Super s = new Super();
			System.out.println("프렌차이즈의 이름을 쓰시오");
			String fname = in.nextLine();
			System.out.println("프렌차이즈의 주소를 쓰시오");
			String faddr = in.nextLine();
			System.out.println("매니저의 이름을 쓰시오");
			String mname = in.nextLine();
			System.out.println("프렌차이즈의 타입을 쓰시오");
			String type = in.nextLine();
			
			
			s.setFname(fname);
			s.setFaddr(faddr);
			s.setMname(mname);
			s.setType(type);
			
			superdao.insert(cdto,s);
	}
	public  void select() {
	}
	public void delete() {
		System.out.println("삭제할 프렌차이즈 이름을 쓰시오");
		String fname = in.nextLine();
		
		superdao.delete(fname);
	}
	public void update() {
		Super s = new Super();
		System.out.println("수정할 브랜드를 입력하시오");
		String fname = in.nextLine();
		
			System.out.println("수정할 부분을 입력하시오");
			System.out.println("1.프렌차이즈 주소 2.매니저 이름");
			String selectnum = in.nextLine();
			switch(selectnum) {
			case"1": 
				System.out.println("수정할 주소를 쓰시오");
				String faddr = in.nextLine(); 
			superdao.updatefaddr(fname,faddr);break;
			case"2":
				System.out.println("수정할 매니저 이름을 쓰시오");
				String mname = in.nextLine();
			superdao.updatemname(fname,mname); break;
			
			}
		
		
	}
	
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFaddr() {
		return faddr;
	}

	public void setFaddr(String faddr) {
		this.faddr = faddr;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	
	
}
