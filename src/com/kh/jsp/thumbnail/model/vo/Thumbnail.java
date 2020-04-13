package com.kh.jsp.thumbnail.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Thumbnail implements Serializable {
	
	private ArrayList<Attachment> attachments;
	
	private int bno     ;
	private int btype   ;
	private int writer  ;
	private String scontent;
	private int scount  ;
	private Date sdate   ;
	private String status  ;
	private String bfile;

	
	public Thumbnail() {
		super();
		
	}

	public Thumbnail(int bno, int btype, int writer, String scontent, int scount, Date sdate, String status) {
		super();
		this.bno = bno;
		this.btype = btype;
		this.writer = writer;
		this.scontent = scontent;
		this.scount = scount;
		this.sdate = sdate;
		this.status = status;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public int getScount() {
		return scount;
	}

	public void setScount(int scount) {
		this.scount = scount;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<Attachment> attachments) {
		this.attachments = attachments;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	

	@Override
	public String toString() {
		return "Thumbnail [bno=" + bno + ", btype=" + btype + ", writer=" + writer + ", scontent=" + scontent
				+ ", scount=" + scount + ", sdate=" + sdate + ", status=" + status + "]";
	}
	
}
