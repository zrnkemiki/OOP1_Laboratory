package io_Stream;

import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

import controller.MenuController;
import model.BiochemistryAnalysis;
import model.DataBase;

public class Main {

	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		// TODO Auto-generated method stub
		BiochemistryAnalysis ba = new BiochemistryAnalysis();
		ba.biochemistryAnalysisGenerator();
		System.out.println(ba.toString());
		
		
		IOUserData ld = new IOUserData();
		ld.loadUsers();
		IOAnalysisRequest lar = new IOAnalysisRequest();
		lar.loadAnalysisRequests();

		System.out.println(DataBase.analysisRequests.get(0).toString());
		IOUserData iouser = new IOUserData();
		iouser.updateUsers();
		MenuController menu = new MenuController();
		menu.start();

	}

}
