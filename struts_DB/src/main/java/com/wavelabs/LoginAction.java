package com.wavelabs;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String msg;
	private String email, pass;
	Dao adm = new Dao();

	@Override
	public String execute() throws Exception {
		msg = adm.getUser(email, pass);
		if (msg.startsWith("Sorry")) {
			return "FAILURE";
		} else {
			return "SUCCESS";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
