package io_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.AnalysisRequest;
import model.CollectionType;
import model.DataBase;
import model.StrucnaSprema;
import model.User;
import model.UserType;

public class LoadAnalysisRequest {
	
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;

	public LoadAnalysisRequest() {
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
					AnalysisRequest ar = new AnalysisRequest();
					ar.setId(Long.valueOf(tokens[0]));
					ar.setLBO(tokens[1]);
					ar.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tokens[2]));
					ar.setCollectionType(CollectionType.valueOf(tokens[3]));
					ar.setStatus(tokens[4]);
					ar.setAnalysisId(Long.valueOf(tokens[5]));
					DataBase.analysisRequests.add(ar);
					System.out.println(ar.toString());
			}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void updateAnalysisRequests() {
		String sadrzaj = "";
		for (AnalysisRequest ar : DataBase.analysisRequests) {
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
