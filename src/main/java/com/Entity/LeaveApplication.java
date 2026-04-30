package com.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LeaveApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String firstname;
	String lastname;
	String reason;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate formdate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate todate;
	String status="pending";
	
	@ManyToOne
	@JoinColumn(name="empid")

	 @JsonIgnoreProperties("leaves")
	employee employee;
	
	
	public LeaveApplication() {
		super();
	}

	public LeaveApplication(Integer id, String firstname, String lastname, String reason, LocalDate formdate,
			LocalDate todate, String status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.reason = reason;
		this.formdate = formdate;
		this.todate = todate;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getFormdate() {
		return formdate;
	}

	public void setFormdate(LocalDate formdate) {
		this.formdate = formdate;
	}

	public LocalDate getTodate() {
		return todate;
	}

	public void setTodate(LocalDate todate) {
		this.todate = todate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public employee getEmployee() {
		return employee;
	}

	public void setEmployee(employee employee) {
		this.employee = employee;
	}

	
	
}
