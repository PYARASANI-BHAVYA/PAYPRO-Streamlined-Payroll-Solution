package com.payproapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.payproapi.api.model.ApproverRequestBody;
import com.payproapi.api.model.AppIdRequest;
import com.payproapi.api.service.ApproverService;

@RestController
@CrossOrigin

public class ApproverController {

    @Autowired
    private ApproverService approverService;

    /**
     * Create a new Approver
     */
    @RequestMapping(value = "/createApprover", method = RequestMethod.POST)
    public ResponseEntity<?> createApprover(@RequestBody ApproverRequestBody approverReqBody) throws Exception {
        return ResponseEntity.ok(approverService.createApprover(approverReqBody));
    }


    /**
     * Update an existing Approver
     */
    @RequestMapping(value = "/updateApprover", method = RequestMethod.PUT)
    public ResponseEntity<?> updateApprover(@RequestBody ApproverRequestBody approverReqBody) throws Exception {
        return ResponseEntity.ok(approverService.updateApprover(approverReqBody));
    }

    /**
     * Read Approver by ID
     */
    @RequestMapping(value = "/readApprover", method = RequestMethod.GET)
    public ResponseEntity<?> readApproverById(@RequestParam int id) throws Exception {
        return ResponseEntity.ok(approverService.readApproverById(id));
    }
    

    /**
     * Delete an Approver by ID
     */
    @RequestMapping(value = "/deleteApprover", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteApprover(@RequestBody AppIdRequest approverIdRequest) throws Exception {
        return ResponseEntity.ok(approverService.deleteApproverById(approverIdRequest));
    }
}
