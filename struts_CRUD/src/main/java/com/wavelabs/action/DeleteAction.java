package com.wavelabs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wavelabs.dao.Dao;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	String uemail, msg;
	Dao dao = new Dao();

	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(uemail);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}