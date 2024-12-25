package com.payproapi.api.model;

public class LeaveRequestBody {

    private int leaveCode;    // Leave ID (used for update, delete operations)
    private String type;      // Type of leave (e.g., Sick Leave, Annual Leave)
    private String description; // Description of the leave
    private int totalDays;    // Total days available for this leave type

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
