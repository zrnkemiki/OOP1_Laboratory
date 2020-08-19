package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Appointment {
	private long id;
	private String LBO;
	private LocalDate date;
	private CollectionType collectionType;
	private String status;
	private ArrayList<String> analysisType;
	private long analysisId;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ArrayList<String> getAnalysisType() {
		return analysisType;
	}



	public void setAnalysisType(ArrayList<String> analysisType) {
		this.analysisType = analysisType;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLBO() {
		return LBO;
	}


	public void setLBO(String lBO) {
		LBO = lBO;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public CollectionType getCollectionType() {
		return collectionType;
	}


	public void setCollectionType(CollectionType collectionType) {
		this.collectionType = collectionType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public long getAnalysisId() {
		return analysisId;
	}


	public void setAnalysisId(long analysisId) {
		this.analysisId = analysisId;
	}


	@Override
	public String toString() {
		return id + "|" + LBO + "|" + date + "|" + collectionType
				+ "|" + status + "|" + getAnalysisType() + "|"+ analysisId;
	}

	
	public String consoleView() {
		return "Appointment_id: " + id + "| Patient LBO: " + LBO + " | Date requested: " + date + " |  CollectionType: " + collectionType
				+ " | Current status: " + status;
	}

	
	
	
	
	
	
	

}
