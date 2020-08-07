package io_Stream;

import java.io.IOException;
import java.text.ParseException;

import controller.Menu;

public class Main {

	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		// TODO Auto-generated method stub
		LoadUserData ld = new LoadUserData();
		ld.loadUsers();
		LoadAnalysisRequest lar = new LoadAnalysisRequest();
		lar.loadAnalysisRequests();
		Menu menu = new Menu();
		menu.start();
		
		
		
		
		
		
	}
	
	

}
