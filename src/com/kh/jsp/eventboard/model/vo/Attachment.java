package com.kh.jsp.eventboard.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Attachment implements Serializable {

	private int fno;
	private int bno;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int flevel;
	private int downloadCount;
	private String status;
	
	public Attachment() {
		super();
	}

	public Attachment(int fno, int bno, String originName, String changeName, String filePath, Date uploadDate,
			int flevel, int downloadCount, String status) {
		super();
		this.fno = fno;
		this.bno = bno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.flevel = flevel;
		this.downloadCount = downloadCount;
		this.status = status;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFlevel() {
		return flevel;
	}

	public void setFlevel(int flevel) {
		this.flevel = flevel;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fno=" + fno + ", bno=" + bno + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", flevel=" + flevel + ", downloadCount="
				+ downloadCount + ", status=" + status + "]";
	}
	
}
