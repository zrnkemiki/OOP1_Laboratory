package model;

import java.time.LocalDate;
import java.util.Random;

public class HematologicalAnalysis extends Analysis {

	private double whiteBloodCells;
	private String whiteBloodCells_referenceValue;
	private double redBloodCells;
	private String redBloodCells_referenceValue;
	private double hemoglobin;
	private String hemoglobin_referenceValue;
	private double hematocrit;
	private String hematocrite_referenceValue;
	private double MCV;
	private String MCV_referenceValue;
	private double MCH;
	private String MCH_referenceValue;
	private double MCHC;
	private String MCHC_refenceValue;
	private double platelet; // trombociti
	private String platelet_referenceValue;
	private double lymphocytes;
	private String lymphocytes_referenceValue;
	private double monocytes;
	private String monocytes_referenceValue;
	private double sedimentationRate;
	private String sedimentationRate_referenceValue;

	public HematologicalAnalysis() {
		super();
	}

	@Override
	public void generateAnalysis() {
		Random r = new Random();
		this.whiteBloodCells = 3.0 + (14.40 - 3.0) * r.nextDouble();
		this.whiteBloodCells_referenceValue = "4.0 - 10.0 ; x10^9/L";
		this.redBloodCells = 3.0 + (10.0 - 3.0) * r.nextDouble();
		this.redBloodCells_referenceValue = "4.50 - 5.80 ; x10^9/L";
		this.hemoglobin = 100.0 + (200.0 - 100.0) * r.nextDouble();
		this.hemoglobin_referenceValue = "130 - 180 ; g/L";
		this.hematocrit = 0.2 + (0.7 - 0.2) * r.nextDouble();
		this.hematocrite_referenceValue = "0.4 - 5.40 ; L/L";
		this.MCV = 70.0 + (100.0 - 70.0) * r.nextDouble();
		this.MCV_referenceValue = "83.0 - 97.0 ; fL";
		this.MCH = 20.0 + (36.0 - 20.0) * r.nextDouble();
		this.MCH_referenceValue = "27.0 - 32.0 ; pg";
		this.MCHC = 250.0 + (400.0 - 250.0) * r.nextDouble();
		this.MCHC_refenceValue = "300 - 360 ; g/L";
		this.platelet = 100.0 + (500.0 - 100.0) * r.nextDouble();
		this.platelet_referenceValue = "140 - 450 ; x10^9/L";
		this.lymphocytes = 15.0 + (60.0 - 15.0) * r.nextDouble();
		this.lymphocytes_referenceValue = "20.0 - 46.0 ; %";
		this.monocytes = 1.0 + (14.0 - 1.0) * r.nextDouble();
		this.monocytes_referenceValue = "2.0 - 12.0 ; %";
		this.sedimentationRate = 0.0 + (14.0 - 0.0) * r.nextDouble();
		this.sedimentationRate_referenceValue = "0 - 10 ; mm/1h";
		this.setPrice(1000);
		this.setStatus("Done");
		this.setDate(LocalDate.now());

	}

	public double getWhiteBloodCells() {
		return whiteBloodCells;
	}

	public void setWhiteBloodCells(double whiteBloodCells) {
		this.whiteBloodCells = whiteBloodCells;
	}

	public String getWhiteBloodCells_referenceValue() {
		return whiteBloodCells_referenceValue;
	}

	public void setWhiteBloodCells_referenceValue(String whiteBloodCells_referenceValue) {
		this.whiteBloodCells_referenceValue = whiteBloodCells_referenceValue;
	}

	public double getRedBloodCells() {
		return redBloodCells;
	}

	public void setRedBloodCells(double redBloodCells) {
		this.redBloodCells = redBloodCells;
	}

	public String getRedBloodCells_referenceValue() {
		return redBloodCells_referenceValue;
	}

	public void setRedBloodCells_referenceValue(String redBloodCells_referenceValue) {
		this.redBloodCells_referenceValue = redBloodCells_referenceValue;
	}

	public double getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	public String getHemoglobin_referenceValue() {
		return hemoglobin_referenceValue;
	}

	public void setHemoglobin_referenceValue(String hemoglobin_referenceValue) {
		this.hemoglobin_referenceValue = hemoglobin_referenceValue;
	}

	public double getHematocrit() {
		return hematocrit;
	}

	public void setHematocrit(double hematocrit) {
		this.hematocrit = hematocrit;
	}

	public String getHematocrite_referenceValue() {
		return hematocrite_referenceValue;
	}

	public void setHematocrite_referenceValue(String hematocrite_referenceValue) {
		this.hematocrite_referenceValue = hematocrite_referenceValue;
	}

	public double getMCV() {
		return MCV;
	}

	public void setMCV(double mCV) {
		MCV = mCV;
	}

	public String getMCV_referenceValue() {
		return MCV_referenceValue;
	}

	public void setMCV_referenceValue(String mCV_referenceValue) {
		MCV_referenceValue = mCV_referenceValue;
	}

	public double getMCH() {
		return MCH;
	}

	public void setMCH(double mCH) {
		MCH = mCH;
	}

	public String getMCH_referenceValue() {
		return MCH_referenceValue;
	}

	public void setMCH_referenceValue(String mCH_referenceValue) {
		MCH_referenceValue = mCH_referenceValue;
	}

	public double getMCHC() {
		return MCHC;
	}

	public void setMCHC(double mCHC) {
		MCHC = mCHC;
	}

	public String getMCHC_refenceValue() {
		return MCHC_refenceValue;
	}

	public void setMCHC_refenceValue(String mCHC_refenceValue) {
		MCHC_refenceValue = mCHC_refenceValue;
	}

	public double getPlatelet() {
		return platelet;
	}

	public void setPlatelet(double platelet) {
		this.platelet = platelet;
	}

	public String getPlatelet_referenceValue() {
		return platelet_referenceValue;
	}

	public void setPlatelet_referenceValue(String platelet_referenceValue) {
		this.platelet_referenceValue = platelet_referenceValue;
	}

	public double getLymphocytes() {
		return lymphocytes;
	}

	public void setLymphocytes(double lymphocytes) {
		this.lymphocytes = lymphocytes;
	}

	public String getLymphocytes_referenceValue() {
		return lymphocytes_referenceValue;
	}

	public void setLymphocytes_referenceValue(String lymphocytes_referenceValue) {
		this.lymphocytes_referenceValue = lymphocytes_referenceValue;
	}

	public double getMonocytes() {
		return monocytes;
	}

	public void setMonocytes(double monocytes) {
		this.monocytes = monocytes;
	}

	public String getMonocytes_referenceValue() {
		return monocytes_referenceValue;
	}

	public void setMonocytes_referenceValue(String monocytes_referenceValue) {
		this.monocytes_referenceValue = monocytes_referenceValue;
	}

	public double getSedimentationRate() {
		return sedimentationRate;
	}

	public void setSedimentationRate(double sedimentationRate) {
		this.sedimentationRate = sedimentationRate;
	}

	public String getSedimentationRate_referenceValue() {
		return sedimentationRate_referenceValue;
	}

	public void setSedimentationRate_referenceValue(String sedimentationRate_referenceValue) {
		this.sedimentationRate_referenceValue = sedimentationRate_referenceValue;
	}

	@Override
	public String toString() {
		return "HematologicalAnalysis|" + getId() + "|" + whiteBloodCells + "|" + whiteBloodCells_referenceValue + "|" + redBloodCells
				+ "|" + redBloodCells_referenceValue + "|" + hemoglobin + "|" + hemoglobin_referenceValue + "|"
				+ hematocrit + "|" + hematocrite_referenceValue + "|" + MCV + "|" + MCV_referenceValue + "|" + MCH + "|"
				+ MCH_referenceValue + "|" + MCHC + "|" + MCHC_refenceValue + "|" + platelet + "|"
				+ platelet_referenceValue + "|" + lymphocytes + "|" + lymphocytes_referenceValue + "|" + monocytes + "|"
				+ monocytes_referenceValue + "|" + sedimentationRate + "|" + sedimentationRate_referenceValue + "|"
				+ getPrice() + "|" + getStatus() + "|" + getDate() + "|" + getLbo() + "|"  + getId() ;
	}

	@Override
	public String stringFileExport() {
		return "HematologicalAnalysis\n" + "---------------------------------------------------\n"
				+ "PARAMETAR  | VREDNOST | MIN - MAX | JEDINICA MERE \n" + 
				"WhiteB.Cells|"	+ String.format("%.2f", whiteBloodCells) + "|" + whiteBloodCells_referenceValue + "\n" + 
				"RedB.Cells  |"	+ String.format("%.2f", redBloodCells) + "|" + redBloodCells_referenceValue + "\n" + 
				"Hemoglobin  |" + String.format("%.2f", hemoglobin) + "|" + hemoglobin_referenceValue + "n" + 
				"Hematocrit  |"	+ String.format("%.2f", hematocrit) + "|" + hematocrite_referenceValue + "\n" + 
				"MCV         |" + String.format("%.2f", MCV) + "|" + MCV_referenceValue + "\n" + 
				"MCH         |"	+ String.format("%.2f", MCH) + "|" + MCH_referenceValue + "|" + 
				"MCHC        |" + String.format("%.2f", MCHC) + "|" + MCHC_refenceValue + "\n" +
				"Platelet    |" + String.format("%.2f", platelet) + "|" + platelet_referenceValue + "\n" + 
				"Lymphocytes |" + String.format("%.2f", lymphocytes) + "|" + lymphocytes_referenceValue + "\n" +
				"Monocytes   |" + String.format("%.2f", monocytes) + "|" + monocytes_referenceValue + "\n" + 
				"Sed. rate   |" + String.format("%.2f", sedimentationRate) + "|" + sedimentationRate_referenceValue + "\n" +
				"----------------------------------------------------\n" +
				"Price      | " + getPrice()  + "RSD \n" +
				"Status     | " + getStatus()  + "\n" +
				"Date       | "	+ getDate()  + "\n" +
				"LBO        | " + getLbo();
	}

}
