package model;

import java.time.LocalDate;
import java.util.Random;

public class HormonesAnalysis extends Analysis {

	private double FSH;
	private String FSH_referenceValue;
	private double LH;
	private String LH_referenceValue;
	private double testosterone;
	private String testosterone_referenceValue;
	private double TSH;
	private String TSH_referenceValue;

	public HormonesAnalysis() {
		super();
	}

	@Override
	public void generateAnalysis() {
		Random r = new Random();
		this.FSH = 1.0 + (14.40 - 1.0) * r.nextDouble();
		this.FSH_referenceValue = "1.5 - 12.40";
		this.LH = 1.0 + (10.0 - 1.0) * r.nextDouble();
		this.LH_referenceValue = "1.70 - 8.60";
		this.testosterone = 8.0 + (30.0 - 8.0) * r.nextDouble();
		this.testosterone_referenceValue = "11.40 - 27.90";
		this.TSH = 0.20 + (5.6 - 0.20) * r.nextDouble();
		this.TSH_referenceValue = "0.270 - 4.280";
		this.setPrice(1000);
		this.setStatus("Done");
		this.setDate(LocalDate.now());

	}

	public double getFSH() {
		return FSH;
	}

	public void setFSH(double fSH) {
		FSH = fSH;
	}

	public String getFSH_referenceValue() {
		return FSH_referenceValue;
	}

	public void setFSH_referenceValue(String fSH_referenceValue) {
		FSH_referenceValue = fSH_referenceValue;
	}

	public double getLH() {
		return LH;
	}

	public void setLH(double lH) {
		LH = lH;
	}

	public String getLH_referenceValue() {
		return LH_referenceValue;
	}

	public void setLH_referenceValue(String lH_referenceValue) {
		LH_referenceValue = lH_referenceValue;
	}

	public double getTestosterone() {
		return testosterone;
	}

	public void setTestosterone(double testosterone) {
		this.testosterone = testosterone;
	}

	public String getTestosterone_referenceValue() {
		return testosterone_referenceValue;
	}

	public void setTestosterone_referenceValue(String testosterone_referenceValue) {
		this.testosterone_referenceValue = testosterone_referenceValue;
	}

	public double getTSH() {
		return TSH;
	}

	public void setTSH(double tSH) {
		TSH = tSH;
	}

	public String getTSH_referenceValue() {
		return TSH_referenceValue;
	}

	public void setTSH_referenceValue(String tSH_referenceValue) {
		TSH_referenceValue = tSH_referenceValue;
	}


	public String stringFileExport() {
		return "HormonesAnalysis\n" + 
				"---------------------------------------------------\n" +
				"PARAMETAR   | VREDNOST | MIN - MAX   | JEDINICA MERE \n" + 
				"FSH         | " + String.format("%.2f",FSH) + "     |" + FSH_referenceValue + "\n" + 
				"LH          | "  + String.format("%.2f",	LH) + "     |" + LH_referenceValue + "\n" +
				"Testosterone| " + String.format("%.2f",testosterone)	+ "    |" + testosterone_referenceValue + "\n" + 
				"TSH         | " + String.format("%.2f",TSH)	+ "     |" + TSH_referenceValue + "\n" +
				"----------------------------------------------------\n" +
				"Price      | " + getPrice()  + "RSD \n" +
				"Status     | " + getStatus()  + "\n" +
				"Date       | "	+ getDate()  + "\n" +
				"LBO        | " + getLbo();
	}
	
	@Override
	public String toString() {
		return "HormonesAnalysis|" + FSH + "|" + FSH_referenceValue + "|" + LH + "|" + LH_referenceValue + "|"
				+ testosterone + "|" + testosterone_referenceValue + "|" + TSH + "|" + TSH_referenceValue + "|"
				+ getPrice() + "|" + getStatus() + "|" + getDate() + "|" + getLbo() + "|"  + getId();
	}
	

}
