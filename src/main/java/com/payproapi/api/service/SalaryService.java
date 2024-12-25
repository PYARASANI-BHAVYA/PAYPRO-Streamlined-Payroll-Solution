package com.payproapi.api.service;

import com.payproapi.api.entity.SalaryEntity;
import com.payproapi.api.model.SalaryIdRequest;
import com.payproapi.api.model.SalaryRequestBody;
import com.payproapi.api.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    // Create Salary
    public SalaryEntity createSalary(SalaryRequestBody salaryRequest) {
        SalaryEntity salary = new SalaryEntity();
        salary.setEmpId(salaryRequest.getEmpId());
        salary.setSalaryAmount(salaryRequest.getSalaryAmount());
        salary.setPaymentDate(salaryRequest.getPaymentDate());
        return salaryRepository.save(salary);
    }

    // Get Salary by ID
    public SalaryEntity getSalaryById(int salaryId) {
        return salaryRepository.findById(salaryId).orElse(null);
    }

    // Update Salary
    public SalaryEntity updateSalary(SalaryRequestBody salaryRequest, int salaryId) {
        SalaryEntity salary = salaryRepository.findById(salaryId).orElse(null);
        if (salary != null) {
            salary.setEmpId(salaryRequest.getEmpId());
            salary.setSalaryAmount(salaryRequest.getSalaryAmount());
            salary.setPaymentDate(salaryRequest.getPaymentDate());
            return salaryRepository.save(salary);
        }
        return null;
    }

    // Delete Salary
    public void deleteSalary(int salaryId) {
        salaryRepository.deleteById(salaryId);
    }
}
