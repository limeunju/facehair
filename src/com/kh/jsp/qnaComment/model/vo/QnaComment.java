package com.kh.jsp.qnaComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class QnaComment implements Serializable{

	private int qcno;
	private int qcwriter;
	private int qno;
	private String qccontent;
	private Date qcdate;
	private String status;
	
	public QnaComment() {
		super();
		
	}

	public QnaComment(int qcno, int qcwriter, int qno, String qccontent) {
		super();
		this.qcno = qcno;
		this.qcwriter = qcwriter;
		this.qno = qno;
		this.qccontent = qccontent;
	}

	public QnaComment(int qcno, int qcwriter, int qno, String qccontent, Date qcdate, String status) {
		super();
		this.qcno = qcno;
		this.qcwriter = qcwriter;
		this.qno = qno;
		this.qccontent = qccontent;
		this.qcdate = qcdate;
		this.status = status;
	}

	public int getQcno() {
		return qcno;
	}

	public void setQcno(int qcno) {
		this.qcno = qcno;
	}

	public int getQcwriter() {
		return qcwriter;
	}

	public void setQcwriter(int qcwriter) {
		this.qcwriter = qcwriter;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQccontent() {
		return qccontent;
	}

	public void setQccontent(String qccontent) {
		this.qccontent = qccontent;
	}

	public Date getQcdate() {
		return qcdate;
	}

	public void setQcdate(Date qcdate) {
		this.qcdate = qcdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "QnaComment [qcno=" + qcno + ", qcwriter=" + qcwriter + ", qno=" + qno + ", qccontent=" + qccontent
				+ ", qcdate=" + qcdate + ", status=" + status + "]";
	}
	
	
	
}	

