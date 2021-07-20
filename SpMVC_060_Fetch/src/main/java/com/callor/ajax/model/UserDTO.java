package com.callor.ajax.model;

public class UserDTO {
	
	private String user_id;
	private String name;
	private String tel;
	private int age;
	private String addr;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public UserDTO(String user_id, String name, String tel, int age, String addr) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.tel = tel;
		this.age = age;
		this.addr = addr;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
