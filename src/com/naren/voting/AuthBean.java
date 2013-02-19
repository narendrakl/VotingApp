package com.naren.voting;

public class AuthBean {
	
	private String username;
	private String pwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String authenticate()
	{
		if(username==null || username.trim().equals(""))
		{
			String msg="";
			msg="Username name is empty";
			System.out.println("Username name is empty");
			return msg;
		}
		else
			if(username.equals("Administrator") && pwd.equals("password"))
		{
			return Constants.SUCCESS;  
		}
		return "I Think U are not an Election Commissioner";
	}
}
