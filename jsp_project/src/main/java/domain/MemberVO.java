package domain;

public class MemberVO {
	private String id;
	private String password;
	private String email;
	private int age;
	private String reg_date;
	private String last_login;
	
	public MemberVO() {}
	
	//login
	public MemberVO(String id, String password) {
		this.id=id;
		this.password=password;
	}
	
	//join
	public MemberVO(String id, String password, String email, int age) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.age = age;
		
	}
	
	//list
	public MemberVO(String id, String email, int age, String reg_date, String last_login) {
		this.id = id;
		this.email = email;
		this.age = age;
		this.reg_date = reg_date;
		this.last_login = last_login;
	}
	
	//modify
	public MemberVO(String password, String email, int age) {
		this.password = password;
		this.email = email;
		this.age = age;
	}
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}


	
	
}
