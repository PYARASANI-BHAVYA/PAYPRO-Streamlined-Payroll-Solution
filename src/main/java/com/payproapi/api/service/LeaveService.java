package com.payproapi.api.service;

import com.payproapi.api.entity.LeaveEntity;
import com.payproapi.api.model.LeaveRequestBody;
import com.payproapi.api.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    // Create a new leave type
    public LeaveEntity createLeave(LeaveRequestBody leaveRequestBody) {
        LeaveEntity leaveEntity = new LeaveEntity();
        leaveEntity.setType(leaveRequestBody.getType());
        leaveEntity.setDescription(leaveRequestBody.getDescription());
        leaveEntity.setTotalDays(leaveRequestBody.getTotalDays());
        return leaveRepository.save(leaveEntity);
    }

    // Update an existing leave type
    public LeaveEntity updateLeave(LeaveRequestBody leaveRequestBody) {
        Optional<LeaveEntity> existingLeave = leaveRepository.findById(leaveRequestBody.getLeaveCode());
        if (existingLeave.isPresent()) {
            LeaveEntity leaveEntity = existingLeave.get();
            leaveEntity.setType(leaveRequestBody.getType());
            leaveEntity.setDescription(leaveRequestBody.getDescription());
            leaveEntity.setTotalDays(leaveRequestBody.getTotalDays());
            return leaveRepository.save(leaveEntity);
        }
        return null;
    }

    // Get leave by ID
    public LeaveEntity getLeaveById(int leaveCode) {
        return leaveRepository.findByLeaveCode(leaveCode);
    }

    // Delete a leave type by leaveCode
    public String deleteLeave(int leaveCode) {
        leaveRepository.deleteById(leaveCode);
        return "Leave type deleted successfully";
    }

    // List all leave types
    public List<LeaveEntity> listAllLeaves() {
        return leaveRepository.findAll();
    }
}
