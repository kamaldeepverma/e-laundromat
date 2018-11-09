package com.laundrovalley.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="staff_main")
@EntityListeners(AuditingEntityListener.class)
public class Staff extends User{
	
	@Transient
	private List<Integer> washes = new ArrayList<Integer>();

	public List<Integer> getWashes() {
		return washes;
	}

	public void setWashes(List<Integer> washes) {
		this.washes = washes;
	}
	
	public void addWash(Integer washId) {
		washes.add(washId);
	}
	
	public void removeWash(Integer washId) {
		washes.remove(washId);
	}

}
