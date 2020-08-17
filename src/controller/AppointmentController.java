package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import io_Stream.IOAnalysisRequest;
import io_Stream.IOHandler;
import model.Appointment;
import model.CollectionType;
import model.DataBase;
import model.User;
import model.UserType;

public class AppointmentController {

	public void makeAppointment(User user) {
		Appointment appointment = new Appointment();
		System.out.println("-------------------------------------\n");
		System.out.println("Zakazivanje novog termina: \n");
		appointment.setId(DataBase.analysisRequests.get(DataBase.analysisRequests.size()-1).getId() + 1);
		if(user.getUserType() == UserType.PACIJENT) {
			appointment.setLBO(user.getLBO());		
		}
		else {
			System.out.println("Please enter patient LBO:");
			String LBO = String.valueOf(IOHandler.intInput());
			if(DataBase.users.containsKey(LBO))
			appointment.setLBO(LBO);
		}
		System.out.println("Please enter the date: yyyy-MM-dd");
		appointment.setDate(IOHandler.dateInput());
		System.out.println("Please choose the collection type:");
		System.out.println("1. At Laboratory");
		System.out.println("2. At your Home Adress");
		int tempInput = MenuController.chooseMenuOption(2, false);
		if(tempInput == 1) {
			appointment.setCollectionType(CollectionType.AT_LABORATORY);
		}
		else if(tempInput ==2) {
			appointment.setCollectionType(CollectionType.AT_HOME);
		}
		appointment.setStatus("Requested");	
		DataBase.analysisRequests.add(appointment);
		System.out.println("Uspesno ste rezervisali termin:");
		System.out.println(appointment.toString());
		
		IOAnalysisRequest.updateAnalysisRequests();
	}
	
	

	public void getFutureAppointments() {
		ArrayList<Appointment> a = DataBase.analysisRequests;
		for(int i = 0; i < a.size(); i++) {
			if(!a.get(i).getStatus().toUpperCase().equals("DONE")) {
				System.out.println(a.get(i).getId() + ") " + a.get(i).consoleView());
			}
		}
	}
	
	public void getTodayAppointents() {
		ArrayList<Appointment> a = DataBase.analysisRequests;
		for(int i = 0; i < a.size(); i++) {
			if(!a.get(i).getStatus().toUpperCase().equals("DONE") && a.get(i).getDate().equals(LocalDate.now()) ) {
				System.out.println(a.get(i).getId() + ") " + a.get(i).consoleView());
			}
		}
	}
	
}
