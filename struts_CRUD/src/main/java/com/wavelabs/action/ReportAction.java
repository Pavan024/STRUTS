package com.wavelabs.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wavelabs.bean.EmployeeBean;
import com.wavelabs.dao.Dao;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 6329394260276112660L;
	ResultSet rs = null;
	EmployeeBean bean = null;
	List<EmployeeBean> beanList = null;
	Dao Dao = new Dao();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<EmployeeBean>();
			rs = Dao.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new EmployeeBean();
					bean.setUname(rs.getString("UNAME"));
					bean.setUemail(rs.getString("UEMAIL"));
					bean.setUpass(rs.getString("UPASS").replaceAll("(?s).", "*"));
					bean.setUdeg(rs.getString("UDEG"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<EmployeeBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmployeeBean> beanList) {
		this.beanList = beanList;
	}
}