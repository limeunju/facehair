package com.kh.jsp.Qna.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Qna implements Serializable {
   private int qno;
   private int writer;
   private String qtitle;
   private String qcontent;
   private int qcount;
   private Date qdate;
   private String status;
   
   public Qna() {
      super();

   }
   
   

   public Qna(String qtitle, String qcontent) {
	super();
	this.qtitle = qtitle;
	this.qcontent = qcontent;
}



public Qna(int qno, int writer, String qtitle, String qcontent, int qcount, Date qdate, String status) {
      super();
      this.qno = qno;
      this.writer = writer;
      this.qtitle = qtitle;
      this.qcontent = qcontent;
      this.qcount = qcount;
      this.qdate = qdate;
      this.status = status;
   }

   public int getQno() {
      return qno;
   }

   public void setQno(int qno) {
      this.qno = qno;
   }

   public int getWriter() {
      return writer;
   }

   public void setWriter(int writer) {
      this.writer = writer;
   }

   public String getQtitle() {
      return qtitle;
   }

   public void setQtitle(String qtitle) {
      this.qtitle = qtitle;
   }

   public String getQcontent() {
      return qcontent;
   }

   public void setQcontent(String qcontent) {
      this.qcontent = qcontent;
   }

   public int getQcount() {
      return qcount;
   }

   public void setQcount(int qcount) {
      this.qcount = qcount;
   }

   public Date getQdate() {
      return qdate;
   }

   public void setQdate(Date qdate) {
      this.qdate = qdate;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "Qna [qno=" + qno + ", writer=" + writer + ", qtitle=" + qtitle + ", qcontent=" + qcontent + ", qcount="
            + qcount + ", qdate=" + qdate + ", status=" + status + "]";
   }
   
   
   
}