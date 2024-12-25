package com.payproapi.api.controller;

import com.payproapi.api.model.LeaveIdRequest;
import com.payproapi.api.model.LeaveRequestBody;
import com.payproapi.api.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController   
@CrossOrigin 
public class LeaveController {

    @Autowired
    private LeaveService leaveService;
    
    // Create a new leave type
    @RequestMapping(value = "/createLeave", method = RequestMethod.POST)
    public ResponseEntity<?> createLeave(@RequestBody LeaveRequestBody leaveRequestBody) throws Exception {
        return ResponseEntity.ok(leaveService.createLeave(leaveRequestBody));
    }

    // Update an existing leave type
    @RequestMapping(value = "/updateLeave", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLeave(@RequestBody LeaveRequestBody leaveRequestBody) throws Exception {
        return ResponseEntity.ok(leaveService.updateLeave(leaveRequestBody));
    }

    // Get leave details by ID
    @RequestMapping(value = "/readLeave/{leaveCode}", method = RequestMethod.GET)
    public ResponseEntity<?> readLeaveById(@PathVariable int leaveCode) throws Exception {
        return ResponseEntity.ok(leaveService.getLeaveById(leaveCode));
    }

    // Delete a leave type
    @RequestMapping(value = "/deleteLeave/{leaveCode}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLeave(@PathVariable int leaveCode) throws Exception {
        return ResponseEntity.ok(leaveService.deleteLeave(leaveCode));
    }

    // Get all leave types
    @RequestMapping(value = "/listAllLeaves", method = RequestMethod.GET)
    public ResponseEntity<?> listAllLeaves() throws Exception {
        return ResponseEntity.ok(leaveService.listAllLeaves());
    }
}
