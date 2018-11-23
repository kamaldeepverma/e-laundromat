package com.laundrovalley.rest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="stud_main")
@EntityListeners(AuditingEntityListener.class)
public class Student extends User{
	
	
	@NotNull
	private String hostel;
	
	
	@Column(name="room_no")
	private int roomNo;
	
	@NotNull
	private String session;
	
	
	private int status;
	
	

	
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}	

	public String getHostel() {
		return hostel;
	}

	public void setHostel(String hostel) {
		this.hostel = hostel;
	}

	@Override
	public String toString() {
		return "Student [hostel=" + hostel + ", roomNo=" + roomNo + ", session=" + session + ", status=" + status + "]";
	}
	

}
