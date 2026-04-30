package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.LeaveApplication;
import com.Repository.LeaveRepository;

@Service
public class LeaveService {

	 @Autowired
	 LeaveRepository lrepo;
	 
	 public String applyleave(LeaveApplication leave) {
		 leave.setStatus("pending");
		 lrepo.save(leave);
		 return "Leave Applied Successfully";
	 }
	 
	
	 
	 public List<LeaveApplication>getall(){
		 return lrepo.findAll();
	 }
	 
	 
	public List<LeaveApplication>findleavebyempid(int empid){
		return lrepo.findByEmployee_empid(empid);
	}
	
	public String cancelleave(int id) {
		lrepo.deleteById(id);
		return "Leave Cancell..";
	}
	
	
	public String updateleavedetails(int id ,LeaveApplication leave) {
	       LeaveApplication  existingleave=lrepo.findById(id).orElse(null);
	       if(existingleave==null) {
	    	   return "No Reocrd Found Four Given id";
	       }
	       
	       if(leave.getFormdate()==null&&leave.getTodate()==null&&leave.getReason()==null) {
	    	   return "No Record Provided Four User";
	       }
	       
	       if(leave.getFormdate()!=null) {
	    	   existingleave.setFormdate(leave.getFormdate());
	       }
	       
	       if(leave.getTodate()!=null) {
	    	   existingleave.setTodate(leave.getTodate());
	       }
	       
	       if(leave.getReason()!=null) {
	    	   existingleave.setReason(leave.getReason());
	       }
	       
	       lrepo.save(existingleave);
	       return "Leave Details Updated Successfully...";
	   }    //leave status update code
	
	
	       public String leavestatusupdate(int id ,String status) {
	    	      LeaveApplication existing= lrepo.findById(id).orElse(null);
	    	      if(existing==null) {
	    	    	  return "no record found for given id";
	    	      }
	    	      
	    	      existing.setStatus(status);
	    	      lrepo.save(existing);
	    	      return "Leave Status Updaed Successfully";
	       
	}
	
}

