package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.employee;
import com.Repository.Repository;



@Service
public class service {
	@Autowired
     Repository repo;
	public String save(employee e) {
		repo.save(e);
		return "Employee record added successfully";
	}
	public List<employee> findallemployee(){
		return repo.findAll();
	}
	public employee findbyempid(int empid) {
		return repo.findById(empid) .orElse(null);
	}
	public String deleteByEmpid(int empid) {
		    employee existingemp= repo.findById(empid) .orElse(null);
		    if(existingemp==null) {
		    	return "No matching record found for given id";
		    }else {
		    	repo.deleteById(empid);
		    	return "Employee record deleted successfully";
		    }
	}
	public String updateempid(int empid, employee newemp) {
		employee existingrecord=repo.findById(empid) .orElse(null);
		if(existingrecord==null) {
			return "No record found for given empid";
		}
		if(newemp.getFirstname()==null && newemp.getLastname()==null && newemp.getDepartment()==null &&newemp.getSalary()==0
				&& newemp.getEmail()==null && newemp.getContactno()==0 && newemp.getJoiningdate()==null && newemp.getDob()==null && newemp.getDesignation()==null
				&& newemp.getExp()==0 && newemp.getAddress()==null && newemp.getGender()==null && newemp.getStatus()==null && newemp.getProfile()==null && newemp.getReportingmanager()==null
				&& newemp.getAdharcardno()==0) {
			return "No record found for the updation";
		}
		if(newemp.getFirstname()!=null) {
			existingrecord.setFirstname(newemp.getFirstname());
		}
		if(newemp.getLastname()!=null) {
			existingrecord.setLastname(newemp.getLastname());
		}
		if(newemp.getDepartment()!=null) {
			existingrecord.setDepartment(newemp.getDepartment());
		}
		if(newemp.getSalary()!=0) {
			existingrecord.setSalary(newemp.getSalary());
		}
		if(newemp.getEmail()!=null) {
			existingrecord.setEmail(newemp.getEmail());
		}
		if(newemp.getContactno()!=0) {
			existingrecord.setContactno(newemp.getContactno());
		}
		if(newemp.getJoiningdate()!=null) {
			existingrecord.setJoiningdate(newemp.getJoiningdate());
		}
		if(newemp.getDob()!=null) {
			existingrecord.setDob(newemp.getDob());
		}
		if(newemp.getDesignation()!=null) {
			existingrecord.setDesignation(newemp.getDesignation());
		}
		if(newemp.getExp()!=0) {
			existingrecord.setExp(newemp.getExp());
		}
		if(newemp.getAddress()!=null) {
			existingrecord.setAddress(newemp.getAddress());
		}
		if(newemp.getGender()!=null) {
			existingrecord.setGender(newemp.getGender());
		}
		if(newemp.getStatus()!=null) {
			existingrecord.setStatus(newemp.getStatus());
		}
		if(newemp.getProfile()!=null) {
			existingrecord.setProfile(newemp.getProfile());
		}
		if(newemp.getReportingmanager()!=null) {
			existingrecord.setReportingmanager(newemp.getReportingmanager());
		}
		if(newemp.getAdharcardno()!=0) {
			existingrecord.setAdharcardno(newemp.getAdharcardno());
		}
		if(newemp.getPanno()!=null) {
			existingrecord.setPanno(newemp.getPanno());
		}
		repo.save(existingrecord);
		return "Employee record updated successfully";
	}
	
	
		public List<employee> findByFirstname(String firstname){
			return repo.findByFirstname(firstname);
		}
		public List<employee> findByLastname(String lastname){
			return repo.findByLastname(lastname);
		}
		public List<employee> findByDepartment(String department){
			return repo.findByDepartment(department);
		}
		public List<employee> findByDesignation(String designation){
			return repo.findByDesignation(designation);
		}
	
	
}