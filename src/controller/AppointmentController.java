package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import io_Stream.IOAppointment;
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
		if(DataBase.allAnalysis.size() == 0) {
			appointment.setId(1);
		}
		else{
			appointment.setId(DataBase.analysisRequests.get(DataBase.analysisRequests.size()-1).getId() + 1);
		}
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
		boolean t = true;
		ArrayList<String> aType = new ArrayList<>();
		while(t) {
			System.out.println("Izaberite tip analize:");
			System.out.println("1. Biohemija");
			System.out.println("2. Hormoni");
			System.out.println("3. Hematologija");
			System.out.println("-------------------------");
			int input = MenuController.chooseMenuOption(3, false);
			if(input == 1) {
				aType.add("BIOHEMIJA");
			}
			else if(input == 2) {
				aType.add("HORMONI");
			}
			else if(input == 3) {
				aType.add("HEMATOLOGIJA");
			}
			System.out.println("Da li zelite jos neku od analiza?");
			System.out.println("1) Da \n 2)Ne");
			input = MenuController.chooseMenuOption(3, false);
			if (input == 2) {
				t = false;
				appointment.setAnalysisType(aType);
			}
			
		}
			
		
		
		appointment.setStatus("Requested");	
		DataBase.analysisRequests.add(appointment);
		System.out.println("Uspesno ste rezervisali termin:");
		System.out.println(appointment.toString());
		
		IOAppointment.updateAppointment();
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
	
	public ArrayList<Appointment> getTodayReadyAppointents() {
		ArrayList<Appointment> a = DataBase.analysisRequests;
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).getStatus().toUpperCase().equals("READY") && a.get(i).getDate().equals(LocalDate.now()) ) {
				System.out.println(a.get(i).getId() + ") " + a.get(i).consoleView());
			}
		}
		return a;
	}



	public Appointment getAppointmentByID(int id) {
		ArrayList<Appointment> a = DataBase.analysisRequests;
		Appointment temp = new Appointment();
		for (Appointment appointment : a) {
			if (appointment.getId() == id) {
				temp = appointment;
			}
		}
		return temp;
	}
	
	
	
}
