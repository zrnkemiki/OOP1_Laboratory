package controller;

import io_Stream.IOHandler;
import io_Stream.LoadAnalysisRequest;
import model.AnalysisRequest;
import model.CollectionType;
import model.DataBase;
import model.User;
import model.UserType;

public class Termin {

	public void zakazivanjeTermina(User user) {
		AnalysisRequest analysisRequest = new AnalysisRequest();
		System.out.println("-------------------------------------\n");
		System.out.println("Zakazivanje novog termina: \n");
		if(user.getUserType() == UserType.PACIJENT) {
			analysisRequest.setLBO(user.getLBO());		
		}
		else {
			System.out.println("Please enter patient LBO:");
			int LBO = IOHandler.intInput();
			analysisRequest.setLBO(String.valueOf(LBO));
		}
		System.out.println("Please enter the date: yyyy-MM-dd");
		analysisRequest.setDate(IOHandler.dateInput());
		System.out.println("Please choose the collection type:");
		System.out.println("1. At Laboratory");
		System.out.println("2. At your Home Adress");
		int tempInput = Menu.chooseMenuOption(2, false);
		if(tempInput == 1) {
			analysisRequest.setCollectionType(CollectionType.AT_LABORATORY);
		}
		else if(tempInput ==2) {
			analysisRequest.setCollectionType(CollectionType.AT_HOME);
		}
		analysisRequest.setStatus("Requested");	
		DataBase.analysisRequests.add(analysisRequest);
		System.out.println("Uspesno ste rezervisali termin:");
		System.out.println(analysisRequest.toString());
		
		LoadAnalysisRequest.updateAnalysisRequests();
	}

}
