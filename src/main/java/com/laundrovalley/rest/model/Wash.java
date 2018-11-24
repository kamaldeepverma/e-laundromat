package com.laundrovalley.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wash")
public class Wash {
	
	/*
	id	int(10)	NO	PRI	
status	varchar(5)	NO		
schtime	datetime	NO		
dlvtime	datetime	NO		
qty	int(11)	NO		
studentid	varchar(13)	NO	MUL	
washid	int(11)	NO		
stud_id	int(11)	YES		
	*/
@Id
@Column(name="washid")
private int washid;
@Column(name="stud_id")
private String studentId;

public int getWashid() {
	return washid;
}

public void setWashid(int washid) {
	this.washid = washid;
}




}
