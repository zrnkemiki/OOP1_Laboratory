package io_Stream;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import model.User;

public class Main {

	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		// TODO Auto-generated method stub
		LoadData ld = new LoadData();
		List<User> users = ld.loadUsers();
		System.out.println(users.get(0).toString());
		System.out.println(users.get(1).toString());
		System.out.println(users.get(2).toString());
		
	}

}
