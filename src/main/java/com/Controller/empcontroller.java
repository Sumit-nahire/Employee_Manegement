package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.employee;
import com.service.service;

@RestController
@CrossOrigin
public class empcontroller {
	@Autowired
	service serv;
	@PostMapping("/addemprecord")
	public String save(@RequestBody employee e) {
		return serv.save(e);
	}
	@GetMapping("/retriverecord")
	public List<employee> findallemployee(){
		return serv.findallemployee();
	}
	@GetMapping("/findbyid")
	public employee findById(@RequestParam int empid) {
		return serv.findbyempid(empid);
	}
	@DeleteMapping("/deleteempid")
	public String deleteByEmpid(@RequestParam int empid) {
		return serv.deleteByEmpid(empid);
	}
		
	
	@PutMapping("/updateemprecord")
	public String updateempid(@RequestParam int empid,@RequestBody employee newemp) {
		return serv.updateempid(empid, newemp);
	}
	@GetMapping("/findByFirstname")
	public List<employee> findByFirstname(@RequestParam String firstname){
		return serv.findByFirstname(firstname);
	}
	@GetMapping("/findByLastname")
	public List<employee> findByLastname(@RequestParam String lastname){
		return serv.findByLastname(lastname);
	}
	@GetMapping("/findByDepartment")
	public List<employee> findByDepartment(@RequestParam String department){
		return serv.findByDepartment(department);
	}
	@GetMapping("/findByDesignation")
	public List<employee> findByDesignation( @RequestParam String designation){
		return serv.findByDesignation(designation);
	}

}