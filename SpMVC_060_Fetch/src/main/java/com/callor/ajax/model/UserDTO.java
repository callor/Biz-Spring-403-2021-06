package com.callor.ajax.model;

public class UserDTO {
	
	private String user_id;
	private String name;
	private String tel;
	private int age;
	
	public UserDTO(String user_id, String name, String tel, int age) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", name=" + name + ", tel=" + tel + ", age=" + age + "]";
	}
	
	

}
