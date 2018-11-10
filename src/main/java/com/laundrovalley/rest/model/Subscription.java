package com.laundrovalley.rest.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	public Subscription() {}
	public Subscription(int sid, @NotNull int amount, @NotNull Date expiry, @NotNull String studentId,
			@NotNull int planId) {
		super();
		this.id = sid;
		this.amount = amount;
		this.expiry = expiry;
		this.studentId = studentId;
		this.planId = planId;
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
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", amount=" + amount + ", expiry=" + expiry + ", studentId=" + studentId
				+ ", planId=" + planId + "]";
	}
	
	
}
