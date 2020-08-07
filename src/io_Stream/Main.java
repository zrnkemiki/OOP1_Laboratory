package io_Stream;

import java.io.IOException;
import java.text.ParseException;

import controller.MenuController;
import model.DataBase;

public class Main {

	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		// TODO Auto-generated method stub
		IOUserData ld = new IOUserData();
		ld.loadUsers();
		IOAnalysisRequest lar = new IOAnalysisRequest();
		lar.loadAnalysisRequests();
		
		System.out.println(DataBase.analysisRequests.get(0).toString());
		
		
		MenuController menu = new MenuController();
		menu.start();
		
		
	}
	
	

}
