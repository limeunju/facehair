package com.kh.jsp.boardComment.model.vo;

import java.io.Serializable;

import java.sql.Timestamp;



public class BoardComment implements Serializable {
	private int cno      ;
	private int cwriter  ;
	private String userName;
	private int bno      ;
	private String ccontent ;
	private	Timestamp cdate ;
	private String status   ;
	
	
	
	public BoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BoardComment(int cno, int cwriter, int bno, String ccontent) {
		super();
		this.cno = cno;
		this.cwriter = cwriter;
		this.bno = bno;
		this.ccontent = ccontent;
	}



	public BoardComment(int bno, String ccontent, Timestamp cdate) {
		super();
		this.bno = bno;
		this.ccontent = ccontent;
		this.cdate = cdate;
	}



	@Override
	public String toString() {
		return "BoardComment [cno=" + cno + ", cwriter=" + cwriter + ", bno=" + bno + ", ccontent=" + ccontent
				+ ", cdate=" + cdate + ", status=" + status + "]";
	}



	public int getCno() {
		return cno;
	}



	public void setCno(int cno) {
		this.cno = cno;
	}



	public int getCwriter() {
		return cwriter;
	}



	public void setCwriter(int cwriter) {
		this.cwriter = cwriter;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getCcontent() {
		return ccontent;
	}



	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}



	public Timestamp getCdate() {
		return cdate;
	}



	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
	
}
