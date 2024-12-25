package com.payproapi.api.model;

import java.time.LocalDate;

public class PayslipRequestBody {

    private int payslipId;
    private int empId;
    private LocalDate payPeriod;  // Changed to LocalDate for better modern Java handling
    private double netSalary;

    // Default constructor
    public PayslipRequestBody() {}

    // Constructor with parameters for easier object creation
    public PayslipRequestBody(int payslipId, int empId, LocalDate payPeriod, double netSalary) {
        this.payslipId = payslipId;
        this.empId = empId;
        this.payPeriod = payPeriod;
        this.netSalary = netSalary;
    }

    // Getters and Setters
    public int getPayslipId() {
        return payslipId;
    }

    public void setPayslipId(int payslipId) {
        this.payslipId = payslipId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public LocalDate getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(LocalDate payPeriod) {
        this.payPeriod = payPeriod;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
