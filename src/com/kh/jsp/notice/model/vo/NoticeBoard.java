package com.kh.jsp.notice.model.vo;

import java.sql.Date;

public class NoticeBoard {

	private int btype;
	private int bno;
	private String nTitle;
	private String nContent;
	private int nCount;
	private Date nDate;
	private String Status;
	
	
	public NoticeBoard() {
		super();
		
	}
	
	public NoticeBoard(String nTitle, String nContent) {
		super();
		this.nTitle = nTitle;
		this.nContent = nContent;
	}

	public NoticeBoard(int btype, int bno, String nTitle, String nContent, int nCount, Date nDate, String Status) {
		super();
		this.btype = btype;
		this.bno = bno;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nCount = nCount;
		this.nDate = nDate;
		this.Status = Status;
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

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	@Override
	public String toString() {
		return "NoticeBoard [btype=" + btype + ", bno=" + bno + ", nTitle=" + nTitle + ", nContent=" + nContent
				+ ", nCount=" + nCount + ", nDate=" + nDate + ", Status=" + Status + "]";
	}
	
}
