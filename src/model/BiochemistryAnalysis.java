package model;

import java.time.LocalDate;
import java.util.Random;

public class BiochemistryAnalysis extends Analysis {
	private double glucose;
	private String glucose_ReferenceValue;
	private double urea;
	private String urea_ReferenceValue;
	private double creatinine;
	private String creatinine_ReferenceValue;
	private double bilirubin;
	private String bilirubin_ReferenceValue;
	private double AST;
	private String AST_ReferenceValue;
	private double ALT;
	private String ALT_ReferenceValue;
	private double cholesterol;
	private String cholesterol_ReferenceValue;
	private double HDL;
	private String HDL_ReferenceValue;
	private double iron;
	private String iron_ReferenceValue;

	public BiochemistryAnalysis() {
		super();
	}

	@Override
	public void generateAnalysis() {
		Random r = new Random();
		this.glucose = (3.0 + (8.0 - 3.0) * r.nextDouble());
		this.glucose_ReferenceValue = "3.9 - 6.1";
		this.urea = 2.0 + (10.0 - 2.0) * r.nextDouble();
		this.urea_ReferenceValue = "2.8 - 8.1";
		this.creatinine = 50.0 + (120.0 - 50.0) * r.nextDouble();
		this.creatinine_ReferenceValue = "62 - 106";
		this.bilirubin = 1.0 + (30.0 - 1.0) * r.nextDouble();
		this.bilirubin_ReferenceValue = "< 21.00";
		this.AST = 1.0 + (50.0 - 1.0) * r.nextDouble();
		this.AST_ReferenceValue = "< 40.00";
		this.ALT = 1.0 + (50.0 - 1.0) * r.nextDouble();
		this.ALT_ReferenceValue = "< 41.00";
		this.cholesterol = 3.0 + (7.0 - 1.0) * r.nextDouble();
		this.cholesterol_ReferenceValue = "3.90 - 6.20";
		this.HDL = 0.5 + (3.0 - 0.5) * r.nextDouble();
		this.HDL_ReferenceValue = "> 1.04";
		this.iron = 5.0 + (39.0 - 5.0) * r.nextDouble();
		this.iron_ReferenceValue = "5.8 - 34.5";
		this.setPrice(1000);
		this.setStatus("Done");
		this.setDate(LocalDate.now());

	}

	public double getGlucose() {
		return glucose;
	}

	public void setGlucose(double glucose) {
		this.glucose = glucose;
	}

	public String getGlucose_ReferenceValue() {
		return glucose_ReferenceValue;
	}

	public void setGlucose_ReferenceValue(String glucose_ReferenceValue) {
		this.glucose_ReferenceValue = glucose_ReferenceValue;
	}

	public double getUrea() {
		return urea;
	}

	public void setUrea(double urea) {
		this.urea = urea;
	}

	public String getUrea_ReferenceValue() {
		return urea_ReferenceValue;
	}

	public void setUrea_ReferenceValue(String urea_ReferenceValue) {
		this.urea_ReferenceValue = urea_ReferenceValue;
	}

	public double getCreatinine() {
		return creatinine;
	}

	public void setCreatinine(double creatinine) {
		this.creatinine = creatinine;
	}

	public String getCreatinine_ReferenceValue() {
		return creatinine_ReferenceValue;
	}

	public void setCreatinine_ReferenceValue(String creatinine_ReferenceValue) {
		this.creatinine_ReferenceValue = creatinine_ReferenceValue;
	}

	public double getBilirubin() {
		return bilirubin;
	}

	public void setBilirubin(double bilirubin) {
		this.bilirubin = bilirubin;
	}

	public String getBilirubin_ReferenceValue() {
		return bilirubin_ReferenceValue;
	}

	public void setBilirubin_ReferenceValue(String bilirubin_ReferenceValue) {
		this.bilirubin_ReferenceValue = bilirubin_ReferenceValue;
	}

	public double getAST() {
		return AST;
	}

	public void setAST(double aST) {
		AST = aST;
	}

	public String getAST_ReferenceValue() {
		return AST_ReferenceValue;
	}

	public void setAST_ReferenceValue(String aST_ReferenceValue) {
		AST_ReferenceValue = aST_ReferenceValue;
	}

	public double getALT() {
		return ALT;
	}

	public void setALT(double aLT) {
		ALT = aLT;
	}

	public String getALT_ReferenceValue() {
		return ALT_ReferenceValue;
	}

	public void setALT_ReferenceValue(String aLT_ReferenceValue) {
		ALT_ReferenceValue = aLT_ReferenceValue;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getCholesterol_ReferenceValue() {
		return cholesterol_ReferenceValue;
	}

	public void setCholesterol_ReferenceValue(String cholesterol_ReferenceValue) {
		this.cholesterol_ReferenceValue = cholesterol_ReferenceValue;
	}

	public double getHDL() {
		return HDL;
	}

	public void setHDL(double hDL) {
		HDL = hDL;
	}

	public String getHDL_ReferenceValue() {
		return HDL_ReferenceValue;
	}

	public void setHDL_ReferenceValue(String hDL_ReferenceValue) {
		HDL_ReferenceValue = hDL_ReferenceValue;
	}

	public double getIron() {
		return iron;
	}

	public void setIron(double iron) {
		this.iron = iron;
	}

	public String getIron_ReferenceValue() {
		return iron_ReferenceValue;
	}

	public void setIron_ReferenceValue(String iron_ReferenceValue) {
		this.iron_ReferenceValue = iron_ReferenceValue;
	}
	
	@Override
	public String toString() {
		return "BiochemistryAnalysis|" + glucose + "|" + glucose_ReferenceValue
				+ "|" + urea + "|" + urea_ReferenceValue + "|" + creatinine
				+ "|" + creatinine_ReferenceValue + "|" + bilirubin
				+ "|" + bilirubin_ReferenceValue + "|" + AST + "|"
				+ AST_ReferenceValue + "|" + ALT + "|" + ALT_ReferenceValue + "|"
				+ cholesterol + "|" + cholesterol_ReferenceValue + "|" + HDL
				+ "|" + HDL_ReferenceValue + "|" + iron + "|"
				+ iron_ReferenceValue + "|" + getPrice() + "|" + getStatus() + "|"
				+ getDate() + "|" + getLbo() + "|"  + getId() ;
	}
	


	public String stringFileExport() {
		return "BiochemistryAnalysis\n" +
				"---------------------------------------------------\n" +
				"PARAMETAR  | VREDNOST | MIN - MAX | JEDINICA MERE \n" + 
				"GLUCOSE    | " + String.format("%.2f",glucose) + "     | " + glucose_ReferenceValue + "\n" +
				"UREA       | " + String.format("%.2f",urea) + "     | " + urea_ReferenceValue + "\n" +
				"creatinine | " + String.format("%.2f",creatinine) + "   | " + creatinine_ReferenceValue  + "\n" + 
				"Bilirubin  | " + String.format("%.2f",bilirubin) +"    | "+ bilirubin_ReferenceValue  + "\n" + 
				"AST        | " + String.format("%.2f",AST) + "    | " + AST_ReferenceValue  + "\n" + 
				"ALT        | " + String.format("%.2f",ALT) + "    | " + ALT_ReferenceValue  + "\n" +
				"Cholesterol| " + String.format("%.2f",cholesterol) + "     | " + cholesterol_ReferenceValue  + "\n" +
				"HDL        | " + String.format("%.2f",HDL) + "     | " + HDL_ReferenceValue  + "\n" +
				"Iron       | " + String.format("%.2f",iron) + "    | " + iron_ReferenceValue  + "\n\n" +
				"----------------------------------------------------\n" +
				"Price      | " + getPrice()  + "RSD \n" +
				"Status     | " + getStatus()  + "\n" +
				"Date       | "	+ getDate()  + "\n" +
				"LBO        | " + getLbo();
		
	}
	
	

	

}