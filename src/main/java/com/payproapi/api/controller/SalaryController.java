package com.payproapi.api.controller;

import com.payproapi.api.model.SalaryRequestBody;
import com.payproapi.api.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // Create Salary
    @RequestMapping(value = "/createSalary", method = RequestMethod.POST)
    public ResponseEntity<?> createSalary(@RequestBody SalaryRequestBody salaryRequest) {
        return ResponseEntity.ok(salaryService.createSalary(salaryRequest));
    }

    // Get Salary by ID
    @RequestMapping(value = "/getSalary/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSalaryById(@PathVariable int id) {
        return ResponseEntity.ok(salaryService.getSalaryById(id));
    }

    // Update Salary
    @RequestMapping(value = "/updateSalary/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSalary(@RequestBody SalaryRequestBody salaryRequest, @PathVariable int id) {
        return ResponseEntity.ok(salaryService.updateSalary(salaryRequest, id));
    }

    // Delete Salary
    @RequestMapping(value = "/deleteSalary/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSalary(@PathVariable int id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.ok("Salary deleted successfully");
    }
}
