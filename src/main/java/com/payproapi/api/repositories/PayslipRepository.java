package com.payproapi.api.repositories;

import com.payproapi.api.entity.PayslipEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipRepository extends PagingAndSortingRepository<PayslipEntity, Integer> {

    // Custom query to list all payslips with pagination
    @Query(value = "SELECT * FROM b_payslip", countQuery = "SELECT COUNT(*) FROM b_payslip", nativeQuery = true)
    Page<PayslipEntity> listAllPayslips(Pageable pageable);

    // Custom query to count total number of payslips
    @Query(value = "SELECT COUNT(*) FROM b_payslip", nativeQuery = true)
    long countPayslips();  // Changed return type to long for accuracy
}
