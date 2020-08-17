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

import model.Analysis;
import model.BiochemistryAnalysis;
import model.DataBase;
import model.HematologicalAnalysis;
import model.HormonesAnalysis;

public class IOAnalysis {

	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;

	public static void updateAnalysis() {
		String sadrzaj = "";
		for (ArrayList<Analysis> ar : DataBase.allAnalysis.values()) {
			for (Analysis analysis : ar) {
				sadrzaj += analysis.toString() + "\n";
			}
		}
		try {
			fw = new FileWriter("src/Data/analysis.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadAnalysis() throws ParseException, NumberFormatException, IOException {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/Data/analysis.txt"), "utf-8"));
			String s;
			while ((s = in.readLine()) != null) {
				s = s.trim();
				String[] tokens = s.split("\\|");
				if (tokens[0].equals("HematologicalAnalysis")) { 
					HematologicalAnalysis a = new HematologicalAnalysis();
					a.setWhiteBloodCells(Double.valueOf(tokens[1]));
					a.setWhiteBloodCells_referenceValue(tokens[2]);
					a.setRedBloodCells(Double.valueOf(tokens[3]));
					a.setRedBloodCells_referenceValue(tokens[4]);
					a.setHemoglobin(Double.valueOf(tokens[5]));
					a.setHemoglobin_referenceValue(tokens[6]);
					a.setHematocrit(Double.valueOf(tokens[7]));
					a.setHematocrite_referenceValue(tokens[8]);
					a.setMCV(Double.valueOf(tokens[9]));
					a.setMCV_referenceValue(tokens[10]);
					a.setMCH(Double.valueOf(tokens[11]));
					a.setMCH_referenceValue(tokens[12]);
					a.setMCHC(Double.valueOf(tokens[13]));
					a.setMCH_referenceValue(tokens[14]);
					a.setPlatelet(Double.valueOf(tokens[15]));
					a.setPlatelet_referenceValue(tokens[16]);
					a.setLymphocytes(Double.valueOf(tokens[17]));
					a.setLymphocytes_referenceValue(tokens[18]);
					a.setMonocytes(Double.valueOf(tokens[19]));
					a.setMonocytes_referenceValue(tokens[20]);
					a.setSedimentationRate(Double.valueOf(tokens[21]));
					a.setSedimentationRate_referenceValue(tokens[22]);
					a.setPrice(Integer.parseInt(tokens[23]));
					a.setStatus(tokens[24]);
					a.setDate(LocalDate.parse(tokens[25]));
					a.setLbo(tokens[25]);
					addAnalysisToDB(a);

				} else if (tokens[0].equals("HormonesAnalysis")) {
					HormonesAnalysis a = new HormonesAnalysis();
					a.setFSH(Double.valueOf(tokens[1]));
					a.setFSH_referenceValue(tokens[2]);
					a.setLH(Double.valueOf(tokens[3]));
					a.setLH_referenceValue(tokens[4]);
					a.setTestosterone(Double.valueOf(tokens[5]));
					a.setTestosterone_referenceValue(tokens[6]);
					a.setTSH(Double.valueOf(tokens[7]));
					a.setTSH_referenceValue(tokens[8]);
					a.setPrice(Integer.parseInt(tokens[9]));
					a.setStatus(tokens[10]);
					a.setDate(LocalDate.parse(tokens[11]));
					a.setLbo(tokens[12]);
					addAnalysisToDB(a);

				} else if (tokens[0].equals("BiochemistryAnalysis")) {
					BiochemistryAnalysis a = new BiochemistryAnalysis();
					a.setGlucose(Double.valueOf(tokens[1]));
					a.setGlucose_ReferenceValue(tokens[2]);
					a.setUrea(Double.valueOf(tokens[3]));
					a.setUrea_ReferenceValue(tokens[4]);
					a.setCreatinine(Double.valueOf(tokens[5]));
					a.setCreatinine_ReferenceValue(tokens[6]);
					a.setBilirubin(Double.valueOf(tokens[7]));
					a.setBilirubin_ReferenceValue(tokens[8]);
					a.setAST(Double.valueOf(tokens[9]));
					a.setAST_ReferenceValue(tokens[10]);
					a.setALT(Double.valueOf(tokens[11]));
					a.setALT_ReferenceValue(tokens[12]);
					a.setCholesterol(Double.valueOf(tokens[13]));
					a.setCholesterol_ReferenceValue(tokens[14]);
					a.setHDL(Double.valueOf(tokens[15]));
					a.setHDL_ReferenceValue(tokens[16]);
					a.setIron(Double.valueOf(tokens[17]));
					a.setIron_ReferenceValue(tokens[18]);
					a.setPrice(Integer.parseInt(tokens[19]));
					a.setStatus(tokens[20]);
					a.setDate(LocalDate.parse(tokens[21]));
					a.setLbo(tokens[22]);
					addAnalysisToDB(a);
				}

			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addAnalysisToDB(Analysis a) {
		if (DataBase.allAnalysis.containsKey(a.getLbo())) {
			DataBase.allAnalysis.get(a.getLbo()).add(a);
		} else {
			DataBase.allAnalysis.put(a.getLbo(), new ArrayList<Analysis>());
			DataBase.allAnalysis.get(a.getLbo()).add(a);
		}

	}

	public void createFile(Analysis analysis) {
		String sadrzaj = "";
		sadrzaj += analysis.stringFileExport() + "\n";
		try {
			fw = new FileWriter("src/Data/" + analysis.getLbo() + "_analysis.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Nalaz je eksportovan.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
