package com.laundrovalley.rest.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="subsciption")
public class Subscription {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private int amount;
	@NotNull
	private Date expiry;
	@NotNull
	@Column(name="stud_id")
	private String studentId;
	@NotNull
	@Column(name="plan_id")
	private int planId;
	@NotNull
	@Column
	private int washes;
	@Column
	@NotNull
	@ColumnDefault(value="false")
	private boolean status;

	
	
	

	public Subscription() {}





	public Subscription(int id, @NotNull int amount, @NotNull Date expiry, @NotNull String studentId,
			@NotNull int planId, @NotNull int washes, @NotNull boolean status) {
		super();
		this.id = id;
		this.amount = amount;
		this.expiry = expiry;
		this.studentId = studentId;
		this.planId = planId;
		this.washes = washes;
		this.status = status;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getAmount() {
		return amount;
	}





	public void setAmount(int amount) {
		this.amount = amount;
	}





	public Date getExpiry() {
		return expiry;
	}





	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}





	public String getStudentId() {
		return studentId;
	}





	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}





	public int getPlanId() {
		return planId;
	}





	public void setPlanId(int planId) {
		this.planId = planId;
	}





	public int getWashes() {
		return washes;
	}





	public void setWashes(int washes) {
		this.washes = washes;
	}





	public boolean isStatus() {
		return status;
	}





	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
