package controller;

import java.util.ArrayList;

import io_Stream.IOAnalysis;
import io_Stream.IOHandler;
import model.Analysis;
import model.BiochemistryAnalysis;
import model.DataBase;
import model.HematologicalAnalysis;
import model.HormonesAnalysis;

public class AnalysisController {

	public AnalysisController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createAnalysis() {
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
	
	

	public void loadAnalysis() {

	}

}
