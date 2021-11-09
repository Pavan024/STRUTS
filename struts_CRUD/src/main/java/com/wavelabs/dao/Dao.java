package com.wavelabs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	// method for create connection
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mvc_login", "root", "Vspk1998@");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// method for save user data in database
	public int registerUser(String uname, String uemail, String upass, String udeg) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO employee(uname,uemail,upass,udeg) VALUES (?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, upass);
			ps.setString(4, udeg);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// method for fetch saved user data
	public ResultSet report() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT UNAME,UEMAIL,UPASS,UDEG FROM employee";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// method for fetch old data to be update
	public ResultSet fetchUserDetails(String uemail) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT UNAME,UEMAIL,UPASS,UDEG FROM employee WHERE UEMAIL=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// method for update new data in database
		public int updateUserDetails(String uname, String uemail, String upass, String udeg, String uemailhidden)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE employee SET UNAME=?,UEMAIL=?,UPASS=?,UDEG=? WHERE UEMAIL=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uname);
				ps.setString(2, uemail);
				ps.setString(3, upass);
				ps.setString(4, udeg);
				ps.setString(5, uemailhidden);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

	// method for delete the record
	public int deleteUserDetails(String uemail) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM employee WHERE UEMAIL=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}