package com.example.obj;

public class Employee {
	
	private int eid;
	private String fname;
	private String lname;
	private int positionType;
	
	
	
	
	public String convertPositionToName() {
		
		
			
		if(positionType==1) {
			
			return "DIRECT SUPERVISOR";
		}
         else if(positionType==2) {
			
			return "DIRECT HEAD";
		}else if(positionType==3) {
			
			return "BENCO";
		}
		return "EMPLOYEE";
		
		
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getPositionType() {
		return positionType;
	}
	public void setPositionType(int positionType) {
		this.positionType = positionType;
	}
	
	
	

}
