package com.laundrovalley.rest.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="wash")

public class Wash {
	
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int washid;
@NotNull
private String studentId;
@NotNull
private Date deliveryDate;
@NotNull
private int quanitity;
@NotNull
//@Max(value=5)
private String status;
@NotNull
private Date scheduledDate;
public int getWashid() {
	return washid;
}
public void setWashid(int washid) {
	this.washid = washid;
}
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public Date getDeliveryDate() {
	return deliveryDate;
}
public void setDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
}
public int getQuanitity() {
	return quanitity;
}
public void setQuanitity(int quanitity) {
	this.quanitity = quanitity;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getScheduledDate() {
	return scheduledDate;
}
public void setScheduledDate(Date scheduledDate) {
	this.scheduledDate = scheduledDate;
}
public Wash(int washid, @NotNull String studentId, @NotNull Date deliveryDate, @NotNull int quanitity,
		@NotNull @Max(5) String status, @NotNull Date scheduledDate) {
	super();
	this.washid = washid;
	this.studentId = studentId;
	this.deliveryDate = deliveryDate;
	this.quanitity = quanitity;
	this.status = status;
	this.scheduledDate = scheduledDate;
}

public Wash() {}
@Override
public String toString() {
	return "Wash [washid=" + washid + ", studentId=" + studentId + ", deliveryDate=" + deliveryDate + ", quanitity="
			+ quanitity + ", status=" + status + ", scheduledDate=" + scheduledDate + "]";
}



}
