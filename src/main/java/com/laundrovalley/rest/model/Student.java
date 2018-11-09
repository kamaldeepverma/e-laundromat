package com.laundrovalley.rest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="stud_main")
@EntityListeners(AuditingEntityListener.class)
public class Student extends User{
	
	@NotBlank
	private String hostel;
	
	
	@Column(name="room_no")
	private int roomNo;
	
	@NotBlank
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
	

}
