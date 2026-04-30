package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.employee;

public interface Repository extends JpaRepository<employee, Integer>{

	public List<employee>findByFirstname(String firstname);
	public List<employee>findByLastname(String firstlast);
	public List<employee>findByDepartment(String department);
	public List<employee>findByDesignation(String designation);	
}