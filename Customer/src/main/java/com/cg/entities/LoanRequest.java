package com.cg.entities;
/**
-File Name          : LoanRequest
-Author Name        : Capgemini
-Description        : LoanRequest POJO 
-Creation Date		: 16/04/2021
*/

import java.util.Date;

public class LoanRequest  {
	

	
	private int requestid;
	private String loantype;
	private int custid;
	
	private String custname;
	private int age;
	private double income;
	private String address;
	
	private String adharno;
	
	private Date date;
	
	private String status;



	public LoanRequest() {
	
	}



	public LoanRequest(int requestid, String loantype, int custid, String custname, int age, double income,
			String address, String adharno, Date date, String status) {
		super();
		this.requestid = requestid;
		this.loantype = loantype;
		this.custid = custid;
		this.custname = custname;
		this.age = age;
		this.income = income;
		this.address = address;
		this.adharno = adharno;
		this.date = date;
		this.status = status;
	}



	public int getRequestid() {
		return requestid;
	}



	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}



	public String getLoantype() {
		return loantype;
	}



	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}



	public int getCustid() {
		return custid;
	}



	public void setCustid(int custid) {
		this.custid = custid;
	}



	public String getCustname() {
		return custname;
	}



	public void setCustname(String custname) {
		this.custname = custname;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getIncome() {
		return income;
	}



	public void setIncome(double income) {
		this.income = income;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getAdharno() {
		return adharno;
	}



	public void setAdharno(String adharno) {
		this.adharno = adharno;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "LoanRequest [requestid=" + requestid + ", loantype=" + loantype + ", custid=" + custid + ", custname="
				+ custname + ", age=" + age + ", income=" + income + ", address=" + address + ", adharno=" + adharno
				+ ", date=" + date + ", status=" + status + "]";
	}



	

}
