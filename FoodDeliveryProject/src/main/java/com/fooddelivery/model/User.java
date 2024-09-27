package com.fooddelivery.model;

public class User {

	private int id;
	private String name;
	private String email;
	private String pwd;
	private String address;
	
	public User(int id, String name, String email, String pwd, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.address = address;
	}
	public User(String name, String email, String pwd, String address) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return id + " " + name +" "+ email + " "+ pwd + " "+ address ;
	}
	

}
