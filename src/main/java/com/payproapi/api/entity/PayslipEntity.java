package com.payproapi.api.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "b_payslip")
public class PayslipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payslip_id", nullable = false)
    private int payslipId;

    @Column(name = "emp_id", nullable = false)
    private int empId;

    @Column(name = "pay_period", nullable = false)
    private Date payPeriod;

    @Column(name = "net_salary", nullable = false)
    private double netSalary;

    @Column(name = "generated_date", nullable = false)
    private Timestamp generatedDate;

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

    public Date getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(Date payPeriod) {
        this.payPeriod = payPeriod;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public Timestamp getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Timestamp generatedDate) {
        this.generatedDate = generatedDate;
    }
}
