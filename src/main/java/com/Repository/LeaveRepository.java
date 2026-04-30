package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Entity.LeaveApplication;

public interface LeaveRepository extends JpaRepository <LeaveApplication,Integer> {

	//@Query(value="select * from leaveapplication l where l.empid=:empid",nativeQuery=true)
	public List<LeaveApplication>findByEmployee_empid(int empid);
		
}
