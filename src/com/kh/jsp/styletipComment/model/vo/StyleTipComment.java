package com.kh.jsp.styletipComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class StyleTipComment implements Serializable {
	
	private int cno;
	private int cwriter;
	private int bno;
	private String ccontent;
	private Date cdate;
	private String status;
	
	public StyleTipComment() { }

	public StyleTipComment(int cno, int cwriter, int bno, String ccontent, Date cdate, String status) {
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

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
	
}
