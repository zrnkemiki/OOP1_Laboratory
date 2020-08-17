package io_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;

import model.Appointment;
import model.CollectionType;
import model.DataBase;

public class IOAnalysisRequest {
	
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;

	public IOAnalysisRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void loadAnalysisRequests() throws ParseException, NumberFormatException, IOException {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/Data/analysisRequests.txt"), "utf-8"));
			String s;
			while ((s = in.readLine()) != null) {
				s = s.trim();
				String[] tokens = s.split("\\|");
				if (tokens.length == 6) {
					Appointment ar = new Appointment();
					ar.setId(Long.valueOf(tokens[0]));
					ar.setLBO(tokens[1]);
					ar.setDate(LocalDate.parse(tokens[2]));
					ar.setCollectionType(CollectionType.valueOf(tokens[3]));
					ar.setStatus(tokens[4]);
					ar.setAnalysisId(Long.valueOf(tokens[5]));
					DataBase.analysisRequests.add(ar);
			}
			}
			in.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void updateAnalysisRequests() {
		String sadrzaj = "";
		for (Appointment ar : DataBase.analysisRequests) {
			sadrzaj += ar.toString() + "\n";

		}
		try {
			fw = new FileWriter("src/Data/analysisRequests.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
