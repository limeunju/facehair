package com.kh.jsp.talkComment.model.vo;

import java.sql.Timestamp;

public class TalkComment {
	
	private int cno;
	private int cwriter;
	private int bno;
	private String ccontent; 
	private Timestamp cdate;
	private String status;
	
	public TalkComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TalkComment(int cwriter, int bno, String ccontent) {
		super();
		this.cwriter = cwriter;
		this.bno = bno;
		this.ccontent = ccontent;
	}

	public TalkComment(int cno, int cwriter, int bno, String ccontent, Timestamp cdate, String status) {
		super();
		this.cno = cno;
		this.cwriter = cwriter;
		this.bno = bno;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "TalkComment [cno=" + cno + ", cwriter=" + cwriter + ", bno=" + bno + ", ccontent=" + ccontent
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
	
	

}
