package com.kh.jsp.Report.model.vo;

import java.util.Date;

public class Report {
	private int repno;
	private int bno;
	private String repcon;
	private Date repdate;
	
	public Report() {
		super();
	}

	public Report(int repno, int bno, String repcon, Date repdate) {
		super();
		this.repno = repno;
		this.bno = bno;
		this.repcon = repcon;
		this.repdate = repdate;
	}

	public int getRepno() {
		return repno;
	}

	public void setRepno(int repno) {
		this.repno = repno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getRepcon() {
		return repcon;
	}

	public void setRepcon(String repcon) {
		this.repcon = repcon;
	}

	public Date getRepdate() {
		return repdate;
	}

	public void setRepdate(Date repdate) {
		this.repdate = repdate;
	}

	@Override
	public String toString() {
		return "Report [repno=" + repno + ", bno=" + bno + ", repcon=" + repcon + ", repdate=" + repdate + "]";
	}
	
	
}
