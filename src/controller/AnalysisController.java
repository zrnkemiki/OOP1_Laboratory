package controller;

import java.util.ArrayList;
import java.util.UUID;

import io_Stream.IOAnalysis;
import io_Stream.IOHandler;
import model.Analysis;
import model.Appointment;
import model.BiochemistryAnalysis;
import model.DataBase;
import model.HematologicalAnalysis;
import model.HormonesAnalysis;

public class AnalysisController {

	public AnalysisController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createAnalysisFromScratch() {
		Analysis analysis = null;
		String lbo = "";
		System.out.println("Izaberite tip analize:");
		System.out.println("1. Biohemija");
		System.out.println("2. Hormoni");
		System.out.println("3. Hematologija");
		System.out.println("-------------------------");
		int input = MenuController.chooseMenuOption(3, false);
		if (input == 1) {
			analysis = new BiochemistryAnalysis();
			analysis.generateAnalysis();
			System.out.println("Analiza biohemije uspesno uradjena, molimo unesite pacijentov LBO");
			lbo = IOHandler.existingLboInput();
			analysis.setLbo(lbo);
		} else if (input == 2) {
			analysis = new HormonesAnalysis();
			analysis.generateAnalysis();
			System.out.println("Analiza hormona uspesno uradjena, molimo unesite pacijentov LBO");
			lbo = IOHandler.existingLboInput();
			analysis.setLbo(lbo);
		} else if (input == 3) {
			analysis = new HematologicalAnalysis();
			analysis.generateAnalysis();
			System.out.println("Analiza hematologije uspesno uradjena, molimo unesite pacijentov LBO");
			lbo = IOHandler.existingLboInput();
			analysis.setLbo(lbo);
		}

		analysis.setId(UUID.randomUUID().toString());

		if (DataBase.allAnalysis.containsKey(lbo)) {
			
			DataBase.allAnalysis.get(lbo).add(analysis);
			IOAnalysis.updateAnalysis();
			System.out.println("Pacijent vec ima karton. Analiza je dodata.");
		} else {
			DataBase.allAnalysis.put(lbo, new ArrayList<>());
			DataBase.allAnalysis.get(lbo).add(analysis);
			IOAnalysis.updateAnalysis();
			System.out.println("Pacijent nije imao karton. Novi karton je napravljen i analiza dodata.");
		}
	}
	
	public void createAnalysisFromAppointment(int id) {
		Analysis analysis = null;
		AppointmentController apc = new AppointmentController();
		Appointment a = apc.getAppointmentByID(id);
		System.out.println("Analiza je zakzana za pacijenta sa LBO: " + a.getLBO());
		
		if (!DataBase.allAnalysis.containsKey(a.getLBO())) {
			DataBase.allAnalysis.put(a.getLBO(), new ArrayList<>());
			System.out.println("Pacijent nije imao karton. Novi karton je napravljen.");
		}
		
		if (a.getAnalysisType().contains("BIOHEMIJA")) {
			analysis = new BiochemistryAnalysis();
			analysis.generateAnalysis();
			System.out.println("Analiza biohemije uspesno uradjena.");
			analysis.setLbo(a.getLBO());
			DataBase.allAnalysis.get(a.getLBO()).add(analysis);
		} 
		if (a.getAnalysisType().contains("HORMONI")) {
			analysis = new HormonesAnalysis();
			analysis.generateAnalysis();
			System.out.println("Analiza hormona uspesno uradjena.");
			analysis.setLbo(a.getLBO());
			DataBase.allAnalysis.get(a.getLBO()).add(analysis);
		}
		if (a.getAnalysisType().contains("HEMATOLOGIJA")) {
			analysis = new HematologicalAnalysis();
			analysis.generateAnalysis();
			System.out.println("Analiza hematologije uspesno uradjena.");
			analysis.setLbo(a.getLBO());
			DataBase.allAnalysis.get(a.getLBO()).add(analysis);
		}

		analysis.setId(UUID.randomUUID().toString());

		IOAnalysis.updateAnalysis();
		
	}

	public ArrayList<Analysis> getAnalysisByLBO(String LBO) {
		ArrayList<Analysis> a = DataBase.allAnalysis.get(LBO);
		return a;
	}

	public void exportAnalysis(ArrayList<Analysis> a) {
		System.out.println("---|----------------------------------|------------------|");
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) instanceof BiochemistryAnalysis) {
				System.out.println(i + 1 + "  | Biohemijska analiza radjena dana |  " + a.get(i).getDate()+ "      |") ;
				System.out.println("---|----------------------------------|------------------|");
			}
			else if (a.get(i) instanceof HormonesAnalysis) {
				System.out.println(i + 1 + "  | Hormonska analiza radjena dana   |  " + a.get(i).getDate()+ "      |");
				System.out.println("---|----------------------------------|------------------|");
			}
			else if (a.get(i) instanceof HematologicalAnalysis) {
				System.out.println(i + 1 + "  | Hematoloska analiza radjena dana |" + a.get(i).getDate()+ "       |");
				System.out.println("---|----------------------------------|------------------|");
			}
		}
		System.out.println("Izaberite nalaz koji zelite da eksportujete:");
		System.out.println("0 za povratak u prethodni meni");
		IOAnalysis ioa = new IOAnalysis();
		int id = IOHandler.intInput();
		if(id != 0) {
			ioa.createFile(a.get(id-1));
		}
		else if(id == 0) {
			System.out.println("Odustali ste od eksportovanja fajla.");
		}
	}

}
