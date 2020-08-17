package model;

import java.time.LocalDate;

public abstract class Analysis {

	
	private int price;
	private String status;
	private LocalDate date;
	private String lbo;
	
	public abstract void generateAnalysis();
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}
	
	public abstract String stringFileExport();
	

}
