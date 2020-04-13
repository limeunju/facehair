package com.kh.jsp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	// 1. 필드 변수
	private int userNo;
	private String userId;
	private String password;
	private String userName;
	private String email;
	private Date dateOfBirth;
	private String gender;
	private String phone;
	private Date enrollDate;
	private int mlevel;
	private String status;
	
	// 2. 생성자
	// 기본 생성자
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 로그인 전용
	public Member(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	// 회원가입 전용
	public Member(String userId, String password, String userName, String email, Date dateOfBirth, String gender,
			String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
	}

	// 모든 정보용
	public Member(int userNo, String userId, String password, String userName, String email, Date dateOfBirth,
			String gender, String phone, Date enrollDate, int mlevel, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.mlevel = mlevel;
		this.status = status;
	}
	
	// 3. 메소드
	// toString()
	
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phone=" + phone
				+ ", enrollDate=" + enrollDate + ", mlevel=" + mlevel + ", status=" + status + "]";
	}

	// getter & setter
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getMlevel() {
		return mlevel;
	}

	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
