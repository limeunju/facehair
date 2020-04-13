package com.kh.jsp.styletip.model.vo;

import java.sql.Date;

public class StyleTip {

	private int btype;
	private int bno;
	private String ttitle;
	private String tcontent;
	private int tcount;
	private Date tdate;
	private String tfilter;
	private String status;
	private String imgTag;
	
	public StyleTip() { }

	public StyleTip(int btype, int bno, String ttitle, String tcontent, int tcount, Date tdate, String tfilter, String status) {
		super();
		this.btype = btype;
		this.bno = bno;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.tcount = tcount;
		this.tdate = tdate;
		this.tfilter = tfilter;
		this.status = status;
	}

	@Override
	public String toString() {
		return "StyleTip [btype=" + btype + ", bno=" + bno + ", ttitle=" + ttitle + ", tcontent=" + tcontent
				+ ", tcount=" + tcount + ", tdate=" + tdate + ", tfilter=" + tfilter + ", status=" + status + "]";
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

	public String getTtitle() {
		return ttitle;
	}

	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	public int getTcount() {
		return tcount;
	}

	public void setTcount(int tcount) {
		this.tcount = tcount;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	
	public String getTfilter() {
		return tfilter;
	}

	public void setTfilter(String tfilter) {
		this.tfilter = tfilter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getImgTag() {
		return imgTag;
	}

	public void setImgTag(String imgTag) {
		this.imgTag = imgTag;
	}
	
	
	
	
}
