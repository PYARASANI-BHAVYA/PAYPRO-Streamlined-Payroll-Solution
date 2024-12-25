package com.payproapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "b_leave")
public class LeaveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_code", nullable = false)
    private int leaveCode;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "total_days", nullable = false)
    private int totalDays;

    // Getters and Setters
    public int getLeaveCode() {
        return leaveCode;
    }

    public void setLeaveCode(int leaveCode) {
        this.leaveCode = leaveCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
}


