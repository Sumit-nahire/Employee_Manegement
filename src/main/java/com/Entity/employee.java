package com.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="EmployeeProject")
@Entity
public class employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int empid;
	String firstname;
	String lastname;
	String department;
	double salary;
	String email;
	long contactno;
	LocalDate joiningdate;    // yy/mm/dd
	LocalDate dob;
	String designation;
	int exp;
	String address;
	String gender;
	String status;
	String profile;
	String reportingmanager;
	long adharcardno;
	String panno;
	
 @OneToMany(mappedBy="employee",cascade=CascadeType.ALL,orphanRemoval=true)	

 @JsonIgnoreProperties("employee")
 List<LeaveApplication>leaves=new ArrayList<>();
	
	
	public employee() {
		super();
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public LocalDate getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(LocalDate joiningdate) {
		this.joiningdate = joiningdate;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getReportingmanager() {
		return reportingmanager;
	}
	public void setReportingmanager(String reportingmanager) {
		this.reportingmanager = reportingmanager;
	}
	public long getAdharcardno() {
		return adharcardno;
	}
	public void setAdharcardno(long adharcardno) {
		this.adharcardno = adharcardno;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public List<LeaveApplication> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<LeaveApplication> leaves) {
		this.leaves = leaves;
	}
	
	

}