package com.kh.jsp.talk.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Talk implements Serializable{
	private int bno;
	private int btype;
	private int writer;
	private String tTitle;
	private String tContent;
	private int tCount;
	private Timestamp tDate;
	private String tStatus;
	
	public Talk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 게시글 추가용

	public Talk(int writer, String tTitle, String tContent) {
		super();
		this.writer = writer;
		this.tTitle = tTitle;
		this.tContent = tContent;
	}

	public Talk(int bno, int btype, int writer, String tTitle, String tContent, int tCount, Timestamp tDate,
			String tStatus) {
		super();
		this.bno = bno;
		this.btype = btype;
		this.writer = writer;
		this.tTitle = tTitle;
		this.tContent = tContent;
		this.tCount = tCount;
		this.tDate = tDate;
		this.tStatus = tStatus;
	}

	@Override
	public String toString() {
		return "Talk [bno=" + bno + ", btype=" + btype + ", writer=" + writer + ", tTitle=" + tTitle + ", tContent="
				+ tContent + ", tCount=" + tCount + ", tDate=" + tDate + ", tStatus=" + tStatus + "]";
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

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public String gettContent() {
		return tContent;
	}

	public void settContent(String tContent) {
		this.tContent = tContent;
	}

	public int gettCount() {
		return tCount;
	}

	public void settCount(int tCount) {
		this.tCount = tCount;
	}

	public Timestamp gettDate() {
		return tDate;
	}

	public void settDate(Timestamp tDate) {
		this.tDate = tDate;
	}

	public String gettStatus() {
		return tStatus;
	}

	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}
	
	
}
