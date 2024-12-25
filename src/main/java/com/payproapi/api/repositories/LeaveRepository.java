package com.payproapi.api.repositories;

import com.payproapi.api.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Integer> {

    // Find a leave by leaveCode
    LeaveEntity findByLeaveCode(int leaveCode);
}
