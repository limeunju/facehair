package com.kh.jsp.Creport.vo;

import java.util.Date;

public class Creport {
	private int crepno;
	private int cno;
	private int writer;
	private String crepcon;
	private Date crepdate;
	
	public Creport() {
		super();
	}

	public Creport(int crepno, int cno, int writer, String crepcon, Date crepdate) {
		super();
		this.crepno = crepno;
		this.cno = cno;
		this.writer = writer;
		this.crepcon = crepcon;
		this.crepdate = crepdate;
	}

	public int getCrepno() {
		return crepno;
	}

	public void setCrepno(int crepno) {
		this.crepno = crepno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getCrepcon() {
		return crepcon;
	}

	public void setCrepcon(String crepcon) {
		this.crepcon = crepcon;
	}

	public Date getCrepdate() {
		return crepdate;
	}

	public void setCrepdate(Date crepdate) {
		this.crepdate = crepdate;
	}

	@Override
	public String toString() {
		return "Creport [crepno=" + crepno + ", cno=" + cno + ", writer=" + writer + ", crepcon=" + crepcon
				+ ", crepdate=" + crepdate + "]";
	}
	
	
}
