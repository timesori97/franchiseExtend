package DTO;

public class ChickenDTO {

	private String menuname;
	private String csize;
	private String ccook;
	private String cscore;
	private String type;
	
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getCsize() {
		return csize;
	}
	public void setCsize(String csize) {
		this.csize = csize;
	}
	public String getCcook() {
		return ccook;
	}
	public void setCcook(String ccook) {
		this.ccook = ccook;
	}
	public String getCscore() {
		return cscore;
	}
	public void setCscore(String cscore) {
		this.cscore = cscore;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void prt() {
		System.out.println("--------------------------------------------");
		System.out.println("치킨 이름 : "+this.menuname);
		System.out.println("치킨 사이즈 : "+this.csize);
		System.out.println("치킨 요리종류 : "+this.cscore);
		System.out.println("치킨 평점 : "+this.cscore);
		System.out.println("타입 : "+this.type);
		System.out.println("--------------------------------------------");
	}
	
	
	
}
