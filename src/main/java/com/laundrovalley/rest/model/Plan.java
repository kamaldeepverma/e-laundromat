package com.laundrovalley.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="plan")
public class Plan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private int amount;
	@NotNull
	private String type;
	
	@NotNull
	@Column
	private int washes;
	
	@NotNull
	@Column
	private String description;
	
	public int getWashes() {
		return washes;
	}

	public void setWashes(int washes) {
		this.washes = washes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Plan(){}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", amount=" + amount + ", type=" + type + "]";
	}

	public Plan(int id, int amount, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.type = type;
	}
	
	
}
