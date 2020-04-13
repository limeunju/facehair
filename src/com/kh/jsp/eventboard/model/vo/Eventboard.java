package com.kh.jsp.eventboard.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Eventboard implements Serializable{
	private int btype;
	private int bno;
	private String etitle;
	private String econtent;
	private int ecount;
	private Date edate;
	private String status;
	private String bfile;
	
	public Eventboard() {
		super();
	}

	@Override
	public String toString() {
		return "Eventboard [btype=" + btype + ", bno=" + bno + ", etitle=" + etitle + ", econtent=" + econtent
				+ ", ecount=" + ecount + ", edate=" + edate + ", status=" + status + ", bfile=" + bfile + "]";
	}

	public Eventboard(int btype, int bno, String etitle, String econtent, int ecount, Date edate, String status,
			String bfile) {
		super();
		this.btype = btype;
		this.bno = bno;
		this.etitle = etitle;
		this.econtent = econtent;
		this.ecount = ecount;
		this.edate = edate;
		this.status = status;
		this.bfile = bfile;
	}

	public Eventboard(int bno, String etitle, String econtent, int ecount, Date edate, String bfile) {
		super();
		this.bno = bno;
		this.etitle = etitle;
		this.econtent = econtent;
		this.ecount = ecount;
		this.edate = edate;
		this.bfile = bfile;
	}

	public Eventboard(String etitle, String econtent) {
		super();
		this.etitle = etitle;
		this.econtent = econtent;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getEtitle() {
		return etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getEcontent() {
		return econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	public int getEcount() {
		return ecount;
	}

	public void setEcount(int ecount) {
		this.ecount = ecount;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	
	

	

}
