package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.bean.User;

public class LoginDAO {
	Connection cn;

	void connect() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String Url = "jdbc:odbc:AirportManagement";
			cn = DriverManager.getConnection(Url, "sa", "123456789");
			System.out.println("Dang nhap thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Dang nhap that bai");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public User checkLogin(String user, String pass) {
		connect();
		String str = "SELECT * FROM UserEmployee WHERE Username = '" + user
				+ "' AND Password = '" + pass + "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(str);
			if (rs.next()) {
				User us = new User();
				us.setUsername(rs.getString(1));
				us.setPassword(rs.getString(2));
				return us;
			}
			return null;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		
	}
	
}
