package com.payproapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payproapi.api.entity.ApproverEntity;

@Repository
public interface ApproverRepository extends CrudRepository<ApproverEntity, Integer> {

    // Returns paginated list of approvers
    @Query(value = "SELECT * FROM b_approver", nativeQuery = true)
    Page<ApproverEntity> listAllApprovers(Pageable pageable);

    // Returns the count of approvers
    @Query(value = "SELECT count(*) FROM b_approver", nativeQuery = true)
    Long countNumberOfApprovers();
}
