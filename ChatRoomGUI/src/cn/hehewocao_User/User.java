package cn.hehewocao_User;

public class User {


	private String username;
	private String sex;

	public User() {

	}

	public User( String username, String sex) {
		
		this.username = username;
		this.sex = sex;

	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


}
