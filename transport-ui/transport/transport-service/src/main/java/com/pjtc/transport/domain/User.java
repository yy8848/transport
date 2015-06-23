package com.pjtc.transport.domain;

public class User {
	private long id;
	private String userName;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	
	public User(){	
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
}