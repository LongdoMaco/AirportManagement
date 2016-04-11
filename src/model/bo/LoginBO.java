package model.bo;

import model.bean.User;
import model.dao.LoginDAO;

public class LoginBO {

	LoginDAO login=new LoginDAO();
	public User checkLogin(String user, String pass) {
		// TODO Auto-generated method stub
		return login.checkLogin(user,pass);
	}
	
}
