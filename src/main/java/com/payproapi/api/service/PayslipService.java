package com.payproapi.api.service;

import com.payproapi.api.entity.PayslipEntity;
import com.payproapi.api.model.PayslipRequestBody;
import com.payproapi.api.repositories.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    // Create Payslip
    public PayslipEntity createPayslip(PayslipRequestBody requestBody) {
        PayslipEntity payslip = new PayslipEntity();
        payslip.setEmpId(requestBody.getEmpId());

        // Convert LocalDate to java.sql.Date
        Date payPeriod = Date.valueOf(requestBody.getPayPeriod());  // Direct conversion from LocalDate
        payslip.setPayPeriod(payPeriod);

        payslip.setNetSalary(requestBody.getNetSalary());
        payslip.setGeneratedDate(new Timestamp(System.currentTimeMillis()));

        return payslipRepository.save(payslip);
    }

    // Update Payslip
    public PayslipEntity updatePayslip(PayslipRequestBody requestBody, int id) {
        PayslipEntity payslip = payslipRepository.findById(id).orElse(null);
        if (payslip != null) {
            payslip.setEmpId(requestBody.getEmpId());

            // Convert LocalDate to java.sql.Date
            Date payPeriod = Date.valueOf(requestBody.getPayPeriod());  // Direct conversion from LocalDate
            payslip.setPayPeriod(payPeriod);

            payslip.setNetSalary(requestBody.getNetSalary());
            payslip.setGeneratedDate(new Timestamp(System.currentTimeMillis()));

            return payslipRepository.save(payslip);
        }
        return null;
    }

    // Get Payslip by ID (updated to use int id directly)
    public PayslipEntity getPayslipById(int id) {
        return payslipRepository.findById(id).orElse(null);
    }

    // Get All Payslips
    public Iterable<PayslipEntity> getAllPayslips() {
        return payslipRepository.findAll();
    }

    // Delete Payslip
    public String deletePayslip(int id) {
        payslipRepository.deleteById(id);
        return "Payslip deleted successfully.";
    }
}
