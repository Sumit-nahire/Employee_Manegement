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

import com.Entity.LeaveApplication;
import com.service.LeaveService;

@RestController
@CrossOrigin
public class LeaveController {

	@Autowired
	LeaveService lserv;
	
	@PostMapping("/applyleave")
	public String applayforleave(@RequestBody LeaveApplication leave) {
		return lserv.applyleave(leave);
	}
	
	@GetMapping("/getallleave")
	public List<LeaveApplication>findleave(){
		return lserv.getall();
	}
	
	@GetMapping("/findleavebyempid")
	public List<LeaveApplication>findleavebyempid(@RequestParam int empid){
		return lserv.findleavebyempid(empid);
	}
	
	@DeleteMapping("/cancel")
	public String cancelleave(@RequestParam int id) {
		return lserv.cancelleave(id);
	}
	
	@PutMapping("/update")
	public String updateleavedetails(@RequestParam int id,
			            @RequestBody LeaveApplication leave) {
	  	return lserv.updateleavedetails(id, leave);
	}
	
	@PutMapping("/statusupdate")
	public String updatestatus(@RequestParam int id,@RequestParam String status) {
		return lserv.leavestatusupdate(id, status);
	}
	
}
