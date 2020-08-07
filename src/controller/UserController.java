package controller;

import model.DataBase;
import model.User;

public class UserController {

	public User getUserByLBO(String lbo) {
		User user = DataBase.users.get(lbo);
		System.out.println(user.toString());
		return user;
	}
	
	
}
