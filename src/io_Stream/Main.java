package io_Stream;

import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

import controller.MenuController;
import model.BiochemistryAnalysis;
import model.DataBase;
import model.HematologicalAnalysis;

public class Main {

	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		// TODO Auto-generated method stub
		IOUserData ld = new IOUserData();
		ld.loadUsers();
		IOAnalysisRequest lar = new IOAnalysisRequest();
		lar.loadAnalysisRequests();
		IOAnalysis ioa = new IOAnalysis();
		ioa.loadAnalysis();
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.println(randomUUIDString);
		
		//ioa.createFile(DataBase.allAnalysis.get("111111").get(0));
		System.out.println(DataBase.allAnalysis.size());
		System.out.println(DataBase.analysisRequests.get(0).toString());
		IOUserData iouser = new IOUserData();
		iouser.updateUsers();
		MenuController menu = new MenuController();
		menu.start();

	}

}
