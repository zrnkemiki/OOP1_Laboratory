package model;

import java.util.Date;

public class AnalysisRequest {
	private long id;
	private String LBO;
	private Date date;
	private CollectionType collectionType;
	private String status;
	private long analysisId;
	
	
	public AnalysisRequest() {
		super();
		// TODO Auto-generated constructor stub
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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
				+ "|" + status + "|" + analysisId;
	}
	
	
	
	
	

}
