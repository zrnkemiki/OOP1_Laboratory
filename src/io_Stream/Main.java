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
		IOAppointment lar = new IOAppointment();
		lar.loadAppointments();
		System.out.println(DataBase.analysisRequests.get(0));
		IOAnalysis ioa = new IOAnalysis();
		ioa.loadAnalysis();
		
		
		IOUserData iouser = new IOUserData();
		iouser.updateUsers();
		MenuController menu = new MenuController();
		menu.start();

	}

}
