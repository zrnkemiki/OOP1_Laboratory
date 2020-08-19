package io_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Appointment;
import model.CollectionType;
import model.DataBase;

public class IOAppointment {

	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;

	public IOAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void loadAppointments() throws ParseException, NumberFormatException, IOException {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/Data/analysisRequests.txt"), "utf-8"));
			String s;
			while ((s = in.readLine()) != null) {
				s = s.trim();
				String[] tokens = s.split("\\|");
				if (tokens.length == 7) {
					Appointment ar = new Appointment();
					ar.setId(Long.valueOf(tokens[0]));
					ar.setLBO(tokens[1]);
					ar.setDate(LocalDate.parse(tokens[2]));
					ar.setCollectionType(CollectionType.valueOf(tokens[3]));
					ar.setStatus(tokens[4]);
					try {
						String[] a = tokens[5].split("\\,");
						ArrayList<String> aType = new ArrayList<>();
						for (int i = 0; i < a.length; i++) {
							aType.add((a[i].trim()));
						}
						ar.setAnalysisType(aType);
					} catch (Exception e) {
					}
					ar.setAnalysisId(Long.valueOf(tokens[6]));
					DataBase.analysisRequests.add(ar);
			
			}
			in.close();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void updateAppointment() {
		String sadrzaj = "";
		for (Appointment ar : DataBase.analysisRequests) {
			sadrzaj += ar.toString().replace("|null|", "|").replace("[", "").replace("]", "").replace("|null", "")
					+ "\n";

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
