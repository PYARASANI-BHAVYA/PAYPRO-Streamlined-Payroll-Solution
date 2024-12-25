package com.payproapi.api.controller;

import com.payproapi.api.model.PayslipRequestBody;
import com.payproapi.api.model.PayslipIdRequest;
import com.payproapi.api.service.PayslipService;
import com.payproapi.api.entity.PayslipEntity;  // Make sure to import the PayslipEntity
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    // Create Payslip
    @RequestMapping(value = "/createPayslip", method = RequestMethod.POST)
    public ResponseEntity<?> createPayslip(@RequestBody PayslipRequestBody payslipRequest) {
        return ResponseEntity.ok(payslipService.createPayslip(payslipRequest));
    }

    // Get Payslip by ID (using PathVariable)
    @RequestMapping(value = "/getPayslip/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPayslipById(@PathVariable("id") int payslipId) {
        PayslipEntity payslip = payslipService.getPayslipById(payslipId);
        return payslip != null ? ResponseEntity.ok(payslip) : ResponseEntity.notFound().build();
    }

    // Update Payslip
    @RequestMapping(value = "/updatePayslip/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePayslip(@RequestBody PayslipRequestBody payslipRequest, @PathVariable("id") int id) {
        PayslipEntity updatedPayslip = payslipService.updatePayslip(payslipRequest, id);
        return updatedPayslip != null ? ResponseEntity.ok(updatedPayslip) : ResponseEntity.notFound().build();
    }

    // Delete Payslip
    @RequestMapping(value = "/deletePayslip", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePayslip(@RequestBody PayslipIdRequest payslipIdRequest) {
        payslipService.deletePayslip(payslipIdRequest.getPayslipId());
        return ResponseEntity.ok("Payslip deleted successfully");
    }

    // Get All Payslips
    @RequestMapping(value = "/getAllPayslips", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPayslips() {
        return ResponseEntity.ok(payslipService.getAllPayslips());
    }
    
}
