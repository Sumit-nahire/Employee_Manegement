package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Entity.employee;
import com.Repository.Repository;

@Service
public class BirthdaySheduale {

    @Autowired
    private Repository employeeRepository;

    @Autowired
    private EmailService emailService;

    // Runs every day at 8 AM
    //@Scheduled(cron = "0 */1 * * * ?")
    @Scheduled(cron = "0 */1 * * * ?")
    public void sendBirthdayEmails() {
        LocalDate today = LocalDate.now();
        List<employee> employees = employeeRepository.findAll();

        for (employee emp : employees) {
            if (emp.getDob() != null &&
                emp.getDob().getMonth() == today.getMonth() &&
                emp.getDob().getDayOfMonth() == today.getDayOfMonth()) {

                emailService.sendBirthdayEmail(emp.getEmail(), emp.getFirstname());
            }
        }
    }
}