package com.laundrovalley.rest.repository;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.laundrovalley.rest.model.Wash;

public interface WashRepository extends JpaRepository<Wash, Integer>{
	
	@Query("from Wash where studentId=?1 and status!='completed'")
	public Wash getWash(String studentId);
	
	@Query("from Wash where status!='completed'")
	public ArrayList<Wash> getWashes();

	@Query("from Wash where scheduledDate=?1 and status!='completed'")
	public List<Wash> findWashesByDate(Date scheduledDate);

	
	@Modifying
	@Query("update Wash set status=?2 where washid=?1")
	public int updateStatus(int washId,String status);

}
