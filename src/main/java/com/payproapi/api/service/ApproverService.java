package com.payproapi.api.service;

import com.payproapi.api.entity.ApproverEntity;
import com.payproapi.api.model.AppIdRequest;
import com.payproapi.api.model.ApproverRequestBody;
import com.payproapi.api.repositories.ApproverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApproverService {

    @Autowired
    private ApproverRepository approverRepository;

    public ApproverEntity createApprover(ApproverRequestBody approverReqBody) {
        ApproverEntity approver = new ApproverEntity();
        approver.setEmployeeId(approverReqBody.getEmployeeId());
        approver.setFirstName(approverReqBody.getFirstName());
        approver.setLastName(approverReqBody.getLastName());
        approver.setDepartment(approverReqBody.getDepartment());
        approver.setManagerName(approverReqBody.getManagerName());
        return approverRepository.save(approver);
    }

    public ApproverEntity updateApprover(ApproverRequestBody approverReqBody) {
        ApproverEntity approver = approverRepository.findById(approverReqBody.getApproverId()).orElseThrow(
                () -> new RuntimeException("Approver not found"));
        approver.setEmployeeId(approverReqBody.getEmployeeId());
        approver.setFirstName(approverReqBody.getFirstName());
        approver.setLastName(approverReqBody.getLastName());
        approver.setDepartment(approverReqBody.getDepartment());
        approver.setManagerName(approverReqBody.getManagerName());
        return approverRepository.save(approver);
    }

    public ApproverEntity readApproverById(int id) {
        return approverRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Approver not found"));
    }
    

    public String deleteApproverById(AppIdRequest approverIdRequest) {
        int approverId = approverIdRequest.getApproverId();
        approverRepository.deleteById(approverId);
        return "Approver Deleted";
    }
}
